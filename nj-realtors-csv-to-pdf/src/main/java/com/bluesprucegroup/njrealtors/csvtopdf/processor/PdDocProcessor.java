package com.bluesprucegroup.njrealtors.csvtopdf.processor;

import org.apache.pdfbox.pdmodel.PDDocument;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;

public interface PdDocProcessor {

	public ServiceAccountDataDO indexPages(ServiceAccountDataDO serviceAccountDataDO, PDDocument pdDocument);
		
	public ServiceAccountDataDO identifyPdf(ServiceAccountDataDO serviceAccountDataDO, PDDocument document);
	 
	public ServiceAccountDataDO findAppFileFeatures(ServiceAccountDataDO serviceAccountDataDO);
	
	public ServiceAccountDataDO findForm8825(ServiceAccountDataDO serviceAccountDataDO, PDDocument pdDocument, String fileType, String year);
	
	public ServiceAccountDataDO findFormSchC(ServiceAccountDataDO serviceAccountDataDO, PDDocument pdDocument, String fileType, String year);
	
	public ServiceAccountDataDO findFormSchE(ServiceAccountDataDO serviceAccountDataDO, PDDocument pdDocument, String fileType, String year);
	
	public ServiceAccountDataDO findFormSchF(ServiceAccountDataDO serviceAccountDataDO, PDDocument pdDocument, String fileType, String year);
	
	//public serviceAccountDataDO strip1040(serviceAccountDataDO serviceAccountDataDO, PDDocument document, Map<String, Map<String, FileCoordinatesDO>> fileLabelLocationServiceMap) ;
	
	public ServiceAccountDataDO saveAppFileFeatures(ServiceAccountDataDO serviceAccountDataDO);
}
