package AcademicStaffManagement;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * stores {@link AcademicStaff} registered in the system
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UserStorageAcStaff {

private ArrayList<AcademicStaff> academicStaffUsers = new ArrayList<AcademicStaff>();
	
	public void addUser(AcademicStaff acStaff) {
		academicStaffUsers.add(acStaff);
	}
	
	public AcademicStaff[] getUsers(){
		AcademicStaff[] academicStaff = new AcademicStaff[this.academicStaffUsers.size()];
		academicStaff = this.academicStaffUsers.toArray(academicStaff);
		return academicStaff;
	}
	
}
