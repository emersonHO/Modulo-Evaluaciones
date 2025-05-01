package com.fisiunmsm.ayudadoc.evaluaciones.controller;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Formula;
import com.fisiunmsm.ayudadoc.evaluaciones.service.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/formula")
public class FormulaController {
    @Autowired
    private FormulaService formulaService;

    @GetMapping
    public List<Formula> getAll(){
        return formulaService.getFormula();
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody Formula formula){
        formulaService.saveOrUpdateFormula(formula);
    }

    @DeleteMapping("/{formulaId}")
    public void deleteUpdate(@PathVariable("formulaId") int formulaId){
        formulaService.deleteFormula(formulaId);
    }

    @GetMapping("/{formulaId}")
    public Optional<Formula> getBId(@PathVariable("formulaId") int formulaId){
        return formulaService.getFormula(formulaId);
    }

}
