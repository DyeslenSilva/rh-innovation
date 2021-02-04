package com.rh.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.innovation.model.Candidato;
import com.rh.innovation.repo.CandidatoRepo;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepo candidatoRepo;
	
	
	public void save (Candidato candidato) {
		candidatoRepo.save(candidato);
	}
	
	public List<Candidato> getCandidatos(){
		return candidatoRepo.findAll().stream()
				.filter(candidato -> !candidato.isDesativado())
				.collect(Collectors.toList());
	}
	
	public Candidato getCandidato(Integer idCandidato) {
		return candidatoRepo.findById(idCandidato).orElse(null);
	}
	
	public void removeCandidato(int [] list) {
		Arrays.stream(list).forEach(idCandidato ->{
			Candidato candidato = getCandidato(idCandidato);
			
			if(candidato != null) {
				candidato.setDesativado(true);
				candidatoRepo.save(candidato);
			}
		});
	}
}