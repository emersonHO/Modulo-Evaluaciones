package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("componentecompetencia")
public class ComponenteCompetencia {
    @Id
    private Integer id;
    private Integer cursocompetenciaid;
    private Long cursocomponenteid;
    private Double peso;

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCursocompetenciaid() {
        return cursocompetenciaid;
    }

    public void setCursocompetenciaid(Integer cursocompetenciaid) {
        this.cursocompetenciaid = cursocompetenciaid;
    }

    public Long getCursocomponenteid() {
        return cursocomponenteid;
    }

    public void setCursocomponenteid(Long cursocomponenteid) {
        this.cursocomponenteid = cursocomponenteid;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}