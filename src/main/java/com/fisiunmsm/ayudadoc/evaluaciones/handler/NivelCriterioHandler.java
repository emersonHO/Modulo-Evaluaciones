package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;
import com.fisiunmsm.ayudadoc.evaluaciones.service.NivelCriterioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
@RequiredArgsConstructor
public class NivelCriterioHandler {
    private final NivelCriterioService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().body(service.getAll(), NivelCriterio.class);
    }

    public Mono<ServerResponse> findByCriterioId(ServerRequest request) {
        int criterioId = Integer.parseInt(request.pathVariable("criterioId"));
        return ok().body(service.getByCriterioId(criterioId), NivelCriterio.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(NivelCriterio.class)
                .flatMap(service::save)
                .flatMap(nc -> ok().bodyValue(nc));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return request.bodyToMono(NivelCriterio.class)
                .flatMap(nc -> service.update(id, nc))
                .flatMap(updated -> ok().bodyValue(updated));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return service.delete(id).then(noContent().build());
    }
}
