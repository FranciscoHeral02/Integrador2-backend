package com.ci2.sgth.people.application.service.impl.mapper;

import com.ci2.sgth.people.domain.dto.CampusDto;
import com.ci2.sgth.people.domain.entity.Campus;
import com.ci2.sgth.people.domain.entity.Ubigeo;

public class CampusMapper {
	
	public static CampusDto mapToDto(Campus entity) {
		CampusDto dto = CampusDto.builder()
							.campusId(entity.getCampusId())
							.ubigeo(entity.getUbigeo())
							.nombreCampus(entity.getNombreCampus())
							.direccionCampus(entity.getDireccionCampus())
							.build();
		return dto;
		
	}
	
	public static Campus mapToEntity(CampusDto dto) {
		Campus entity = Campus.builder()
				.campusId(dto.getCampusId())
				.ubigeo(Ubigeo.builder().idUbigeo(dto.getDepartamentoCampus()+
						dto.getProvinciaCampus()+
						dto.getDistritoCampus()).build())
				.nombreCampus(dto.getNombreCampus())
				.direccionCampus(dto.getDireccionCampus())
				.build();
		return entity;
		
	}
}
