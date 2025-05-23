package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Competencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CompetenciaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.ComponenteCompetenciaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.FormulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TreeService {
    private final CompetenciaRepository competenciaRepository;
    private final ComponenteCompetenciaRepository componenteCompetenciaRepository;
    private final FormulaRepository formulaRepository;

    public Flux<Map<String, Object>> getCompetenciasComponentesFormulas() {
        return competenciaRepository.findAll()
            .flatMap(competencia ->
                componenteCompetenciaRepository.findByCursocompetenciaid(competencia.getId())
                    .collectList()
                    .flatMapMany(componentes -> {
                        if (componentes.isEmpty()) {
                            Map<String, Object> competenciaNode = new HashMap<>();
                            competenciaNode.put("id", competencia.getId());
                            competenciaNode.put("nombre", competencia.getNombre());
                            competenciaNode.put("componentes", Collections.emptyList());
                            return Flux.just(competenciaNode);
                        }
                        return Flux.fromIterable(componentes)
                            .flatMap(componente ->
                                formulaRepository.findAll()
                                    .filter(f -> Objects.equals(f.getId(), componente.getCursocomponenteid()))
                                    .collectList()
                                    .map(formulas -> {
                                        Map<String, Object> componenteNode = new HashMap<>();
                                        componenteNode.put("id", componente.getCursocomponenteid());
                                        componenteNode.put("peso", componente.getPeso());
                                        componenteNode.put("formulas", formulas);
                                        return componenteNode;
                                    })
                            )
                            .collectList()
                            .map(componentesList -> {
                                Map<String, Object> competenciaNode = new HashMap<>();
                                competenciaNode.put("id", competencia.getId());
                                competenciaNode.put("nombre", competencia.getNombre());
                                competenciaNode.put("componentes", componentesList);
                                return competenciaNode;
                            });
                    })
            );
    }
}