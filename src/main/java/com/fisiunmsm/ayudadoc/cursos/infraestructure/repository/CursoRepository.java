package com.fisiunmsm.ayudadoc.cursos.infraestructure.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper.CursoTable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CursoRepository extends R2dbcRepository<CursoTable, Long>  {
    
    Mono<CursoTable> findByCodigo(String codigo);

    @Query(value = "SELECT * FROM curso WHERE estado = '1' order by nombre")
    Flux<CursoTable> queryCursosActivos();

}
