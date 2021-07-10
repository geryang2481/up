package com.bsg.data.extractor.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.bsg.data.extractor.dao.QueryReader;

@Component
public class QueryReaderImpl implements QueryReader {

	@Override
	public String readQuery(String fileName) {
		try {
			InputStream in = getClass().getResourceAsStream("/com/bsg/data/extractor/dao/sql/" + fileName);
			Reader reader = new InputStreamReader(in, "utf-8");
			return IOUtils.toString(reader);
		} catch(IOException e) {
			e.getMessage();
		}
		return null;
	}

}
