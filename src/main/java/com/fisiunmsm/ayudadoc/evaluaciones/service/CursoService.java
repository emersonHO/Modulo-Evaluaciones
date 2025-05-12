package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Curso;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CursoService {
    private final CursoRepository cursoRepository;

    public Flux<Curso> getAll() {
        return cursoRepository.findAll();
    }

    public Mono<Curso> getById(Integer id) {
        return cursoRepository.findById(id);
    }

    public Flux<Curso> getByInstitucionAndPeriodo(Integer institucionId, Integer periodoId) {
        return cursoRepository.findByInstitucionIdAndPeriodoId(institucionId, periodoId);
    }

    public Mono<Curso> save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Mono<Curso> update(Integer id, Curso curso) {
        return cursoRepository.findById(id)
                .flatMap(existing -> {
                    curso.setId(id);
                    return cursoRepository.save(curso);
                });
    }

    public Mono<Void> delete(Integer id) {
        return cursoRepository.deleteById(id);
    }
}