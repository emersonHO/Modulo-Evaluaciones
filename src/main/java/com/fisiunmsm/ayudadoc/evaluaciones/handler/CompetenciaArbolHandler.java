package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.service.CompetenciaArbolService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CompetenciaArbolHandler {

    private final CompetenciaArbolService competenciaArbolService;

    public CompetenciaArbolHandler(CompetenciaArbolService competenciaArbolService) {
        this.competenciaArbolService = competenciaArbolService;
    }

    public Mono<ServerResponse> getArbol(ServerRequest request) {
        Integer competenciaId = Integer.valueOf(request.pathVariable("competenciaId"));
        return competenciaArbolService.getArbolPorCompetencia(competenciaId)
                .flatMap(dto -> ServerResponse.ok().bodyValue(dto))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}