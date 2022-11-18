package com.ci2.sgth.people.application.service.impl.mapper;

import com.ci2.sgth.people.domain.dto.JobDto;
import com.ci2.sgth.people.domain.entity.Job;

public class JobMapper {
		
	public static JobDto mapToDto(Job entity) {
		JobDto dto = JobDto.builder()
						.jobId(entity.getJobId())
						.nombrePuesto(entity.getNombrePuesto())
						.build();
		
		return dto;
		
	}
	
	public static Job mapToEntity(JobDto dto) {
		Job entity = Job.builder()
				.jobId(dto.getJobId())
				.nombrePuesto(dto.getNombrePuesto())
				.build();

		return entity;

		
	}
}
