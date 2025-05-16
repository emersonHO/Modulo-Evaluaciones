package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;

@Repository
public interface FormulaRepository extends ReactiveCrudRepository<Formula, Integer> {

}
