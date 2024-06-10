package AcademicStaffManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * implementation of academic staff management service
 *
 */
@WebService(endpointInterface = "AcademicStaffManagement.AcademicStaffManagement")
public class AcademicStaffManagmentImpl implements AcademicStaffManagement {

	private final static String path = "/Users/danielmason/eclipse-workspace-sop/AcademicStaffService/UserStorageAcStaff.xml";

	/**
	 * registers an {@link AcademicStaff} to the {@link UserStorageAcStaff}
	 */
	public void registerUser(AcademicStaff academicStaff) throws FileNotFoundException, JAXBException {

		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageAcStaff.class);
		UserStorageAcStaff userStorageAcStaff = getUserStorageAcStaff(jAXBContext);

		userStorageAcStaff.addUser(academicStaff);

		OutputStream outputStream = new FileOutputStream(path);
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal(userStorageAcStaff, outputStream);
	}

	/**
	 * checks an {@link AcademicStaff} is contained in {@link UserStorageAcStaff}
	 */
	public boolean isRegistered(AcademicStaff user) throws FileNotFoundException, JAXBException {
		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageAcStaff.class);
		UserStorageAcStaff userStorageAcStaff = getUserStorageAcStaff(jAXBContext);
		if (userStorageAcStaff == null) {
			return false;
		}

		AcademicStaff[] registeredUsers = userStorageAcStaff.getUsers();
		for (int i = 0; i < registeredUsers.length; i++) {
			if (user == registeredUsers[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * assigns an {@link AcStaffModule} to an {@link AcademicStaff}
	 */
	public boolean assignModule(AcademicStaff user, AcStaffModule module) throws FileNotFoundException, JAXBException {
		if (module == null) {
			return false;
		}
		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageAcStaff.class);
		UserStorageAcStaff userStorageAcStaff = getUserStorageAcStaff(jAXBContext);
		if (userStorageAcStaff == null) {
			return false;
		}

		AcademicStaff[] users = userStorageAcStaff.getUsers();
		for (int i = 0; i < users.length; i++) {
			if (users[i] == user) {
				users[i].assignModule(module);
				OutputStream outputStream = new FileOutputStream(path);
				Marshaller marshaller = jAXBContext.createMarshaller();
				marshaller.marshal(userStorageAcStaff, outputStream);
				return true;
			}
		}
		return false;
	}

	/**
	 * returns an {@link AcademicStaff} stored in {@link UserStorageAcStaff} using their ID
	 */
	public AcademicStaff getUser(int academicStaffId) throws JAXBException, FileNotFoundException {

		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageAcStaff.class);
		UserStorageAcStaff userStorageAcStaff = getUserStorageAcStaff(jAXBContext);

		for (AcademicStaff s : userStorageAcStaff.getUsers()) {
			if (s.getId() == academicStaffId)
				return s;
		}
		return null;
	}

	/**
	 * Un-serialized the xml for storing {@link AcademicStaff}
	 * @param ctx
	 * @return
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 */
	private UserStorageAcStaff getUserStorageAcStaff(JAXBContext ctx) throws FileNotFoundException, JAXBException {
		UserStorageAcStaff academicStaffStorage = null;

		if (!new java.io.File(path).exists()) {
			academicStaffStorage = new UserStorageAcStaff();
		} else {
			InputStream inputStream = new FileInputStream(path);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			academicStaffStorage = (UserStorageAcStaff) unmarshaller.unmarshal(inputStream);
		}

		return academicStaffStorage;
	}

}
