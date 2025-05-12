package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CriterioRubricaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CriterioRubricaHandler {

    private final CriterioRubricaService criterioRubricaService;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<CriterioRubrica> criterios = criterioRubricaService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(criterios, CriterioRubrica.class);
    }

    public Mono<ServerResponse> getByRubricaId(ServerRequest request) {
        int rubricaid = Integer.parseInt(request.pathVariable("rubricaid"));
        Flux<CriterioRubrica> criterios = criterioRubricaService.getByRubricaId(rubricaid);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(criterios, CriterioRubrica.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<CriterioRubrica> criterio = request.bodyToMono(CriterioRubrica.class);
        return criterio.flatMap(c -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(criterioRubricaService.save(c), CriterioRubrica.class));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<CriterioRubrica> criterio = request.bodyToMono(CriterioRubrica.class);
        return criterio.flatMap(c -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(criterioRubricaService.update(id, c), CriterioRubrica.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(criterioRubricaService.delete(id), Void.class);
    }
}
