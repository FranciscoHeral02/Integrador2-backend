package com.ci2.sgth.people.domain.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long categoryId;	
	
	private String nombreCategoria;
	
	private String pagoHora;
	
	@ManyToOne
    @JoinColumn
	private Job job;
	
	@OneToMany(mappedBy = "category")
	private Set<CategoryCompetence> categoryCompetence;
}
