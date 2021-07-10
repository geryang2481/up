package com.bluesprucegroup.njrealtors.csvtopdf.service;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;

public interface TransactionService {

	public ServiceAccountDataDO createTransaction(String userName, String fileName, String auditLog);
			
	public ServiceAccountDataDO createTransaction(String custID, String guid, String pdfPassword, String userName, String auditLog);
	
	public void updateTransaction(ServiceAccountDataDO serviceAccountDataDO, String serviceAccountFormItem);
	
}
