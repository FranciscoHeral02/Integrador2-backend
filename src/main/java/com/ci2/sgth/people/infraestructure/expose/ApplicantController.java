package com.ci2.sgth.people.infraestructure.expose;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ci2.sgth.people.application.service.ApplicantService;
import com.ci2.sgth.people.domain.dto.ApplicantDto;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private ApplicantService employeeService;
	
	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
		     produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ApplicantDto> saveApplicantInformation(@RequestPart("data") ApplicantDto employee,
			@RequestPart(value="file",required=false) MultipartFile file){		
		return new ResponseEntity<ApplicantDto>(employeeService.saveApplicantFirstInformation(employee,
				file),HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
     produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ApplicantDto> updateApplicantInformation(@RequestPart("data") ApplicantDto employee,
			@RequestPart(value="file",required=false) MultipartFile file){
		
		return new ResponseEntity<ApplicantDto>(employeeService.saveApplicantFirstInformation(employee,
				file),HttpStatus.OK);
	}
	
	@DeleteMapping("/{idApplicant}")
	public ResponseEntity<String> deleteApplicantInformation(@PathVariable Long idApplicant){
		
		employeeService.deleteEmployee(idApplicant);
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ApplicantDto>> getAllApplicantsInformation(){
		
		return new ResponseEntity<List<ApplicantDto>>(employeeService.getAllApplicantsInformation(),HttpStatus.OK);
	}
	
	@GetMapping("/{idApplicant}")
	public ResponseEntity<ApplicantDto> getApplicantInformation(@PathVariable Long idApplicant){
		
		return new ResponseEntity<ApplicantDto>(employeeService.getApliccant(idApplicant),HttpStatus.OK);
	}
}
