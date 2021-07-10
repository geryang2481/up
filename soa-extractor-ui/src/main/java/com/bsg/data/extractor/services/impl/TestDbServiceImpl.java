package com.bsg.data.extractor.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bsg.data.extractor.dao.BsgDataExtractorDao;
import com.bsg.data.extractor.services.TestDbService;

@Component
public class TestDbServiceImpl implements TestDbService {

	@Autowired
	private BsgDataExtractorDao dataExtractorDao;
	
	@Override
	public boolean isValidDbConnection(String jdbcurl, String username, String password) {
		return dataExtractorDao.isValidDbConnection(jdbcurl, username, password);
		//return dataExtractorDao.findTcustInfo(jdbcurl, username, password, '0');
	}

}
