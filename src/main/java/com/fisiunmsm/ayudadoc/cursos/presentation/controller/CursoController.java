package com.fisiunmsm.ayudadoc.cursos.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisiunmsm.ayudadoc.cursos.application.service.CursoService;
import com.fisiunmsm.ayudadoc.cursos.domain.model.Curso;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-cur/v1")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Mono<Curso> newCurso(@RequestBody Curso curso) {

        return cursoService.crearCurso( curso );
    }

    @PostMapping("/{id}/actualiza")
    public Mono<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {

        return cursoService.actualizarCurso( id, curso );
    }

    @PostMapping("/copiar")
    public Mono<Curso> copyCurso(@RequestBody Curso curso) {

        return cursoService.copiarCurso( curso );
    }

    @GetMapping("/cursos")
    public Flux<Curso> getCursosActivos() {

        return cursoService.obtenerCursosActivos();
    }    
}
