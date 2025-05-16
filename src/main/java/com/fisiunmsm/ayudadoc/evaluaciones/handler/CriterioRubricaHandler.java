package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CriterioRubricaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
@RequiredArgsConstructor
public class CriterioRubricaHandler {
    private final CriterioRubricaService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().body(service.getAll(), CriterioRubrica.class);
    }

    public Mono<ServerResponse> findByRubricaId(ServerRequest request) {
        int rubricaId = Integer.parseInt(request.pathVariable("rubricaId"));
        return ok().body(service.getByRubricaId(rubricaId), CriterioRubrica.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(CriterioRubrica.class)
                .flatMap(service::save)
                .flatMap(r -> ok().bodyValue(r));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return request.bodyToMono(CriterioRubrica.class)
                .flatMap(cr -> service.update(id, cr))
                .flatMap(updated -> ok().bodyValue(updated));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return service.delete(id).then(noContent().build());
    }
}
