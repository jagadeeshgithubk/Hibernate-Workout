package com.webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace="http://ram.webservice.com/",name="fuckyou")
@SOAPBinding(style=Style.RPC)
public interface TestWebservice1 {

	@WebMethod
	String getTestString();
	@WebMethod
	int getIntegerValue(String inputIntParam);
}
