/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USuario
 */
public class ProImovel {

    String ID_Proprietario;
    String Cod_Incra;
    String demais;

    public String getID() {
        return ID_Proprietario;
    }

    public void setID(String ID_Proprietario) {
        this.ID_Proprietario = ID_Proprietario;
    }

    public String getCI() {
        return Cod_Incra;
    }

    public void setCI(String Cod_Incra) {
        this.Cod_Incra = Cod_Incra;
    }
    public String getCom(){
        return demais;
    }
    public void setCom(String demais){
        this.demais = demais;
    }
}
