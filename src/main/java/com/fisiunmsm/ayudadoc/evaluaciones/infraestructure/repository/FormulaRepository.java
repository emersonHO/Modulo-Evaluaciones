package com.fisiunmsm.ayudadoc.evaluaciones.infraestructure.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.fisiunmsm.ayudadoc.evaluaciones.infraestructure.mapper.FormulaTable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FormulaRepository extends R2dbcRepository<FormulaTable, Integer>  {
    
    Mono<FormulaTable> findByCodigo(String codigo);

    @Query(value = "SELECT * FROM formula WHERE estado = '1' ORDER BY id")
    Flux<FormulaTable> queryFormulasActivas();
}