package com.cts.exception;

import java.util.Calendar;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	@Autowired
	ExceptionDetails exceptionDetails;

	public Response toResponse(Throwable e) {
		exceptionDetails.setName(e.getClass().getSimpleName());
		exceptionDetails.setExceptionTime(Calendar.getInstance().getTime());
		exceptionDetails.setDetails(e.getMessage());
	 
		return Response.status(200)
					.entity(exceptionDetails)
					.type(MediaType.APPLICATION_JSON)
					.build();	
	}
	
	
 
}