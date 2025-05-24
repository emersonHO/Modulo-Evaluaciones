package com.fisiunmsm.ayudadoc.evaluaciones.service;

import org.springframework.stereotype.Service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.FormulaRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FormulaService {
    private final FormulaRepository formulaRepository;

    public Flux<Formula> getAll() {
        return formulaRepository.findAll();
    }

    public Mono<Formula> getById(int id) {
        return formulaRepository.findById(id);
    }

    public Mono<Formula> save(Formula formula) {
        return formulaRepository.save(formula);
    }

    public Mono<Formula> update(int id, Formula formula) {
        return formulaRepository.save(new Formula(id, formula.getCodigo(), formula.getDescripcion(),
                formula.getFormula(), formula.getFuncionId(), formula.getEstado(), formula.getInstitucionId(),
                formula.getDepartamentoId(), formula.getUsaPesos(), formula.getRestaMenor(),
                formula.getNumMenor(), formula.getRestaMayor(), formula.getNumMayor(),
                formula.getCopiaPrimero(), formula.getCopiaMenor(), formula.getCopiaMayor(),
                formula.getRedondeo(), formula.getInstitutoid()));
    }

    public Mono<Void> delete(int id) {
        return formulaRepository.deleteById(id);
    }
}
