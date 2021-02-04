package com.rh.innovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rh.innovation.model.GestorRH;
import com.rh.innovation.service.GestorRHService;

@RestController
@RequestMapping("/gestorRhAPI")
public class GestorRHController {

	@Autowired
	private GestorRHService gestorRHService;
	
	@RequestMapping("/cadastraGestor")
	public ResponseEntity<Object> cadastraGestor(GestorRH gestorRH){
		gestorRHService.salvar(gestorRH);
		return ResponseEntity.ok().build();
	}
}
