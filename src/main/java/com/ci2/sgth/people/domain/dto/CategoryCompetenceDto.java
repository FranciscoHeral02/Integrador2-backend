package com.ci2.sgth.people.domain.dto;

import java.math.BigDecimal;

import com.ci2.sgth.people.domain.entity.Category;
import com.ci2.sgth.people.domain.entity.Competence;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryCompetenceDto {
	
    private Long categoryId;

    private Long competenceId;
    
    private Category categoria;
    private Competence competencia;
    
    private BigDecimal minimaNota;
    private Integer escalaMax;
    private Integer saltoEscala;
}
