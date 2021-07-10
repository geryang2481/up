package com.bsg.data.extractor.dao;

import java.io.IOException;

public interface BsgDataExtractorDao {
	public boolean isValidDbConnection(String jdbcurl, String username, String password);
	
	public boolean findTcustInfo(String jdbcurl, String username, String password, String custId);
	
	public boolean dataExtractor(String jdbcurl, String username, String password, String output)  throws IOException;
}
