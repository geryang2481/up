package com.bluesprucegroup.njrealtors.csvtopdf.dao;

import java.util.List;
import java.util.TreeMap;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.QuickEntryDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO.ServiceAccountFileItem;

public interface QuickEntryDao {
	public void findNewOrExisitng(ServiceAccountDataDO serviceAccountDataDO, ServiceAccountFileItem serviceAccountFileItem, List<QuickEntryDO> quickEntryDOList);
	public	List<QuickEntryDO> findQuickEntryByFileTypeID(String fileTypeID);
	public	QuickEntryDO findQuickEntryByQuickEntryID(String quickEntryID);
	public	void createQuickEntry(QuickEntryDO quickEntryDO);
	public	void saveQuickEntryByFileTypeID(QuickEntryDO quickEntryDO, String quickEntryID);
	public void deleteQuickEntryByQuickEntryID(String quickEntryID);
	public void saveFileUpload(TreeMap<String, HRefModel> hrefModelMap, String uuid);
	public List<HRefModel>  findFileUpload(String uuid);
}
