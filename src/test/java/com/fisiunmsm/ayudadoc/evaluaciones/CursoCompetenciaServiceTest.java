package com.fisiunmsm.ayudadoc.evaluaciones;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CursoComponenteRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CursoComponenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class CursoComponenteServiceTest {

    private CursoComponenteRepository cursoComponenteRepository;
    private CursoComponenteService cursoComponenteService;

    @BeforeEach
    void setUp() {
        cursoComponenteRepository = mock(CursoComponenteRepository.class);
        cursoComponenteService = new CursoComponenteService(cursoComponenteRepository);

        cursoComponenteRepository = mock(CursoComponenteRepository.class);
        cursoComponenteService = new CursoComponenteService(cursoComponenteRepository);
    }

    @Test
    void testSave() {
        CursoComponente componente = new CursoComponente();
        componente.setCodigo("C001");
        componente.setDescripcion("Examen Parcial");
        componente.setPeso(30F);
        componente.setCursoid(101);

        // Simulamos que el repositorio retorna el mismo objeto con ID generado
        CursoComponente saved = new CursoComponente();
        saved.setId(1L);
        saved.setCodigo("C001");
        saved.setDescripcion("Examen Parcial");
        saved.setPeso(30F);
        saved.setCursoid(101);

        when(cursoComponenteRepository.save(componente)).thenReturn(Mono.just(saved));

        StepVerifier.create(cursoComponenteService.save(componente))
                .expectNextMatches(result ->
                        result.getId().equals(1L) &&
                                result.getCodigo().equals("C001") &&
                                result.getPeso() == 30.0
                )
                .verifyComplete();

        verify(cursoComponenteRepository, times(1)).save(componente);
    }

    @Test
    void testGetAll() {
        CursoComponente c1 = new CursoComponente();
        c1.setId(1L);
        c1.setCodigo("C001");
        c1.setDescripcion("Examen Parcial");

        CursoComponente c2 = new CursoComponente();
        c2.setId(2L);
        c2.setCodigo("C002");
        c2.setDescripcion("Proyecto Final");

        when(cursoComponenteRepository.findAll()).thenReturn(Flux.just(c1, c2));

        StepVerifier.create(cursoComponenteService.getAll())
                .expectNext(c1)
                .expectNext(c2)
                .verifyComplete();

        verify(cursoComponenteRepository, times(1)).findAll();
    }
}
