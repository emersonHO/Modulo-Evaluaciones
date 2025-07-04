package com.fisiunmsm.ayudadoc.evaluaciones;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.RubricaRequestDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Rubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.handler.RubricaHandler;
import com.fisiunmsm.ayudadoc.evaluaciones.service.RubricaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RubricaHandlerTest {

    private RubricaService rubricaService;
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        rubricaService = mock(RubricaService.class);
        RubricaHandler rubricaHandler = new RubricaHandler(rubricaService);

        RouterFunction<?> route = RouterFunctions
                .route()
                .POST("/rubricas", rubricaHandler::guardarRubrica)
                .build();

        webTestClient = WebTestClient.bindToRouterFunction(route).build();
    }

    @Test
    void testGuardarRubrica() {
        RubricaRequestDTO requestDTO = new RubricaRequestDTO();
        requestDTO.setNombre("Evaluación crítica");

        Rubrica savedRubrica = new Rubrica();
        savedRubrica.setId(1);
        savedRubrica.setNombre("Evaluación crítica");

        when(rubricaService.guardarRubricaCompleta(any())).thenReturn(Mono.just(savedRubrica));

        webTestClient.post()
                .uri("/rubricas")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestDTO)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.nombre").isEqualTo("Evaluación crítica");

        verify(rubricaService, times(1)).guardarRubricaCompleta(any());
    }
}
