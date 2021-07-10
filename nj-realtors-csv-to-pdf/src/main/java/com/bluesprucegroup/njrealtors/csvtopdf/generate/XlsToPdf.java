package com.bluesprucegroup.njrealtors.csvtopdf.generate;

import java.nio.file.Path;
import java.util.TreeMap;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;

public interface XlsToPdf {
	public TreeMap<String, HRefModel> generateFile(Path filePath);
}
