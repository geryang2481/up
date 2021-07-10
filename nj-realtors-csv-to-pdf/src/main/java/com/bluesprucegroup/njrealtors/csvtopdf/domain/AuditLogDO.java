package com.bluesprucegroup.njrealtors.csvtopdf.domain;

import org.springframework.http.HttpStatus;

public class AuditLogDO {
	

	
	
	private HttpStatus statusCode;
	private String status;
	private String userName;
	private String classMethod;	
	private String statusSource;
	private String details;
	private String currentTimestamp;
	private String history;
	
	
	
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getClassMethod() {
		return classMethod;
	}
	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}
	public String getStatusSource() {
		return statusSource;
	}
	public void setStatusSource(String statusSource) {
		this.statusSource = statusSource;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCurrentTimestamp() {
		return currentTimestamp;
	}
	public void setCurrentTimestamp(String currentTimestamp) {
		this.currentTimestamp = currentTimestamp;
	}
}
