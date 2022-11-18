package com.ci2.sgth.people.domain.dto;

import java.time.LocalDateTime;
import java.util.Set;


import com.ci2.sgth.people.domain.entity.ResultScore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EvaluationDto {
	
	private Long evaluationId;
	
	private LocalDateTime  fechaEvaluacion;
	private Boolean aprobado;
	
	private Set<ResultScore> resultScoreSet;
}
