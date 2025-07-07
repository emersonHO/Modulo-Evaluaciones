package com.fisiunmsm.ayudadoc.evaluaciones.router;
import com.fisiunmsm.ayudadoc.evaluaciones.handler.NotasHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class NotasRouter {
    @Bean
    public RouterFunction<ServerResponse> notasRoutes(NotasHandler handler) {
        return route(GET("/api/notas/top/{cursoId}/{componenteId}"), handler::handleTopNotas);
    }
}
