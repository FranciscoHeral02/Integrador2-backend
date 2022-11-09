package com.ci2.sgth.people.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long jobId;	
	private String nombrePuesto;
}
