package AcademicStaffManagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * field of {@link AcStaffModule}
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AcademicYearAc {

	private String academicYear;

	/**
	 * constructor
	 * 
	 * @param string
	 */
	public AcademicYearAc(String string) {
		this.academicYear = string;
	}

	/**
	 * getter
	 * 
	 * @return
	 */
	public String getAcademicYear() {
		return academicYear;
	}

}
