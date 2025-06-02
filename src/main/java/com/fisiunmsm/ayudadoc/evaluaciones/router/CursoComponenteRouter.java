package com.fisiunmsm.ayudadoc.evaluaciones.router;

import com.fisiunmsm.ayudadoc.evaluaciones.handler.CursoComponenteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CursoComponenteRouter {
    private static final String PATH = "/api/componentes";
    private static final String PATH_WITHOUT_API = "/componentes";

    @Bean
    public RouterFunction<ServerResponse> cursoComponenteRoutes(CursoComponenteHandler handler) {
        return RouterFunctions.route()
                // Rutas con prefijo /api
                .GET(PATH, handler::findAll)
                .GET(PATH + "/cursos/{cursoId}", handler::findByCursoId)
                .POST(PATH, handler::save)
                .PUT(PATH + "/{id}", handler::update)
                .DELETE(PATH + "/{id}", handler::delete)
                .GET(PATH + "/unicos", handler::findDistinctCodigoDescripcionPeso)
                
                // Rutas sin prefijo /api para compatibilidad
                .GET(PATH_WITHOUT_API, handler::findAll)
                .GET(PATH_WITHOUT_API + "/cursos/{cursoId}", handler::findByCursoId)
                .POST(PATH_WITHOUT_API, handler::save)
                .PUT(PATH_WITHOUT_API + "/{id}", handler::update)
                .DELETE(PATH_WITHOUT_API + "/{id}", handler::delete)
                .GET(PATH_WITHOUT_API + "/unicos", handler::findDistinctCodigoDescripcionPeso)
                .build();
    }
}
