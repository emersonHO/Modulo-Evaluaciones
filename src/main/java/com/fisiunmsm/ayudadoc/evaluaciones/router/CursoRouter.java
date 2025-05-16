package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.CursoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CursoRouter {
    private static final String PATH = "/api-cur/v1/cursos";

    @Bean
    RouterFunction<ServerResponse> cursoRoutes(CursoHandler handler) {
        return RouterFunctions.route()
                .GET(PATH, handler::getAll)
                .GET(PATH + "/{id}", handler::getById)
                .GET(PATH + "/institucion-periodo", handler::getByInstitucionAndPeriodo)
                .POST(PATH, handler::save)
                .PUT(PATH + "/{id}", handler::update)
                .DELETE(PATH + "/{id}", handler::delete)
                .build();
    }
}