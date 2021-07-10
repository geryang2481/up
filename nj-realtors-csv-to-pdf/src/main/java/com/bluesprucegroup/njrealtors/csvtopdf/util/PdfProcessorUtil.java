package com.bluesprucegroup.njrealtors.csvtopdf.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.stereotype.Component;

import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;

@Component
public class PdfProcessorUtil {
	private static final Logger log = LogManager.getLogger(PdfProcessorUtil.class);
	
	public static PDDocument bytesToPdfDocument(ServiceAccountDataDO serviceAccountDataDO, PDDocument pdDocument) 
			throws InvalidPasswordException, IOException, Exception {
		if(serviceAccountDataDO.getFileName().contains("PA55")) {
			String password = findValue(serviceAccountDataDO.getFileName());
			log.info("PdfPassword=" + password);
			serviceAccountDataDO.setPdfPassword(findValue(serviceAccountDataDO.getFileName()));
		}
		//log.info(FilterElementsUtil.reverseString("0" + serviceAccountDataDO.getPdfPassword()) + "O");

		if(serviceAccountDataDO.getPdfPassword().length() > 1) {
			log.info("Using password to decrypt PDF. GUID=" + serviceAccountDataDO.getGuid()
			+ ", fileName=" + serviceAccountDataDO.getFileName());
			pdDocument = PDDocument.load(serviceAccountDataDO.getByteArray(), serviceAccountDataDO.getPdfPassword());
		} else {
			log.info("Decypting PDF without password. GUID=" + serviceAccountDataDO.getGuid()
			+ ", fileName=" + serviceAccountDataDO.getFileName());
			pdDocument = PDDocument.load(serviceAccountDataDO.getByteArray());
			if(pdDocument == null) {
				throw new Exception("Please provide password."); 
			}
		}
		return pdDocument;
	}
	
	public static PDDocument bytesToPdfDocument(PDDocument pdDocument, String pdfFile) 
			throws InvalidPasswordException, IOException, Exception {
		
		log.info("Decypting PDF without password");
		pdDocument = PDDocument.load(readPDFFromFile(pdfFile));
		if(pdDocument == null) {
			throw new Exception("Please provide password."); 
		}
		return pdDocument;
	}
	
	public static byte[] readPDFFromFile(String pdfFile) {
		ReadFileServiceTool extractorServiceTool = new ReadFileServiceTool();
		byte[] array = extractorServiceTool.readFile(pdfFile);
		return array;
	}


	public static String getLeadingZeroesString(int i) {
		if(i > 0 && i < 1000000) {
			i = 100000 + i;
		} else {
			log.info("Unable to convert integer with leading zeroes.");
			return "";
		}
		String leadingZeroes = String.valueOf(i);
		leadingZeroes = leadingZeroes.substring(1);
		
		return leadingZeroes;
	}
	
	public static String removeLastChar(String input) {
		input = input.substring(0, input.length() - 1);
	    return input;
	}
	
	public static String replaceAndFormat(String input) {
		input = input.replaceAll("\"", "");
		input =  input.replace("â€”", "-");
		input =  input.replace("â€“", "-");
		input =  input.replace("â€™", "-");
		input =  input.replace("â€¢", "-");
		input =  input.replace("â€™", "-");
		input = input.replace("*", "X");
		input = input.replace("  ", " ");
		input = input.replace(" |", "|");
		input = input.replace("|.|", "|");
		input = input.replace("|.|", "|");
		return input;
	}
	
	private static String findValue(String fileName) {
		Map<String, String> valueMap = new HashMap<String, String>();
		//1040
		valueMap.put("2016_1040_002_BRADEN_SCHE2_4403_PA55.pdf", "4403");
		valueMap.put("2016_1040_009_HILEMAN_SCHE_SCHF_46970_PA55.pdf", "46970");
		valueMap.put("2016_1040_016_PRESNALL_SCHE_SCHF_46928_PA55.pdf", "46928");
		valueMap.put("2018_1040_002_GIANNONATTI_SCHF_504946925_PA55.pdf", "504946925");
		valueMap.put("2018_1040_010_PITTS_SCHE_SCHF_517061038_PA55.pdf", "517061038");
		//1065
		valueMap.put("2016_1065_004A_PRESNALL_EQUIPMENT_46928_PA55.pdf","46928");
		valueMap.put("2016_1065_004B_PRESNALL_FAMILY_FARM_8825_46928_PA55.pdf","46928");
		valueMap.put("2016_1065_004C_PRESNALL_FARMS_SCHF_46928_PA55.pdf","46928");
		valueMap.put("2018_1065_014_SPOTTED_MULE_8825_SCHF_460459333_PA55.pdf","460459333");
		//1120
		valueMap.put("2014_1120_002_MUSSELMAN_BROS_8495_PA55.pdf", "8495");
		valueMap.put("2016_1120_001_BMP_FARMS_46928_PA55.pdf","46928");
		valueMap.put("2016_1120_002_UPDIKE_FARMS_3926_PA55.pdf","3926");
		//1120S
		valueMap.put("2016_1120S_001_ALP_FARMS_46928_PA55.pdf", "46928");
		valueMap.put("2016_1120S_004_EAST_BRANCH_FARMS_SCHF_46928_PA55.pdf", "46928");
		valueMap.put("2016_1120S_009_SJ_BRADEN_FARMS_8825_4403_PA55.pdf", "4403");
		valueMap.put("2017_1120S_003_DAKOTA_CABLE_SOLUTIONS_274528403_PA55.pdf","274528403");
		valueMap.put("2017_1120S_005_IRON_OUTFITTER_461752642_PA55.pdf", "461752642");
		valueMap.put("2018_1120S_002_DAKOTA_CABLE_SOLUTIONS_274528403_PA55.pdf","274528403");
		valueMap.put("2018_1120S_010_WOOD_VET_SERVICES_472914186_PA55.pdf","472914186");
		return valueMap.get(fileName);
	}

}