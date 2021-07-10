package com.bluesprucegroup.njrealtors.csvtopdf.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.TextPosition;
import org.springframework.http.HttpStatus;

public class ServiceAccountDataDO implements Serializable  {
	
	private static final long serialVersionUID = 6085747413464672451L;
	private PDDocument pdDocument;
	private String uuid;
	private BigDecimal TransactionID;
	private BigDecimal exportID;
	private String custID;
	private String guid;
	private String pdfPassword;
	private String userName;
	private byte[] byteArray;
	private String fileName;
	private String fileDirectory;
	private String auditLog;
	private HttpStatus statusCode;
	private String status;
	private String mainFileType;
	private HashMap<String, String> entityNameMap;
	private List<String> scheduleStartPageNoList;
	private List<String> subScheduleList;
	private HashMap<String, ServiceAccountFileItem> serviceAccountFileItemMap;
	
	public HashMap<String, String> getEntityNameMap() {
		return entityNameMap;
	}
	public void setEntityNameMap(HashMap<String, String> entityNameMap) {
		this.entityNameMap = entityNameMap;
	}
	public List<String> getSubScheduleList() {
		return subScheduleList;
	}
	public void setSubScheduleList(List<String> subScheduleList) {
		this.subScheduleList = subScheduleList;
	}
	public String getMainFileType() {
		return mainFileType;
	}
	public void setMainFileType(String mainFileType) {
		this.mainFileType = mainFileType;
	}
	public List<String> getScheduleStartPageNoList() {
		return scheduleStartPageNoList;
	}
	public void setScheduleStartPageNoList(List<String> scheduleStartPageNoList) {
		this.scheduleStartPageNoList = scheduleStartPageNoList;
	}
	public PDDocument getPdDocument() {
		return pdDocument;
	}
	public void setPdDocument(PDDocument pdDocument) {
		this.pdDocument = pdDocument;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public BigDecimal getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(BigDecimal transactionID) {
		TransactionID = transactionID;
	}
	public BigDecimal getExportID() {
		return exportID;
	}
	public void setExportID(BigDecimal exportID) {
		this.exportID = exportID;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getPdfPassword() {
		return pdfPassword;
	}
	public void setPdfPassword(String pdfPassword) {
		this.pdfPassword = pdfPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte[] getByteArray() {
		return byteArray;
	}
	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}
	public String getFileDirectory() {
		return fileDirectory;
	}
	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getAuditLog() {
		return auditLog;
	}
	public void setAuditLog(String auditLog) {
		this.auditLog = auditLog;
	}
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
	
	public HashMap<String, ServiceAccountFileItem> getServiceAccountFileItemMap() {
		return serviceAccountFileItemMap;
	}
	public void setServiceAccountFileItemMap(HashMap<String, ServiceAccountFileItem> serviceAccountFileItemMap) {
		this.serviceAccountFileItemMap = serviceAccountFileItemMap;
	}
	public ServiceAccountFileItem createServiceAccountFileItem() {
		ServiceAccountFileItem serviceAccountFileItem = new ServiceAccountFileItem();
		return serviceAccountFileItem;
	}
	
	public class ServiceAccountFileItem {
		private TreeMap<Integer, byte[]> compressedTextMap;
		private HashMap<String, TextPosition> xyRowLocationMap;
		private LinkedList<PDPage> pdPagesList;
		private ArrayList<FormScheduleEntityDO> entityList;
		private FormScheduleEntityDO formScheduleEntity;
		private boolean[] fileFlags;
		private byte[] compressedOutput;
		private String fileItemID;
		private String fileApplication;
		private String fileType;
		private String fileYear;
		private String fileOmbNo;
		private String fileStartPageNo;
		private String caTemplateID;
		private String caSpreadID;
		private BigDecimal importID;
		private boolean is8825_P2;
		private boolean isSchE_P2;
		private boolean is1040_2018;
		
		public FormScheduleEntityDO getFormScheduleEntity() {
			return formScheduleEntity;
		}
		public void setFormScheduleEntity(FormScheduleEntityDO formScheduleEntity) {
			this.formScheduleEntity = formScheduleEntity;
		}
		public boolean is8825_P2() {
			return is8825_P2;
		}
		
		public void setIs8825_P2(boolean is8825_P2) {
			this.is8825_P2 = is8825_P2;
		}
		public boolean is1040_2018() {
			return is1040_2018;
		}
		public void set1040_2018(boolean is1040_2018) {
			this.is1040_2018 = is1040_2018;
		}
		public boolean isSchE_P2() {
			return isSchE_P2;
		}
		public void setSchE_P2(boolean isSchE_P2) {
			this.isSchE_P2 = isSchE_P2;
		}
		public ArrayList<FormScheduleEntityDO> getEntityList() {
			return entityList;
		}
		public void setEntityList(ArrayList<FormScheduleEntityDO> entityList) {
			this.entityList = entityList;
		}
		public String getCaTemplateID() {
			return caTemplateID;
		}
		public void setCaTemplateID(String caTemplateID) {
			this.caTemplateID = caTemplateID;
		}
		public String getCaSpreadID() {
			return caSpreadID;
		}
		public void setCaSpreadID(String caSpreadID) {
			this.caSpreadID = caSpreadID;
		}
		public boolean[] getFileFlags() {
			return fileFlags;
		}
		public void setFileFlags(boolean[] fileFlags) {
			this.fileFlags = fileFlags;
		}
		public byte[] getCompressedOutput() {
			return compressedOutput;
		}
		public void setCompressedOutput(byte[] compressedOutput) {
			this.compressedOutput = compressedOutput;
		}
		public String getFileItemID() {
			return fileItemID;
		}
		public void setFileItemID(String fileItemID) {
			this.fileItemID = fileItemID;
		}
		public String getFileApplication() {
			return fileApplication;
		}
		public void setFileApplication(String fileApplication) {
			this.fileApplication = fileApplication;
		}
		
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public String getFileYear() {
			return fileYear;
		}
		public void setFileYear(String fileYear) {
			this.fileYear = fileYear;
		}
		public String getFileOmbNo() {
			return fileOmbNo;
		}
		public void setFileOmbNo(String fileOmbNo) {
			this.fileOmbNo = fileOmbNo;
		}
		public String getFileStartPageNo() {
			return fileStartPageNo;
		}
		public void setFileStartPageNo(String fileStartPageNo) {
			this.fileStartPageNo = fileStartPageNo;
		}
		public BigDecimal getImportID() {
			return importID;
		}
		public void setImportID(BigDecimal importID) {
			this.importID = importID;
		}
		public HashMap<String, TextPosition> getXyRowLocationMap() {
			return xyRowLocationMap;
		}
		public void setXyRowLocationMap(HashMap<String, TextPosition> xyRowLocationMap) {
			this.xyRowLocationMap = xyRowLocationMap;
		}
		public TreeMap<Integer, byte[]> getCompressedTextMap() {
			return compressedTextMap;
		}
		public void setCompressedTextMap(TreeMap<Integer, byte[]> compressedTextMap) {
			this.compressedTextMap = compressedTextMap;
		}
		public LinkedList<PDPage> getPdPagesList() {
			return pdPagesList;
		}
		public void setPdPagesList(LinkedList<PDPage> pdPagesList) {
			this.pdPagesList = pdPagesList;
		}
	}
}
