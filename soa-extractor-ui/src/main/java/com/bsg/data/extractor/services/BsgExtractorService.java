package com.bsg.data.extractor.services;

public interface BsgExtractorService {
	public boolean dataExtractor(String jdbcurl, String username, String password, String output);
}
