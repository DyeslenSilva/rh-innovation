package com.rh.innovation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Table
@Entity
public class GestorRH {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idGestor;
	@Column
	private String nomeGestor;
	@Column
	private String areaGestor;
	@Column
	private long salario;
	@Column
	private String senha;
	
}
