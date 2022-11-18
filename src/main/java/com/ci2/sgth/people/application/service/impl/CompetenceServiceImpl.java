package com.ci2.sgth.people.application.service.impl;

import static com.ci2.sgth.people.application.service.impl.mapper.CompetenceMapper.mapToDto;
import static com.ci2.sgth.people.application.service.impl.mapper.CompetenceMapper.mapToEntity;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ci2.sgth.people.application.repository.CompetenceRepository;
import com.ci2.sgth.people.application.service.CompetenceService;
import com.ci2.sgth.people.domain.dto.CompetenceDto;
import com.ci2.sgth.people.domain.entity.Competence;

public class CompetenceServiceImpl implements CompetenceService {

	@Autowired
	private CompetenceRepository competenceRepository;
	
	
	@Override
	public CompetenceDto addCompetence(CompetenceDto dto) {
		return mapToDto(competenceRepository.save(mapToEntity(dto)));
	}

	@Override
	public void deleteCompetence(Long competenceId) {
		competenceRepository.deleteById(competenceId);
	}

	@Override
	public CompetenceDto getCompetence(Long competenceId) {
		
		Competence competence= competenceRepository.findById(competenceId).orElseThrow(
				()-> new EntityNotFoundException("No se encuentra la entidad")
		);
		
		return mapToDto(competence);
	}

	@Override
	public Set<CompetenceDto> getAllCompetence() {
		 Set<CompetenceDto> competenceDtoSet = competenceRepository.findAll().stream()
					.map(e-> mapToDto(e)).collect(Collectors.toSet());

		 return competenceDtoSet;
	}

}
