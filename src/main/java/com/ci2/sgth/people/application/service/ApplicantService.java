package com.ci2.sgth.people.application.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ci2.sgth.people.domain.dto.ApplicantDto;

public interface ApplicantService {
	ApplicantDto saveApplicantFirstInformation(ApplicantDto employee,MultipartFile file);
	ApplicantDto getApliccant(Long idEmployee);
	void deleteEmployee(Long idEmployee);
	List<ApplicantDto> getAllApplicantsInformation();
	ApplicantDto updateApplicantFirstInformation(ApplicantDto employee,MultipartFile file);
}
