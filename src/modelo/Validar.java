package modelo;
// Generated 02/07/2013 03:06:14 by Hibernate Tools 3.6.0



/**
 * Validar generated by hbm2java
 */
public class Validar  implements java.io.Serializable {


     private String usuario;
     private String senha;
     private String tipo;

    public Validar() {
    }

	
    public Validar(String usuario, String tipo) {
        this.usuario = usuario;
        this.tipo = tipo;
    }
    public Validar(String usuario, String senha, String tipo) {
       this.usuario = usuario;
       this.senha = senha;
       this.tipo = tipo;
    }
   
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}


