/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.xml.crypto.Data;

/**
 *
 * @author USuario
 */
public class serviços {
    String cod;
    String nome;
    String valor;
    String moeda;
    String Comentario;
    String ID_Proprietario;
    String Cod_Incra;
    String matricula;
    String demais;
    String data;
    public String getDemais() {
        return demais;
    }
    public void setDemais(String demais) {
        this.demais = demais;
    }
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getCI() {
        return Cod_Incra;
    }
    public void setCI(String Cod_Incra) {
        this.Cod_Incra = Cod_Incra;
    }
    public String getID() {
        return ID_Proprietario;
    }
    public void setID(String ID_Proprietario) {
        this.ID_Proprietario = ID_Proprietario;
    }
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
    public String getCom() {
        return Comentario;
    }

    public void setCom(String Comentario) {
        this.Comentario = Comentario;
    }
}
