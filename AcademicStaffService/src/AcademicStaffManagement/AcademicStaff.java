package AcademicStaffManagement;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * object for creating an academic staff user
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AcademicStaff {

	protected int id;
	protected List<AcStaffModule> staffModules;

	/**
	 * constructor
	 * @param id
	 */
	public AcademicStaff(Integer id) {
		this.id = id;
	}

	/**
	 * assigns a module
	 * @param module
	 */
	public void assignModule(AcStaffModule module) {
		staffModules.add(module);
	}
	/**
	 * get id of academic staff
	 * @return
	 */
	public int getId() {
		return this.id;
	}
}
