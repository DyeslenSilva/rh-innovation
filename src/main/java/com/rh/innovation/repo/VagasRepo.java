package com.rh.innovation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rh.innovation.model.Vagas;

public interface VagasRepo extends JpaRepository<Vagas, Integer> {

	List<Vagas> encontrarPorAreaDeAtuacao(String areaDeAtuacao);

	List<Vagas> encontrarPorSenioridade(String senioridade);

}
