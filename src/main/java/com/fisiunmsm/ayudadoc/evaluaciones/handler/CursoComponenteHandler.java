package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CursoComponenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
@RequiredArgsConstructor
public class CursoComponenteHandler {

    private final CursoComponenteService service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().body(service.getAll(), CursoComponente.class);
    }

    public Mono<ServerResponse> findByCursoId(ServerRequest request) {
        int cursoId = Integer.parseInt(request.pathVariable("cursoId"));
        return ok().body(service.getByCursoId(cursoId), CursoComponente.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(CursoComponente.class)
                .flatMap(service::save)
                .flatMap(saved -> ok().bodyValue(saved));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        return request.bodyToMono(CursoComponente.class)
                .flatMap(cc -> service.update(id, cc))
                .flatMap(updated -> ok().bodyValue(updated));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        return service.delete(id).then(noContent().build());
    }

    public Mono<ServerResponse> findDistinctCodigoDescripcionPeso(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getDistinctCodigoDescripcionPeso(), CursoComponente.class);
    }
}
