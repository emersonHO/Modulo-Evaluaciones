package com.fisiunmsm.ayudadoc.cursos.domain.model;

public class Curso  {

    private Long id;

    private String codigo;
    private String nombre;
    private String tipo;
    private Long numHorasTeoria;
    private Long numHorasPractica;
    private Long numHorasLaboratorio;
    private Long numCreditos;
    private Long planEstudiosId;
    private String ciclo;
    private Long periodoAcademicoId;
    private Long institucionid;
    private Long departamentoid;
    private String estado;
    private String sumilla;
    private String modalidad;
    private String etiquetas;

    private String nuevoCodigo;

    public Curso()  {
    }

    public Curso(Long id, String codigo, String nombre, Long institucionid ) {

        this.id = id;                    
        this.codigo = codigo;
        this.nombre = nombre;
        this.institucionid = institucionid;
    }

    public Curso(Long id, String codigo, String nombre, String tipo,
                 Long numHorasTeoria, Long numHorasPractica, Long numHorasLaboratorio, Long numCreditos,
                 String ciclo, Long planEstudiosId, Long periodoAcademicoId, Long institucionid, Long departamentoid,
                 String estado, String sumilla, String modalidad, String etiquetas  ) {

        this.id = id;                    
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numHorasTeoria = numHorasTeoria;
        this.numHorasPractica = numHorasPractica;
        this.numHorasLaboratorio = numHorasLaboratorio;
        this.numCreditos = numCreditos;
        this.planEstudiosId = planEstudiosId;
        this.ciclo = ciclo;
        this.periodoAcademicoId = periodoAcademicoId;
        this.institucionid = institucionid;
        this.departamentoid = departamentoid;
        this.estado = estado;
        this.sumilla = sumilla;
        this.modalidad = modalidad;
        this.etiquetas = etiquetas;
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
    public Long getNumHorasTeoria() {
        return numHorasTeoria;
    }
    public void setNumHorasTeoria(Long numHorasTeoria) {
        this.numHorasTeoria = numHorasTeoria;
    }
    public Long getNumHorasPractica() {
        return numHorasPractica;
    }
    public void setNumHorasPractica(Long numHorasPractica) {
        this.numHorasPractica = numHorasPractica;
    }
    public Long getNumHorasLaboratorio() {
        return numHorasLaboratorio;
    }
    public void setNumHorasLaboratorio(Long numHorasLaboratorio) {
        this.numHorasLaboratorio = numHorasLaboratorio;
    }
    public Long getNumCreditos() {
        return numCreditos;
    }
    public void setNumCreditos(Long numCreditos) {
        this.numCreditos = numCreditos;
    }
    public Long getPlanEstudiosId() {
        return planEstudiosId;
    }
    public void setPlanEstudiosId(Long planEstudiosId) {
        this.planEstudiosId = planEstudiosId;
    }
    public String getCiclo() {
        return ciclo;
    }
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    public Long getPeriodoAcademicoId() {
        return periodoAcademicoId;
    }
    public void setPeriodoAcademicoId(Long periodoAcademicoId) {
        this.periodoAcademicoId = periodoAcademicoId;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getSumilla() {
        return sumilla;
    }
    public void setSumilla(String sumilla) {
        this.sumilla = sumilla;
    }
    public String getModalidad() {
        return this.modalidad;
    }
    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
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

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getNuevoCodigo() {
        return nuevoCodigo;
    }
    public void setNuevoCodigo(String nuevoCodigo) {
        this.nuevoCodigo = nuevoCodigo;
    }

    @Override
    public String toString()    {

        return "[" + codigo + " - \n" 
                   + nombre + " - \n"
                   + "plan:" + planEstudiosId + " - \n"
                   + "Hs.T:" + numHorasTeoria + " - \n"
                   + "Hs.P:" + numHorasPractica + " - \n"
                   + "Hs.L:" + numHorasLaboratorio + " - \n"
                   + "Cred:" + numCreditos + " - \n"
                   + "PerAcd:" + periodoAcademicoId + " - \n"
                   + "Est:" + estado
                +"]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        
        Curso newCurso = new Curso();
        newCurso.setCodigo(codigo);
        newCurso.setNombre(nombre);
        newCurso.setTipo(tipo);
        newCurso.setNumHorasTeoria(numHorasTeoria);
        newCurso.setNumHorasPractica(numHorasPractica);
        newCurso.setNumHorasLaboratorio(numHorasLaboratorio);
        newCurso.setNumCreditos(numCreditos);
        newCurso.setPeriodoAcademicoId(periodoAcademicoId);
        newCurso.setPlanEstudiosId(planEstudiosId);
        newCurso.setCiclo(ciclo);
        newCurso.setInstitucionid(institucionid);
        newCurso.setDepartamentoid(departamentoid);
        newCurso.setSumilla(sumilla);
        newCurso.setModalidad(modalidad);
        return newCurso;
    }

}
