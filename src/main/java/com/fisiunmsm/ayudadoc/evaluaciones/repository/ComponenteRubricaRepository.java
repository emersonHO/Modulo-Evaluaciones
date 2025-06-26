package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteRubrica;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponenteRubricaRepository extends ReactiveCrudRepository<ComponenteRubrica, Integer> {}