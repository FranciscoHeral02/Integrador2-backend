package com.ci2.sgth.people.application.service;

import java.util.Set;

import com.ci2.sgth.people.domain.dto.CategoryDto;


public interface CategoryService {
	CategoryDto addCategory(CategoryDto dto);
	void deleteCategory(Long categoryId);
	CategoryDto getCategory(Long categoryId);
	Set<CategoryDto> getAllCategory();
}
