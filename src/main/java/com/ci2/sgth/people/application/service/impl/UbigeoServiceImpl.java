package com.ci2.sgth.people.application.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci2.sgth.people.application.repository.UbigeoRepository;
import com.ci2.sgth.people.application.service.UbigeoService;
import com.ci2.sgth.people.domain.dto.Departamento;
import com.ci2.sgth.people.domain.dto.Distrito;
import com.ci2.sgth.people.domain.dto.Provincia;

@Service	
public class UbigeoServiceImpl implements UbigeoService {

	@Autowired
	private UbigeoRepository ubigeoRepository;

	@Override
	public Set<Departamento> listDepartamentos() {
		
		Set<Departamento> deps = ubigeoRepository.findByCodProvIsNullAndCodDistIsNull()
			.stream().map(ubigeo-> new Departamento(ubigeo.getIdUbigeo(),ubigeo.getCodDep(),ubigeo.getDescDep()))
			.collect(Collectors.toSet());
		
		return deps;
	}

	@Override
	public Set<Provincia> listProvincias(String codDep) {
		
		Set<Provincia> provs = ubigeoRepository.findByCodDepAndCodDistIsNullAndCodProvIsNotNull(codDep)
				.stream().map(ubigeo-> new Provincia(ubigeo.getIdUbigeo(),ubigeo.getCodProv(),ubigeo.getDescProv()))
				.collect(Collectors.toSet());
			
			return provs;
	}

	@Override
	public Set<Distrito> listDistritos(String codDep,String codProv) {
		
		Set<Distrito> dists = ubigeoRepository.findByCodDepAndCodProvAndCodDistIsNotNull(codDep,codProv)
				.stream().map(ubigeo-> new Distrito(ubigeo.getIdUbigeo(),ubigeo.getCodDist(),ubigeo.getDescDist()))
				.collect(Collectors.toSet());
			
			return dists;
	}



}
