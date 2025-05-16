package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Curso;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CursoHandler {
    private final CursoService cursoService;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cursoService.getAll(), Curso.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cursoService.getById(id), Curso.class);
    }

    public Mono<ServerResponse> getByInstitucionAndPeriodo(ServerRequest request) {
        Integer institucionId = Integer.valueOf(request.queryParam("institucionId").orElse("1"));
        Integer periodoId = Integer.valueOf(request.queryParam("periodoId").orElse("1"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cursoService.getByInstitucionAndPeriodo(institucionId, periodoId), Curso.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Curso.class)
                .flatMap(curso -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(cursoService.save(curso), Curso.class));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        return request.bodyToMono(Curso.class)
                .flatMap(curso -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(cursoService.update(id, curso), Curso.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cursoService.delete(id), Void.class);
    }
}