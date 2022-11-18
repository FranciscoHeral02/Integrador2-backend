package com.ci2.sgth.people.application.service.impl;

import static com.ci2.sgth.people.application.service.impl.mapper.JobMapper.mapToDto;
import static com.ci2.sgth.people.application.service.impl.mapper.JobMapper.mapToEntity;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ci2.sgth.people.application.repository.JobRepository;
import com.ci2.sgth.people.application.service.JobService;
import com.ci2.sgth.people.domain.dto.JobDto;
import com.ci2.sgth.people.domain.entity.Job;

public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	
	@Override
	public JobDto addJob(JobDto dto) {
		return mapToDto(jobRepository.save(mapToEntity(dto)));
	}

	@Override
	public void deleteJob(Long jobId) {
		jobRepository.deleteById(jobId);
	}

	@Override
	public JobDto getJob(Long jobId) {
		
		Job job= jobRepository.findById(jobId).orElseThrow(
				()-> new EntityNotFoundException("No se encuentra la entidad")
		);
		
		return mapToDto(job);
	}

	@Override
	public Set<JobDto> getAllJob() {
		 Set<JobDto> jobDtoSet = jobRepository.findAll().stream()
					.map(e-> mapToDto(e)).collect(Collectors.toSet());

		 return jobDtoSet;
	}

}
