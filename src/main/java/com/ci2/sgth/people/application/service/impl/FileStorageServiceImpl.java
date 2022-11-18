package com.ci2.sgth.people.application.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import com.ci2.sgth.people.application.service.FileStorageService;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileStorageServiceImpl implements FileStorageService {

	private final Path fileStorageLocation;

	@Autowired
	public FileStorageServiceImpl(Environment env) {
		this.fileStorageLocation = Paths.get(env.getProperty("app.file.upload-dir", "./uploads/files")).toAbsolutePath()
				.normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
		}
	}

	private String getFileExtension(String fileName) {
		if (fileName == null) {
			return null;
		}
		String[] fileNameParts = fileName.split("\\.");

		return fileNameParts[fileNameParts.length - 1];
	}

	@Override
	public String storeFile(MultipartFile file) {
		
		String fileExtension = getFileExtension(file.getOriginalFilename());
		
		log.info("extension de archivo"+fileExtension);
		
		
		String fileName = new Date().getTime() + "-file." + storeFormat;
		Path targetLocation = this.fileStorageLocation.resolve(fileName);
		
		try {

			if (fileName.contains("..")) {
				throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			
			System.out.println(fileExtension);
			
			if(fileExtension.equals("docx")) {
			
				Document doc = new Document(file.getInputStream());
				doc.saveToFile(targetLocation.toString(),FileFormat.PDF);
			
				return fileName;
			}else {

				Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

				return fileName;
				
			}

		} catch (IOException ex) {
			throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
		}
		
	}

	@Override
	public String getFileAsBase64(String fileName) {
		
		String base64 = "";
		
		Path targetLocation = this.fileStorageLocation.resolve(fileName);
		
		try {
			base64 = Base64Utils.encodeToString(Files.readAllBytes(targetLocation)); 
			 
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		
		return base64;
	}
}