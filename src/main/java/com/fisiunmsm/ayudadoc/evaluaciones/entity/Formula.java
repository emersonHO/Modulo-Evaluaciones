package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("formula")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Formula {

    @Id
    private int id;

    private String codigo;
    private String descripcion;
    private String formula;
    private int funcionid;
    private String estado;
    private int institucionid;
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
    private int institutoid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public int getFuncionId() {
        return funcionid;
    }

    public void setFuncionId(int funcionid) {
        this.funcionid = funcionid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getInstitucionId() {
        return institucionid;
    }

    public void setInstitucionId(int institucionid) {
        this.institucionid = institucionid;
    }

    public int getDepartamentoId() {
        return departamentoid;
    }

    public void setDepartamentoId(int departamentoid) {
        this.departamentoid = departamentoid;
    }

    public int getUsaPesos() {
        return usapesos;
    }

    public void setUsaPesos(int usapesos) {
        this.usapesos = usapesos;
    }

    public int getRestaMenor() {
        return restamenor;
    }

    public void setRestaMenor(int restamenor) {
        this.restamenor = restamenor;
    }

    public int getNumMenor() {
        return nummenor;
    }

    public void setNumMenor(int nummenor) {
        this.nummenor = nummenor;
    }

    public int getRestaMayor() {
        return restamayor;
    }

    public void setRestaMayor(int restamayor) {
        this.restamayor = restamayor;
    }

    public int getNumMayor() {
        return nummayor;
    }

    public void setNumMayor(int nummayor) {
        this.nummayor = nummayor;
    }

    public int getCopiaPrimero() {
        return copiaprimero;
    }

    public void setCopiaPrimero(int copiaprimero) {
        this.copiaprimero = copiaprimero;
    }

    public int getCopiaMenor() {
        return copiamenor;
    }

    public void setCopiaMenor(int copiamenor) {
        this.copiamenor = copiamenor;
    }

    public int getCopiaMayor() {
        return copiamayor;
    }

    public void setCopiaMayor(int copiamayor) {
        this.copiamayor = copiamayor;
    }

    public int getRedondeo() {
        return redondeo;
    }

    public void setRedondeo(int redondeo) {
        this.redondeo = redondeo;
    }

    public int getInstitutoId() {
        return institutoid;
    }

    public void setInstitutoId(int institutoid) {
        this.institutoid = institutoid;
    }
}
