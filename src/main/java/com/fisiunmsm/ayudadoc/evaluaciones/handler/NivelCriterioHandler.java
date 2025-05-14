package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;
import com.fisiunmsm.ayudadoc.evaluaciones.service.NivelCriterioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class NivelCriterioHandler {

    private final NivelCriterioService nivelCriterioService;

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<NivelCriterio> nivelCriterio = request.bodyToMono(NivelCriterio.class);
        return nivelCriterio.flatMap(nc -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(nivelCriterioService.save(nc), NivelCriterio.class));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<NivelCriterio> nivelCriterio = request.bodyToMono(NivelCriterio.class);
        return nivelCriterio.flatMap(nc -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(nivelCriterioService.update(id, nc), NivelCriterio.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(nivelCriterioService.delete(id), Void.class);
    }
}