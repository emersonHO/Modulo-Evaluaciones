package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.RubricaRequestDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.DTO.RubricaResponseDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Rubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RubricaService {

    private final RubricaRepository rubricaRepository;
    private final CriterioRubricaRepository criterioRepository;
    private final NivelCriterioRepository nivelRepository;
    private final ComponenteRubricaRepository componenteRubricaRepository;

    public Mono<Rubrica> guardarRubricaCompleta(RubricaRequestDTO dto) {
        log.info("Iniciando guardado de rubrica '{}'", dto.getNombre());

        Rubrica rubrica = new Rubrica(null, dto.getDescripcion(), dto.getEstado(), dto.getNombre());

        return rubricaRepository.save(rubrica)
            .doOnSuccess(saved -> log.debug("Rubrica guardada con ID: {}", saved.getId()))
            .flatMap(savedRubrica -> {
                ComponenteRubrica cr = new ComponenteRubrica(null, savedRubrica.getId(), dto.getComponenteid());
                Mono<ComponenteRubrica> guardarCR = componenteRubricaRepository.save(cr)
                    .doOnSuccess(saved -> log.debug("Componente asociado guardado, ID: {}", saved.getId()));

                Mono<Void> guardarCriteriosYNiveles = Flux.fromIterable(dto.getCriterios())
                    .flatMap(criterioDTO -> {
                        log.debug("Guardando criterio: {}", criterioDTO.getDescripcion());
                        CriterioRubrica criterio = new CriterioRubrica(null, criterioDTO.getDescripcion(), criterioDTO.getEstado(), savedRubrica.getId());

                        return criterioRepository.save(criterio)
                            .doOnSuccess(saved -> log.debug("Criterio guardado con ID: {}", saved.getId()))
                            .flatMapMany(savedCriterio -> {
                                List<NivelCriterio> niveles = criterioDTO.getNiveles().stream()
                                    .map(n -> new NivelCriterio(null, n.getDescripcion(), n.getPuntajemax(), savedCriterio.getId(), n.getTitulo()))
                                    .collect(Collectors.toList());

                                return nivelRepository.saveAll(niveles)
                                    .doOnNext(nivel -> log.debug("Nivel guardado: {}", nivel.getDescripcion()));
                            });
                    }).then();

                return guardarCR.then(guardarCriteriosYNiveles).thenReturn(savedRubrica);
            })
            .doOnSuccess(r -> log.info("Rubrica '{}' guardada exitosamente con ID: {}", r.getNombre(), r.getId()))
            .doOnError(e -> log.error("Error al guardar la rubrica: {}", e.getMessage(), e));
    }
    public Flux<RubricaResponseDTO> obtenerRubricas() {
        return rubricaRepository.findAll()
            .flatMap(rubrica -> {
                Mono<List<Long>> componentesMono = componenteRubricaRepository.findAll()
                    .filter(cr -> cr.getRubricaid().equals(rubrica.getId()))
                    .map(ComponenteRubrica::getComponenteid)
                    .collectList()
                    .defaultIfEmpty(List.of());

                Mono<List<RubricaResponseDTO.CriterioDTO>> criteriosMono = criterioRepository.findAll()
                    .filter(criterio -> criterio.getRubricaid() == rubrica.getId())
                    .flatMap(criterio -> {
                        Mono<List<RubricaResponseDTO.CriterioDTO.NivelDTO>> nivelesMono = nivelRepository.findByCriterioid(criterio.getId())
                            .map(n -> new RubricaResponseDTO.CriterioDTO.NivelDTO(n.getId(), n.getTitulo(), n.getDescripcion(), n.getPuntajemax()))
                            .collectList()
                            .defaultIfEmpty(List.of());

                        return nivelesMono.map(niveles -> new RubricaResponseDTO.CriterioDTO(
                            criterio.getId(),
                            criterio.getDescripcion(),
                            criterio.getEstado(),
                            niveles
                        ));
                    })
                    .collectList()
                    .defaultIfEmpty(List.of());

                return Mono.zip(componentesMono, criteriosMono)
                    .map(tuple -> new RubricaResponseDTO(
                        rubrica.getId(),
                        rubrica.getNombre(),
                        rubrica.getDescripcion(),
                        rubrica.getEstado(),
                        tuple.getT1(),
                        tuple.getT2()
                    ))
                    .onErrorResume(e -> {
                        log.error("Error al procesar rúbrica con ID {}: {}", rubrica.getId(), e.getMessage());
                        return Mono.empty(); // Evita propagar errores por una sola rúbrica
                    });
            });
    }


}
