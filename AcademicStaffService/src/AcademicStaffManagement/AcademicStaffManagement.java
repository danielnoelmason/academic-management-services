package AcademicStaffManagement;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.JAXBException;


import java.io.FileNotFoundException;

/**
 * web api interface for managing academic staff
 *
 */
@WebService
@SOAPBinding(style=Style.RPC)
public interface AcademicStaffManagement {
	
	@WebMethod
	 void registerUser(@WebParam(name = "registerAcademicStaff")AcademicStaff academicStaff)  throws FileNotFoundException, JAXBException;
	@WebMethod
	 @WebResult(name = "isRegistered")boolean isRegistered(@WebParam(name = "academicStaffRegistration")AcademicStaff user)  throws FileNotFoundException, JAXBException;
	@WebMethod
	 @WebResult(name = "assignModule")boolean assignModule(@WebParam(name = "assigningModule")AcademicStaff academicStaff, @WebParam(name = "module")AcStaffModule module)  throws FileNotFoundException, JAXBException;
	@WebMethod
	 @WebResult(name = "getUser")AcademicStaff getUser(@WebParam(name = "getUserAcademicStaff")int academicStaffId)  throws FileNotFoundException, JAXBException;
	}
