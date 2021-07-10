package com.bsg.data.extractor.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

	@Primary
	@Bean(name = "jasperDB")
	@ConfigurationProperties(prefix = "spring.datasource.jasper")
	public DataSource jasperDataSource() {
		DataSource DataSource = DataSourceBuilder.create().build();
		return DataSource;
	}

	@Bean(name = "jasperJdbcTemplate")
	public JdbcTemplate jasperJdbcTemplate(@Qualifier("jasperDB") DataSource dataSource) {
		JdbcTemplate JdbcTemplate = new JdbcTemplate(dataSource);
		return JdbcTemplate;
	}

}
