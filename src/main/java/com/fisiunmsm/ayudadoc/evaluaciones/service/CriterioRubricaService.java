package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CriterioRubrica;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.CriterioRubricaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CriterioRubricaService {
    private final CriterioRubricaRepository criterioRubricaRepository;

    public Flux<CriterioRubrica> getAll() {
        return criterioRubricaRepository.findAll();
    }

    public Flux<CriterioRubrica> getByRubricaId(int rubricaid) {
        return criterioRubricaRepository.findByRubricaid(rubricaid);
    }

    public Mono<CriterioRubrica> save(CriterioRubrica criterioRubrica) {
        return criterioRubricaRepository.save(criterioRubrica);
    }

    public Mono<CriterioRubrica> update(int id, CriterioRubrica criterioRubrica) {
        return criterioRubricaRepository.save(new CriterioRubrica(
                id, criterioRubrica.getDescripcion(),
                criterioRubrica.getEstado(), criterioRubrica.getNivel(),
                criterioRubrica.getPuntaje(),
                criterioRubrica.getRubricaid()));
    }

    public Mono<Void> delete(int id) {
        return criterioRubricaRepository.deleteById(id);
    }
}
