package com.rh.innovation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.innovation.model.Servico;
import com.rh.innovation.repo.ServicoRepo;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepo servicoRepo;
	
	
	public void salvar(Servico servico) {
		servicoRepo.save(servico);
	}
	
	public List<Servico> getServicos(){
		return servicoRepo.findAll().stream()
				.filter(servico -> servico.isDesativado())
				.collect(Collectors.toList());
	}
	
	
	public Servico getServico(Integer idServico) {
		return servicoRepo.findById(idServico).orElse(null);
	}
	
	public boolean removeServico(Integer idServico) {
		Servico servico = getServico(idServico);
		
		if(servico != null) {
			servico.setDesativado(true);
			servicoRepo.save(servico);
			return true;
		}else {
			return false;
		}
	}
}
