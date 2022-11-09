package com.ci2.sgth.people.infraestructure.expose;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci2.sgth.people.application.service.EmployeeService;
import com.ci2.sgth.people.domain.entity.Employee;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> saveApplicantInformation(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.saveApplicantFirstInformation(employee),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Employee> updateApplicantInformation(@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.saveApplicantFirstInformation(employee),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idApplicant}")
	public ResponseEntity<String> deleteApplicantInformation(@PathVariable Long idApplicant){
		
		employeeService.deleteEmployee(idApplicant);
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllApplicantsInformation(){
		
		return new ResponseEntity<List<Employee>>(employeeService.getAllApplicantsInformation(),HttpStatus.OK);
	}
	
	@GetMapping("/{idApplicant}")
	public ResponseEntity<Employee> getApplicantInformation(@PathVariable Long idApplicant){
		
		return new ResponseEntity<Employee>(employeeService.getApliccant(idApplicant),HttpStatus.OK);
	}
}
