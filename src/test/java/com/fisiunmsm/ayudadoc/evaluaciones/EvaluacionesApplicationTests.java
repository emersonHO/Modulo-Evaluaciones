package com.fisiunmsm.ayudadoc.evaluaciones;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Competencia;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CompetenciaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CompetenciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class CompetenciaServiceTest {

	private CompetenciaRepository competenciaRepository;
	private CompetenciaService competenciaService;

	@BeforeEach
	void setUp() {
		competenciaRepository = mock(CompetenciaRepository.class);
		competenciaService = new CompetenciaService();
		// Usamos reflexión o setter si no hay constructor (alternativa: usa @InjectMocks con @Mock)
		var field = Arrays.stream(competenciaService.getClass().getDeclaredFields())
				.filter(f -> f.getName().equals("competenciaRepository"))
				.findFirst().orElseThrow();
		field.setAccessible(true);
		try {
			field.set(competenciaService, competenciaRepository);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	void testFindAll() {
		// Arrange
		Competencia c1 = new Competencia();
		c1.setId(1);
		c1.setNombre("Comunicación");

		Competencia c2 = new Competencia();
		c2.setId(2);
		c2.setNombre("Trabajo en equipo");

		when(competenciaRepository.findAll()).thenReturn(Flux.just(c1, c2));

		// Act & Assert
		StepVerifier.create(competenciaService.findAll())
				.expectNext(c1)
				.expectNext(c2)
				.verifyComplete();

		verify(competenciaRepository, times(1)).findAll();
	}
}
