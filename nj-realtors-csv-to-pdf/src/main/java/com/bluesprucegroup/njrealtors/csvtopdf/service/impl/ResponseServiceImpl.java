package com.bluesprucegroup.njrealtors.csvtopdf.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.service.ResponseService;

@Component
public class ResponseServiceImpl implements ResponseService {

	private final String RESPONSE_OPEN = "<Response><StatusCode>";
	private final String RESPONSE_MID = "</StatusCode><Status>";
	private final String RESPONSE_AUDITLOG = "</Status><AuditLog>";
	private final String RESPONSE_CLOSE = "</AuditLog></Response>";

	private static final Logger log = LogManager.getLogger(ResponseServiceImpl.class);
	
	private String createXmlHeader() {
		return "<?xml version=\"1.0\"?>";
	}
	
	private String buildResponse(String statusCode, String status, String auditLog) {
		StringBuffer sb = new StringBuffer();
		
		try {
			sb.append(createXmlHeader());
			sb.append(RESPONSE_OPEN );
			sb.append(statusCode);
			sb.append(RESPONSE_MID);
			sb.append(status);
			sb.append(RESPONSE_AUDITLOG);
			sb.append(auditLog);
			sb.append(RESPONSE_CLOSE);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return sb.toString();
	}
	
	

	@Override
	public String createHttpStatusOk200Xml(HttpStatus statusCode, String status, String auditLog) {
		return buildResponse(statusCode.toString(), status, auditLog);
	}
	
	@Override
	public String createHttpStatusBadRequest400Xml(HttpStatus statusCode, String status, String auditLog) {
		return buildResponse(statusCode.toString(), status, auditLog);
	}
	
	@Override
	public String createHttpStatusForbidden403Xml(HttpStatus statusCode, String status, String auditLog) {
		return buildResponse(statusCode.toString(), status, auditLog);
	}

	@Override
	public String createHttpStatusUnsupportedMediaType415Xml(HttpStatus statusCode, String status, String auditLog) {
		return buildResponse(statusCode.toString(), status, auditLog);
	}
	
	@Override
	public String createHttpStatusInternalServerError500Xml(HttpStatus statusCode, String status, String auditLog) {
		return buildResponse(statusCode.toString(), status, auditLog);
	}
}
