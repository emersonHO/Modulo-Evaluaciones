package com.fisiunmsm.ayudadoc.evaluaciones.service;

import org.springframework.stereotype.Service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Funcion;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.FuncionRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FuncionService {
    private final FuncionRepository funcionRepository;

    public Flux<Funcion> getAll(){
        return funcionRepository.findAll();
    }

    public Mono<Funcion> getById(int id){
        return funcionRepository.findById(id);
    }

    public Mono<Funcion> save(Funcion funcion){
        return funcionRepository.save(funcion);
    }

    public Mono<Funcion> update(int id, Funcion funcion){
        return funcionRepository.save(new Funcion(id, funcion.getNombre(), funcion.getEstado(), 
        funcion.getFunsql(), funcion.getDescripcion()));
    }
    
    public Mono<Void> delete(int id){
        return funcionRepository.deleteById(id);
    } 
}

