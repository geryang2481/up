 package com.bluesprucegroup.njrealtors.csvtopdf.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.AuditLogDO;
import com.google.gson.Gson;

@Component
public class AuditLogUtil {
	
	private static final Logger log = LogManager.getLogger(AuditLogUtil.class);
	
	public static final HttpStatus OK = HttpStatus.OK;
	public static final HttpStatus ACCEPTED = HttpStatus.ACCEPTED;
	public static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;
	public static final HttpStatus FORBIDDEN = HttpStatus.FORBIDDEN;
	public static final HttpStatus UNSUPPORTED_MEDIA_TYPE = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
	public static final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;
	public static final String TX_COMPLETED = "Transaction completed";
	public static final String TX_ERROR = "Unable to complete transaction.";
	public static final String DAO_COMPLETED = "Database transaction completed";
	public static final String DAO_ERROR_FIND = "Unable to find data in the database";
	public static final String DAO_ERROR_SAVE = "Unable to save data to the database";
	
	public String getAuditLog(HttpStatus statusCode, String status, String userName, String classMethod, String statusSource, String details, String auditLog) {
		try {
			AuditLogDO auditLogDO = new AuditLogDO();
			
			auditLogDO.setStatusCode(statusCode);
			auditLogDO.setStatus(status);
			auditLogDO.setUserName(userName);
			auditLogDO.setClassMethod(classMethod);
			auditLogDO.setStatusSource(statusSource);
			auditLogDO.setDetails(details);
			auditLogDO.setCurrentTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
			Gson gson = new Gson();
			auditLog = auditLog.replace("]", "");
			auditLog = auditLog + ", " + gson.toJson(auditLogDO) + "]";
		}
		catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		
		return auditLog;
	}
}
