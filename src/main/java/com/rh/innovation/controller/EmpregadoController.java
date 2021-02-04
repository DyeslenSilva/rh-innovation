package com.rh.innovation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rh.innovation.model.Empregado;
import com.rh.innovation.service.EmpregadoService;
import com.rh.innovation.service.ServicoService;

@RestController
@RequestMapping("/empregadoAPI")
public class EmpregadoController {

	@Autowired
	private EmpregadoService empregadoService;
	
	@Autowired
	private ServicoService servicoService;

	@RequestMapping("/cadastrarEmpregado")
	public ResponseEntity<Object> cadastro(@RequestBody Empregado empregado){
		empregadoService.salvar(empregado);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaEmpregado")
	public ResponseEntity<List<Empregado>> getEmpregados(){
		return ResponseEntity.ok(empregadoService.getEmpregados());
	}
	
	@RequestMapping("/editaEmpregado")
	public ResponseEntity<Object> editaEmpregados(@PathVariable("idEmpregado") Integer idEmpregado){
		Empregado empregado = empregadoService.getEmpregado(idEmpregado);
		if(empregado != null) {
			ResponseEntity.ok(empregado);
		}else {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.noContent().build();
		}
	
	@RequestMapping("/removeCliente")
	public ResponseEntity<Object> removeEmpregados(@RequestBody int[]lista){
		empregadoService.removeCliente(lista);
		return ResponseEntity.ok().build();
	}
	
	
	
}
