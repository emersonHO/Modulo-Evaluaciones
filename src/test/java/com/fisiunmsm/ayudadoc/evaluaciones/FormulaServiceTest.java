package com.fisiunmsm.ayudadoc.evaluaciones;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.FormulaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.service.FormulaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class FormulaServiceTest {

    private FormulaRepository formulaRepository;
    private FormulaService formulaService;

    @BeforeEach
    void setUp() {
        formulaRepository = mock(FormulaRepository.class);
        formulaService = new FormulaService(formulaRepository);
    }

    @Test
    void testGetAll() {
        Formula f1 = new Formula();
        f1.setId(1);
        f1.setCodigo("F1");

        Formula f2 = new Formula();
        f2.setId(2);
        f2.setCodigo("F2");

        when(formulaRepository.findAll()).thenReturn(Flux.just(f1, f2));

        StepVerifier.create(formulaService.getAll())
                .expectNext(f1)
                .expectNext(f2)
                .verifyComplete();

        verify(formulaRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        Formula f = new Formula();
        f.setId(1);
        f.setCodigo("F1");

        when(formulaRepository.findById(1)).thenReturn(Mono.just(f));

        StepVerifier.create(formulaService.getById(1))
                .expectNext(f)
                .verifyComplete();

        verify(formulaRepository).findById(1);
    }

    @Test
    void testSave() {
        Formula f = new Formula();
        f.setId(1);
        f.setCodigo("F1");

        when(formulaRepository.save(f)).thenReturn(Mono.just(f));

        StepVerifier.create(formulaService.save(f))
                .expectNext(f)
                .verifyComplete();

        verify(formulaRepository).save(f);
    }

    @Test
    void testUpdate() {
        Formula f = new Formula();
        f.setCodigo("F1");

        Formula updated = new Formula(
                1, "FSP", "Suma ponderada", null, 1, "1", 1,
                1, 1, 1, 1, 1, 1,
                1, 1, 1, 2, 1
        );

        when(formulaRepository.save(any(Formula.class))).thenReturn(Mono.just(updated));

        StepVerifier.create(formulaService.update(1, f))
                .expectNext(updated)
                .verifyComplete();

        verify(formulaRepository).save(any(Formula.class));
    }

    @Test
    void testDelete() {
        when(formulaRepository.deleteById(1)).thenReturn(Mono.empty());

        StepVerifier.create(formulaService.delete(1))
                .verifyComplete();

        verify(formulaRepository).deleteById(1);
    }
}