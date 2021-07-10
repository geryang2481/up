package com.bsg.data.extractor.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankProduct {

    private Integer id;
    private String bankProductName;
    private String bankProductValue;
    private String bankProductDescription;
    private BsgDomain bank;
    private BigDecimal price;
    private List<BankProductCategory> bankProductCategories = new ArrayList<>();
    private String imageUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBankProductName() {
		return bankProductName;
	}
	public void setBankProductName(String bankProductName) {
		this.bankProductName = bankProductName;
	}
	public String getBankProductValue() {
		return bankProductValue;
	}
	public void setBankProductValue(String bankProductValue) {
		this.bankProductValue = bankProductValue;
	}
	public String getBankProductDescription() {
		return bankProductDescription;
	}
	public void setBankProductDescription(String bankProductDescription) {
		this.bankProductDescription = bankProductDescription;
	}
	
	public BsgDomain getBank() {
		return bank;
	}
	public void setBank(BsgDomain bank) {
		this.bank = bank;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public List<BankProductCategory> getBankProductCategories() {
		return bankProductCategories;
	}
	public void setBankProductCategories(List<BankProductCategory> bankProductCategories) {
		this.bankProductCategories = bankProductCategories;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    
}
