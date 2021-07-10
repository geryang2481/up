package com.bluesprucegroup.njrealtors.csvtopdf.transformer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.Njr118DO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.NjrlpdDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.QuickEntryDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.WebServiceGzipUtil;
import com.bluesprucegroup.njrealtors.csvtopdf.elements.ElementsCommon;
import com.bluesprucegroup.njrealtors.csvtopdf.elements.ElementsNjr118;
import com.bluesprucegroup.njrealtors.csvtopdf.elements.ElementsNjrlpd;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DataObjectTransformer {
	private static final Logger log = LogManager.getLogger(DataObjectTransformer.class);
	
	public static QuickEntryDO transformFromNjrlpdDO(NjrlpdDO njrlpdDO) {
		QuickEntryDO quickEntryDO = null;
		try {
			if(njrlpdDO != null ) {
				quickEntryDO = new QuickEntryDO();
				Gson gson = new Gson();
				Map<String, String> elements = new HashMap<String, String>();
				if(StringUtils.isEmpty(quickEntryDO.getFileTypeID())) {
					quickEntryDO.setFileTypeID(njrlpdDO.getFileType());
				}
				if(StringUtils.isEmpty(quickEntryDO.getName())) {
					quickEntryDO.setName(njrlpdDO.getQuickEntryName());
				}
				if(StringUtils.isEmpty(quickEntryDO.getDescription())) {
					quickEntryDO.setDescription(njrlpdDO.getQuickEntryDescription());
				}
				if(StringUtils.isEmpty(quickEntryDO.getUuid())) {
					quickEntryDO.setUuid(njrlpdDO.getUuid());
				}
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L10_PROPERTYADDRESS1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l10_propertyAddress1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l10_propertyAddress1());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L11_PROPERTYADDRESS2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l11_propertyAddress2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l11_propertyAddress2());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L14_III_A_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l14_iii_a_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l14_iii_a_initials());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l15_knownLeadBasedPaint()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l15_knownLeadBasedPaint());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l16_knownLeadBasedPaintExp1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l16_knownLeadBasedPaintExp1());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l17_knownLeadBasedPaintExp2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l17_knownLeadBasedPaintExp2());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l19_sellerNoKnowledge()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l19_sellerNoKnowledge());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L21_III_B_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l121_iii_b_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l121_iii_b_initials());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l22_sellerHasNoReports()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l22_sellerHasNoReports());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L23_SELLERHASREPORTS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l23_sellerHasReports()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l23_sellerHasReports());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l27_sellerHasReportsDoc1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l27_sellerHasReportsDoc1());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l28_sellerHasReportsDoc2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l28_sellerHasReportsDoc2());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L30_III_C_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l30_iii_c_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l30_iii_c_initials());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l37_sellerName1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l37_sellerName1());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l37_sellerDate1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l37_sellerDate1());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l37_sellerName2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l37_sellerName2());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l37_sellerDate2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l37_sellerDate2());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME3_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l39_sellerName3()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l39_sellerName3());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE3_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l39_sellerDate3()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l39_sellerDate3());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME4_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l39_sellerName4()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l39_sellerName4());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE4_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l39_sellerDate4()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l39_sellerDate4());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAME_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l45_listingAgentName()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l45_listingAgentName());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l45_listingAgentNameDate()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l45_listingAgentNameDate());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L50_VI_A_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l50_vi_a_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l50_vi_a_initials());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L52_VI_B_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l52_vi_b_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l52_vi_b_initials());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L57_VI_C_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l57_vi_c_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l57_vi_c_initials());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l58_received10days()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l58_received10days());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l60_waivedOppurtunity()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l60_waivedOppurtunity());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME1_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l67_purchaserName1()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l67_purchaserName1());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE1_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l67_purchaserDate1()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l67_purchaserDate1());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME2_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l67_purchaserName2()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l67_purchaserName2());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE2_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l67_purchaserDate2()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l67_purchaserDate2());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME3_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l69_purchaserName3()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l69_purchaserName3());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE3_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l69_purchaserDate3()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l69_purchaserDate3());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME4_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l69_purchaserName4()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l69_purchaserName4());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE4_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l69_purchaserDate4()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l69_purchaserDate4());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l74_sellingByAgentName()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l74_sellingByAgentName());
				elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l75_sellingByAgentNameDate()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l75_sellingByAgentNameDate());
				byte[] elementsBytes = WebServiceGzipUtil.compress(gson.toJson(elements));
				quickEntryDO.setElements(elementsBytes);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return quickEntryDO;
	}
	
	public static List<QuickEntryDO> transformFromNjrlpdDO(List<NjrlpdDO> njrlpdDOList) {
		List<QuickEntryDO> quickEntryDOList = null;
		try {
			if(njrlpdDOList != null || njrlpdDOList.size() > 0) {
				quickEntryDOList = new ArrayList<QuickEntryDO>();
				Gson gson = new Gson();
				for(NjrlpdDO njrlpdDO : njrlpdDOList) {
					QuickEntryDO quickEntryDO = new QuickEntryDO();
					Map<String, String> elements = new HashMap<String, String>();
					
					if(StringUtils.isEmpty(quickEntryDO.getFileTypeID())) {
						quickEntryDO.setFileTypeID(njrlpdDO.getFileType());
					}
					if(StringUtils.isEmpty(quickEntryDO.getName())) {
						quickEntryDO.setName(njrlpdDO.getQuickEntryName());
					}
					if(StringUtils.isEmpty(quickEntryDO.getDescription())) {
						quickEntryDO.setDescription(njrlpdDO.getQuickEntryDescription());
					}
					if(StringUtils.isEmpty(quickEntryDO.getUuid())) {
						quickEntryDO.setUuid(njrlpdDO.getUuid());
					}
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L10_PROPERTYADDRESS1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l10_propertyAddress1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l10_propertyAddress1());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L11_PROPERTYADDRESS2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l11_propertyAddress2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l11_propertyAddress2());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L14_III_A_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l14_iii_a_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l14_iii_a_initials());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l15_knownLeadBasedPaint()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l15_knownLeadBasedPaint());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l16_knownLeadBasedPaintExp1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l16_knownLeadBasedPaintExp1());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l17_knownLeadBasedPaintExp2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l17_knownLeadBasedPaintExp2());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l19_sellerNoKnowledge()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l19_sellerNoKnowledge());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L21_III_B_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l121_iii_b_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l121_iii_b_initials());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l22_sellerHasNoReports()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l22_sellerHasNoReports());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L23_SELLERHASREPORTS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l23_sellerHasReports()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l23_sellerHasReports());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l27_sellerHasReportsDoc1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l27_sellerHasReportsDoc1());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l28_sellerHasReportsDoc2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l28_sellerHasReportsDoc2());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L30_III_C_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l30_iii_c_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l30_iii_c_initials());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l37_sellerName1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l37_sellerName1());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE1_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l37_sellerDate1()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l37_sellerDate1());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l37_sellerName2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l37_sellerName2());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE2_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l37_sellerDate2()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l37_sellerDate2());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME3_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l39_sellerName3()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l39_sellerName3());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE3_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l39_sellerDate3()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l39_sellerDate3());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME4_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l39_sellerName4()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l39_sellerName4());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE4_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l39_sellerDate4()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l39_sellerDate4());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAME_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l45_listingAgentName()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l45_listingAgentName());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l45_listingAgentNameDate()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l45_listingAgentNameDate());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L50_VI_A_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l50_vi_a_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l50_vi_a_initials());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P1L52_VI_B_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP1l52_vi_b_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP1l52_vi_b_initials());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L57_VI_C_INITIALS_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l57_vi_c_initials()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l57_vi_c_initials());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l58_received10days()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l58_received10days());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l60_waivedOppurtunity()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l60_waivedOppurtunity());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME1_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l67_purchaserName1()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l67_purchaserName1());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE1_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l67_purchaserDate1()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l67_purchaserDate1());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME2_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l67_purchaserName2()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l67_purchaserName2());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE2_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l67_purchaserDate2()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l67_purchaserDate2());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME3_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l69_purchaserName3()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l69_purchaserName3());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE3_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l69_purchaserDate3()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l69_purchaserDate3());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME4_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l69_purchaserName4()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l69_purchaserName4());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE4_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l69_purchaserDate4()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l69_purchaserDate4());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l74_sellingByAgentName()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l74_sellingByAgentName());
					elements.put(ElementsNjrlpd.OFL_NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE, StringUtils.isEmpty(njrlpdDO.getP2l75_sellingByAgentNameDate()) ? ElementsCommon.EMPTY : njrlpdDO.getP2l75_sellingByAgentNameDate());
					byte[] elementsBytes = WebServiceGzipUtil.compress(gson.toJson(elements));
					quickEntryDO.setElements(elementsBytes);
					quickEntryDOList.add(quickEntryDO);
				}
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return quickEntryDOList;
	}

	public static NjrlpdDO transformToNjrlpdDO(QuickEntryDO quickEntryDO) {
		NjrlpdDO njrlpdDO = null;
		try {
			if(quickEntryDO != null || quickEntryDO.getElements() != null) {
				njrlpdDO = new NjrlpdDO();
				Gson gson = new Gson();
				Type typeOfT = new TypeToken<HashMap<String, String>>() {}.getType();
				if(StringUtils.isEmpty(njrlpdDO.getQuickEntryID())) {
					njrlpdDO.setQuickEntryID(String.valueOf(quickEntryDO.getQuickEntryID()));
				}
				if(StringUtils.isEmpty(njrlpdDO.getQuickEntryName())) {
					njrlpdDO.setQuickEntryName(quickEntryDO.getName());
				}
				if(StringUtils.isEmpty(njrlpdDO.getQuickEntryDescription())) {
					njrlpdDO.setQuickEntryDescription(quickEntryDO.getDescription());
				}
				if(StringUtils.isEmpty(njrlpdDO.getUuid())) {
					njrlpdDO.setUuid(quickEntryDO.getUuid());
				}
				String json = WebServiceGzipUtil.decompress(quickEntryDO.getElements());
				HashMap<String, String> elements = gson.fromJson(json, typeOfT);
				njrlpdDO.setP1l10_propertyAddress1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L10_PROPERTYADDRESS1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L10_PROPERTYADDRESS1_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l11_propertyAddress2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L11_PROPERTYADDRESS2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L11_PROPERTYADDRESS2_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l14_iii_a_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L14_III_A_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L14_III_A_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l15_knownLeadBasedPaint(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l16_knownLeadBasedPaintExp1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l17_knownLeadBasedPaintExp2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l19_sellerNoKnowledge(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l121_iii_b_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L21_III_B_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L21_III_B_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l22_sellerHasNoReports(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l23_sellerHasReports(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L23_SELLERHASREPORTS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L23_SELLERHASREPORTS_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l27_sellerHasReportsDoc1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l28_sellerHasReportsDoc2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l30_iii_c_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L30_III_C_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L30_III_C_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l37_sellerName1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME1_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l37_sellerDate1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE1_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l37_sellerName2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME2_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l37_sellerDate2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE2_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l39_sellerName3(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME3_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME3_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l39_sellerDate3(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE3_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE3_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l39_sellerName4(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME4_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME4_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l39_sellerDate4(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE4_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE4_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l45_listingAgentName(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAME_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAME_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l45_listingAgentNameDate(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l50_vi_a_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L50_VI_A_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L50_VI_A_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP1l52_vi_b_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L52_VI_B_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L52_VI_B_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l57_vi_c_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L57_VI_C_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L57_VI_C_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l58_received10days(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l60_waivedOppurtunity(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l67_purchaserName1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME1_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l67_purchaserDate1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE1_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l67_purchaserName2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME2_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l67_purchaserDate2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE2_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l69_purchaserName3(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME3_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME3_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l69_purchaserDate3(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE3_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE3_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l69_purchaserName4(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME4_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME4_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l69_purchaserDate4(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE4_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE4_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l74_sellingByAgentName(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE) : ElementsCommon.EMPTY);
				njrlpdDO.setP2l75_sellingByAgentNameDate(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE) : ElementsCommon.EMPTY);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return njrlpdDO;
	}
	
	public static List<NjrlpdDO> transformToNjrlpdDO(List<QuickEntryDO> quickEntryDOList) {
		List<NjrlpdDO> njrlpdDOList = null;
		try {
			if(quickEntryDOList != null || quickEntryDOList.size() > 0) {
				njrlpdDOList = new ArrayList<NjrlpdDO>();
				Gson gson = new Gson();
				Type typeOfT = new TypeToken<HashMap<String, String>>() {}.getType();
				for(QuickEntryDO quickEntryDO : quickEntryDOList) {
					if(quickEntryDO.getElements() != null) {
						NjrlpdDO njrlpdDO = new NjrlpdDO();
						if(StringUtils.isEmpty(njrlpdDO.getQuickEntryID())) {
							njrlpdDO.setQuickEntryID(String.valueOf(quickEntryDO.getQuickEntryID()));
						}
						if(StringUtils.isEmpty(njrlpdDO.getQuickEntryName())) {
							njrlpdDO.setQuickEntryName(quickEntryDO.getName());
						}
						if(StringUtils.isEmpty(njrlpdDO.getQuickEntryDescription())) {
							njrlpdDO.setQuickEntryDescription(quickEntryDO.getDescription());
						}
						if(StringUtils.isEmpty(njrlpdDO.getUuid())) {
							njrlpdDO.setUuid(quickEntryDO.getUuid());
						}
						
						String json =  WebServiceGzipUtil.decompress(quickEntryDO.getElements());
						HashMap<String, String> elements = gson.fromJson(json, typeOfT);
						njrlpdDO.setP1l10_propertyAddress1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L10_PROPERTYADDRESS1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L10_PROPERTYADDRESS1_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l11_propertyAddress2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L11_PROPERTYADDRESS2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L11_PROPERTYADDRESS2_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l14_iii_a_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L14_III_A_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L14_III_A_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l15_knownLeadBasedPaint(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l16_knownLeadBasedPaintExp1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l17_knownLeadBasedPaintExp2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l19_sellerNoKnowledge(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l121_iii_b_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L21_III_B_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L21_III_B_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l22_sellerHasNoReports(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l23_sellerHasReports(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L23_SELLERHASREPORTS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L23_SELLERHASREPORTS_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l27_sellerHasReportsDoc1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l28_sellerHasReportsDoc2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l30_iii_c_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L30_III_C_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L30_III_C_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l37_sellerName1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME1_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l37_sellerDate1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE1_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l37_sellerName2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME2_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l37_sellerDate2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE2_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l39_sellerName3(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME3_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME3_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l39_sellerDate3(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE3_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE3_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l39_sellerName4(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME4_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME4_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l39_sellerDate4(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE4_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE4_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l45_listingAgentName(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAME_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAME_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l45_listingAgentNameDate(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l50_vi_a_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L50_VI_A_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L50_VI_A_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP1l52_vi_b_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P1L52_VI_B_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P1L52_VI_B_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l57_vi_c_initials(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L57_VI_C_INITIALS_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L57_VI_C_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l58_received10days(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l60_waivedOppurtunity(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l67_purchaserName1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME1_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l67_purchaserDate1(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE1_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE1_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l67_purchaserName2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME2_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l67_purchaserDate2(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE2_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE2_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l69_purchaserName3(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME3_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME3_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l69_purchaserDate3(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE3_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE3_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l69_purchaserName4(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME4_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME4_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l69_purchaserDate4(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE4_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE4_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l74_sellingByAgentName(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE) : ElementsCommon.EMPTY);
						njrlpdDO.setP2l75_sellingByAgentNameDate(elements.containsKey(ElementsNjrlpd.OFL_NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE) ? elements.get(ElementsNjrlpd.OFL_NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE) : ElementsCommon.EMPTY);
						njrlpdDOList.add(njrlpdDO);
					}
				}
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return njrlpdDOList;
	}


	public static QuickEntryDO transformFromNjr118DO(Njr118DO njr118DO) {
		QuickEntryDO quickEntryDO = null;
		try {
			if(njr118DO != null ) {
				quickEntryDO = new QuickEntryDO();
				Gson gson = new Gson();
				Map<String, String> elements = new HashMap<String, String>();
				if(StringUtils.isEmpty(quickEntryDO.getFileTypeID())) {
					quickEntryDO.setFileTypeID(njr118DO.getFileType());
				}
				if(StringUtils.isEmpty(quickEntryDO.getName())) {
					quickEntryDO.setName(njr118DO.getQuickEntryName());
				}
				if(StringUtils.isEmpty(quickEntryDO.getDescription())) {
					quickEntryDO.setDescription(njr118DO.getQuickEntryDescription());
				}
				if(StringUtils.isEmpty(quickEntryDO.getUuid())) {
					quickEntryDO.setUuid(njr118DO.getUuid());
				}
				//List - REAL_ESTATE_BROKER_REP
				//elements.put(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_SELLER_VALUE, StringUtils.isEmpty(njr118DO.getP1_real_estate_broker_rep()) ? ElementsCommon.EMPTY : njr118DO.getP1_real_estate_broker_rep());
				//elements.put(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BUYER_VALUE, StringUtils.isEmpty(njr118DO.getP1_real_estate_broker_rep()) ? ElementsCommon.EMPTY : njr118DO.getP1_real_estate_broker_rep());
				//elements.put(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BOTH_VALUE, StringUtils.isEmpty(njr118DO.getP1_real_estate_broker_rep()) ? ElementsCommon.EMPTY : njr118DO.getP1_real_estate_broker_rep());
				//elements.put(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_NEITHER_VALUE, StringUtils.isEmpty(njr118DO.getP1_real_estate_broker_rep()) ? ElementsCommon.EMPTY : njr118DO.getP1_real_estate_broker_rep());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME01_VALUE, StringUtils.isEmpty(njr118DO.getP1_seller_name01()) ? ElementsCommon.EMPTY : njr118DO.getP1_seller_name01());
				elements.put(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE01_VALUE, StringUtils.isEmpty(njr118DO.getP1_seller_date01()) ? ElementsCommon.EMPTY : njr118DO.getP1_seller_date01());
				elements.put(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME01_VALUE, StringUtils.isEmpty(njr118DO.getP1_buyer_name01()) ? ElementsCommon.EMPTY : njr118DO.getP1_buyer_name01());
				elements.put(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE01_VALUE, StringUtils.isEmpty(njr118DO.getP1_buyer_date01()) ? ElementsCommon.EMPTY : njr118DO.getP1_buyer_date01());
				elements.put(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME02_VALUE, StringUtils.isEmpty(njr118DO.getP1_seller_name02()) ? ElementsCommon.EMPTY : njr118DO.getP1_seller_name02());
				elements.put(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE02_VALUE, StringUtils.isEmpty(njr118DO.getP1_seller_date02()) ? ElementsCommon.EMPTY : njr118DO.getP1_seller_date02());
				elements.put(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME02_VALUE, StringUtils.isEmpty(njr118DO.getP1_buyer_name02()) ? ElementsCommon.EMPTY : njr118DO.getP1_buyer_name02());
				elements.put(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE02_VALUE, StringUtils.isEmpty(njr118DO.getP1_buyer_date02()) ? ElementsCommon.EMPTY : njr118DO.getP1_buyer_date02());
				elements.put(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP1_listing_broker()) ? ElementsCommon.EMPTY : njr118DO.getP1_listing_broker());
				elements.put(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP1_listing_broker_date()) ? ElementsCommon.EMPTY : njr118DO.getP1_listing_broker_date());
				elements.put(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP1_selling_broker()) ? ElementsCommon.EMPTY : njr118DO.getP1_selling_broker());
				elements.put(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP1_selling_broker_date()) ? ElementsCommon.EMPTY : njr118DO.getP1_selling_broker_date());
				elements.put(ElementsNjr118.OFL_NJR118_P1_PREPARED_BY_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP1_prepared_by_name()) ? ElementsCommon.EMPTY : njr118DO.getP1_prepared_by_name());
				elements.put(ElementsNjr118.OFL_NJR118_P2L16_NOTES1_VALUE, StringUtils.isEmpty(njr118DO.getP2l16_notes1()) ? ElementsCommon.EMPTY : njr118DO.getP2l16_notes1());
				elements.put(ElementsNjr118.OFL_NJR118_P2L17_NOTES2_VALUE, StringUtils.isEmpty(njr118DO.getP2l17_notes2()) ? ElementsCommon.EMPTY : njr118DO.getP2l17_notes2());
				elements.put(ElementsNjr118.OFL_NJR118_P2L18_NOTES3_VALUE, StringUtils.isEmpty(njr118DO.getP2l18_notes3()) ? ElementsCommon.EMPTY : njr118DO.getP2l18_notes3());
				elements.put(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION1_VALUE, StringUtils.isEmpty(njr118DO.getP2l21_buyer_description1()) ? ElementsCommon.EMPTY : njr118DO.getP2l21_buyer_description1());
				elements.put(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION2_VALUE, StringUtils.isEmpty(njr118DO.getP2l21_buyer_description2()) ? ElementsCommon.EMPTY : njr118DO.getP2l21_buyer_description2());
				elements.put(ElementsNjr118.OFL_NJR118_P2L23_BUYER_ADDRESS1_VALUE, StringUtils.isEmpty(njr118DO.getP2l23_buyer_address1()) ? ElementsCommon.EMPTY : njr118DO.getP2l23_buyer_address1());
				elements.put(ElementsNjr118.OFL_NJR118_P2L25_BUYER_ADDRESS2_VALUE, StringUtils.isEmpty(njr118DO.getP2l25_buyer_address2()) ? ElementsCommon.EMPTY : njr118DO.getP2l25_buyer_address2());
				elements.put(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION1_VALUE, StringUtils.isEmpty(njr118DO.getP2l28_seller_description1()) ? ElementsCommon.EMPTY : njr118DO.getP2l28_seller_description1());
				elements.put(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION2_VALUE, StringUtils.isEmpty(njr118DO.getP2l28_seller_description2()) ? ElementsCommon.EMPTY : njr118DO.getP2l28_seller_description2());
				elements.put(ElementsNjr118.OFL_NJR118_P2L30_SELLER_ADDRESS1_VALUE, StringUtils.isEmpty(njr118DO.getP2l30_seller_address1()) ? ElementsCommon.EMPTY : njr118DO.getP2l30_seller_address1());
				elements.put(ElementsNjr118.OFL_NJR118_P2L32_SELLER_ADDRESS2_VALUE, StringUtils.isEmpty(njr118DO.getP2l32_seller_address2()) ? ElementsCommon.EMPTY : njr118DO.getP2l32_seller_address2());
				elements.put(ElementsNjr118.OFL_NJR118_P2L35_PROPERTY_ADDRESS_VALUE, StringUtils.isEmpty(njr118DO.getP2l35_property_address()) ? ElementsCommon.EMPTY : njr118DO.getP2l35_property_address());
				elements.put(ElementsNjr118.OFL_NJR118_P2L37_MUNICIPAL_TAX_MAP_VALUE, StringUtils.isEmpty(njr118DO.getP2l37_municipal_tax_map()) ? ElementsCommon.EMPTY : njr118DO.getP2l37_municipal_tax_map());
				elements.put(ElementsNjr118.OFL_NJR118_P2L37_COUNTY_VALUE, StringUtils.isEmpty(njr118DO.getP2l37_county()) ? ElementsCommon.EMPTY : njr118DO.getP2l37_county());
				elements.put(ElementsNjr118.OFL_NJR118_P2L39_AS_LOT_VALUE, StringUtils.isEmpty(njr118DO.getP2l39_as_lot()) ? ElementsCommon.EMPTY : njr118DO.getP2l39_as_lot());
				elements.put(ElementsNjr118.OFL_NJR118_P2L39_BLOCK_VALUE, StringUtils.isEmpty(njr118DO.getP2l39_block()) ? ElementsCommon.EMPTY : njr118DO.getP2l39_block());
				elements.put(ElementsNjr118.OFL_NJR118_P2L44_TOTAL_PURCHASE_PRICE_VALUE, StringUtils.isEmpty(njr118DO.getP2l44_total_purchase_price()) ? ElementsCommon.EMPTY : njr118DO.getP2l44_total_purchase_price());
				elements.put(ElementsNjr118.OFL_NJR118_P2L45_INITIAL_DEPOSIT_VALUE, StringUtils.isEmpty(njr118DO.getP2l45_initial_deposit()) ? ElementsCommon.EMPTY : njr118DO.getP2l45_initial_deposit());
				elements.put(ElementsNjr118.OFL_NJR118_P2L46_ADDITIONAL_DEPOSIT_VALUE, StringUtils.isEmpty(njr118DO.getP2l46_additional_deposit()) ? ElementsCommon.EMPTY : njr118DO.getP2l46_additional_deposit());
				elements.put(ElementsNjr118.OFL_NJR118_P2L47_MORTAGE_VALUE, StringUtils.isEmpty(njr118DO.getP2l47_mortage()) ? ElementsCommon.EMPTY : njr118DO.getP2l47_mortage());
				elements.put(ElementsNjr118.OFL_NJR118_P2L48_BALANCE_OF_PURCHASE_PRICE_VALUE, StringUtils.isEmpty(njr118DO.getP2l48_balance_of_purchase_price()) ? ElementsCommon.EMPTY : njr118DO.getP2l48_balance_of_purchase_price());
				elements.put(ElementsNjr118.OFL_NJR118_P2_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP2_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP2_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P2_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP2_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP2_sellers_initials());
				//List - INITIAL_DEPOSIT_PAID_TO
				elements.put(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_LISTING_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
				elements.put(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_PARTICIPATING_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
				elements.put(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_BUYER_ATTORNEY_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
				elements.put(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_TITLE_CO_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
				elements.put(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
				elements.put(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_DESCRIPTION_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
				elements.put(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_date());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P3L56_ADDITIONAL_DEPOSIT_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l56_additional_deposit_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l56_additional_deposit_date());
				elements.put(ElementsNjr118.OFL_NJR118_P3L59_NONINTEREST_BEARING_TRUST_ACCOUNT_VALUE, StringUtils.isEmpty(njr118DO.getP3l59_noninterest_bearing_trust_account()) ? ElementsCommon.EMPTY : njr118DO.getP3l59_noninterest_bearing_trust_account());
				elements.put(ElementsNjr118.OFL_NJR118_P3L73_PRINCIPAL_AMOUNT_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_principal_amount()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_principal_amount());
				//List - getP3l73_type_of_mortage_List
				elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_VA_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_value()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_value());
				elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_FHA_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_value()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_value());
				elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_CONVENTIONAL_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_value()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_value());
				elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_value()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_value());
				elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_DESCRIPTION_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_value()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_value());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P3L74_TERM_OF_MORTAGE_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_value()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_value());
				elements.put(ElementsNjr118.OFL_NJR118_P3L74_BASED_ON_YEAR_PAYMENT_SCHEDULE_VALUE, StringUtils.isEmpty(njr118DO.getP3l74_based_on_year_payment_schedule()) ? ElementsCommon.EMPTY : njr118DO.getP3l74_based_on_year_payment_schedule());
				elements.put(ElementsNjr118.OFL_NJR118_P3L77_COMMITMENT_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l77_commitment_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l77_commitment_date());
				elements.put(ElementsNjr118.OFL_NJR118_P3L79_COMMITMENT_DATE_EXTENDED_NO_OF_DAYS_VALUE, StringUtils.isEmpty(njr118DO.getP3l79_commitment_date_extended_no_of_days()) ? ElementsCommon.EMPTY : njr118DO.getP3l79_commitment_date_extended_no_of_days());
				elements.put(ElementsNjr118.OFL_NJR118_P3L80_CLOSING_DATE_EXTENDED_NO_OF_DAYS_VALUE, StringUtils.isEmpty(njr118DO.getP3l80_closing_date_extended_no_of_days()) ? ElementsCommon.EMPTY : njr118DO.getP3l80_closing_date_extended_no_of_days());
				elements.put(ElementsNjr118.OFL_NJR118_P3L92_PAYMENT_OF_BALANCE_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l92_payment_of_balance_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l92_payment_of_balance_date());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P3L95_FHA_VA_LOANS_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p3l95_FHA_VA_loan()) ? ElementsCommon.EMPTY : njr118DO.is_p3l95_FHA_VA_loan());
				//elements.put(ElementsNjr118.OFL_NJR118_P3L95_FHA_VA_LOANS_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p3l95_FHA_VA_loan()) ? ElementsCommon.EMPTY : njr118DO.is_p3l95_FHA_VA_loan());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p3l103_buyer_property_sale_contingency()) ? ElementsCommon.EMPTY : njr118DO.is_p3l103_buyer_property_sale_contingency());
				//elements.put(ElementsNjr118.OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p3l103_buyer_property_sale_contingency()) ? ElementsCommon.EMPTY : njr118DO.is_p3l103_buyer_property_sale_contingency());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P3L104_BUYER_PROPERTY_CONTINGENT_ADDRESS1_VALUE, StringUtils.isEmpty(njr118DO.getP3l104_buyer_property_contingent_address1()) ? ElementsCommon.EMPTY : njr118DO.getP3l104_buyer_property_contingent_address1());
				elements.put(ElementsNjr118.OFL_NJR118_P3L105_BUYER_PROPERTY_CONTINGENT_ADDRESS2_VALUE, StringUtils.isEmpty(njr118DO.getP3l105_buyer_property_contingent_address2()) ? ElementsCommon.EMPTY : njr118DO.getP3l105_buyer_property_contingent_address2());
				elements.put(ElementsNjr118.OFL_NJR118_P3L105_SALE_CONTINGENCY_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l105_sale_contingency_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l105_sale_contingency_date());
				elements.put(ElementsNjr118.OFL_NJR118_P3_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP3_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP3_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P3_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP3_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP3_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P4L122_CONTRACT_OF_SALE_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP4l122_contract_of_sale_date()) ? ElementsCommon.EMPTY : njr118DO.getP4l122_contract_of_sale_date());
				elements.put(ElementsNjr118.OFL_NJR118_P4L150_ITEMS_INCLUDED_IN_SALE1_VALUE, StringUtils.isEmpty(njr118DO.getP4l150_items_included_in_sale1()) ? ElementsCommon.EMPTY : njr118DO.getP4l150_items_included_in_sale1());
				elements.put(ElementsNjr118.OFL_NJR118_P4L151_ITEMS_INCLUDED_IN_SALE2_VALUE, StringUtils.isEmpty(njr118DO.getP4l151_items_included_in_sale2()) ? ElementsCommon.EMPTY : njr118DO.getP4l151_items_included_in_sale2());
				elements.put(ElementsNjr118.OFL_NJR118_P4L152_ITEMS_INCLUDED_IN_SALE3_VALUE, StringUtils.isEmpty(njr118DO.getP4l152_items_included_in_sale3()) ? ElementsCommon.EMPTY : njr118DO.getP4l152_items_included_in_sale3());
				elements.put(ElementsNjr118.OFL_NJR118_P4L153_ITEMS_INCLUDED_IN_SALE4_VALUE, StringUtils.isEmpty(njr118DO.getP4l153_items_included_in_sale4()) ? ElementsCommon.EMPTY : njr118DO.getP4l153_items_included_in_sale4());
				elements.put(ElementsNjr118.OFL_NJR118_P4L154_ITEMS_INCLUDED_IN_SALE5_VALUE, StringUtils.isEmpty(njr118DO.getP4l154_items_included_in_sale5()) ? ElementsCommon.EMPTY : njr118DO.getP4l154_items_included_in_sale5());
				elements.put(ElementsNjr118.OFL_NJR118_P4L155_ITEMS_INCLUDED_IN_SALE6_VALUE, StringUtils.isEmpty(njr118DO.getP4l155_items_included_in_sale6()) ? ElementsCommon.EMPTY : njr118DO.getP4l155_items_included_in_sale6());
				elements.put(ElementsNjr118.OFL_NJR118_P4L156_ITEMS_INCLUDED_IN_SALE7_VALUE, StringUtils.isEmpty(njr118DO.getP4l156_items_included_in_sale7()) ? ElementsCommon.EMPTY : njr118DO.getP4l156_items_included_in_sale7());
				elements.put(ElementsNjr118.OFL_NJR118_P4L158_ITEMS_EXCLUDED_FROM_SALE1_VALUE, StringUtils.isEmpty(njr118DO.getP4l158_items_excluded_from_sale1()) ? ElementsCommon.EMPTY : njr118DO.getP4l158_items_excluded_from_sale1());
				elements.put(ElementsNjr118.OFL_NJR118_P4L159_ITEMS_EXCLUDED_FROM_SALE2_VALUE, StringUtils.isEmpty(njr118DO.getP4l159_items_excluded_from_sale2()) ? ElementsCommon.EMPTY : njr118DO.getP4l159_items_excluded_from_sale2());
				elements.put(ElementsNjr118.OFL_NJR118_P4L160_ITEMS_EXCLUDED_FROM_SALE3_VALUE, StringUtils.isEmpty(njr118DO.getP4l160_items_excluded_from_sale3()) ? ElementsCommon.EMPTY : njr118DO.getP4l160_items_excluded_from_sale3());
				elements.put(ElementsNjr118.OFL_NJR118_P4L161_ITEMS_EXCLUDED_FROM_SALE4_VALUE, StringUtils.isEmpty(njr118DO.getP4l161_items_excluded_from_sale4()) ? ElementsCommon.EMPTY : njr118DO.getP4l161_items_excluded_from_sale4());
				elements.put(ElementsNjr118.OFL_NJR118_P4L162_ITEMS_EXCLUDED_FROM_SALE5_VALUE, StringUtils.isEmpty(njr118DO.getP4l162_items_excluded_from_sale5()) ? ElementsCommon.EMPTY : njr118DO.getP4l162_items_excluded_from_sale5());
				elements.put(ElementsNjr118.OFL_NJR118_P4L163_ITEMS_EXCLUDED_FROM_SALE6_VALUE, StringUtils.isEmpty(njr118DO.getP4l163_items_excluded_from_sale6()) ? ElementsCommon.EMPTY : njr118DO.getP4l163_items_excluded_from_sale6());
				elements.put(ElementsNjr118.OFL_NJR118_P4L164_ITEMS_EXCLUDED_FROM_SALE7_VALUE, StringUtils.isEmpty(njr118DO.getP4l164_items_excluded_from_sale7()) ? ElementsCommon.EMPTY : njr118DO.getP4l164_items_excluded_from_sale7());
				elements.put(ElementsNjr118.OFL_NJR118_P4_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP4_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP4_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P4_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP4_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP4_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P5L177_AMOUNT_EXPENSE_EXCEEDS_TO_SELLER_VALUE, StringUtils.isEmpty(njr118DO.getP5l177_amount_expense_exceeds_to_seller()) ? ElementsCommon.EMPTY : njr118DO.getP5l177_amount_expense_exceeds_to_seller());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p5l183_condo_home_associations()) ? ElementsCommon.EMPTY : njr118DO.is_p5l183_condo_home_associations());
				//elements.put(ElementsNjr118.OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p5l183_condo_home_associations()) ? ElementsCommon.EMPTY : njr118DO.is_p5l183_condo_home_associations());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P5L187_CONDO_HOME_ASSOCIATIONS_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP5l187_condo_home_associations_name()) ? ElementsCommon.EMPTY : njr118DO.getP5l187_condo_home_associations_name());
				elements.put(ElementsNjr118.OFL_NJR118_P5L188_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO1_VALUE, StringUtils.isEmpty(njr118DO.getP5l188_condo_home_associations_contact_info1()) ? ElementsCommon.EMPTY : njr118DO.getP5l188_condo_home_associations_contact_info1());
				elements.put(ElementsNjr118.OFL_NJR118_P5L189_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO2_VALUE, StringUtils.isEmpty(njr118DO.getP5l189_condo_home_associations_contact_info2()) ? ElementsCommon.EMPTY : njr118DO.getP5l189_condo_home_associations_contact_info2());
				elements.put(ElementsNjr118.OFL_NJR118_P5L196_CONDO_HOME_ASSOCIATIONS_FEE_AMOUNT_VALUE, StringUtils.isEmpty(njr118DO.getP5l196_condo_home_associations_fee_amount()) ? ElementsCommon.EMPTY : njr118DO.getP5l196_condo_home_associations_fee_amount());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable()) ? ElementsCommon.EMPTY : njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable());
				//elements.put(ElementsNjr118.OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable()) ? ElementsCommon.EMPTY : njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_AMOUNT_VALUE, StringUtils.isEmpty(njr118DO.getP5l201_condo_home_associations_assessments_by_buyer_amount()) ? ElementsCommon.EMPTY : njr118DO.getP5l201_condo_home_associations_assessments_by_buyer_amount());
				elements.put(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE1_VALUE, StringUtils.isEmpty(njr118DO.getP5l201_condo_home_associations_assessments_by_buyer_purpose1()) ? ElementsCommon.EMPTY : njr118DO.getP5l201_condo_home_associations_assessments_by_buyer_purpose1());
				elements.put(ElementsNjr118.OFL_NJR118_P5L202_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE2_VALUE, StringUtils.isEmpty(njr118DO.getP5l202_condo_home_associations_assessments_by_buyer_purpose2()) ? ElementsCommon.EMPTY : njr118DO.getP5l202_condo_home_associations_assessments_by_buyer_purpose2());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_BEEN_NOTIFIED_VALUE, StringUtils.isEmpty(njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified()) ? ElementsCommon.EMPTY : njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified());
				//elements.put(ElementsNjr118.OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_NOT_BEEN_NOTIFIED_VALUE, StringUtils.isEmpty(njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified()) ? ElementsCommon.EMPTY : njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P5_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP5_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP5_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P5_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP5_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP5_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P6L233_OCCUPANCY_OF_PROPERTY_AS_FAMILY_RESIDENTIAL_DWELLING_VALUE, StringUtils.isEmpty(njr118DO.getP6l233_occupancy_of_property_as_family_residential_dwelling()) ? ElementsCommon.EMPTY : njr118DO.getP6l233_occupancy_of_property_as_family_residential_dwelling());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P6L246_TENANCIES_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p6l246_tenancies()) ? ElementsCommon.EMPTY : njr118DO.is_p6l246_tenancies());
				//elements.put(ElementsNjr118.OFL_NJR118_P6L246_TENANCIES_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p6l246_tenancies()) ? ElementsCommon.EMPTY : njr118DO.is_p6l246_tenancies());
				elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_NAME1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_name1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_name1());
				elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_LOCATION1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_location1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_location1());
				elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_RENT1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_rent1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_rent1());
				elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_SECURITY_DEPOSIT1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_security_deposit1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_security_deposit1());
				elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_TERM1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_term1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_term1());
				elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_NAME2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_name2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_name2());
				elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_LOCATION2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_location2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_location2());
				elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_RENT2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_rent2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_rent2());
				elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_SECURITY_DEPOSIT2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_security_deposit2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_security_deposit2());
				elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_TERM2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_term2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_term2());
				elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_NAME3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_name3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_name3());
				elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_LOCATION3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_location3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_location3());
				elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_RENT3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_rent3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_rent3());
				elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_SECURITY_DEPOSIT3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_security_deposit3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_security_deposit3());
				elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_TERM3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_term3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_term3());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P6L265_LEAD_BASED_PAINT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p6l265_lead_based_paint()) ? ElementsCommon.EMPTY : njr118DO.is_p6l265_lead_based_paint());
				//elements.put(ElementsNjr118.OFL_NJR118_P6L265_LEAD_BASED_PAINT_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p6l265_lead_based_paint()) ? ElementsCommon.EMPTY : njr118DO.is_p6l265_lead_based_paint());
				elements.put(ElementsNjr118.OFL_NJR118_P6_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP6_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP6_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P6_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP6_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP6_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P7L296_SELLER_NO_DAYS_RECEIPT_OF_AMENDMENT_VALUE, StringUtils.isEmpty(njr118DO.getP7l296_seller_no_days_receipt_of_amendment()) ? ElementsCommon.EMPTY : njr118DO.getP7l296_seller_no_days_receipt_of_amendment());
				elements.put(ElementsNjr118.OFL_NJR118_P7L298_BUYER_NO_DAYS_RECEIPT_OF_COUNTERPROPOSAL_VALUE, StringUtils.isEmpty(njr118DO.getP7l298_buyer_no_days_receipt_of_counterproposal()) ? ElementsCommon.EMPTY : njr118DO.getP7l298_buyer_no_days_receipt_of_counterproposal());
				//is
				/*elements.put(ElementsNjr118.OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l302_private_well_testing()) ? ElementsCommon.EMPTY : njr118DO.is_p7l302_private_well_testing());
				elements.put(ElementsNjr118.OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l302_private_well_testing()) ? ElementsCommon.EMPTY : njr118DO.is_p7l302_private_well_testing());
				elements.put(ElementsNjr118.OFL_NJR118_P7L327_POET_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l327_poet()) ? ElementsCommon.EMPTY : njr118DO.is_p7l327_poet());
				elements.put(ElementsNjr118.OFL_NJR118_P7L327_POET_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l327_poet()) ? ElementsCommon.EMPTY : njr118DO.is_p7l327_poet());
				elements.put(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l332_cesspool_requirements()) ? ElementsCommon.EMPTY : njr118DO.is_p7l332_cesspool_requirements());
				elements.put(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l332_cesspool_requirements()) ? ElementsCommon.EMPTY : njr118DO.is_p7l332_cesspool_requirements());
				elements.put(ElementsNjr118.OFL_NJR118_P7L339_SELLER_REPRESENTS_NO_CESSPOOL_VALUE, StringUtils.isEmpty(njr118DO.is_p7l339_one_or_more_cesspool()) ? ElementsCommon.EMPTY : njr118DO.is_p7l339_one_or_more_cesspool());
				elements.put(ElementsNjr118.OFL_NJR118_P7L339_ONE_OR_MORE_CESSPOOL_VALUE, StringUtils.isEmpty(njr118DO.is_p7l339_one_or_more_cesspool()) ? ElementsCommon.EMPTY : njr118DO.is_p7l339_one_or_more_cesspool());
				elements.put(ElementsNjr118.OFL_NJR118_P7L342_SELLER_AGREES_SOLE_COST_EXPENSE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l342_seller_agrees_sole_cost_expense()) ? ElementsCommon.EMPTY : njr118DO.is_p7l342_seller_agrees_sole_cost_expense());
				*/
				elements.put(ElementsNjr118.OFL_NJR118_P7_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP7_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP7_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P7_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP7_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP7_sellers_initials());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P8L355_BUYER_AGREES_SOLE_COST_EXPENSE_VALUE, StringUtils.isEmpty(njr118DO.is_p8l355_buyer_agrees_sole_cost_expense()) ? ElementsCommon.EMPTY : njr118DO.is_p8l355_buyer_agrees_sole_cost_expense());
				elements.put(ElementsNjr118.OFL_NJR118_P8_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP8_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP8_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P8_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP8_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP8_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P9_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP9_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP9_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P9_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP9_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP9_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P10_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP10_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP10_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P10_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP10_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP10_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P11_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP11_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP11_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P11_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP11_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP11_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P12L608_NAME_OF_FIRM_VALUE, StringUtils.isEmpty(njr118DO.getP12l608_name_of_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l608_name_of_firm());
				elements.put(ElementsNjr118.OFL_NJR118_P12L609_NAME_OF_SALES_REP_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
				//List - getP12l611_sales_person_operating_as_List
				elements.put(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_SELLERS_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
				elements.put(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_BUYERS_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
				elements.put(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_DISCLOSED_DUAL_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
				elements.put(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_TRANSACTION_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P12L613_NAME_OF_OTHER_FIRM_VALUE, StringUtils.isEmpty(njr118DO.getP12l613_name_of_other_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l613_name_of_other_firm());
				//List - getP12l615_other_firm_operating_as_List
				elements.put(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_SELLERS_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l613_name_of_other_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l613_name_of_other_firm());
				elements.put(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_BUYERS_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l613_name_of_other_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l613_name_of_other_firm());
				elements.put(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_TRANSACTION_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP12l613_name_of_other_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l613_name_of_other_firm());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP12l623_listing_firm_name()) ? ElementsCommon.EMPTY : njr118DO.getP12l623_listing_firm_name());
				elements.put(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_REC_LICENSE_ID_VALUE, StringUtils.isEmpty(njr118DO.getP12l623_listing_firm_rec_license_id()) ? ElementsCommon.EMPTY : njr118DO.getP12l623_listing_firm_rec_license_id());
				elements.put(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP12l626_listing_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP12l626_listing_agent_name());
				elements.put(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_REC_LICENSE_ID_VALUE, StringUtils.isEmpty(njr118DO.getP12l626_listing_agent_rec_license_id()) ? ElementsCommon.EMPTY : njr118DO.getP12l626_listing_agent_rec_license_id());
				elements.put(ElementsNjr118.OFL_NJR118_P12L629_LISTING_ADDRESS_VALUE, StringUtils.isEmpty(njr118DO.getP12l629_listing_address()) ? ElementsCommon.EMPTY : njr118DO.getP12l629_listing_address());
				elements.put(ElementsNjr118.OFL_NJR118_P12L631_LISTING_OFFICE_PHONE_VALUE, StringUtils.isEmpty(njr118DO.getP12l631_listing_office_phone()) ? ElementsCommon.EMPTY : njr118DO.getP12l631_listing_fax());
				elements.put(ElementsNjr118.OFL_NJR118_P12L631_LISTING_FAX_VALUE, StringUtils.isEmpty(njr118DO.getP12l631_listing_fax()) ? ElementsCommon.EMPTY : njr118DO.getP12l631_listing_fax());
				elements.put(ElementsNjr118.OFL_NJR118_P12L631_LISTING_AGENT_CELLPHONE_VALUE, StringUtils.isEmpty(njr118DO.getP12l631_listing_agent_cellphone()) ? ElementsCommon.EMPTY : njr118DO.getP12l631_listing_agent_cellphone());
				elements.put(ElementsNjr118.OFL_NJR118_P12L634_LISTING_EMAIL_VALUE, StringUtils.isEmpty(njr118DO.getP12l634_listing_email()) ? ElementsCommon.EMPTY : njr118DO.getP12l634_listing_email());
				elements.put(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_VALUE, StringUtils.isEmpty(njr118DO.getP12l636_participating_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l636_participating_firm());
				elements.put(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_REC_LICENSE_ID_VALUE, StringUtils.isEmpty(njr118DO.getP12l636_participating_firm_rec_license_id()) ? ElementsCommon.EMPTY : njr118DO.getP12l636_participating_firm_rec_license_id());
				elements.put(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l639_participating_agent()) ? ElementsCommon.EMPTY : njr118DO.getP12l639_participating_agent());
				elements.put(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_REC_LICENSE_ID_VALUE, StringUtils.isEmpty(njr118DO.getP12l639_participating_agent_rec_license_id()) ? ElementsCommon.EMPTY : njr118DO.getP12l639_participating_agent_rec_license_id());
				elements.put(ElementsNjr118.OFL_NJR118_P12L641_PARTICIPATING_ADDRESS_VALUE, StringUtils.isEmpty(njr118DO.getP12l641_participating_address()) ? ElementsCommon.EMPTY : njr118DO.getP12l641_participating_address());
				elements.put(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_OFFICE_PHONE_VALUE, StringUtils.isEmpty(njr118DO.getP12l643_participating_office_phone()) ? ElementsCommon.EMPTY : njr118DO.getP12l643_participating_office_phone());
				elements.put(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_FAX_VALUE, StringUtils.isEmpty(njr118DO.getP12l643_participating_fax()) ? ElementsCommon.EMPTY : njr118DO.getP12l643_participating_fax());
				elements.put(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_AGENT_CELLPHONE_VALUE, StringUtils.isEmpty(njr118DO.getP12l643_participating_agent_cellphone()) ? ElementsCommon.EMPTY : njr118DO.getP12l643_participating_agent_cellphone());
				elements.put(ElementsNjr118.OFL_NJR118_P12L646_PARTICIPATING_EMAIL_VALUE, StringUtils.isEmpty(njr118DO.getP12l646_participating_email()) ? ElementsCommon.EMPTY : njr118DO.getP12l646_participating_email());
				elements.put(ElementsNjr118.OFL_NJR118_P12L649_COMMISION_DUE_PARTICIPATING_FIRM_VALUE, StringUtils.isEmpty(njr118DO.getP12l649_commission_due_participating_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l649_commission_due_participating_firm());
				elements.put(ElementsNjr118.OFL_NJR118_P12_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP12_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP12_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P12_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP12_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP12_sellers_initials());
				//is
				//elements.put(ElementsNjr118.OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p13l651_disclosure_real_estate_license()) ? ElementsCommon.EMPTY : njr118DO.is_p13l651_disclosure_real_estate_license());
				//elements.put(ElementsNjr118.OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p13l651_disclosure_real_estate_license()) ? ElementsCommon.EMPTY : njr118DO.is_p13l651_disclosure_real_estate_license());
				elements.put(ElementsNjr118.OFL_NJR118_P13L653_DISCLOSURE_AGENT_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
				//List  - getP13l654_disclosure_agent
				elements.put(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
				elements.put(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_SALESPERSON_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
				elements.put(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_SALESPERSON_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
				elements.put(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_REFERRAL_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
				//
				elements.put(ElementsNjr118.OFL_NJR118_P13_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP13_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP13_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P13_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP13_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP13_sellers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P14L712_ADDITIONAL_PROVISIONS_01_VALUE, StringUtils.isEmpty(njr118DO.getP14l712_additional_provisions_01()) ? ElementsCommon.EMPTY : njr118DO.getP14l712_additional_provisions_01());
				elements.put(ElementsNjr118.OFL_NJR118_P14L713_ADDITIONAL_PROVISIONS_02_VALUE, StringUtils.isEmpty(njr118DO.getP14l713_additional_provisions_02()) ? ElementsCommon.EMPTY : njr118DO.getP14l713_additional_provisions_02());
				elements.put(ElementsNjr118.OFL_NJR118_P14L714_ADDITIONAL_PROVISIONS_03_VALUE, StringUtils.isEmpty(njr118DO.getP14l714_additional_provisions_03()) ? ElementsCommon.EMPTY : njr118DO.getP14l714_additional_provisions_03());
				elements.put(ElementsNjr118.OFL_NJR118_P14L715_ADDITIONAL_PROVISIONS_04_VALUE, StringUtils.isEmpty(njr118DO.getP14l715_additional_provisions_04()) ? ElementsCommon.EMPTY : njr118DO.getP14l715_additional_provisions_04());
				elements.put(ElementsNjr118.OFL_NJR118_P14L716_ADDITIONAL_PROVISIONS_05_VALUE, StringUtils.isEmpty(njr118DO.getP14l716_additional_provisions_05()) ? ElementsCommon.EMPTY : njr118DO.getP14l716_additional_provisions_05());
				elements.put(ElementsNjr118.OFL_NJR118_P14L717_ADDITIONAL_PROVISIONS_06_VALUE, StringUtils.isEmpty(njr118DO.getP14l717_additional_provisions_06()) ? ElementsCommon.EMPTY : njr118DO.getP14l717_additional_provisions_06());
				elements.put(ElementsNjr118.OFL_NJR118_P14L718_ADDITIONAL_PROVISIONS_07_VALUE, StringUtils.isEmpty(njr118DO.getP14l718_additional_provisions_07()) ? ElementsCommon.EMPTY : njr118DO.getP14l718_additional_provisions_07());
				elements.put(ElementsNjr118.OFL_NJR118_P14L719_ADDITIONAL_PROVISIONS_08_VALUE, StringUtils.isEmpty(njr118DO.getP14l719_additional_provisions_08()) ? ElementsCommon.EMPTY : njr118DO.getP14l719_additional_provisions_08());
				elements.put(ElementsNjr118.OFL_NJR118_P14L720_ADDITIONAL_PROVISIONS_09_VALUE, StringUtils.isEmpty(njr118DO.getP14l720_additional_provisions_09()) ? ElementsCommon.EMPTY : njr118DO.getP14l720_additional_provisions_09());
				elements.put(ElementsNjr118.OFL_NJR118_P14L721_ADDITIONAL_PROVISIONS_10_VALUE, StringUtils.isEmpty(njr118DO.getP14l721_additional_provisions_10()) ? ElementsCommon.EMPTY : njr118DO.getP14l721_additional_provisions_10());
				elements.put(ElementsNjr118.OFL_NJR118_P14L722_ADDITIONAL_PROVISIONS_11_VALUE, StringUtils.isEmpty(njr118DO.getP14l722_additional_provisions_11()) ? ElementsCommon.EMPTY : njr118DO.getP14l722_additional_provisions_11());
				elements.put(ElementsNjr118.OFL_NJR118_P14L723_ADDITIONAL_PROVISIONS_12_VALUE, StringUtils.isEmpty(njr118DO.getP14l723_additional_provisions_12()) ? ElementsCommon.EMPTY : njr118DO.getP14l723_additional_provisions_12());
				elements.put(ElementsNjr118.OFL_NJR118_P14L724_ADDITIONAL_PROVISIONS_13_VALUE, StringUtils.isEmpty(njr118DO.getP14l724_additional_provisions_13()) ? ElementsCommon.EMPTY : njr118DO.getP14l724_additional_provisions_13());
				elements.put(ElementsNjr118.OFL_NJR118_P14L725_ADDITIONAL_PROVISIONS_14_VALUE, StringUtils.isEmpty(njr118DO.getP14l725_additional_provisions_14()) ? ElementsCommon.EMPTY : njr118DO.getP14l725_additional_provisions_14());
				elements.put(ElementsNjr118.OFL_NJR118_P14L726_ADDITIONAL_PROVISIONS_15_VALUE, StringUtils.isEmpty(njr118DO.getP14l726_additional_provisions_15()) ? ElementsCommon.EMPTY : njr118DO.getP14l726_additional_provisions_15());
				elements.put(ElementsNjr118.OFL_NJR118_P14L727_ADDITIONAL_PROVISIONS_16_VALUE, StringUtils.isEmpty(njr118DO.getP14l727_additional_provisions_16()) ? ElementsCommon.EMPTY : njr118DO.getP14l727_additional_provisions_16());
				elements.put(ElementsNjr118.OFL_NJR118_P14L728_ADDITIONAL_PROVISIONS_17_VALUE, StringUtils.isEmpty(njr118DO.getP14l728_additional_provisions_17()) ? ElementsCommon.EMPTY : njr118DO.getP14l728_additional_provisions_17());
				elements.put(ElementsNjr118.OFL_NJR118_P14L729_ADDITIONAL_PROVISIONS_18_VALUE, StringUtils.isEmpty(njr118DO.getP14l729_additional_provisions_18()) ? ElementsCommon.EMPTY : njr118DO.getP14l729_additional_provisions_18());
				elements.put(ElementsNjr118.OFL_NJR118_P14L730_ADDITIONAL_PROVISIONS_19_VALUE, StringUtils.isEmpty(njr118DO.getP14l730_additional_provisions_19()) ? ElementsCommon.EMPTY : njr118DO.getP14l730_additional_provisions_19());
				elements.put(ElementsNjr118.OFL_NJR118_P14L731_ADDITIONAL_PROVISIONS_20_VALUE, StringUtils.isEmpty(njr118DO.getP14l731_additional_provisions_20()) ? ElementsCommon.EMPTY : njr118DO.getP14l731_additional_provisions_20());
				elements.put(ElementsNjr118.OFL_NJR118_P14L732_ADDITIONAL_PROVISIONS_21_VALUE, StringUtils.isEmpty(njr118DO.getP14l732_additional_provisions_21()) ? ElementsCommon.EMPTY : njr118DO.getP14l732_additional_provisions_21());
				elements.put(ElementsNjr118.OFL_NJR118_P14L733_ADDITIONAL_PROVISIONS_22_VALUE, StringUtils.isEmpty(njr118DO.getP14l733_additional_provisions_22()) ? ElementsCommon.EMPTY : njr118DO.getP14l733_additional_provisions_22());
				elements.put(ElementsNjr118.OFL_NJR118_P14L734_ADDITIONAL_PROVISIONS_23_VALUE, StringUtils.isEmpty(njr118DO.getP14l734_additional_provisions_23()) ? ElementsCommon.EMPTY : njr118DO.getP14l734_additional_provisions_23());
				elements.put(ElementsNjr118.OFL_NJR118_P14L735_ADDITIONAL_PROVISIONS_24_VALUE, StringUtils.isEmpty(njr118DO.getP14l735_additional_provisions_24()) ? ElementsCommon.EMPTY : njr118DO.getP14l735_additional_provisions_24());
				elements.put(ElementsNjr118.OFL_NJR118_P14L736_ADDITIONAL_PROVISIONS_25_VALUE, StringUtils.isEmpty(njr118DO.getP14l736_additional_provisions_25()) ? ElementsCommon.EMPTY : njr118DO.getP14l736_additional_provisions_25());
				elements.put(ElementsNjr118.OFL_NJR118_P14L737_ADDITIONAL_PROVISIONS_26_VALUE, StringUtils.isEmpty(njr118DO.getP14l737_additional_provisions_26()) ? ElementsCommon.EMPTY : njr118DO.getP14l737_additional_provisions_26());
				elements.put(ElementsNjr118.OFL_NJR118_P14L738_ADDITIONAL_PROVISIONS_27_VALUE, StringUtils.isEmpty(njr118DO.getP14l738_additional_provisions_27()) ? ElementsCommon.EMPTY : njr118DO.getP14l738_additional_provisions_27());
				elements.put(ElementsNjr118.OFL_NJR118_P14L739_ADDITIONAL_PROVISIONS_28_VALUE, StringUtils.isEmpty(njr118DO.getP14l739_additional_provisions_28()) ? ElementsCommon.EMPTY : njr118DO.getP14l739_additional_provisions_28());
				elements.put(ElementsNjr118.OFL_NJR118_P14L742_PRESENCE1_VALUE, StringUtils.isEmpty(njr118DO.getP14l742_presence1()) ? ElementsCommon.EMPTY : njr118DO.getP14l742_presence1());
				elements.put(ElementsNjr118.OFL_NJR118_P14L742_DATE1_VALUE, StringUtils.isEmpty(njr118DO.getP14l742_date1()) ? ElementsCommon.EMPTY : njr118DO.getP14l742_date1());
				elements.put(ElementsNjr118.OFL_NJR118_P14L745_PRESENCE2_VALUE, StringUtils.isEmpty(njr118DO.getP14l745_presence2()) ? ElementsCommon.EMPTY : njr118DO.getP14l745_presence2());
				elements.put(ElementsNjr118.OFL_NJR118_P14L745_DATE2_VALUE, StringUtils.isEmpty(njr118DO.getP14l745_date2()) ? ElementsCommon.EMPTY : njr118DO.getP14l745_date2());
				elements.put(ElementsNjr118.OFL_NJR118_P14L748_PRESENCE3_VALUE, StringUtils.isEmpty(njr118DO.getP14l748_presence3()) ? ElementsCommon.EMPTY : njr118DO.getP14l748_presence3());
				elements.put(ElementsNjr118.OFL_NJR118_P14L748_DATE3_VALUE, StringUtils.isEmpty(njr118DO.getP14l748_date3()) ? ElementsCommon.EMPTY : njr118DO.getP14l748_date3());
				elements.put(ElementsNjr118.OFL_NJR118_P14L751_PRESENCE4_VALUE, StringUtils.isEmpty(njr118DO.getP14l751_presence4()) ? ElementsCommon.EMPTY : njr118DO.getP14l751_presence4());
				elements.put(ElementsNjr118.OFL_NJR118_P14L751_DATE4_VALUE, StringUtils.isEmpty(njr118DO.getP14l751_date4()) ? ElementsCommon.EMPTY : njr118DO.getP14l751_date4());
				elements.put(ElementsNjr118.OFL_NJR118_P14L751_SELLER2_VALUE, StringUtils.isEmpty(njr118DO.getP14l751_seller2()) ? ElementsCommon.EMPTY : njr118DO.getP14l751_seller2());
				elements.put(ElementsNjr118.OFL_NJR118_P14_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP14_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP14_buyers_initials());
				elements.put(ElementsNjr118.OFL_NJR118_P14_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP14_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP14_sellers_initials());

				byte[] elementsBytes = WebServiceGzipUtil.compress(gson.toJson(elements));
				quickEntryDO.setElements(elementsBytes);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return quickEntryDO;
	}

	public static List<QuickEntryDO> transformFromNjr118DO(List<Njr118DO> njr118DOList) {
		List<QuickEntryDO> quickEntryDOList = null;
		try {
			if(njr118DOList != null || njr118DOList.size() > 0) {
				quickEntryDOList = new ArrayList<QuickEntryDO>();
				Gson gson = new Gson();
				for(Njr118DO njr118DO : njr118DOList) {
					QuickEntryDO quickEntryDO = new QuickEntryDO();
					Map<String, String> elements = new HashMap<String, String>();
					
					if(StringUtils.isEmpty(quickEntryDO.getFileTypeID())) {
						quickEntryDO.setFileTypeID(njr118DO.getFileType());
					}
					if(StringUtils.isEmpty(quickEntryDO.getName())) {
						quickEntryDO.setName(njr118DO.getQuickEntryName());
					}
					if(StringUtils.isEmpty(quickEntryDO.getDescription())) {
						quickEntryDO.setDescription(njr118DO.getQuickEntryDescription());
					}
					if(StringUtils.isEmpty(quickEntryDO.getUuid())) {
						quickEntryDO.setUuid(njr118DO.getUuid());
					}
					//List - REAL_ESTATE_BROKER_REP
					//elements.put(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_SELLER_VALUE, StringUtils.isEmpty(njr118DO.getP1_real_estate_broker_rep()) ? ElementsCommon.EMPTY : njr118DO.getP1_real_estate_broker_rep());
					//elements.put(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BUYER_VALUE, StringUtils.isEmpty(njr118DO.getP1_real_estate_broker_rep()) ? ElementsCommon.EMPTY : njr118DO.getP1_real_estate_broker_rep());
					//elements.put(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BOTH_VALUE, StringUtils.isEmpty(njr118DO.getP1_real_estate_broker_rep()) ? ElementsCommon.EMPTY : njr118DO.getP1_real_estate_broker_rep());
					//elements.put(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_NEITHER_VALUE, StringUtils.isEmpty(njr118DO.getP1_real_estate_broker_rep()) ? ElementsCommon.EMPTY : njr118DO.getP1_real_estate_broker_rep());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME01_VALUE, StringUtils.isEmpty(njr118DO.getP1_seller_name01()) ? ElementsCommon.EMPTY : njr118DO.getP1_seller_name01());
					elements.put(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE01_VALUE, StringUtils.isEmpty(njr118DO.getP1_seller_date01()) ? ElementsCommon.EMPTY : njr118DO.getP1_seller_date01());
					elements.put(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME01_VALUE, StringUtils.isEmpty(njr118DO.getP1_buyer_name01()) ? ElementsCommon.EMPTY : njr118DO.getP1_buyer_name01());
					elements.put(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE01_VALUE, StringUtils.isEmpty(njr118DO.getP1_buyer_date01()) ? ElementsCommon.EMPTY : njr118DO.getP1_buyer_date01());
					elements.put(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME02_VALUE, StringUtils.isEmpty(njr118DO.getP1_seller_name02()) ? ElementsCommon.EMPTY : njr118DO.getP1_seller_name02());
					elements.put(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE02_VALUE, StringUtils.isEmpty(njr118DO.getP1_seller_date02()) ? ElementsCommon.EMPTY : njr118DO.getP1_seller_date02());
					elements.put(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME02_VALUE, StringUtils.isEmpty(njr118DO.getP1_buyer_name02()) ? ElementsCommon.EMPTY : njr118DO.getP1_buyer_name02());
					elements.put(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE02_VALUE, StringUtils.isEmpty(njr118DO.getP1_buyer_date02()) ? ElementsCommon.EMPTY : njr118DO.getP1_buyer_date02());
					elements.put(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP1_listing_broker()) ? ElementsCommon.EMPTY : njr118DO.getP1_listing_broker());
					elements.put(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP1_listing_broker_date()) ? ElementsCommon.EMPTY : njr118DO.getP1_listing_broker_date());
					elements.put(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP1_selling_broker()) ? ElementsCommon.EMPTY : njr118DO.getP1_selling_broker());
					elements.put(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP1_selling_broker_date()) ? ElementsCommon.EMPTY : njr118DO.getP1_selling_broker_date());
					elements.put(ElementsNjr118.OFL_NJR118_P1_PREPARED_BY_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP1_prepared_by_name()) ? ElementsCommon.EMPTY : njr118DO.getP1_prepared_by_name());
					elements.put(ElementsNjr118.OFL_NJR118_P2L16_NOTES1_VALUE, StringUtils.isEmpty(njr118DO.getP2l16_notes1()) ? ElementsCommon.EMPTY : njr118DO.getP2l16_notes1());
					elements.put(ElementsNjr118.OFL_NJR118_P2L17_NOTES2_VALUE, StringUtils.isEmpty(njr118DO.getP2l17_notes2()) ? ElementsCommon.EMPTY : njr118DO.getP2l17_notes2());
					elements.put(ElementsNjr118.OFL_NJR118_P2L18_NOTES3_VALUE, StringUtils.isEmpty(njr118DO.getP2l18_notes3()) ? ElementsCommon.EMPTY : njr118DO.getP2l18_notes3());
					elements.put(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION1_VALUE, StringUtils.isEmpty(njr118DO.getP2l21_buyer_description1()) ? ElementsCommon.EMPTY : njr118DO.getP2l21_buyer_description1());
					elements.put(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION2_VALUE, StringUtils.isEmpty(njr118DO.getP2l21_buyer_description2()) ? ElementsCommon.EMPTY : njr118DO.getP2l21_buyer_description2());
					elements.put(ElementsNjr118.OFL_NJR118_P2L23_BUYER_ADDRESS1_VALUE, StringUtils.isEmpty(njr118DO.getP2l23_buyer_address1()) ? ElementsCommon.EMPTY : njr118DO.getP2l23_buyer_address1());
					elements.put(ElementsNjr118.OFL_NJR118_P2L25_BUYER_ADDRESS2_VALUE, StringUtils.isEmpty(njr118DO.getP2l25_buyer_address2()) ? ElementsCommon.EMPTY : njr118DO.getP2l25_buyer_address2());
					elements.put(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION1_VALUE, StringUtils.isEmpty(njr118DO.getP2l28_seller_description1()) ? ElementsCommon.EMPTY : njr118DO.getP2l28_seller_description1());
					elements.put(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION2_VALUE, StringUtils.isEmpty(njr118DO.getP2l28_seller_description2()) ? ElementsCommon.EMPTY : njr118DO.getP2l28_seller_description2());
					elements.put(ElementsNjr118.OFL_NJR118_P2L30_SELLER_ADDRESS1_VALUE, StringUtils.isEmpty(njr118DO.getP2l30_seller_address1()) ? ElementsCommon.EMPTY : njr118DO.getP2l30_seller_address1());
					elements.put(ElementsNjr118.OFL_NJR118_P2L32_SELLER_ADDRESS2_VALUE, StringUtils.isEmpty(njr118DO.getP2l32_seller_address2()) ? ElementsCommon.EMPTY : njr118DO.getP2l32_seller_address2());
					elements.put(ElementsNjr118.OFL_NJR118_P2L35_PROPERTY_ADDRESS_VALUE, StringUtils.isEmpty(njr118DO.getP2l35_property_address()) ? ElementsCommon.EMPTY : njr118DO.getP2l35_property_address());
					elements.put(ElementsNjr118.OFL_NJR118_P2L37_MUNICIPAL_TAX_MAP_VALUE, StringUtils.isEmpty(njr118DO.getP2l37_municipal_tax_map()) ? ElementsCommon.EMPTY : njr118DO.getP2l37_municipal_tax_map());
					elements.put(ElementsNjr118.OFL_NJR118_P2L37_COUNTY_VALUE, StringUtils.isEmpty(njr118DO.getP2l37_county()) ? ElementsCommon.EMPTY : njr118DO.getP2l37_county());
					elements.put(ElementsNjr118.OFL_NJR118_P2L39_AS_LOT_VALUE, StringUtils.isEmpty(njr118DO.getP2l39_as_lot()) ? ElementsCommon.EMPTY : njr118DO.getP2l39_as_lot());
					elements.put(ElementsNjr118.OFL_NJR118_P2L39_BLOCK_VALUE, StringUtils.isEmpty(njr118DO.getP2l39_block()) ? ElementsCommon.EMPTY : njr118DO.getP2l39_block());
					elements.put(ElementsNjr118.OFL_NJR118_P2L44_TOTAL_PURCHASE_PRICE_VALUE, StringUtils.isEmpty(njr118DO.getP2l44_total_purchase_price()) ? ElementsCommon.EMPTY : njr118DO.getP2l44_total_purchase_price());
					elements.put(ElementsNjr118.OFL_NJR118_P2L45_INITIAL_DEPOSIT_VALUE, StringUtils.isEmpty(njr118DO.getP2l45_initial_deposit()) ? ElementsCommon.EMPTY : njr118DO.getP2l45_initial_deposit());
					elements.put(ElementsNjr118.OFL_NJR118_P2L46_ADDITIONAL_DEPOSIT_VALUE, StringUtils.isEmpty(njr118DO.getP2l46_additional_deposit()) ? ElementsCommon.EMPTY : njr118DO.getP2l46_additional_deposit());
					elements.put(ElementsNjr118.OFL_NJR118_P2L47_MORTAGE_VALUE, StringUtils.isEmpty(njr118DO.getP2l47_mortage()) ? ElementsCommon.EMPTY : njr118DO.getP2l47_mortage());
					elements.put(ElementsNjr118.OFL_NJR118_P2L48_BALANCE_OF_PURCHASE_PRICE_VALUE, StringUtils.isEmpty(njr118DO.getP2l48_balance_of_purchase_price()) ? ElementsCommon.EMPTY : njr118DO.getP2l48_balance_of_purchase_price());
					elements.put(ElementsNjr118.OFL_NJR118_P2_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP2_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP2_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P2_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP2_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP2_sellers_initials());
					//List - INITIAL_DEPOSIT_PAID_TO
					elements.put(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_LISTING_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_PARTICIPATING_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_BUYER_ATTORNEY_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_TITLE_CO_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_DESCRIPTION_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_paid_to_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_paid_to_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l53_initial_deposit_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l53_initial_deposit_date());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P3L56_ADDITIONAL_DEPOSIT_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l56_additional_deposit_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l56_additional_deposit_date());
					elements.put(ElementsNjr118.OFL_NJR118_P3L59_NONINTEREST_BEARING_TRUST_ACCOUNT_VALUE, StringUtils.isEmpty(njr118DO.getP3l59_noninterest_bearing_trust_account()) ? ElementsCommon.EMPTY : njr118DO.getP3l59_noninterest_bearing_trust_account());
					elements.put(ElementsNjr118.OFL_NJR118_P3L73_PRINCIPAL_AMOUNT_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_principal_amount()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_principal_amount());
					//List - getP3l73_type_of_mortage_List
					elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_VA_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_FHA_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_CONVENTIONAL_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_other_description());
					elements.put(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_DESCRIPTION_VALUE, StringUtils.isEmpty(njr118DO.getP3l73_type_of_mortgage_other_description()) ? ElementsCommon.EMPTY : njr118DO.getP3l73_type_of_mortgage_other_description());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P3L74_TERM_OF_MORTAGE_VALUE, StringUtils.isEmpty(njr118DO.getP3l74_term_of_mortgage()) ? ElementsCommon.EMPTY : njr118DO.getP3l74_term_of_mortgage());
					elements.put(ElementsNjr118.OFL_NJR118_P3L74_BASED_ON_YEAR_PAYMENT_SCHEDULE_VALUE, StringUtils.isEmpty(njr118DO.getP3l74_based_on_year_payment_schedule()) ? ElementsCommon.EMPTY : njr118DO.getP3l74_based_on_year_payment_schedule());
					elements.put(ElementsNjr118.OFL_NJR118_P3L77_COMMITMENT_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l77_commitment_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l77_commitment_date());
					elements.put(ElementsNjr118.OFL_NJR118_P3L79_COMMITMENT_DATE_EXTENDED_NO_OF_DAYS_VALUE, StringUtils.isEmpty(njr118DO.getP3l79_commitment_date_extended_no_of_days()) ? ElementsCommon.EMPTY : njr118DO.getP3l79_commitment_date_extended_no_of_days());
					elements.put(ElementsNjr118.OFL_NJR118_P3L80_CLOSING_DATE_EXTENDED_NO_OF_DAYS_VALUE, StringUtils.isEmpty(njr118DO.getP3l80_closing_date_extended_no_of_days()) ? ElementsCommon.EMPTY : njr118DO.getP3l80_closing_date_extended_no_of_days());
					elements.put(ElementsNjr118.OFL_NJR118_P3L92_PAYMENT_OF_BALANCE_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l92_payment_of_balance_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l92_payment_of_balance_date());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P3L95_FHA_VA_LOANS_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p3l95_FHA_VA_loan()) ? ElementsCommon.EMPTY : njr118DO.is_p3l95_FHA_VA_loan());
					//elements.put(ElementsNjr118.OFL_NJR118_P3L95_FHA_VA_LOANS_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p3l95_FHA_VA_loan()) ? ElementsCommon.EMPTY : njr118DO.is_p3l95_FHA_VA_loan());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p3l103_buyer_property_sale_contingency()) ? ElementsCommon.EMPTY : njr118DO.is_p3l103_buyer_property_sale_contingency());
					//elements.put(ElementsNjr118.OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p3l103_buyer_property_sale_contingency()) ? ElementsCommon.EMPTY : njr118DO.is_p3l103_buyer_property_sale_contingency());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P3L104_BUYER_PROPERTY_CONTINGENT_ADDRESS1_VALUE, StringUtils.isEmpty(njr118DO.getP3l104_buyer_property_contingent_address1()) ? ElementsCommon.EMPTY : njr118DO.getP3l104_buyer_property_contingent_address1());
					elements.put(ElementsNjr118.OFL_NJR118_P3L105_BUYER_PROPERTY_CONTINGENT_ADDRESS2_VALUE, StringUtils.isEmpty(njr118DO.getP3l105_buyer_property_contingent_address2()) ? ElementsCommon.EMPTY : njr118DO.getP3l105_buyer_property_contingent_address2());
					elements.put(ElementsNjr118.OFL_NJR118_P3L105_SALE_CONTINGENCY_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP3l105_sale_contingency_date()) ? ElementsCommon.EMPTY : njr118DO.getP3l105_sale_contingency_date());
					elements.put(ElementsNjr118.OFL_NJR118_P3_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP3_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP3_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P3_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP3_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP3_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P4L122_CONTRACT_OF_SALE_DATE_VALUE, StringUtils.isEmpty(njr118DO.getP4l122_contract_of_sale_date()) ? ElementsCommon.EMPTY : njr118DO.getP4l122_contract_of_sale_date());
					elements.put(ElementsNjr118.OFL_NJR118_P4L150_ITEMS_INCLUDED_IN_SALE1_VALUE, StringUtils.isEmpty(njr118DO.getP4l150_items_included_in_sale1()) ? ElementsCommon.EMPTY : njr118DO.getP4l150_items_included_in_sale1());
					elements.put(ElementsNjr118.OFL_NJR118_P4L151_ITEMS_INCLUDED_IN_SALE2_VALUE, StringUtils.isEmpty(njr118DO.getP4l151_items_included_in_sale2()) ? ElementsCommon.EMPTY : njr118DO.getP4l151_items_included_in_sale2());
					elements.put(ElementsNjr118.OFL_NJR118_P4L152_ITEMS_INCLUDED_IN_SALE3_VALUE, StringUtils.isEmpty(njr118DO.getP4l152_items_included_in_sale3()) ? ElementsCommon.EMPTY : njr118DO.getP4l152_items_included_in_sale3());
					elements.put(ElementsNjr118.OFL_NJR118_P4L153_ITEMS_INCLUDED_IN_SALE4_VALUE, StringUtils.isEmpty(njr118DO.getP4l153_items_included_in_sale4()) ? ElementsCommon.EMPTY : njr118DO.getP4l153_items_included_in_sale4());
					elements.put(ElementsNjr118.OFL_NJR118_P4L154_ITEMS_INCLUDED_IN_SALE5_VALUE, StringUtils.isEmpty(njr118DO.getP4l154_items_included_in_sale5()) ? ElementsCommon.EMPTY : njr118DO.getP4l154_items_included_in_sale5());
					elements.put(ElementsNjr118.OFL_NJR118_P4L155_ITEMS_INCLUDED_IN_SALE6_VALUE, StringUtils.isEmpty(njr118DO.getP4l155_items_included_in_sale6()) ? ElementsCommon.EMPTY : njr118DO.getP4l155_items_included_in_sale6());
					elements.put(ElementsNjr118.OFL_NJR118_P4L156_ITEMS_INCLUDED_IN_SALE7_VALUE, StringUtils.isEmpty(njr118DO.getP4l156_items_included_in_sale7()) ? ElementsCommon.EMPTY : njr118DO.getP4l156_items_included_in_sale7());
					elements.put(ElementsNjr118.OFL_NJR118_P4L158_ITEMS_EXCLUDED_FROM_SALE1_VALUE, StringUtils.isEmpty(njr118DO.getP4l158_items_excluded_from_sale1()) ? ElementsCommon.EMPTY : njr118DO.getP4l158_items_excluded_from_sale1());
					elements.put(ElementsNjr118.OFL_NJR118_P4L159_ITEMS_EXCLUDED_FROM_SALE2_VALUE, StringUtils.isEmpty(njr118DO.getP4l159_items_excluded_from_sale2()) ? ElementsCommon.EMPTY : njr118DO.getP4l159_items_excluded_from_sale2());
					elements.put(ElementsNjr118.OFL_NJR118_P4L160_ITEMS_EXCLUDED_FROM_SALE3_VALUE, StringUtils.isEmpty(njr118DO.getP4l160_items_excluded_from_sale3()) ? ElementsCommon.EMPTY : njr118DO.getP4l160_items_excluded_from_sale3());
					elements.put(ElementsNjr118.OFL_NJR118_P4L161_ITEMS_EXCLUDED_FROM_SALE4_VALUE, StringUtils.isEmpty(njr118DO.getP4l161_items_excluded_from_sale4()) ? ElementsCommon.EMPTY : njr118DO.getP4l161_items_excluded_from_sale4());
					elements.put(ElementsNjr118.OFL_NJR118_P4L162_ITEMS_EXCLUDED_FROM_SALE5_VALUE, StringUtils.isEmpty(njr118DO.getP4l162_items_excluded_from_sale5()) ? ElementsCommon.EMPTY : njr118DO.getP4l162_items_excluded_from_sale5());
					elements.put(ElementsNjr118.OFL_NJR118_P4L163_ITEMS_EXCLUDED_FROM_SALE6_VALUE, StringUtils.isEmpty(njr118DO.getP4l163_items_excluded_from_sale6()) ? ElementsCommon.EMPTY : njr118DO.getP4l163_items_excluded_from_sale6());
					elements.put(ElementsNjr118.OFL_NJR118_P4L164_ITEMS_EXCLUDED_FROM_SALE7_VALUE, StringUtils.isEmpty(njr118DO.getP4l164_items_excluded_from_sale7()) ? ElementsCommon.EMPTY : njr118DO.getP4l164_items_excluded_from_sale7());
					elements.put(ElementsNjr118.OFL_NJR118_P4_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP4_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP4_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P4_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP4_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP4_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P5L177_AMOUNT_EXPENSE_EXCEEDS_TO_SELLER_VALUE, StringUtils.isEmpty(njr118DO.getP5l177_amount_expense_exceeds_to_seller()) ? ElementsCommon.EMPTY : njr118DO.getP5l177_amount_expense_exceeds_to_seller());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p5l183_condo_home_associations()) ? ElementsCommon.EMPTY : njr118DO.is_p5l183_condo_home_associations());
					//elements.put(ElementsNjr118.OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p5l183_condo_home_associations()) ? ElementsCommon.EMPTY : njr118DO.is_p5l183_condo_home_associations());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P5L187_CONDO_HOME_ASSOCIATIONS_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP5l187_condo_home_associations_name()) ? ElementsCommon.EMPTY : njr118DO.getP5l187_condo_home_associations_name());
					elements.put(ElementsNjr118.OFL_NJR118_P5L188_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO1_VALUE, StringUtils.isEmpty(njr118DO.getP5l188_condo_home_associations_contact_info1()) ? ElementsCommon.EMPTY : njr118DO.getP5l188_condo_home_associations_contact_info1());
					elements.put(ElementsNjr118.OFL_NJR118_P5L189_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO2_VALUE, StringUtils.isEmpty(njr118DO.getP5l189_condo_home_associations_contact_info2()) ? ElementsCommon.EMPTY : njr118DO.getP5l189_condo_home_associations_contact_info2());
					elements.put(ElementsNjr118.OFL_NJR118_P5L196_CONDO_HOME_ASSOCIATIONS_FEE_AMOUNT_VALUE, StringUtils.isEmpty(njr118DO.getP5l196_condo_home_associations_fee_amount()) ? ElementsCommon.EMPTY : njr118DO.getP5l196_condo_home_associations_fee_amount());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable()) ? ElementsCommon.EMPTY : njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable());
					//elements.put(ElementsNjr118.OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable()) ? ElementsCommon.EMPTY : njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_AMOUNT_VALUE, StringUtils.isEmpty(njr118DO.getP5l201_condo_home_associations_assessments_by_buyer_amount()) ? ElementsCommon.EMPTY : njr118DO.getP5l201_condo_home_associations_assessments_by_buyer_amount());
					elements.put(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE1_VALUE, StringUtils.isEmpty(njr118DO.getP5l201_condo_home_associations_assessments_by_buyer_purpose1()) ? ElementsCommon.EMPTY : njr118DO.getP5l201_condo_home_associations_assessments_by_buyer_purpose1());
					elements.put(ElementsNjr118.OFL_NJR118_P5L202_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE2_VALUE, StringUtils.isEmpty(njr118DO.getP5l202_condo_home_associations_assessments_by_buyer_purpose2()) ? ElementsCommon.EMPTY : njr118DO.getP5l202_condo_home_associations_assessments_by_buyer_purpose2());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_BEEN_NOTIFIED_VALUE, StringUtils.isEmpty(njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified()) ? ElementsCommon.EMPTY : njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified());
					//elements.put(ElementsNjr118.OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_NOT_BEEN_NOTIFIED_VALUE, StringUtils.isEmpty(njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified()) ? ElementsCommon.EMPTY : njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P5_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP5_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP5_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P5_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP5_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP5_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P6L233_OCCUPANCY_OF_PROPERTY_AS_FAMILY_RESIDENTIAL_DWELLING_VALUE, StringUtils.isEmpty(njr118DO.getP6l233_occupancy_of_property_as_family_residential_dwelling()) ? ElementsCommon.EMPTY : njr118DO.getP6l233_occupancy_of_property_as_family_residential_dwelling());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P6L246_TENANCIES_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p6l246_tenancies()) ? ElementsCommon.EMPTY : njr118DO.is_p6l246_tenancies());
					//elements.put(ElementsNjr118.OFL_NJR118_P6L246_TENANCIES_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p6l246_tenancies()) ? ElementsCommon.EMPTY : njr118DO.is_p6l246_tenancies());
					elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_NAME1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_name1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_name1());
					elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_LOCATION1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_location1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_location1());
					elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_RENT1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_rent1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_rent1());
					elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_SECURITY_DEPOSIT1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_security_deposit1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_security_deposit1());
					elements.put(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_TERM1_VALUE, StringUtils.isEmpty(njr118DO.getP6l255_tentant_term1()) ? ElementsCommon.EMPTY : njr118DO.getP6l255_tentant_term1());
					elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_NAME2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_name2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_name2());
					elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_LOCATION2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_location2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_location2());
					elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_RENT2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_rent2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_rent2());
					elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_SECURITY_DEPOSIT2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_security_deposit2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_security_deposit2());
					elements.put(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_TERM2_VALUE, StringUtils.isEmpty(njr118DO.getP6l256_tentant_term2()) ? ElementsCommon.EMPTY : njr118DO.getP6l256_tentant_term2());
					elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_NAME3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_name3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_name3());
					elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_LOCATION3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_location3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_location3());
					elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_RENT3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_rent3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_rent3());
					elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_SECURITY_DEPOSIT3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_security_deposit3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_security_deposit3());
					elements.put(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_TERM3_VALUE, StringUtils.isEmpty(njr118DO.getP6l257_tentant_term3()) ? ElementsCommon.EMPTY : njr118DO.getP6l257_tentant_term3());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P6L265_LEAD_BASED_PAINT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p6l265_lead_based_paint()) ? ElementsCommon.EMPTY : njr118DO.is_p6l265_lead_based_paint());
					//elements.put(ElementsNjr118.OFL_NJR118_P6L265_LEAD_BASED_PAINT_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p6l265_lead_based_paint()) ? ElementsCommon.EMPTY : njr118DO.is_p6l265_lead_based_paint());
					elements.put(ElementsNjr118.OFL_NJR118_P6_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP6_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP6_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P6_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP6_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP6_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P7L296_SELLER_NO_DAYS_RECEIPT_OF_AMENDMENT_VALUE, StringUtils.isEmpty(njr118DO.getP7l296_seller_no_days_receipt_of_amendment()) ? ElementsCommon.EMPTY : njr118DO.getP7l296_seller_no_days_receipt_of_amendment());
					elements.put(ElementsNjr118.OFL_NJR118_P7L298_BUYER_NO_DAYS_RECEIPT_OF_COUNTERPROPOSAL_VALUE, StringUtils.isEmpty(njr118DO.getP7l298_buyer_no_days_receipt_of_counterproposal()) ? ElementsCommon.EMPTY : njr118DO.getP7l298_buyer_no_days_receipt_of_counterproposal());
					//is
					/*elements.put(ElementsNjr118.OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l302_private_well_testing()) ? ElementsCommon.EMPTY : njr118DO.is_p7l302_private_well_testing());
					elements.put(ElementsNjr118.OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l302_private_well_testing()) ? ElementsCommon.EMPTY : njr118DO.is_p7l302_private_well_testing());
					elements.put(ElementsNjr118.OFL_NJR118_P7L327_POET_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l327_poet()) ? ElementsCommon.EMPTY : njr118DO.is_p7l327_poet());
					elements.put(ElementsNjr118.OFL_NJR118_P7L327_POET_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l327_poet()) ? ElementsCommon.EMPTY : njr118DO.is_p7l327_poet());
					elements.put(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l332_cesspool_requirements()) ? ElementsCommon.EMPTY : njr118DO.is_p7l332_cesspool_requirements());
					elements.put(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l332_cesspool_requirements()) ? ElementsCommon.EMPTY : njr118DO.is_p7l332_cesspool_requirements());
					elements.put(ElementsNjr118.OFL_NJR118_P7L339_SELLER_REPRESENTS_NO_CESSPOOL_VALUE, StringUtils.isEmpty(njr118DO.is_p7l339_one_or_more_cesspool()) ? ElementsCommon.EMPTY : njr118DO.is_p7l339_one_or_more_cesspool());
					elements.put(ElementsNjr118.OFL_NJR118_P7L339_ONE_OR_MORE_CESSPOOL_VALUE, StringUtils.isEmpty(njr118DO.is_p7l339_one_or_more_cesspool()) ? ElementsCommon.EMPTY : njr118DO.is_p7l339_one_or_more_cesspool());
					elements.put(ElementsNjr118.OFL_NJR118_P7L342_SELLER_AGREES_SOLE_COST_EXPENSE_VALUE, StringUtils.isEmpty(njr118DO.is_p7l342_seller_agrees_sole_cost_expense()) ? ElementsCommon.EMPTY : njr118DO.is_p7l342_seller_agrees_sole_cost_expense());
					*/
					elements.put(ElementsNjr118.OFL_NJR118_P7_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP7_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP7_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P7_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP7_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP7_sellers_initials());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P8L355_BUYER_AGREES_SOLE_COST_EXPENSE_VALUE, StringUtils.isEmpty(njr118DO.is_p8l355_buyer_agrees_sole_cost_expense()) ? ElementsCommon.EMPTY : njr118DO.is_p8l355_buyer_agrees_sole_cost_expense());
					elements.put(ElementsNjr118.OFL_NJR118_P8_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP8_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP8_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P8_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP8_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP8_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P9_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP9_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP9_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P9_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP9_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP9_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P10_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP10_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP10_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P10_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP10_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP10_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P11_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP11_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP11_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P11_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP11_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP11_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P12L608_NAME_OF_FIRM_VALUE, StringUtils.isEmpty(njr118DO.getP12l608_name_of_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l608_name_of_firm());
					elements.put(ElementsNjr118.OFL_NJR118_P12L609_NAME_OF_SALES_REP_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
					//List - getP12l611_sales_person_operating_as_List
					elements.put(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_SELLERS_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
					elements.put(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_BUYERS_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
					elements.put(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_DISCLOSED_DUAL_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
					elements.put(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_TRANSACTION_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP12l609_name_of_sales_rep()) ? ElementsCommon.EMPTY : njr118DO.getP12l609_name_of_sales_rep());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P12L613_NAME_OF_OTHER_FIRM_VALUE, StringUtils.isEmpty(njr118DO.getP12l613_name_of_other_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l613_name_of_other_firm());
					//List - getP12l615_other_firm_operating_as_List
					elements.put(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_SELLERS_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l613_name_of_other_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l613_name_of_other_firm());
					elements.put(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_BUYERS_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l613_name_of_other_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l613_name_of_other_firm());
					elements.put(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_TRANSACTION_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP12l613_name_of_other_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l613_name_of_other_firm());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP12l623_listing_firm_name()) ? ElementsCommon.EMPTY : njr118DO.getP12l623_listing_firm_name());
					elements.put(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_REC_LICENSE_ID_VALUE, StringUtils.isEmpty(njr118DO.getP12l623_listing_firm_rec_license_id()) ? ElementsCommon.EMPTY : njr118DO.getP12l623_listing_firm_rec_license_id());
					elements.put(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP12l626_listing_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP12l626_listing_agent_name());
					elements.put(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_REC_LICENSE_ID_VALUE, StringUtils.isEmpty(njr118DO.getP12l626_listing_agent_rec_license_id()) ? ElementsCommon.EMPTY : njr118DO.getP12l626_listing_agent_rec_license_id());
					elements.put(ElementsNjr118.OFL_NJR118_P12L629_LISTING_ADDRESS_VALUE, StringUtils.isEmpty(njr118DO.getP12l629_listing_address()) ? ElementsCommon.EMPTY : njr118DO.getP12l629_listing_address());
					elements.put(ElementsNjr118.OFL_NJR118_P12L631_LISTING_OFFICE_PHONE_VALUE, StringUtils.isEmpty(njr118DO.getP12l631_listing_office_phone()) ? ElementsCommon.EMPTY : njr118DO.getP12l631_listing_fax());
					elements.put(ElementsNjr118.OFL_NJR118_P12L631_LISTING_FAX_VALUE, StringUtils.isEmpty(njr118DO.getP12l631_listing_fax()) ? ElementsCommon.EMPTY : njr118DO.getP12l631_listing_fax());
					elements.put(ElementsNjr118.OFL_NJR118_P12L631_LISTING_AGENT_CELLPHONE_VALUE, StringUtils.isEmpty(njr118DO.getP12l631_listing_agent_cellphone()) ? ElementsCommon.EMPTY : njr118DO.getP12l631_listing_agent_cellphone());
					elements.put(ElementsNjr118.OFL_NJR118_P12L634_LISTING_EMAIL_VALUE, StringUtils.isEmpty(njr118DO.getP12l634_listing_email()) ? ElementsCommon.EMPTY : njr118DO.getP12l634_listing_email());
					elements.put(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_VALUE, StringUtils.isEmpty(njr118DO.getP12l636_participating_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l636_participating_firm());
					elements.put(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_REC_LICENSE_ID_VALUE, StringUtils.isEmpty(njr118DO.getP12l636_participating_firm_rec_license_id()) ? ElementsCommon.EMPTY : njr118DO.getP12l636_participating_firm_rec_license_id());
					elements.put(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_VALUE, StringUtils.isEmpty(njr118DO.getP12l639_participating_agent()) ? ElementsCommon.EMPTY : njr118DO.getP12l639_participating_agent());
					elements.put(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_REC_LICENSE_ID_VALUE, StringUtils.isEmpty(njr118DO.getP12l639_participating_agent_rec_license_id()) ? ElementsCommon.EMPTY : njr118DO.getP12l639_participating_agent_rec_license_id());
					elements.put(ElementsNjr118.OFL_NJR118_P12L641_PARTICIPATING_ADDRESS_VALUE, StringUtils.isEmpty(njr118DO.getP12l641_participating_address()) ? ElementsCommon.EMPTY : njr118DO.getP12l641_participating_address());
					elements.put(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_OFFICE_PHONE_VALUE, StringUtils.isEmpty(njr118DO.getP12l643_participating_office_phone()) ? ElementsCommon.EMPTY : njr118DO.getP12l643_participating_office_phone());
					elements.put(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_FAX_VALUE, StringUtils.isEmpty(njr118DO.getP12l643_participating_fax()) ? ElementsCommon.EMPTY : njr118DO.getP12l643_participating_fax());
					elements.put(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_AGENT_CELLPHONE_VALUE, StringUtils.isEmpty(njr118DO.getP12l643_participating_agent_cellphone()) ? ElementsCommon.EMPTY : njr118DO.getP12l643_participating_agent_cellphone());
					elements.put(ElementsNjr118.OFL_NJR118_P12L646_PARTICIPATING_EMAIL_VALUE, StringUtils.isEmpty(njr118DO.getP12l646_participating_email()) ? ElementsCommon.EMPTY : njr118DO.getP12l646_participating_email());
					elements.put(ElementsNjr118.OFL_NJR118_P12L649_COMMISION_DUE_PARTICIPATING_FIRM_VALUE, StringUtils.isEmpty(njr118DO.getP12l649_commission_due_participating_firm()) ? ElementsCommon.EMPTY : njr118DO.getP12l649_commission_due_participating_firm());
					elements.put(ElementsNjr118.OFL_NJR118_P12_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP12_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP12_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P12_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP12_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP12_sellers_initials());
					//is
					//elements.put(ElementsNjr118.OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p13l651_disclosure_real_estate_license()) ? ElementsCommon.EMPTY : njr118DO.is_p13l651_disclosure_real_estate_license());
					//elements.put(ElementsNjr118.OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_NOT_APPLICABLE_VALUE, StringUtils.isEmpty(njr118DO.is_p13l651_disclosure_real_estate_license()) ? ElementsCommon.EMPTY : njr118DO.is_p13l651_disclosure_real_estate_license());
					elements.put(ElementsNjr118.OFL_NJR118_P13L653_DISCLOSURE_AGENT_NAME_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
					//List  - getP13l654_disclosure_agent
					elements.put(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
					elements.put(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_SALESPERSON_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
					elements.put(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_SALESPERSON_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
					elements.put(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_REFERRAL_VALUE, StringUtils.isEmpty(njr118DO.getP13l653_disclosure_agent_name()) ? ElementsCommon.EMPTY : njr118DO.getP13l653_disclosure_agent_name());
					//
					elements.put(ElementsNjr118.OFL_NJR118_P13_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP13_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP13_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P13_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP13_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP13_sellers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P14L712_ADDITIONAL_PROVISIONS_01_VALUE, StringUtils.isEmpty(njr118DO.getP14l712_additional_provisions_01()) ? ElementsCommon.EMPTY : njr118DO.getP14l712_additional_provisions_01());
					elements.put(ElementsNjr118.OFL_NJR118_P14L713_ADDITIONAL_PROVISIONS_02_VALUE, StringUtils.isEmpty(njr118DO.getP14l713_additional_provisions_02()) ? ElementsCommon.EMPTY : njr118DO.getP14l713_additional_provisions_02());
					elements.put(ElementsNjr118.OFL_NJR118_P14L714_ADDITIONAL_PROVISIONS_03_VALUE, StringUtils.isEmpty(njr118DO.getP14l714_additional_provisions_03()) ? ElementsCommon.EMPTY : njr118DO.getP14l714_additional_provisions_03());
					elements.put(ElementsNjr118.OFL_NJR118_P14L715_ADDITIONAL_PROVISIONS_04_VALUE, StringUtils.isEmpty(njr118DO.getP14l715_additional_provisions_04()) ? ElementsCommon.EMPTY : njr118DO.getP14l715_additional_provisions_04());
					elements.put(ElementsNjr118.OFL_NJR118_P14L716_ADDITIONAL_PROVISIONS_05_VALUE, StringUtils.isEmpty(njr118DO.getP14l716_additional_provisions_05()) ? ElementsCommon.EMPTY : njr118DO.getP14l716_additional_provisions_05());
					elements.put(ElementsNjr118.OFL_NJR118_P14L717_ADDITIONAL_PROVISIONS_06_VALUE, StringUtils.isEmpty(njr118DO.getP14l717_additional_provisions_06()) ? ElementsCommon.EMPTY : njr118DO.getP14l717_additional_provisions_06());
					elements.put(ElementsNjr118.OFL_NJR118_P14L718_ADDITIONAL_PROVISIONS_07_VALUE, StringUtils.isEmpty(njr118DO.getP14l718_additional_provisions_07()) ? ElementsCommon.EMPTY : njr118DO.getP14l718_additional_provisions_07());
					elements.put(ElementsNjr118.OFL_NJR118_P14L719_ADDITIONAL_PROVISIONS_08_VALUE, StringUtils.isEmpty(njr118DO.getP14l719_additional_provisions_08()) ? ElementsCommon.EMPTY : njr118DO.getP14l719_additional_provisions_08());
					elements.put(ElementsNjr118.OFL_NJR118_P14L720_ADDITIONAL_PROVISIONS_09_VALUE, StringUtils.isEmpty(njr118DO.getP14l720_additional_provisions_09()) ? ElementsCommon.EMPTY : njr118DO.getP14l720_additional_provisions_09());
					elements.put(ElementsNjr118.OFL_NJR118_P14L721_ADDITIONAL_PROVISIONS_10_VALUE, StringUtils.isEmpty(njr118DO.getP14l721_additional_provisions_10()) ? ElementsCommon.EMPTY : njr118DO.getP14l721_additional_provisions_10());
					elements.put(ElementsNjr118.OFL_NJR118_P14L722_ADDITIONAL_PROVISIONS_11_VALUE, StringUtils.isEmpty(njr118DO.getP14l722_additional_provisions_11()) ? ElementsCommon.EMPTY : njr118DO.getP14l722_additional_provisions_11());
					elements.put(ElementsNjr118.OFL_NJR118_P14L723_ADDITIONAL_PROVISIONS_12_VALUE, StringUtils.isEmpty(njr118DO.getP14l723_additional_provisions_12()) ? ElementsCommon.EMPTY : njr118DO.getP14l723_additional_provisions_12());
					elements.put(ElementsNjr118.OFL_NJR118_P14L724_ADDITIONAL_PROVISIONS_13_VALUE, StringUtils.isEmpty(njr118DO.getP14l724_additional_provisions_13()) ? ElementsCommon.EMPTY : njr118DO.getP14l724_additional_provisions_13());
					elements.put(ElementsNjr118.OFL_NJR118_P14L725_ADDITIONAL_PROVISIONS_14_VALUE, StringUtils.isEmpty(njr118DO.getP14l725_additional_provisions_14()) ? ElementsCommon.EMPTY : njr118DO.getP14l725_additional_provisions_14());
					elements.put(ElementsNjr118.OFL_NJR118_P14L726_ADDITIONAL_PROVISIONS_15_VALUE, StringUtils.isEmpty(njr118DO.getP14l726_additional_provisions_15()) ? ElementsCommon.EMPTY : njr118DO.getP14l726_additional_provisions_15());
					elements.put(ElementsNjr118.OFL_NJR118_P14L727_ADDITIONAL_PROVISIONS_16_VALUE, StringUtils.isEmpty(njr118DO.getP14l727_additional_provisions_16()) ? ElementsCommon.EMPTY : njr118DO.getP14l727_additional_provisions_16());
					elements.put(ElementsNjr118.OFL_NJR118_P14L728_ADDITIONAL_PROVISIONS_17_VALUE, StringUtils.isEmpty(njr118DO.getP14l728_additional_provisions_17()) ? ElementsCommon.EMPTY : njr118DO.getP14l728_additional_provisions_17());
					elements.put(ElementsNjr118.OFL_NJR118_P14L729_ADDITIONAL_PROVISIONS_18_VALUE, StringUtils.isEmpty(njr118DO.getP14l729_additional_provisions_18()) ? ElementsCommon.EMPTY : njr118DO.getP14l729_additional_provisions_18());
					elements.put(ElementsNjr118.OFL_NJR118_P14L730_ADDITIONAL_PROVISIONS_19_VALUE, StringUtils.isEmpty(njr118DO.getP14l730_additional_provisions_19()) ? ElementsCommon.EMPTY : njr118DO.getP14l730_additional_provisions_19());
					elements.put(ElementsNjr118.OFL_NJR118_P14L731_ADDITIONAL_PROVISIONS_20_VALUE, StringUtils.isEmpty(njr118DO.getP14l731_additional_provisions_20()) ? ElementsCommon.EMPTY : njr118DO.getP14l731_additional_provisions_20());
					elements.put(ElementsNjr118.OFL_NJR118_P14L732_ADDITIONAL_PROVISIONS_21_VALUE, StringUtils.isEmpty(njr118DO.getP14l732_additional_provisions_21()) ? ElementsCommon.EMPTY : njr118DO.getP14l732_additional_provisions_21());
					elements.put(ElementsNjr118.OFL_NJR118_P14L733_ADDITIONAL_PROVISIONS_22_VALUE, StringUtils.isEmpty(njr118DO.getP14l733_additional_provisions_22()) ? ElementsCommon.EMPTY : njr118DO.getP14l733_additional_provisions_22());
					elements.put(ElementsNjr118.OFL_NJR118_P14L734_ADDITIONAL_PROVISIONS_23_VALUE, StringUtils.isEmpty(njr118DO.getP14l734_additional_provisions_23()) ? ElementsCommon.EMPTY : njr118DO.getP14l734_additional_provisions_23());
					elements.put(ElementsNjr118.OFL_NJR118_P14L735_ADDITIONAL_PROVISIONS_24_VALUE, StringUtils.isEmpty(njr118DO.getP14l735_additional_provisions_24()) ? ElementsCommon.EMPTY : njr118DO.getP14l735_additional_provisions_24());
					elements.put(ElementsNjr118.OFL_NJR118_P14L736_ADDITIONAL_PROVISIONS_25_VALUE, StringUtils.isEmpty(njr118DO.getP14l736_additional_provisions_25()) ? ElementsCommon.EMPTY : njr118DO.getP14l736_additional_provisions_25());
					elements.put(ElementsNjr118.OFL_NJR118_P14L737_ADDITIONAL_PROVISIONS_26_VALUE, StringUtils.isEmpty(njr118DO.getP14l737_additional_provisions_26()) ? ElementsCommon.EMPTY : njr118DO.getP14l737_additional_provisions_26());
					elements.put(ElementsNjr118.OFL_NJR118_P14L738_ADDITIONAL_PROVISIONS_27_VALUE, StringUtils.isEmpty(njr118DO.getP14l738_additional_provisions_27()) ? ElementsCommon.EMPTY : njr118DO.getP14l738_additional_provisions_27());
					elements.put(ElementsNjr118.OFL_NJR118_P14L739_ADDITIONAL_PROVISIONS_28_VALUE, StringUtils.isEmpty(njr118DO.getP14l739_additional_provisions_28()) ? ElementsCommon.EMPTY : njr118DO.getP14l739_additional_provisions_28());
					elements.put(ElementsNjr118.OFL_NJR118_P14L742_PRESENCE1_VALUE, StringUtils.isEmpty(njr118DO.getP14l742_presence1()) ? ElementsCommon.EMPTY : njr118DO.getP14l742_presence1());
					elements.put(ElementsNjr118.OFL_NJR118_P14L742_DATE1_VALUE, StringUtils.isEmpty(njr118DO.getP14l742_date1()) ? ElementsCommon.EMPTY : njr118DO.getP14l742_date1());
					elements.put(ElementsNjr118.OFL_NJR118_P14L745_PRESENCE2_VALUE, StringUtils.isEmpty(njr118DO.getP14l745_presence2()) ? ElementsCommon.EMPTY : njr118DO.getP14l745_presence2());
					elements.put(ElementsNjr118.OFL_NJR118_P14L745_DATE2_VALUE, StringUtils.isEmpty(njr118DO.getP14l745_date2()) ? ElementsCommon.EMPTY : njr118DO.getP14l745_date2());
					elements.put(ElementsNjr118.OFL_NJR118_P14L748_PRESENCE3_VALUE, StringUtils.isEmpty(njr118DO.getP14l748_presence3()) ? ElementsCommon.EMPTY : njr118DO.getP14l748_presence3());
					elements.put(ElementsNjr118.OFL_NJR118_P14L748_DATE3_VALUE, StringUtils.isEmpty(njr118DO.getP14l748_date3()) ? ElementsCommon.EMPTY : njr118DO.getP14l748_date3());
					elements.put(ElementsNjr118.OFL_NJR118_P14L751_PRESENCE4_VALUE, StringUtils.isEmpty(njr118DO.getP14l751_presence4()) ? ElementsCommon.EMPTY : njr118DO.getP14l751_presence4());
					elements.put(ElementsNjr118.OFL_NJR118_P14L751_DATE4_VALUE, StringUtils.isEmpty(njr118DO.getP14l751_date4()) ? ElementsCommon.EMPTY : njr118DO.getP14l751_date4());
					elements.put(ElementsNjr118.OFL_NJR118_P14L751_SELLER2_VALUE, StringUtils.isEmpty(njr118DO.getP14l751_seller2()) ? ElementsCommon.EMPTY : njr118DO.getP14l751_seller2());
					elements.put(ElementsNjr118.OFL_NJR118_P14_BUYERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP14_buyers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP14_buyers_initials());
					elements.put(ElementsNjr118.OFL_NJR118_P14_SELLERS_INITIALS_VALUE, StringUtils.isEmpty(njr118DO.getP14_sellers_initials()) ? ElementsCommon.EMPTY : njr118DO.getP14_sellers_initials());
					byte[] elementsBytes = WebServiceGzipUtil.compress(gson.toJson(elements));
					quickEntryDO.setElements(elementsBytes);
					
					quickEntryDOList.add(quickEntryDO);
				}
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return quickEntryDOList;
	}
	
	public static Njr118DO transformToNjr118DO(QuickEntryDO quickEntryDO) {
		Njr118DO njr118DO = null;
		try {
			if(quickEntryDO != null || quickEntryDO.getElements() != null) {
				njr118DO = new Njr118DO();
				Gson gson = new Gson();
				Type typeOfT = new TypeToken<HashMap<String, String>>() {}.getType();
				if(StringUtils.isEmpty(njr118DO.getQuickEntryID())) {
					njr118DO.setQuickEntryID(String.valueOf(quickEntryDO.getQuickEntryID()));
				}
				if(StringUtils.isEmpty(njr118DO.getQuickEntryName())) {
					njr118DO.setQuickEntryName(quickEntryDO.getName());
				}
				if(StringUtils.isEmpty(njr118DO.getQuickEntryDescription())) {
					njr118DO.setQuickEntryDescription(quickEntryDO.getDescription());
				}
				if(StringUtils.isEmpty(njr118DO.getUuid())) {
					njr118DO.setUuid(quickEntryDO.getUuid());
				}
				String json = WebServiceGzipUtil.decompress(quickEntryDO.getElements());
				HashMap<String, String> elements = gson.fromJson(json, typeOfT);
				//njr118DO.setP1_real_estate_broker_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_SELLER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_SELLER_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.setP1_real_estate_broker_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BUYER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BUYER_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.setP1_real_estate_broker_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BOTH_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BOTH_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.setP1_real_estate_broker_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_NEITHER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_NEITHER_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP1_seller_name01(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME01_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_seller_date01(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE01_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_buyer_name01(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME01_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_buyer_date01(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE01_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_seller_name02(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME02_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_seller_date02(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE02_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_buyer_name02(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME02_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_buyer_date02(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE02_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_listing_broker(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_listing_broker_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_DATE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_selling_broker(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_selling_broker_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_DATE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP1_prepared_by_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_PREPARED_BY_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_PREPARED_BY_NAME_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l16_notes1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L16_NOTES1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L16_NOTES1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l17_notes2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L17_NOTES2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L17_NOTES2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l18_notes3(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L18_NOTES3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L18_NOTES3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l21_buyer_description1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l21_buyer_description2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l23_buyer_address1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L23_BUYER_ADDRESS1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L23_BUYER_ADDRESS1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l25_buyer_address2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L25_BUYER_ADDRESS2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L25_BUYER_ADDRESS2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l28_seller_description1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l28_seller_description2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l30_seller_address1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L30_SELLER_ADDRESS1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L30_SELLER_ADDRESS1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l32_seller_address2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L32_SELLER_ADDRESS2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L32_SELLER_ADDRESS2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l35_property_address(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L35_PROPERTY_ADDRESS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L35_PROPERTY_ADDRESS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l37_municipal_tax_map(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L37_MUNICIPAL_TAX_MAP_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L37_MUNICIPAL_TAX_MAP_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l37_county(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L37_COUNTY_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L37_COUNTY_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l39_as_lot(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L39_AS_LOT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L39_AS_LOT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l39_block(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L39_BLOCK_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L39_BLOCK_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l44_total_purchase_price(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L44_TOTAL_PURCHASE_PRICE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L44_TOTAL_PURCHASE_PRICE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l45_initial_deposit(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L45_INITIAL_DEPOSIT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L45_INITIAL_DEPOSIT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l46_additional_deposit(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L46_ADDITIONAL_DEPOSIT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L46_ADDITIONAL_DEPOSIT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l47_mortage(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L47_MORTAGE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L47_MORTAGE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2l48_balance_of_purchase_price(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L48_BALANCE_OF_PURCHASE_PRICE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L48_BALANCE_OF_PURCHASE_PRICE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P2_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP2_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P2_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//List - INITIAL_DEPOSIT_PAID_TO) ? elements.get(ElementsNjr118.//List - INITIAL_DEPOSIT_PAID_TO) : ElementsCommon.EMPTY);
				njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_LISTING_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_LISTING_BROKER_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_PARTICIPATING_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_PARTICIPATING_BROKER_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_BUYER_ATTORNEY_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_BUYER_ATTORNEY_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_TITLE_CO_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_TITLE_CO_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_DESCRIPTION_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_DESCRIPTION_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l53_initial_deposit_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_DATE_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP3l56_additional_deposit_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L56_ADDITIONAL_DEPOSIT_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L56_ADDITIONAL_DEPOSIT_DATE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l59_noninterest_bearing_trust_account(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L59_NONINTEREST_BEARING_TRUST_ACCOUNT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L59_NONINTEREST_BEARING_TRUST_ACCOUNT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l73_principal_amount(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_PRINCIPAL_AMOUNT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_PRINCIPAL_AMOUNT_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//List - getP3l73_type_of_mortage_List) ? elements.get(ElementsNjr118.//List - getP3l73_type_of_mortage_List) : ElementsCommon.EMPTY);
				njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_VA_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_VA_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_FHA_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_FHA_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_CONVENTIONAL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_CONVENTIONAL_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_DESCRIPTION_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_DESCRIPTION_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP3l74_term_of_mortgage(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L74_TERM_OF_MORTAGE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L74_TERM_OF_MORTAGE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l74_based_on_year_payment_schedule(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L74_BASED_ON_YEAR_PAYMENT_SCHEDULE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L74_BASED_ON_YEAR_PAYMENT_SCHEDULE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l77_commitment_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L77_COMMITMENT_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L77_COMMITMENT_DATE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l79_commitment_date_extended_no_of_days(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L79_COMMITMENT_DATE_EXTENDED_NO_OF_DAYS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L79_COMMITMENT_DATE_EXTENDED_NO_OF_DAYS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l80_closing_date_extended_no_of_days(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L80_CLOSING_DATE_EXTENDED_NO_OF_DAYS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L80_CLOSING_DATE_EXTENDED_NO_OF_DAYS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l92_payment_of_balance_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L92_PAYMENT_OF_BALANCE_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L92_PAYMENT_OF_BALANCE_DATE_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p3l95_FHA_VA_loan(elements.containsKey(ElementsNjr118.//OFL_NJR118_P3L95_FHA_VA_LOANS_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P3L95_FHA_VA_LOANS_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.is_p3l95_FHA_VA_loan(elements.containsKey(ElementsNjr118.//OFL_NJR118_P3L95_FHA_VA_LOANS_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P3L95_FHA_VA_LOANS_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p3l103_buyer_property_sale_contingency(elements.containsKey(ElementsNjr118.//OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.is_p3l103_buyer_property_sale_contingency(elements.containsKey(ElementsNjr118.//OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP3l104_buyer_property_contingent_address1(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L104_BUYER_PROPERTY_CONTINGENT_ADDRESS1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L104_BUYER_PROPERTY_CONTINGENT_ADDRESS1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l105_buyer_property_contingent_address2(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L105_BUYER_PROPERTY_CONTINGENT_ADDRESS2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L105_BUYER_PROPERTY_CONTINGENT_ADDRESS2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3l105_sale_contingency_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L105_SALE_CONTINGENCY_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L105_SALE_CONTINGENCY_DATE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P3_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP3_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P3_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l122_contract_of_sale_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L122_CONTRACT_OF_SALE_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L122_CONTRACT_OF_SALE_DATE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l150_items_included_in_sale1(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L150_ITEMS_INCLUDED_IN_SALE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L150_ITEMS_INCLUDED_IN_SALE1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l151_items_included_in_sale2(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L151_ITEMS_INCLUDED_IN_SALE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L151_ITEMS_INCLUDED_IN_SALE2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l152_items_included_in_sale3(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L152_ITEMS_INCLUDED_IN_SALE3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L152_ITEMS_INCLUDED_IN_SALE3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l153_items_included_in_sale4(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L153_ITEMS_INCLUDED_IN_SALE4_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L153_ITEMS_INCLUDED_IN_SALE4_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l154_items_included_in_sale5(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L154_ITEMS_INCLUDED_IN_SALE5_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L154_ITEMS_INCLUDED_IN_SALE5_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l155_items_included_in_sale6(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L155_ITEMS_INCLUDED_IN_SALE6_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L155_ITEMS_INCLUDED_IN_SALE6_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l156_items_included_in_sale7(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L156_ITEMS_INCLUDED_IN_SALE7_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L156_ITEMS_INCLUDED_IN_SALE7_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l158_items_excluded_from_sale1(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L158_ITEMS_EXCLUDED_FROM_SALE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L158_ITEMS_EXCLUDED_FROM_SALE1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l159_items_excluded_from_sale2(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L159_ITEMS_EXCLUDED_FROM_SALE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L159_ITEMS_EXCLUDED_FROM_SALE2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l160_items_excluded_from_sale3(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L160_ITEMS_EXCLUDED_FROM_SALE3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L160_ITEMS_EXCLUDED_FROM_SALE3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l161_items_excluded_from_sale4(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L161_ITEMS_EXCLUDED_FROM_SALE4_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L161_ITEMS_EXCLUDED_FROM_SALE4_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l162_items_excluded_from_sale5(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L162_ITEMS_EXCLUDED_FROM_SALE5_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L162_ITEMS_EXCLUDED_FROM_SALE5_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l163_items_excluded_from_sale6(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L163_ITEMS_EXCLUDED_FROM_SALE6_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L163_ITEMS_EXCLUDED_FROM_SALE6_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4l164_items_excluded_from_sale7(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L164_ITEMS_EXCLUDED_FROM_SALE7_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L164_ITEMS_EXCLUDED_FROM_SALE7_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P4_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP4_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P4_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP5l177_amount_expense_exceeds_to_seller(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L177_AMOUNT_EXPENSE_EXCEEDS_TO_SELLER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L177_AMOUNT_EXPENSE_EXCEEDS_TO_SELLER_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p5l183_condo_home_associations(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.is_p5l183_condo_home_associations(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP5l187_condo_home_associations_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L187_CONDO_HOME_ASSOCIATIONS_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L187_CONDO_HOME_ASSOCIATIONS_NAME_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP5l188_condo_home_associations_contact_info1(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L188_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L188_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP5l189_condo_home_associations_contact_info2(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L189_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L189_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP5l196_condo_home_associations_fee_amount(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L196_CONDO_HOME_ASSOCIATIONS_FEE_AMOUNT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L196_CONDO_HOME_ASSOCIATIONS_FEE_AMOUNT_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP5l201_condo_home_associations_assessments_by_buyer_amount(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_AMOUNT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_AMOUNT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP5l201_condo_home_associations_assessments_by_buyer_purpose1(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP5l202_condo_home_associations_assessments_by_buyer_purpose2(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L202_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L202_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE2_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_BEEN_NOTIFIED_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_BEEN_NOTIFIED_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_NOT_BEEN_NOTIFIED_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_NOT_BEEN_NOTIFIED_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP5_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P5_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP5_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P5_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l233_occupancy_of_property_as_family_residential_dwelling(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L233_OCCUPANCY_OF_PROPERTY_AS_FAMILY_RESIDENTIAL_DWELLING_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L233_OCCUPANCY_OF_PROPERTY_AS_FAMILY_RESIDENTIAL_DWELLING_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p6l246_tenancies(elements.containsKey(ElementsNjr118.//OFL_NJR118_P6L246_TENANCIES_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P6L246_TENANCIES_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.is_p6l246_tenancies(elements.containsKey(ElementsNjr118.//OFL_NJR118_P6L246_TENANCIES_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P6L246_TENANCIES_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l255_tentant_name1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_NAME1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_NAME1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l255_tentant_location1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_LOCATION1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_LOCATION1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l255_tentant_rent1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_RENT1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_RENT1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l255_tentant_security_deposit1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_SECURITY_DEPOSIT1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_SECURITY_DEPOSIT1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l255_tentant_term1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_TERM1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_TERM1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l256_tentant_name2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_NAME2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_NAME2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l256_tentant_location2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_LOCATION2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_LOCATION2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l256_tentant_rent2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_RENT2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_RENT2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l256_tentant_security_deposit2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_SECURITY_DEPOSIT2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_SECURITY_DEPOSIT2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l256_tentant_term2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_TERM2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_TERM2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l257_tentant_name3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_NAME3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_NAME3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l257_tentant_location3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_LOCATION3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_LOCATION3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l257_tentant_rent3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_RENT3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_RENT3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l257_tentant_security_deposit3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_SECURITY_DEPOSIT3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_SECURITY_DEPOSIT3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6l257_tentant_term3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_TERM3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_TERM3_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p6l265_lead_based_paint(elements.containsKey(ElementsNjr118.//OFL_NJR118_P6L265_LEAD_BASED_PAINT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P6L265_LEAD_BASED_PAINT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.is_p6l265_lead_based_paint(elements.containsKey(ElementsNjr118.//OFL_NJR118_P6L265_LEAD_BASED_PAINT_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P6L265_LEAD_BASED_PAINT_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P6_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP6_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P6_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP7l296_seller_no_days_receipt_of_amendment(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L296_SELLER_NO_DAYS_RECEIPT_OF_AMENDMENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L296_SELLER_NO_DAYS_RECEIPT_OF_AMENDMENT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP7l298_buyer_no_days_receipt_of_counterproposal(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L298_BUYER_NO_DAYS_RECEIPT_OF_COUNTERPROPOSAL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L298_BUYER_NO_DAYS_RECEIPT_OF_COUNTERPROPOSAL_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p7l302_private_well_testing(elements.containsKey(ElementsNjr118./*OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_APPLICABLE_VALUE) ? elements.get(ElementsNjr118./*OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				/*njr118DO.is_p7l302_private_well_testing(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.is_p7l327_poet(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L327_POET_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L327_POET_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.is_p7l327_poet(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L327_POET_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L327_POET_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.is_p7l332_cesspool_requirements(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.is_p7l332_cesspool_requirements(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.is_p7l339_one_or_more_cesspool(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L339_SELLER_REPRESENTS_NO_CESSPOOL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L339_SELLER_REPRESENTS_NO_CESSPOOL_VALUE) : ElementsCommon.EMPTY);
				njr118DO.is_p7l339_one_or_more_cesspool(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L339_ONE_OR_MORE_CESSPOOL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L339_ONE_OR_MORE_CESSPOOL_VALUE) : ElementsCommon.EMPTY);
				njr118DO.is_p7l342_seller_agrees_sole_cost_expense(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L342_SELLER_AGREES_SOLE_COST_EXPENSE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L342_SELLER_AGREES_SOLE_COST_EXPENSE_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.*///) //? elements.get(ElementsNjr118.
						//*/) : ElementsCommon.EMPTY);
				njr118DO.setP7_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P7_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP7_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P7_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p8l355_buyer_agrees_sole_cost_expense(elements.containsKey(ElementsNjr118.//OFL_NJR118_P8L355_BUYER_AGREES_SOLE_COST_EXPENSE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P8L355_BUYER_AGREES_SOLE_COST_EXPENSE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP8_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P8_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P8_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP8_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P8_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P8_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP9_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P9_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P9_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP9_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P9_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P9_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP10_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P10_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P10_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP10_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P10_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P10_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP11_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P11_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P11_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP11_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P11_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P11_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l608_name_of_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L608_NAME_OF_FIRM_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L608_NAME_OF_FIRM_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L609_NAME_OF_SALES_REP_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L609_NAME_OF_SALES_REP_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//List - getP12l611_sales_person_operating_as_List) ? elements.get(ElementsNjr118.//List - getP12l611_sales_person_operating_as_List) : ElementsCommon.EMPTY);
				njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_SELLERS_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_SELLERS_AGENT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_BUYERS_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_BUYERS_AGENT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_DISCLOSED_DUAL_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_DISCLOSED_DUAL_AGENT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_TRANSACTION_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_TRANSACTION_BROKER_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP12l613_name_of_other_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L613_NAME_OF_OTHER_FIRM_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L613_NAME_OF_OTHER_FIRM_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//List - getP12l615_other_firm_operating_as_List) ? elements.get(ElementsNjr118.//List - getP12l615_other_firm_operating_as_List) : ElementsCommon.EMPTY);
				njr118DO.setP12l613_name_of_other_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_SELLERS_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_SELLERS_AGENT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l613_name_of_other_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_BUYERS_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_BUYERS_AGENT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l613_name_of_other_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_TRANSACTION_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_TRANSACTION_BROKER_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP12l623_listing_firm_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_NAME_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l623_listing_firm_rec_license_id(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_REC_LICENSE_ID_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_REC_LICENSE_ID_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l626_listing_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_NAME_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l626_listing_agent_rec_license_id(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_REC_LICENSE_ID_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_REC_LICENSE_ID_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l629_listing_address(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L629_LISTING_ADDRESS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L629_LISTING_ADDRESS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l631_listing_fax(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L631_LISTING_OFFICE_PHONE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L631_LISTING_OFFICE_PHONE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l631_listing_fax(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L631_LISTING_FAX_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L631_LISTING_FAX_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l631_listing_agent_cellphone(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L631_LISTING_AGENT_CELLPHONE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L631_LISTING_AGENT_CELLPHONE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l634_listing_email(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L634_LISTING_EMAIL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L634_LISTING_EMAIL_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l636_participating_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l636_participating_firm_rec_license_id(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_REC_LICENSE_ID_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_REC_LICENSE_ID_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l639_participating_agent(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l639_participating_agent_rec_license_id(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_REC_LICENSE_ID_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_REC_LICENSE_ID_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l641_participating_address(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L641_PARTICIPATING_ADDRESS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L641_PARTICIPATING_ADDRESS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l643_participating_office_phone(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_OFFICE_PHONE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_OFFICE_PHONE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l643_participating_fax(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_FAX_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_FAX_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l643_participating_agent_cellphone(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_AGENT_CELLPHONE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_AGENT_CELLPHONE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l646_participating_email(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L646_PARTICIPATING_EMAIL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L646_PARTICIPATING_EMAIL_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12l649_commission_due_participating_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L649_COMMISION_DUE_PARTICIPATING_FIRM_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L649_COMMISION_DUE_PARTICIPATING_FIRM_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P12_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP12_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P12_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
				//njr118DO.is_p13l651_disclosure_real_estate_license(elements.containsKey(ElementsNjr118.//OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				//njr118DO.is_p13l651_disclosure_real_estate_license(elements.containsKey(ElementsNjr118.//OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L653_DISCLOSURE_AGENT_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L653_DISCLOSURE_AGENT_NAME_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//List  - getP13l654_disclosure_agent) ? elements.get(ElementsNjr118.//List  - getP13l654_disclosure_agent) : ElementsCommon.EMPTY);
				njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_SALESPERSON_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_SALESPERSON_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_SALESPERSON_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_SALESPERSON_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_REFERRAL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_REFERRAL_VALUE) : ElementsCommon.EMPTY);
				//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
				njr118DO.setP13_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P13_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP13_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P13_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l712_additional_provisions_01(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L712_ADDITIONAL_PROVISIONS_01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L712_ADDITIONAL_PROVISIONS_01_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l713_additional_provisions_02(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L713_ADDITIONAL_PROVISIONS_02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L713_ADDITIONAL_PROVISIONS_02_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l714_additional_provisions_03(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L714_ADDITIONAL_PROVISIONS_03_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L714_ADDITIONAL_PROVISIONS_03_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l715_additional_provisions_04(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L715_ADDITIONAL_PROVISIONS_04_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L715_ADDITIONAL_PROVISIONS_04_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l716_additional_provisions_05(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L716_ADDITIONAL_PROVISIONS_05_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L716_ADDITIONAL_PROVISIONS_05_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l717_additional_provisions_06(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L717_ADDITIONAL_PROVISIONS_06_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L717_ADDITIONAL_PROVISIONS_06_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l718_additional_provisions_07(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L718_ADDITIONAL_PROVISIONS_07_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L718_ADDITIONAL_PROVISIONS_07_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l719_additional_provisions_08(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L719_ADDITIONAL_PROVISIONS_08_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L719_ADDITIONAL_PROVISIONS_08_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l720_additional_provisions_09(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L720_ADDITIONAL_PROVISIONS_09_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L720_ADDITIONAL_PROVISIONS_09_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l721_additional_provisions_10(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L721_ADDITIONAL_PROVISIONS_10_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L721_ADDITIONAL_PROVISIONS_10_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l722_additional_provisions_11(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L722_ADDITIONAL_PROVISIONS_11_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L722_ADDITIONAL_PROVISIONS_11_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l723_additional_provisions_12(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L723_ADDITIONAL_PROVISIONS_12_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L723_ADDITIONAL_PROVISIONS_12_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l724_additional_provisions_13(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L724_ADDITIONAL_PROVISIONS_13_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L724_ADDITIONAL_PROVISIONS_13_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l725_additional_provisions_14(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L725_ADDITIONAL_PROVISIONS_14_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L725_ADDITIONAL_PROVISIONS_14_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l726_additional_provisions_15(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L726_ADDITIONAL_PROVISIONS_15_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L726_ADDITIONAL_PROVISIONS_15_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l727_additional_provisions_16(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L727_ADDITIONAL_PROVISIONS_16_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L727_ADDITIONAL_PROVISIONS_16_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l728_additional_provisions_17(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L728_ADDITIONAL_PROVISIONS_17_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L728_ADDITIONAL_PROVISIONS_17_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l729_additional_provisions_18(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L729_ADDITIONAL_PROVISIONS_18_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L729_ADDITIONAL_PROVISIONS_18_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l730_additional_provisions_19(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L730_ADDITIONAL_PROVISIONS_19_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L730_ADDITIONAL_PROVISIONS_19_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l731_additional_provisions_20(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L731_ADDITIONAL_PROVISIONS_20_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L731_ADDITIONAL_PROVISIONS_20_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l732_additional_provisions_21(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L732_ADDITIONAL_PROVISIONS_21_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L732_ADDITIONAL_PROVISIONS_21_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l733_additional_provisions_22(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L733_ADDITIONAL_PROVISIONS_22_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L733_ADDITIONAL_PROVISIONS_22_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l734_additional_provisions_23(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L734_ADDITIONAL_PROVISIONS_23_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L734_ADDITIONAL_PROVISIONS_23_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l735_additional_provisions_24(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L735_ADDITIONAL_PROVISIONS_24_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L735_ADDITIONAL_PROVISIONS_24_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l736_additional_provisions_25(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L736_ADDITIONAL_PROVISIONS_25_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L736_ADDITIONAL_PROVISIONS_25_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l737_additional_provisions_26(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L737_ADDITIONAL_PROVISIONS_26_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L737_ADDITIONAL_PROVISIONS_26_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l738_additional_provisions_27(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L738_ADDITIONAL_PROVISIONS_27_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L738_ADDITIONAL_PROVISIONS_27_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l739_additional_provisions_28(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L739_ADDITIONAL_PROVISIONS_28_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L739_ADDITIONAL_PROVISIONS_28_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l742_presence1(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L742_PRESENCE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L742_PRESENCE1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l742_date1(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L742_DATE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L742_DATE1_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l745_presence2(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L745_PRESENCE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L745_PRESENCE2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l745_date2(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L745_DATE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L745_DATE2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l748_presence3(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L748_PRESENCE3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L748_PRESENCE3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l748_date3(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L748_DATE3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L748_DATE3_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l751_presence4(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L751_PRESENCE4_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L751_PRESENCE4_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l751_date4(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L751_DATE4_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L751_DATE4_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14l751_seller2(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L751_SELLER2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L751_SELLER2_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P14_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
				njr118DO.setP14_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P14_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return njr118DO;
	}
	
	public static List<Njr118DO> transformToNjr118DO(List<QuickEntryDO> quickEntryDOList) {
		List<Njr118DO> njr118DOList = null;
		try {
			if(quickEntryDOList != null || quickEntryDOList.size() > 0) {
				njr118DOList = new ArrayList<Njr118DO>();
				Gson gson = new Gson();
				Type typeOfT = new TypeToken<HashMap<String, String>>() {}.getType();
				for(QuickEntryDO quickEntryDO : quickEntryDOList) {
					if(quickEntryDO.getElements() != null) {
						Njr118DO njr118DO = new Njr118DO();
						if(StringUtils.isEmpty(njr118DO.getQuickEntryID())) {
							njr118DO.setQuickEntryID(String.valueOf(quickEntryDO.getQuickEntryID()));
						}
						if(StringUtils.isEmpty(njr118DO.getQuickEntryName())) {
							njr118DO.setQuickEntryName(quickEntryDO.getName());
						}
						if(StringUtils.isEmpty(njr118DO.getQuickEntryDescription())) {
							njr118DO.setQuickEntryDescription(quickEntryDO.getDescription());
						}
						if(StringUtils.isEmpty(njr118DO.getUuid())) {
							njr118DO.setUuid(quickEntryDO.getUuid());
						}
						
						String json =  WebServiceGzipUtil.decompress(quickEntryDO.getElements());
						HashMap<String, String> elements = gson.fromJson(json, typeOfT);
						//njr118DO.setP1_real_estate_broker_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_SELLER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_SELLER_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.setP1_real_estate_broker_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BUYER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BUYER_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.setP1_real_estate_broker_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BOTH_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_BOTH_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.setP1_real_estate_broker_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_NEITHER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_REAL_ESTATE_BROKER_REP_NEITHER_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP1_seller_name01(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME01_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_seller_date01(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE01_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_buyer_name01(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME01_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_buyer_date01(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE01_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_seller_name02(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLER_NAME02_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_seller_date02(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLER_DATE02_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_buyer_name02(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_BUYER_NAME02_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_buyer_date02(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_BUYER_DATE02_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_listing_broker(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_listing_broker_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_LISTING_BROKER_DATE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_selling_broker(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_selling_broker_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_SELLING_BROKER_DATE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP1_prepared_by_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P1_PREPARED_BY_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P1_PREPARED_BY_NAME_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l16_notes1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L16_NOTES1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L16_NOTES1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l17_notes2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L17_NOTES2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L17_NOTES2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l18_notes3(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L18_NOTES3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L18_NOTES3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l21_buyer_description1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l21_buyer_description2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L21_BUYER_DESCRIPTION2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l23_buyer_address1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L23_BUYER_ADDRESS1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L23_BUYER_ADDRESS1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l25_buyer_address2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L25_BUYER_ADDRESS2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L25_BUYER_ADDRESS2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l28_seller_description1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l28_seller_description2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L28_SELLER_DESCRIPTION2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l30_seller_address1(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L30_SELLER_ADDRESS1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L30_SELLER_ADDRESS1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l32_seller_address2(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L32_SELLER_ADDRESS2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L32_SELLER_ADDRESS2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l35_property_address(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L35_PROPERTY_ADDRESS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L35_PROPERTY_ADDRESS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l37_municipal_tax_map(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L37_MUNICIPAL_TAX_MAP_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L37_MUNICIPAL_TAX_MAP_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l37_county(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L37_COUNTY_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L37_COUNTY_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l39_as_lot(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L39_AS_LOT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L39_AS_LOT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l39_block(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L39_BLOCK_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L39_BLOCK_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l44_total_purchase_price(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L44_TOTAL_PURCHASE_PRICE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L44_TOTAL_PURCHASE_PRICE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l45_initial_deposit(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L45_INITIAL_DEPOSIT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L45_INITIAL_DEPOSIT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l46_additional_deposit(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L46_ADDITIONAL_DEPOSIT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L46_ADDITIONAL_DEPOSIT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l47_mortage(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L47_MORTAGE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L47_MORTAGE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2l48_balance_of_purchase_price(elements.containsKey(ElementsNjr118.OFL_NJR118_P2L48_BALANCE_OF_PURCHASE_PRICE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2L48_BALANCE_OF_PURCHASE_PRICE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P2_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP2_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P2_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P2_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//List - INITIAL_DEPOSIT_PAID_TO) ? elements.get(ElementsNjr118.//List - INITIAL_DEPOSIT_PAID_TO) : ElementsCommon.EMPTY);
						njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_LISTING_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_LISTING_BROKER_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_PARTICIPATING_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_PARTICIPATING_BROKER_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_BUYER_ATTORNEY_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_BUYER_ATTORNEY_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_TITLE_CO_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L52_INITIAL_DEPOSIT_PAID_TO_TITLE_CO_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l53_initial_deposit_paid_to_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_DESCRIPTION_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_PAID_TO_OTHER_DESCRIPTION_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l53_initial_deposit_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L53_INITIAL_DEPOSIT_DATE_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP3l56_additional_deposit_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L56_ADDITIONAL_DEPOSIT_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L56_ADDITIONAL_DEPOSIT_DATE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l59_noninterest_bearing_trust_account(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L59_NONINTEREST_BEARING_TRUST_ACCOUNT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L59_NONINTEREST_BEARING_TRUST_ACCOUNT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l73_principal_amount(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_PRINCIPAL_AMOUNT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_PRINCIPAL_AMOUNT_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//List - getP3l73_type_of_mortage_List) ? elements.get(ElementsNjr118.//List - getP3l73_type_of_mortage_List) : ElementsCommon.EMPTY);
						njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_VA_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_VA_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_FHA_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_FHA_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_CONVENTIONAL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_CONVENTIONAL_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l73_type_of_mortgage_other_description(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_DESCRIPTION_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L73_TYPE_OF_MORTAGE_OTHER_DESCRIPTION_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP3l74_term_of_mortgage(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L74_TERM_OF_MORTAGE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L74_TERM_OF_MORTAGE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l74_based_on_year_payment_schedule(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L74_BASED_ON_YEAR_PAYMENT_SCHEDULE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L74_BASED_ON_YEAR_PAYMENT_SCHEDULE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l77_commitment_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L77_COMMITMENT_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L77_COMMITMENT_DATE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l79_commitment_date_extended_no_of_days(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L79_COMMITMENT_DATE_EXTENDED_NO_OF_DAYS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L79_COMMITMENT_DATE_EXTENDED_NO_OF_DAYS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l80_closing_date_extended_no_of_days(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L80_CLOSING_DATE_EXTENDED_NO_OF_DAYS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L80_CLOSING_DATE_EXTENDED_NO_OF_DAYS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l92_payment_of_balance_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L92_PAYMENT_OF_BALANCE_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L92_PAYMENT_OF_BALANCE_DATE_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p3l95_FHA_VA_loan(elements.containsKey(ElementsNjr118.//OFL_NJR118_P3L95_FHA_VA_LOANS_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P3L95_FHA_VA_LOANS_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.is_p3l95_FHA_VA_loan(elements.containsKey(ElementsNjr118.//OFL_NJR118_P3L95_FHA_VA_LOANS_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P3L95_FHA_VA_LOANS_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p3l103_buyer_property_sale_contingency(elements.containsKey(ElementsNjr118.//OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.is_p3l103_buyer_property_sale_contingency(elements.containsKey(ElementsNjr118.//OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P3L103_BUYER_PROPERTY_SALE_CONTINGENCY_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP3l104_buyer_property_contingent_address1(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L104_BUYER_PROPERTY_CONTINGENT_ADDRESS1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L104_BUYER_PROPERTY_CONTINGENT_ADDRESS1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l105_buyer_property_contingent_address2(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L105_BUYER_PROPERTY_CONTINGENT_ADDRESS2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L105_BUYER_PROPERTY_CONTINGENT_ADDRESS2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3l105_sale_contingency_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P3L105_SALE_CONTINGENCY_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3L105_SALE_CONTINGENCY_DATE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P3_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP3_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P3_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P3_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l122_contract_of_sale_date(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L122_CONTRACT_OF_SALE_DATE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L122_CONTRACT_OF_SALE_DATE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l150_items_included_in_sale1(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L150_ITEMS_INCLUDED_IN_SALE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L150_ITEMS_INCLUDED_IN_SALE1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l151_items_included_in_sale2(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L151_ITEMS_INCLUDED_IN_SALE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L151_ITEMS_INCLUDED_IN_SALE2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l152_items_included_in_sale3(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L152_ITEMS_INCLUDED_IN_SALE3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L152_ITEMS_INCLUDED_IN_SALE3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l153_items_included_in_sale4(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L153_ITEMS_INCLUDED_IN_SALE4_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L153_ITEMS_INCLUDED_IN_SALE4_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l154_items_included_in_sale5(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L154_ITEMS_INCLUDED_IN_SALE5_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L154_ITEMS_INCLUDED_IN_SALE5_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l155_items_included_in_sale6(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L155_ITEMS_INCLUDED_IN_SALE6_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L155_ITEMS_INCLUDED_IN_SALE6_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l156_items_included_in_sale7(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L156_ITEMS_INCLUDED_IN_SALE7_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L156_ITEMS_INCLUDED_IN_SALE7_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l158_items_excluded_from_sale1(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L158_ITEMS_EXCLUDED_FROM_SALE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L158_ITEMS_EXCLUDED_FROM_SALE1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l159_items_excluded_from_sale2(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L159_ITEMS_EXCLUDED_FROM_SALE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L159_ITEMS_EXCLUDED_FROM_SALE2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l160_items_excluded_from_sale3(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L160_ITEMS_EXCLUDED_FROM_SALE3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L160_ITEMS_EXCLUDED_FROM_SALE3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l161_items_excluded_from_sale4(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L161_ITEMS_EXCLUDED_FROM_SALE4_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L161_ITEMS_EXCLUDED_FROM_SALE4_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l162_items_excluded_from_sale5(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L162_ITEMS_EXCLUDED_FROM_SALE5_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L162_ITEMS_EXCLUDED_FROM_SALE5_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l163_items_excluded_from_sale6(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L163_ITEMS_EXCLUDED_FROM_SALE6_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L163_ITEMS_EXCLUDED_FROM_SALE6_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4l164_items_excluded_from_sale7(elements.containsKey(ElementsNjr118.OFL_NJR118_P4L164_ITEMS_EXCLUDED_FROM_SALE7_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4L164_ITEMS_EXCLUDED_FROM_SALE7_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P4_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP4_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P4_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P4_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP5l177_amount_expense_exceeds_to_seller(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L177_AMOUNT_EXPENSE_EXCEEDS_TO_SELLER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L177_AMOUNT_EXPENSE_EXCEEDS_TO_SELLER_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p5l183_condo_home_associations(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.is_p5l183_condo_home_associations(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L183_CONDO_HOME_ASSOCIATIONS_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP5l187_condo_home_associations_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L187_CONDO_HOME_ASSOCIATIONS_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L187_CONDO_HOME_ASSOCIATIONS_NAME_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP5l188_condo_home_associations_contact_info1(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L188_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L188_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP5l189_condo_home_associations_contact_info2(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L189_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L189_CONDO_HOME_ASSOCIATIONS_CONTACT_INFO2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP5l196_condo_home_associations_fee_amount(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L196_CONDO_HOME_ASSOCIATIONS_FEE_AMOUNT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L196_CONDO_HOME_ASSOCIATIONS_FEE_AMOUNT_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.is_p5l199_condo_home_associations_assessments_not_applicable(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L199_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP5l201_condo_home_associations_assessments_by_buyer_amount(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_AMOUNT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_AMOUNT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP5l201_condo_home_associations_assessments_by_buyer_purpose1(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L201_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP5l202_condo_home_associations_assessments_by_buyer_purpose2(elements.containsKey(ElementsNjr118.OFL_NJR118_P5L202_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5L202_CONDO_HOME_ASSOCIATIONS_ASSESSMENTS_BY_BUYER_PURPOSE2_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_BEEN_NOTIFIED_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_BEEN_NOTIFIED_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.is_p5l211_municipal_assessments_seller_has_not_been_notified(elements.containsKey(ElementsNjr118.//OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_NOT_BEEN_NOTIFIED_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P5L211_MUNICIPAL_ASSESSMENTS_SELLER_HAS_NOT_BEEN_NOTIFIED_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP5_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P5_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP5_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P5_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P5_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l233_occupancy_of_property_as_family_residential_dwelling(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L233_OCCUPANCY_OF_PROPERTY_AS_FAMILY_RESIDENTIAL_DWELLING_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L233_OCCUPANCY_OF_PROPERTY_AS_FAMILY_RESIDENTIAL_DWELLING_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p6l246_tenancies(elements.containsKey(ElementsNjr118.//OFL_NJR118_P6L246_TENANCIES_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P6L246_TENANCIES_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.is_p6l246_tenancies(elements.containsKey(ElementsNjr118.//OFL_NJR118_P6L246_TENANCIES_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P6L246_TENANCIES_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l255_tentant_name1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_NAME1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_NAME1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l255_tentant_location1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_LOCATION1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_LOCATION1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l255_tentant_rent1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_RENT1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_RENT1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l255_tentant_security_deposit1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_SECURITY_DEPOSIT1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_SECURITY_DEPOSIT1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l255_tentant_term1(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_TERM1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L255_TENTANT_TERM1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l256_tentant_name2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_NAME2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_NAME2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l256_tentant_location2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_LOCATION2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_LOCATION2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l256_tentant_rent2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_RENT2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_RENT2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l256_tentant_security_deposit2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_SECURITY_DEPOSIT2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_SECURITY_DEPOSIT2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l256_tentant_term2(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_TERM2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L256_TENTANT_TERM2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l257_tentant_name3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_NAME3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_NAME3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l257_tentant_location3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_LOCATION3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_LOCATION3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l257_tentant_rent3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_RENT3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_RENT3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l257_tentant_security_deposit3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_SECURITY_DEPOSIT3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_SECURITY_DEPOSIT3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6l257_tentant_term3(elements.containsKey(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_TERM3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6L257_TENTANT_TERM3_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p6l265_lead_based_paint(elements.containsKey(ElementsNjr118.//OFL_NJR118_P6L265_LEAD_BASED_PAINT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P6L265_LEAD_BASED_PAINT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.is_p6l265_lead_based_paint(elements.containsKey(ElementsNjr118.//OFL_NJR118_P6L265_LEAD_BASED_PAINT_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P6L265_LEAD_BASED_PAINT_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P6_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP6_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P6_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P6_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP7l296_seller_no_days_receipt_of_amendment(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L296_SELLER_NO_DAYS_RECEIPT_OF_AMENDMENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L296_SELLER_NO_DAYS_RECEIPT_OF_AMENDMENT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP7l298_buyer_no_days_receipt_of_counterproposal(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L298_BUYER_NO_DAYS_RECEIPT_OF_COUNTERPROPOSAL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L298_BUYER_NO_DAYS_RECEIPT_OF_COUNTERPROPOSAL_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p7l302_private_well_testing(elements.containsKey(ElementsNjr118./*OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_APPLICABLE_VALUE) ? elements.get(ElementsNjr118./*OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						/*njr118DO.is_p7l302_private_well_testing(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L302_PRIVATE_WELL_TESTING_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.is_p7l327_poet(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L327_POET_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L327_POET_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.is_p7l327_poet(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L327_POET_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L327_POET_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.is_p7l332_cesspool_requirements(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.is_p7l332_cesspool_requirements(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L332_CESSPOOL_REQUIREMENTS_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.is_p7l339_one_or_more_cesspool(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L339_SELLER_REPRESENTS_NO_CESSPOOL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L339_SELLER_REPRESENTS_NO_CESSPOOL_VALUE) : ElementsCommon.EMPTY);
						njr118DO.is_p7l339_one_or_more_cesspool(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L339_ONE_OR_MORE_CESSPOOL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L339_ONE_OR_MORE_CESSPOOL_VALUE) : ElementsCommon.EMPTY);
						njr118DO.is_p7l342_seller_agrees_sole_cost_expense(elements.containsKey(ElementsNjr118.OFL_NJR118_P7L342_SELLER_AGREES_SOLE_COST_EXPENSE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7L342_SELLER_AGREES_SOLE_COST_EXPENSE_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.*///) //? elements.get(ElementsNjr118.
								//*/) : ElementsCommon.EMPTY);
						njr118DO.setP7_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P7_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP7_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P7_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P7_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p8l355_buyer_agrees_sole_cost_expense(elements.containsKey(ElementsNjr118.//OFL_NJR118_P8L355_BUYER_AGREES_SOLE_COST_EXPENSE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P8L355_BUYER_AGREES_SOLE_COST_EXPENSE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP8_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P8_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P8_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP8_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P8_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P8_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP9_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P9_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P9_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP9_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P9_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P9_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP10_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P10_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P10_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP10_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P10_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P10_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP11_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P11_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P11_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP11_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P11_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P11_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l608_name_of_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L608_NAME_OF_FIRM_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L608_NAME_OF_FIRM_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L609_NAME_OF_SALES_REP_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L609_NAME_OF_SALES_REP_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//List - getP12l611_sales_person_operating_as_List) ? elements.get(ElementsNjr118.//List - getP12l611_sales_person_operating_as_List) : ElementsCommon.EMPTY);
						njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_SELLERS_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_SELLERS_AGENT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_BUYERS_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_BUYERS_AGENT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_DISCLOSED_DUAL_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_DISCLOSED_DUAL_AGENT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l609_name_of_sales_rep(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_TRANSACTION_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L611_DECLARATION_TRANSACTION_BROKER_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP12l613_name_of_other_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L613_NAME_OF_OTHER_FIRM_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L613_NAME_OF_OTHER_FIRM_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//List - getP12l615_other_firm_operating_as_List) ? elements.get(ElementsNjr118.//List - getP12l615_other_firm_operating_as_List) : ElementsCommon.EMPTY);
						njr118DO.setP12l613_name_of_other_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_SELLERS_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_SELLERS_AGENT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l613_name_of_other_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_BUYERS_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_BUYERS_AGENT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l613_name_of_other_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_TRANSACTION_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L615_SUPPLIED_BY_TRANSACTION_BROKER_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP12l623_listing_firm_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_NAME_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l623_listing_firm_rec_license_id(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_REC_LICENSE_ID_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L623_LISTING_FIRM_REC_LICENSE_ID_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l626_listing_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_NAME_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l626_listing_agent_rec_license_id(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_REC_LICENSE_ID_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L626_LISTING_AGENT_REC_LICENSE_ID_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l629_listing_address(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L629_LISTING_ADDRESS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L629_LISTING_ADDRESS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l631_listing_fax(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L631_LISTING_OFFICE_PHONE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L631_LISTING_OFFICE_PHONE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l631_listing_fax(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L631_LISTING_FAX_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L631_LISTING_FAX_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l631_listing_agent_cellphone(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L631_LISTING_AGENT_CELLPHONE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L631_LISTING_AGENT_CELLPHONE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l634_listing_email(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L634_LISTING_EMAIL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L634_LISTING_EMAIL_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l636_participating_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l636_participating_firm_rec_license_id(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_REC_LICENSE_ID_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L636_PARTICIPATING_FIRM_REC_LICENSE_ID_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l639_participating_agent(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l639_participating_agent_rec_license_id(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_REC_LICENSE_ID_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L639_PARTICIPATING_AGENT_REC_LICENSE_ID_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l641_participating_address(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L641_PARTICIPATING_ADDRESS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L641_PARTICIPATING_ADDRESS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l643_participating_office_phone(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_OFFICE_PHONE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_OFFICE_PHONE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l643_participating_fax(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_FAX_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_FAX_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l643_participating_agent_cellphone(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_AGENT_CELLPHONE_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L643_PARTICIPATING_AGENT_CELLPHONE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l646_participating_email(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L646_PARTICIPATING_EMAIL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L646_PARTICIPATING_EMAIL_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12l649_commission_due_participating_firm(elements.containsKey(ElementsNjr118.OFL_NJR118_P12L649_COMMISION_DUE_PARTICIPATING_FIRM_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12L649_COMMISION_DUE_PARTICIPATING_FIRM_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P12_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP12_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P12_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P12_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//is) ? elements.get(ElementsNjr118.//is) : ElementsCommon.EMPTY);
						//njr118DO.is_p13l651_disclosure_real_estate_license(elements.containsKey(ElementsNjr118.//OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						//njr118DO.is_p13l651_disclosure_real_estate_license(elements.containsKey(ElementsNjr118.//OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_NOT_APPLICABLE_VALUE) ? elements.get(ElementsNjr118.//OFL_NJR118_P13L651_DISCLOSURE_REAL_ESTATE_LICENSE_NOT_APPLICABLE_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L653_DISCLOSURE_AGENT_NAME_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L653_DISCLOSURE_AGENT_NAME_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//List  - getP13l654_disclosure_agent) ? elements.get(ElementsNjr118.//List  - getP13l654_disclosure_agent) : ElementsCommon.EMPTY);
						njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_SALESPERSON_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_BROKER_SALESPERSON_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_SALESPERSON_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_SALESPERSON_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP13l653_disclosure_agent_name(elements.containsKey(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_REFERRAL_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13L654_DISCLOSURE_AGENT_REFERRAL_VALUE) : ElementsCommon.EMPTY);
						//elements.containsKey(ElementsNjr118.//) ? elements.get(ElementsNjr118.//) : ElementsCommon.EMPTY);
						njr118DO.setP13_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P13_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP13_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P13_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P13_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l712_additional_provisions_01(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L712_ADDITIONAL_PROVISIONS_01_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L712_ADDITIONAL_PROVISIONS_01_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l713_additional_provisions_02(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L713_ADDITIONAL_PROVISIONS_02_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L713_ADDITIONAL_PROVISIONS_02_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l714_additional_provisions_03(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L714_ADDITIONAL_PROVISIONS_03_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L714_ADDITIONAL_PROVISIONS_03_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l715_additional_provisions_04(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L715_ADDITIONAL_PROVISIONS_04_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L715_ADDITIONAL_PROVISIONS_04_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l716_additional_provisions_05(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L716_ADDITIONAL_PROVISIONS_05_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L716_ADDITIONAL_PROVISIONS_05_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l717_additional_provisions_06(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L717_ADDITIONAL_PROVISIONS_06_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L717_ADDITIONAL_PROVISIONS_06_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l718_additional_provisions_07(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L718_ADDITIONAL_PROVISIONS_07_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L718_ADDITIONAL_PROVISIONS_07_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l719_additional_provisions_08(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L719_ADDITIONAL_PROVISIONS_08_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L719_ADDITIONAL_PROVISIONS_08_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l720_additional_provisions_09(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L720_ADDITIONAL_PROVISIONS_09_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L720_ADDITIONAL_PROVISIONS_09_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l721_additional_provisions_10(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L721_ADDITIONAL_PROVISIONS_10_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L721_ADDITIONAL_PROVISIONS_10_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l722_additional_provisions_11(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L722_ADDITIONAL_PROVISIONS_11_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L722_ADDITIONAL_PROVISIONS_11_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l723_additional_provisions_12(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L723_ADDITIONAL_PROVISIONS_12_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L723_ADDITIONAL_PROVISIONS_12_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l724_additional_provisions_13(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L724_ADDITIONAL_PROVISIONS_13_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L724_ADDITIONAL_PROVISIONS_13_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l725_additional_provisions_14(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L725_ADDITIONAL_PROVISIONS_14_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L725_ADDITIONAL_PROVISIONS_14_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l726_additional_provisions_15(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L726_ADDITIONAL_PROVISIONS_15_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L726_ADDITIONAL_PROVISIONS_15_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l727_additional_provisions_16(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L727_ADDITIONAL_PROVISIONS_16_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L727_ADDITIONAL_PROVISIONS_16_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l728_additional_provisions_17(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L728_ADDITIONAL_PROVISIONS_17_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L728_ADDITIONAL_PROVISIONS_17_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l729_additional_provisions_18(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L729_ADDITIONAL_PROVISIONS_18_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L729_ADDITIONAL_PROVISIONS_18_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l730_additional_provisions_19(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L730_ADDITIONAL_PROVISIONS_19_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L730_ADDITIONAL_PROVISIONS_19_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l731_additional_provisions_20(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L731_ADDITIONAL_PROVISIONS_20_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L731_ADDITIONAL_PROVISIONS_20_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l732_additional_provisions_21(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L732_ADDITIONAL_PROVISIONS_21_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L732_ADDITIONAL_PROVISIONS_21_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l733_additional_provisions_22(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L733_ADDITIONAL_PROVISIONS_22_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L733_ADDITIONAL_PROVISIONS_22_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l734_additional_provisions_23(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L734_ADDITIONAL_PROVISIONS_23_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L734_ADDITIONAL_PROVISIONS_23_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l735_additional_provisions_24(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L735_ADDITIONAL_PROVISIONS_24_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L735_ADDITIONAL_PROVISIONS_24_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l736_additional_provisions_25(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L736_ADDITIONAL_PROVISIONS_25_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L736_ADDITIONAL_PROVISIONS_25_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l737_additional_provisions_26(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L737_ADDITIONAL_PROVISIONS_26_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L737_ADDITIONAL_PROVISIONS_26_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l738_additional_provisions_27(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L738_ADDITIONAL_PROVISIONS_27_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L738_ADDITIONAL_PROVISIONS_27_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l739_additional_provisions_28(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L739_ADDITIONAL_PROVISIONS_28_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L739_ADDITIONAL_PROVISIONS_28_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l742_presence1(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L742_PRESENCE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L742_PRESENCE1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l742_date1(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L742_DATE1_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L742_DATE1_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l745_presence2(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L745_PRESENCE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L745_PRESENCE2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l745_date2(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L745_DATE2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L745_DATE2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l748_presence3(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L748_PRESENCE3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L748_PRESENCE3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l748_date3(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L748_DATE3_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L748_DATE3_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l751_presence4(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L751_PRESENCE4_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L751_PRESENCE4_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l751_date4(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L751_DATE4_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L751_DATE4_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14l751_seller2(elements.containsKey(ElementsNjr118.OFL_NJR118_P14L751_SELLER2_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14L751_SELLER2_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14_buyers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P14_BUYERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14_BUYERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DO.setP14_sellers_initials(elements.containsKey(ElementsNjr118.OFL_NJR118_P14_SELLERS_INITIALS_VALUE) ? elements.get(ElementsNjr118.OFL_NJR118_P14_SELLERS_INITIALS_VALUE) : ElementsCommon.EMPTY);
						njr118DOList.add(njr118DO);
					}
				}
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return njr118DOList;
	}
	
	public static HashMap<String,String> extractQuickEntryElements(QuickEntryDO quickEntryDO) {
		HashMap<String, String> elements =  null;
		try {
			Gson gson = new Gson();
			Type typeOfT = new TypeToken<HashMap<String, String>>() {}.getType();
			String json = WebServiceGzipUtil.decompress(quickEntryDO.getElements());
			elements = gson.fromJson(json, typeOfT);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return elements;
	}
}
