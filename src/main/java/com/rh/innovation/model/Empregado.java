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
@Entity
@Table
public class Empregado {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idEmpregado;
	@Column
	private String nomeEmpregado;
	
	@Column
	private String rg;
	
	@Column
	private String cpf;
	
	@Column
	private String telefoneCelular;
	
	@Column
	private String endereco;
	
	@Column
	private String setor;
	@Column
	private String areaDeAtuacao;
	@Column
	private long salario;
	
	private boolean ativado;
	private boolean desativado;

}
