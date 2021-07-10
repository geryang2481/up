package com.bluesprucegroup.njrealtors.csvtopdf.service;

import org.springframework.http.HttpStatus;

public interface ResponseService {

	public String createHttpStatusOk200Xml(HttpStatus statusCode, String status, String auditLog);
	public String createHttpStatusBadRequest400Xml(HttpStatus statusCode, String status, String auditLog );
	public String createHttpStatusForbidden403Xml(HttpStatus statusCode, String status, String auditLog );
	public String createHttpStatusUnsupportedMediaType415Xml(HttpStatus statusCode, String status, String auditLog );
	public String createHttpStatusInternalServerError500Xml(HttpStatus statusCode, String status, String auditLog);
}
