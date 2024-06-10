
package studentmanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studentModule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moduleCode" type="{http://StudentManagement/}moduleCode" minOccurs="0"/>
 *         &lt;element name="semester" type="{http://StudentManagement/}semester" minOccurs="0"/>
 *         &lt;element name="academicYear" type="{http://StudentManagement/}academicYear" minOccurs="0"/>
 *         &lt;element name="mark" type="{http://StudentManagement/}mark" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentModule", propOrder = {
    "moduleCode",
    "semester",
    "academicYear",
    "mark"
})
public class StudentModule {

    protected ModuleCode moduleCode;
    protected Semester semester;
    protected AcademicYear academicYear;
    protected Mark mark;

    /**
     * Gets the value of the moduleCode property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleCode }
     *     
     */
    public ModuleCode getModuleCode() {
        return moduleCode;
    }

    /**
     * Sets the value of the moduleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleCode }
     *     
     */
    public void setModuleCode(ModuleCode value) {
        this.moduleCode = value;
    }

    /**
     * Gets the value of the semester property.
     * 
     * @return
     *     possible object is
     *     {@link Semester }
     *     
     */
    public Semester getSemester() {
        return semester;
    }

    /**
     * Sets the value of the semester property.
     * 
     * @param value
     *     allowed object is
     *     {@link Semester }
     *     
     */
    public void setSemester(Semester value) {
        this.semester = value;
    }

    /**
     * Gets the value of the academicYear property.
     * 
     * @return
     *     possible object is
     *     {@link AcademicYear }
     *     
     */
    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    /**
     * Sets the value of the academicYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcademicYear }
     *     
     */
    public void setAcademicYear(AcademicYear value) {
        this.academicYear = value;
    }

    /**
     * Gets the value of the mark property.
     * 
     * @return
     *     possible object is
     *     {@link Mark }
     *     
     */
    public Mark getMark() {
        return mark;
    }

    /**
     * Sets the value of the mark property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mark }
     *     
     */
    public void setMark(Mark value) {
        this.mark = value;
    }

}
