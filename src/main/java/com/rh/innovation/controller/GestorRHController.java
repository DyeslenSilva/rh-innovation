package com.rh.innovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rh.innovation.model.GestorRH;
import com.rh.innovation.model.Vagas;
import com.rh.innovation.service.GestorRHService;
import com.rh.innovation.service.VagasService;

@RestController
@RequestMapping("/gestorRhAPI")
@CrossOrigin(origins = "http://localhost:4200")
public class GestorRHController {

	@Autowired
	private GestorRHService gestorRHService;
	
	@RequestMapping("/cadastraGestor")
	public ResponseEntity<Object> cadastraGestor(GestorRH gestorRH){
		gestorRHService.salvar(gestorRH);
		return ResponseEntity.ok().build();
	}
	
	
	
}
