package com.bsg.data.extractor.dao.util;

import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DaoUtil {
	
	public static JdbcTemplate createJdbc(String jdbcurl, String username, String password, JdbcTemplate jdbcTemplate) {
		HikariDataSource hikariDataSource = (HikariDataSource) jdbcTemplate.getDataSource();
		if(!hikariDataSource.getJdbcUrl().equals(jdbcurl)) {
			hikariDataSource.setJdbcUrl(jdbcurl);
			hikariDataSource.setUsername(username);
			hikariDataSource.setPassword(password);
		}
		return jdbcTemplate;
	}
	
	public static String StringFix(String input) {
		
		if(input.equals("null")) {
			input = "";
		}
		input = input.replace("\r", " ");
		input = input.replace("\n", " ");
		input = input.replace("\t", " ");
		return input;
	}

	private static HikariDataSource createHikariDataSource(String jdbcurl, String username, String password) {
	    Properties props = new Properties();
	    //props.setProperty("poolName", "cookpool");
	    props.setProperty("driverClassName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    props.setProperty("jdbcUrl", jdbcurl);
	    props.setProperty("username", username);
	    props.setProperty("password", password);
	   // props.setProperty("maximumPoolSize", "10");
	   // props.setProperty("minimumIdle", "2");
	   // props.setProperty("dataSource.cachePrepStmts","true");
	   // props.setProperty("dataSource.prepStmtCacheSize", "256");
	   // props.setProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	   // props.setProperty("dataSource.useServerPrepStmts","true");

	    HikariConfig config = new HikariConfig(props);
	    HikariDataSource hikariDataSource = new HikariDataSource(config);
	    return hikariDataSource;
	}
	
	
}
