package com.ci2.sgth.people.application.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci2.sgth.people.application.repository.CategoryCompetenceRepository;
import com.ci2.sgth.people.application.service.CategoryCompetenceService;
import com.ci2.sgth.people.domain.dto.CategoryCompetenceDto;
import com.ci2.sgth.people.domain.entity.CategoryCompetence;
import com.ci2.sgth.people.domain.entity.CategoryCompetenceId;

import static com.ci2.sgth.people.application.service.impl.mapper.CategoryCompetenceMapper.mapToDto;
import static com.ci2.sgth.people.application.service.impl.mapper.CategoryCompetenceMapper.mapToEntity;

@Service
public class CategoryCompetenceServiceImpl implements CategoryCompetenceService {
	
	@Autowired
	private CategoryCompetenceRepository categoryCompetenceRepository;
	
	@Override
	public CategoryCompetenceDto addCategoryCompetence(CategoryCompetenceDto dto) {
		
		return mapToDto(categoryCompetenceRepository.save(mapToEntity(dto)));
		
	}

	@Override
	public void deleteCategoryCompetence(Long idCategory,Long idCompetence) {
		
		categoryCompetenceRepository.deleteById(CategoryCompetenceId.builder()
											.categoryId(idCategory)
											.competenceId(idCompetence)
											.build());

	}

	@Override
	public CategoryCompetenceDto getCategoryCompetence(Long idCategory,Long idCompetence) {
		
		CategoryCompetence entity = categoryCompetenceRepository.findById(CategoryCompetenceId.builder()
				.categoryId(idCategory)
				.competenceId(idCompetence)
				.build()).orElseThrow(()-> new EntityNotFoundException("No se encontro la entidad"));
		
		return mapToDto(entity);
	}

	@Override
	public Set<CategoryCompetenceDto> getAllCategoryCompetence() {
	
		Set<CategoryCompetenceDto> dtoSet = categoryCompetenceRepository.findAll()
											.stream().map(e->mapToDto(e))
											.collect(Collectors.toSet());
		
		return dtoSet;
	}

}
