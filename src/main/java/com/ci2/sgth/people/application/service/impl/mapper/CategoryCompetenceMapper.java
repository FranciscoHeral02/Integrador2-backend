package com.ci2.sgth.people.application.service.impl.mapper;

import com.ci2.sgth.people.domain.dto.CategoryCompetenceDto;
import com.ci2.sgth.people.domain.entity.CategoryCompetence;
import com.ci2.sgth.people.domain.entity.CategoryCompetenceId;

public class CategoryCompetenceMapper {
	
	public static CategoryCompetenceDto mapToDto(CategoryCompetence entity) {
		
		CategoryCompetenceDto dto = CategoryCompetenceDto.builder()
										.categoryId(entity.getCategoryCompetenceId().getCategoryId())
										.competenceId(entity.getCategoryCompetenceId().getCompetenceId())
										.categoria(entity.getCategory())
										.competencia(entity.getCompetence())
										.minimaNota(entity.getMinimaNota())
										.escalaMax(entity.getEscalaMax())
										.saltoEscala(entity.getSaltoEscala())
										.build();
								       
		
		return dto;
	}
	
	public static CategoryCompetence mapToEntity(CategoryCompetenceDto dto) {
		
		CategoryCompetence entity = CategoryCompetence.builder()
									.categoryCompetenceId(CategoryCompetenceId.builder()
															.categoryId(dto.getCategoryId())
															.competenceId(dto.getCompetenceId())
															.build())
									.minimaNota(dto.getMinimaNota())
									.escalaMax(dto.getEscalaMax())
									.saltoEscala(dto.getSaltoEscala())
									.build();
		
		return entity;
	}
}
