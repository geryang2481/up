package com.bsg.data.extractor.commands;

import org.apache.commons.lang3.StringUtils;

public class DbCommand {
	
	private String jdbcurl;
	private String host;
	private String port;
	private String dbname;
	private String username;
	private String password;
	private String message;
	private String error;
	private String output;
	
	public String getJdbcurl() {
		this.jdbcurl = "jdbc:sqlserver://" + findHost() + ":" + findPort() + ";databaseName=" + findDbname();
		return jdbcurl;
	}
	public void setJdbcurl(String jdbcurl) {
		this.jdbcurl = jdbcurl;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String findHost() {
		return StringUtils.isEmpty(this.host) ? "local" : this.host;
	}
	
	private String findPort() {
		return StringUtils.isEmpty(this.port) ? "1433" : this.port;
	}
	
	private String findDbname() {
		return StringUtils.isEmpty(this.dbname) ? "Bsg" : this.dbname;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	
}
