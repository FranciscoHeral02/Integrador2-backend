package com.ci2.sgth.people.application.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci2.sgth.people.domain.entity.Ubigeo;

public interface UbigeoRepository extends JpaRepository<Ubigeo, String>  {
	Set<Ubigeo> findByCodProvIsNullAndCodDistIsNull();
	Set<Ubigeo> findByCodDepAndCodDistIsNullAndCodProvIsNotNull(String codDep);
	Set<Ubigeo> findByCodDepAndCodProvAndCodDistIsNotNull(String codDep,String codProv);
	
}
