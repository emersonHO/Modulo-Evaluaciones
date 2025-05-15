package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.dto.ComponenteCompetenciaDetalleDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.dto.ComponenteSimpleDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import org.springframework.data.r2dbc.repository.Query;
import reactor.core.publisher.Mono;

@Repository
public interface ComponenteCompetenciaRepository extends ReactiveCrudRepository<ComponenteCompetencia, Integer> {
    // Flux<ComponenteCompetencia> findByCursocompetenciaid(Integer
    // cursocompetenciaid);

    @Query("SELECT cc.id, c.descripcion AS descripcionComponente, comp.descripcion AS descripcionCompetencia, c.peso " +
            "FROM componentecompetencia cc " +
            "JOIN cursocomponente c ON cc.cursocomponenteid = c.id " +
            "JOIN cursocompetencia cco ON cc.cursocompetenciaid = cco.id " +
            "JOIN competencia comp ON cco.competenciaid = comp.id")
    Flux<ComponenteCompetenciaDetalleDTO> findAllDetalles();

    @Query("SELECT MIN(c.id) AS id, c.descripcion, MAX(c.peso) AS peso FROM cursocomponente c WHERE c.peso IS NOT NULL GROUP BY c.descripcion")
    Flux<ComponenteSimpleDTO> findAllComponentesConPeso();

    @Query("DELETE FROM competencias_asociadas WHERE componente = :componente")
    Mono<Void> deleteByComponente(String componente);
}