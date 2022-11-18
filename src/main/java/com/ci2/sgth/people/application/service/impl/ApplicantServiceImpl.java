package com.ci2.sgth.people.application.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ci2.sgth.people.application.repository.EmployeeRepository;
import com.ci2.sgth.people.application.service.ApplicantService;
import com.ci2.sgth.people.application.service.FileStorageService;
import com.ci2.sgth.people.domain.dto.ApplicantDto;
import com.ci2.sgth.people.domain.entity.Employee;

import static com.ci2.sgth.people.application.service.impl.mapper.ApplicantMapper.mapToDto;
import static com.ci2.sgth.people.application.service.impl.mapper.ApplicantMapper.mapToEntity;

@Service
public class ApplicantServiceImpl implements ApplicantService{

	@Autowired
	private EmployeeRepository employeRepository;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	
	@Override
	public ApplicantDto saveApplicantFirstInformation(ApplicantDto employee,MultipartFile file) {
		
		Employee entity = mapToEntity(employee);
		
		if(null!=file) {
			String fileName = fileStorageService.storeFile(file);
			entity.setCvFileName(fileName);
		}
		
		return mapToDto(employeRepository.save(entity));
	}
	
	@Override
	public ApplicantDto updateApplicantFirstInformation(ApplicantDto employee,MultipartFile file) {
		
		
		Employee entity = mapToEntity(employee);
		
		String fileName = fileStorageService.storeFile(file);
		entity.setCvFileName(fileName);
		
		return mapToDto(employeRepository.save(entity));
	}
	
	@Override
	public List<ApplicantDto> getAllApplicantsInformation() {
		
		List<ApplicantDto> list = employeRepository.findAll().stream()
			.map(emp -> mapToDto(emp)).toList();
		
		return list;
	}
	
	@Override
	public ApplicantDto getApliccant(Long idEmployee) {
		
		Employee entity = employeRepository.findById(idEmployee).orElseThrow(
					()->new EntityNotFoundException("Empleado no encontrado")
				);
		
		
		ApplicantDto applicantDto = mapToDto(entity);
		
		String fileBase64 = fileStorageService.getFileAsBase64(entity.getCvFileName());
		
		applicantDto.setBase64pdf(fileBase64);
		
		return applicantDto;
	}
	
	@Override
	public void deleteEmployee(Long idEmployee) {
		
		 employeRepository.deleteById(idEmployee);
	}

}
