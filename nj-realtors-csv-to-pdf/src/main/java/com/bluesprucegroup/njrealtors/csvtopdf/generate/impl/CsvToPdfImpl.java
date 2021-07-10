package com.bluesprucegroup.njrealtors.csvtopdf.generate.impl;


import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;
import com.bluesprucegroup.njrealtors.csvtopdf.controller.FileController;
import com.bluesprucegroup.njrealtors.csvtopdf.generate.CsvToPdf;
import com.bluesprucegroup.njrealtors.csvtopdf.util.PdfProcessorUtil;

@Component
public class CsvToPdfImpl implements CsvToPdf {
	
	private static final Logger log = LogManager.getLogger(CsvToPdfImpl.class);
	
	@Override
	public TreeMap<String, HRefModel> generateFile(Path filePath) { 
		String[] recordHeaderLabel = new String[] {
				"MLS"
				,"Street Number"
				,"Street Dir"
				,"Street Name"
				,"Street Mode"
				,"Unit Num"
				,"County"
				,"Area"
				,"Current Price"
				,"List Off"
				,"BR"
				,"Status"
				,"Category"
				,"baths_full"
				,"baths_part"
				,"date_list"
				,"date_uc"
				,"date_sold"
				,"price_org"
				,"dom"
				,"tax"
				,"style"
				,"list off name"
				,"sold off name"
				,"List Agent"
				,"Sold Office"
				,"Sold Agent"
				,"Approx lot dim"
				,"Garage"
				,"Fireplace"
				,"Area Name"
				,"Final List Price"
				,"Ext Finish"
				,"Misc"
				,"Lot Description"
		};
		try {
			File file = filePath.toFile();
			Reader in = new FileReader(file.getPath());
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
			
			TreeMap<String, Map<String, String[]>> csvRecords = new TreeMap<String, Map<String, String[]>>();
			for (CSVRecord record : records) {
				Map<String, String[]> csvRowMap = new HashMap<String, String[]>();
				csvRowMap.put("mls", new String[] { "mls", record.get(recordHeaderLabel[0])});
				csvRowMap.put("REALTORSFORM118_P1_BUYER_ADDRESS1_VALUE", new String[] { "streetNumber", record.get(recordHeaderLabel[1])});
				csvRowMap.put("REALTORSFORM118_P1_BUYER_ADDRESS2_VALUE", new String[] { "streetDir", record.get(recordHeaderLabel[2])});
				csvRowMap.put("REALTORSFORM118_P1_BUYER_ADDRESS3_VALUE", new String[] { "streetName", record.get(recordHeaderLabel[3])});
				csvRowMap.put("REALTORSFORM118_P1_BUYER_ADDRESS4_VALUE", new String[] { "streetMode", record.get(recordHeaderLabel[4])});
				csvRowMap.put("REALTORSFORM118_P1_BUYER_ADDRESS5_VALUE", new String[] { "unitNum", record.get(recordHeaderLabel[5])});
				csvRowMap.put("REALTORSFORM118_P1_COUNTY_VALUE", new String[] { "county", record.get(recordHeaderLabel[6])});
				csvRowMap.put("REALTORSFORM118_P1_MUNICIPAL_TAX_MAP_VALUE", new String[] { "area", record.get(recordHeaderLabel[7])});
				csvRowMap.put("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS1_VALUE", new String[] { "streetNumber", record.get(recordHeaderLabel[1])});
				csvRowMap.put("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS2_VALUE", new String[] { "streetDir", record.get(recordHeaderLabel[2])});
				csvRowMap.put("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS3_VALUE", new String[] { "streetName", record.get(recordHeaderLabel[3])});
				csvRowMap.put("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS4_VALUE", new String[] { "streetMode", record.get(recordHeaderLabel[4])});
				csvRowMap.put("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS5_VALUE", new String[] { "unitNum", record.get(recordHeaderLabel[5])});
				csvRowMap.put("REALTORSFORMLEADPAINTDISCLOSURE_P1_COUNTY_VALUE", new String[] { "county", record.get(recordHeaderLabel[6])});
				csvRowMap.put("REALTORSFORMLEADPAINTDISCLOSURE_P1_MUNICIPAL_TAX_MAP_VALUE", new String[] { "area", record.get(recordHeaderLabel[7])});
				csvRowMap.put("1000", new String[] { "currentPrice", record.get(recordHeaderLabel[8])});
				csvRowMap.put("1001", new String[] { "listOff", record.get(recordHeaderLabel[9])});
				csvRowMap.put("1002", new String[] { "br", record.get(recordHeaderLabel[10])});
				csvRowMap.put("1002", new String[] { "status", record.get(recordHeaderLabel[11])});
				csvRowMap.put("1002", new String[] { "category", record.get(recordHeaderLabel[12])});
				csvRowMap.put("1002", new String[] { "baths_full", record.get(recordHeaderLabel[13])});
				csvRowMap.put("1002", new String[] { "baths_part", record.get(recordHeaderLabel[14])});
				csvRowMap.put("1002", new String[] { "date_list", record.get(recordHeaderLabel[15])});
				csvRowMap.put("1002", new String[] { "date_uc", record.get(recordHeaderLabel[16])});
				csvRowMap.put("1002", new String[] { "date_sold", record.get(recordHeaderLabel[17])});
				csvRowMap.put("1002", new String[] { "price_org", record.get(recordHeaderLabel[18])});
				csvRowMap.put("1002", new String[] { "dom", record.get(recordHeaderLabel[19])});
				csvRowMap.put("1002", new String[] { "tax", record.get(recordHeaderLabel[20])});
				csvRowMap.put("1002", new String[] { "style", record.get(recordHeaderLabel[21])});
				csvRowMap.put("REALTORSFORM118_P12_LISTING_FIRM_NAME", new String[] { "listOffName", record.get(recordHeaderLabel[22])});
				csvRowMap.put("1002", new String[] { "soldOffName", record.get(recordHeaderLabel[23])});
				csvRowMap.put("REALTORSFORM118_P12_LISTING_AGENT_REC_LICENSE_ID_VALUE", new String[] { "listAgent", record.get(recordHeaderLabel[24])});
				csvRowMap.put("REALTORSFORMLEADPAINTDISCLOSURE_P1_LIST_AGENT_VALUE", new String[] { "listAgent", record.get(recordHeaderLabel[24])});
				csvRowMap.put("1002", new String[] { "soldOffice", record.get(recordHeaderLabel[25])});
				csvRowMap.put("1002", new String[] { "soldAgent", record.get(recordHeaderLabel[26])});
				csvRowMap.put("1002", new String[] { "approxLotDim", record.get(recordHeaderLabel[27])});
				csvRowMap.put("1002", new String[] { "garage", record.get(recordHeaderLabel[28])});
				csvRowMap.put("1002", new String[] { "fireplace", record.get(recordHeaderLabel[29])});
				csvRowMap.put("1002", new String[] { "areaName", record.get(recordHeaderLabel[30])});
				csvRowMap.put("1002", new String[] { "finalListPrice", record.get(recordHeaderLabel[31])});
				csvRowMap.put("1002", new String[] { "extFinish", record.get(recordHeaderLabel[32])});
				csvRowMap.put("1002", new String[] { "misc", record.get(recordHeaderLabel[33])});
				csvRowMap.put("1002", new String[] { "lotDescription", record.get(recordHeaderLabel[34])});
				csvRecords.put(record.get(recordHeaderLabel[0]), csvRowMap);
			}
			in.close();
			return processPdf(csvRecords);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
    private TreeMap<String, HRefModel> processPdf(TreeMap<String, Map<String, String[]>> csvRecords) throws IOException {
    	
		String pdfFileContract_of_Sale = "C:\\java-exec\\repo\\source\\Contract_of_Sale_with_Opinion_26_NOTICE__1015_ts59787.pdf";
		String pdfFileLead_Paint_Disclosure = "C:\\java-exec\\repo\\source\\Lead_Paint_DisclosureContract_816_ts52296.pdf";
		PDDocument pdDocumentContract_of_Sale = null;
		PDDocument pdDocumentLead_Paint_Disclosure = null;
		TreeMap<String, HRefModel> hrefModelTreeMap = new TreeMap<String, HRefModel>();
		try {
			for(String key : csvRecords.keySet()) {
				Map<String, String[]> csvRowMap = csvRecords.get(key);
				//String fileTextDesc = revisionDO.getComments();
				String contractOfSale_UUID = UUID.randomUUID().toString();
				String njr118PdfFile = "C:\\java-exec\\repo\\output\\Contract_of_Sale\\Contract_of_Sale_with_Opinion_26_NOTICE__1015_ts59787+"+ contractOfSale_UUID +".pdf";
				pdDocumentContract_of_Sale = PdfProcessorUtil.bytesToPdfDocument(pdDocumentContract_of_Sale, pdfFileContract_of_Sale);
				pdDocumentContract_of_Sale.setAllSecurityToBeRemoved(true);
				PDPage pdPage2Contract_of_Sale = pdDocumentContract_of_Sale.getPage(1);
				PDRectangle pageSizeContract_of_Sale = pdPage2Contract_of_Sale.getMediaBox();
				PDPageContentStream contentStreamContract_of_Sale = new PDPageContentStream(pdDocumentContract_of_Sale, pdPage2Contract_of_Sale,  PDPageContentStream.AppendMode.APPEND, true);
				//Contract_of_Sale-Address
				contentStreamContract_of_Sale.setNonStrokingColor(Color.yellow);
				PDFont font = PDType1Font.HELVETICA;
				contentStreamContract_of_Sale.setFont(font, 8);
				Float[] addressFloat = new Float[] { 125f, 212f, 275f, 12f };
				String[] address1 = csvRowMap.get("REALTORSFORM118_P1_BUYER_ADDRESS1_VALUE");
				String[] address2 = csvRowMap.get("REALTORSFORM118_P1_BUYER_ADDRESS2_VALUE");
				String[] address3 = csvRowMap.get("REALTORSFORM118_P1_BUYER_ADDRESS3_VALUE");
				String[] address4 = csvRowMap.get("REALTORSFORM118_P1_BUYER_ADDRESS4_VALUE");
				String[] address5 = csvRowMap.get("REALTORSFORM118_P1_BUYER_ADDRESS5_VALUE");
				String address = address1[1] + " " + address2[1] + " " + address3[1] + " " + address4[1] + " " + address5[1] + " ";
				contentStreamContract_of_Sale.fillRect(pageSizeContract_of_Sale.getLowerLeftX() + addressFloat[0], pageSizeContract_of_Sale.getLowerLeftY() + addressFloat[1], addressFloat[2], addressFloat[3]);
				contentStreamContract_of_Sale.beginText();
				contentStreamContract_of_Sale.moveTextPositionByAmount(pageSizeContract_of_Sale.getLowerLeftX() + addressFloat[0], pageSizeContract_of_Sale.getLowerLeftY() + addressFloat[1]);
				contentStreamContract_of_Sale.setNonStrokingColor(Color.red);
				contentStreamContract_of_Sale.drawString(address);
				contentStreamContract_of_Sale.endText();
				//Contract_of_Sale-TaxMap
				contentStreamContract_of_Sale.setNonStrokingColor(Color.yellow);
				contentStreamContract_of_Sale.setFont(font, 8);
				Float[] taxMapFloat = new Float[] { 180f, 193f, 190f, 12f };
				String area = "Area " + csvRowMap.get("REALTORSFORM118_P1_MUNICIPAL_TAX_MAP_VALUE")[1];
				contentStreamContract_of_Sale.fillRect(pageSizeContract_of_Sale.getLowerLeftX() + taxMapFloat[0], pageSizeContract_of_Sale.getLowerLeftY() + taxMapFloat[1], taxMapFloat[2], taxMapFloat[3]);
				contentStreamContract_of_Sale.beginText();
				contentStreamContract_of_Sale.moveTextPositionByAmount(pageSizeContract_of_Sale.getLowerLeftX() + taxMapFloat[0], pageSizeContract_of_Sale.getLowerLeftY() + taxMapFloat[1]);
				contentStreamContract_of_Sale.setNonStrokingColor(Color.red);
				contentStreamContract_of_Sale.drawString(area);
				contentStreamContract_of_Sale.endText();
				//Contract_of_Sale-County
				contentStreamContract_of_Sale.setNonStrokingColor(Color.yellow);
				contentStreamContract_of_Sale.setFont(font, 8);
				Float[] countyFloat = new Float[] { 440f, 193f, 30f, 12f };
				String county = "County " + csvRowMap.get("REALTORSFORM118_P1_COUNTY_VALUE")[1];
				contentStreamContract_of_Sale.fillRect(pageSizeContract_of_Sale.getLowerLeftX() + countyFloat[0], pageSizeContract_of_Sale.getLowerLeftY() + countyFloat[1], countyFloat[2], countyFloat[3]);
				contentStreamContract_of_Sale.beginText();
				contentStreamContract_of_Sale.moveTextPositionByAmount(pageSizeContract_of_Sale.getLowerLeftX() + countyFloat[0], pageSizeContract_of_Sale.getLowerLeftY() + countyFloat[1]);
				contentStreamContract_of_Sale.setNonStrokingColor(Color.red);
				contentStreamContract_of_Sale.drawString(county);
				contentStreamContract_of_Sale.endText();
				//fileTextDesc = fileTextDesc + contractOfSale_UUID + "+" + "COS" + "+" + csvRowMap.get("mls")[1] + "+" +address + "+" + county + ", " + area + "|";
				HRefModel hrefModelNjr118 = new HRefModel();
				hrefModelNjr118.setHrefText("PDF_TYPE=Contract of Sale , MLS=" + key + ", Address=" + address + " " + county + ", Timestamp=" + getCurrentTimestamp());
				hrefModelNjr118.setFileTextDesc(contractOfSale_UUID + "+" + "COS" + "+" + csvRowMap.get("mls")[1] + "+" +address + "+" + county + ", " + area);
				hrefModelNjr118.setFileTypeID("NJR118");
				hrefModelNjr118.setColor(HRefModel.COLOR_PINK);
				hrefModelNjr118.setPath(njr118PdfFile);
				hrefModelNjr118.setHref(MvcUriComponentsBuilder
						.fromMethodName(FileController.class, "serveFile", njr118PdfFile)
						.build()
						.toString());
				hrefModelTreeMap.put("NJR118_" + key, hrefModelNjr118);
				//Close Stream
				contentStreamContract_of_Sale.close();
				//Save pdDocument
				pdDocumentContract_of_Sale.save(njr118PdfFile);
				//Close pdDocument
				pdDocumentContract_of_Sale.close();
				//
				String leadPaintDisc_UUID = UUID.randomUUID().toString();
				String njrlpdPdfFile = "C:\\java-exec\\repo\\output\\Lead_Paint_Disclosure\\Lead_Paint_DisclosureContract_816_ts52296+"+ leadPaintDisc_UUID +".pdf";
				pdDocumentLead_Paint_Disclosure = PdfProcessorUtil.bytesToPdfDocument(pdDocumentLead_Paint_Disclosure, pdfFileLead_Paint_Disclosure);
				pdDocumentLead_Paint_Disclosure.setAllSecurityToBeRemoved(true);
				PDPage pdPage2Lead_Paint_Disclosure = pdDocumentLead_Paint_Disclosure.getPage(0);
				PDRectangle pageSizeLead_Paint_Disclosure = pdPage2Lead_Paint_Disclosure.getMediaBox();
				PDPageContentStream contentStreamLead_Paint_Disclosure = new PDPageContentStream(pdDocumentLead_Paint_Disclosure, pdPage2Lead_Paint_Disclosure,  PDPageContentStream.AppendMode.APPEND, true);
				//Lead_Paint_Disclosure-Address1
				contentStreamLead_Paint_Disclosure.setNonStrokingColor(Color.yellow);
				contentStreamLead_Paint_Disclosure.setFont(font, 8);
				Float[] addressFloat2 = new Float[] { 175f, 595f, 275f, 9f };
				String[] address1b = csvRowMap.get("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS1_VALUE");
				String[] address2b = csvRowMap.get("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS2_VALUE");
				String[] address3b = csvRowMap.get("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS3_VALUE");
				String[] address4b = csvRowMap.get("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS4_VALUE");
				String[] address5b = csvRowMap.get("REALTORSFORMLEADPAINTDISCLOSURE_P1_PROPERTY_ADDRESS5_VALUE");
				String address_b = address1b[1] + " " + address2b[1] + " " + address3b[1] + " " + address4b[1] + " " + address5b[1] + " ";
				contentStreamLead_Paint_Disclosure.fillRect(pageSizeLead_Paint_Disclosure.getLowerLeftX() + addressFloat2[0], pageSizeLead_Paint_Disclosure.getLowerLeftY() + addressFloat2[1], addressFloat2[2], addressFloat2[3]);
				contentStreamLead_Paint_Disclosure.beginText();
				contentStreamLead_Paint_Disclosure.moveTextPositionByAmount(pageSizeLead_Paint_Disclosure.getLowerLeftX() + addressFloat2[0], pageSizeLead_Paint_Disclosure.getLowerLeftY() + addressFloat2[1]);
				contentStreamLead_Paint_Disclosure.setNonStrokingColor(Color.red);
				contentStreamLead_Paint_Disclosure.drawString(address_b);
				contentStreamLead_Paint_Disclosure.endText();
				//Lead_Paint_Disclosur-MapArea+County
				contentStreamLead_Paint_Disclosure.setNonStrokingColor(Color.yellow);
				contentStreamLead_Paint_Disclosure.setFont(font, 8);
				Float[] addressFloat2b = new Float[] { 175f, 581f, 275f, 9f };
				String[] county2 = csvRowMap.get("REALTORSFORMLEADPAINTDISCLOSURE_P1_COUNTY_VALUE");
				String[] taxMap2 = csvRowMap.get("REALTORSFORMLEADPAINTDISCLOSURE_P1_MUNICIPAL_TAX_MAP_VALUE");
				String address_b2 = "County " + county2[1] + ", Area " + taxMap2[1];
				contentStreamLead_Paint_Disclosure.fillRect(pageSizeLead_Paint_Disclosure.getLowerLeftX() + addressFloat2b[0], pageSizeLead_Paint_Disclosure.getLowerLeftY() + addressFloat2b[1], addressFloat2b[2], addressFloat2b[3]);
				contentStreamLead_Paint_Disclosure.beginText();
				contentStreamLead_Paint_Disclosure.moveTextPositionByAmount(pageSizeLead_Paint_Disclosure.getLowerLeftX() + addressFloat2b[0], pageSizeLead_Paint_Disclosure.getLowerLeftY() + addressFloat2b[1]);
				contentStreamLead_Paint_Disclosure.setNonStrokingColor(Color.red);
				contentStreamLead_Paint_Disclosure.drawString(address_b2);
				contentStreamLead_Paint_Disclosure.endText();
				HRefModel hrefModelNjrlpd = new HRefModel();
				hrefModelNjrlpd.setFileTextDesc(leadPaintDisc_UUID + "+" + "LPD" + "+" + csvRowMap.get("mls")[1] + "+" +  address_b + "+" +  address_b2);
				hrefModelNjrlpd.setHrefText("PDF_TYPE=Lead Paint Disclosure , MLS=" + key + ", Address=" + address_b + " " + county + ", Timestamp=" + getCurrentTimestamp());
				hrefModelNjrlpd.setFileTextDesc(leadPaintDisc_UUID + "+" + "LPD" + "+" + csvRowMap.get("mls")[1] + "+" +  address_b + "+" +  address_b2);
				hrefModelNjrlpd.setFileTypeID("NJRLPD");
				hrefModelNjrlpd.setColor(HRefModel.COLOR_BROWN);
				hrefModelNjrlpd.setPath(njrlpdPdfFile);
				hrefModelNjrlpd.setHref(MvcUriComponentsBuilder
						.fromMethodName(FileController.class, "serveFile", njrlpdPdfFile)
						.build()
						.toString());
				hrefModelTreeMap.put("NJRLPD_" + key, hrefModelNjrlpd);
				//Close Stream
				contentStreamLead_Paint_Disclosure.close();
				//Save pdDocument
				pdDocumentLead_Paint_Disclosure.save(njrlpdPdfFile);
				//Close pdDocument
				pdDocumentLead_Paint_Disclosure.close();
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if(pdDocumentContract_of_Sale != null) {
				pdDocumentContract_of_Sale.close();
			}
			if(pdDocumentLead_Paint_Disclosure != null) {
				pdDocumentLead_Paint_Disclosure.close();
			}
		}
		return hrefModelTreeMap;
    }
    
	private static String getCurrentTimestamp() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}

}
