package com.ci2.sgth.people.application.service;

import java.util.Set;

import com.ci2.sgth.people.domain.dto.CategoryCompetenceDto;

public interface CategoryCompetenceService {

	CategoryCompetenceDto addCategoryCompetence(CategoryCompetenceDto dto);
	void deleteCategoryCompetence(Long idCategory, Long idCompetence);
	CategoryCompetenceDto getCategoryCompetence(Long idCategory, Long idCompetence);
	Set<CategoryCompetenceDto> getAllCategoryCompetence();
	
}
