package com.bluesprucegroup.njrealtors.csvtopdf.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;

public class ReadFileServiceTool {
	private static final Logger log = LogManager.getLogger(ReadFileServiceTool.class);
	public ServiceAccountDataDO readFile(ServiceAccountDataDO serviceAccountDataDO, String userName, String fileDirectory, String fileName, String auditLog) {
		try {
			File file = new File(fileDirectory + fileName);
			FileInputStream fis = new FileInputStream(file);
			//byte[] fileBytes = Files.readAllBytes(file.toPath());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        byte[] buf = new byte[1024];
	        try {
	            for (int readNum; (readNum = fis.read(buf)) != -1;) {
	                bos.write(buf, 0, readNum); //no doubt here is 0
	                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
	                //log.info("read " + readNum + " bytes,");
	            }
	        } catch (IOException e) {
	           // log.error(e.getMessage(), e);
	        }
	        byte[] fileBytes = bos.toByteArray();
	        //serviceAccountDataDO = this.extractPDFDao.saveFile(serviceAccountDataDO, fileBytes);
	        serviceAccountDataDO.setByteArray(fileBytes);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			serviceAccountDataDO.setStatusCode(AuditLogUtil.INTERNAL_SERVER_ERROR);
			serviceAccountDataDO.setStatus(AuditLogUtil.TX_ERROR);
			//serviceAccountDataDO.setAuditLog(this.auditLogUtil.getAuditLog(AuditLogUtil.INTERNAL_SERVER_ERROR, serviceAccountDataDO.getUserName(), this.toString(), 
				//	Thread.currentThread().getStackTrace()[1].getMethodName(), AuditLogUtil.TX_ERROR + " - " + e.getMessage(), serviceAccountDataDO.getAuditLog()));
		}
		
		return serviceAccountDataDO;
	}
	

	public byte[] readFile(String pdfFile) {
		try {
			File file = new File(pdfFile);
			FileInputStream fis = new FileInputStream(file);
			//byte[] fileBytes = Files.readAllBytes(file.toPath());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        byte[] buf = new byte[1024];
	        try {
	            for (int readNum; (readNum = fis.read(buf)) != -1;) {
	                bos.write(buf, 0, readNum); //no doubt here is 0
	                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
	                //log.info("read " + readNum + " bytes,");
	            }
	        } catch (IOException e) {
	           log.error(e.getMessage(), e);
	        }
	        return bos.toByteArray();
	        //serviceAccountDataDO = this.extractPDFDao.saveFile(serviceAccountDataDO, fileBytes);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			//serviceAccountDataDO.setAuditLog(this.auditLogUtil.getAuditLog(AuditLogUtil.INTERNAL_SERVER_ERROR, serviceAccountDataDO.getUserName(), this.toString(), 
				//	Thread.currentThread().getStackTrace()[1].getMethodName(), AuditLogUtil.TX_ERROR + " - " + e.getMessage(), serviceAccountDataDO.getAuditLog()));
		}
		
		return null;
	}
	
	public ServiceAccountDataDO learnFileCoordinates(ServiceAccountDataDO serviceAccountDataDO, int startPageNumber, int endPageNumber, String password) {
		try {
			
			PDDocument pdDocument = null;
			if(password.length() > 1) {
				pdDocument = PDDocument.load(serviceAccountDataDO.getByteArray(), password);
				//log.info("Using password to decrypt PDF");
			} else {
				pdDocument = PDDocument.load(serviceAccountDataDO.getByteArray());
				//log.info("NOT Using password to decrypt PDF");
			}
			
			StringBuffer sb = new StringBuffer();
			float pdfVersion = pdDocument.getDocument().getVersion();
			PDDocumentInformation pdDocumentInformation = pdDocument.getDocumentInformation();
			
			sb.append("Author=" + pdDocumentInformation.getAuthor());
			sb.append("&Creator=" + pdDocumentInformation.getCreator());
			sb.append("&Producer=" + pdDocumentInformation.getProducer());
			sb.append("&Title=" + pdDocumentInformation.getTitle());
			sb.append("&Subject=" + pdDocumentInformation.getSubject());
			sb.append("&PDFVersion=" + pdfVersion);
			
			//log.warn("PDDocumentInformation.ApplicationName: " + sb.toString());
			
			
			//Map<String, List<TextPositionDO>> cMap = new ConcurrentHashMap<String, List<TextPositionDO>>(2);
			//Map<String, List<TextPositionDO>> map = pdDocumentUtil.findLabelCoordinates(pdDocument, serviceAccountDataDO.getFileName(), 0, 1, extractPDFDao, cMap);
			
			//int startPageNumber = 0;
			//int startPageNumber = pdDocument.getPages().getCount();
			//int endPageNumber = 0;
			//Map<String, PDDocumentCoordinatesDO> pdDocumentCoordinatesMap = ;
		
			//public void  findLabelCoordinates(PDDocument pdDocument, String fileName, int startPage, int endPage, ExtractPDFDao extractPDFDao, Map<String, PDDocumentCoordinatesDO> pdDocumentCoordinatesDOMap, String uuid) throws IOException	{
			UUID uuid = UUID.randomUUID();
			
			//pdDocumentUtil.findPDDocumentCoordinates(pdDocument, serviceAccountDataDO.getFileName(), startPageNumber, endPageNumber, extractPDFDao, new HashMap<String, PDDocumentCoordinatesDO>(), uuid.toString());
			//@SuppressWarnings("unused")
			//Map<String, PDDocumentCoordinatesDO> pdDocumentCoordinatesDOMap = findPDDocumentCoordinates(pdDocument, serviceAccountDataDO.getFileName(), startPageNumber, endPageNumber, extractPDFDao, new HashMap<String, PDDocumentCoordinatesDO>(), uuid.toString());
			//findPDDocumentCoordinates(serviceAccountDataDO, pdDocument, serviceAccountDataDO.getFileName(), sb.toString(), startPageNumber, endPageNumber, extractPDFDao, new HashMap<String, PDDocumentCoordinatesDO>(), uuid.toString());
			
			//log.info("End Transaction: pdDocumentUtil.findPDDocumentCoordinates()");
			//Map<String, List<TextPositionDO>> textPositionDOMap = gc.getTextPositionDOMap();
			//Map<String, List<TextPositionDO>> textPositionDOMap = GetCharLocationAndSize.
			
		} catch(Exception e) {
			//log.error(e.getMessage(), e);
			serviceAccountDataDO.setStatusCode(AuditLogUtil.INTERNAL_SERVER_ERROR);
			serviceAccountDataDO.setStatus(AuditLogUtil.TX_ERROR);
			//serviceAccountDataDO.setAuditLog(this.auditLogUtil.getAuditLog(AuditLogUtil.INTERNAL_SERVER_ERROR, serviceAccountDataDO.getUserName(), this.toString(), 
				//	Thread.currentThread().getStackTrace()[1].getMethodName(), AuditLogUtil.TX_ERROR + " - " + e.getMessage(), serviceAccountDataDO.getAuditLog()));
		}
		return serviceAccountDataDO;
	}
}
