package com.fisiunmsm.ayudadoc.evaluaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopNotaDTO {
    private Integer alumnoId;
    private Integer cursoId;
    private Integer componenteId;
    private String nombreComponente;
    private Double nota;
}
