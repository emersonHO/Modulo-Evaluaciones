package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NivelCriterioRepository extends ReactiveCrudRepository<NivelCriterio, Integer> {
    Flux<NivelCriterio> findByCriterioid(Integer criterioid);
}
