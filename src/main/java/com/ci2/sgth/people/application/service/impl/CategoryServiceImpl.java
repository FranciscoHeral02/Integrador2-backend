package com.ci2.sgth.people.application.service.impl;

import static com.ci2.sgth.people.application.service.impl.mapper.CategoryMapper.mapToDto;
import static com.ci2.sgth.people.application.service.impl.mapper.CategoryMapper.mapToEntity;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ci2.sgth.people.application.repository.CategoryRepository;
import com.ci2.sgth.people.application.service.CategoryService;
import com.ci2.sgth.people.domain.dto.CategoryDto;
import com.ci2.sgth.people.domain.entity.Category;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public CategoryDto addCategory(CategoryDto dto) {
		return mapToDto(categoryRepository.save(mapToEntity(dto)));
	}

	@Override
	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public CategoryDto getCategory(Long categoryId) {
		
		Category category= categoryRepository.findById(categoryId).orElseThrow(
				()-> new EntityNotFoundException("No se encuentra la entidad")
		);
		
		return mapToDto(category);
	}

	@Override
	public Set<CategoryDto> getAllCategory() {
		 Set<CategoryDto> categoryDtoSet = categoryRepository.findAll().stream()
					.map(e-> mapToDto(e)).collect(Collectors.toSet());

		 return categoryDtoSet;
	}

}
