package com.fisiunmsm.ayudadoc.cursos.infraestructure.mapper;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fisiunmsm.ayudadoc.cursos.domain.model.Curso;

import reactor.core.publisher.Mono;

@Table("curso")
public class CursoTable {

    @Id
    private Long id;

    private String codigo;
    private String nombre;
    private String tipo;
    private Long numhorasteoria;
    private Long numhoraspractica;
    private Long numhoraslaboratorio;
    private Long numcreditos;
    private Long planestudiosid;
    private String ciclo;
    private Long periodoacademicoid;
    private Long institucionid;
    private Long departamentoid;
    private String estado;
    private String sumilla;
    private String modalidad;
    private String etiquetas;

    public CursoTable() {
    }

    public CursoTable(Long id, 
                      String codigo, 
                      String nombre, 
                      String tipo, 
                      Long numhorasteoria, 
                      Long numhoraspractica, 
                      Long numhoraslaboratorio, 
                      Long numcreditos, 
                      String ciclo, 
                      Long planestudiosid, 
                      Long periodoacademicoid,
                      Long institucionid,
                      Long departamentoid,
                      String estado, 
                      String sumilla,
                      String modalidad,
                      String etiquetas) {
    
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numhorasteoria  = numhorasteoria;
        this.numhoraspractica = numhoraspractica;
        this.numhoraslaboratorio = numhoraslaboratorio;
        this.numcreditos = numcreditos;
        this.planestudiosid = planestudiosid;
        this.ciclo = ciclo;
        this.periodoacademicoid = periodoacademicoid;
        this.estado = estado;
        this.institucionid = institucionid;
        this.departamentoid = departamentoid;
        this.sumilla = sumilla;
        this.modalidad = modalidad;
        this.etiquetas = etiquetas;
    }

    public static CursoTable fromDomainModel( Curso curso ) {
        
        return new CursoTable( curso.getId(), curso.getCodigo(), curso.getNombre(), curso.getTipo()
                                , curso.getNumHorasTeoria(), curso.getNumHorasPractica(), curso.getNumHorasLaboratorio()
                                , curso.getNumCreditos(), curso.getCiclo(), curso.getPlanEstudiosId(), curso.getPeriodoAcademicoId()
                                , curso.getInstitucionid(), curso.getDepartamentoid(), curso.getEstado()
                                , curso.getSumilla(), curso.getModalidad(), curso.getEtiquetas() );
    }

    public Curso toDomainModel()  {

        return new Curso( id, codigo, nombre, tipo, numhorasteoria, numhoraspractica, numhoraslaboratorio, numcreditos, 
                          ciclo, planestudiosid, periodoacademicoid, institucionid, departamentoid, estado,
                          sumilla, modalidad, etiquetas );
    }

    public Mono<Curso> toMono()  {

        return Mono.just( toDomainModel() );
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getNumhorasteoria() {
        return numhorasteoria;
    }

    public void setNumhorasteoria(Long numhorasteoria) {
        this.numhorasteoria = numhorasteoria;
    }

    public Long getNumhoraspractica() {
        return numhoraspractica;
    }

    public void setNumhoraspractica(Long numhoraspractica) {
        this.numhoraspractica = numhoraspractica;
    }

    public Long getNumhoraslaboratorio() {
        return numhoraslaboratorio;
    }

    public void setNumhoraslaboratorio(Long numhoraslaboratorio) {
        this.numhoraslaboratorio = numhoraslaboratorio;
    }

    public Long getNumcreditos() {
        return numcreditos;
    }

    public void setNumcreditos(Long numcreditos) {
        this.numcreditos = numcreditos;
    }

    public Long getPlanestudiosid() {
        return planestudiosid;
    }

    public void setPlanestudiosid(Long planestudiosid) {
        this.planestudiosid = planestudiosid;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Long getPeriodoacademicoid() {
        return periodoacademicoid;
    }

    public void setPeriodoacademicoid(Long periodoacademicoid) {
        this.periodoacademicoid = periodoacademicoid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getInstitucionid() {
        return institucionid;
    }

    public void setInstitucionid(Long institucionid) {
        this.institucionid = institucionid;
    }

    public Long getDepartamentoid() {
        return departamentoid;
    }

    public void setDepartamentoid(Long departamentoid) {
        this.departamentoid = departamentoid;
    }

    public String getSumilla() {
        return sumilla;
    }

    public void setSumilla(String sumilla) {
        this.sumilla = sumilla;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }
}
