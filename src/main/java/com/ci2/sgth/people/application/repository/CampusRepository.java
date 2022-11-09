package com.ci2.sgth.people.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci2.sgth.people.domain.entity.Campus;

public interface CampusRepository extends JpaRepository<Campus, Long> {

}
