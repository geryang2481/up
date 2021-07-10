package com.bluesprucegroup.njrealtors.csvtopdf.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;
import com.bluesprucegroup.njrealtors.csvtopdf.dao.QuickEntryDao;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.Njr118DO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.NjrlpdDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.QuickEntryDO;
import com.bluesprucegroup.njrealtors.csvtopdf.generate.QuickEntryToPdf;
import com.bluesprucegroup.njrealtors.csvtopdf.service.FileService;
import com.bluesprucegroup.njrealtors.csvtopdf.transformer.DataObjectTransformer;

@Component
public class FileServiceImpl implements FileService {
	private static final Logger log = LogManager.getLogger(FileServiceImpl.class);
	
	@Autowired
	QuickEntryDao quickEntryDao;
	
	@Autowired
	QuickEntryToPdf quickEntryToPdf;
	
	//Upload Files - HTML GSMLS
	public List<String> parseHtml_gsmls(Path path) throws IOException {
		String[] myOutput = new String[] {"",""};
		List<String> list1 = null;
		try {
			File input = path.toFile();
			StringBuilder colBuilder = new StringBuilder();
			StringBuilder strongBuilder = new StringBuilder();
			Document htmlDocument = Jsoup.parse(input, "UTF-8", "http://mlsold.gsmls.com/");
			
			//Elements reportTitleElements = htmlDocument.getElementsByClass("report-cell title-color top-title");
			Elements checkBoxElements = htmlDocument.getElementsByClass("l chkbxshow");
			//RecordID
			String recordID = checkBoxElements.attr("value");
			//l town
			Elements townElements = htmlDocument.getElementsByClass("l town");
			StringBuilder builder1Town = new StringBuilder();
			for(Element element : townElements) {
				builder1Town.append(formatString(element.toString()));
			}
			//l address
			Elements addressElements = htmlDocument.getElementsByClass("l address");
			StringBuilder builder1Address = new StringBuilder();
			for(Element element : addressElements) {
				builder1Address.append(formatString(element.toString()));
			}
			//r price
			Elements priceElements = htmlDocument.getElementsByClass("r price");
			StringBuilder builderRprice = new StringBuilder();
			for(Element element : priceElements) {
				builderRprice.append(formatString(element.toString()));
			}
			//Report title
			Elements reportTitleElements = htmlDocument.getElementsByClass("report-row-label report-title");
			StringBuilder reportTitle = new StringBuilder();
			for(Element element : reportTitleElements) {
				reportTitle.append(formatString(element.toString()));
			}
			//Column-one
			Elements reportColumnOne = htmlDocument.getElementsByClass("column-one");
			StringBuilder colOne = new StringBuilder();
			for(Element element : reportColumnOne) {
				colOne.append(formatString(element.toString()));
			}
			//Column-two
			Elements reportColumnTwo = htmlDocument.getElementsByClass("column-two");
			StringBuilder colTwo = new StringBuilder();
			for(Element element : reportColumnOne) {
				colTwo.append(formatString(element.toString()));
			}
			//Column-three
			Elements reportColumnThree = htmlDocument.getElementsByClass("column-three");
			StringBuilder colThree = new StringBuilder();
			for(Element element : reportColumnOne) {
				colThree.append(formatString(element.toString()));
			}
			//NormalWrap
			Elements reportNormalWrap = htmlDocument.getElementsByClass("report-row-label normalWrap");
			StringBuilder normalWrapBuilder = new StringBuilder();
			for(Element element : reportNormalWrap) {
				normalWrapBuilder.append(formatString(element.toString()));
			}
			//NormalWrap
			Elements reportRowLabelElements = htmlDocument.getElementsByClass("report-row-label");
			StringBuilder reportRowLabelBuilder = new StringBuilder();
			for(Element element : reportRowLabelElements) {
				String s = formatString(element.toString());
				if(!s.contains("=")) {
					reportRowLabelBuilder.append(s);
				}
			}
			//log.info("recordID=\r\n" + recordID.toString());
			int i1 = builder1Town.toString().indexOf("mobile");
			//String builder1townString =  builder1Town.toString().substring(0, i1);
			//log.info("builder1Town=\r\n" + builder1townString);
			
			int i2 = builder1Town.toString().indexOf("mobile");
			//String builder1addressString =  builder1Address.toString().substring(0, i2);
			//log.info("builder1Address=\r\n" + builder1addressString.toString());
			
			int i3 = builderRprice.toString().indexOf("clear");
			//String builder1priceString =  builderRprice.toString().substring(0, i3);
			//log.info("builderRprice=\r\n" + builder1priceString.toString());
			//log.info("reportTitle=\r\n" + reportTitle.toString());
			//log.info("reportColumnOne=\r\n" + reportColumnOne.toString());
			//log.info("reportColumnTwo=\r\n" + reportColumnTwo.toString());
			//log.info("reportColumnThree=\r\n" + reportColumnThree.toString());
			//log.info("reportNormalWrap=\r\n" + reportNormalWrap.toString());
			String output = reportRowLabelBuilder.toString() + "+";
			StringBuilder b1 = new StringBuilder();
			List<String> list = new LinkedList<String>();
			for(int i=0; i<output.length();i++) {
				if(output.charAt(i) != '+') {
					b1.append(output.charAt(i));
				} else {
					list.add(b1.toString());
					b1 = new StringBuilder();
				}
			}
			//String[] strings = StringUtils.split("+", output);
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).contains("javascript")) {
					int j = list.get(i).indexOf("(");
					String s = list.get(i).substring(0, j);
					list.set(i, s);
				} else if(list.get(i).contains("j.us")) {
					int j = list.get(i).indexOf("j.us");
					String s =list.get(i).substring(0, j);
					list.set(i, s);
				} else if(list.get(i).contains("us=")) {
					int j = list.get(i).indexOf("us=");
					String s = list.get(i).substring(0, j);
					list.set(i, s);
				} else if(list.get(i).contains("style=")) {
					int j = list.get(i).indexOf("style=");
					String s =list.get(i).substring(0, j);
					list.set(i, s);
				} else if(list.get(i).contains("mobile-")) {
					int j = list.get(i).indexOf("mobile-");
					String s =list.get(i).substring(0, j);
					list.set(i, s);
				} else if(list.get(i).contains("clear l")) {
					int j = list.get(i).indexOf("clear l");
					String s =list.get(i).substring(0, j);
					list.set(i, s);
				} else if(list.get(i).contains("sid=")) {
					int j = list.get(i).indexOf("sid=");
					String s =list.get(i).substring(0, j);
					list.set(i, s);
				} else if(list.get(i).contains("=")) {
					int j = list.get(i).indexOf("=");
					String s =list.get(i).substring(0, j);
					list.set(i, s);
				}
			}
			StringBuilder builder = new StringBuilder();
			for(int i=0;i<list.size();i++) {
				if(i==1) {
					myOutput[0]=list.get(i);
				}
				builder.append(list.get(i) + "<br>");
			}
			log.info("reportRowLabelBuilder=\r\n" + builder.toString());
			log.info("");
			myOutput[1] = builder.toString();
			return list;
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return list1;
	}
		
	private String formatString(String input) {
		input = input.replace("src=./1_ï¿½", "");
		input = input.replace("*", "");
		input = input.replace("\r", "");
		input = input.replace("\n", "");
		input = input.replace("l town", "");
		input = input.replace("l address", "");
		input = input.replace("r price", "");
		input = input.replace("<\"\">", "_");
		input = input.replace("<\" \"> ", "_");
		input = input.replace("<\" normalWrap\">", "");
		input = input.replace("<label>", "+");
		input = input.replace("</label>", "");
		input = input.replace("report-row-label", "");
		input = input.replace("</label>", "");
		input = input.replace("&nbsp;", " ");
		input = input.replace("<div ", "");
		input = input.replace("/div>", "");
		input = input.replace("class=", "");
		input = input.replace("<\"\"> ", "");
		input = input.replace("<\"\">", "");
		input = input.replace("normalWrap", "");
		input = input.replace("noWrap", "");
		input = input.replace("\"", "");
		input = input.replace(">", "");
		input = input.replace("<", "");
		input = input.replace("a href=", "");
		return input;
	}
	
	//Upload Files - HTML NjTaxRecords
	public List<String> parseHtml_njtax(Path path) throws IOException {
		String[] myOutput = new String[] {"",""};
		List<String> list = new LinkedList<String>();
		try {
			File input = path.toFile();
			StringBuilder colBuilder = new StringBuilder();
			StringBuilder strongBuilder = new StringBuilder();
			Document htmlDocument = Jsoup.parse(input, "UTF-8", "http://www.njtaxrecords.com/");
			Element content = htmlDocument.getElementById("ContentPlaceHolder1_PropertyDetails");
			Elements cols = content.getElementsByTag("td");
			Elements strongs = content.getElementsByTag("strong");
			//List<String> list = new LinkedList<String>();
			for (Element col : cols) {
			 // String colAttr = link.attr("href");
			  String colText = col.text();
			  //colBuilder.append(colText + "+");
			  list.add(col.text());
			}
			//for (Element strong : strongs) {
			 // String strongAttr = link.attr("href");
			  //String strongText = strong.text();
			 // strongBuilder.append(strongText + "+");
			//}
			//log.info("colBuilder=" + colBuilder.toString());
			//log.info("strongBuilder=" + strongBuilder.toString());
			StringBuilder b1 = new StringBuilder();
			int i=0;
			for(String string : list) {
				if(i==0) {
					
				} else {
					if(i==1) {
						myOutput[0]=string; 
					}
					b1.append(string + "<br>");
				}
				i++;
			}
			log.info("b1=\r\n" + b1.toString());
			log.info("");
			myOutput[1] = b1.toString();
			return  list;
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return list;
	}
	
	//File Upload impl
	@Override
	public void saveFileUpload(TreeMap<String, HRefModel> hrefModelMap, String uuid) {
		try {
			quickEntryDao.saveFileUpload(hrefModelMap, uuid);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	//File Upload impl
	@Override
	public List<HRefModel> findFileUpload(String uuid) {
		List<HRefModel> hrefModelList = null;
		try {
			hrefModelList = quickEntryDao.findFileUpload(uuid);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return hrefModelList;
	}
	
	//NJR118
	
	@Override
	public void createQuickEntry(Njr118DO njr118DO) {
		try {
			QuickEntryDO quickEntryDO = DataObjectTransformer.transformFromNjr118DO(njr118DO);
			quickEntryDao.createQuickEntry(quickEntryDO);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public List<QuickEntryDO> findQuickEntryList_Njr118DO(List<Njr118DO> njr118DOList) {
		if(njr118DOList.size() > 0) {
			//List<QuickEntryDO> quickEntryDOList = DataObjectTransformer.transformFromNjrlpdDO(njrlpdDOList, "Sysadmin");
		}
		return null;
	}
	
	@Override
	public List<Njr118DO> findList_Njr118DO() {
		List<Njr118DO> njr118DOList = null;
		List<QuickEntryDO> quickEntryDOList = quickEntryDao.findQuickEntryByFileTypeID("NJR118");
		if(quickEntryDOList.size() > 0) {
			njr118DOList = DataObjectTransformer.transformToNjr118DO(quickEntryDOList);
		} else {
			njr118DOList = new ArrayList<Njr118DO>();
			Njr118DO njr118DO = new Njr118DO(); 
			njr118DO.setQuickEntryID("0");
			njr118DO.setUuid("Sysadmin");
			njr118DOList.add(njr118DO);
		}
		return njr118DOList;
	}
	
	@Override
	public void saveQuickEntryByQuickEntryID(Njr118DO njr118DO, String quickEntryID) {
		try {
			QuickEntryDO quickEntryDO = DataObjectTransformer.transformFromNjr118DO(njr118DO);
			quickEntryDao.saveQuickEntryByFileTypeID(quickEntryDO, quickEntryID);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	//NJRLPD
	
	@Override
	public void createQuickEntry(NjrlpdDO njrlpdDO) {
		try {
			QuickEntryDO quickEntryDO = DataObjectTransformer.transformFromNjrlpdDO(njrlpdDO);
			quickEntryDao.createQuickEntry(quickEntryDO);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public List<QuickEntryDO> findQuickEntryList_NjrlpdDO(List<NjrlpdDO> njrlpdDOList) {
		if(njrlpdDOList.size() > 0) {
			//List<QuickEntryDO> quickEntryDOList = DataObjectTransformer.transformFromNjrlpdDO(njrlpdDOList, "Sysadmin");
		}
		return null;
	}
	
	@Override
	public List<NjrlpdDO> findList_NjrlpdDO() {
		List<NjrlpdDO> njrlpdDOList = null;
		List<QuickEntryDO> quickEntryDOList = quickEntryDao.findQuickEntryByFileTypeID("NJRLPD");
		if(quickEntryDOList.size() > 0) {
			njrlpdDOList = DataObjectTransformer.transformToNjrlpdDO(quickEntryDOList);
		} else {
			njrlpdDOList = new ArrayList<NjrlpdDO>();
			NjrlpdDO njrlpdDO = new NjrlpdDO(); 
			njrlpdDO.setQuickEntryID("0");
			njrlpdDO.setUuid("Sysadmin");
			njrlpdDOList.add(njrlpdDO);
		}
		return njrlpdDOList;
	}
	
	@Override
	public void saveQuickEntryByQuickEntryID(NjrlpdDO njrlpdDO, String quickEntryID) {
		try {
			QuickEntryDO quickEntryDO = DataObjectTransformer.transformFromNjrlpdDO(njrlpdDO);
			quickEntryDao.saveQuickEntryByFileTypeID(quickEntryDO, quickEntryID);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	public String createPdfByQuickEntryID(String quickEntryID) {
		String pdfFile = "";
		try {
			QuickEntryDO quickEntryDO = quickEntryDao.findQuickEntryByQuickEntryID(quickEntryID);
			if(quickEntryDO.getFileTypeID().equals("NJR118")) {
				//Njr118DO njr118DO = DataObjectTransformer.transformToNjr118DO(quickEntryDO);
				HashMap<String, String> elements = DataObjectTransformer.extractQuickEntryElements(quickEntryDO);
				pdfFile = quickEntryToPdf.generateNjr118DO(elements);
			} else {
				NjrlpdDO njrlpdDO = DataObjectTransformer.transformToNjrlpdDO(quickEntryDO);
				pdfFile = quickEntryToPdf.generate(njrlpdDO);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return pdfFile;
	}
	
	@Override
	public void	deleteQuickEntryByQuickEntryID(String quickEntryID) {
		try {
			quickEntryDao.deleteQuickEntryByQuickEntryID(quickEntryID);
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	



}
