package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.FormulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormulaService {
    @Autowired
    FormulaRepository formulaRepository;
    public List<Formula> getFormula(){
        return formulaRepository.findAll();
    }

    public Optional<Formula> getFormula(int id){
        return formulaRepository.findById(id);
    }

    public void saveOrUpdateFormula(Formula formula){
        formulaRepository.save(formula);
    }

    public void deleteFormula(int id){
        formulaRepository.deleteById(id);
    }
}
