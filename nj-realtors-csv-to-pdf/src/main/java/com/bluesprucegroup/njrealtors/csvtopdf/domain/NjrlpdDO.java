package com.bluesprucegroup.njrealtors.csvtopdf.domain;

public class NjrlpdDO {
	//Application data
	private String uuid;
	private String quickEntryName;
	private String quickEntryDescription;
	private String quickEntryID;
	private final String fileType = "NJRLPD";
	private boolean isExist;
	//Object data
	private String p1l10_propertyAddress1;
	private String p1l11_propertyAddress2;
	private String p1l14_iii_a_initials;
	private String p1l15_knownLeadBasedPaint;
	private String p1l16_knownLeadBasedPaintExp1;
	private String p1l17_knownLeadBasedPaintExp2;
	private String p1l19_sellerNoKnowledge;
	private String p1l121_iii_b_initials;
	private String p1l22_sellerHasNoReports;
	private String p1l23_sellerHasReports;
	private String p1l27_sellerHasReportsDoc1;
	private String p1l28_sellerHasReportsDoc2;
	private String p1l30_iii_c_initials;
	private String p1l37_sellerName1;
	private String p1l37_sellerDate1;
	private String p1l37_sellerName2;
	private String p1l37_sellerDate2;
	private String p1l39_sellerName3;
	private String p1l39_sellerDate3;
	private String p1l39_sellerName4;
	private String p1l39_sellerDate4;
	private String p1l45_listingAgentName;
	private String p1l45_listingAgentNameDate;
	private String p1l50_vi_a_initials;
	private String p1l52_vi_b_initials;
	private String p2l57_vi_c_initials;
	private String p2l58_received10days;
	private String p2l60_waivedOppurtunity;
	private String p2l67_purchaserName1;
	private String p2l67_purchaserDate1;
	private String p2l67_purchaserName2;
	private String p2l67_purchaserDate2;
	private String p2l69_purchaserName3;
	private String p2l69_purchaserDate3;
	private String p2l69_purchaserName4;
	private String p2l69_purchaserDate4;
	private String p2l74_sellingByAgentName;
	private String p2l75_sellingByAgentNameDate;
	
	//Application data
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getQuickEntryName() {
		return quickEntryName;
	}
	public void setQuickEntryName(String quickEntryName) {
		this.quickEntryName = quickEntryName;
	}
	public String getQuickEntryDescription() {
		return quickEntryDescription;
	}
	public void setQuickEntryDescription(String quickEntryDescription) {
		this.quickEntryDescription = quickEntryDescription;
	}
	public String getQuickEntryID() {
		return quickEntryID;
	}
	public void setQuickEntryID(String quickEntryID) {
		this.quickEntryID = quickEntryID;
	}
	public boolean isExist() {
		return isExist;
	}
	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	public String getFileType() {
		return fileType;
	}
	
	//Object data
	
	public String getP1l10_propertyAddress1() {
		return p1l10_propertyAddress1;
	}
	public void setP1l10_propertyAddress1(String p1l10_propertyAddress1) {
		this.p1l10_propertyAddress1 = p1l10_propertyAddress1;
	}
	public String getP1l11_propertyAddress2() {
		return p1l11_propertyAddress2;
	}
	public void setP1l11_propertyAddress2(String p1l11_propertyAddress2) {
		this.p1l11_propertyAddress2 = p1l11_propertyAddress2;
	}
	public String getP1l14_iii_a_initials() {
		return p1l14_iii_a_initials;
	}
	public void setP1l14_iii_a_initials(String p1l14_iii_a_initials) {
		this.p1l14_iii_a_initials = p1l14_iii_a_initials;
	}
	public String getP1l15_knownLeadBasedPaint() {
		return p1l15_knownLeadBasedPaint;
	}
	public void setP1l15_knownLeadBasedPaint(String p1l15_knownLeadBasedPaint) {
		this.p1l15_knownLeadBasedPaint = p1l15_knownLeadBasedPaint;
	}
	public String getP1l16_knownLeadBasedPaintExp1() {
		return p1l16_knownLeadBasedPaintExp1;
	}
	public void setP1l16_knownLeadBasedPaintExp1(String p1l16_knownLeadBasedPaintExp1) {
		this.p1l16_knownLeadBasedPaintExp1 = p1l16_knownLeadBasedPaintExp1;
	}
	public String getP1l17_knownLeadBasedPaintExp2() {
		return p1l17_knownLeadBasedPaintExp2;
	}
	public void setP1l17_knownLeadBasedPaintExp2(String p1l17_knownLeadBasedPaintExp2) {
		this.p1l17_knownLeadBasedPaintExp2 = p1l17_knownLeadBasedPaintExp2;
	}
	public String getP1l19_sellerNoKnowledge() {
		return p1l19_sellerNoKnowledge;
	}
	public void setP1l19_sellerNoKnowledge(String p1l19_sellerNoKnowledge) {
		this.p1l19_sellerNoKnowledge = p1l19_sellerNoKnowledge;
	}
	public String getP1l121_iii_b_initials() {
		return p1l121_iii_b_initials;
	}
	public void setP1l121_iii_b_initials(String p1l121_iii_b_initials) {
		this.p1l121_iii_b_initials = p1l121_iii_b_initials;
	}
	public String getP1l22_sellerHasNoReports() {
		return p1l22_sellerHasNoReports;
	}
	public void setP1l22_sellerHasNoReports(String p1l22_sellerHasNoReports) {
		this.p1l22_sellerHasNoReports = p1l22_sellerHasNoReports;
	}
	public String getP1l23_sellerHasReports() {
		return p1l23_sellerHasReports;
	}
	public void setP1l23_sellerHasReports(String p1l23_sellerHasReports) {
		this.p1l23_sellerHasReports = p1l23_sellerHasReports;
	}
	public String getP1l27_sellerHasReportsDoc1() {
		return p1l27_sellerHasReportsDoc1;
	}
	public void setP1l27_sellerHasReportsDoc1(String p1l27_sellerHasReportsDoc1) {
		this.p1l27_sellerHasReportsDoc1 = p1l27_sellerHasReportsDoc1;
	}
	public String getP1l28_sellerHasReportsDoc2() {
		return p1l28_sellerHasReportsDoc2;
	}
	public void setP1l28_sellerHasReportsDoc2(String p1l28_sellerHasReportsDoc2) {
		this.p1l28_sellerHasReportsDoc2 = p1l28_sellerHasReportsDoc2;
	}
	public String getP1l30_iii_c_initials() {
		return p1l30_iii_c_initials;
	}
	public void setP1l30_iii_c_initials(String p1l30_iii_c_initials) {
		this.p1l30_iii_c_initials = p1l30_iii_c_initials;
	}
	public String getP1l37_sellerName1() {
		return p1l37_sellerName1;
	}
	public void setP1l37_sellerName1(String p1l37_sellerName1) {
		this.p1l37_sellerName1 = p1l37_sellerName1;
	}
	public String getP1l37_sellerDate1() {
		return p1l37_sellerDate1;
	}
	public void setP1l37_sellerDate1(String p1l37_sellerDate1) {
		this.p1l37_sellerDate1 = p1l37_sellerDate1;
	}
	public String getP1l37_sellerName2() {
		return p1l37_sellerName2;
	}
	public void setP1l37_sellerName2(String p1l37_sellerName2) {
		this.p1l37_sellerName2 = p1l37_sellerName2;
	}
	public String getP1l37_sellerDate2() {
		return p1l37_sellerDate2;
	}
	public void setP1l37_sellerDate2(String p1l37_sellerDate2) {
		this.p1l37_sellerDate2 = p1l37_sellerDate2;
	}
	public String getP1l39_sellerName3() {
		return p1l39_sellerName3;
	}
	public void setP1l39_sellerName3(String p1l39_sellerName3) {
		this.p1l39_sellerName3 = p1l39_sellerName3;
	}
	public String getP1l39_sellerDate3() {
		return p1l39_sellerDate3;
	}
	public void setP1l39_sellerDate3(String p1l39_sellerDate3) {
		this.p1l39_sellerDate3 = p1l39_sellerDate3;
	}
	public String getP1l39_sellerName4() {
		return p1l39_sellerName4;
	}
	public void setP1l39_sellerName4(String p1l39_sellerName4) {
		this.p1l39_sellerName4 = p1l39_sellerName4;
	}
	public String getP1l39_sellerDate4() {
		return p1l39_sellerDate4;
	}
	public void setP1l39_sellerDate4(String p1l39_sellerDate4) {
		this.p1l39_sellerDate4 = p1l39_sellerDate4;
	}
	public String getP1l45_listingAgentName() {
		return p1l45_listingAgentName;
	}
	public void setP1l45_listingAgentName(String p1l45_listingAgentName) {
		this.p1l45_listingAgentName = p1l45_listingAgentName;
	}
	public String getP1l45_listingAgentNameDate() {
		return p1l45_listingAgentNameDate;
	}
	public void setP1l45_listingAgentNameDate(String p1l45_listingAgentNameDate) {
		this.p1l45_listingAgentNameDate = p1l45_listingAgentNameDate;
	}
	public String getP1l50_vi_a_initials() {
		return p1l50_vi_a_initials;
	}
	public void setP1l50_vi_a_initials(String p1l50_vi_a_initials) {
		this.p1l50_vi_a_initials = p1l50_vi_a_initials;
	}
	public String getP1l52_vi_b_initials() {
		return p1l52_vi_b_initials;
	}
	public void setP1l52_vi_b_initials(String p1l52_vi_b_initials) {
		this.p1l52_vi_b_initials = p1l52_vi_b_initials;
	}
	public String getP2l57_vi_c_initials() {
		return p2l57_vi_c_initials;
	}
	public void setP2l57_vi_c_initials(String p2l57_vi_c_initials) {
		this.p2l57_vi_c_initials = p2l57_vi_c_initials;
	}
	public String getP2l58_received10days() {
		return p2l58_received10days;
	}
	public void setP2l58_received10days(String p2l58_received10days) {
		this.p2l58_received10days = p2l58_received10days;
	}
	public String getP2l60_waivedOppurtunity() {
		return p2l60_waivedOppurtunity;
	}
	public void setP2l60_waivedOppurtunity(String p2l60_waivedOppurtunity) {
		this.p2l60_waivedOppurtunity = p2l60_waivedOppurtunity;
	}
	public String getP2l67_purchaserName1() {
		return p2l67_purchaserName1;
	}
	public void setP2l67_purchaserName1(String p2l67_purchaserName1) {
		this.p2l67_purchaserName1 = p2l67_purchaserName1;
	}
	public String getP2l67_purchaserDate1() {
		return p2l67_purchaserDate1;
	}
	public void setP2l67_purchaserDate1(String p2l67_purchaserDate1) {
		this.p2l67_purchaserDate1 = p2l67_purchaserDate1;
	}
	public String getP2l67_purchaserName2() {
		return p2l67_purchaserName2;
	}
	public void setP2l67_purchaserName2(String p2l67_purchaserName2) {
		this.p2l67_purchaserName2 = p2l67_purchaserName2;
	}
	public String getP2l67_purchaserDate2() {
		return p2l67_purchaserDate2;
	}
	public void setP2l67_purchaserDate2(String p2l67_purchaserDate2) {
		this.p2l67_purchaserDate2 = p2l67_purchaserDate2;
	}
	public String getP2l69_purchaserName3() {
		return p2l69_purchaserName3;
	}
	public void setP2l69_purchaserName3(String p2l69_purchaserName3) {
		this.p2l69_purchaserName3 = p2l69_purchaserName3;
	}
	public String getP2l69_purchaserDate3() {
		return p2l69_purchaserDate3;
	}
	public void setP2l69_purchaserDate3(String p2l69_purchaserDate3) {
		this.p2l69_purchaserDate3 = p2l69_purchaserDate3;
	}
	public String getP2l69_purchaserName4() {
		return p2l69_purchaserName4;
	}
	public void setP2l69_purchaserName4(String p2l69_purchaserName4) {
		this.p2l69_purchaserName4 = p2l69_purchaserName4;
	}
	public String getP2l69_purchaserDate4() {
		return p2l69_purchaserDate4;
	}
	public void setP2l69_purchaserDate4(String p2l69_purchaserDate4) {
		this.p2l69_purchaserDate4 = p2l69_purchaserDate4;
	}
	public String getP2l74_sellingByAgentName() {
		return p2l74_sellingByAgentName;
	}
	public void setP2l74_sellingByAgentName(String p2l74_sellingByAgentName) {
		this.p2l74_sellingByAgentName = p2l74_sellingByAgentName;
	}
	public String getP2l75_sellingByAgentNameDate() {
		return p2l75_sellingByAgentNameDate;
	}
	public void setP2l75_sellingByAgentNameDate(String p2l75_sellingByAgentNameDate) {
		this.p2l75_sellingByAgentNameDate = p2l75_sellingByAgentNameDate;
	}
	
	
	
}
