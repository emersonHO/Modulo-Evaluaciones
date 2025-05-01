package com.fisiunmsm.ayudadoc.evaluaciones.controller;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CriterioRubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/criterioRubrica")
public class CriterioRubricaController {
    @Autowired
    private CriterioRubricaService criterioRubricaService;

    @GetMapping
    public List<CriterioRubrica> getAll(){
        return criterioRubricaService.getCriterioRubrica();
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody CriterioRubrica criterioRubrica){
        criterioRubricaService.saveOrUpdateCriterioRubrica(criterioRubrica);
    }

    @DeleteMapping("/{criterioRubricaId}")
    public void deleteUpdate(@PathVariable("criterioRubricaId") int criterioRubricaId){
        criterioRubricaService.deleteCriterioRubrica(criterioRubricaId);
    }

    @GetMapping("/{criterioRubricaId}")
    public Optional<CriterioRubrica> getBId(@PathVariable("criterioRubricaId") int criterioRubricaId){
        return criterioRubricaService.getCriterioRubrica(criterioRubricaId);
    }
}
