package com.bluesprucegroup.njrealtors.csvtopdf.dao.impl;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.QuickEntryDao;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.impl.sql.QuickEntrySql;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.rowmapper.QuickEntryDaoRowMapper;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.QuickEntryDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO.ServiceAccountFileItem;

@Component
public class QuickEntryDaoImpl implements QuickEntryDao {
	private static final Logger log = LogManager.getLogger(QuickEntryDaoImpl.class);
	@Autowired
	@Qualifier("solutionsourceJdbcTemplate")
	private JdbcTemplate solutionsourceJdbcTemplate;
	
	@Autowired
	@Qualifier("devopsJdbcTemplate")
	private JdbcTemplate devopsJdbcTemplate;
	
	@Autowired
	QuickEntrySql quickEntrySql;
	
	@Override
	public void findNewOrExisitng(ServiceAccountDataDO serviceAccountDataDO, ServiceAccountFileItem serviceAccountFileItem, List<QuickEntryDO> quickEntryDOList) {

		try {
			if(quickEntryDOList.size() > 0) {
				for(QuickEntryDO quickEntryDO : quickEntryDOList) {
					String queryForCount = this.quickEntrySql.countByQuickEntryID(String.valueOf(quickEntryDO.getQuickEntryID()));
					int count = this.devopsJdbcTemplate.queryForObject(queryForCount, Integer.class);
					if(count == 0) {
						byte[] elements = quickEntryDO.getElements();
						String saveSql = this.quickEntrySql.save();
						LobHandler lobHandler = new DefaultLobHandler();
						Object args[] = { 
								quickEntryDO.getFileTypeID(),//FileTypeID
								quickEntryDO.getName(),//Name
								quickEntryDO.getDescription(),//Description
								"Sysadmin",//UUID
								new SqlLobValue(new ByteArrayInputStream(elements), elements.length, lobHandler),//compressedText
								"Sysadmin", //Created By User
								"Sysadmin"//Updated By User 
						};
						this.devopsJdbcTemplate.update(saveSql, args, new int[] {
								Types.VARCHAR, //FileTypeID
								Types.VARCHAR,//Name
								Types.VARCHAR,//Description
								Types.VARCHAR, //UUID
								Types.BLOB, //compressedText
								Types.VARCHAR, //Created By User
								Types.VARCHAR //Updated By User  
						});
					} else {
						String updateToNull = this.quickEntrySql.updateElementToNull(String.valueOf(quickEntryDO.getQuickEntryID()));
						this.devopsJdbcTemplate.update(updateToNull);
						String updateQuickEntry = this.quickEntrySql.updateQuickEntry(String.valueOf(quickEntryDO.getQuickEntryID()));
						byte[] elements = quickEntryDO.getElements();
						LobHandler lobHandler = new DefaultLobHandler();
						Object args[] = { 
								quickEntryDO.getFileTypeID(),//FileTypeID
								quickEntryDO.getName(),//Name
								quickEntryDO.getDescription(),//Description
								new SqlLobValue(new ByteArrayInputStream(elements), elements.length, lobHandler),//compressedText
						};
						this.devopsJdbcTemplate.update(updateQuickEntry, args, new int[] {
								Types.VARCHAR, //FileTypeID
								Types.VARCHAR,//Name
								Types.VARCHAR,//Description
								Types.BLOB, //compressedText
						});
						
					}
				}
			}
			
		}
		catch(org.springframework.dao.EmptyResultDataAccessException e) {
			log.error("Unable to find fileElementsDOMap using fileFeaturesDO.getFileFeaturesID()");
		}
		catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		
		//return fileElements;
	}

	@Override
	public	List<QuickEntryDO> findQuickEntryByFileTypeID(String fileTypeID) {
		List<QuickEntryDO> quickEntryDOList = new ArrayList<QuickEntryDO>();
		try {
			String findQuickEntryByFileType = this.quickEntrySql.findQuickEntryByFileTypeID(fileTypeID);
			List<Map<String, Object>> rows = this.devopsJdbcTemplate.queryForList(findQuickEntryByFileType);
			for(Map<String, Object> rs : rows) {
				QuickEntryDO quickEntryDO = new QuickEntryDO();
				quickEntryDO.setQuickEntryID(new BigDecimal((long)rs.get("QuickEntryID")));
				quickEntryDO.setFileTypeID((String)rs.get("FileTypeID"));
				quickEntryDO.setName((String)rs.get("Name"));
				quickEntryDO.setDescription((String)rs.get("Description"));
				quickEntryDO.setElements((byte[])rs.get("Elements"));
				quickEntryDO.setUuid((String)rs.get("UUID"));
				quickEntryDOList.add(quickEntryDO);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return quickEntryDOList;
	}
	
	@Override
	public	QuickEntryDO findQuickEntryByQuickEntryID(String quickEntryID) {
		QuickEntryDO quickEntryDO = null;
		try {
			String findQuickEntryByQuickEntryID = this.quickEntrySql.findQuickEntryByQuickEntryID(quickEntryID);
			quickEntryDO = this.devopsJdbcTemplate.queryForObject(findQuickEntryByQuickEntryID, new QuickEntryDaoRowMapper()); 
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return quickEntryDO;
	}

	@Override
	public void createQuickEntry(QuickEntryDO quickEntryDO) {
		try {
			byte[] elements = quickEntryDO.getElements();
			String saveSql = this.quickEntrySql.save();
			LobHandler lobHandler = new DefaultLobHandler();
			Object args[] = { 
					quickEntryDO.getFileTypeID(),//FileTypeID
					quickEntryDO.getName(),//Name
					quickEntryDO.getDescription(),//Description
					"Sysadmin",//UUID
					new SqlLobValue(new ByteArrayInputStream(elements), elements.length, lobHandler),//compressedText
					"Sysadmin", //Created By User
					"Sysadmin"//Updated By User 
			};
			this.devopsJdbcTemplate.update(saveSql, args, new int[] {
					Types.VARCHAR, //FileTypeID
					Types.VARCHAR,//Name
					Types.VARCHAR,//Description
					Types.VARCHAR, //UUID
					Types.BLOB, //compressedText
					Types.VARCHAR, //Created By User
					Types.VARCHAR //Updated By User  
			});
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public void saveQuickEntryByFileTypeID(QuickEntryDO quickEntryDO, String quickEntryID) {
		try {
			String updateElementToNull = this.quickEntrySql.updateElementToNull(quickEntryID);
			this.devopsJdbcTemplate.update(updateElementToNull);
			String updateQuickEntry = this.quickEntrySql.updateQuickEntry(quickEntryID);
			byte[] elements = quickEntryDO.getElements();
			LobHandler lobHandler = new DefaultLobHandler();
			Object args[] = { 
					quickEntryDO.getFileTypeID(),//FileTypeID
					quickEntryDO.getName(),//Name
					quickEntryDO.getDescription(),//Description
					new SqlLobValue(new ByteArrayInputStream(elements), elements.length, lobHandler),//compressedText
			};
			this.devopsJdbcTemplate.update(updateQuickEntry, args, new int[] {
					Types.VARCHAR, //FileTypeID
					Types.VARCHAR,//Name
					Types.VARCHAR,//Description
					Types.BLOB, //compressedText
			});
			
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void	deleteQuickEntryByQuickEntryID(String quickEntryID) {
		try {
			String deleteSql = this.quickEntrySql.deleteQuickEntryByQuickEntryID(quickEntryID);
			this.devopsJdbcTemplate.update(deleteSql);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void saveFileUpload(TreeMap<String, HRefModel> hrefModelMap, String uuid) {
		try {
			for(String key : hrefModelMap.keySet()) {
				HRefModel href = hrefModelMap.get(key);
				String insertSql = this.quickEntrySql.saveFileUpload(href.getFileTypeID(), href.getPath(), href.getHrefText(), uuid, "Sysadmin", "Sysadmin");
				this.devopsJdbcTemplate.update(insertSql);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public List<HRefModel>  findFileUpload(String uuid) {
		List<HRefModel> hRefModelDOList = new ArrayList<HRefModel>();
		try {
			String findFileUpload = this.quickEntrySql.findFileUpload(uuid);
			List<Map<String, Object>> rows = this.devopsJdbcTemplate.queryForList(findFileUpload);
			for(Map<String, Object> rs : rows) {
				HRefModel hRefModel = new HRefModel();
				hRefModel.setFileTypeID((String)rs.get("FileTypeID"));
				hRefModel.setPath((String)rs.get("Path"));
				hRefModel.setHrefText((String)rs.get("Description"));
				hRefModel.setUuid((String)rs.get("UUID"));
				hRefModelDOList.add(hRefModel);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return hRefModelDOList;
	}
}
