package com.ci2.sgth.people.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci2.sgth.people.domain.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
