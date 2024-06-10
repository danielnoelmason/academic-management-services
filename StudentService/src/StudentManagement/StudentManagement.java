package StudentManagement;

import java.io.FileNotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXBException;

/**
 * web api definitions for student services
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface StudentManagement {

	@WebMethod
	void registerUser(@WebParam(name = "registerStudentUser") Student user) throws FileNotFoundException, JAXBException;

	@WebMethod
	void enrollStudent(@WebParam(name = "enrollStudentOnModule") Student user,
			@WebParam(name = "Module") StudentModule module) throws FileNotFoundException, JAXBException;

	@WebMethod
	@WebResult(name = "isRegistered")
	boolean isRegistered(@WebParam(name = "Student") Student student) throws FileNotFoundException, JAXBException;

	@WebMethod
	@WebResult(name = "isEnrolled")
	boolean isEnrolled(@WebParam(name = "Student") Student student, @WebParam(name = "ModuleCode") ModuleCode mc)
			throws FileNotFoundException, JAXBException;

	@WebMethod
	@WebResult(name = "insertMark")
	boolean insertMark(@WebParam(name = "Student") Student user, @WebParam(name = "ModuleCode") ModuleCode mc,
			@WebParam(name = "Mark") Mark mark) throws FileNotFoundException, JAXBException;

	@WebMethod
	@WebResult(name = "retrieveMarks")
	String retrieveMarks(@WebParam(name = "Student") Student student) throws FileNotFoundException, JAXBException;

	@WebMethod
	@WebResult(name = "getUser")
	Student getUser(@WebParam(name = "getUserStudent") int studentId)
			throws FileNotFoundException, JAXBException;

}
