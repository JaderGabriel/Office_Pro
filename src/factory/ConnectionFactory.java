/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection; // conexão SQL para Java
import java.sql.DriverManager; // driver de conexão SQL para Java
import java.sql.SQLException; // classe para tratamento de exceções

/**
 *
 * @author USuario
 */
public class ConnectionFactory {

    private static Connection c;
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/programacao";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static String USER = "root";
    private static String PASS = "root";

    
    public Connection getConnection() throws ClassNotFoundException {
      
            try {
                Class.forName(DRIVER_CLASS);
                return DriverManager.getConnection(URL_MYSQL, USER, PASS);
            } catch (SQLException excecao) {
                throw new RuntimeException(excecao);

            }
       
    }
}