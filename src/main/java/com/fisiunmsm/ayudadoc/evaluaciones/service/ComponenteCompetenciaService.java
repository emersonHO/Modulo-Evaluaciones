package com.fisiunmsm.ayudadoc.evaluaciones.service;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteCompetencia;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.ComponenteSimple;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.Competencia;
import com.fisiunmsm.ayudadoc.evaluaciones.repository.ComponenteCompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.stream.Collectors;
import java.util.List;
import java.util.AbstractMap;

@Service
public class ComponenteCompetenciaService {
    @Autowired
    private ComponenteCompetenciaRepository repository;

    public Flux<ComponenteCompetencia> findAll() {
        return repository.findAll();
    }

    public Mono<ComponenteCompetencia> findById(Integer id) {
        return repository.findById(id);
    }

    public Mono<ComponenteCompetencia> save(ComponenteCompetencia componente) {
        if (componente.getCursocomponenteid() == null) {
            return Mono.error(new IllegalArgumentException("El ID del componente no puede estar vacío"));
        }

        if (componente.getCursocompetenciaid() == null) {
            return Mono.error(new IllegalArgumentException("El ID de la competencia no puede estar vacío"));
        }

        if (componente.getPeso() == null) {
            componente.setPeso(0.0);
        }

        return repository.save(componente)
                .doOnSuccess(saved -> {
                    System.out.println("Componente-Competencia guardado exitosamente: " + saved);
                })
                .doOnError(error -> {
                    System.err.println("Error al guardar el componente-competencia: " + error.getMessage());
                });
    }

    public Mono<ComponenteCompetencia> update(Integer id, ComponenteCompetencia componente) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setCursocomponenteid(componente.getCursocomponenteid());
                    existing.setCursocompetenciaid(componente.getCursocompetenciaid());
                    existing.setPeso(componente.getPeso());
                    return repository.save(existing);
                });
    }

    public Mono<Void> deleteById(Integer id) {
        return repository.findById(id)
                .flatMap(componente -> {
                    if (componente == null) {
                        return Mono.error(new IllegalArgumentException("No se encontró el componente con ID: " + id));
                    }
                    return repository.deleteById(id)
                            .doOnSuccess(v -> System.out.println("Componente eliminado exitosamente: " + id))
                            .doOnError(error -> System.err
                                    .println("Error al eliminar el componente: " + error.getMessage()));
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No se encontró el componente con ID: " + id)));
    }

    public Flux<ComponenteCompetencia> findAllDetalles() {
        return repository.findAllDetalles();
    }

    public Flux<ComponenteCompetencia> findComponentesConCompetencias() {
        return repository.findAllDetalles()
                .collectList()
                .flatMapMany(detalles -> {
                    try {
                        var agrupado = detalles.stream()
                                .collect(Collectors.groupingBy(
                                        d -> new AbstractMap.SimpleEntry<>(
                                                d.getId(),
                                                d.getCursocomponenteid())));

                        List<ComponenteCompetencia> resultado = agrupado.entrySet().stream()
                                .map(entry -> {
                                    var key = entry.getKey();
                                    var lista = entry.getValue();
                                    ComponenteCompetencia componente = new ComponenteCompetencia();
                                    componente.setId(key.getKey());
                                    componente.setCursocomponenteid(key.getValue());
                                    componente.setPeso(lista.get(0).getPeso());
                                    return componente;
                                })
                                .collect(Collectors.toList());

                        return Flux.fromIterable(resultado);
                    } catch (Exception e) {
                        return Flux.error(new RuntimeException(
                                "Error al procesar los componentes con competencias: " + e.getMessage()));
                    }
                });
    }

    public Flux<ComponenteSimple> findAllComponentesConPeso() {
        return repository.findAllComponentesConPeso();
    }

    public Flux<ComponenteSimple> findComponentesNoAsociados() {
        return repository.findComponentesNoAsociados();
    }

    public Mono<Void> deleteByCursocomponenteid(Long componenteId) {
        return repository.deleteByCursocomponenteid(componenteId);
    }

    public Flux<Competencia> findCompetenciasByComponente(Long componenteId) {
        return repository.findCompetenciasByComponenteId(componenteId)
                .map(detalle -> {
                    try {
                        Competencia competencia = new Competencia();
                        competencia.setId(detalle.getCursocompetenciaid());
                        competencia.setNombre(detalle.getNombreCompetencia());
                        competencia.setDescripcion(detalle.getDescripcionCompetencia());
                        return competencia;
                    } catch (Exception e) {
                        System.err.println("Error al mapear competencia: " + e.getMessage());
                        e.printStackTrace();
                        throw e;
                    }
                })
                .doOnError(error -> {
                    System.err.println("Error en findCompetenciasByComponente: " + error.getMessage());
                    error.printStackTrace();
                });
    }
}