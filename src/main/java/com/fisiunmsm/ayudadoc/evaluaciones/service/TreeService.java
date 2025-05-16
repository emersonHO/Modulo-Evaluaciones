package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Competencia;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.ComponenteCompetenciaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.FormulaRepository;
import reactor.core.publisher.Flux;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TreeService {
    private final CompetenciaRepository competenciaRepository;
    private final ComponenteCompetenciaRepository componenteCompetenciaRepository;
    private final FormulaRepository formulaRepository;

    public Mono<Competencia> getCompetenciaById(int id) {
        return competenciaRepository.findById(id);
    }

    // This method returns a Flux of tree nodes (one per competencia)
    public Flux<Map<String, Object>> getCompetenciasComponentesFormulas() {
        return competenciaRepository.findAll()
            .flatMap(competencia ->
                componenteCompetenciaRepository.findByCursocompetenciaid(competencia.getId())
                    .collectList()
                    .flatMapMany(componentes -> {
                        if (componentes.isEmpty()) {
                            // Competencia without componentes
                            Map<String, Object> node = new HashMap<>();
                            node.put("id", competencia.getId());
                            node.put("nombre", competencia.getNombre());
                            node.put("componentes", Collections.emptyList());
                            return Flux.just(node);
                        }
                        // For each componente, get formulas
                        return Flux.fromIterable(componentes)
                            .flatMap(componente ->
                                formulaRepository.findAll()
                                    .filter(f -> Objects.equals(f.getId(), componente.getCursocomponenteid()))
                                    .collectList()
                                    .map(formulas -> {
                                        Map<String, Object> compNode = new HashMap<>();
                                        compNode.put("id", componente.getCursocomponenteid());
                                        compNode.put("peso", componente.getPeso());
                                        compNode.put("formulas", formulas);
                                        return compNode;
                                    })
                            )
                            .collectList()
                            .map(compNodes -> {
                                Map<String, Object> node = new HashMap<>();
                                node.put("id", competencia.getId());
                                node.put("nombre", competencia.getNombre());
                                node.put("componentes", compNodes);
                                return node;
                            })
                            .flux();
                    })
            );
    }
}
