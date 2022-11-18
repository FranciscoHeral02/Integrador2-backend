package com.ci2.sgth.people.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long employeeId;	
	private String nombre;
	private String apellidos;
	private String direccion;
	@Column(unique=true)
	private String telefono;
	@Column(unique=true)
	private String celular;
	@Column(unique=true)
	private String email;
	private LocalDate fechaNacimiento;
	@Column(unique=true)
	private String dni;
	private String puestoPostulacion;
	private BigDecimal aspiracionSalarial;
	private String disponibilidad;
	private Integer aniosServicio;
	private String empresaAnterior;
	private String puestoAnterior;
	private String perfil;
	private Boolean entrevistado;
	private Boolean contratado;
	private String cvFileName;
	
	@ManyToOne
    @JoinColumn
	private Ubigeo lugarNacimiento;
	
	@ManyToOne
    @JoinColumn
	private Job puestoTrabajo;
	
	@ManyToOne
    @JoinColumn
	private Campus localTrabajo;
	
	@OneToMany
	private Set<Evaluation> evaluationSet;
	
	@CreatedDate 
	private Date registrofecha;
	@LastModifiedDate 
	private Date fechaModificacion;
	
}
