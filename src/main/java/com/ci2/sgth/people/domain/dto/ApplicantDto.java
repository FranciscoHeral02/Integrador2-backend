package com.ci2.sgth.people.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicantDto {

	private Long employeeId;	
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String celular;
	private String email;
	private LocalDate fechaNacimiento;
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
	private String lugarNacimiento;
	private String provinciaNacimiento;
	private String departamentoNacimiento;
	private String distritoNacimiento;
	private Long puestoTrabajo;	
	private	Long localTrabajo;
	private String cvFileName;
	
	private String base64pdf;
}
