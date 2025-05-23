package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.RubricaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RubricaRouter {

    @Bean
    public RouterFunction<ServerResponse> rubricaRoutes(RubricaHandler rubricaHandler) {
        return route()
                .path("/rubricas", builder -> builder
                        .POST(rubricaHandler::save)  // Crear una nueva rúbrica
                        .GET(rubricaHandler::findAll))  // Obtener todas las rúbricas
                .path("/rubricas/{id}", builder -> builder
                        .GET(rubricaHandler::findById)  // Obtener rúbrica por ID
                        .PUT(rubricaHandler::update)  // Actualizar una rúbrica existente
                        .DELETE(rubricaHandler::delete))  // Eliminar una rúbrica
                .build();
    }
}
