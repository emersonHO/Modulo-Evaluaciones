package com.fisiunmsm.ayudadoc.evaluaciones.controller;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import com.fisiunmsm.ayudadoc.evaluaciones.service.CursoComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cursoComponente")
public class CursoComponenteController {
    @Autowired
    private CursoComponenteService cursoComponenteService;

    @GetMapping
    public List<CursoComponente> getAll(){
        return cursoComponenteService.getCursoComponente();
    }

    @PostMapping
    public void saveOrUpdate(@RequestBody CursoComponente cursoComponente){
        cursoComponenteService.saveOrUpdateCursoComponente(cursoComponente);
    }

    @DeleteMapping("{cursoComponente}")
    public void deleteUpdate(@PathVariable("cursoComponente") int cursocomponente){
        cursoComponenteService.deleteCursoComponente(cursocomponente);
    }

    @GetMapping("/{cursoComponenteId}")
    public Optional<CursoComponente> getBId(@PathVariable("cursoComponenteId") int cursoComponenteId){
        return cursoComponenteService.getCursoComponente(cursoComponenteId);
    }
}
