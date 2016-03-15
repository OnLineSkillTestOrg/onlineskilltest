package com.cts.exception;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class ExceptionDetails {
	
	String name;
	String details;
	Date exceptionTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getExceptionTime() {
		return exceptionTime;
	}
	public void setExceptionTime(Date exceptionTime) {
		this.exceptionTime = exceptionTime;
	}

}
