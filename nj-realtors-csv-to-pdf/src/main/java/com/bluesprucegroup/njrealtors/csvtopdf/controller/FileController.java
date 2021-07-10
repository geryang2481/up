package com.bluesprucegroup.njrealtors.csvtopdf.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.Constants;
import com.bluesprucegroup.njrealtors.csvtopdf.constant.HRefModel;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.Njr118DO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.NjrlpdDO;
import com.bluesprucegroup.njrealtors.csvtopdf.elements.ElementsCommon;
import com.bluesprucegroup.njrealtors.csvtopdf.generate.CsvToPdf;
import com.bluesprucegroup.njrealtors.csvtopdf.generate.HtmlToPdf;
import com.bluesprucegroup.njrealtors.csvtopdf.generate.TsvToPdf;
import com.bluesprucegroup.njrealtors.csvtopdf.generate.XlsToPdf;
import com.bluesprucegroup.njrealtors.csvtopdf.service.FileService;
import com.bluesprucegroup.njrealtors.csvtopdf.service.FileSystemStorageService;



@Controller
public class FileController {
	private static final Logger log = LogManager.getLogger(FileController.class);
	
	private String fileText;
	
	@Value("${com.bluesprucegroup.solution.source.user.token}")
	private String userToken;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private CsvToPdf csvToPdf;
	
	@Autowired
	private TsvToPdf tsvToPdf;
	
	@Autowired
	private XlsToPdf xlsToPdf;
	
	@Autowired
	private HtmlToPdf htmlToPdf;
	
	@Autowired
	private FileSystemStorageService storageService;

	private Map<String, HRefModel> hrefModelMap; 
	
	private HRefModel hrefModel;
	
	//User Front
	@RequestMapping("/userFront")
	public String loadUserFront(Principal principal, Model model) {
		if(this.hrefModelMap == null) {
			this.hrefModelMap = new HashMap<String, HRefModel>();
		}
        return "userFront";
    }
	
	//CSV to PDF FileUpload
	@RequestMapping(value = "/files/pdfList", method = RequestMethod.GET)
	public String listFilesUserFrontDownload(Model model) {
		List<HRefModel> urisNjr118 = new ArrayList<>();
		List<HRefModel> urisNjrlpd = new ArrayList<>();
		
		//Gson gson = new Gson();
		if(this.hrefModel != null && !StringUtils.isEmpty(this.hrefModel.getUuid())) {
			System.out.println("listFilesUserFrontDownload.My new UUID=" + this.hrefModel.getUuid());
			try {
				List<HRefModel> hrefList = this.fileService.findFileUpload(this.hrefModel.getUuid());
				for(int i=0; i < hrefList.size(); i++) {
					HRefModel href =hrefList.get(i);
					if(href.getFileTypeID().equals("NJR118")) {
						href.setColor(HRefModel.COLOR_PINK);
						urisNjr118.add(href);
					} else {
						href.setColor(HRefModel.COLOR_BROWN);
						urisNjrlpd.add(href);
					}
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		model.addAttribute("urisNjr118", urisNjr118);
		model.addAttribute("urisNjrlpd", urisNjrlpd);
		return "filePdfList :: urlPdfFileList";
		//return "urlFileList";
	}
	
	//Serve File
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsPdfResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	//  FileUpload - HTML - gsmls
	@RequestMapping(value = "/upload/gsmls", method = RequestMethod.GET)
	public String uploadHtml_gsmls() {
		if(this.hrefModelMap == null) {
			this.hrefModelMap = new HashMap<String, HRefModel>();
		}
		return "qu-gsmls";
	}
	
	//  FileUpload - HTML - njtax
	@RequestMapping(value = "/upload/njtax", method = RequestMethod.GET)
	public String uploadHtml_njtax() {
		if(this.hrefModelMap == null) {
			this.hrefModelMap = new HashMap<String, HRefModel>();
		}
		return "qu-njtax";
	}
	
	//  FileUpload - HTML - profilereport
	@RequestMapping(value = "/upload/profilereport", method = RequestMethod.GET)
	public String uploadHtml_profilereport() {
		return "qu-profilereport";
	}
	
	//  FileUpload - tsv
	@RequestMapping(value = "/upload/tsv", method = RequestMethod.GET)
	public String uploadHtm_tsv() {
		return "qu-tsv";
	}
	
	//  FileUpload - xls
	@RequestMapping(value = "/upload/xls", method = RequestMethod.GET)
	public String uploadHtml_tsv() {
		return "qu-xls";
	}
	
	//  Append PDFs
	@RequestMapping(value = "/append/pdf", method = RequestMethod.GET)
	public String appendNjTaxGsmls() {
		return "append_njtax_gsmls";
	}
	
	@RequestMapping(value = "/files/html/gsmls", method = RequestMethod.POST)
	public ResponseEntity<Resource> handleFileUpload_html_gsmls(@RequestParam("file") MultipartFile file, @ModelAttribute("HRefModel") HRefModel hrefModel, RedirectAttributes redirectAttributes, Model model) {
		Path path = storageService.store(file);
		try {
			List<String> output = this.fileService.parseHtml_gsmls(path);
			HRefModel hrefModel1 = this.htmlToPdf.generateFile("gsmls", output);
			String uuid = UUID.randomUUID().toString();
			System.out.println("handleFileUpload.My new UUID=" + uuid);
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
			Path filePath = Paths.get(Constants.OUTPUT_CONTRACT_OF_SALE_LOCATION).resolve(hrefModel1.getPath());
			Resource resource = new UrlResource(filePath.toUri());
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
					.body(resource);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/files/html/njtax", method = RequestMethod.POST)
	public ResponseEntity<Resource> handleFileUpload_html_njtax(@RequestParam("file") MultipartFile file, @ModelAttribute("HRefModel") HRefModel hrefModel, RedirectAttributes redirectAttributes, Model model) {
		Path path = storageService.store(file);
		try {
			List<String> list = this.fileService.parseHtml_njtax(path);
			HRefModel hrefModel1 = this.htmlToPdf.generateFile("njtax", list);
			String uuid = UUID.randomUUID().toString();
			System.out.println("handleFileUpload.My new UUID=" + uuid);
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
			Path filePath = Paths.get(Constants.OUTPUT_CONTRACT_OF_SALE_LOCATION).resolve(hrefModel1.getPath());
			Resource resource = new UrlResource(filePath.toUri());
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
					.body(resource);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/files/html/profilereport", method = RequestMethod.POST)
	public String handleFileUpload_html_profilereport(@RequestParam("file") MultipartFile file, @ModelAttribute("HRefModel") HRefModel hrefModel, RedirectAttributes redirectAttributes, Model model) {
		try {
			Path filePath = storageService.store(file);
			TreeMap<String, HRefModel> hrefModelMap = this.csvToPdf.generateFile(filePath);
			String uuid = UUID.randomUUID().toString();
			this.fileService.saveFileUpload(hrefModelMap, uuid);
			this.hrefModel = new HRefModel();
			this.hrefModel.setUuid(uuid);
			this.hrefModelMap.put(uuid, this.hrefModel);
			System.out.println("handleFileUpload.My new UUID=" + uuid);
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:/qu-profilereport";
	}
	
	@RequestMapping(value = "/files/tsv", method = RequestMethod.POST)
	public String handleFileUpload_tsv(@RequestParam("file") MultipartFile file, @ModelAttribute("HRefModel") HRefModel hrefModel, RedirectAttributes redirectAttributes, Model model) {
		
		try {
			Path filePath = storageService.store(file);
			TreeMap<String, HRefModel> hrefModelMap = this.csvToPdf.generateFile(filePath);
			String uuid = UUID.randomUUID().toString();
			this.fileService.saveFileUpload(hrefModelMap, uuid);
			this.hrefModel = new HRefModel();
			this.hrefModel.setUuid(uuid);
			this.hrefModelMap.put(uuid, this.hrefModel);
			System.out.println("handleFileUpload.My new UUID=" + uuid);
			//model.addAttribute("HRefModel", hrefModel);
			//redirectAttributes.addFlashAttribute("HRefModel", hrefModel);
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:/qu-tsv";
	}
	
	@RequestMapping(value = "/files/xls", method = RequestMethod.POST)
	public String handleFileUpload_xls(@RequestParam("file") MultipartFile file, @ModelAttribute("HRefModel") HRefModel hrefModel, RedirectAttributes redirectAttributes, Model model) {
		
		try {
			Path filePath = storageService.store(file);
			TreeMap<String, HRefModel> hrefModelMap = this.csvToPdf.generateFile(filePath);
			String uuid = UUID.randomUUID().toString();
			this.fileService.saveFileUpload(hrefModelMap, uuid);
			this.hrefModel = new HRefModel();
			this.hrefModel.setUuid(uuid);
			this.hrefModelMap.put(uuid, this.hrefModel);
			System.out.println("handleFileUpload.My new UUID=" + uuid);
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:/qu-xls";
	}
	
	
	//  FileUpload - CSV
	@RequestMapping(value = "/files/upload/csv", method = RequestMethod.POST)
	public String handleFileUpload_csv(@RequestParam("file") MultipartFile file, @ModelAttribute("HRefModel") HRefModel hrefModel, RedirectAttributes redirectAttributes, Model model) {
		try {
			Path filePath = storageService.store(file);
			TreeMap<String, HRefModel> hrefModelMap = this.csvToPdf.generateFile(filePath);
			String uuid = UUID.randomUUID().toString();
			this.fileService.saveFileUpload(hrefModelMap, uuid);
			this.hrefModel = new HRefModel();
			this.hrefModel.setUuid(uuid);
			this.hrefModelMap.put(uuid, this.hrefModel);
			System.out.println("handleFileUpload.My new UUID=" + uuid);
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return "redirect:/userFront";
	}
	
	//Load QuickEntry - Contract of Sale
	
	@RequestMapping(value = "/load/quickentry/njr118", method = RequestMethod.GET)
	public String loadQuickEntryNjr118(@RequestParam String quickEntryID, Model model) {
		if(quickEntryID.equals("0")) {
			List<Njr118DO> list = this.fileService.findList_Njr118DO();
			Njr118DO njr118DO = new Njr118DO();
			njr118DO.setUuid("Sysadmin");
			njr118DO.setQuickEntryName("");
			njr118DO.setQuickEntryDescription("");
			njr118DO.setQuickEntryID("0");
			//Page 1
			njr118DO.setForm_seller_initials(ElementsCommon.BOSCARINO);
			njr118DO.setP1_seller_name01(ElementsCommon.BOSCARINO);
			njr118DO.setP12_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 2
			njr118DO.setP2_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 3
			njr118DO.setP3_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 4
			njr118DO.setP4_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 5
			njr118DO.setP5_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 6
			njr118DO.setP6_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 7
			njr118DO.setP7_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 8
			njr118DO.setP8_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 9
			njr118DO.setP9_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 10
			njr118DO.setP10_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 11
			njr118DO.setP11_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 12
			njr118DO.setP12_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 13
			njr118DO.setP13l653_disclosure_agent_name(ElementsCommon.BOSCARINO);
			njr118DO.setP13_sellers_initials(ElementsCommon.BOSCARINO);
			//Page 14
			njr118DO.setP14l748_seller1(ElementsCommon.BOSCARINO);
			njr118DO.setP14_sellers_initials(ElementsCommon.BOSCARINO);
			model.addAttribute("njr118DOList", list);
			model.addAttribute("njr118DO", njr118DO);
		} else {
			List<Njr118DO> njr118DOList = this.fileService.findList_Njr118DO();
			for(Njr118DO njr118DO : njr118DOList) {
				if(njr118DO.getQuickEntryID().equals(quickEntryID)) {
					model.addAttribute("njr118DOList", njr118DOList);
					model.addAttribute("njr118DO", njr118DO);
				}
			}
		}
		return "qe-njr118";
	}

	@RequestMapping(value = "/load/quickentry/njrlpd", method = RequestMethod.GET)
	public String loadQuickEntryNjrlpd(@RequestParam String quickEntryID, Model model) {
		if(quickEntryID.equals("0")) {
			List<NjrlpdDO> list = this.fileService.findList_NjrlpdDO();
			NjrlpdDO njrlpdDO = new NjrlpdDO();
			njrlpdDO.setP1l14_iii_a_initials(ElementsCommon.BOSCARINO);
			njrlpdDO.setP1l30_iii_c_initials(ElementsCommon.BOSCARINO);
			njrlpdDO.setP1l37_sellerName1(ElementsCommon.BOSCARINO);
			njrlpdDO.setP1l50_vi_a_initials(ElementsCommon.BOSCARINO);
			njrlpdDO.setP1l52_vi_b_initials(ElementsCommon.BOSCARINO);
			njrlpdDO.setP2l57_vi_c_initials(ElementsCommon.BOSCARINO);
			njrlpdDO.setP2l74_sellingByAgentName(ElementsCommon.BOSCARINO);
			njrlpdDO.setUuid("Sysadmin");
			njrlpdDO.setQuickEntryName("");
			njrlpdDO.setQuickEntryDescription("");
			njrlpdDO.setQuickEntryID("0");
			model.addAttribute("njrlpdDOList", list);
			model.addAttribute("njrlpdDO", njrlpdDO);
		} else {
			List<NjrlpdDO> list = this.fileService.findList_NjrlpdDO();
			for(NjrlpdDO njrlpdDO : list) {
				if(njrlpdDO.getQuickEntryID().equals(quickEntryID)) {
					model.addAttribute("njrlpdDOList", list);
					model.addAttribute("njrlpdDO", njrlpdDO);
				}
			}
		}
		return "qe-njrlpd";
	}
	
	//Create Contract of Sale PDF by quickEntryID
	@RequestMapping(value = "/create/pdf/njr118", method = RequestMethod.GET)
	public ResponseEntity<Resource> createNjr118PdfByQuickEntryID(@RequestParam String quickEntryID) throws MalformedURLException {
		String pdfFile = this.fileService.createPdfByQuickEntryID(quickEntryID);
		Path file = Paths.get(Constants.OUTPUT_CONTRACT_OF_SALE_LOCATION).resolve(pdfFile);
		Resource resource = new UrlResource(file.toUri());
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	//Create Lead Paint Disclosure PDF by quickEntryID
	@RequestMapping(value = "/create/pdf/njrlpd", method = RequestMethod.GET)
	public ResponseEntity<Resource> createNjrlpdPdfByQuickEntryID(@RequestParam String quickEntryID) throws MalformedURLException {
		String pdfFile = this.fileService.createPdfByQuickEntryID(quickEntryID);
		Path file = Paths.get(Constants.OUTPUT_LEAD_PAINT_DISCLOSURE_LOCATION).resolve(pdfFile);
		Resource resource = new UrlResource(file.toUri());
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	//Save new or edit QuickEntry
	
	@RequestMapping(value = "/save/quickentry/njr118", method = RequestMethod.POST)
	public String saveQuickEntryByQuickEntryID(@RequestParam String quickEntryID, @ModelAttribute("njr118DO") Njr118DO njr118DO,  Model model) {
		njr118DO = saveNjr118DORepeatedValuesToActualValues(njr118DO);
		if(quickEntryID.equals("0")) {
			this.fileService.createQuickEntry(njr118DO);
		} else {
			this.fileService.saveQuickEntryByQuickEntryID(njr118DO, quickEntryID);
		}
		return "redirect:/load/quickentry/njr118?quickEntryID=0";
	}
	
	private Njr118DO saveNjr118DORepeatedValuesToActualValues(Njr118DO njr118DO) {
		try {
			String form_buyer_initials = njr118DO.getForm_buyer_initials();
			String form_seller_initials = njr118DO.getForm_seller_initials();
			//njr118DO.setP1_seller_name01(form_seller_initials);
			//Page 2
			njr118DO.setP2_buyers_initials(form_buyer_initials);
			njr118DO.setP2_sellers_initials(form_seller_initials);
			//Page 3
			njr118DO.setP3_buyers_initials(form_buyer_initials);
			njr118DO.setP3_sellers_initials(form_seller_initials);
			//Page 4
			njr118DO.setP4_buyers_initials(form_buyer_initials);
			njr118DO.setP4_sellers_initials(form_seller_initials);
			//Page 5
			njr118DO.setP5_buyers_initials(form_buyer_initials);
			njr118DO.setP5_sellers_initials(form_seller_initials);
			//Page 6
			njr118DO.setP6_buyers_initials(form_buyer_initials);
			njr118DO.setP6_sellers_initials(form_seller_initials);
			//Page 7
			njr118DO.setP7_buyers_initials(form_buyer_initials);
			njr118DO.setP7_sellers_initials(form_seller_initials);
			//Page 8
			njr118DO.setP8_buyers_initials(form_buyer_initials);
			njr118DO.setP8_sellers_initials(form_seller_initials);
			//Page 9
			njr118DO.setP9_buyers_initials(form_buyer_initials);
			njr118DO.setP9_sellers_initials(form_seller_initials);
			//Page 10
			njr118DO.setP10_buyers_initials(form_buyer_initials);
			njr118DO.setP10_sellers_initials(form_seller_initials);
			//Page 11
			njr118DO.setP11_buyers_initials(form_buyer_initials);
			njr118DO.setP11_sellers_initials(form_seller_initials);
			//Page 12
			njr118DO.setP12_buyers_initials(form_buyer_initials);
			njr118DO.setP12_sellers_initials(form_seller_initials);
			//Page 13
			njr118DO.setP13_buyers_initials(form_buyer_initials);
			njr118DO.setP13_sellers_initials(form_seller_initials);
			//Page 14
			njr118DO.setP14_buyers_initials(form_buyer_initials);
			njr118DO.setP14_sellers_initials(form_seller_initials);
		}catch(Exception e) {
			log.error(e.getMessage(), e);
		}
		return njr118DO;
	}
	
	@RequestMapping(value = "/save/quickentry/njrlpd", method = RequestMethod.POST)
	public String saveQuickEntryByQuickEntryID(@RequestParam String quickEntryID, @ModelAttribute("njrlpdDO") NjrlpdDO njrlpdDO,  Model model) {
		if(quickEntryID.equals("0")) {
			this.fileService.createQuickEntry(njrlpdDO);
		} else {
			this.fileService.saveQuickEntryByQuickEntryID(njrlpdDO, quickEntryID);
		}
		return "redirect:/load/quickentry/njrlpd?quickEntryID=0";
	}
	
	
	//Download Blank PDFs
	
	@RequestMapping(value = "/download/pdf/nj118", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resource> downloadPdfNj118() throws MalformedURLException {
		Path file = Paths.get(Constants.SOURCE_CONTRACT_OF_SALE_LOCATION).resolve(Constants.SOURCE_CONTRACT_OF_SALE_FILENAME);
		Resource resource = new UrlResource(file.toUri());
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	@RequestMapping(value = "/download/pdf/njrlpd", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resource> downloadPdfNjrlpd() throws MalformedURLException {
		Path file = Paths.get(Constants.SOURCE_LEAD_PAINT_DISCLOSURE_LOCATION).resolve(Constants.SOURCE_LEAD_PAINT_DISCLOSURE_FILENAME);
		Resource resource = new UrlResource(file.toUri());
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	// Delete QuickEntry
	
	@RequestMapping(value = "/delete/quickentry", method = RequestMethod.GET)
	public String deleteQuickEntryByQuickEntryID(@RequestParam String quickEntryID) {
		this.fileService.deleteQuickEntryByQuickEntryID(quickEntryID);
		return "redirect:/load/quickentry/njrlpd?quickEntryID=0";
	}
	
	public String getFileText() {
		return fileText;
	}

	public void setFileText(String fileText) {
		this.fileText = fileText;
	}
	
	private static String getCurrentTimestamp() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}
	
	@ModelAttribute("HRefModel")
	public HRefModel populateHrefModel() {
		HRefModel hrefModel = new HRefModel();
		hrefModel.setUuid(UUID.randomUUID().toString());
		return hrefModel;
	}


	public HRefModel getHrefModel() {
		return hrefModel;
	}


	public void setHrefModel(HRefModel hrefModel) {
		this.hrefModel = hrefModel;
	}




	
}
