package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;

import reactor.core.publisher.Flux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelCriterioRepository extends ReactiveCrudRepository<NivelCriterio, Integer> {

    Flux<NivelCriterio> findByCriterioid(int criterioid);}