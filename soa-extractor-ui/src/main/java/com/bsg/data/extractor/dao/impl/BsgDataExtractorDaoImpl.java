package com.bsg.data.extractor.dao.impl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bsg.data.extractor.dao.BsgDataExtractorDao;
import com.bsg.data.extractor.dao.rowmapper.DataInfoDORowMapper;
import com.bsg.data.extractor.dao.util.DaoUtil;
import com.bsg.data.extractor.domain.DataCommentsDO;
import com.bsg.data.extractor.domain.DataDocumentDO;
import com.bsg.data.extractor.domain.DataInfoDO;
import com.bsg.data.extractor.domain.BsgData;
import com.zaxxer.hikari.HikariConfigMXBean;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class BsgDataExtractorDaoImpl implements BsgDataExtractorDao {
	private static final Logger log = LogManager.getLogger(BsgDataExtractorDaoImpl.class);
	private static final String TEST_DB_CONNECTION_SQL = "testDBConnection.sql";
	private static final String FIND_DATA_INFO_SQL = "findDataInfoInfo.sql";
	private static final String FIND_ALL_CUSTS_SQL = "findAllCustomers.sql";
	private static final String FIND_COMMENTS_SQL = "findComments.sql";
	private static final String FIND_DATA_SQL = "findData.sql";
	@SuppressWarnings("unused")
	private boolean flag;
	
	//@Autowired
	HikariConfigMXBean hBean;
	
	@Autowired
	@Qualifier("jasperJdbcTemplate")
	private JdbcTemplate jasperTemplate;
	
	@Autowired
	private QueryReaderImpl queryReader;
	
	@Autowired
	FileItemWriter fileItemWriter;
	
	@Override
	public boolean isValidDbConnection(String jdbcurl, String username, String password) {
		String sql = queryReader.readQuery(TEST_DB_CONNECTION_SQL);
		JdbcTemplate jdbc = DaoUtil.createJdbc(jdbcurl, username, password, this.jasperTemplate);
		boolean isExistTable = false;
		try {
			Integer count = jdbc.queryForObject(sql, Integer.class);
			isExistTable = count > 0 ? true : false;
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return isExistTable;
	}

	@Override
	public boolean findTcustInfo(String jdbcurl, String username, String password, String custId) {
		String sql = queryReader.readQuery(FIND_DATA_INFO_SQL);
		sql = sql.replace("'?'", "'" + custId + "'");
		boolean isExistTable = false;
		JdbcTemplate jdbc = DaoUtil.createJdbc(jdbcurl, username, password, this.jasperTemplate);
		DataInfoDO tcustInfoDO = null;
		try {
			tcustInfoDO = jdbc.queryForObject(sql, new DataInfoDORowMapper());
		} catch(org.springframework.dao.EmptyResultDataAccessException e) { 
			if(tcustInfoDO != null) {
				isExistTable = true;
			}
			log.error(e.getMessage(), e);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return isExistTable;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public boolean dataExtractor(String jdbcurl, String username, String password, String output) throws IOException {
		boolean isBsgDataExtractor = false;
		JdbcTemplate jdbc = DaoUtil.createJdbc(jdbcurl, username, password, this.jasperTemplate);
		String currentTime = new String(this.fileItemWriter.getDate());
		String dataFile = "data_" + currentTime + ".tsv";
		String duplicateNoteCollatFile = "DuplicateNoteCollatFile" + currentTime + ".tsv";
		String commentsFile = "Comments_" + currentTime + ".tsv";
		String noCommentsFile = "CustomersWithNoComments_" + currentTime + ".tsv";
		String auditLogFile = "AuditLog_" + currentTime + ".txt";
		String dataMulti = "dataMulti_" + currentTime + ".tsv";
		
		OutputStream dataStream = null;//new File(output + dataFile);
		// duplicateNoteCollatStream = new File(this.fileItemWriterDO.getDirectory(this.flag) + duplicateNoteCollatFile);
		OutputStream commentsStream = null;//new File(output + commentsFile);
		// noCommentsStream = new File(this.fileItemWriterDO.getDirectory(this.flag) + noCommentsFile);
		OutputStream auditLogsStream = null;//new File(output + auditLogFile);
		// dataMultiStream = new File(this.fileItemWriterDO.getDirectory(this.flag) + dataMulti);
		StringBuffer stringBuffer = new StringBuffer();
		
		int dataCount = 0;
		int dataMultiCount = 0;
		int commentCount = 0;
		try {
			//1) findAllCustomers
			List<DataDocumentDO> tdocCustDOList =  findAllCustomers(jdbcurl, username, password, jdbc);
			//for(TDocCustDO tdocCustDO : tdocCustDOList) {
				Map<String, String> custDocIDMap = new HashMap<String, String>();
				
				//((OutputStream) dataStream).write(this.fileItemWriter.getdataHeaders().getBytes());
				commentsStream.write(this.fileItemWriter.getCommentsHeaders().getBytes());
				//dataMultiStream.write(this.fileItemWriterDO.getdataMultiHeaders().getBytes());
				
				//write data
				for(DataDocumentDO t : tdocCustDOList) {
					custDocIDMap.put(t.getCustId(), t.getCustId());
					dataCount = writeDataExtractor(custDocIDMap, t, dataStream, dataCount, jdbc);
				}//end of data stream
				
				//write Comments
				Iterator custDocIDIt = custDocIDMap.entrySet().iterator();
			    while (custDocIDIt.hasNext()) {
			    	commentCount = writeComments(stringBuffer, custDocIDIt, commentCount, commentsStream, jdbc);//noCommentCount, commentsStream, null);
			    	custDocIDIt.remove(); // avoids a ConcurrentModificationException
			    }
			    
				//Only for Guaranty
				boolean isGuarnaty = false;
				
				if(isGuarnaty) {
					//writeDuplicateCollaterals(stringBuffer, duplicateNoteCollatStream);
				}
				
				outputNumberOfCustomers(stringBuffer, tdocCustDOList);
				outputdataInfo(stringBuffer, dataCount, dataMultiCount, custDocIDMap);
				outputCommentsInfo(stringBuffer, commentCount);//, noCommentCount);
			//}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
			isBsgDataExtractor = false;
		} finally {
			auditLogsStream.write(stringBuffer.toString().getBytes());
			
			dataStream.close();
			commentsStream.close();
			//noCommentsStream.close();
			auditLogsStream.close();
			//dataMultiStream.close();
			exitInfo();
			isBsgDataExtractor = true;
		}
		return isBsgDataExtractor;
	}
	
	private List<DataDocumentDO> findAllCustomers(String jdbcurl, String username, String password, JdbcTemplate jdbc) {
		List<DataDocumentDO> tdocCustDOList = new ArrayList<DataDocumentDO>();
		String sql = queryReader.readQuery(FIND_ALL_CUSTS_SQL);
		try {
			List<Map<String, Object>> rows = jdbc.queryForList(sql);
			for (Map<String, Object> row : rows) {
				DataDocumentDO tdocCustDO = new DataDocumentDO();
				tdocCustDO.setCustId(DaoUtil.StringFix(row.get("CustID") + ""));
				tdocCustDOList.add(tdocCustDO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return tdocCustDOList;
	}
	
	

	

	private int writeDataExtractor(Map<String, String> custDocIDMap, DataDocumentDO tdocCustDO,  OutputStream outputStream, 
			int dataCount, JdbcTemplate jdbcTemplate) {
		List<BsgData> dataDOList = findData(jdbcTemplate, tdocCustDO.getCustId());
		try {
			for(BsgData dataDO : dataDOList) {				
				StringBuffer stringBuffer = new StringBuffer();
					//column01
				stringBuffer.append(dataDO.getTdocCustCustDocID());
				stringBuffer.append("\t");
				//column02
				stringBuffer.append(dataDO.getTcustInfoLastName());
				stringBuffer.append("\t");
				//column03
				stringBuffer.append(dataDO.getTcustInfoFirstName());
				stringBuffer.append("\t");
				//column04
				stringBuffer.append(dataDO.getTcustInfoCustNo());
				stringBuffer.append("\t");
				//column05
				stringBuffer.append(dataDO.getTcustInfoTaxID());
				stringBuffer.append("\t");				
				stringBuffer.append("\n");										
				outputStream.write(stringBuffer.toString().getBytes());
				dataCount++;
				custDocIDMap.put(dataDO.getTdocCustCustDocID(), tdocCustDO.getCustId());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dataCount;
	}

	@SuppressWarnings("unused")
	private StringBuffer writeDuplicateCollaterals(StringBuffer stringBuffer,  OutputStream duplicateStream, JdbcTemplate jdbcTemplate) {
		try {
			List<String> duplicateNoteCollatList = findDuplicate(jdbcTemplate);
			int duplciateCount = 0;
			duplicateStream.write(fileItemWriter.getDuplicateNoteHeaders().getBytes());
			for(String note : duplicateNoteCollatList) {
				duplicateStream.write(note.getBytes());
			}
		    System.out.println("Total number of duplicate: " + duplicateNoteCollatList.size());
			stringBuffer.append("Total number of duplicate List: " + duplicateNoteCollatList.size());
			stringBuffer.append("\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return stringBuffer;
	}
	
	@SuppressWarnings("rawtypes")
	private int writeComments(StringBuffer stringBuffer, Iterator custDocIDIt, int commentCount, 
			OutputStream commentsStream, JdbcTemplate jdbcTemplate) {//, int noCommentCount,  noCommentsStream) {
		try {
			//noCommentsStream.write(("CustDocID"+ "\n").getBytes());
			Map.Entry pair = (Map.Entry)custDocIDIt.next();
	        
			List<DataCommentsDO> dataCommentsDOList = findComments(jdbcTemplate, (String)pair.getKey());
	        
	        if(dataCommentsDOList.isEmpty()) {
	        	//noCommentsStream.write(((String)pair.getKey() + "\n").getBytes());
	        	//noCommentCount++;
	        }
	        
			for(DataCommentsDO dataCommentsDO : dataCommentsDOList) {
				StringBuffer commentsStringBuffer = new StringBuffer();
				//column01
				commentsStringBuffer.append(dataCommentsDO.getCustDocID());
				commentsStringBuffer.append("\t");
				//column02
				//commentsStringBuffer.append(dataCommentsDO.getLastName());
				//commentsStringBuffer.append("\t");
				//column03
				//commentsStringBuffer.append(dataCommentsDO.getFirstName());
				//commentsStringBuffer.append("\t");
				//column04
				//commentsStringBuffer.append(dataCommentsDO.getTaxID());
				//commentsStringBuffer.append("\t");
				//column05
				//commentsStringBuffer.append(dataCommentsDO.getItem());
				//commentsStringBuffer.append("\t");
				//column06
				commentsStringBuffer.append(dataCommentsDO.getComDate());
				commentsStringBuffer.append("\t");
				//column07
				commentsStringBuffer.append(dataCommentsDO.getComment());
				commentsStringBuffer.append("\n");
				
				commentsStream.write(commentsStringBuffer.toString().getBytes());
				commentCount++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return commentCount;
	}
	
	private StringBuffer outputNumberOfCustomers(StringBuffer stringBuffer, List<DataDocumentDO> tdocCustBoList) {
		
		try{
			System.out.println("Total number of customer: " + tdocCustBoList.size());
			stringBuffer.append("Total number of customer: " + tdocCustBoList.size());
			stringBuffer.append("\n");
			System.out.println("Processing data records....");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stringBuffer;
	}
	
	private StringBuffer outputdataInfo(StringBuffer stringBuffer, int dataCount, int dataMultiCount, Map<String, String> custDocIDMap) {
		try{
			System.out.println("Total number of data: " + dataCount);
			stringBuffer.append("Total number of data: " + dataCount);
			stringBuffer.append("\n");
			//System.out.println("Total number of data with multiple loans: " + dataMultiCount);
			//stringBuffer.append("Total number of data with multiple loans: " + dataMultiCount);
			//stringBuffer.append("\n");
			//System.out.println("Total number of unique customer documents: " + custDocIDMap.size());
			//stringBuffer.append("Total number of unique customer documents: " + custDocIDMap.size());
			//stringBuffer.append("\n");
			System.out.println("Processing records may take several minutes to complete....");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stringBuffer;
	}
	
	private StringBuffer outputCommentsInfo(StringBuffer stringBuffer, int commentCount) {//, int noCommentCount) {
		
		try{
			//System.out.println("Total number of data with no comments: " + noCommentCount);
			//stringBuffer.append("Total number of data with no comments: " + noCommentCount);
			//stringBuffer.append("\n");
			System.out.println("Total number of comments: " + commentCount);
			stringBuffer.append("Total number of comments: " + commentCount);
			stringBuffer.append("\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stringBuffer;
	}
	
	public List<String> findDuplicate(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<DataCommentsDO> findComments(JdbcTemplate jdbcTemplate, String custDocID) {
		String sql = queryReader.readQuery(FIND_COMMENTS_SQL);
		List<DataCommentsDO> dataCommentsDOList = new ArrayList<DataCommentsDO>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, custDocID);
			for(Map<String, Object> row : rows) {
				DataCommentsDO dataCommentsDO = new DataCommentsDO();
				dataCommentsDO.setCustDocID(DaoUtil.StringFix(row.get("CustDocumentID") + ""));
				dataCommentsDO.setComment(DaoUtil.StringFix(row.get("Comment") + ""));
				dataCommentsDO.setComDate(DaoUtil.StringFix(row.get("ComDate") + ""));
				dataCommentsDO.setLastName(DaoUtil.StringFix(row.get("LastName") + ""));
				dataCommentsDO.setFirstName(DaoUtil.StringFix(row.get("FirstName") + ""));
				dataCommentsDO.setTaxID(DaoUtil.StringFix(row.get("TaxID") + ""));
				dataCommentsDO.setItem(DaoUtil.StringFix(row.get("Item") + ""));
				dataCommentsDOList.add(dataCommentsDO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dataCommentsDOList;
	}
	
	private void exitInfo() {
		
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        System.out.println("Timestamp: " + timestamp);
			System.out.println("Extract Completed");
			Thread.sleep(1000);
			System.out.println("...");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<BsgData> findData(JdbcTemplate jdbcTemplate, String custId) {
		String sql = queryReader.readQuery(FIND_DATA_SQL);
		List<BsgData> dataDOList = new ArrayList<BsgData>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, custId);
			for (Map<String, Object> row : rows) {
				BsgData dataDO = new BsgData();
				
				//column01
				dataDO.setTdocCustCustDocID(DaoUtil.StringFix(row.get("documentId") + ""));
				//column02
				dataDO.setTcustInfoLastName(DaoUtil.StringFix(row.get("lastName") + ""));
				//column03
				dataDO.setTcustInfoFirstName(DaoUtil.StringFix(row.get("firstName") + ""));
				//column04
				dataDO.setTcustInfoCustNo(DaoUtil.StringFix(row.get("custDocumentNo") + ""));
				//column05
				dataDO.setTcustInfoTaxID(DaoUtil.StringFix(row.get("taxID") + ""));
				
				
				dataDOList.add(dataDO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return dataDOList;
	}
}
