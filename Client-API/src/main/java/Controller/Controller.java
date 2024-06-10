package Controller;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.ws.Service;

import academicstaffmanagement.*;
import academicstaffmanagement.FileNotFoundException_Exception;
import academicstaffmanagement.JAXBException_Exception;
import studentmanagement.*;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

public class Controller {

	/**
	 * register a user with the module
	 * 
	 * @param id
	 * @param role
	 * @throws MalformedURLException
	 * @throws JAXBException_Exception 
	 * @throws FileNotFoundException_Exception 
	 * @throws studentmanagement.FileNotFoundException_Exception 
	 * @throws studentmanagement.JAXBException_Exception 
	 */
	public void registerUser(int id, Role role) throws MalformedURLException, FileNotFoundException_Exception, JAXBException_Exception, studentmanagement.FileNotFoundException_Exception, studentmanagement.JAXBException_Exception {

		if (role == Role.STUDENT) {
			Service service = getService("http://localhost:8080/StudentService/?wsdl", "http://StudentManagement/",
					"StudentManagementImplService");
			StudentManagement sServices = service.getPort(StudentManagement.class);

			Student student = new Student();
			student.setId(id);
			sServices.registerUser(student);
			System.out.println("Enrolling the student with ID " + id);
	           
		}

		if (role == Role.ACADEMIC_STAFF) {
			Service service = getService("http://localhost:8080/AcademicStaffService/?wsdl",
					"http://AcademicStaffManagement/", "AcademicStaffManagmentImplService");
			AcademicStaffManagement aServices = service.getPort(AcademicStaffManagement.class);

			AcademicStaff academicStaff = new AcademicStaff();
			academicStaff.setId(id);
			aServices.registerUser(academicStaff);
			System.out.println("Enrolling the academic staff member with ID " + id);
            
		}

	}

	/**
	 * enroll a student for a module
	 * @param academicStaff
	 * @param student
	 * @param mc
	 * @param s
	 * @param ay
	 * @return
	 * @throws MalformedURLException
	 * @throws studentmanagement.FileNotFoundException_Exception
	 * @throws studentmanagement.JAXBException_Exception
	 * @throws FileNotFoundException_Exception
	 * @throws JAXBException_Exception
	 */
	public int enrollStudent(int academicStaff, int student, ModuleCode mc, Semester s, AcademicYear ay)
			throws MalformedURLException, studentmanagement.FileNotFoundException_Exception, studentmanagement.JAXBException_Exception, FileNotFoundException_Exception, JAXBException_Exception {

		Service studentService = getService("http://localhost:8080/StudentManagement/?wsdl",
				"http://StudentManagement/", "StudentManagementImpl");
		Service academicStaffService = getService("http://localhost:8080/AcademicStaffManagement/?wsdl",
				"http://AcademicStaffManagement/", "AcademicStaffManagmentImpl");
		StudentManagement sServices = studentService.getPort(StudentManagement.class);
		AcademicStaffManagement acServices = academicStaffService.getPort(AcademicStaffManagement.class);

		AcademicStaff userAc = acServices.getUser(academicStaff);
		Student userS = sServices.getUser(student);
		
		StudentModule newModule = new StudentModule();
		newModule.setModuleCode(mc);
		newModule.setSemester(s);
		newModule.setAcademicYear(ay);
		
		try {
			if (acServices.isRegistered(userAc)) {
				if (sServices.isRegistered(userS)) {
					if (!sServices.isEnrolled(userS, mc)) {
						sServices.enrollStudent(userS, newModule);
						System.out.println("Successful enrolment of the student with ID " + userS.getId()
								+ " on the module " + mc.toString() + ", " + s.toString() + ", " + ay.getAcademicYear()
								+ " by the academic staff member with ID " + userS.getId());
						return 0;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Error enrolling student with ID " + userS.getId() + " by the academic staff member with ID " + userAc.getId());
		return -1;
	}

	/**
	 * insert a mark for a module
	 * 
	 * @param academicStaffId
	 * @param studentId
	 * @param mc
	 * @param markScore
	 * @param note
	 * @return
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 * @throws MalformedURLException
	 * @throws studentmanagement.FileNotFoundException_Exception
	 * @throws studentmanagement.JAXBException_Exception
	 * @throws FileNotFoundException_Exception
	 * @throws JAXBException_Exception
	 */
	public int insertMark(int academicStaffId, int studentId, ModuleCode mc, int markScore, String note)
			throws FileNotFoundException, JAXBException, MalformedURLException, studentmanagement.FileNotFoundException_Exception, studentmanagement.JAXBException_Exception, FileNotFoundException_Exception, JAXBException_Exception {

		Service studentService = getService("http://localhost:8080/StudentManagement/?wsdl",
				"http://StudentManagement/", "StudentManagementImpl");
		Service academicStaffService = getService("http://localhost:8080/AcademicStaffManagement/?wsdl",
				"http://AcademicStaffManagement/", "AcademicStaffManagmentImpl");
		StudentManagement sServices = studentService.getPort(StudentManagement.class);
		AcademicStaffManagement acServices = academicStaffService.getPort(AcademicStaffManagement.class);

		AcademicStaff as = acServices.getUser(academicStaffId);
		Student s = sServices.getUser(studentId);
		
		if (!acServices.isRegistered(as)) {
			System.out.println("Error inserting the mark " + markScore + " for the student with ID " + studentId
					+ " on the module " + mc.toString() + " by the academic staff member with ID "
					+ academicStaffId);
			return -1;
		}
		if (!sServices.isRegistered(s)) {
			System.out.println("Error inserting the mark " + markScore + " for the student with ID " + s
					+ " on the module " + mc.toString() + " by the academic staff member with ID "
					+ as);
			return -1;
		}
		if (!sServices.isEnrolled(s, mc)) {
			System.out.println("Error inserting the mark " + markScore + " for the student with ID " + s
					+ " on the module " + mc.toString() + " by the academic staff member with ID "
					+ academicStaffId);
			return -1;
		}
		
		Mark mark = new Mark();
		mark.setMark(markScore);
		mark.setNote(note);
		sServices.insertMark(s, mc, mark);
		System.out.println("Successful insertion of the mark " + markScore + " for the student with ID "
				+ studentId + " on the module " + mc.toString()
				+ " by the academic staff member with ID " + academicStaffId);
		return 0;
	}

	/**
	 * retrieve a string to print the marks for a student
	 * 
	 * @param academicStaffId
	 * @param studentId
	 * @return
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 * @throws MalformedURLException
	 * @throws FileNotFoundException_Exception
	 * @throws JAXBException_Exception
	 * @throws studentmanagement.FileNotFoundException_Exception
	 * @throws studentmanagement.JAXBException_Exception
	 */
	public String retrieveMarks(int academicStaffId, int studentId)
			throws FileNotFoundException, JAXBException, MalformedURLException, FileNotFoundException_Exception, JAXBException_Exception, studentmanagement.FileNotFoundException_Exception, studentmanagement.JAXBException_Exception {
		Service studentService = getService("http://localhost:8080/StudentManagement/?wsdl",
				"http://StudentManagement/", "StudentManagementImpl");
		Service academicStaffService = getService("http://localhost:8080/AcademicStaffManagement/?wsdl",
				"http://AcademicStaffManagement/", "AcademicStaffManagmentImpl");
		StudentManagement sServices = studentService.getPort(StudentManagement.class);
		AcademicStaffManagement acServices = academicStaffService.getPort(AcademicStaffManagement.class);

		AcademicStaff as = acServices.getUser(academicStaffId);
		Student s = sServices.getUser(studentId);
		
		if (!acServices.isRegistered(as)) {
			System.out.println("Error report the modules for the student with ID  " + studentId
					+ " by the academic staff member with ID " + academicStaffId);
			return null;
		}
		if (!sServices.isRegistered(s)) {
			System.out.println("Error report the modules for the student with ID  " + studentId
					+ " by the academic staff member with ID " + academicStaffId);
			return null;
		}

		System.out.println("Reporting the modules for the student with ID " + studentId
				+ " by the academic staff member with ID " + academicStaffId);
		return sServices.retrieveMarks(s);
	}

	/**
	 * assign a module to a academic staff
	 * 
	 * @param academicStaffId
	 * @param mc
	 * @param s
	 * @param ay
	 * @return
	 * @throws MalformedURLException
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 * @throws FileNotFoundException_Exception
	 * @throws JAXBException_Exception
	 */
	public int assignModule(int academicStaffId, ModuleCodeAc mc, SemesterAc s, AcademicYearAc ay)
			throws MalformedURLException, FileNotFoundException, JAXBException, FileNotFoundException_Exception, JAXBException_Exception {

		Service academicStaffService = getService("http://localhost:8080/AcademicStaffManagement/?wsdl",
				"http://AcademicStaffManagement/", "AcademicStaffManagmentImpl");
		AcademicStaffManagement acServices = academicStaffService.getPort(AcademicStaffManagement.class);

		AcademicStaff as = acServices.getUser(academicStaffId);
		
		if (!acServices.isRegistered(as)) {
			System.out.println("Error assignment of the module " + mc.toString() + ", " + s.toString() + ", "
					+ ay.getAcademicYear() + " to the academic staff member with ID " + academicStaffId + "\n");
			return -1;
		}

		AcStaffModule module = new AcStaffModule();
		module.setSemester(s);
		module.setAcademicYear(ay);
		module.setModuleCode(mc);
		
		acServices.assignModule(as, module);
		System.out.println("Successful assignment of the module " + mc.toString() + ", " + s.toString() + ", "
				+ ay.toString() + " to the academic staff member with ID " + academicStaffId + "\n");

		return 0;

	}

	/**
	 * returns a service
	 * 
	 * @param url
	 * @param namespaceURI
	 * @param localPort
	 * @return
	 * @throws MalformedURLException
	 */
	private Service getService(String url, String namespaceURI, String localPort) throws MalformedURLException {
		if (url == null || namespaceURI == null || localPort == null) {
			return null;
		}

		URL _url = new URL(url);
		QName _qname = new QName(namespaceURI, localPort);

		return Service.create(_url, _qname);
	}

}
