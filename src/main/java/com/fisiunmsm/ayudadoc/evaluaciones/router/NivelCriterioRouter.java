package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.NivelCriterioHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class NivelCriterioRouter {

    @Bean
    public RouterFunction<ServerResponse> nivelCriterioRoutes(NivelCriterioHandler nivelCriterioHandler) {
        return route()
                .path("/criterios/{criterioId}/niveles", builder -> builder
                        .GET(nivelCriterioHandler::findByCriterioId)  // Obtener niveles de un criterio
                        .POST(nivelCriterioHandler::save))  // Crear un nuevo nivel para un criterio
                /*
                .path("/niveles/{id}", builder -> builder
                        .PUT(nivelCriterioHandler::update)  // Actualizar un nivel
                        .DELETE(nivelCriterioHandler::delete))  // Eliminar un nivel
                */
                .build();
    }
}
