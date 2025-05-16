package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Competencia;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CompetenciaService {
    @Autowired
    private CompetenciaRepository competenciaRepository;

    public Flux<Competencia> findAll() {
        return competenciaRepository.findAll();
    }
}