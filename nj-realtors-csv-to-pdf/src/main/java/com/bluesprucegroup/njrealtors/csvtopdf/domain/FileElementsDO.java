package com.bluesprucegroup.njrealtors.csvtopdf.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class FileElementsDO {
	private BigDecimal fileElementsID;	
	private byte[] elements;
	private String uuid;
	//Encrypted fields
	//00-FileType	01-Year	02-Version	03-PageNo-2	04-OutputField	05-LabelID	06-isImport	07-RowType	08-ColumnType	09-XY_MINMAX	10-ElementKV	
	//11-HashText01	12-HashText02	13-HashText03	14-LineTxtNo	15-LineTxt	16-StartX	17-StartY	18-StartW	19-StartH	20-EndX	
	//21-EndY	22-EndW	23-EndH	24-FileItemID	25-FileFeaturesID	26-Unicode	27-Label	28-isForceNeg	29-Info	30-Value	31-Description 
	private String version;
	private String fileType;
	private String year;
	private String pageNo; 
	private String outputField;
	private String labelID;	
	private boolean isImport;
	private String rowType;
	private String columnType;
	private String xyMinMax ;
	private String elementKV;
	private String hashText01;
	private String hashText02;
	private String hashText03;
	private String lineTxtNo;
	private String lineTxt;
	private float startX;
	private float startY;	
	private float startW;	
	private float startH;
	private float endX;
	private float endY;
	private float endW;
	private float endH;
	private String fileItemID;
	private BigDecimal fileFeaturesID;	
	private String unicode;	
	private String label;
	private boolean isForceNeg;
	private String info;
	private String value;	
	private String description;
	
	public BigDecimal getFileElementsID() {
		return fileElementsID;
	}
	public void setFileElementsID(BigDecimal fileElementsID) {
		this.fileElementsID = fileElementsID;
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

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getOutputField() {
		return outputField;
	}
	public void setOutputField(String outputField) {
		this.outputField = outputField;
	}
	public String getLabelID() {
		return labelID;
	}
	public void setLabelID(String labelID) {
		this.labelID = labelID;
	}
	public boolean isImport() {
		return isImport;
	}
	public void setImport(boolean isImport) {
		this.isImport = isImport;
	}
	public String getRowType() {
		return rowType;
	}
	public void setRowType(String rowType) {
		this.rowType = rowType;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getXyMinMax() {
		return xyMinMax;
	}
	public void setXyMinMax(String xyMinMax) {
		this.xyMinMax = xyMinMax;
	}
	public String getElementKV() {
		return elementKV;
	}
	public void setElementKV(String elementKV) {
		this.elementKV = elementKV;
	}
	public String getHashText01() {
		return hashText01;
	}
	public void setHashText01(String hashText01) {
		this.hashText01 = hashText01;
	}
	public String getHashText02() {
		return hashText02;
	}
	public void setHashText02(String hashText02) {
		this.hashText02 = hashText02;
	}
	public String getHashText03() {
		return hashText03;
	}
	public void setHashText03(String hashText03) {
		this.hashText03 = hashText03;
	}
	public String getLineTxtNo() {
		return lineTxtNo;
	}
	public void setLineTxtNo(String lineTxtNo) {
		this.lineTxtNo = lineTxtNo;
	}
	public String getLineTxt() {
		return lineTxt;
	}
	public void setLineTxt(String lineTxt) {
		this.lineTxt = lineTxt;
	}
	public float getStartX() {
		return startX;
	}
	public void setStartX(float startX) {
		this.startX = startX;
	}
	public float getStartY() {
		return startY;
	}
	public void setStartY(float startY) {
		this.startY = startY;
	}
	public float getStartW() {
		return startW;
	}
	public void setStartW(float startW) {
		this.startW = startW;
	}
	public float getStartH() {
		return startH;
	}
	public void setStartH(float startH) {
		this.startH = startH;
	}
	public float getEndX() {
		return endX;
	}
	public void setEndX(float endX) {
		this.endX = endX;
	}
	public float getEndY() {
		return endY;
	}
	public void setEndY(float endY) {
		this.endY = endY;
	}
	public float getEndW() {
		return endW;
	}
	public void setEndW(float endW) {
		this.endW = endW;
	}
	public float getEndH() {
		return endH;
	}
	public void setEndH(float endH) {
		this.endH = endH;
	}
	public String getFileItemID() {
		return fileItemID;
	}
	public void setFileItemID(String fileItemID) {
		this.fileItemID = fileItemID;
	}
	public BigDecimal getFileFeaturesID() {
		return fileFeaturesID;
	}
	public void setFileFeaturesID(BigDecimal fileFeaturesID) {
		this.fileFeaturesID = fileFeaturesID;
	}
	public String getUnicode() {
		return unicode;
	}
	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isForceNeg() {
		return isForceNeg;
	}
	public void setForceNeg(boolean isForceNeg) {
		this.isForceNeg = isForceNeg;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = StringUtils.isEmpty(this.info) ? info : this.info + info;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}