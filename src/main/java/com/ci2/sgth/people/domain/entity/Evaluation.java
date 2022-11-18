package com.ci2.sgth.people.domain.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long evaluationId;
	
	private LocalDateTime  fechaEvaluacion;
	private Boolean aprobado;
	
	@OneToMany
	private Set<ResultScore> resultScoreSet;
	
}
