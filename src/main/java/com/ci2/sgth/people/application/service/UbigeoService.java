package com.ci2.sgth.people.application.service;

import java.util.Set;

import com.ci2.sgth.people.domain.dto.Departamento;
import com.ci2.sgth.people.domain.dto.Distrito;
import com.ci2.sgth.people.domain.dto.Provincia;

public interface UbigeoService {
	
	Set<Departamento> listDepartamentos();
	Set<Provincia> listProvincias(String codDep);
	Set<Distrito> listDistritos(String codDep,String codProv );
	
}
