package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Rubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.RubricaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RubricaService {
    private final RubricaRepository rubricaRepository;

    public Flux<Rubrica> getAll(){
        return rubricaRepository.findAll();
    }

    public Mono<Rubrica> getById(int id){
        return rubricaRepository.findById(id);
    }

    public Mono<Rubrica> save(Rubrica rubrica){
        return rubricaRepository.save(rubrica);
    }

    public Mono<Rubrica> update(int id, Rubrica rubrica) {
        return rubricaRepository.save(new Rubrica(
                id,
                rubrica.getNombre(),
                rubrica.getDescripcion(),
                rubrica.getEstado()
        ));
    }

    public Mono<Void> delete(int id) {
        return rubricaRepository.deleteById(id);
    }
}
