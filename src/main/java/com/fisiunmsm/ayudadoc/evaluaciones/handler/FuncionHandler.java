package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Funcion;
import com.fisiunmsm.ayudadoc.evaluaciones.service.FuncionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class FuncionHandler {

    private final FuncionService funcionService;

    public Mono<ServerResponse> getAll(ServerRequest request){
        log.info("GET /funciones desde IP: {}", request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        Flux<Funcion> funciones= funcionService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funciones, Funcion.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request){
        int id= Integer.parseInt(request.pathVariable("id"));
        log.info("GET /funciones/{} desde IP: {}", id, request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        Mono<Funcion> funcion= funcionService.getById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funcion, Funcion.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        log.info("POST /funciones desde IP: {}", request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        Mono<Funcion> funcion= request.bodyToMono(Funcion.class);
        return funcion.flatMap(f -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funcionService.save(f), Funcion.class));
    }

    public Mono<ServerResponse> update(ServerRequest request){
        int id= Integer.parseInt(request.pathVariable("id"));
        log.info("PUT /funciones/{} desde IP: {}", id, request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        Mono<Funcion> funcion= request.bodyToMono(Funcion.class);
        return funcion.flatMap(f -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funcionService.update(id, f), Funcion.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        int id= Integer.parseInt(request.pathVariable("id"));
        log.warn("DELETE /funciones/{} desde IP: {}", id, request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(funcionService.delete(id), Funcion.class);
    }
}
