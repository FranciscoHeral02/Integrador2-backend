package com.ci2.sgth.people.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci2.sgth.people.domain.entity.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Long>{
	
}
