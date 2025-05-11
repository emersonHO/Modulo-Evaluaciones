package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.ComponenteCompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ComponenteCompetenciaService {
    @Autowired
    private ComponenteCompetenciaRepository repository;

    public Flux<ComponenteCompetencia> findAll() {
        return repository.findAll();
    }

    public Mono<ComponenteCompetencia> findById(Integer id) {
        return repository.findById(id);
    }

    public Mono<ComponenteCompetencia> save(ComponenteCompetencia componente) {
        return repository.save(componente);
    }

    public Mono<ComponenteCompetencia> update(Integer id, ComponenteCompetencia componente) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setCursocompetenciaid(componente.getCursocompetenciaid());
                    existing.setCursocomponenteid(componente.getCursocomponenteid());
                    existing.setPeso(componente.getPeso());
                    return repository.save(existing);
                });
    }

    public Mono<Void> deleteById(Integer id) {
        return repository.deleteById(id);
    }

    public Flux<ComponenteCompetencia> findByCursocompetenciaid(Integer cursocompetenciaid) {
        return repository.findByCursocompetenciaid(cursocompetenciaid);
    }
}