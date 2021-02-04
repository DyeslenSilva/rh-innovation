package com.rh.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.innovation.model.Vagas;
import com.rh.innovation.repo.VagasRepo;

@Service
public class VagasService {

	@Autowired
	private VagasRepo vagasRepo;


	public void salvar(Vagas vagas) {
		vagasRepo.save(vagas);
	}
	
	public List<Vagas> getVagas(){
		return vagasRepo.findAll().stream()
				.filter(vagas -> vagas.isAtivada())
				.collect(Collectors.toList());
	}
	
	public Vagas getVagasPorId(int codigoDaVaga) {
		return vagasRepo.findById(codigoDaVaga).orElse(null);
	}
	
	public List<Vagas> getVagasPorAreaDeAtuacao(String areaDeAtuacao) {
		return vagasRepo.encontrarPorAreaDeAtuacao(areaDeAtuacao);
	}
	
	public List<Vagas> getVagasPorSenioridade(String senioridade){
		return vagasRepo.encontrarPorSenioridade(senioridade);
	}
	
	public void removeVaga(Integer[] lista)  {
		Arrays.stream(lista).forEach(codigoDaVaga ->{
			Vagas vagas = getVagasPorId(codigoDaVaga);
			
			if(vagas != null) {
				vagas.setDesativada(true);
				vagasRepo.save(vagas);
			}
		});
	}
}
