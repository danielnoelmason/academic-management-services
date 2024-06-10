package View;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javax.xml.bind.JAXBException;

import Controller.Controller;
import Controller.Role;
import academicstaffmanagement.AcademicYearAc;
import academicstaffmanagement.FileNotFoundException_Exception;
import academicstaffmanagement.JAXBException_Exception;
import academicstaffmanagement.ModuleCodeAc;
import academicstaffmanagement.SemesterAc;
import studentmanagement.AcademicYear;
import studentmanagement.ModuleCode;
import studentmanagement.Semester;

public class CLI {

	static Controller controller = new Controller();

	public static void main(String[] args) throws MalformedURLException, FileNotFoundException_Exception, JAXBException_Exception, studentmanagement.FileNotFoundException_Exception, studentmanagement.JAXBException_Exception, FileNotFoundException, JAXBException {
		//1
		System.out.println("Use Case 1 Batch registration of End Users");
        int[] ids = {0, 1, 2, 3, 4, 5, 6};
        Role[] roles = {Role.STUDENT, Role.STUDENT, Role.STUDENT, Role.STUDENT, Role.STUDENT, Role.ACADEMIC_STAFF, Role.ACADEMIC_STAFF};

        for(int i = 0; i < ids.length; i++) { 
            controller.registerUser(ids[i], roles[i]);
        }

        ModuleCode mc1 = ModuleCode.CSC_1022;
        ModuleCode mc2 = ModuleCode.CSC_1022;
        Semester s = Semester.AUT;
        AcademicYear ay = new AcademicYear();ay.setAcademicYear("AY_2019_20");
        
        //2
        System.out.println("Use Case 2 Enrolling a student on a Module");
        
        controller.enrollStudent(0, 1, mc1, s, ay);
        controller.enrollStudent(5, 7, mc1, s, ay);
        controller.enrollStudent(5, 1, mc1, s, ay);
        
        //3
        System.out.println("Use Case 3 Inserting a new Mark");

        controller.insertMark(0, 1, mc1, 100, "P");
        controller.insertMark(5, 1, mc2, 100, "P");
        controller.insertMark(5, 7, mc1, 100, "P");
        controller.insertMark(5, 1, mc1, 100, "P");
        
        //4
        System.out.println("Use Case 4 Printing the marks of a student");

        System.out.println(controller.retrieveMarks(2,1));
        System.out.println(controller.retrieveMarks(5,1));
        
        //5
        System.out.println("Use Case 5 Assigning a module to an academic staff member");
        
        ModuleCodeAc mc1A = ModuleCodeAc.CSC_1022;
        SemesterAc sA = SemesterAc.AUT;
        AcademicYearAc ayA = new AcademicYearAc();ay.setAcademicYear("AY_2019_20");
        controller.assignModule(2, mc1A, sA, ayA);
        controller.assignModule(5, mc1A, sA, ayA);
    }

}