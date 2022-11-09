package com.ci2.sgth.people.infraestructure.expose;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci2.sgth.people.application.service.UbigeoService;
import com.ci2.sgth.people.domain.dto.Departamento;
import com.ci2.sgth.people.domain.dto.Distrito;
import com.ci2.sgth.people.domain.dto.Provincia;

@RestController
@RequestMapping("/ubigeo")
public class UbigeoController {
	@Autowired
	private UbigeoService ubigeoService;
	
	@GetMapping("/getDepartamentos")
	public ResponseEntity<Set<Departamento>> listDepartamentos(){
		
		return new ResponseEntity<Set<Departamento>>(ubigeoService.listDepartamentos(),HttpStatus.OK);
	}
	
	@GetMapping("/getProvincias/{codDep}")
	public ResponseEntity<Set<Provincia>> listProvincias(@PathVariable String codDep){
		
		return new ResponseEntity<Set<Provincia>>(ubigeoService.listProvincias(codDep),HttpStatus.OK);
	}
	
	@GetMapping("/getDistritos/{codDep}/{codProv}")
	public ResponseEntity<Set<Distrito>> listDistritos(@PathVariable String codDep,@PathVariable String codProv){
		
		return new ResponseEntity<Set<Distrito>>(ubigeoService.listDistritos(codDep, codProv),HttpStatus.OK);
	}
}
