package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;
import com.fisiunmsm.ayudadoc.evaluaciones.service.NivelCriterioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class NivelCriterioHandler {
    private final NivelCriterioService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        log.info("GET /nivelcriterio desde IP: {}", request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        return ok().body(service.getAll(), NivelCriterio.class);
    }

    public Mono<ServerResponse> findByCriterioId(ServerRequest request) {
        int criterioId = Integer.parseInt(request.pathVariable("criterioId"));
        log.info("GET /nivelcriterio/{} desde IP: {}", criterioId, request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        return ok().body(service.getByCriterioId(criterioId), NivelCriterio.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        log.info("POST /nivelcriterio desde IP: {}", request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        return request.bodyToMono(NivelCriterio.class)
                .flatMap(service::save)
                .flatMap(nc -> ok().bodyValue(nc));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        log.warn("DELETE /nivelcriterio/{} desde IP: {}", id, request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        return service.delete(id).then(noContent().build());
    }
}
