package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.CursoComponenteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CursoComponenteRouter {
    private static final String PATH = "/api/componente";
    @Bean
    public RouterFunction<ServerResponse> cursoComponenteRoutes(CursoComponenteHandler handler) {
        return route()

                .GET("/componente", handler::findAll)
                .GET("/cursos/{cursoId}/componente", handler::findByCursoId)
                .POST("/componente", handler::save)
                .PUT("/componente/{id}", handler::update)
                .DELETE("/componente/{id}", handler::delete)

                .build();
    }
}
