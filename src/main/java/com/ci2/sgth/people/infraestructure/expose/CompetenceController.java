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

import com.ci2.sgth.people.application.service.CompetenceService;
import com.ci2.sgth.people.domain.dto.CompetenceDto;

@RestController
@RequestMapping("/competence")
public class CompetenceController {
	
	@Autowired
	private CompetenceService competenceService;
	
	@PostMapping
	public ResponseEntity<CompetenceDto> saveCompetenceInformation(@RequestBody CompetenceDto competence){
		
		return new ResponseEntity<CompetenceDto>(competenceService.addCompetence(competence),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<CompetenceDto> updateCompetenceInformation(@RequestBody CompetenceDto competence){
		
		return new ResponseEntity<CompetenceDto>(competenceService.addCompetence(competence),HttpStatus.OK);
	}
	
	@DeleteMapping("/{idCompetence}")
	public ResponseEntity<String> deleteCompetenceInformation(@PathVariable Long idCompetence){
		
		competenceService.deleteCompetence(idCompetence);
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Set<CompetenceDto>> getAllCompetencesInformation(){
		
		return new ResponseEntity<Set<CompetenceDto>>(competenceService.getAllCompetence(),HttpStatus.OK);
	}
	
	@GetMapping("/{idCompetence}")
	public ResponseEntity<CompetenceDto> getCompetenceInformation(@PathVariable Long idCompetence){
		
		return new ResponseEntity<CompetenceDto>(competenceService.getCompetence(idCompetence),HttpStatus.OK);
	}
}
