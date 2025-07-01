package com.fisiunmsm.ayudadoc.evaluaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PromedioCompetenciaDTO {
    private int alumnoId;
    private int cursoId;
    private int competenciaId;
    private String nombreCompetencia;
    private Double promedioNota;
}
