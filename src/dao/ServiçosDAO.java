/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Hibernate.NewHibernateUtil;
import Hibernate.Servicos;
import factory.ConnectionFactory;
import gui.JDialogProImo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.serviços;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author USuario
 */
public class ServiçosDAO {

    private Connection connection;
    String cod;
    String nome;
    String valor;
    String moeda;
    String Comentario;

    public ServiçosDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(serviços serv) {

        String sql = "INSERT INTO servicos(Descricao,Moeda,Valor,Comentarios) VALUES(?,?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setString(1, serv.getNome());
                stmt.setString(2, serv.getMoeda());
                stmt.setString(3, serv.getValor());
                stmt.setString(4, serv.getCom());


                stmt.execute();
            }

        } catch (SQLException | RuntimeException u) {
            JOptionPane.showMessageDialog(null, "PROBLEMA\n" + u);
            //   throw new RuntimeException(u);
        }


    }

    public Servicos procuraIDService(String ID) throws SQLException {

         SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {

            Query query = session.createQuery("FROM Servicos where CodS = ?").setString(0, ID);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                Servicos  ranking = (Servicos ) iterator.next();
                System.out.println(ranking.getDescricao());
               return ranking;
            }
            tx.commit();
            session.flush();
            //System.out.println(list);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    
    }
    public List<Servicos> procuraNome(String Nome) throws SQLException {

        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        
        List<Servicos> p = new ArrayList();
        try {
            p = session.createQuery("FROM Servicos where Descricao like ?").setString(0, Nome).list();
            System.out.println("Hash do p:"  + p);
            
           /* for (int i = 0; i < tamanhoBusca; i++) {
                Proprietario prop = p.get(i);
                System.out.println("Hash do p:"  + p);
                System.out.println("\n"  + prop.getNome());
            }*/
           
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return p;
    }
    public boolean realizaincra(serviços serv) {

        String sql = "INSERT INTO proprietarioimovel_serviços(ID_Proprietario,Cod_Incra,CodS,Valor,DataRealizacao,Demais) VALUES(?,?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setString(1, serv.getID());
                stmt.setString(2, serv.getCI());
                stmt.setString(3, serv.getCod());
                stmt.setString(4, serv.getValor());
                stmt.setString(5, serv.getData());
                stmt.setString(6, serv.getDemais());
                
                stmt.execute();
                return true;
            }

        } catch (SQLException | RuntimeException u) {
            JOptionPane.showMessageDialog(null, "PROBLEMA\n" + u);
            //   throw new RuntimeException(u);
        }

            return false;
    }
    public boolean realizaoutros(serviços serv) {

        String sql = "INSERT INTO proprietarioimovel2_servicos(ID_Proprietario,Cod_Incra,CodS,Valor,DataRealizacao,Demais) VALUES(?,?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setString(1, serv.getID());
                stmt.setString(2, serv.getCI());
                stmt.setString(3, serv.getCod());
                stmt.setString(4, serv.getValor());
                stmt.setString(5, serv.getData());
                stmt.setString(6, serv.getDemais());
                


                stmt.execute();
                return true;
            }

        } catch (SQLException | RuntimeException u) {
            JOptionPane.showMessageDialog(null, "PROBLEMA\n" + u);
            //   throw new RuntimeException(u);
        }

            return false;
    }
}
