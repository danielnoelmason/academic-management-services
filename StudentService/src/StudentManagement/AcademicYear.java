package StudentManagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * field of {@link StudentModule}
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AcademicYear {

	private String academicYear;

	/**
	 * constructor
	 * 
	 * @param string
	 */
	public AcademicYear(String string) {
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
