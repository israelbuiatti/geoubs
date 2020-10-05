package com.bionexo.geoubs.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "ubs")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ubs {

	@Id
	@Column(name = "id")
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
	@Column(name = "nom_estab")
	private String name;
	
	@Column(name = "dsc_endereco")
	private String address;
	
	@Column(name = "dsc_cidade")
	private String city;
	
	@Column(name = "dsc_telefone")
	private String phone;
	
	@Column(name = "vlr_latitude")
	private String latitude;
	
	@Column(name = "vlr_longitude")
	private String longitude;
	
	@Column(name = "dsc_adap_defic_fisic_idosos")
	private String adaptation_for_seniors;
	
	@Column(name = "dsc_equipamentos")
	private String medical_equipment;
	
	@Column(name = "dsc_medicamentos")
	private String medicine;
	
	@Column(name = "distancia")
	private String distancia;


}
