package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.service.FormulaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FormulaHandler {
    
    private final FormulaService formulaService;

    public Mono<ServerResponse> getAll(ServerRequest request){
        Flux<Formula> formulas= formulaService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(formulas, Formula.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request){
        int id= Integer.valueOf(request.pathVariable("id"));
        Mono<Formula> formula= formulaService.getById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(formula, Formula.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        Mono<Formula> formula= request.bodyToMono(Formula.class);
        return formula.flatMap(f -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(formulaService.save(f), Formula.class));
    }

    public Mono<ServerResponse> update(ServerRequest request){
        int id= Integer.valueOf(request.pathVariable("id"));
        Mono<Formula> formula= request.bodyToMono(Formula.class);
        return formula.flatMap(f -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(formulaService.update(id, f), Formula.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        int id= Integer.valueOf(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(formulaService.delete(id), Formula.class);
    }
}
