package com.ci2.sgth.people.domain.entity;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class CategoryCompetence {
	
	@EmbeddedId
	private CategoryCompetenceId categoryCompetenceId;
	
	@ManyToOne
    @MapsId("categoryId")
    @JoinColumn
    private Category category;

    @ManyToOne
    @MapsId("competenceId")
    @JoinColumn
    private Competence competence;
    
    
    private BigDecimal minimaNota;
    private Integer escalaMax;
    private Integer saltoEscala;
    
	
}
