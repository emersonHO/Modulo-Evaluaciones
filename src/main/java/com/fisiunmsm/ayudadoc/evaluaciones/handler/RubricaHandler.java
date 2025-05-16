package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Rubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.service.RubricaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
@RequiredArgsConstructor
public class RubricaHandler {
    private final RubricaService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().body(service.getAll(), Rubrica.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return service.getById(id)
                .flatMap(r -> ok().bodyValue(r))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Rubrica.class)
                .flatMap(service::save)
                .flatMap(r -> ok().bodyValue(r));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return request.bodyToMono(Rubrica.class)
                .flatMap(r -> service.update(id, r))
                .flatMap(updated -> ok().bodyValue(updated));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return service.delete(id).then(noContent().build());
    }
}
