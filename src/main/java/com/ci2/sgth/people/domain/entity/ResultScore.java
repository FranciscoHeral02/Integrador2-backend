package com.ci2.sgth.people.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ResultScore {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long resultScoreId;
	
	private BigDecimal nota; 
	private Boolean aprobado;
	
	@ManyToOne
    @JoinColumn
	private Competence competence;
}
