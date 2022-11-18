package com.ci2.sgth.people.domain.dto;


import com.ci2.sgth.people.domain.entity.Ubigeo;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CampusDto {

	private Long campusId;	
	
	private String nombreCampus;
	
	private Ubigeo ubigeo;
	
	private Long id;

	private String direccionCampus;
	
	private String provinciaCampus;
	private String departamentoCampus;
	private String distritoCampus;
}
