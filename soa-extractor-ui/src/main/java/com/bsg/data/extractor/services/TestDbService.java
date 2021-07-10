package com.bsg.data.extractor.services;

public interface TestDbService {

	public boolean isValidDbConnection(String jdbcurl, String username, String password);
}
