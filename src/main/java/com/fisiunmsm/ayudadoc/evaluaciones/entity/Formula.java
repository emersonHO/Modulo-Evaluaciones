package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formula")
public class Formula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigo;
    private String descripcion;
    private String formula;
    private int funcionid;
    private String estado;
    private int institutoid;
    private int departamentoid;
    private int usapesos;
    private int restamenor;
    private int nummenor;
    private int restamayor;
    private int nummayor;
    private int copiaprimero;
    private int copiamenor;
    private int copiamayor;
    private int redondeo;
}
