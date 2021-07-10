package com.bluesprucegroup.njrealtors.csvtopdf.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bluesprucegroup.njrealtors.csvtopdf.constant.Constants;

@Service
public class FileSystemStorageService {
	private static final Logger log = LogManager.getLogger(FileSystemStorageService.class);
	private Path inboundLocation;
	private Path contractOfSaleLocation;
	private Path leadPaintDisclosureLocation;
	
	@PostConstruct
	public void init() {
		this.inboundLocation = Paths.get(Constants.INBOUND_LOCATION);
		this.contractOfSaleLocation = Paths.get(Constants.OUTPUT_CONTRACT_OF_SALE_LOCATION);
		this.leadPaintDisclosureLocation = Paths.get(Constants.OUTPUT_LEAD_PAINT_DISCLOSURE_LOCATION);
		try {
			Files.createDirectories(inboundLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage", e);
		}
	}
	
	public Path store(MultipartFile file) {
		Path filePath = null;
		String filename = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (file.isEmpty()) {
				throw new RuntimeException("Failed to store empty file " + filename);
			}
			
			// This is a security check
			if (filename.contains("..")) {
				throw new RuntimeException("Cannot store file with relative path outside current directory " + filename);
			}
			
			try (InputStream inputStream = file.getInputStream()) {
				filePath = this.inboundLocation.resolve(filename);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to store file " + filename, e);
		}
		return filePath;
	}

	public Resource loadAsResource(String filename) {
		try {
			Path file = inboundLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read file: " + filename);
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Could not read file: " + filename, e);
		}
	}

	public Resource loadAsPdfResource(String filename) {
		try {
			Path file = filename.toUpperCase().contains("CONTRACT_OF_SALE") ? contractOfSaleLocation.resolve(filename) : leadPaintDisclosureLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read file: " + filename);
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Could not read file: " + filename, e);
		}
	}
	
	public List<Path> listSourceFiles(Path dir) throws IOException {
		List<Path> result = new ArrayList<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{csv}")) {
			for (Path entry : stream) {
				result.add(entry);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public List<Path> listContractSalesSourceFiles(Path dir) throws IOException {
		List<Path> result = new ArrayList<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{pdf}")) {
			for (Path entry : stream) {
				result.add(entry);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public List<Path> listLeadPaintSourceFiles(Path dir) throws IOException {
		List<Path> result = new ArrayList<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{pdf}")) {
			for (Path entry : stream) {
				result.add(entry);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public Path getInboundLocation() {
		return inboundLocation;
	}
	
	public Path getContractOfSaleLocation() {
		return contractOfSaleLocation;
	}
	
	public Path getLeadPaintDisclosureLocation() {
		return leadPaintDisclosureLocation;
	}
}
