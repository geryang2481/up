package com.bluesprucegroup.njrealtors.csvtopdf.generate.impl;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

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
import com.bluesprucegroup.njrealtors.csvtopdf.generate.HtmlToPdf;
import com.bluesprucegroup.njrealtors.csvtopdf.util.PdfProcessorUtil;

@Component
public class HtmlToPdfImpl implements HtmlToPdf{
	private static final Logger log = LogManager.getLogger(HtmlToPdfImpl.class);

	@Override
	public HRefModel generateFile(String type, List<String> list) {
		String pdfFile = type.equals("gsmls") ? "C:\\java-exec\\repo\\source\\NJ_GSMLS_Records.pdf" : "C:\\java-exec\\repo\\source\\NJTax_Records.pdf";
		PDDocument pdDocument = null;
		TreeMap<String, HRefModel> hrefModelTreeMap = new TreeMap<String, HRefModel>();
		HRefModel hrefModel = new HRefModel();
		try {
			String myUUID = UUID.randomUUID().toString();
			String fileName =  type.equals("gsmls") ? "NJ_GSMLS_Records" : "NJTax_Records";
			String outputPdfFile = "C:\\java-exec\\repo\\output\\Contract_of_Sale\\" + fileName + "+" + myUUID +".pdf";
			pdDocument = PdfProcessorUtil.bytesToPdfDocument(pdDocument, pdfFile);
			pdDocument.setAllSecurityToBeRemoved(true);
			
			PDPage pdPage = pdDocument.getPage(0);
			PDRectangle pdRectangle = pdPage.getMediaBox();
			float yFloat = 750;
			for(String s : list) {
				try {
					PDPageContentStream stream = new PDPageContentStream(pdDocument, pdPage,  PDPageContentStream.AppendMode.APPEND, true);
					//Contract_of_Sale-Address
					stream.setNonStrokingColor(Color.white);
					PDFont font = PDType1Font.HELVETICA;
					stream.setFont(font, 8);
					Float[] addressFloat = new Float[] { 25f, yFloat, 565f, 10f };
					
					String address = s;
					stream.fillRect(pdRectangle.getLowerLeftX() + addressFloat[0], pdRectangle.getLowerLeftY() + addressFloat[1], addressFloat[2], addressFloat[3]);
					stream.beginText();
					stream.moveTextPositionByAmount(pdRectangle.getLowerLeftX() + addressFloat[0], pdRectangle.getLowerLeftY() + addressFloat[1]);
					stream.setNonStrokingColor(Color.black);
					stream.drawString(address);
					stream.endText();
					//Close Stream
					stream.close();
					yFloat = yFloat-10f;
				} catch(Exception e) {
					
				}
				
			}
			//
			//HRefModel hrefModelNjrlpd = new HRefModel();
			hrefModel.setFileTextDesc(myUUID + "+" + "" + "+" + "" + "+" +  list.get(0) + "+" +  "");
			hrefModel.setHrefText("Type=" + fileName + ", Address=" + list.get(1) + " " + "" + ", Timestamp=" + getCurrentTimestamp());
			hrefModel.setFileTextDesc("Type=" + fileName + ", Address=" + list.get(1) + " " + "" + ", Timestamp=" + getCurrentTimestamp());
			hrefModel.setFileTypeID(fileName);
			hrefModel.setColor(HRefModel.COLOR_BROWN);
			hrefModel.setPath(outputPdfFile);
			hrefModel.setHref(MvcUriComponentsBuilder
					.fromMethodName(FileController.class, "serveFile", outputPdfFile)
					.build()
					.toString());
			//hrefModelTreeMap.put(fileName + "_" +id, hrefModelNjrlpd);
			
			//Save pdDocument
			pdDocument.save(outputPdfFile);
			//Close pdDocument
			pdDocument.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return hrefModel;
	}

	private static String getCurrentTimestamp() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}
}
