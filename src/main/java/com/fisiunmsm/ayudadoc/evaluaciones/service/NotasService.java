package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.TopNotaDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.NotasRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class NotasService {
    private final NotasRepository notasRepository;

    public NotasService(NotasRepository notasRepository) {
        this.notasRepository = notasRepository;
    }

    public Flux<TopNotaDTO> obtenerTopNotasPorCursoYComponente(int cursoId, int componenteId) {
        return notasRepository.obtenerTopNotasPorCursoYComponente(cursoId, componenteId);
    }
}
