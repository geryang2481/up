package com.bluesprucegroup.njrealtors.csvtopdf.generate.impl;

import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.Constants;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.FileElementsDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.Njr118DO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.NjrlpdDO;
import com.bluesprucegroup.njrealtors.csvtopdf.elements.ElementsNjr118;
import com.bluesprucegroup.njrealtors.csvtopdf.elements.ElementsNjrlpd;
import com.bluesprucegroup.njrealtors.csvtopdf.generate.QuickEntryToPdf;
import com.bluesprucegroup.njrealtors.csvtopdf.util.PdfProcessorUtil;

@Component
public class QuickEntryToPdfImpl implements QuickEntryToPdf {
	private static final Logger log = LogManager.getLogger(QuickEntryToPdfImpl.class);
	
	private float getYFloat(float yFloat) {
		return 790-yFloat;
	}
	
	private boolean getIsSetting() {
		return false;
	}
	
	@Override
	public String generateNjr118DO(HashMap<String, String> elements) {
		String fileUUID = UUID.randomUUID().toString();
		//String pdfFile_Lead_Paint_Disclosure = "";//"C:\\java-exec\\repo\\output\\Lead_Paint_Disclosure\\Lead_Paint_DisclosureContract_816_ts52296+"+ leadPaintDisc_UUID +".pdf";
		String outputFile = "";
		String sourceFile = "C:\\java-exec\\repo\\source\\Contract_of_Sale_with_Opinion_26_NOTICE__1015_ts59787.pdf";
		PDDocument pdDocument = null;
		FileElementsDO[] fileElements = null;
		try {
			pdDocument = PdfProcessorUtil.bytesToPdfDocument(pdDocument, sourceFile);
			pdDocument.setAllSecurityToBeRemoved(true);
			fileElements = ElementsNjr118.getFileElements(fileElements, "2019");
			int currentPage=-1;
			PDRectangle pdRectangle = null;
			PDPage pdPage = null;
			PDPageContentStream stream = null;
			for(int i=0; i <fileElements.length; i++) {
				FileElementsDO feValue = fileElements[i];
				if(elements.containsKey(feValue.getOutputField())) {
					if(currentPage !=Integer.valueOf(feValue.getPageNo())-1) {
						if(stream != null) {
							stream.close();
						}
						currentPage = Integer.valueOf(feValue.getPageNo())-1;
						pdPage = pdDocument.getPage(Integer.valueOf(feValue.getPageNo())-1);
						pdRectangle = pdPage.getMediaBox();
						stream = new PDPageContentStream(pdDocument, pdPage,  PDPageContentStream.AppendMode.APPEND, true);
					} 
					stream = setStreamBackgroundYellow(stream); //Set background yellow
					PDFont font = PDType1Font.COURIER; //Set font
					//PDTrueTypeFont.loadTTF(pdDocument, "Arial.ttf");
					stream.setFont(font, 8); //Set font in stream
					String value = elements.get(feValue.getOutputField());
					feValue.setValue(value);
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				}
			}
			stream.close();
			outputFile = "Contract_of_Sale_with_Opinion_26_NOTICE__1015_ts59787+"+ fileUUID +".pdf";
			//Save pdDocument
			pdDocument.save(Constants.OUTPUT_CONTRACT_OF_SALE_LOCATION + outputFile);
			//Close pdDocument
			pdDocument.close();
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return outputFile;
	}
	
	@Override
	public String generate(Njr118DO njr118DO) {
		return "";
	}
	
	@SuppressWarnings({ "deprecation", "unused", "resource" })
	@Override
	public String generate(NjrlpdDO njrlpdDO) throws IOException {
		String leadPaintDisc_UUID = UUID.randomUUID().toString();
		String pdfFile_Lead_Paint_Disclosure = "";//"C:\\java-exec\\repo\\output\\Lead_Paint_Disclosure\\Lead_Paint_DisclosureContract_816_ts52296+"+ leadPaintDisc_UUID +".pdf";
		String pdfFileLead_Paint_Disclosure = "C:\\java-exec\\repo\\source\\Lead_Paint_DisclosureContract_816_ts52296.pdf";
		PDDocument pdDocument = null;
		
		FileElementsDO[] fileElements = null;
		try {
			pdDocument = PdfProcessorUtil.bytesToPdfDocument(pdDocument, pdfFileLead_Paint_Disclosure);
			pdDocument.setAllSecurityToBeRemoved(true);
			fileElements = ElementsNjrlpd.getFileElements(fileElements, "2019");
			int pageNo = 0;
			for(int i=0; i <fileElements.length; i++) {
				FileElementsDO feValue = fileElements[i];
				PDPage pdPage = pdDocument.getPage(Integer.valueOf(feValue.getPageNo())-1);
				PDRectangle pdRectangle = pdPage.getMediaBox();
				PDPageContentStream stream = new PDPageContentStream(pdDocument, pdPage,  PDPageContentStream.AppendMode.APPEND, true);
				stream = setStreamBackgroundYellow(stream); //Set background yellow
				PDFont font = PDType1Font.HELVETICA;
				stream.setFont(font, 8);
				if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L10_PROPERTYADDRESS1_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l10_propertyAddress1());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L11_PROPERTYADDRESS2_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l11_propertyAddress2());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L14_III_A_INITIALS_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l14_iii_a_initials());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				}else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L15_KNOWNLEADBASEDPAINT_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l15_knownLeadBasedPaint());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L16_KNOWNLEADBASEDPAINTEXP1_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l16_knownLeadBasedPaintExp1());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L17_KNOWNLEADBASEDPAINTEXP2_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l17_knownLeadBasedPaintExp2());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L19_SELLERNOKNOWLEDGE_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l19_sellerNoKnowledge());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L21_III_B_INITIALS_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l121_iii_b_initials());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L22_SELLERHASNOREPORTS_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l22_sellerHasNoReports());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L23_SELLERHASREPORTS_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l23_sellerHasReports());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} 
				else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L27_SELLERHASREPORTSDOC1_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l27_sellerHasReportsDoc1());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L28_SELLERHASREPORTSDOC2_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l28_sellerHasReportsDoc2());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L30_III_C_INITIALS_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l30_iii_c_initials());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME1_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l37_sellerName1());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE1_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l37_sellerDate1());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERNAME2_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l37_sellerName2());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L37_SELLERDATE2_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l37_sellerDate2());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME3_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l39_sellerName3());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE3_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l39_sellerDate3());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERNAME4_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l39_sellerName4());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L39_SELLERDATE4_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l39_sellerDate4());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAME_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l45_listingAgentName());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L45_LISTINGAGENTNAMEDATE_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l45_listingAgentNameDate());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L50_VI_A_INITIALS_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l50_vi_a_initials());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P1L52_VI_B_INITIALS_VALUE)) {
					feValue.setValue(njrlpdDO.getP1l52_vi_b_initials());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L57_VI_C_INITIALS_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l57_vi_c_initials());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L58_RECIEVED_10DAY_OPPURTUNITY_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l58_received10days());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L60_WAIVED_OPPURTUNITY_RISK_ASSESSMENT_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l60_waivedOppurtunity());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME1_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l67_purchaserName1());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE1_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l67_purchaserDate1());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERNAME2_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l67_purchaserName2());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L67_PURCHASERDATE2_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l67_purchaserDate2());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME3_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l69_purchaserName3());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE3_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l69_purchaserDate3());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERNAME4_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l69_purchaserName4());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L69_PURCHASERDATE4_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l69_purchaserDate4());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L74_SELLINGBYAGENTNAME_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l74_sellingByAgentName());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} else if(feValue.getOutputField().contains(ElementsNjrlpd.OFL_NJRLPD_P2L75_SELLINGBYAGENTNAMEDATE_VALUE)) {
					feValue.setValue(njrlpdDO.getP2l75_sellingByAgentNameDate());
					stream = setStreamFillRect(stream, pdRectangle, feValue); //Set rectangle
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()));
					stream = setStreamTextRed(stream); //Set text red
					stream.drawString(feValue.getValue());
					stream.endText();
				} 
				stream.close();
			}
			pdfFile_Lead_Paint_Disclosure = "Lead_Paint_DisclosureContract_816_ts52296+"+ leadPaintDisc_UUID +".pdf";
			//Save pdDocument
			pdDocument.save(Constants.OUTPUT_LEAD_PAINT_DISCLOSURE_LOCATION + pdfFile_Lead_Paint_Disclosure);
			//Close pdDocument
			pdDocument.close();
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if(pdDocument != null) {
				pdDocument.close();
			}
		}
		return pdfFile_Lead_Paint_Disclosure;
	}
	
	private PDPageContentStream setStreamBackgroundYellow(PDPageContentStream stream) throws IOException {
		if(getIsSetting()) {
			stream.setNonStrokingColor(Color.yellow); //Set background yellow
		}
		return stream;
	}
	
	@SuppressWarnings("deprecation")
	private PDPageContentStream setStreamFillRect(PDPageContentStream stream, PDRectangle pdRectangle, FileElementsDO feValue) throws IOException {
		if(getIsSetting()) {
			stream.fillRect(pdRectangle.getLowerLeftX() + feValue.getStartX(), pdRectangle.getLowerLeftY() + getYFloat(feValue.getStartY()), feValue.getStartW(), feValue.getStartH());
		}
		return stream;
	}
	
	private PDPageContentStream setStreamTextRed(PDPageContentStream stream) throws IOException {
		if(getIsSetting()) {
			stream.setNonStrokingColor(Color.red); //Set text red
		}
		return stream;
	}
	
}
