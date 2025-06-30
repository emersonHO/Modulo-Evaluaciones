package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Table("componentecompetencia")
public class ComponenteCompetencia {
    @Id
    private Integer id;

    @Column("cursocompetenciaid")
    private Integer cursocompetenciaid;

    @Column("cursocomponenteid")
    private Long cursocomponenteid;

    @Column("peso")
    private Double peso;

    @Column("nombreCompetencia")
    private String nombreCompetencia;

    @Column("descripcionCompetencia")
    private String descripcionCompetencia;

    public ComponenteCompetencia() {
    }

    public ComponenteCompetencia(Integer cursocompetenciaid, Long cursocomponenteid, Double peso) {
        this.cursocompetenciaid = cursocompetenciaid;
        this.cursocomponenteid = cursocomponenteid;
        this.peso = peso;
    }

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

    public String getNombreCompetencia() {
        return nombreCompetencia;
    }

    public void setNombreCompetencia(String nombreCompetencia) {
        this.nombreCompetencia = nombreCompetencia;
    }

    public String getDescripcionCompetencia() {
        return descripcionCompetencia;
    }

    public void setDescripcionCompetencia(String descripcionCompetencia) {
        this.descripcionCompetencia = descripcionCompetencia;
    }

    @Override
    public String toString() {
        return "ComponenteCompetencia{" +
                "id=" + id +
                ", cursocompetenciaid=" + cursocompetenciaid +
                ", cursocomponenteid=" + cursocomponenteid +
                ", peso=" + peso +
                ", nombreCompetencia=" + nombreCompetencia +
                ", descripcionCompetencia=" + descripcionCompetencia +
                '}';
    }
}