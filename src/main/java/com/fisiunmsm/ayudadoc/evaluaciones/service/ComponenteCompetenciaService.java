package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.ComponenteCompetenciaRepository;
import com.fisiunmsm.ayudadoc.evaluaciones.dto.ComponenteCompetenciaDetalleDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.dto.ComponenteConCompetenciasDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.dto.ComponenteSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.stream.Collectors;
import java.util.List;
import java.util.AbstractMap;
import java.util.Objects;

@Service
public class ComponenteCompetenciaService {
    @Autowired
    private ComponenteCompetenciaRepository repository;

    public Flux<ComponenteCompetencia> findAll() {
        return repository.findAll()
                .flatMap(componente -> {
                    // Aquí podrías agregar la lógica para obtener las competencias asociadas
                    // Por ahora, solo retornamos el componente con su información básica
                    return Mono.just(componente);
                });
    }

    public Mono<ComponenteCompetencia> findById(Integer id) {
        return repository.findById(id);
    }

    public Mono<ComponenteCompetencia> save(ComponenteCompetencia componente) {
        return repository.save(componente);
    }

    public Mono<ComponenteCompetencia> update(Integer id, ComponenteCompetencia componente) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setCursocompetenciaid(componente.getCursocompetenciaid());
                    existing.setCursocomponenteid(componente.getCursocomponenteid());
                    existing.setPeso(componente.getPeso());
                    return repository.save(existing);
                });
    }

    public Mono<Void> deleteById(Integer id) {
        return repository.deleteById(id);
    }

    public Flux<ComponenteCompetencia> findByCursocompetenciaid(Integer cursocompetenciaid) {
        return repository.findByCursocompetenciaid(cursocompetenciaid);
    }

    public Flux<ComponenteCompetenciaDetalleDTO> findAllDetalles() {
        return repository.findAllDetalles();
    }

    public Flux<ComponenteConCompetenciasDTO> findComponentesConCompetencias() {
        return repository.findAllDetalles()
                .collectList()
                .flatMapMany(detalles -> {
                    try {
                        // Agrupar por idComponente y descripcionComponente
                        var agrupado = detalles.stream()
                                .collect(Collectors.groupingBy(
                                        d -> new AbstractMap.SimpleEntry<>(
                                                d.getId(),
                                                d.getDescripcionComponente())));

                        List<ComponenteConCompetenciasDTO> resultado = agrupado.entrySet().stream()
                                .map(entry -> {
                                    var key = entry.getKey();
                                    var lista = entry.getValue();
                                    ComponenteConCompetenciasDTO dto = new ComponenteConCompetenciasDTO();
                                    dto.setIdComponente(key.getKey());
                                    dto.setDescripcionComponente(key.getValue());
                                    dto.setCompetencias(
                                            lista.stream()
                                                    .map(x -> x.getDescripcionCompetencia())
                                                    .filter(Objects::nonNull)
                                                    .collect(Collectors.toList()));
                                    return dto;
                                })
                                .collect(Collectors.toList());

                        return Flux.fromIterable(resultado);
                    } catch (Exception e) {
                        return Flux.error(new RuntimeException(
                                "Error al procesar los componentes con competencias: " + e.getMessage()));
                    }
                });
    }

    public Flux<ComponenteSimpleDTO> findAllComponentesConPeso() {
        return repository.findAllComponentesConPeso();
    }
}