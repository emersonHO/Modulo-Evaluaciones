package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.CompetenciaArbolHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CompetenciaArbolRouter {

    @Bean
    public RouterFunction<ServerResponse> competenciaArbolRoutes(CompetenciaArbolHandler handler) {
        return route()
                .GET("/api/competencias/{competenciaId}/arbol-componentes", handler::getArbol)
                .build();
    }
}