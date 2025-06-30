package com.fisiunmsm.ayudadoc.evaluaciones.repository;

import com.fisiunmsm.ayudadoc.evaluaciones.DTO.PromedioCompetenciaDTO;
import com.fisiunmsm.ayudadoc.evaluaciones.entity.AlumnoNotas;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface NotasRepository extends ReactiveCrudRepository<AlumnoNotas, Long> {

    @Query("""
        SELECT 
          an.alumnoid,
          c.id AS curso_id,
          comp.id AS competencia_id,
          comp.nombre AS nombre_competencia,
          ROUND(AVG(an.nota), 2) AS promedio_nota
        FROM alumnonotas an
        JOIN curso c ON an.cursoid = c.id
        JOIN cursocomponente cuco ON an.componentenotaid = cuco.id
        JOIN componentecompetencia cocom ON cuco.id = cocom.cursocomponenteid
        JOIN cursocompetencia cucomp ON cocom.cursocompetenciaid = cucomp.id AND cucomp.cursoid = c.id
        JOIN competencia comp ON cucomp.competenciaid = comp.id
        WHERE an.alumnoid = :alumnoId AND an.cursoid = :cursoId
        GROUP BY an.alumnoid, c.id, comp.id, comp.nombre
    """)
    Flux<PromedioCompetenciaDTO> obtenerPromedioPorCompetencia(int alumnoId, int cursoId);
}
