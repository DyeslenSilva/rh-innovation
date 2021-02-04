package com.rh.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rh.innovation.model.Candidato;

public interface CandidatoRepo extends JpaRepository<Candidato, Integer> {

}
