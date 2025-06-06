package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.entity.CursoComponente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import org.springframework.data.r2dbc.repository.Query;

@Repository
public interface CursoComponenteRepository extends ReactiveCrudRepository<CursoComponente, Long> {
    Flux<CursoComponente> findByCursoid(int cursoid);

    @Query("SELECT id, descripcion, peso FROM cursocomponente")
    Flux<CursoComponente> findDistinctCodigoDescripcionPeso();
}
