package com.rh.innovation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Vagas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoDaVaga;
	
	@Column
	private String tituloDaVaga;
	
	@Column
	private String descricaoDaVaga;
	
	@Column
	private String areaDeAtuacao;
	
	@Column
	private long salario;
	
	@Column
	private String senioriade;
	
	@Column
	private Date dataDePublicacao;
	
	private Integer validade;
	
	private boolean ativada;
	private boolean desativada;
	
	
	public Object isDesativada() {
		// TODO Auto-generated method stub
		return null;
	}
}
