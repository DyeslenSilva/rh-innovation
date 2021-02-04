package com.rh.innovation.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.transaction.TransactionScoped;

import lombok.Data;

@Data
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idService;
	private String nome;
	private boolean desativado;
	@Transient
	private boolean selecionado;
}
