package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Funcion;
import com.fisiunmsm.ayudadoc.evaluaciones.service.FuncionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FuncionHandler {
    
    private final FuncionService funcionService;

    public Mono<ServerResponse> getAll(ServerRequest request){
        Flux<Funcion> funciones= funcionService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funciones, Funcion.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request){
        int id= Integer.valueOf(request.pathVariable("id"));
        Mono<Funcion> funcion= funcionService.getById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funcion, Funcion.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        Mono<Funcion> funcion= request.bodyToMono(Funcion.class);
        return funcion.flatMap(f -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funcionService.save(f), Funcion.class));
    }

    public Mono<ServerResponse> update(ServerRequest request){
        int id= Integer.valueOf(request.pathVariable("id"));
        Mono<Funcion> funcion= request.bodyToMono(Funcion.class);
        return funcion.flatMap(f -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funcionService.update(id, f), Funcion.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        int id= Integer.valueOf(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funcionService.delete(id), Funcion.class);
    }
}
