package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Funcion;

@Repository
public interface FuncionRepository extends ReactiveCrudRepository<Funcion, Integer> {
    
}
