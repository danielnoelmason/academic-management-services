
package academicstaffmanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acStaffModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acStaffModule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moduleCode" type="{http://AcademicStaffManagement/}moduleCodeAc" minOccurs="0"/>
 *         &lt;element name="semester" type="{http://AcademicStaffManagement/}semesterAc" minOccurs="0"/>
 *         &lt;element name="academicYear" type="{http://AcademicStaffManagement/}academicYearAc" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acStaffModule", propOrder = {
    "moduleCode",
    "semester",
    "academicYear"
})
public class AcStaffModule {

    protected ModuleCodeAc moduleCode;
    protected SemesterAc semester;
    protected AcademicYearAc academicYear;

    /**
     * Gets the value of the moduleCode property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleCodeAc }
     *     
     */
    public ModuleCodeAc getModuleCode() {
        return moduleCode;
    }

    /**
     * Sets the value of the moduleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleCodeAc }
     *     
     */
    public void setModuleCode(ModuleCodeAc value) {
        this.moduleCode = value;
    }

    /**
     * Gets the value of the semester property.
     * 
     * @return
     *     possible object is
     *     {@link SemesterAc }
     *     
     */
    public SemesterAc getSemester() {
        return semester;
    }

    /**
     * Sets the value of the semester property.
     * 
     * @param value
     *     allowed object is
     *     {@link SemesterAc }
     *     
     */
    public void setSemester(SemesterAc value) {
        this.semester = value;
    }

    /**
     * Gets the value of the academicYear property.
     * 
     * @return
     *     possible object is
     *     {@link AcademicYearAc }
     *     
     */
    public AcademicYearAc getAcademicYear() {
        return academicYear;
    }

    /**
     * Sets the value of the academicYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcademicYearAc }
     *     
     */
    public void setAcademicYear(AcademicYearAc value) {
        this.academicYear = value;
    }

}
