package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.TreeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TreeRouter {
    @Bean
    public RouterFunction<ServerResponse> treeRoutes(TreeHandler handler) {
        return route()
            .GET("/api/competencias-componentes-formulas", handler::getTree)
            .build();
    }
}