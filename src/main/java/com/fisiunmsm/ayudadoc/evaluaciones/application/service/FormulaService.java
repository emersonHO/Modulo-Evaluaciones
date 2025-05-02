package com.fisiunmsm.ayudadoc.evaluaciones.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisiunmsm.ayudadoc.evaluaciones.infraestructure.repository.FormulaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.infraestructure.mapper.FormulaTable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FormulaService {

    private final FormulaRepository formulaRepository;

    @Autowired
    public FormulaService(FormulaRepository formulaRepository) {
        this.formulaRepository = formulaRepository;
    }

    public Flux<FormulaTable> getAllFormulas() {
        return formulaRepository.findAll();
    }

    public Mono<FormulaTable> getFormulaById(int id) {
        return formulaRepository.findById(id);
    }

    public Mono<FormulaTable> saveOrUpdateFormula(FormulaTable formula) {
        return formulaRepository.save(formula);
    }

    public Mono<Void> deleteFormula(int id) {
        return formulaRepository.deleteById(id);
    }
}
