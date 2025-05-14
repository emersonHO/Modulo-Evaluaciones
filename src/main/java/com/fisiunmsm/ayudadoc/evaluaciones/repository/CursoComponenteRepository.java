package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoComponenteRepository extends ReactiveCrudRepository<CursoComponente, Long> {
}
