package com.ci2.sgth.people.domain.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Competence {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idCompetencia;
	private String nombreCompetencia;
	private String descripcionCompetencia;
	
	@OneToMany(mappedBy = "competence")
	private Set<CategoryCompetence> categoryCompetence;
	
}
