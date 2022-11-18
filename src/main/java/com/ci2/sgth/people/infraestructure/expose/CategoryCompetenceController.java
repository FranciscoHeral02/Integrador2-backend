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

import com.ci2.sgth.people.application.service.CategoryCompetenceService;
import com.ci2.sgth.people.domain.dto.CategoryCompetenceDto;

@RestController
@RequestMapping("/category-competence")
public class CategoryCompetenceController {
	
	@Autowired
	private CategoryCompetenceService categoryCompetenceService;
	
	@PostMapping
	public ResponseEntity<CategoryCompetenceDto> saveCategoryCompetenceInformation(@RequestBody CategoryCompetenceDto categoryCompetence){
		
		return new ResponseEntity<CategoryCompetenceDto>(categoryCompetenceService.addCategoryCompetence(categoryCompetence),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<CategoryCompetenceDto> updateCategoryCompetenceInformation(@RequestBody CategoryCompetenceDto categoryCompetence){
		
		return new ResponseEntity<CategoryCompetenceDto>(categoryCompetenceService.addCategoryCompetence(categoryCompetence),HttpStatus.OK);
	}
	
	@DeleteMapping("/{idCategory}/{idCompetence}")
	public ResponseEntity<String> deleteCategoryCompetenceInformation(@PathVariable Long idCategory,
			@PathVariable Long idCompetence){
		
		categoryCompetenceService.deleteCategoryCompetence(idCategory,idCompetence);
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Set<CategoryCompetenceDto>> getAllCategoryCompetencesInformation(){
		
		return new ResponseEntity<Set<CategoryCompetenceDto>>(categoryCompetenceService.getAllCategoryCompetence(),HttpStatus.OK);
	}
	
	@GetMapping("/{idCategory}/{idCompetence}")
	public ResponseEntity<CategoryCompetenceDto> getCategoryCompetenceInformation(@PathVariable Long idCategory,
			@PathVariable Long idCompetence){
		
		return new ResponseEntity<CategoryCompetenceDto>(categoryCompetenceService.getCategoryCompetence(idCategory,idCompetence),HttpStatus.OK);
	}
}
