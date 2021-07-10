package com.bluesprucegroup.njrealtors.csvtopdf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.bluesprucegroup.njrealtors.csvtopdf.dao.AppEventDao;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.RevisionDO;
import com.bluesprucegroup.njrealtors.csvtopdf.event.ServiceAccountDataEvent;
import com.bluesprucegroup.njrealtors.csvtopdf.service.AppEventService;

@Component
public class AppEventServiceImpl implements AppEventService {
	private static final Logger log = LogManager.getLogger(AppEventServiceImpl.class);
	
	@Autowired
	private AppEventDao appEventDao;

	@Override
	public List<RevisionDO> findAllServiceAccountDatabaseVersion() {
		return appEventDao.findAllServiceAccountDatabaseVersion();
	}

	@Override
	public RevisionDO findCurrentServiceAccountDatabaseVersion() {
		return appEventDao.findCurrentServiceAccountDatabaseVersion();
	}
	
	@Override
	public void updateRevision(RevisionDO revisionDO) {
		try {
			appEventDao.updateRevision(revisionDO);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void checkRevisionTable(String uuid, String appName) {
		try {
			boolean isExistTable = appEventDao.isExistTable(ServiceAccountDataEvent.SET_DB, ServiceAccountDataEvent.SET_DB_REVISION_TABLE);
			if(isExistTable) {
				RevisionDO revisionDO = new RevisionDO();
				revisionDO.setVersion(ServiceAccountDataEvent.SERVICE_ACCOUNT_REVISION_VERSION_1_0_0_0);
				revisionDO.setInfo("Initial Revision " + ServiceAccountDataEvent.SERVICE_ACCOUNT_REVISION_VERSION_1_0_0_0);
				revisionDO.setComments("Initial Revision " + ServiceAccountDataEvent.SERVICE_ACCOUNT_REVISION_VERSION_1_0_0_0);
				revisionDO.setUuid(uuid);
				revisionDO.setCreatedBy(appName);
				revisionDO.setUpdatedBy(appName);
				appEventDao.createTable(ServiceAccountDataEvent.SET_DB, ServiceAccountDataEvent.SET_DB_REVISION_TABLE);
				appEventDao.updateRevision(revisionDO);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void checkTables(RevisionDO revisionDO) {
		HashMap<String, String> setDbTablesMaps = ServiceAccountDataEvent.getSetDbTablesMap();
		for(String tableName : setDbTablesMaps.keySet()) {
			String databaseName =  setDbTablesMaps.get(tableName);
			boolean isExistTable = appEventDao.isExistTable(databaseName, tableName);
			if(isExistTable) {
				createTable(databaseName, tableName, revisionDO);
			}
		}
	}
	
	private void createTable(String databaseName, String tableName, RevisionDO revisionDO) {
		try {
			appEventDao.createTable(databaseName, tableName);
			revisionDO.setInfo("Created new table.");
			revisionDO.setComments("databaseName=" + databaseName + ", tableName=" + tableName);
			this.updateRevision(revisionDO);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public void checkEntityColumns(RevisionDO revisionDO) {
		try {
			Map<String, String[]> lmsEntityMap = ServiceAccountDataEvent.getLmsDbEntityColumns();
			for(String tableName : lmsEntityMap.keySet()) {
				String[] columns = lmsEntityMap.get(tableName);
				for(int i=0; i<columns.length; i++) {
					String[] columnLength = StringUtils.split(columns[i], "=");
					String columnName = columnLength[0];
					String length = columnLength[1];
					//results[0]=COLUMN_NAME, results[1]=DATA_TYPE, results[2]=CHARACTER_MAXIMUM_LENGTH
					String[] results = appEventDao.checkColumnCharLength(ServiceAccountDataEvent.SOA_DB, tableName, columnName);
					int charMaxLength = Integer.valueOf(results[2]);
					//If -1, column does not exist
					if(charMaxLength == -1) {
						appEventDao.addColumn(ServiceAccountDataEvent.SOA_DB, tableName, columnName, length);
						revisionDO.setInfo("Added new column");
						revisionDO.setComments("databaseName=" + ServiceAccountDataEvent.SOA_DB + ", tableName=" + tableName 
								+ ", columnName=" + columnName + ", length=" + length);
						this.updateRevision(revisionDO);
					} else if(!columnLength[1].equals(ServiceAccountDataEvent.COLUMN_INT)) {
						//If database length is smaller, modify database column
						if(Integer.valueOf(results[2]) < Integer.valueOf(columnLength[1])) {
							String tempColumnName = ServiceAccountDataEvent.COLUMN_TEMP + columnName;
							//Create tempColumn
							appEventDao.addColumn(ServiceAccountDataEvent.SOA_DB, tableName, tempColumnName, length);
							//Copy data from old column to tempColumn
							appEventDao.copyColumn(ServiceAccountDataEvent.SOA_DB, tableName, columnName, tempColumnName);
							//Update old column to NULL
							appEventDao.updateColumnToNull(ServiceAccountDataEvent.SOA_DB, tableName, columnName);
							//Drop old column
							appEventDao.dropColumn(ServiceAccountDataEvent.SOA_DB, tableName, columnName);
							//Create column with new length
							appEventDao.addColumn(ServiceAccountDataEvent.SOA_DB, tableName, columnName, length);
							//Copy data from tempColumn to  new Column
							appEventDao.copyColumn(ServiceAccountDataEvent.SOA_DB, tableName, tempColumnName, columnName);
							//Update tempColumn to NULL
							appEventDao.updateColumnToNull(ServiceAccountDataEvent.SOA_DB, tableName, tempColumnName);
							//Drop tempColumn
							appEventDao.dropColumn(ServiceAccountDataEvent.SOA_DB, tableName, tempColumnName);
							revisionDO.setInfo("Changed column length");
							revisionDO.setComments("databaseName=" + ServiceAccountDataEvent.SOA_DB + ", tableName=" + tableName 
									+ ", columnName=" + columnName + ", length=" + length);
							this.updateRevision(revisionDO);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
