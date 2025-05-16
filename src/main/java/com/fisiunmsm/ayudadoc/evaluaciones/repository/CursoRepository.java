package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Curso;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CursoRepository extends ReactiveCrudRepository<Curso, Integer> {
    Flux<Curso> findByInstitucionIdAndPeriodoId(Integer institucionId, Integer periodoId);
}