package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import org.springframework.data.r2dbc.repository.Query;

@Repository
public interface ComponenteRepository extends ReactiveCrudRepository<CursoComponente, Integer> {
    @Query("SELECT * FROM cursocomponente c JOIN componentecompetencia cc ON c.id = cc.cursocomponenteid WHERE cc.competenciaid = :competenciaId")
    Flux<CursoComponente> findByCompetenciaId(Integer competenciaId);
}