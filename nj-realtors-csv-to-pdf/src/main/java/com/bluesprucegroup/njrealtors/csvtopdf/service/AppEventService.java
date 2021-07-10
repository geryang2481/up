package com.bluesprucegroup.njrealtors.csvtopdf.service;

import java.util.List;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.RevisionDO;

public interface AppEventService {
	public void updateRevision(RevisionDO revisionDO);
	public RevisionDO findCurrentServiceAccountDatabaseVersion();
	public List<RevisionDO> findAllServiceAccountDatabaseVersion();
	public void checkRevisionTable(String uuid, String appName);
	public void checkTables(RevisionDO revisionDO);
	public void checkEntityColumns(RevisionDO revisionDO);
}
