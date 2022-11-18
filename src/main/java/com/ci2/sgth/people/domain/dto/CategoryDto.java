package com.ci2.sgth.people.domain.dto;

import java.util.Set;


import com.ci2.sgth.people.domain.entity.CategoryCompetence;
import com.ci2.sgth.people.domain.entity.Job;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

	private Long categoryId;	
	
	private String nombreCategoria;
	
	private String pagoHora;
	
	private Long jobId;
	
	private Job job;
	
	private Set<CategoryCompetence> categoryCompetence;
}
