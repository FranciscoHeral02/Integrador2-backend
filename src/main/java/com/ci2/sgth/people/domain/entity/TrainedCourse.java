package com.ci2.sgth.people.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class TrainedCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long trainingId;	
	
	private Integer notaCurso;
	@OneToOne
    @JoinColumn
	private Courses course;
	
	@ManyToOne
	@JoinColumn
	private Employee employee;
}
