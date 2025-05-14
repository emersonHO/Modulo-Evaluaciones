package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.RubricaCursoComponente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RubricaCursoComponenteRepository extends ReactiveCrudRepository<RubricaCursoComponente, Integer> {
    Flux<RubricaCursoComponente> findByCursoComponenteId(Integer componenteId);
    Flux<RubricaCursoComponente> findByRubricaId(Integer rubricaId);
}
