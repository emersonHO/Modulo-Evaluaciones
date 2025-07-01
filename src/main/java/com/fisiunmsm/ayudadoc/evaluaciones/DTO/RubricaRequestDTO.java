package com.fisiunmsm.ayudadoc.evaluaciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RubricaRequestDTO {
    private String nombre;
    private String descripcion;
    private String estado;
    private Long componenteid;
    private List<CriterioDTO> criterios;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class CriterioDTO {
        private String descripcion;
        private String estado;
        private List<NivelDTO> niveles;

        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class NivelDTO {
            private String titulo;
            private String descripcion;
            private int puntajemax;
        }
    }
}