package com.bluesprucegroup.njrealtors.csvtopdf.constant;

import org.springframework.stereotype.Component;

@Component
public class HRefModel {
	public final static String COLOR_PINK = "PINK";
	public final static String COLOR_BROWN = "BROWN";
	private String href;
	private String hrefText;
	private String fileTextDesc;
	private String fileTypeID;
	private String color;
	private String path;
	private String uuid;
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HRefModel() {
		
	}
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getHrefText() {
		return hrefText;
	}
	public void setHrefText(String hrefText) {
		this.hrefText = hrefText;
	}
	public String getFileTextDesc() {
		return fileTextDesc;
	}
	public void setFileTextDesc(String fileTextDesc) {
		this.fileTextDesc = fileTextDesc;
	}
	public String getFileTypeID() {
		return fileTypeID;
	}
	public void setFileTypeID(String fileTypeID) {
		this.fileTypeID = fileTypeID;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public static String getColorPink() {
		return COLOR_PINK;
	}
	public static String getColorBrown() {
		return COLOR_BROWN;
	}
	

}
