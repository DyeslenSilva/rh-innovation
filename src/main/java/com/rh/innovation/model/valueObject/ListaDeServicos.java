package com.rh.innovation.model.valueObject;

import com.rh.innovation.model.Servico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeServicos {

	private int idCandidato;
	private Servico[] servicos;
}
