package com.ci2.sgth.people.infraestructure.expose;

import java.util.Set;

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

import com.ci2.sgth.people.application.service.JobService;
import com.ci2.sgth.people.domain.dto.JobDto;

@RestController
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@PostMapping
	public ResponseEntity<JobDto> saveJobInformation(@RequestBody JobDto job){
		
		return new ResponseEntity<JobDto>(jobService.addJob(job),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<JobDto> updateJobInformation(@RequestBody JobDto job){
		
		return new ResponseEntity<JobDto>(jobService.addJob(job),HttpStatus.OK);
	}
	
	@DeleteMapping("/{idJob}")
	public ResponseEntity<String> deleteJobInformation(@PathVariable Long idJob){
		
		jobService.deleteJob(idJob);
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Set<JobDto>> getAllJobsInformation(){
		
		return new ResponseEntity<Set<JobDto>>(jobService.getAllJob(),HttpStatus.OK);
	}
	
	@GetMapping("/{idJob}")
	public ResponseEntity<JobDto> getJobInformation(@PathVariable Long idJob){
		
		return new ResponseEntity<JobDto>(jobService.getJob(idJob),HttpStatus.OK);
	}
}
