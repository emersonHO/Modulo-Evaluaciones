package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CursoComponenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CursoComponenteService {

    private final CursoComponenteRepository cursoComponenteRepository;

    public Flux<CursoComponente> getAll() {
        return cursoComponenteRepository.findAll();
    }

    public Flux<CursoComponente> getByCursoId(int cursoid) {
        return cursoComponenteRepository.findByCursoid(cursoid);
    }

    public Mono<CursoComponente> save(CursoComponente componente) {
        return cursoComponenteRepository.save(componente);
    }

    public Mono<CursoComponente> update(Long id, CursoComponente componente) {
        return cursoComponenteRepository.save(new CursoComponente(
                id,
                componente.getCodigo(),
                componente.getDescripcion(),
                componente.getEvaluacionid(),
                componente.getPeso(),
                componente.getEstado(),
                componente.getCursoid(),
                componente.getOrden(),
                componente.getPadreid(),
                componente.getNivel(),
                componente.getInstitucionalid(),
                componente.getCalculado(),
                componente.getDepartamentoid(),
                componente.getFormulaid(),
                componente.getCurso_id()));
    }

    public Mono<Void> delete(Long id) {
        return cursoComponenteRepository.deleteById(id);
    }

    public Flux<CursoComponente> getDistinctCodigoDescripcionPeso() {
        return cursoComponenteRepository.findDistinctCodigoDescripcionPeso();
    }
}
