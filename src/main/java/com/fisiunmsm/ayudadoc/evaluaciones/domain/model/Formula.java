package com.fisiunmsm.ayudadoc.evaluaciones.domain.model;

public class Formula {
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

    public Formula(){

    }
    
    public Formula(int id, String codigo, String descripcion, String formula){
        this.id= id;
        this.codigo= codigo;
        this.descripcion= descripcion;
        this.formula= formula;
    }
    
    public Formula(int id, String codigo, String descripcion, String formula, int funcionid, String estado,
                int institutoid, int departamentoid, int usapesos, int restamenor, int nummenor, int restamayor,
                int nummayor, int copiaprimero, int copiamenor, int copiamayor, int redondeo){
        this.id= id;
        this.codigo= codigo;
        this.descripcion= descripcion;
        this.formula= formula;
        this.funcionid= funcionid;
        this.estado= estado;
        this.institutoid= institutoid;
        this.departamentoid= departamentoid;
        this.usapesos= usapesos;
        this.restamenor= restamenor;
        this.nummenor= nummenor;
        this.restamayor= restamayor;
        this.nummayor= nummayor;
        this.copiaprimero= copiaprimero;
        this.copiamenor= copiamenor;
        this.copiamayor= copiamayor;
        this.redondeo= redondeo;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public String getFormula(){
        return formula;
    }
    public void setFormula(String formula){
        this.formula=formula;
    }
    public int getFuncionId(){
        return funcionid;
    }
    public void setFuncionId(int funcionid){
        this.funcionid=funcionid;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    public int getInstitutoId(){
        return institutoid;
    }
    public void setInstitutoId(int institutoid){
        this.institutoid=institutoid;
    }
    public int getDepartamentoId(){
        return departamentoid;
    }
    public void setDepartamentoId(int departamentoid){
        this.departamentoid=departamentoid;
    }
    public int getUsaPesos(){
        return usapesos;
    }
    public void setUsaPesos(int usapesos){
        this.usapesos=usapesos;
    }
    public int getRestaMenor(){
        return restamenor;
    }
    public void setRestaMenor(int restamenor){
        this.restamenor=restamenor;
    }
    public int getNumMenor(){
        return nummenor;
    }
    public void setNumMenor(int nummenor){
        this.nummenor=nummenor;
    }
    public int getRestaMayor(){
        return restamayor;
    }
    public void setRestaMayor(int restamayor){
        this.restamayor=restamayor;
    }
    public int getNumMayor(){
        return nummayor;
    }
    public void setNumMayor(int nummayor){
        this.nummayor=nummayor;
    }
    public int getCopiaPrimero(){
        return copiaprimero;
    }
    public void setCopiaPrimero(int copiaprimero){
        this.copiaprimero=copiaprimero;
    }
    public int getCopiaMenor(){
        return copiamenor;
    }
    public void setCopiaMenor(int copiamenor){
        this.copiamenor=copiamenor;
    }
    public int getCopiaMayor(){
        return copiamayor;
    }
    public void setCopiaMayor(int copiamayor){
        this.copiamayor=copiamayor;
    }
    public int getRedondeo(){
        return redondeo;
    }
    public void setRedondeo(int redondeo){
        this.redondeo=redondeo;
    }
}

