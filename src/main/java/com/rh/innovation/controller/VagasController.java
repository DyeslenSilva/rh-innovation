package com.rh.innovation.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rh.innovation.model.Vagas;
import com.rh.innovation.service.ServicoService;
import com.rh.innovation.service.VagasService;

@RestController
@RequestMapping("/vagasApi")
@CrossOrigin(origins = "http://localhost:4200")
public class VagasController {

	@Autowired
	private VagasService vagasService;

	private ServicoService servicoService;
	
	@RequestMapping("/cadastraVaga")
	public ResponseEntity<Object> cadastraVagas(@RequestBody Vagas vagas){
		vagasService.salvar(vagas);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaDeVagas")
	public ResponseEntity<List<Vagas>> getVagas(){
		return ResponseEntity.ok(vagasService.getVagas());
	}
	
	@RequestMapping("/vaga/{codigoDaVaga}")
	public ResponseEntity<Vagas> getVagasPorCodigo(Integer codigoDaVaga){
		return ResponseEntity.ok(vagasService.getVagasPorId(codigoDaVaga));
	}
	
	@RequestMapping("/vaga/{areaDeAtuacao")
	public ResponseEntity<List<Vagas>> getVagasPorAreaDeAtuacao(String areaDeAtuacao){
		return ResponseEntity.ok(vagasService.getVagasPorAreaDeAtuacao(areaDeAtuacao));
	}
	
	@RequestMapping("/vaga/{senioridade}")
	public ResponseEntity<List<Vagas>> getVagasPorSenioridade(String senioridade){
		return ResponseEntity.ok(vagasService.getVagasPorSenioridade(senioridade));
	}
	
	@RequestMapping("/vaga/{codigoDaVaga}")
	public ResponseEntity<Object> editaVaga(@PathVariable("codigoDaVaga") Integer codigoDaVaga){
		Vagas vagas = vagasService.getVagasPorId(codigoDaVaga);
		
		if(vagas != null) {
			return ResponseEntity.ok(vagasService.getVagas());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping("/removeVaga")
	public ResponseEntity<Object> removeVaga(@RequestBody Integer[] lista){
		vagasService.removeVaga(lista);
		return ResponseEntity.ok().build();	
	}
	
	
}