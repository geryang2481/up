SELECT  tDocCust.CustID,
	tCustInfo.LN AS lastName,  
	tCustInfo.FN AS firstName,  
	tCustInfo.CustNo AS custNo,  
	tCustInfo.TaxID AS taxID,  
	tCollat.CollatID AS collatID,  
	tlCollatVal.Collat AS collat,  
	tCollat.[Description of Collateral] AS descriptionOfCollateral,   
	tNoteInfo.NoteNum AS noteNum,  
	tDocCust.CustDocID AS custDocId, 
	tDocCust.DIID AS diid, 
	tlDocType.DocTypeDesc AS DocTypeDesc,
	tlDocItems.Item AS docItem,  
	tDocCust.bCrit AS bcrit,  
	tDocCust.RQ AS rq,  
	tDocCust.WV AS wv,  
	tDocCust.HV AS hv,  
	CONVERT(VARCHAR(10), tDocCust.Date, 101) AS dateOftDocCust,  
	CONVERT(VARCHAR(10), tDocCust.NxtDate, 101) AS nxtDate,  
	tlOffice.Initials AS officerID,  
	tlCustType.CustType AS ctid,  
	CASE  
		WHEN tDocCust.DocTypeID = 1 OR tDocCust.DocTypeID = 2  
		THEN tlBankadd1.[Bank Name]  
		WHEN tDocCust.DocTypeID = 3 OR tDocCust.DocTypeID = 4  
		THEN tlBankadd2.[Bank Name]  
		ELSE ''  
	END AS nBranch,  
	tlRecurrence.Name AS nrecurrence,  
	CONVERT(VARCHAR(10), tDocCust.dtLastSent, 101) AS dtLastSent,  
	CONVERT(VARCHAR(10), tDocCust.dtEst, 101) AS dtEst,  
	tlDocItems.nGrace as ngrace,
	CONCAT(tDocCust.memIdentifier,' ') AS memIdentifier,  
	tDocCust.bNotify AS bnotify,  
	tDocCust.bNotifyThird AS bnotifyThird
	
FROM  
	tDocCust tDocCust   
	LEFT JOIN [T Cust Info] tCustInfo  
		ON tDocCust.CustID = tCustInfo.CustId  
	LEFT JOIN [T Collat] tCollat  
		ON tDocCust.CollatID = tCollat.CollatID  
	LEFT JOIN [T Note Info] tNoteInfo  
		ON tDocCust.NIID = tNoteInfo.NIID  
	LEFT JOIN tlCollatVal tlCollatVal  
		ON tCollat.Collat = tlCollatVal.CLTID  
	LEFT JOIN tlDocItems tlDocItems  
		ON tDocCust.DIID = tlDocItems.DIID  
	LEFT JOIN tlDocType tlDocType  
		ON tDocCust.DocTypeID = tlDocType.DocTypeID  
	LEFT JOIN tlOfficer tlOffice  
		ON tDocCust.OfficerID = tlOffice.OffID  
	LEFT JOIN tlCustType tlCustType  
		ON tDocCust.CTID = tlCustType.CTID  
	LEFT JOIN tlBankAdd tlBankAdd1  
		ON tCustInfo.BankID = tlBankadd1.BankID  
	LEFT JOIN tlBankAdd tlBankAdd2  
		ON tNoteInfo.nBranch = tlBankadd2.BankID  
	LEFT JOIN tlRecurrence tlRecurrence  
		ON tDocCust.nRecurrence = tlRecurrence.ID  
WHERE  
	tDocCust.CustID = ?
	--AND ((tDocCust.nRecurrence > 1 AND tDocCust.RQ = 1) 
	--OR (tDocCust.RQ = 1  
	--AND tDocCust.WV = 0  
	--AND tDocCust.HV = 0 )  
	--OR (tDocCust.RQ = 1  
	--AND tDocCust.WV = 0  
	--AND tDocCust.HV = 1 	 
	--AND (tDocCust.NxtDate + tDocCust.nGrace) < GETDATE()))