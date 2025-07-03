package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteSimple;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import org.springframework.data.r2dbc.repository.Query;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Repository
public interface ComponenteCompetenciaRepository extends ReactiveCrudRepository<ComponenteCompetencia, Integer> {
    @Query("SELECT cc.*, comp.nombre as nombreCompetencia, comp.descripcion as descripcionCompetencia " +
            "FROM componentecompetencia cc " +
            "JOIN cursocomponente c ON cc.cursocomponenteid = c.id " +
            "JOIN cursocompetencia cco ON cc.cursocompetenciaid = cco.id " +
            "JOIN competencia comp ON cco.competenciaid = comp.id")
    Flux<ComponenteCompetencia> findAllDetalles();

    @Query("SELECT c.id as id, c.descripcion as descripcion, c.peso as peso FROM cursocomponente c LEFT JOIN componentecompetencia cc ON c.id = cc.cursocomponenteid GROUP BY c.id, c.descripcion, c.nivel, c.padreid, c.peso")
    Flux<ComponenteSimple> findAllComponentesConPeso();

    @Query("SELECT c.id as id, c.descripcion as descripcion, c.peso as peso FROM cursocomponente c LEFT JOIN componentecompetencia cc ON c.id = cc.cursocomponenteid WHERE cc.cursocomponenteid IS NULL GROUP BY c.id, c.descripcion, c.nivel, c.padreid, c.peso")
    Flux<ComponenteSimple> findComponentesNoAsociados();

    @Query("DELETE FROM componentecompetencia WHERE cursocomponenteid = :componenteId")
    Mono<Void> deleteByCursocomponenteid(Long componenteId);

    @Query("SELECT cc.*, comp.nombre as nombreCompetencia, comp.descripcion as descripcionCompetencia " +
            "FROM componentecompetencia cc " +
            "JOIN cursocompetencia cco ON cc.cursocompetenciaid = cco.id " +
            "JOIN competencia comp ON cco.competenciaid = comp.id " +
            "WHERE cc.cursocomponenteid = :componenteId")
    Flux<ComponenteCompetencia> findCompetenciasByComponenteId(Long componenteId);
    
    @Query("SELECT c.id FROM cursocomponente c " +
            "JOIN componentecompetencia cc ON c.id = cc.cursocomponenteid " +
            "JOIN cursocompetencia cco ON cc.cursocompetenciaid = cco.id " +
            "WHERE cco.competenciaid = :competenciaId")
    Flux<Long> findComponenteIdsByCompetenciaId(Integer competenciaId);
}