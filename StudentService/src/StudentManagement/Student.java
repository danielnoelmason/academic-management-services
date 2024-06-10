package StudentManagement;

import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * object for creating students on the system
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

	private int id;
	private List<StudentModule> enrolledModules;

	/**
	 * construcor
	 * @param id
	 */
	public Student(int id) {
		this.id = id;
	}

	/**
	 * gets id
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * add a module to students enrolledModules
	 * @param module
	 * @return
	 */
	public boolean enroll(StudentModule module) {
		if (this.enrolledModules == null)
			this.enrolledModules = new ArrayList<StudentModule>();
		return this.enrolledModules.add(module);
	}

	public List<StudentModule> getEnrolledModules() {
		return enrolledModules;
	}

	public void insertMark(ModuleCode mc, Mark mark) {
		for(StudentModule s:enrolledModules)
			if(s.getModuleCode()==mc)
				s.insertMark(mark);
	}

	public String retrieveMarks() {
		String res=null;
		for(StudentModule s:enrolledModules)
			res += s.getMarksToString()+"\n";
		return res;
	}
	

}