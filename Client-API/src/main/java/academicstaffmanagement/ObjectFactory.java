
package academicstaffmanagement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the academicstaffmanagement package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FileNotFoundException_QNAME = new QName("http://AcademicStaffManagement/", "FileNotFoundException");
    private final static QName _JAXBException_QNAME = new QName("http://AcademicStaffManagement/", "JAXBException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: academicstaffmanagement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBException }
     * 
     */
    public JAXBException createJAXBException() {
        return new JAXBException();
    }

    /**
     * Create an instance of {@link FileNotFoundException }
     * 
     */
    public FileNotFoundException createFileNotFoundException() {
        return new FileNotFoundException();
    }

    /**
     * Create an instance of {@link AcStaffModule }
     * 
     */
    public AcStaffModule createAcStaffModule() {
        return new AcStaffModule();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link AcademicStaff }
     * 
     */
    public AcademicStaff createAcademicStaff() {
        return new AcademicStaff();
    }

    /**
     * Create an instance of {@link AcademicYearAc }
     * 
     */
    public AcademicYearAc createAcademicYearAc() {
        return new AcademicYearAc();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AcademicStaffManagement/", name = "FileNotFoundException")
    public JAXBElement<FileNotFoundException> createFileNotFoundException(FileNotFoundException value) {
        return new JAXBElement<FileNotFoundException>(_FileNotFoundException_QNAME, FileNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JAXBException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AcademicStaffManagement/", name = "JAXBException")
    public JAXBElement<JAXBException> createJAXBException(JAXBException value) {
        return new JAXBElement<JAXBException>(_JAXBException_QNAME, JAXBException.class, null, value);
    }

}
