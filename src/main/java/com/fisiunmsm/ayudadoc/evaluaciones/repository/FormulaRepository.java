package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulaRepository extends ReactiveCrudRepository<Formula, Integer> {
}
