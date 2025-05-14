package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Rubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.service.RubricaService;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CriterioRubricaService;
import com.fisiunmsm.ayudadoc.evaluaciones.service.NivelCriterioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RubricaHandler {
    private final RubricaService rubricaService;
    private final CriterioRubricaService criterioRubricaService;
    private final NivelCriterioService nivelCriterioService;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<Rubrica> rubricas = rubricaService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(rubricas, Rubrica.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<Rubrica> rubrica = rubricaService.getById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(rubrica, Rubrica.class);
    }

    /*public Mono<ServerResponse> save(ServerRequest request) {         hay error aca xd
        Mono<Rubrica> rubrica = request.bodyToMono(Rubrica.class);
        return rubrica.flatMap(r -> {
            return rubricaService.save(r).flatMap(savedRubrica -> {
                Flux<CriterioRubrica> criterios = Flux.fromIterable(r.getCriteriosRubrica());
                return criterioRubricaService.save(criterios).then(Mono.just(savedRubrica));
            }).flatMap(savedRubrica ->
                    ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(savedRubrica)
            );
        });
    }*/

    public Mono<ServerResponse> update(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<Rubrica> rubrica = request.bodyToMono(Rubrica.class);
        return rubrica.flatMap(r -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(rubricaService.update(id, r), Rubrica.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(rubricaService.delete(id), Void.class);
    }
}
