package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.NivelCriterioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NivelCriterioService {
    private final NivelCriterioRepository nivelCriterioRepository;

    public Flux<NivelCriterio> getAll(){
        return nivelCriterioRepository.findAll();
    }

    public Flux<NivelCriterio> getByCriterioId(int criterioid){
        return nivelCriterioRepository.findByCriterioRubricaId(criterioid);
    }

    public Mono<NivelCriterio> save(NivelCriterio nivel){
        return nivelCriterioRepository.save(nivel);
    }

    public Mono<NivelCriterio> update(int id, NivelCriterio nivel) {
        return nivelCriterioRepository.save(
                new NivelCriterio(
                        id, nivel.getDescripcion(), nivel.getNivel(),
                        nivel.getPuntaje(), nivel.getCriterioid()
                )
        );
    }

    public Mono<Void> delete(int id){
        return nivelCriterioRepository.deleteById(id);
    }
}