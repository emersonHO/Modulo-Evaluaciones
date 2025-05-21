package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.CursoComponenteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CursoComponenteRouter {
    private static final String PATH = "/api/componentes";
    @Bean
    public RouterFunction<ServerResponse> cursoComponenteRoutes(CursoComponenteHandler handler) {
        return route()

                .GET("/componentes", handler::findAll)
                .GET("/cursos/{cursoId}/componentes", handler::findByCursoId)
                .POST("/componentes", handler::save)
                .PUT("/componentes/{id}", handler::update)
                .DELETE("/componentes/{id}", handler::delete)

                .build();
    }
}
