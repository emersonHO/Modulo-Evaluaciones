package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.NivelCriterioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class NivelCriterioService {
    private final NivelCriterioRepository nivelCriterioRepository;

    public Flux<NivelCriterio> getAll() {
        log.info("Obteniendo todos los niveles de criterio");
        return nivelCriterioRepository.findAll();
    }

    public Flux<NivelCriterio> getByCriterioId(int criterioid) {
        log.info("Obteniendo niveles para el criterio ID: {}", criterioid);
        return nivelCriterioRepository.findByCriterioid(criterioid);
    }

    public Mono<NivelCriterio> save(NivelCriterio nivel) {
        log.info("Guardando nivel: {}", nivel.getDescripcion());
        return nivelCriterioRepository.save(nivel)
            .doOnSuccess(n -> log.debug("Nivel guardado con ID: {}", n.getId()));
    }

    public Mono<Void> delete(int id) {
        log.warn("Eliminando nivel con ID: {}", id);
        return nivelCriterioRepository.deleteById(id);
    }
}
