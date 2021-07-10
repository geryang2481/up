package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql;

import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.QuickEntryDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO.ServiceAccountFileItem;

@Component
public class QuickEntrySql {
	
	public String countByQuickEntryID(String quickEntryID) {
		/*Query
		 * 
		 * 
		 * SELECT
				COUNT([QuickEntry].QuickEntryID)
			FROM 
				[QuickEntry] [QuickEntry]
			WHERE 
				[QuickEntry].QuickEntryID = 'QuickEntryID' 
			ORDER BY [PageNo], [QuickEntryID] ASC
		 * 
		 */
		
		String query = "SELECT "
				+ "COUNT([QuickEntry].[QuickEntryID]) "
				+ "FROM " 
				+ "[QuickEntry] [QuickEntry] "
				+ " WHERE "
				+ "[QuickEntry].[QuickEntryID] = '" + quickEntryID + "'";
		return query;
	}

	public String findQuickEntryByFileTypeID(String fileTypeID) {
		/*Query
		 * 
		 * 
		 * SELECT
		 *     [QuickEntry].[QuickEntryID]
		      ,[QuickEntry].[FileTypeID]
		      ,[QuickEntry].[Name]
		      ,[QuickEntry].[Description]
		      ,[QuickEntry].[UUID]
		      ,[QuickEntry].[Elements]
		   FROM
		   		[QuickEntry] [QuickEntry] 
		   	WHERE 
		   		[QuickEntry].[FileTypeID] = ?
		 * 
		 */
		
		String query = "SELECT "
				+ "  [QuickEntry].[QuickEntryID]"
				+ " ,[QuickEntry].[FileTypeID] " 
				+ " ,[QuickEntry].[Name]"
				+ " ,[QuickEntry].[Description]"
				+ " ,[QuickEntry].[UUID]"
				+ " ,[QuickEntry].[Elements]"
				+ "  FROM [QuickEntry] [QuickEntry] "
				+ " WHERE "
				+ "[QuickEntry].[FileTypeID] = '" + fileTypeID + "'";
		return query;
	}
	
	public String findQuickEntryByQuickEntryID(String quickEntryID) {
		/*Query
		 * 
		 * 
		 * SELECT
		 *     [QuickEntry].[QuickEntryID]
		      ,[QuickEntry].[FileTypeID]
		      ,[QuickEntry].[Name]
		      ,[QuickEntry].[Description]
		      ,[QuickEntry].[UUID]
		      ,[QuickEntry].[Elements]
		   FROM
		   		[QuickEntry] [QuickEntry] 
		   	WHERE 
		   		[QuickEntry].[FileTypeID] = ?
		 * 
		 */
		
		String query = "SELECT "
				+ "  [QuickEntry].[QuickEntryID]"
				+ " ,[QuickEntry].[FileTypeID] " 
				+ " ,[QuickEntry].[Name]"
				+ " ,[QuickEntry].[Description]"
				+ " ,[QuickEntry].[UUID]"
				+ " ,[QuickEntry].[Elements]"
				+ " FROM [QuickEntry] [QuickEntry] "
				+ " WHERE "
				+ "[QuickEntry].[QuickEntryID] = '" + quickEntryID + "'";
		return query;
	}
	
	public String save() {
			
			/*Query
			 * 
			 	"INSERT INTO  
			 		[QuickEntry]  (
			 			[QuickEntryID]
			 			,[QuickEntry].[Description]
			 			,[QuickEntry].[Row]
			 			,[QuickEntry].[UUID] 
			 			,[QuickEntry].[Elements] 
			 			,[QuickEntry].[CreatedBy] 
			 			,[QuickEntry].[UpdatedBy] 
			 			) 
			 		VALUES
			 		(QuickEntryID()
			 		+ "'" + 
			 		+ "','Sysadmin','Sysadmin')" ;
			 */
			;
			return "INSERT INTO  "
					+ "[QuickEntry] "
					+ "("
					+ "[FileTypeID], "
					+ "[Name], "
					+ "[Description], "
					+ "[UUID], "
					+ "[Elements], "
					+ "[CreatedBy], "
					+ "[UpdatedBy] "
					+ ") "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?) ";
					
		}
	public String updateElementToNull(String quickEntryID) {
		
		/*Query
		 * 
		 	"UPDATE [QuickEntry]SET  
		 			[QuickEntry].[Elements]=NULL
		 		WHERE
		 			[QuickEntry].[QuickEntryID]=?
		 */
		;
		return "UPDATE  [QuickEntry] SET "
				+ " [QuickEntry].[Elements]=NULL "
				+ " WHERE "
				+ " [QuickEntry].[QuickEntryID]= '" + quickEntryID + "'";
				
	}
	
	public String updateQuickEntry(String quickEntryID) {
		
		/*Query
		 * 
		 	"UPDATE [QuickEntry] SET  
				 	,[QuickEntry].[FileTypeID]=?
				 	,[QuickEntry].[Name]=?
		 			,[QuickEntry].[Description]=?
		 			,[QuickEntry].[Elements]=?
		 		WHERE
		 			[QuickEntry].[QuickEntryID]=quickEntryID
		 */
		;
		return "UPDATE  [QuickEntry]  SET "
				+ " [QuickEntry].[FileTypeID]=? "
				+ " ,[QuickEntry].[Name]=? "
				+ " ,[QuickEntry].[Description]=? "
				+ " ,[QuickEntry].[Elements]=? "
				+ " WHERE "
				+ " [QuickEntry].[QuickEntryID]= '" + quickEntryID + "'";
				
	}

	public String deleteQuickEntryByQuickEntryID(String quickEntryID) {
		
		/*Query
		 * 
		 	"DELETE [QuickEntry] WHERE  [QuickEntryID]=?
				 
		 */
		;
		return "DELETE [QuickEntry] WHERE  [QuickEntryID]='" + quickEntryID + "'";
				
				
	}
	
	public String saveFileUpload(String fileTypeID, String path, String description, String uuid, String createdBy, String updatedBy) {
		/*Query
		 * 
		 	"INSERT INTO  
		 		[FileUpload]  (
		 			[QuickEntry].[FileTypeID]
		 			,[QuickEntry].[Row]
		 			,[QuickEntry].[UUID] 
		 			,[QuickEntry].[Elements] 
		 			,[QuickEntry].[CreatedBy] 
		 			,[QuickEntry].[UpdatedBy] 
		 			) 
		 		VALUES
		 		(QuickEntryID()
		 		+ "'" + 
		 		+ "','Sysadmin','Sysadmin')" ;
		 */
		;
		return "INSERT INTO  "
				+ "[FileUpload] "
				+ "("
				+ "[FileTypeID], "
				+ "[Path], "
				+ "[Description], "
				+ "[UUID], "
				+ "[CreatedBy], "
				+ "[UpdatedBy] "
				+ ") "
				+ "VALUES "
				+ " ("
				+ " '"  + fileTypeID + "' "
				+ " ,'" + path + "' "
				+ " ,'" + description + "' "
				+ " ,'" + uuid + "' "
				+ " ,'" + createdBy + "' "
				+ " ,'" + updatedBy + "' "
				+ ") ";
	}
	
	public String findFileUpload(String uuid) {
		String query = "SELECT "
				+ "  [FileUpload].[FileTypeID]"
				+ " ,[FileUpload].[Path] " 
				+ " ,[FileUpload].[Description]"
				+ " ,[FileUpload].[Description]"
				+ " ,[FileUpload].[UUID]"
				+ " FROM [FileUpload] [FileUpload] "
				+ " WHERE "
				+ "[FileUpload].[UUID] = '" + uuid + "'";
		return query;
	}
}
