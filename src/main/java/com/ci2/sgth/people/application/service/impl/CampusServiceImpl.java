package com.ci2.sgth.people.application.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci2.sgth.people.application.repository.CampusRepository;
import com.ci2.sgth.people.application.service.CampusService;
import com.ci2.sgth.people.domain.dto.CampusDto;
import com.ci2.sgth.people.domain.entity.Campus;

import static com.ci2.sgth.people.application.service.impl.mapper.CampusMapper.mapToDto;
import static com.ci2.sgth.people.application.service.impl.mapper.CampusMapper.mapToEntity;

@Service
public class CampusServiceImpl implements CampusService {

	@Autowired
	private CampusRepository campusRepository;
	
	@Override
	public CampusDto addCampus(CampusDto dto) {
		
		return mapToDto(campusRepository.save(mapToEntity(dto)));
		
	}

	@Override
	public void deleteCampus(Long campusId) {
		campusRepository.deleteById(campusId);
	}

	@Override
	public CampusDto getCampus(Long campusId) {
		
		Campus campus= campusRepository.findById(campusId).orElseThrow(
				()-> new EntityNotFoundException("No se encuentra la entidad")
		);
		return mapToDto(campus);
	}

	@Override
	public Set<CampusDto> getAllCampus() {
		
		 Set<CampusDto> campusDtoSet = campusRepository.findAll().stream()
				 						.map(e-> mapToDto(e)).collect(Collectors.toSet());
		
		return campusDtoSet;
	}

}
