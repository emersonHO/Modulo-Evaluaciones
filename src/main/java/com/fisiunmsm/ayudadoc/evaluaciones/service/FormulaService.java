package com.fisiunmsm.ayudadoc.evaluaciones.service;

import org.springframework.stereotype.Service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.FormulaRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FormulaService {
    private final FormulaRepository formulaRepository;

    public Flux<Formula> getAll() {
        log.info("Obteniendo todas las fórmulas");
        return formulaRepository.findAll();
    }

    public Mono<Formula> getById(int id) {
        log.info("Buscando formula con ID: {}", id);
        return formulaRepository.findById(id)
            .doOnSuccess(formula -> {
                if (formula == null) {
                    log.warn("No se encontro formula con ID: {}", id);
                }
            });
    }

    public Mono<Formula> save(Formula formula) {
        log.info("Guardando formula: {}", formula.getCodigo());
        return formulaRepository.save(formula)
            .doOnSuccess(saved -> log.debug("Formula guardada con ID: {}", saved.getId()));
    }

    public Mono<Formula> update(int id, Formula formula) {
        log.info("Actualizando formula con ID: {}", id);
        return formulaRepository.save(new Formula(
                id, formula.getCodigo(), formula.getDescripcion(), formula.getFormula(),
                formula.getFuncionId(), formula.getEstado(), formula.getInstitucionId(),
                formula.getDepartamentoId(), formula.getUsaPesos(), formula.getRestaMenor(),
                formula.getNumMenor(), formula.getRestaMayor(), formula.getNumMayor(),
                formula.getCopiaPrimero(), formula.getCopiaMenor(), formula.getCopiaMayor(),
                formula.getRedondeo(), formula.getInstitutoid()
        )).doOnSuccess(updated -> log.debug("Formula actualizada: {}", updated.getCodigo()));
    }

    public Mono<Void> delete(int id) {
        log.warn("Eliminando formula con ID: {}", id);
        return formulaRepository.deleteById(id);
    }
}
