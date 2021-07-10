package com.bluesprucegroup.njrealtors.csvtopdf.service;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;

public interface VerificationPdfService {
	public ServiceAccountDataDO verifyForm(ServiceAccountDataDO serviceAccountDataDO, String userName, String fileType, String auditLog);

}
