package com.bluesprucegroup.njrealtors.csvtopdf.event;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.RevisionDO;
import com.bluesprucegroup.njrealtors.csvtopdf.service.AppEventService;
import com.bluesprucegroup.njrealtors.csvtopdf.util.AppEventUtil;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger log = LogManager.getLogger(StartupApplicationListener.class);
	
	@Autowired
    private Environment environment;
	
	@Autowired
	private AppEventService appEventService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("Starting ServiceAccountData application environment validation >>>>");
		try {
			/*String uuid = UUID.randomUUID().toString();
			Gson gson = new Gson();
			logEnvironment(uuid, gson);
			checkRevisionTable(uuid);
			RevisionDO currentDBVersion = checkServiceAccountDBVersion(gson);
			RevisionDO revisionDO = compareVersions(uuid, currentDBVersion.getVersion(), environment.getProperty(ServiceAccountDataEvent.ServiceAccount_DATA_APP_VERSION));
			checkDatabaseStructure(revisionDO);*/
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		log.info("<<<< End ServiceAccountData application environment validation");
	}
	
	private void checkRevisionTable(String uuid) {
		appEventService.checkRevisionTable(uuid, environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
	}
	
	private void logEnvironment(String uuid, Gson gson) {
		log.info("UUID: " + gson.toJson(uuid));
		log.info("DEFAULT_PROFILES: " + gson.toJson(environment.getDefaultProfiles()));
		log.info("ACTIVE_PROFILES: " + gson.toJson(environment.getActiveProfiles()));
		log.info("SOA_DB_URL: " + gson.toJson(environment.getProperty(ServiceAccountDataEvent.SOA_DB_URL)));
		log.info("ServiceAccount_DB_URL: " + gson.toJson(environment.getProperty(ServiceAccountDataEvent.SERVICE_ACCOUNT_DB_URL)));
		log.info("ServiceAccount_DATA_APP_VERSION: " + gson.toJson(environment.getProperty(ServiceAccountDataEvent.SERVICE_ACCOUNT_DATA_APP_VERSION)));
		log.info("ServiceAccount_SOURCE_CLIENT_VERSION: " + gson.toJson(environment.getProperty(ServiceAccountDataEvent.SERVICE_ACCOUNT_SOURCE_CLIENT_VERSION)));
	}

	private RevisionDO checkServiceAccountDBVersion(Gson gson) {
		RevisionDO revisionDO = null;
		try {
			List<RevisionDO> revisionDOList = appEventService.findAllServiceAccountDatabaseVersion();
			revisionDO = appEventService.findCurrentServiceAccountDatabaseVersion();
			log.info("All ServiceAccount database versions: ");
			log.info(gson.toJson(revisionDOList));
			log.info("Current ServiceAccount database version: ");
			log.info(gson.toJson(revisionDO));
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return revisionDO;
	}
	
	private RevisionDO compareVersions(String uuid,  String currentDBVersion, String ServiceAccountDataAppVersion) {
		RevisionDO revisionDO = null;
		switch(AppEventUtil.compareVersions(currentDBVersion, ServiceAccountDataAppVersion)) {
			//Current version in the database is less than the version from the server properties file
			case 2:
				revisionDO = new RevisionDO();
				revisionDO.setVersion(ServiceAccountDataAppVersion);
				revisionDO.setInfo("Add new Revision version " + ServiceAccountDataAppVersion);
				revisionDO.setComments("Found currentDBVersion=" + currentDBVersion + ", updated to ServiceAccountAppVersion=" + ServiceAccountDataAppVersion);
				revisionDO.setUuid(uuid);
				revisionDO.setCreatedBy(environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
				revisionDO.setUpdatedBy(environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
				appEventService.updateRevision(revisionDO);
				break;
			//Current version in the database is greater than the version from the server properties file
			case 1:
				revisionDO = new RevisionDO();
				revisionDO.setVersion(ServiceAccountDataAppVersion);
				revisionDO.setInfo("Add new Revision version " + currentDBVersion);
				revisionDO.setComments("Found ServiceAccountAppVersion=" + ServiceAccountDataAppVersion + ", updated to currentDBVersion=" + currentDBVersion);
				revisionDO.setUuid(uuid);
				revisionDO.setCreatedBy(environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
				revisionDO.setUpdatedBy(environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
				appEventService.updateRevision(revisionDO);
				break;
			//Current version and the version form the server properties are the same - no need to update database
			case 0:
				revisionDO = new RevisionDO();
				revisionDO.setVersion(ServiceAccountDataAppVersion);
				revisionDO.setInfo("currentDBVersion=" + currentDBVersion);
				revisionDO.setComments("ServiceAccountAppVersion=" + ServiceAccountDataAppVersion);
				revisionDO.setUuid(uuid);
				revisionDO.setCreatedBy(environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
				revisionDO.setUpdatedBy(environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
				break;
			//Unable to recognize input for comparing versions
			case -1:
				break;
			//Break for all other scenarios
			default:
				revisionDO = new RevisionDO();
				revisionDO.setVersion(ServiceAccountDataAppVersion);
				revisionDO.setInfo("currentDBVersion=" + currentDBVersion);
				revisionDO.setComments("ServiceAccountAppVersion=" + ServiceAccountDataAppVersion);
				revisionDO.setUuid(uuid);
				revisionDO.setCreatedBy(environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
				revisionDO.setUpdatedBy(environment.getProperty(ServiceAccountDataEvent.APPLICATION_NAME));
				break;
		}
		return revisionDO;
	}
	
	private void checkDatabaseStructure(RevisionDO revisionDO) {
		appEventService.checkTables(revisionDO);
		appEventService.checkEntityColumns(revisionDO);
	}
}
