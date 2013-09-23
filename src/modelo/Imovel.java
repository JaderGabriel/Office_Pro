/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USuario
 */
public class Imovel {
    String ID_Proprietario;
    String Cod_Incra;
    String nome;
    String municipio;
    String uf;
    String matricula;
    String comarca;
    String area;
    String processo;
    String arquivo;
    String demais;
    
    public String getCI() {
        return Cod_Incra;
    }
    public void setCI(String Cod_Incra) {
        this.Cod_Incra = Cod_Incra;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getMunicipio(){
        return municipio;
    }
    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }
    public String getCom(){
        return comarca;
    }
    public void setCom(String comarca){
        this.comarca = comarca;
    }
    public String getUF(){
        return uf;
    }
    public void setUF(String uf){
        this.uf = uf;
    }
    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getArea(){
        return area;
    }
    public void setArea(String area){
        this.area = area;
    }
    public String getProc(){
        return processo;
    }
    public void setProc(String processo){
        this.processo = processo;
    }
    public String getArquivo(){
        return arquivo;
    }
    public void setArquivo(String arquivo){
        this.arquivo = arquivo;
    }
    public String getDemais() {
        return demais;
    }
    public void setDemais(String demais) {
        this.demais = demais;
    }
    
}
