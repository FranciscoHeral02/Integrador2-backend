package com.ci2.sgth.people.application.service;

import java.util.Set;

import com.ci2.sgth.people.domain.dto.CampusDto;

public interface CampusService {
	CampusDto addCampus(CampusDto dto);
	void deleteCampus(Long idCampus);
	CampusDto getCampus(Long idCampus);
	Set<CampusDto> getAllCampus();
}
