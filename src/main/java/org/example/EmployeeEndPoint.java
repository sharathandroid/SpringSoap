package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.example.employee.GetEmployeeRequest;
import org.example.employee.GetEmployeeResponse;
@Endpoint
public class EmployeeEndPoint {
	private static final String NAMESPACE_URI = "http://www.example.org/Employee";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployeeRequest(@RequestPayload GetEmployeeRequest getEmployeeRequest) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		/*if(calculateAge(request.getDob())<20)
		response.setEligibilityCode(500);
		response.setEligibilityMessage("Bad Request");
		return response;*/
		response.setEligibilityCode(1);
		response.setEligibilityMessage("success");
		return response;
	}
	private int calculateAge(XMLGregorianCalendar xmlGregorianCalendar) {
		// TODO Auto-generated method stub
		if(xmlGregorianCalendar == null) {
            return 0;
        }
         Date birthDate= xmlGregorianCalendar.toGregorianCalendar().getTime();  
         Date now=new Date();
         long difference =  (birthDate.getTime()-now.getTime())/1000l*60*60*24*365;
         return (int) Math.abs(difference);
	}
} 