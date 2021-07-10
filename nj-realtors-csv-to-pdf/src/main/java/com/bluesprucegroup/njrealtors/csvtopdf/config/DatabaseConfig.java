package com.bluesprucegroup.njrealtors.csvtopdf.config;

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
	@Primary
	@Bean(name = "solutionsourcedb")
	@ConfigurationProperties(prefix = "spring.datasource.solution")
	public DataSource solutionsourceDataSource() {
		DataSource DataSource = DataSourceBuilder.create().build();
		return DataSource;
	}

	@Bean(name = "solutionsourceJdbcTemplate")
	public JdbcTemplate solutionsourceJdbcTemplate(@Qualifier("solutionsourcedb") DataSource dataSource) {
		JdbcTemplate JdbcTemplate = new JdbcTemplate(dataSource);
		return JdbcTemplate;
	}
	
	
	
	@Bean(name = "devopsdb")
	@ConfigurationProperties(prefix = "spring.datasource.devops")
	public DataSource devopsDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "devopsJdbcTemplate")
	public JdbcTemplate devopsJdbcTemplate(@Qualifier("devopsdb") DataSource dataSource) {
		HikariDataSource hk = (HikariDataSource)dataSource;
		hk.setMaximumPoolSize(115);
		hk.setMinimumIdle(15);
		return new JdbcTemplate(dataSource);
	}
}
