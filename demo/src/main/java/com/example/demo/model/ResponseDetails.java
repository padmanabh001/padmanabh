package com.example.demo.model;

import org.springframework.http.HttpStatus;

public class ResponseDetails {
	private HttpStatus status;
	private String errorMessage;
	private String successMessage;
	private Object o1;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public Object getO1() {
		return o1;
	}
	public void setO1(Object o1) {
		this.o1 = o1;
	}
	
	
	
}
