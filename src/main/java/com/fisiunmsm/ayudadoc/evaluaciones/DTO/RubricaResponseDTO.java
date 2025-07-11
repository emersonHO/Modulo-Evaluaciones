package com.fisiunmsm.ayudadoc.evaluaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RubricaResponseDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String estado;
    private List<Long> componenteIds;
    private List<CriterioDTO> criterios;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class CriterioDTO {
        private Integer id;
        private String descripcion;
        private String estado;
        private List<NivelDTO> niveles;

        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class NivelDTO {
            private Integer id;
            private String titulo;
            private String descripcion;
            private int puntajemax;
        }
    }
}
