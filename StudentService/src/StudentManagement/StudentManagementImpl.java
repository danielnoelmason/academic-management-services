package StudentManagement;

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
 * implementation of student services interface
 *
 */
@WebService(endpointInterface = "StudentManagement.StudentManagement")
public class StudentManagementImpl implements StudentManagement {

	private final static String path = "/Users/danielmason/eclipse-workspace-sop/StudentService/UserStorageStudent.xml";

	/**
	 * registers a {@link Student} to the {@link UserStorageStudent}
	 */
	public void registerUser(Student user) throws FileNotFoundException, JAXBException {

		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageStudent.class);
		UserStorageStudent studentStorage = getUserStorageStudent(jAXBContext);

		studentStorage.addUser(user);

		OutputStream outputStream = new FileOutputStream(path);
		Marshaller marshaller = jAXBContext.createMarshaller();
		marshaller.marshal(studentStorage, outputStream);
	}

	/**
	 * adds a {@link StudentModule} to a students enrolled modules
	 */
	public void enrollStudent(Student user, StudentModule module) throws FileNotFoundException, JAXBException {
		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageStudent.class);
		UserStorageStudent studentStorage = getUserStorageStudent(jAXBContext);

		for (Student s : studentStorage.getUsers())
			if (s == user) {
				s.enroll(module);
				OutputStream outputStream = new FileOutputStream(path);
				Marshaller marshaller = jAXBContext.createMarshaller();
				marshaller.marshal(studentStorage, outputStream);
			}
	}

	/**
	 * checks a student is registered in {@link UserStorageStudent}
	 */
	public boolean isRegistered(Student student) throws FileNotFoundException, JAXBException {
		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageStudent.class);
		UserStorageStudent studentStorage = getUserStorageStudent(jAXBContext);
		if (studentStorage == null) {
			return false;
		}

		for (Student s : studentStorage.getUsers()) {
			if (s == student) {
				return true;
			}
		}
		return false;
	}

	/**
	 * checks if a student is enrolled in a module
	 */
	public boolean isEnrolled(Student student, 	ModuleCode mc) throws FileNotFoundException, JAXBException {
		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageStudent.class);
		UserStorageStudent studentStorage = getUserStorageStudent(jAXBContext);
		if (studentStorage == null) {
			return false;
		}

		for (Student s : studentStorage.getUsers()) {
			if (s == student) {
				for (StudentModule k :s.getEnrolledModules()) {
					if(k.getModuleCode()==mc) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * inserts a {@link Mark} into {@link StudentModule} for a {@link Student}
	 */
	public boolean insertMark(Student user, ModuleCode mc, Mark mark)
			throws FileNotFoundException, JAXBException {
		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageStudent.class);
		UserStorageStudent studentStorage = getUserStorageStudent(jAXBContext);
		if (studentStorage == null) {
			return false;
		}

		for (Student s : studentStorage.getUsers()) {
			if (s == user) {
				if (mark != null) {
					s.insertMark(mc, mark);
					OutputStream outputStream = new FileOutputStream(path);
					Marshaller marshaller = jAXBContext.createMarshaller();
					marshaller.marshal(studentStorage, outputStream);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * retrieves the marks for a {@link Student}
	 */
	public String retrieveMarks(Student student) throws FileNotFoundException, JAXBException {
		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageStudent.class);
		UserStorageStudent studentStorage = getUserStorageStudent(jAXBContext);
		String res;
		if (studentStorage == null) {
			return "error";
		}

		for (Student s : studentStorage.getUsers()) {
			if (s == student) {
				res = s.retrieveMarks();
				return res;
			}
		}
		return "error";
	}

	/**
	 * returns a student from the {@link UserStorageStudent} using their id
	 */
	public Student getUser(int studentId) throws JAXBException, FileNotFoundException {

		JAXBContext jAXBContext = JAXBContext.newInstance(UserStorageStudent.class);
		UserStorageStudent userStorageAcStaff = getUserStorageStudent(jAXBContext);

		for (Student s : userStorageAcStaff.getUsers()) {
			if (s.getId() == studentId)
				return s;
		}
		return null;
	}

	/**
	 * returns an unserialized {@link UserStorageStudent}
	 * @param ctx
	 * @return
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 */
	private UserStorageStudent getUserStorageStudent(JAXBContext ctx) throws FileNotFoundException, JAXBException {
		UserStorageStudent studentStorage = null;

		if (!new java.io.File(path).exists()) {
			studentStorage = new UserStorageStudent();
		} else {
			InputStream inputStream = new FileInputStream(path);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			studentStorage = (UserStorageStudent) unmarshaller.unmarshal(inputStream);
		}

		return studentStorage;
	}


}
