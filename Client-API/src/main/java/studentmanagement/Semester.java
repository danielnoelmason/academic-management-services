
package studentmanagement;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for semester.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="semester">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AUT"/>
 *     &lt;enumeration value="SPR"/>
 *     &lt;enumeration value="FY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "semester")
@XmlEnum
public enum Semester {

    AUT,
    SPR,
    FY;

    public String value() {
        return name();
    }

    public static Semester fromValue(String v) {
        return valueOf(v);
    }

}
