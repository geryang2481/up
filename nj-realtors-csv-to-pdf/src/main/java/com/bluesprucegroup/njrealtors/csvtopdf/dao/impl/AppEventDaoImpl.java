package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import com.bluesprucegroup.njrealtors.csvtopdf.dao.AppEventDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql.AppEventSql;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper.ColumnCharLengthRowMapper;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper.RevisionDaoRowMapper;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.RevisionDO;
import com.bluesprucegroup.njrealtors.csvtopdf.event.ServiceAccountDataEvent;

@Component
public class AppEventDaoImpl implements AppEventDao{
	private static final Logger log = LogManager.getLogger(AppEventDaoImpl.class);
	
	@Autowired
	@Qualifier("solutionsourceJdbcTemplate")
	private JdbcTemplate solutionsourceJdbcTemplate;
	
	@Autowired
	@Qualifier("devopsJdbcTemplate")
	private JdbcTemplate devopsJdbcTemplate;
	
	@Autowired
	private AppEventSql appEventSql;
	
	@Override
	public boolean isExistTable(String databaseName, String tableName) {
		JdbcTemplate jdbcTemplate = getDatasource(databaseName);
		boolean isExistTable = false;
		try {
			String checkExistTableSql = appEventSql.checkExistTable(tableName);
			int count = jdbcTemplate.queryForObject(checkExistTableSql, Integer.class);
			isExistTable = count < 1 ? true : false;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return isExistTable;
	}

	@Override
	public String[] checkColumnCharLength(String databaseName, String tableName, String columnName) {
		JdbcTemplate jdbcTemplate = getDatasource(databaseName);
		String[] results = null;
		try {
			results = jdbcTemplate.queryForObject(appEventSql.checkColumnCharLength(tableName, columnName), new ColumnCharLengthRowMapper());
		} catch(EmptyResultDataAccessException e) {
			results = new String[] { "", "", "-1" };
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return results;
	}
	
	@Override
	public void addColumn(String databaseName, String tableName, String columnName, String length) {
		JdbcTemplate jdbcTemplate = getDatasource(databaseName);
		try {
			if(length.equals(ServiceAccountDataEvent.COLUMN_INT)) {
				jdbcTemplate.update(appEventSql.addColumnInt(tableName, columnName));
			} else {
				jdbcTemplate.update(appEventSql.addColumnNvarchar(tableName, columnName, length));
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void copyColumn(String databaseName, String tableName, String sourceColumn, String destinationColumn) {
		JdbcTemplate jdbcTemplate = getDatasource(databaseName);
		try {
			jdbcTemplate.update(appEventSql.copyColumn(tableName, sourceColumn, destinationColumn));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void updateColumnToNull(String databaseName, String tableName, String columnName) {
		JdbcTemplate jdbcTemplate = getDatasource(databaseName);
		try {
			jdbcTemplate.update(appEventSql.updateColumnToNull(tableName, columnName));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void dropColumn(String databaseName, String tableName, String columnName) {
		JdbcTemplate jdbcTemplate = getDatasource(databaseName);
		try {
			jdbcTemplate.update(appEventSql.dropColumn(tableName, columnName));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void createTable(String databaseName, String tableName) {
		JdbcTemplate jdbcTemplate = getDatasource(databaseName);
		String createTableSql = "";
		try {
			switch(tableName) {
				case ServiceAccountDataEvent.SET_DB_REVISION_TABLE:
					createTableSql = appEventSql.createRevisionTable();
					break;
				case ServiceAccountDataEvent.SET_DB_OUTPUTSTREAM_TABLE:
					createTableSql = appEventSql.createOutputStreamTable();
					break;
				default:
					return;
			}
			if(!StringUtils.isEmpty(createTableSql)) {
				jdbcTemplate.update(createTableSql);
			} else {
				throw new NullPointerException("createTableSql script is NULL.");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void updateRevision(RevisionDO revisionDO) {
		try {
			this.devopsJdbcTemplate.update(appEventSql.updateRevision(revisionDO));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public RevisionDO findCurrentServiceAccountDatabaseVersion() {
		RevisionDO revisionDO = null;
		try {
			revisionDO = (RevisionDO)this.devopsJdbcTemplate.queryForObject(appEventSql.findCurrentServiceAccountDatabaseVersion(), new RevisionDaoRowMapper());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return revisionDO;
	}

	@Override
	public List<RevisionDO> findAllServiceAccountDatabaseVersion() {
		List<RevisionDO> revisionDOList = null;
		try {
			revisionDOList = this.devopsJdbcTemplate.query(appEventSql.findAllServiceAccountDatabaseVersions(), new RevisionDaoRowMapper());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return revisionDOList;
	}
	
	private JdbcTemplate getDatasource(String databaseName) {
		if(databaseName.equals(ServiceAccountDataEvent.SET_DB)) {
			return this.devopsJdbcTemplate;
		} else if(databaseName.equals(ServiceAccountDataEvent.SOA_DB)) {
			return this.solutionsourceJdbcTemplate;
		} else {
			return null;
		}
	}
}
