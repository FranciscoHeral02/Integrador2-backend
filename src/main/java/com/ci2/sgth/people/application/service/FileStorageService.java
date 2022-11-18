package com.ci2.sgth.people.application.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	
	public static final String storeFormat="pdf";
	
	String storeFile(MultipartFile file);
	
	String getFileAsBase64(String fileName);
}
