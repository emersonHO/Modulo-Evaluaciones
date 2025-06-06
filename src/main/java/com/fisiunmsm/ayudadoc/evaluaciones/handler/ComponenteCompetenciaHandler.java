package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteSimple;
import com.fisiunmsm.ayudadoc.evaluaciones.service.ComponenteCompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.util.Map;

@Component
public class ComponenteCompetenciaHandler {
        @Autowired
        private ComponenteCompetenciaService service;

        public Mono<ServerResponse> findAll(ServerRequest request) {
                return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(service.findAll(), ComponenteCompetencia.class);
        }

        public Mono<ServerResponse> findById(ServerRequest request) {
                Integer id = Integer.valueOf(request.pathVariable("id"));
                return service.findById(id)
                                .flatMap(componente -> ServerResponse.ok()
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .bodyValue(componente))
                                .switchIfEmpty(ServerResponse.notFound().build());
        }

        public Mono<ServerResponse> save(ServerRequest request) {
                return request.bodyToMono(Map.class)
                                .flatMap(body -> {
                                        ComponenteCompetencia comp = new ComponenteCompetencia();

                                        // Obtener el ID del componente
                                        Object componenteId = body.get("componenteId");
                                        if (componenteId instanceof Number) {
                                                comp.setCursocomponenteid(((Number) componenteId).longValue());
                                        } else if (componenteId instanceof String) {
                                                comp.setCursocomponenteid(Long.parseLong((String) componenteId));
                                        }

                                        // Obtener el ID de la competencia
                                        Object competenciaId = body.get("competenciaId");
                                        if (competenciaId instanceof Number) {
                                                comp.setCursocompetenciaid(((Number) competenciaId).intValue());
                                        } else if (competenciaId instanceof String) {
                                                comp.setCursocompetenciaid(Integer.parseInt((String) competenciaId));
                                        }

                                        // Obtener el peso
                                        Object pesoObj = body.get("peso");
                                        if (pesoObj instanceof Number) {
                                                comp.setPeso(((Number) pesoObj).doubleValue());
                                        } else if (pesoObj instanceof String) {
                                                comp.setPeso(Double.parseDouble((String) pesoObj));
                                        } else {
                                                comp.setPeso(null);
                                        }

                                        return service.save(comp);
                                })
                                .flatMap(saved -> ServerResponse.ok()
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .bodyValue(saved))
                                .onErrorResume(e -> ServerResponse.badRequest()
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .bodyValue(Map.of("error", e.getMessage())));
        }

        public Mono<ServerResponse> update(ServerRequest request) {
                Integer id = Integer.valueOf(request.pathVariable("id"));
                return request.bodyToMono(Map.class)
                                .flatMap(body -> {
                                        ComponenteCompetencia comp = new ComponenteCompetencia();
                                        comp.setId(id);

                                        // Obtener el ID del componente
                                        Object componenteId = body.get("componenteId");
                                        if (componenteId instanceof Number) {
                                                comp.setCursocomponenteid(((Number) componenteId).longValue());
                                        } else if (componenteId instanceof String) {
                                                comp.setCursocomponenteid(Long.parseLong((String) componenteId));
                                        }

                                        // Obtener el ID de la competencia
                                        Object competenciaId = body.get("competenciaId");
                                        if (competenciaId instanceof Number) {
                                                comp.setCursocompetenciaid(((Number) competenciaId).intValue());
                                        } else if (competenciaId instanceof String) {
                                                comp.setCursocompetenciaid(Integer.parseInt((String) competenciaId));
                                        }

                                        // Obtener el peso
                                        Object pesoObj = body.get("peso");
                                        if (pesoObj instanceof Number) {
                                                comp.setPeso(((Number) pesoObj).doubleValue());
                                        } else if (pesoObj instanceof String) {
                                                comp.setPeso(Double.parseDouble((String) pesoObj));
                                        } else {
                                                comp.setPeso(0.0);
                                        }

                                        return service.update(id, comp);
                                })
                                .flatMap(updated -> ServerResponse.ok()
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .bodyValue(updated))
                                .switchIfEmpty(ServerResponse.notFound().build());
        }

        public Mono<ServerResponse> delete(ServerRequest request) {
                Integer id = Integer.valueOf(request.pathVariable("id"));
                return service.deleteById(id)
                                .then(ServerResponse.noContent().build());
        }

        public Mono<ServerResponse> findAllDetalles(ServerRequest request) {
                return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(service.findAllDetalles(), ComponenteCompetencia.class);
        }

        public Mono<ServerResponse> findAllComponentesConCompetencias(ServerRequest request) {
                return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(service.findComponentesConCompetencias(), ComponenteCompetencia.class);
        }

        public Mono<ServerResponse> findAllComponentesConPeso(ServerRequest request) {
                return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(service.findAllComponentesConPeso(), ComponenteSimple.class);
        }

        public Mono<ServerResponse> findComponentesNoAsociados(ServerRequest request) {
                return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(service.findComponentesNoAsociados(), ComponenteSimple.class);
        }

        public Mono<ServerResponse> deleteByComponenteId(ServerRequest request) {
                Long componenteId = Long.valueOf(request.pathVariable("componenteId"));
                return service.deleteByCursocomponenteid(componenteId)
                                .then(ServerResponse.noContent().build());
        }

        public Mono<ServerResponse> findCompetenciasByComponente(ServerRequest request) {
                try {
                        Long componenteId = Long.valueOf(request.pathVariable("componenteId"));
                        return service.findCompetenciasByComponente(componenteId)
                                        .collectList()
                                        .flatMap(competencias -> ServerResponse.ok()
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .bodyValue(competencias))
                                        .switchIfEmpty(ServerResponse.notFound().build())
                                        .onErrorResume(error -> {
                                                System.err.println("Error en findCompetenciasByComponente handler: "
                                                                + error.getMessage());
                                                error.printStackTrace();
                                                return ServerResponse.status(500)
                                                                .contentType(MediaType.APPLICATION_JSON)
                                                                .bodyValue(Map.of("error",
                                                                                "Error al obtener competencias: "
                                                                                                + error.getMessage()));
                                        });
                } catch (NumberFormatException e) {
                        return ServerResponse.badRequest()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(Map.of("error", "ID de componente inválido"));
                } catch (Exception e) {
                        System.err.println(
                                        "Error inesperado en findCompetenciasByComponente handler: " + e.getMessage());
                        e.printStackTrace();
                        return ServerResponse.status(500)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(Map.of("error", "Error interno del servidor: " + e.getMessage()));
                }
        }
}