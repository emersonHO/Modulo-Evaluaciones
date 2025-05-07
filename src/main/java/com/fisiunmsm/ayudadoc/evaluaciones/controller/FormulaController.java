package com.fisiunmsm.ayudadoc.evaluaciones.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.service.FormulaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/formula")
@RequiredArgsConstructor
public class FormulaController {
    
    private final FormulaService formulaService;

    @GetMapping
    public Flux<Formula> getAll(){
        return formulaService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Formula> getById(@PathVariable("id") int id){
        return formulaService.getById(id);
    }
    
    @PostMapping
    public Mono<Formula> save(@RequestBody Formula formula){
        return formulaService.save(formula);
    }

    @PutMapping("/{id}")
    public Mono<Formula> update(@PathVariable("id") int id, @RequestBody Formula formula){
        return formulaService.update(id, formula);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") int id){
        return formulaService.delete(id);
    }
}
