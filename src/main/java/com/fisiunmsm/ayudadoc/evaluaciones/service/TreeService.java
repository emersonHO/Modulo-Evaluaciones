package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Competencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CompetenciaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.ComponenteCompetenciaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CursoComponenteRepository;
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
    private final CursoComponenteRepository cursoComponenteRepository;
    private final FormulaRepository formulaRepository;

    public Mono<Competencia> getCompetenciaById(int id) {
        return competenciaRepository.findById(id);
    }

    public Object getCompetenciasComponentesFormulas() {
        return null;
    }
}
