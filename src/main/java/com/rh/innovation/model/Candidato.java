package com.rh.innovation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Candidato {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idCandidato;
	@Column
	private String nomeCandidato;
	
	@Column
	private String rg;
	
	@Column
	private String cpf;
	
	@Column
	private String endereco;
	
	@Column
	private String telefoneCelular;
	
	@Column
	private String cargoPretendido;
	@Column
	private long pretencaoSalarial;
	
	@Column
	private String email;
	
	private String senha;
	
	private List<Servico> servicos;

	private boolean ativado;
	private boolean desativado;
	
	
	
	
	
	
}
