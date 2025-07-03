package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.CompetenciaArbolDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.DTO.ComponenteArbolDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Competencia;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.ComponenteRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CompetenciaArbolService {

    private final ComponenteRepository componenteRepository;
    private final CompetenciaRepository competenciaRepository;

    public Mono<CompetenciaArbolDTO> getArbolPorCompetencia(Integer competenciaId) {
        Mono<Competencia> competenciaMono = competenciaRepository.findById(competenciaId);
        Flux<CursoComponente> componentesFlux = componenteRepository.findByCompetenciaId(competenciaId);

        return Mono.zip(competenciaMono, componentesFlux.collectList())
                .map(tuple -> {
                    Competencia competencia = tuple.getT1();
                    List<CursoComponente> componentes = tuple.getT2();

                    // Mapa de id a DTO
                    Map<Long, ComponenteArbolDTO> dtoMap = new HashMap<>();
                    for (CursoComponente comp : componentes) {
                        dtoMap.put(comp.getId(), new ComponenteArbolDTO(
                                comp.getId().intValue(), // El DTO espera Integer, la entidad es Long
                                comp.getDescripcion(),
                                comp.getPeso() != null ? comp.getPeso().doubleValue() : null,
                                new ArrayList<>()
                        ));
                    }

                    // Construir jerarquía
                    List<ComponenteArbolDTO> raiz = new ArrayList<>();
                    for (CursoComponente comp : componentes) {
                        ComponenteArbolDTO dto = dtoMap.get(comp.getId());
                        if (comp.getPadreid() != null && dtoMap.containsKey(comp.getPadreid())) {
                            dtoMap.get(comp.getPadreid()).getHijos().add(dto);
                        } else {
                            raiz.add(dto);
                        }
                    }

                    return new CompetenciaArbolDTO(
                            competencia.getId(), // int
                            competencia.getNombre(),
                            raiz
                    );
                });
    }
}