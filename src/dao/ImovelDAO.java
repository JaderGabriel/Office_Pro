/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Hibernate.Imovel2;
import Hibernate.Imovelincra;
import Hibernate.NewHibernateUtil;
import factory.ConnectionFactory;
import gui.JDialogProImo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Imovel;
import modelo.serviços;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author USuario
 */
public class ImovelDAO {

    private Connection connection;
    String Cod_Incra;
    String nome;
    String municipio;
    String uf;
    String matricula;
    String comarca;
    String area;
    String processo;
    String arquivo;
    String cod;

    public ImovelDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionaIncra(Imovel imovel) {

        String sql = "INSERT INTO imovelIncra(Cod_Incra,Nome,Municipio,Comarca,UF,Matricula,Área,TipoProcesso, NomeArquivo,Demais) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setString(1, imovel.getCI());
                stmt.setString(2, imovel.getNome());
                stmt.setString(3, imovel.getMunicipio());
                stmt.setString(4, imovel.getCom());
                stmt.setString(5, imovel.getUF());
                stmt.setString(6, imovel.getMatricula());
                stmt.setString(7, imovel.getArea());
                stmt.setString(8, imovel.getProc());
                stmt.setString(9, imovel.getArquivo());
                stmt.setString(10, imovel.getDemais());


                stmt.execute();
            }

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u.getMessage());
            throw new RuntimeException(u);
        }
    }
    public boolean adicionaOutros(Imovel2 imovel) {

       SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(imovel);
            tx.commit();
            session.flush();
            return true;
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());

        } finally {
            session.close();
        }
        return false;
    }
    
    
   
    public Imovelincra procuraIDUser(String COD) throws SQLException {
       
         SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {
             
            Query query = session.createQuery("FROM Imovelincra where Cod_Incra ="+COD);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                Imovelincra  ranking = (Imovelincra ) iterator.next();
                
                System.out.println(ranking.getNome());
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
   
    public Imovel2 procuraIDUserO(String COD) throws SQLException {
       SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {

            Query query = session.createQuery("FROM  Imovel2 where Matricula = ?").setString(0, COD);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                 Imovel2  ranking = ( Imovel2 ) iterator.next();
                System.out.println(ranking.getNome());
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
    public void procuraNome(String Nome, int opc) throws SQLException {
        String queryincra;
        String queryoutros;
        queryincra = "SELECT* FROM imovelincra WHERE Nome like ?";
        queryoutros = "SELECT* FROM imovel2 WHERE Nome like ?";

        try (PreparedStatement stmt = connection.prepareStatement(queryincra)) {
            stmt.setString(1, Nome);

            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                cod = rs.getString("Cod_Incra");
                nome = rs.getString("nome");
                JOptionPane.showMessageDialog(null, nome);     
            }if(rs.next()==false && (nome == null)){
                JOptionPane.showMessageDialog(null, "NAO ENCONTRADO");
            }
        }
    }
    public static Imovel2 verImovel2(String Busca) {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {
            Imovel2 verifica = null;
            tx = session.beginTransaction();
            

            Query query = session.createQuery("FROM Imovel2 where Matricula =" + Busca);
            List list = query.list();
            Iterator iterator = list.iterator();

            if (iterator.hasNext()) {
                verifica = (Imovel2) iterator.next();
            }

            //session.delete(verifica);

            tx.commit();

            return verifica;
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());

        } finally {
            session.close();
        }
        return null;

    }
     public static Imovelincra verImovel(String Busca) {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {
            Imovelincra verifica = null;
            tx = session.beginTransaction();
            

            Query query = session.createQuery("FROM Imovelincra where Cod_Incra =" + Busca);
            List list = query.list();
            Iterator iterator = list.iterator();

            if (iterator.hasNext()) {
                verifica = (Imovelincra) iterator.next();
            }

            //session.delete(verifica);

            tx.commit();

            return verifica;
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());

        } finally {
            session.close();
        }
        return null;

    }
}
