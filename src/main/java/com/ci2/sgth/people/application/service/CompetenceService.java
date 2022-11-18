package com.ci2.sgth.people.application.service;

import java.util.Set;

import com.ci2.sgth.people.domain.dto.CompetenceDto;

public interface CompetenceService {
	CompetenceDto addCompetence(CompetenceDto dto);
	void deleteCompetence(Long idCompetence);
	CompetenceDto getCompetence(Long idCompetence);
	Set<CompetenceDto> getAllCompetence();
}
