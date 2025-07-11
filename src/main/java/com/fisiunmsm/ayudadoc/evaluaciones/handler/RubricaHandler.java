package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.RubricaRequestDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.service.RubricaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class RubricaHandler {

    private final RubricaService rubricaService;

    public Mono<ServerResponse> guardarRubrica(ServerRequest request) {
        log.info("POST /rubricas desde IP: {}", request.remoteAddress().map(addr -> addr.getAddress().getHostAddress()).orElse("Desconocida"));
        return request.bodyToMono(RubricaRequestDTO.class)
                .flatMap(rubricaService::guardarRubricaCompleta)
                .flatMap(saved -> ServerResponse.ok().bodyValue(saved));
    }
    public Mono<ServerResponse> obtenerRubricas(ServerRequest request) {
        return rubricaService.obtenerRubricas()
            .collectList()
            .flatMap(rubricas -> ServerResponse.ok().bodyValue(rubricas));
    }
}
