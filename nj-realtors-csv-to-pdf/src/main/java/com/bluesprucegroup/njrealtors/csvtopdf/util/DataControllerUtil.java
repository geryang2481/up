package com.bluesprucegroup.njrealtors.csvtopdf.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.WebServiceCryptoUtil;
import com.bluesprucegroup.njrealtors.csvtopdf.service.ResponseService;

@Component
public class DataControllerUtil {
	
	private static final Logger log = LogManager.getLogger(DataControllerUtil.class);
	
	@Value("${com.bluesprucegroup.solution.source.user.name}")
	private String userName;
	
	@Value("${com.bluesprucegroup.solution.source.message}")
	private String sourceMessage;
	
	@Value("${com.bluesprucegroup.solution.source.system}")
	private String sourceSystem;
	
	@Value("${com.bluesprucegroup.solution.source.clientversion}")
	private String clientVersion;
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private AuditLogUtil auditLogUtil;
	
	private String decryptedValue;
	private String decryptedMessage;

	private static final String TESTING_SOURCE = "soapui";
	
	public String decrypt(String input) {
		String output = "";
		try {
			output = WebServiceCryptoUtil.decrypt(input);
		} catch(java.lang.RuntimeException e) {
			log.info("Unable to decrypt message or value sent by requestor");
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return output;
	}
	
	public boolean isValidRequest(String value, String message, String source) {
		boolean isValidValue = false;
		boolean isValidMessage = false;
		
		if(source.equals(TESTING_SOURCE)) {
			//Decrypt and check to see if value is empty
			decryptedValue = value.equals("0") ? value : decrypt(value);
			isValidValue = !StringUtils.isEmpty(decryptedValue) ? true : false;
			
			//Decrypt message if from a valid source
			decryptedMessage = decrypt(message);
			isValidMessage = decryptedMessage.equals(sourceMessage) ? true : false;
		}
		
		return isValidValue && isValidMessage ? true : false;
	}
	
	public boolean isValidRequest(String value, String message) {
		boolean isValidValue = false;
		boolean isValidMessage = false;
		
		//Decrypt and check to see if value is empty
		decryptedValue = value.equals("0") ? value : decrypt(value);
		isValidValue = !StringUtils.isEmpty(decryptedValue) ? true : false;
		
		//Decrypt message if from a valid source
		decryptedMessage = decrypt(message);
		isValidMessage = decryptedMessage.equals(sourceMessage + WebServiceCryptoUtil.getCurrentHour()) ? true : false;
		
		return isValidValue && isValidMessage ? true : false;
	}
	
	public boolean isValidClientVersion(String clientVersion) {
		if(clientVersion.equals(this.clientVersion)) {
			return true;
		}
		return false;
	}
	
	public String formatRequest(String request) {
		request = request.replace("%5C", "-");
		request = request.replace("%5B", "[");
		request = request.replace("%7B", "{");
		request = request.replace("%22", "\"");
        request = request.replace("%3A", ":");
        request = request.replace("%2F", "/");
        request = request.replace("%2C", ",");
        request = request.replace("%7D", "}");
        request = request.replace("%5D", "]");
        request = request.replace("+", "");
        request = request.replace("\\\\", "-");
        request = request.replace("\\", "-");
		return request;
	}
	
	public ResponseEntity<String> findResponseEntity(ResponseEntity<String> responseEntity, HttpStatus statusCode, String status, String userName, String auditLog) {
		
		try {
			
		switch(statusCode)
			{
				case OK:
					responseEntity = new ResponseEntity<String>(responseService.createHttpStatusOk200Xml(HttpStatus.OK, status, auditLogUtil.getAuditLog(HttpStatus.OK, status, userName, this.toString(), 
							Thread.currentThread().getStackTrace()[1].getMethodName(), "Response to user.", auditLog)), HttpStatus.OK);
					break;
				case BAD_REQUEST:
					responseEntity = new ResponseEntity<String>(responseService.createHttpStatusBadRequest400Xml(HttpStatus.BAD_REQUEST, status, auditLogUtil.getAuditLog(HttpStatus.BAD_REQUEST, status, 
							userName, this.toString(), Thread.currentThread().getStackTrace()[1].getMethodName(), "Response to client", auditLog)), 
							HttpStatus.BAD_REQUEST);
					break;
				case FORBIDDEN:
					responseEntity = new ResponseEntity<String>(responseService.createHttpStatusForbidden403Xml(HttpStatus.FORBIDDEN, status, auditLogUtil.getAuditLog(HttpStatus.FORBIDDEN, status, 
							userName, this.toString(), Thread.currentThread().getStackTrace()[1].getMethodName(), "Response to client", auditLog)), 
							HttpStatus.FORBIDDEN);
					break;
				case UNSUPPORTED_MEDIA_TYPE:
					responseEntity = new ResponseEntity<String>(responseService.createHttpStatusUnsupportedMediaType415Xml(HttpStatus.UNSUPPORTED_MEDIA_TYPE, status, auditLogUtil.getAuditLog(HttpStatus.UNSUPPORTED_MEDIA_TYPE, status, 
							userName, this.toString(), Thread.currentThread().getStackTrace()[1].getMethodName(), "Response to user", auditLog)), 
							HttpStatus.UNSUPPORTED_MEDIA_TYPE);
					break;
				case INTERNAL_SERVER_ERROR:
					responseEntity = new ResponseEntity<String>(responseService.createHttpStatusInternalServerError500Xml(HttpStatus.INTERNAL_SERVER_ERROR, status, auditLogUtil.getAuditLog(HttpStatus.INTERNAL_SERVER_ERROR, status, 
							userName, this.toString(), Thread.currentThread().getStackTrace()[1].getMethodName(), "Response to user", auditLog)), 
							HttpStatus.INTERNAL_SERVER_ERROR);
					break;
				case HTTP_VERSION_NOT_SUPPORTED:
					responseEntity = new ResponseEntity<String>(responseService.createHttpStatusUnsupportedMediaType415Xml(HttpStatus.HTTP_VERSION_NOT_SUPPORTED, status, auditLogUtil.getAuditLog(HttpStatus.HTTP_VERSION_NOT_SUPPORTED, status, 
							userName, this.toString(), Thread.currentThread().getStackTrace()[1].getMethodName(), "Response to user", auditLog)), 
							HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
					break;
				default:
					responseEntity = new ResponseEntity<String>(responseService.createHttpStatusInternalServerError500Xml(HttpStatus.INTERNAL_SERVER_ERROR, status, auditLogUtil.getAuditLog(HttpStatus.INTERNAL_SERVER_ERROR, status, 
							userName, this.toString(), Thread.currentThread().getStackTrace()[1].getMethodName(), "Response to user", auditLog)), 
							HttpStatus.INTERNAL_SERVER_ERROR);
					break;
			}
			log.info("ResponseEntity -  StatusCode: " + statusCode + ", UserName: " + userName + ", AuditLog: " + auditLog);
		} catch(Exception e) {
        	log.error(e.getMessage(), e);
        }
		
		return responseEntity;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSourceMessage() {
		return sourceMessage;
	}

	public void setSourceMessage(String sourceMessage) {
		this.sourceMessage = sourceMessage;
	}

	
	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public ResponseService getResponseService() {
		return responseService;
	}

	public void setResponseService(ResponseService responseService) {
		this.responseService = responseService;
	}

	public AuditLogUtil getAuditLogUtil() {
		return auditLogUtil;
	}

	public void setAuditLogUtil(AuditLogUtil auditLogUtil) {
		this.auditLogUtil = auditLogUtil;
	}

	public String getDecryptedValue() {
		return decryptedValue;
	}

	public void setDecryptedValue(String decryptedValue) {
		this.decryptedValue = decryptedValue;
	}

	public String getDecryptedMessage() {
		return decryptedMessage;
	}

	public void setDecryptedMessage(String decryptedMessage) {
		this.decryptedMessage = decryptedMessage;
	}
	
	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public static Logger getLog() {
		return log;
	}
	
	
}
