package com.rh.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rh.innovation.model.Empregado;

public interface EmpregadoRepo extends JpaRepository<Empregado, Integer> {

}
