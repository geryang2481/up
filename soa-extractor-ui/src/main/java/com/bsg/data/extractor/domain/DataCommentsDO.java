package com.bsg.data.extractor.domain;

public class DataCommentsDO {
	private String custDocID;
	private String comment;
	private String comDate;
	private String lastName;
	private String firstName;
	private String taxID;
	private String item;
	
	public String getCustDocID() {
		return custDocID;
	}
	public void setCustDocID(String custDocID) {
		this.custDocID = custDocID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getComDate() {
		return comDate;
	}
	public void setComDate(String comDate) {
		this.comDate = comDate;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
}
