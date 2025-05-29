package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.ComponenteCompetenciaHandler;
import com.fisiunmsm.ayudadoc.evaluaciones.handler.CompetenciaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ComponenteCompetenciaRouter {
        private static final String PATH = "/api/componente-competencia";

        @Bean
        public RouterFunction<ServerResponse> componenteCompetenciaRoutes(ComponenteCompetenciaHandler handler,
                        CompetenciaHandler competenciaHandler) {
                return RouterFunctions.route(GET(PATH), handler::findAll)
                                .andRoute(GET(PATH + "/{id}"), handler::findById)
                                .andRoute(POST(PATH), handler::save)
                                .andRoute(PUT(PATH + "/{id}"), handler::update)
                                .andRoute(DELETE(PATH + "/{id}"), handler::delete)
                                .andRoute(GET("/api/componente-competencia-detalle"), handler::findAllDetalles)
                                .andRoute(GET("/api/componente-competencia-con-competencias"),
                                                handler::findAllComponentesConCompetencias)
                                .andRoute(GET("/api/componentes-con-peso"), handler::findAllComponentesConPeso)
                                .andRoute(GET("/api/competencias"), competenciaHandler::findAll)
                                .andRoute(DELETE("/api/componente-competencia/by-componente/{componente}"),
                                                handler::deleteByComponente)
                                .andRoute(GET("/api/componentes-no-asociados"), handler::findComponentesNoAsociados);
        }
}