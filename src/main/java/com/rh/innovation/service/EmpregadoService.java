package com.rh.innovation.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.innovation.model.Empregado;
import com.rh.innovation.repo.EmpregadoRepo;

@Service
public class EmpregadoService {

	@Autowired
	private EmpregadoRepo empregadoRepo;
	
	
	public void salvar(Empregado empregado) {
		empregadoRepo.save(empregado);
	}
	
	public java.util.List<Empregado> getEmpregados(){
		return empregadoRepo.findAll().stream()
				.filter(empregado -> !empregado.isDesativado())
				.collect(Collectors.toList());
	}
	
	public Empregado getEmpregado(int idEmpregado) {
		return empregadoRepo.findById(idEmpregado).orElse(null);
	}
	
	public void removeCliente(int [] lista) {
		Arrays.stream(lista).forEach(idEmpregado ->{
			Empregado empregado = getEmpregado(idEmpregado);
			
			if(empregado != null) {
				empregado.setDesativado(true);
				empregadoRepo.save(empregado);
				
			}
		});
	}
}
