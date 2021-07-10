package com.bluesprucegroup.njrealtors.csvtopdf.generate;

import java.io.IOException;
import java.util.HashMap;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.Njr118DO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.NjrlpdDO;

public interface QuickEntryToPdf {
	public String generateNjr118DO(HashMap<String, String> elements);
	public String generate(Njr118DO njr118DO) throws IOException;
	public String generate(NjrlpdDO njrlpdDO) throws IOException;
}
