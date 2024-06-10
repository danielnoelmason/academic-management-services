package StudentManagement;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * stores students stored in the service
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UserStorageStudent {

private ArrayList<Student> studentUsers = new ArrayList<Student>();
	
	public void addUser(Student student) {
		studentUsers.add(student);
	}
	
	public Student[] getUsers(){
		Student[] academicStaff = new Student[this.studentUsers.size()];
		academicStaff = this.studentUsers.toArray(academicStaff);
		return academicStaff;
	}
	
	public Student getUser(int id) {
		for(Student s : studentUsers) {
			if(s.getId()==id)
				return s;
		}
		return null;
	}
	
}
