package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.RubricaRequestDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Rubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.NivelCriterio;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.RubricaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CriterioRubricaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.NivelCriterioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RubricaService {

    private final RubricaRepository rubricaRepository;
    private final CriterioRubricaRepository criterioRepository;
    private final NivelCriterioRepository nivelRepository;

    public Mono<Rubrica> guardarRubricaCompleta(RubricaRequestDTO dto) {
        Rubrica rubrica = new Rubrica(null, dto.getDescripcion(), dto.getEstado(), dto.getNombre());

        return rubricaRepository.save(rubrica)
                .flatMap(savedRubrica -> Flux.fromIterable(dto.getCriterios())
                    .flatMap(criterioDTO -> {
                        CriterioRubrica criterio = new CriterioRubrica(null, criterioDTO.getDescripcion(), criterioDTO.getEstado(), savedRubrica.getId());

                        return criterioRepository.save(criterio)
                                .flatMapMany(savedCriterio -> {
                                    List<NivelCriterio> niveles = criterioDTO.getNiveles().stream()
                                            .map(n -> new NivelCriterio(null, n.getDescripcion(), n.getPuntajemax(), savedCriterio.getId(), n.getTitulo()))
                                            .collect(Collectors.toList());

                                    return nivelRepository.saveAll(niveles);
                                });
                    })
                    .then(Mono.just(savedRubrica))
                );
    }
}