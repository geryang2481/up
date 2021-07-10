package com.bluesprucegroup.njrealtors.csvtopdf.generate.impl;

import java.nio.file.Path;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;
import com.bluesprucegroup.njrealtors.csvtopdf.generate.TsvToPdf;

@Component
public class TsvToPdfImpl implements TsvToPdf {

	@Override
	public TreeMap<String, HRefModel> generateFile(Path filePath) {
		// TODO Auto-generated method stub
		return null;
	}

}
