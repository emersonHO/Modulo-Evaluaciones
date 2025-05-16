package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.CriterioRubricaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CriterioRubricaRouter {

    @Bean
    public RouterFunction<ServerResponse> criterioRubricaRoutes(CriterioRubricaHandler criterioRubricaHandler) {
        return route()
                .path("/rubricas/{rubricaId}/criterios", builder -> builder
                        .POST(criterioRubricaHandler::save)  // Crear un nuevo criterio
                        .GET(criterioRubricaHandler::findByRubricaId))  // Obtener criterios de una rúbrica
                .path("/criterios/{id}", builder -> builder
                        .PUT(criterioRubricaHandler::update)  // Actualizar un criterio
                        .DELETE(criterioRubricaHandler::delete))  // Eliminar un criterio
                .build();
    }
}
