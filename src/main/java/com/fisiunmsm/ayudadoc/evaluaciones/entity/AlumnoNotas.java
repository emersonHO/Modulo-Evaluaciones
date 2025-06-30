package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("alumnonotas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlumnoNotas {
    @Id
    private int id;
    private int alumnoid;
    private int cursoid;
    private int componentenotaid;
    private BigDecimal nota;
}
