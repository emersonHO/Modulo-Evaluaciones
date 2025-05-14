package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.RubricaCursoComponente;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.RubricaCursoComponenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RubricaCursoComponenteService {
    private final RubricaCursoComponenteRepository repository;

    public Flux<RubricaCursoComponente> getByComponenteId(int componenteid) {
        return repository.findByCursoComponenteId(componenteid);
    }

    public Flux<RubricaCursoComponente> getByRubricaId(int rubricaId) {
        return repository.findByRubricaId(rubricaId);
    }
    
    public Mono<RubricaCursoComponente> save(RubricaCursoComponente entity) {
        return repository.save(entity);
    }

    public Mono<Void> delete(int id) {
        return repository.deleteById(id);
    }
}