SELECT 
	tDocComments.CustDocID AS CustDocID, 
	tDocComments.Comment AS Comment, 
	CONVERT(VARCHAR(10), tDocComments.ComDate, 101) AS ComDate,
	tCustInfo.LN AS LastName,
	tCustInfo.FN AS FirstName,
	tCustInfo.TaxID AS TaxID,
	 tlDocItems.Item AS Item
FROM 
	tDocComments tDocComments 
	LEFT JOIN tDocCust tDocCust
		ON tDocCust.CustDocID = tDocComments.CustDocID
	LEFT JOIN [T Cust Info] tCustInfo
		ON tCustInfo.CustID = tDocCust.CustID
	LEFT JOIN tlDocItems tlDocItems
		ON tDocCust.DIID = tlDocItems.DIID
WHERE 
	tDocComments.CustDocID = ?