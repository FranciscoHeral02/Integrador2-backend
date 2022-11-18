package com.ci2.sgth.people.domain.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Campus {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long campusId;	
	
	private String nombreCampus;
	
	@OneToOne
	@JoinColumn
	private Ubigeo ubigeo;

	private String direccionCampus;
}
