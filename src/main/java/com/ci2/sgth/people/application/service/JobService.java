package com.ci2.sgth.people.application.service;

import java.util.Set;

import com.ci2.sgth.people.domain.dto.JobDto;

public interface JobService {
	JobDto addJob(JobDto dto);
	void deleteJob(Long idCompetence);
	JobDto getJob(Long idCompetence);
	Set<JobDto> getAllJob();
}
