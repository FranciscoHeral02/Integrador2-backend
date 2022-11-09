package com.ci2.sgth.people.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
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
	
	
	//@ManyToOne
    //@JoinColumn
	//private Ubigeo lugarNacimiento;
	
	@OneToOne
    @JoinColumn
	private Job puestoTrabajo;
	
	@OneToOne
    @JoinColumn
	private Campus localTrabajo;
	
	@CreatedDate 
	private Date registrofecha;
	@LastModifiedDate 
	private Date fechaModificacion;
	
}
