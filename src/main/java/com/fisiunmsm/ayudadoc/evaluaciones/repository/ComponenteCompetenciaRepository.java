package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteSimple;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import org.springframework.data.r2dbc.repository.Query;
import reactor.core.publisher.Mono;

@Repository
public interface ComponenteCompetenciaRepository extends ReactiveCrudRepository<ComponenteCompetencia, Integer> {
    @Query("SELECT cc.* FROM componentecompetencia cc " +
            "JOIN cursocomponente c ON cc.cursocomponenteid = c.id " +
            "JOIN cursocompetencia cco ON cc.cursocompetenciaid = cco.id " +
            "JOIN competencia comp ON cco.competenciaid = comp.id")
    Flux<ComponenteCompetencia> findAllDetalles();

    @Query("SELECT c.id as id, c.descripcion as descripcion, c.peso as peso FROM cursocomponente c WHERE c.peso IS NOT NULL")
    Flux<ComponenteSimple> findAllComponentesConPeso();

    @Query("DELETE FROM competencias_asociadas WHERE componente = :componente")
    Mono<Void> deleteByComponente(String componente);
}