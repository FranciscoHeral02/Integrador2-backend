package com.ci2.sgth.people.application.service.impl.mapper;


import com.ci2.sgth.people.domain.dto.ApplicantDto;
import com.ci2.sgth.people.domain.entity.Campus;
import com.ci2.sgth.people.domain.entity.Employee;
import com.ci2.sgth.people.domain.entity.Job;
import com.ci2.sgth.people.domain.entity.Ubigeo;

public class ApplicantMapper{
	
	public static ApplicantDto mapToDto(Employee employee) {
		
		ApplicantDto dto = ApplicantDto.builder()
				.aniosServicio(employee.getAniosServicio())
				.apellidos(employee.getApellidos())
				.aspiracionSalarial(employee.getAspiracionSalarial())
				.celular(employee.getCelular())
				.contratado(employee.getContratado())
				.departamentoNacimiento(employee.getLugarNacimiento().getCodDep())
				.direccion(employee.getDireccion())
				.disponibilidad(employee.getDisponibilidad())
				.distritoNacimiento(employee.getLugarNacimiento().getCodDist())
				.dni(employee.getDni())
				.email(employee.getEmail())
				.employeeId(employee.getEmployeeId())
				.empresaAnterior(employee.getEmpresaAnterior())
				.entrevistado(employee.getEntrevistado())
				.fechaNacimiento(employee.getFechaNacimiento())
				.localTrabajo(null==employee.getLocalTrabajo()?null:employee.getLocalTrabajo().getCampusId())
				.lugarNacimiento(employee.getLugarNacimiento().getIdUbigeo())
				.nombre(employee.getNombre())
				.perfil(employee.getPerfil())
				.provinciaNacimiento(employee.getLugarNacimiento().getCodProv())
				.puestoAnterior(employee.getPuestoAnterior())
				.puestoPostulacion(employee.getPuestoPostulacion())
				.puestoTrabajo(null==employee.getPuestoTrabajo()?null:employee.getPuestoTrabajo().getJobId())
				.telefono(employee.getTelefono())
				.cvFileName(employee.getCvFileName())
				.build();
		
		return dto;
	}
	
	public static Employee mapToEntity(ApplicantDto employee) {
		
		Employee entity = Employee.builder()
				.aniosServicio(employee.getAniosServicio())
				.apellidos(employee.getApellidos())
				.aspiracionSalarial(employee.getAspiracionSalarial())
				.celular(employee.getCelular())
				.contratado(employee.getContratado())
				.direccion(employee.getDireccion())
				.disponibilidad(employee.getDisponibilidad())
				.dni(employee.getDni())
				.email(employee.getEmail())
				.employeeId(employee.getEmployeeId())
				.empresaAnterior(employee.getEmpresaAnterior())
				.entrevistado(employee.getEntrevistado())
				.fechaNacimiento(employee.getFechaNacimiento())
				.localTrabajo(null==employee.getLocalTrabajo()?null:Campus.builder().campusId(employee.getLocalTrabajo()).build())
				.lugarNacimiento(Ubigeo.builder().idUbigeo(employee.getDepartamentoNacimiento()+
														   employee.getProvinciaNacimiento()+
														   employee.getDistritoNacimiento()).build())
				.nombre(employee.getNombre())
				.perfil(employee.getPerfil())
				.puestoAnterior(employee.getPuestoAnterior())
				.puestoPostulacion(employee.getPuestoPostulacion())
				.puestoTrabajo(null==employee.getPuestoTrabajo()?null:Job.builder().jobId(employee.getPuestoTrabajo()).build())
				.telefono(employee.getTelefono())
				.cvFileName(employee.getCvFileName())
				.build();
				
		return entity;
	}	
	
}
