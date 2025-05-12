package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CriterioRubricaRepository extends ReactiveCrudRepository<CriterioRubrica, Integer> {
    Flux<CriterioRubrica> findByRubricaid(Integer rubricaid);
}
