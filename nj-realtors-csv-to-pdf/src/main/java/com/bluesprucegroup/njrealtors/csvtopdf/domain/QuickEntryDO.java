package com.bluesprucegroup.njrealtors.csvtopdf.domain;

import java.math.BigDecimal;

public class QuickEntryDO {
	private BigDecimal quickEntryID;
	private String fileTypeID;
	private String name;
	private String description;
	private byte[] elements;
	private String uuid;
	public BigDecimal getQuickEntryID() {
		return quickEntryID;
	}
	public void setQuickEntryID(BigDecimal quickEntryID) {
		this.quickEntryID = quickEntryID;
	}
	
	public String getFileTypeID() {
		return fileTypeID;
	}
	public void setFileTypeID(String fileTypeID) {
		this.fileTypeID = fileTypeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getElements() {
		return elements;
	}
	public void setElements(byte[] elements) {
		this.elements = elements;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
