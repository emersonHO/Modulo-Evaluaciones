package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ComponenteCompetenciaRepository extends ReactiveCrudRepository<ComponenteCompetencia, Integer> {
    Flux<ComponenteCompetencia> findByCursocompetenciaid(Integer cursocompetenciaid);
}