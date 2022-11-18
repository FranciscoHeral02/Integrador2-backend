package com.ci2.sgth.people.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class CategoryCompetenceId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5953934711433262276L;

	@Column(name = "student_id")
    private final Long categoryId;

    @Column(name = "course_id")
    private final Long competenceId;
    
}
