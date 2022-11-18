package com.ci2.sgth.people.domain.dto;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompetenceDto {
	
	private Long idCompetencia;
	private String nombreCompetencia;
	private String descripcionCompetencia;
	
}
