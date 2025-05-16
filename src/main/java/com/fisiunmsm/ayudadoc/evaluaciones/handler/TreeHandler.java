package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class TreeHandler {
    private final TreeService treeService;

    public Mono<ServerResponse> getTree(ServerRequest request) {
        return ok().body(treeService.getCompetenciasComponentesFormulas(), Object.class);
    }
}