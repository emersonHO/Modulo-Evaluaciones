package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("cursocomponente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CursoComponente {
    @Id
    private Long id;

    private String codigo;
    private String descripcion;
    private int evaluacionid;
    private float peso;
    private String estado;
    private int cursoid;
    private int orden;
    private Long padreid;
    private int nivel;
    private int institucionalid;
    private String calculado;
    private Long departamentoid;
    private Long formulaid;
    private Long curso_id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getEvaluacionid() {
        return evaluacionid;
    }
    public void setEvaluacionid(int evaluacionid) {
        this.evaluacionid = evaluacionid;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getCursoid() {
        return cursoid;
    }
    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }
    public int getOrden() {
        return orden;
    }
    public void setOrden(int orden) {
        this.orden = orden;
    }
    public Long getPadreid() {
        return padreid;
    }
    public void setPadreid(Long padreid) {
        this.padreid = padreid;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getInstitucionalid() {
        return institucionalid;
    }
    public void setInstitucionalid(int institucionalid) {
        this.institucionalid = institucionalid;
    }
    public String getCalculado() {
        return calculado;
    }
    public void setCalculado(String calculado) {
        this.calculado = calculado;
    }
    public Long getDepartamentoid() {
        return departamentoid;
    }
    public void setDepartamentoid(Long departamentoid) {
        this.departamentoid = departamentoid;
    }
    public Long getFormulaid() {
        return formulaid;
    }
    public void setFormulaid(Long formulaid) {
        this.formulaid = formulaid;
    }
    public Long getCurso_id() {
        return curso_id;
    }
    public void setCurso_id(Long curso_id) {
        this.curso_id = curso_id;
    }
}
