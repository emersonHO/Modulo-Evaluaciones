package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.RubricaRequestDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.service.RubricaService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RubricaHandler {

    private final RubricaService rubricaService;

    public Mono<ServerResponse> guardarRubrica(ServerRequest request) {
        return request.bodyToMono(RubricaRequestDTO.class)
                .flatMap(rubricaService::guardarRubricaCompleta)
                .flatMap(saved -> ServerResponse.ok().bodyValue(saved));
    }
}