package com.rh.innovation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rh.innovation.model.Candidato;
import com.rh.innovation.model.Servico;
import com.rh.innovation.model.valueObject.ListaDeServicos;
import com.rh.innovation.service.CandidatoService;
import com.rh.innovation.service.ServicoService;

@RestController
@RequestMapping("/candidatoAPI")
public class CandidatoController {

	@Autowired
	private CandidatoService candidatoService;
	
	@Autowired
	private ServicoService servicoService;
	
	@PostMapping("/cadastraCandidato")
	public ResponseEntity<Candidato> cadasatraCandidato(@RequestBody Candidato candidato){
		candidatoService.save(candidato);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaCandidato")
	public ResponseEntity<List<Candidato>> getCandidato(){
		return ResponseEntity.ok(candidatoService.getCandidatos());
	}
	
	@RequestMapping("/editaCandidato/{idCandidato}")
	public ResponseEntity<Object> editaCandidato(@PathVariable("idCandidato") Integer idCandidato){
		Candidato candidato = candidatoService.getCandidato(idCandidato);
		
		if(candidato != null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/selecionaServico")
	public ResponseEntity<Object> selecionaServico(@RequestBody ListaDeServicos lista){
		Candidato candidato = candidatoService.getCandidato(lista.getIdCandidato());
		if(candidato != null) {
			if(candidato.getServicos() ==null) 
				candidato.setServicos(new ArrayList<>());
				
				Predicate<Servico> naoEstaNaLista = (srvCandidato) -> !Arrays.stream(lista.getServicos())
						.filter(srvDaLista -> srvDaLista.getIdService() == srvCandidato.getIdService())
						.findFirst().get().isSelecionado();
				
				
				List<Servico> aDeletar = candidato.getServicos().stream()
						.filter(naoEstaNaLista).collect(Collectors.toList());
			
				aDeletar.stream().forEach(servico -> candidato.getServicos()
						.removeIf(srv -> srv.getIdService() == servico.getIdService()));
			
				
				Arrays.stream(lista.getServicos()).filter(Servico :: isSelecionado)
					.filter(servico -> !candidato.getServicos().contains(servico))
					.forEach(servico -> candidato.getServicos().add(servico));
			
			
				candidatoService.save(candidato);
				return ResponseEntity.ok().build();
		}else {
				return ResponseEntity.unprocessableEntity().build();
			}
		}	
	}