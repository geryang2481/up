package com.bluesprucegroup.njrealtors.csvtopdf;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println(getNjRealtorsCsvToPdfVersion());
		return application.sources(NjRealtorsCsvToPdfApplication.class);
	}
	private static String getNjRealtorsCsvToPdfVersion() {
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("\r\n");
		buffer.append("---------------------------------------------------------------------------------------------------\r\n");
		buffer.append("---------------------------------------------------------------------------------------------------\r\n");
		buffer.append("--------------------------------------nj-realtors-csv-to-pdf-version-1.0.0.0------------------------------------\r\n");
		buffer.append("---------------------------------------------------------------------------------------------------\r\n");
		buffer.append("---------------------------------------------------------------------------------------------------\r\n");
		return buffer.toString();
	}

}
