package AcademicStaffManagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * modules an {@link AcademicStaff} is assigned 
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AcStaffModule {
	private ModuleCodeAc moduleCode;
	private SemesterAc semester;
	private AcademicYearAc academicYear;

	public AcStaffModule(ModuleCodeAc mc, SemesterAc s, AcademicYearAc ay) {
		this.academicYear = ay;
		this.semester = s;
		this.moduleCode = mc;

	} 



	/**
	 * getter
	 * 
	 * @return
	 */
	public ModuleCodeAc getModuleCode() {
		return moduleCode;
	}

	/**
	 * getter
	 * 
	 * @return
	 */
	public SemesterAc getSemester() {
		return semester;
	}

	/**
	 * getter
	 * 
	 * @return
	 */
	public AcademicYearAc getAcademicYear() {
		return academicYear;
	}
}
