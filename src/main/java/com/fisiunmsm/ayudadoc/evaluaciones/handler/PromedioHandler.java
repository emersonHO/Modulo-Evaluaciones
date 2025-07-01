package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.PromedioCompetenciaDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.NotasRepository;

import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class PromedioHandler {

    private final NotasRepository notasRepository;

    public PromedioHandler(NotasRepository notasRepository) {
        this.notasRepository = notasRepository;
    }

    public Mono<ServerResponse> obtenerPromedioPorCompetencia(ServerRequest request) {
        int alumnoId = Integer.parseInt(request.queryParam("alumnoid").orElseThrow());
        int cursoId = Integer.parseInt(request.queryParam("cursoid").orElseThrow());

        return ServerResponse.ok()
            .body(
                notasRepository.obtenerPromedioPorCompetencia(alumnoId, cursoId),
                PromedioCompetenciaDTO.class
            );
    }
}
