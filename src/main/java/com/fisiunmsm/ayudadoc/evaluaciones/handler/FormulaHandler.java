package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.service.FormulaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class FormulaHandler {

    private final FormulaService formulaService;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        logRequestDetails(request, "Obteniendo todas las fórmulas");
        Flux<Formula> formulas = formulaService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(formulas, Formula.class);
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        logRequestDetails(request, "Buscando fórmula con ID: " + id);
        Mono<Formula> formula = formulaService.getById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(formula, Formula.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        logRequestDetails(request, "Guardando fórmula desde body");
        Mono<Formula> formula = request.bodyToMono(Formula.class);
        return formula.flatMap(f -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(formulaService.save(f), Formula.class));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        logRequestDetails(request, "Actualizando fórmula con ID: " + id);
        Mono<Formula> formula = request.bodyToMono(Formula.class);
        return formula.flatMap(f -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(formulaService.update(id, f), Formula.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        logRequestDetails(request, "Eliminando fórmula con ID: " + id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(formulaService.delete(id), Formula.class);
    }

    private void logRequestDetails(ServerRequest request, String message) {
        String method = request.methodName();
        String path = request.path();
        String ip = request.remoteAddress().map(Object::toString).orElse("IP desconocida");
        log.info("Request {} {} desde {} - {}", method, path, ip, message);
    }
}
