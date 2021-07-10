package com.bluesprucegroup.njrealtors.csvtopdf.processor;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO.ServiceAccountFileItem;

public interface PdfProcessor {
	
	public ServiceAccountFileItem parsePdfData(ServiceAccountFileItem serviceAccountFileItem, PDDocument pdDocument);
	
	public ServiceAccountFileItem formatResults(ServiceAccountFileItem serviceAccountFileItem);
	
	public ServiceAccountFileItem extractPdfDataByRegion(ServiceAccountDataDO serviceAccountDataDO, ServiceAccountFileItem serviceAccountFileItem, PDDocument pdDocument);
	
	public ServiceAccountFileItem savePDPages(ServiceAccountDataDO serviceAccountDataDO, ServiceAccountFileItem serviceAccountFileItem, PDDocument pdDocument)  throws IOException;
}
