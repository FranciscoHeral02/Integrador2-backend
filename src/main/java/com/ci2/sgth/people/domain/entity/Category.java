package com.ci2.sgth.people.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long categoryId;	
	
	private String nombreCategoria;
	
	private String pagoHora;
	
	@ManyToOne
    @JoinColumn
	private Job puesto;
}
