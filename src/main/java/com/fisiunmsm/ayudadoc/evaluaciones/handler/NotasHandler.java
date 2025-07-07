package com.fisiunmsm.ayudadoc.evaluaciones.handler;
import com.fisiunmsm.ayudadoc.evaluaciones.service.NotasService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class NotasHandler {
    private final NotasService notasService;

    public NotasHandler(NotasService notasService) {
        this.notasService = notasService;
    }

    public Mono<ServerResponse> handleTopNotas(ServerRequest request) {
        int cursoId = Integer.parseInt(request.pathVariable("cursoId"));
        int componenteId = Integer.parseInt(request.pathVariable("componenteId"));

        return notasService.obtenerTopNotasPorCursoYComponente(cursoId, componenteId)
            .collectList()
            .flatMap(lista ->
                lista.isEmpty()
                    ? ServerResponse.noContent().build()
                    : ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(lista)
            );
    }
}
