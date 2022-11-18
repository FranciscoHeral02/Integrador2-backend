package com.ci2.sgth.people.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDto {
	private Long jobId;	
	private String nombrePuesto;
}
