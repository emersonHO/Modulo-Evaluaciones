package com.fisiunmsm.ayudadoc.evaluaciones.handler;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.service.ComponenteCompetenciaService;
import com.fisiunmsm.ayudadoc.evaluaciones.dto.ComponenteCompetenciaDetalleDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.dto.ComponenteConCompetenciasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.util.Map;
import java.util.List;

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
                                                comp.setPeso(0.0);
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

        public Mono<ServerResponse> deleteByComponente(ServerRequest request) {
                String componente = request.pathVariable("componente");
                return service.deleteByComponente(componente)
                                .then(ServerResponse.noContent().build());
        }

        /*
         * public Mono<ServerResponse> findByCursocompetenciaid(ServerRequest request) {
         * Integer cursocompetenciaid =
         * Integer.valueOf(request.pathVariable("cursocompetenciaid"));
         * return ServerResponse.ok()
         * .contentType(MediaType.APPLICATION_JSON)
         * .body(service.findByCursocompetenciaid(cursocompetenciaid),
         * ComponenteCompetencia.class);
         * }
         */

        public Mono<ServerResponse> findAllDetalles(ServerRequest request) {
                return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(service.findAllDetalles(), ComponenteCompetenciaDetalleDTO.class);
        }

        public Mono<ServerResponse> findAllComponentesConCompetencias(ServerRequest request) {
                return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(service.findComponentesConCompetencias(), ComponenteConCompetenciasDTO.class);
        }

        public Mono<ServerResponse> findAllComponentesConPeso(ServerRequest request) {
                return ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(service.findAllComponentesConPeso(),
                                                com.fisiunmsm.ayudadoc.evaluaciones.dto.ComponenteSimpleDTO.class);
        }
}