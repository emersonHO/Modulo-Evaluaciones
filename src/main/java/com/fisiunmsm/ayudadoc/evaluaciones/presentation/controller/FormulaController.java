package com.fisiunmsm.ayudadoc.evaluaciones.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fisiunmsm.ayudadoc.evaluaciones.application.service.FormulaService;
import com.fisiunmsm.ayudadoc.evaluaciones.infraestructure.mapper.FormulaTable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/formula")
public class FormulaController {

    @Autowired
    private FormulaService formulaService;

    @GetMapping
    public Flux<FormulaTable> getAll() {
        return formulaService.getAllFormulas();
    }

    @PostMapping
    public Mono<FormulaTable> saveOrUpdate(@RequestBody FormulaTable formula) {
        return formulaService.saveOrUpdateFormula(formula);
    }

    @DeleteMapping("/{formulaId}")
    public Mono<Void> delete(@PathVariable("formulaId") int formulaId) {
        return formulaService.deleteFormula(formulaId);
    }

    @GetMapping("/{formulaId}")
    public Mono<FormulaTable> getById(@PathVariable("formulaId") int formulaId) {
        return formulaService.getFormulaById(formulaId);
    }

}
