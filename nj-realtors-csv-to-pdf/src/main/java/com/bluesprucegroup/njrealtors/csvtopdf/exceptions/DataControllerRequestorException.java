package com.bluesprucegroup.njrealtors.csvtopdf.exceptions;

public class DataControllerRequestorException extends Exception {
	private static final long serialVersionUID = 7624069228507659826L;
	private static final String MESSAGE = "Request rejected because requestor could not be verified";
	
	public DataControllerRequestorException(String additionalDetails) {
        super(MESSAGE + " - Additional Details: " + additionalDetails);
    }
}
