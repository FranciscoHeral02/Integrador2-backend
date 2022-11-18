package com.ci2.sgth.people.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci2.sgth.people.domain.entity.CategoryCompetence;
import com.ci2.sgth.people.domain.entity.CategoryCompetenceId;

public interface CategoryCompetenceRepository extends JpaRepository<CategoryCompetence, CategoryCompetenceId> {

}
