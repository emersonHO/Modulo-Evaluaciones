package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.PromedioHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class PromedioRouter {

    @Bean
    public RouterFunction<?> promedioRoutes(PromedioHandler handler) {
        return route(GET("/api/promedio/competencia"), handler::obtenerPromedioPorCompetencia);
    }
}
