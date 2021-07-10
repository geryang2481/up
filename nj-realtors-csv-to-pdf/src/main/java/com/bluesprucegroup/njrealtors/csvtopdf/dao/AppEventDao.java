package com.bluesprucegroup.njrealtors.csvtopdf.dao;

import java.util.List;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.RevisionDO;

public interface AppEventDao {
	public String[] checkColumnCharLength(String databaseName, String tableName, String columnName);
	public void addColumn(String databaseName, String tableName, String columnName, String length);
	public void copyColumn(String databaseName, String tableName, String sourceColumn, String destinationColumn);
	public void updateColumnToNull(String databaseName, String tableName, String columnName);
	public void dropColumn(String databaseName, String tableName, String columnName);
	public boolean isExistTable(String databaseName, String tableName);
	public void createTable(String databaseName, String tableName);
	public void updateRevision(RevisionDO revisionDO);
	public RevisionDO findCurrentServiceAccountDatabaseVersion();
	public List<RevisionDO> findAllServiceAccountDatabaseVersion();
}
