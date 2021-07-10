package com.bluesprucegroup.njrealtors.csvtopdf.elements;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.FileElementsDO;
import com.bluesprucegroup.njrealtors.csvtopdf.elements.value.FormNJRLPD_2019;

public class ElementsNjrlpd {
	private static final Logger log = LogManager.getLogger(ElementsNjrlpd.class);
	
	public static final String OFL_NJRLPD_P1L10_PROPERTYADDRESS1_VALUE = "NJRLPD_P1L10_PROPERTYADDRESS1_VALUE";
	public static final String OFL_NJRLPD_P1L11_PROPERTYADDRESS2_VALUE = "NJRLPD_P1L11_PROPERTYADDRESS2_VALUE";
	public static final String OFL_NJRLPD_P1L14_III_A_INITIALS_VALUE = "NJRLPD_P1L14_III_A_INITIALS_VALUE";
	public static final String OFL_NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE = "NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE";
	public static final String OFL_NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE = "NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE";
	public static final String OFL_NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE = "NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE";
	public static final String OFL_NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE = "NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE";
	public static final String OFL_NJRLPD_P1L21_III_B_INITIALS_VALUE = "NJRLPD_P1L21_III_B_INITIALS_VALUE";
	public static final String OFL_NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE = "NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE";
	public static final String OFL_NJRLPD_P1L23_SELLERHASREPORTS_VALUE = "NJRLPD_P1L23_SELLERHASREPORTS_VALUE";
	public static final String OFL_NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE = "NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE";
	public static final String OFL_NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE = "NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE";
	public static final String OFL_NJRLPD_P1L30_III_C_INITIALS_VALUE = "NJRLPD_P1L30_III_C_INITIALS_VALUE";
	public static final String OFL_NJRLPD_P1L37_SELLERNAME1_VALUE = "NJRLPD_P1L37_SELLERNAME1_VALUE";
	public static final String OFL_NJRLPD_P1L37_SELLERDATE1_VALUE = "NJRLPD_P1L37_SELLERDATE1_VALUE";
	public static final String OFL_NJRLPD_P1L37_SELLERNAME2_VALUE = "NJRLPD_P1L37_SELLERNAME2_VALUE";
	public static final String OFL_NJRLPD_P1L37_SELLERDATE2_VALUE = "NJRLPD_P1L37_SELLERDATE2_VALUE";
	public static final String OFL_NJRLPD_P1L39_SELLERNAME3_VALUE = "NJRLPD_P1L39_SELLERNAME3_VALUE";
	public static final String OFL_NJRLPD_P1L39_SELLERDATE3_VALUE = "NJRLPD_P1L39_SELLERDATE3_VALUE";
	public static final String OFL_NJRLPD_P1L39_SELLERNAME4_VALUE = "NJRLPD_P1L39_SELLERNAME4_VALUE";
	public static final String OFL_NJRLPD_P1L39_SELLERDATE4_VALUE = "NJRLPD_P1L39_SELLERDATE4_VALUE";
	public static final String OFL_NJRLPD_P1L45_LISTINGAGENTNAME_VALUE = "NJRLPD_P1L45_LISTINGAGENTNAME_VALUE";
	public static final String OFL_NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE = "NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE";
	public static final String OFL_NJRLPD_P1L50_VI_A_INITIALS_VALUE = "NJRLPD_P1L50_VI_A_INITIALS_VALUE";
	public static final String OFL_NJRLPD_P1L52_VI_B_INITIALS_VALUE = "NJRLPD_P1L52_VI_B_INITIALS_VALUE";
	public static final String OFL_NJRLPD_P2L57_VI_C_INITIALS_VALUE = "NJRLPD_P2L57_VI_C_INITIALS_VALUE";
	public static final String OFL_NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE = "NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE";
	public static final String OFL_NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE = "NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE";
	public static final String OFL_NJRLPD_P2L67_PURCHASERNAME1_VALUE = "NJRLPD_P2L67_PURCHASERNAME1_VALUE";
	public static final String OFL_NJRLPD_P2L67_PURCHASERDATE1_VALUE = "NJRLPD_P2L67_PURCHASERDATE1_VALUE";
	public static final String OFL_NJRLPD_P2L67_PURCHASERNAME2_VALUE = "NJRLPD_P2L67_PURCHASERNAME2_VALUE";
	public static final String OFL_NJRLPD_P2L67_PURCHASERDATE2_VALUE = "NJRLPD_P2L67_PURCHASERDATE2_VALUE";
	public static final String OFL_NJRLPD_P2L69_PURCHASERNAME3_VALUE = "NJRLPD_P2L69_PURCHASERNAME3_VALUE";
	public static final String OFL_NJRLPD_P2L69_PURCHASERDATE3_VALUE = "NJRLPD_P2L69_PURCHASERDATE3_VALUE";
	public static final String OFL_NJRLPD_P2L69_PURCHASERNAME4_VALUE = "NJRLPD_P2L69_PURCHASERNAME4_VALUE";
	public static final String OFL_NJRLPD_P2L69_PURCHASERDATE4_VALUE = "NJRLPD_P2L69_PURCHASERDATE4_VALUE";
	public static final String OFL_NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE = "NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE";
	public static final String OFL_NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE = "NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE";
	
	public static FileElementsDO[] getFileElements(FileElementsDO[] fileElements, String year) {
		try {
			String[] elements = getElements(year);
			fileElements = new FileElementsDO[elements.length];
			for(int i = 0; i < elements.length; i++) {
				String row = elements[i];
				String[] element = StringUtils.split(row, "\t");
				FileElementsDO fileElementsDO = new FileElementsDO();
				fileElementsDO.setFileType(element[0]);
				fileElementsDO.setYear(String.valueOf(element[1]));
				fileElementsDO.setVersion(String.valueOf(element[2]));
				fileElementsDO.setPageNo(String.valueOf(element[3]));
				fileElementsDO.setOutputField(element[4]);
				fileElementsDO.setLabelID(element[5]);
				fileElementsDO.setImport(element[6].equals("0") ? true : false);
				fileElementsDO.setRowType(element[7]);
				fileElementsDO.setColumnType(element[8]);
				fileElementsDO.setXyMinMax(element[9]);
				fileElementsDO.setElementKV(element[10]);
				fileElementsDO.setHashText01(element[11]);
				fileElementsDO.setHashText02(element[12]);
				fileElementsDO.setHashText03(element[13]);
				fileElementsDO.setLineTxtNo(element[14]);
				fileElementsDO.setLineTxt(element[15]);
				fileElementsDO.setStartX(Float.valueOf(element[16]));
				fileElementsDO.setStartY(Float.valueOf(element[17]));
				fileElementsDO.setStartW(Float.valueOf(element[18]));
				fileElementsDO.setStartH(Float.valueOf(element[19]));
				fileElementsDO.setEndX(Float.valueOf(element[20]));
				fileElementsDO.setEndY(Float.valueOf(element[21]));
				fileElementsDO.setEndW(Float.valueOf(element[22]));
				fileElementsDO.setEndH(Float.valueOf(element[23]));
				fileElementsDO.setFileItemID("0");//(element[24]
				fileElementsDO.setFileFeaturesID(new BigDecimal(Integer.valueOf(element[25])));
				fileElementsDO.setUnicode(element[26]);
				fileElementsDO.setLabel(element[27]);
				fileElementsDO.setForceNeg(element[28].equals("0") ? true : false);
				fileElementsDO.setInfo(element[29]);
				fileElementsDO.setValue(element[30]);
				fileElementsDO.setDescription(element[31]);
				fileElements[i] = fileElementsDO;
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return fileElements;
	}

	private static String[] getElements(String year) {
		String[] elements =  null;
		switch(year) {
			default:
				elements = FormNJRLPD_2019.getTsvFileElements();
				break;
		}
		return elements;
	}
}
