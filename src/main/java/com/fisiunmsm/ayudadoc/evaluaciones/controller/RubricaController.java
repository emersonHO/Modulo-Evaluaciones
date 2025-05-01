package com.fisiunmsm.ayudadoc.evaluaciones.controller;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.Rubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.service.RubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/rubrica")
public class RubricaController {
    @Autowired
    private RubricaService rubricaService;

    @GetMapping
    public List<Rubrica> getAll(){
        return rubricaService.getRubrica();
    }

    @PostMapping
    public void saveOrUpdateRubrica(@RequestBody Rubrica rubrica){
        rubricaService.saveOrUpdateRubrica(rubrica);
    }

    @DeleteMapping("/{rubricaId}")
    public void deleteRubrica(@PathVariable("rubricaId") int rubricaId){
        rubricaService.deleteRubrica(rubricaId);
    }

    @GetMapping("/{rubricaId}")
    public Optional<Rubrica> getBId(@PathVariable("rubricaId") int rubricaId){
        return rubricaService.getRubrica(rubricaId);
    }
}
