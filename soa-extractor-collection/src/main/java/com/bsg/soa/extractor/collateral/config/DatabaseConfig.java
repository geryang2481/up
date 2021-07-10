package com.bsg.soa.extractor.collateral.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;



@Configuration
public class DatabaseConfig {
	
	@Bean(name = "bsgDB")
	@ConfigurationProperties(prefix = "spring.datasource.bsg")
	public DataSource bsgDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "bsgJdbcTemplate")
	public JdbcTemplate bsgJdbcTemplate(@Qualifier("bsgDB") DataSource dataSource) {
		//(HikariDataSource)dataSource.getClass();
		HikariDataSource hk = (HikariDataSource)dataSource;
		hk.setMaximumPoolSize(115);
		hk.setMinimumIdle(15);
		return new JdbcTemplate(dataSource);
	}
	
	@Primary
	@Bean(name = "soaDB")
	@ConfigurationProperties(prefix = "spring.datasource.soa")
	public DataSource soaDataSource() {
		DataSource DataSource = DataSourceBuilder.create().build();
		return DataSource;
	}

	@Bean(name = "soaJdbcTemplate")
	public JdbcTemplate soaJdbcTemplate(@Qualifier("soaDB") DataSource dataSource) {
		JdbcTemplate JdbcTemplate = new JdbcTemplate(dataSource);
		return JdbcTemplate;
	}
}
