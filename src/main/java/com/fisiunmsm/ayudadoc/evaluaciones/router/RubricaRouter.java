package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.RubricaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RubricaRouter {
    private static final String PATH = "/api/rubrica";

    @Bean
    RouterFunction<ServerResponse> router(RubricaHandler handler) {
        return RouterFunctions.route()
                .GET(PATH, handler::getAll)
                .GET(PATH + "/{id}", handler::getById)
                .POST(PATH, handler::save)
                .PUT(PATH + "/{id}", handler::update)
                .DELETE(PATH + "/{id}", handler::delete)
                .build();
    }
}
