package com.bluesprucegroup.njrealtors.csvtopdf.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.Njr118DO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.NjrlpdDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.QuickEntryDO;

public interface FileService {
	//Upload Files - HTML
	public List<String> parseHtml_gsmls(Path path) throws IOException;
	public List<String> parseHtml_njtax(Path path) throws IOException;
	//Upload Files - CSV
	public void saveFileUpload(TreeMap<String, HRefModel> hrefModelMap, String uuid);
	public List<HRefModel> findFileUpload(String uuid);
	//Contract of Sale
	public void createQuickEntry(Njr118DO njr118DO);
	public List<QuickEntryDO> findQuickEntryList_Njr118DO(List<Njr118DO> Njr118DO);
	public List<Njr118DO> findList_Njr118DO();
	public void saveQuickEntryByQuickEntryID(Njr118DO njr118DO, String quickEntryID);
	//Lead Paint Disclosure
	public void createQuickEntry(NjrlpdDO njrlpdDO);
	public List<QuickEntryDO> findQuickEntryList_NjrlpdDO(List<NjrlpdDO> njrlpdDO);
	public List<NjrlpdDO> findList_NjrlpdDO();
	public void saveQuickEntryByQuickEntryID(NjrlpdDO njrlpdDO, String quickEntryID);
	//Both
	public String createPdfByQuickEntryID(String quickEntryID);
	public void deleteQuickEntryByQuickEntryID(String quickEntryID);
}
