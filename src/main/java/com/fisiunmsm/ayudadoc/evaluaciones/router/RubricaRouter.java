package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.RubricaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RubricaRouter {

    @Bean
    public RouterFunction<ServerResponse> rubricaRoutes(RubricaHandler handler) {
        return RouterFunctions.route()
                .POST("/api/rubricas", handler::guardarRubrica)
                .build();
    }
}