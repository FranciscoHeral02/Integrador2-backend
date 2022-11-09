package com.ci2.sgth.people.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ubigeo {

	@Id
	@Column(name = "id_ubigeo")
	private String idUbigeo;
	
	@Column(name = "cod_dep",length = 2)
	private String codDep;
	
	@Column(name = "cod_prov",length = 2)
	private String codProv;
	
	@Column(name = "cod_dist",length = 2)
	private String codDist;
	
	@Column(name = "des_dep")
	private String descDep;
	
	@Column(name = "des_prov")
	private String descProv;
	
	@Column(name = "des_dist")
	private String descDist;
}
