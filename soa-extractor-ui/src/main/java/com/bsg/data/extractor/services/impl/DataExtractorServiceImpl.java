package com.bsg.data.extractor.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bsg.data.extractor.dao.BsgDataExtractorDao;
import com.bsg.data.extractor.services.BsgExtractorService;

@Component
public class DataExtractorServiceImpl implements BsgExtractorService {

	@Autowired
	BsgDataExtractorDao dataExtractorDao;
	
	@Override
	public boolean dataExtractor(String jdbcurl, String username, String password, String output) {
		boolean isExtracted = false;
		try {
			isExtracted = dataExtractorDao.dataExtractor(jdbcurl, username, password, output);
		} catch(Exception e) {
			e.getStackTrace();
		}
		return isExtracted;
	}

}
