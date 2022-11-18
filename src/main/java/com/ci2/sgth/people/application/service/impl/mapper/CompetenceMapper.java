package com.ci2.sgth.people.application.service.impl.mapper;

import com.ci2.sgth.people.domain.dto.CompetenceDto;
import com.ci2.sgth.people.domain.entity.Competence;

public class CompetenceMapper {
	
	public static CompetenceDto mapToDto(Competence entity) {
		CompetenceDto dto  = CompetenceDto.builder()
								.idCompetencia(entity.getIdCompetencia())
								.nombreCompetencia(entity.getNombreCompetencia())
								.descripcionCompetencia(entity.getDescripcionCompetencia())
								.build();
		return dto;
		
	}
	
	public static Competence mapToEntity(CompetenceDto dto) {
		
		Competence entity  = Competence.builder()
				.idCompetencia(dto.getIdCompetencia())
				.nombreCompetencia(dto.getNombreCompetencia())
				.descripcionCompetencia(dto.getDescripcionCompetencia())
				.build();
		return entity;
		
	}
}
