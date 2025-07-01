package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.CursoComponenteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CursoComponenteRouter {

    @Bean
    public RouterFunction<ServerResponse> cursoComponenteRoutes(CursoComponenteHandler handler) {
        return route()
                // Obtener todos los componentes
                .GET("/componentes", handler::findAll)

                // Obtener componentes por ID de curso
                .GET("/cursos/{cursoId}/componentes", handler::findByCursoId)

                // Crear un nuevo componente
                .POST("/componentes", handler::save)

                // Actualizar un componente existente
                .PUT("/componentes/{id}", handler::update)

                // Eliminar un componente
                .DELETE("/componentes/{id}", handler::delete)

                // Obtener componentes únicos por id, descripcion y peso
                .GET("/componentes-unicos", handler::findDistinctCodigoDescripcionPeso)

                .build();
    }
}
