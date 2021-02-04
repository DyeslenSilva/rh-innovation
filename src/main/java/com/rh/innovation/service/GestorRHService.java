package com.rh.innovation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.innovation.model.GestorRH;
import com.rh.innovation.repo.GestorRHRepo;

@Service
public class GestorRHService {
	
	@Autowired
	private GestorRHRepo gestorRHRepo;
	
	public void salvar(GestorRH gestorRH) {
		gestorRHRepo.save(gestorRH);
	}
	
	
}
