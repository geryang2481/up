package com.bluesprucegroup.njrealtors.csvtopdf.service.impl;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.service.TransactionService;
import com.bluesprucegroup.njrealtors.csvtopdf.util.AuditLogUtil;

@Component
public class TransactionServiceImpl implements TransactionService {
	
	private static final Logger log = LogManager.getLogger(TransactionServiceImpl.class);
	
	//@Autowired
	//private TransactionDao transactionDao;
	
	@Override
	public ServiceAccountDataDO createTransaction(String custID, String guid, String pdfPassword, String userName, String auditLog) {
		
		ServiceAccountDataDO serviceAccountDataDO = null;
		
		try {
			serviceAccountDataDO = new ServiceAccountDataDO();
			serviceAccountDataDO.setUuid(UUID.randomUUID().toString());
			serviceAccountDataDO.setCustID(custID);
			serviceAccountDataDO.setGuid(guid);
			serviceAccountDataDO.setPdfPassword(pdfPassword);
			serviceAccountDataDO.setUserName(userName);
			serviceAccountDataDO.setAuditLog(auditLog);
			//serviceAccountDataDO.setStatusCodeList(new LinkedList<HttpStatus>());
			//serviceAccountDataDO.setStatusList(new LinkedList<String>());
			serviceAccountDataDO.setStatusCode(AuditLogUtil.OK);
			serviceAccountDataDO.setStatus(AuditLogUtil.TX_COMPLETED);
			log.info("Transaction created.  GUID=" + guid + ", CustID=" + custID + ", userName=" + userName);
		} catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		
		//return transactionDao.saveTransaction(serviceAccountDataDO);
		return null;
	}

	@Override
	public ServiceAccountDataDO createTransaction(String userName, String fileName, String auditLog) {
		ServiceAccountDataDO serviceAccountDataDO = null;
		
		try {
			serviceAccountDataDO = new ServiceAccountDataDO();
			serviceAccountDataDO.setUuid(UUID.randomUUID().toString());
			serviceAccountDataDO.setCustID("0");
			serviceAccountDataDO.setFileName(fileName);
			serviceAccountDataDO.setGuid("N/A");
			serviceAccountDataDO.setPdfPassword("N/A");
			serviceAccountDataDO.setUserName(userName);
			serviceAccountDataDO.setAuditLog(auditLog);
			//serviceAccountDataDO.setStatusCodeList(new LinkedList<HttpStatus>());
			//serviceAccountDataDO.setStatusList(new LinkedList<String>());
			serviceAccountDataDO.setStatusCode(AuditLogUtil.OK);
			serviceAccountDataDO.setStatus(AuditLogUtil.TX_COMPLETED);
			log.info("Transaction created.  fileName=" + fileName + ", userName=" + userName);
		} catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		
		return serviceAccountDataDO;
	}
	
	public void updateTransaction(ServiceAccountDataDO serviceAccountDataDO, String serviceAccountFormItem) {
		//transactionDao.updateTransaction(serviceAccountDataDO, serviceAccountFormItem);
		log.info("Transaction updated.  GUID=" + serviceAccountDataDO.getGuid() + ", UUID=" + serviceAccountDataDO.getUuid() + ", fileName=" + serviceAccountDataDO.getFileName() + ", userName=" + serviceAccountDataDO.getUserName());
	}

	
}
