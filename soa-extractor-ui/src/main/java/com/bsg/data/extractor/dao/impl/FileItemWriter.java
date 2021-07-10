package com.bsg.data.extractor.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FileItemWriter {
	public String getdataHeaders() {
		StringBuffer sb = new StringBuffer();

		//column01
		sb.append("dataID");
		sb.append("\t");
		//coulmn02
		sb.append("Last Name or Bus Name");
		sb.append("\t");
		//coulmn03
		sb.append("First Name");
		sb.append("\t");
		//coulmn04
		sb.append("Portfolio ID");
		sb.append("\t");
		//coulmn05
		sb.append("Tax ID");
		sb.append("\t");
		//coulmn06
		sb.append("Collateral ID");
		sb.append("\t");
		//coulmn07
		sb.append("Collateral Type");
		sb.append("\t");
		//coulmn08
		sb.append("Description of Collateral");
		sb.append("\t");
		//coulmn09
		sb.append("Loan Number");
		sb.append("\t");
		//coulmn10
		//sb.append("Loan Status ID");
		//sb.append("\t");
		//coulmn11
		//sb.append("Loan Status");
		//sb.append("\t");
		//coulmn12
		sb.append("DIID");
		sb.append("\t");
		//coulmn13
		sb.append("Documentation Description");
		sb.append("\t");
		//coulmn14
		sb.append("Documentation Item");
		sb.append("\t");
		//coulmn15
		sb.append("Critical");
		sb.append("\t");
		//coulmn16
		sb.append("Required");
		sb.append("\t");
		//coulmn17
		sb.append("Waived");
		sb.append("\t");
		//coulmn18
		sb.append("Have");
		sb.append("\t");
		//coulmn19
		sb.append("Document Date");
		sb.append("\t");
		//coulmn20
		sb.append("Next Due Date");
		sb.append("\t");
		//coulmn21
		//sb.append("Officer Name");
		//sb.append("\t");
		//coulmn22
		sb.append("Officer");
		sb.append("\t");
		//coulmn23
		sb.append("Entity Type");
		sb.append("\t");
		//coulmn24
		sb.append("Branch");
		sb.append("\t");
		//coulmn25
		sb.append("Recurrence");
		sb.append("\t");
		//coulmn26
		sb.append("Last Notification Date");
		sb.append("\t");
		//coulmn27
		sb.append("Date Established");
		sb.append("\t");
		//coulmn28
		//sb.append("Grace");
		//sb.append("\t");
		//coulmn28
		//sb.append("Active Status");
		//sb.append("\t");
		//coulmn28
		sb.append("Identifier");
		sb.append("\t");
		//coulmn28
		sb.append("Notify");
		sb.append("\t");
		//coulmn29
		sb.append("Notify Third Party");
		
		sb.append("\n");
		
		return sb.toString();
	}
	
	public String getCommentsHeaders() {
		StringBuffer sb = new StringBuffer();
		//column01
		sb.append("data ID");
		sb.append("\t");
		//column02
		//sb.append("Last Name");
		//sb.append("\t");
		//column03
		//sb.append("First Name");
		//sb.append("\t");
		//column04
		//sb.append("Tax ID");
		//sb.append("\t");
		//column05
		//sb.append("Documentation Item");
		//sb.append("\t");
		//column06
		sb.append("Comment Date");
		sb.append("\t");
		//column07
		sb.append("Comment");
		sb.append("\n");
				
		return sb.toString();
	}
	
	public String getDuplicateNoteHeaders() {
		StringBuffer sb = new StringBuffer();
		sb.append("CollatID");
		sb.append("\t");
		sb.append("NoteNum");
		sb.append("\n");
				
		return sb.toString();
	}
	
	public String getdatasWithMultipleLoansHeaders() {
		StringBuffer sb = new StringBuffer();
		sb.append("CustDocID");
		sb.append("\t");
		sb.append("NoteNum");
		sb.append("\n");
		return sb.toString();
	}
	
	public String getDate() {
		String date = new String();
		String pattern = "yyyy-MM-dd_HHmmssZ";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
	    date = format.format(new Date());
	    return date;
	}
	
	public String getOldDirectory(String output) {
		return output;
	}
	
	public String getOldDirectory(boolean flag) {
		//System.out.println("Working Directory = " +  System.getProperty("user.dir"));
		String directory = "";
		if(flag) {
			directory = System.getProperty("user.dir") + "/output/";
			directory = directory.replace("\\", "/");
		} else {
			directory = "c:/apps/bsg/data-extractor/output/";
		}
		return directory;
	}
}
