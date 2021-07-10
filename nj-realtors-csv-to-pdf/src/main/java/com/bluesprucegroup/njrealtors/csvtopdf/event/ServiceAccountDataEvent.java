package com.bluesprucegroup.njrealtors.csvtopdf.event;

import java.util.HashMap;
import java.util.Map;

public class ServiceAccountDataEvent {
	public static final String APPLICATION_NAME = "spring.application.name";
	public static final String SOA_DB_URL = "spring.datasource.soa.jdbc-url";
	public static final String SERVICE_ACCOUNT_DB_URL = "spring.datasource.nj_realtors_csv_to_pdf.jdbc-url";
	public static final String SERVICE_ACCOUNT_DATA_APP_VERSION = "com.bluesprucegroup.nj_realtors_csv_to_pdf.app.version";
	public static final String SERVICE_ACCOUNT_SOURCE_CLIENT_VERSION = "com.bluesprucegroup.nj_realtors_csv_to_pdf.source.clientversion";
	public static final String SERVICE_ACCOUNT_REVISION_VERSION_1_0_0_0 = "1.0.0.0";
	public static final String SET_DB = "DevOpsDB";
	public static final String SOA_DB = "SOA";
	public static final String SET_DB_REVISION_TABLE = "Revision";
	public static final String SET_DB_OUTPUTSTREAM_TABLE = "OutputStream";
	public static final String SOA_DB_TCABUSINESS_TABLE = "tCABusiness";
	public static final String SOA_DB_TCAFARM_TABLE = "tCAFarm";
	public static final String SOA_DB_TCARENTAL_TABLE = "tCARental";
	public static final String SOA_DB_serviceAccountIMPORT_TABLE = "serviceAccountImport";
	public static final String COLUMN_INT = "INT";
	public static final String COLUMN_TEMP = "TEMP"; 
	
	public static Map<String, String[]> getLmsDbEntityColumns() {
		Map<String, String[]> lmsEntityMap = new HashMap<String, String[]>();
		String[] tCABusiness = new String[] { "BusinessName=255", "BusinessAddress=4000", "ProprietorName=255", "PrincipalBusiness=4000", "TaxID=50"  };
		String[] tCAFarm = new String[] { "FarmName=255", "FarmDesc=4000", "TaxID=50" };
		String[] tCARental = new String[] { "PropertyDesc=4000", "PropertyAddress=4000", "EntityName=255", "TaxID=50" };
		String[] serviceAccountImport = new String[] { "FileTypeInfo=4000", "EntityColumnType=4000", "EntityColumnCode=255" };
		lmsEntityMap.put(ServiceAccountDataEvent.SOA_DB_TCABUSINESS_TABLE, tCABusiness);
		lmsEntityMap.put(ServiceAccountDataEvent.SOA_DB_TCAFARM_TABLE, tCAFarm);
		lmsEntityMap.put(ServiceAccountDataEvent.SOA_DB_TCARENTAL_TABLE, tCARental);
		lmsEntityMap.put(ServiceAccountDataEvent.SOA_DB_serviceAccountIMPORT_TABLE, serviceAccountImport);
		return lmsEntityMap;
	}
	
	public static HashMap<String, String> getSetDbTablesMap() {
		HashMap<String, String> setDbTables = new HashMap<String, String>();
		setDbTables.put(ServiceAccountDataEvent.SET_DB_OUTPUTSTREAM_TABLE, ServiceAccountDataEvent.SET_DB);
		return setDbTables;
	}
}
