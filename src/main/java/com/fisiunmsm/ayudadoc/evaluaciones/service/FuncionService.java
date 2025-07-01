package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Funcion;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.FuncionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class FuncionService {
    private final FuncionRepository funcionRepository;

    public Flux<Funcion> getAll() {
        log.info("Obteniendo todas las funciones");
        return funcionRepository.findAll();
    }

    public Mono<Funcion> getById(int id) {
        log.info("Buscando funcion con ID: {}", id);
        return funcionRepository.findById(id)
            .doOnSuccess(f -> {
                if (f == null) log.warn("No se encontro funcion con ID: {}", id);
            });
    }

    public Mono<Funcion> save(Funcion funcion) {
        log.info("Guardando funcion: {}", funcion.getNombre());
        return funcionRepository.save(funcion)
            .doOnSuccess(f -> log.debug("Funcion guardada con ID: {}", f.getId()));
    }

    public Mono<Funcion> update(int id, Funcion funcion) {
        log.info("Actualizando funcion con ID: {}", id);
        return funcionRepository.save(new Funcion(id, funcion.getNombre(), funcion.getEstado(),
            funcion.getFunsql(), funcion.getDescripcion()))
            .doOnSuccess(f -> log.debug("Funcion actualizada: {}", f.getNombre()));
    }

    public Mono<Void> delete(int id) {
        log.warn("Eliminando funcion con ID: {}", id);
        return funcionRepository.deleteById(id);
    }
}
