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

import com.ci2.sgth.people.application.service.CategoryService;
import com.ci2.sgth.people.domain.dto.CategoryDto;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDto> saveCategoryInformation(@RequestBody CategoryDto category){
		
		return new ResponseEntity<CategoryDto>(categoryService.addCategory(category),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<CategoryDto> updateCategoryInformation(@RequestBody CategoryDto category){
		
		return new ResponseEntity<CategoryDto>(categoryService.addCategory(category),HttpStatus.OK);
	}
	
	@DeleteMapping("/{idCategory}")
	public ResponseEntity<String> deleteCategoryInformation(@PathVariable Long idCategory){
		
		categoryService.deleteCategory(idCategory);
		
		return new ResponseEntity<String>("OK",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Set<CategoryDto>> getAllCategorysInformation(){
		
		return new ResponseEntity<Set<CategoryDto>>(categoryService.getAllCategory(),HttpStatus.OK);
	}
	
	@GetMapping("/{idCategory}")
	public ResponseEntity<CategoryDto> getCategoryInformation(@PathVariable Long idCategory){
		
		return new ResponseEntity<CategoryDto>(categoryService.getCategory(idCategory),HttpStatus.OK);
	}
	
}
