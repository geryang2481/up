package com.bluesprucegroup.njrealtors.csvtopdf.generate;

import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;

public interface HtmlToPdf {
	public HRefModel generateFile(String type, List<String> list);
}
