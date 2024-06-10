package StudentManagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * for creating modules of a student
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentModule {
	
	private ModuleCode moduleCode;
    private Semester semester;
    private AcademicYear academicYear;
    private Mark mark;

    public StudentModule(ModuleCode mc, Semester s, AcademicYear ay) {
		this.academicYear = ay;
		this.semester = s;
		this.moduleCode = mc;

	}
    /**
	 * sets mark for module
	 * @param mark
	 */
	public void insertMark(Mark mark) {
		this.mark = mark;

	}

	/**
	 * get module code and mark
	 * @return
	 */
	public String getMarksToString() {
		return getSemester().toString()+" "+getAcademicYear().getAcademicYear()+" "+getModuleCode().toString() + "\t" + mark.getMarkToString();
	}

	/**
	 * getter
	 * @return
	 */
	public ModuleCode getModuleCode() {
		return moduleCode;
	}

	/**
	 * getter
	 * @return
	 */
	public Semester getSemester() {
		return semester;
	}

	/**
	 * getter
	 * @return
	 */
	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	/**
	 * getter
	 * @return
	 */
	public Mark getMark() {
		return mark;
	}
}
