package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql;

import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.RevisionDO;

@Component
public class AppEventSql {
	
	public String checkColumnCharLength(String tableName, String columnName) {
		String sql = "SELECT "
						+ " COLUMN_NAME, "
						+ " DATA_TYPE, "
						+ " CHARACTER_MAXIMUM_LENGTH "
						+ " FROM "
						+ "INFORMATION_SCHEMA.COLUMNS "
					+ " WHERE "
						+ "TABLE_NAME = "
						+ "'" + tableName + "' " 
						+ " AND COLUMN_NAME = "
						+ " '" + columnName + "' ";
		return sql;
	}
	
	public String checkExistTable(String tableName) {
		String sql = "IF EXISTS (SELECT 1  "
			           + " FROM INFORMATION_SCHEMA.TABLES " 
			      + " WHERE TABLE_TYPE='BASE TABLE' " 
			           + " AND TABLE_NAME='" + tableName + "') "
			      + " SELECT 1 AS RES ELSE SELECT 0 AS RES; ";
		return sql;
	}

	public String addColumnNvarchar(String tableName, String columnName, String length) {
		String sql = "ALTER TABLE " 
				+ tableName 
				+ " ADD "
				+ columnName
				+ " NVARCHAR(" + length + ") NULL ";
		return sql;
	}
	
	public String addColumnInt(String tableName, String columnName) {
		String sql = "ALTER TABLE " 
				+ tableName 
				+ " ADD "
				+ columnName
				+ " INT NULL ";
		return sql;
	}
	
	public String copyColumn(String tableName, String sourceColumn, String destinationColumn) {
		String sql = " UPDATE "
				+ tableName 
				+ " SET "
				+ destinationColumn + " = " + sourceColumn
				+ " WHERE " + sourceColumn + " IS NOT NULL";
		return sql;
	}
	
	public String updateColumnToNull(String tableName, String columnName) {
		String sql = " UPDATE "
				+ tableName 
				+ " SET "
				+ columnName + " = NULL ";
		return sql;
	}
	
	public String dropColumn(String tableName, String columnName) {
		String sql = " ALTER TABLE "
				+ tableName 
				+ " DROP COLUMN "
				+ columnName;
		return sql;
	}
	
	public String createRevisionTable() {
		String sql = "CREATE TABLE [dbo].[Revision] "
							+ " ( "
							    + " [RevisionID] [bigint] IDENTITY(1,1) NOT NULL, "
							    + " [Version] [nvarchar](255) NULL, "
							    + " [Info] [nvarchar](MAX) NULL, "
							    + " [Comments] [nvarchar](MAX) NULL, "
							    + " [UUID] [nvarchar](255) NULL, "
							    + " [CreatedDateTime] [datetime] NULL, "
							    + " [CreatedBy] [nvarchar](255) NULL, "
							    + " [UpdatedDateTime] [datetime] NULL, "
							    + " [UpdatedBy] [nvarchar](255) NULL, "
							    + " PRIMARY KEY CLUSTERED  "
							+ " ( "
								+ " [RevisionID] ASC "
							+ " )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY] "
							+ " ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY] "
							+ "   "
							+ " ALTER TABLE [dbo].[Revision] ADD  DEFAULT (getdate()) FOR [CreatedDateTime] "
							+ "   "
							+ " ALTER TABLE [dbo].[Revision] ADD  DEFAULT (getdate()) FOR [UpdatedDateTime] "
							+ "   "
							+ " ";
		return sql;
	}
	
	public String createOutputStreamTable() {
		String sql = "CREATE TABLE [dbo].[OutputStream] "
							+ " ( "
							    + " [OutputStreamID] [bigint] IDENTITY(1,1) NOT NULL, "
							    + " [Object] [varbinary](max) NULL, "
							    + " [Status] [nvarchar](max) NULL, "
							    + " [UUID] [nvarchar](255) NULL, "
							    + " [CreatedDateTime] [datetime] NULL, "
							    + " [CreatedBy] [nvarchar](255) NULL, "
							    + " [UpdatedDateTime] [datetime] NULL, "
							    + " [UpdatedBy] [nvarchar](255) NULL, "
							    + " PRIMARY KEY CLUSTERED  "
							+ " ( "
								+ " [OutputStreamID] ASC "
							+ " )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY] "
							+ " ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY] "
							+ "   "
							+ " ALTER TABLE [dbo].[OutputStream] ADD  DEFAULT (getdate()) FOR [CreatedDateTime] "
							+ "   "
							+ " ALTER TABLE [dbo].[OutputStream] ADD  DEFAULT (getdate()) FOR [UpdatedDateTime] "
							+ "   "
							+ " ";
		return sql;
	}
	
	public String updateRevision(RevisionDO revisionDO) {
		String sql = "INSERT INTO REVISION "
				+ " ( Version, Info, Comments, UUID, CreatedBy, UpdatedBy )"
				+ " VALUES (" 
				+ " '" + revisionDO.getVersion() + "' "
				+ " ,'" + revisionDO.getInfo() + "' "
				+ " ,'" + revisionDO.getComments() + "' "
				+ " ,'" + revisionDO.getUuid() + "' "
				+ " ,'" + revisionDO.getCreatedBy() + "' "
				+ " ,'" + revisionDO.getUpdatedBy() + "' )";
		return sql;
	}
	
	public String findCurrentServiceAccountDatabaseVersion() {
		/*Query
		 * 
		 	SELECT
		 	   [RevisionID]
		      ,[Version]
		      ,[Info]
		      ,[Comments]
		      ,[UUID]
		      ,[CreatedBy]
		      ,[CreatedDateTime]
		      ,[UpdatedBy]
		      ,[UpdatedDateTime]
		   FROM
		   		[Revision]
		   ORDER BY [Version]  DESC
		 * 
		 */
		
		return "SELECT TOP (1)"
				+ "  [RevisionID] "
		        + " ,[Version] "
		        + " ,[Info] "
		        + " ,[Comments] "
		        + " ,[UUID] "
		        + " ,[CreatedBy] "
		        + " ,[CreatedDateTime] "
		        + " ,[UpdatedBy] "
		        + " ,[UpdatedDateTime] "
		   + " FROM "
		   		+ " [Revision]"
		   		+ " ORDER BY [Version]  DESC ";
	}
	
	public String findAllServiceAccountDatabaseVersions() {
		/*Query
		 * 
		 	SELECT
		 	   [RevisionID]
		      ,[Version]
		      ,[Info]
		      ,[Comments]
		      ,[UUID]
		      ,[CreatedBy]
		      ,[CreatedDateTime]
		      ,[UpdatedBy]
		      ,[UpdatedDateTime]
		   FROM
		   		[Revision]
		   	ORDER BY [RevisionID]  ASC
		 * 
		 */
		
		return "SELECT "
				+ "  [RevisionID] "
		        + " ,[Version] "
		        + " ,[Info] "
		        + " ,[Comments] "
		        + " ,[UUID] "
		        + " ,[CreatedBy] "
		        + " ,[CreatedDateTime] "
		        + " ,[UpdatedBy] "
		        + " ,[UpdatedDateTime] "
		   + " FROM "
		   		+ " [Revision]"
		   		+ " ORDER BY [RevisionID]  ASC ";
	}
}
