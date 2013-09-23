/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Hibernate.Imovel2;
import Hibernate.Imovelincra;
import Hibernate.NewHibernateUtil;
import Hibernate.Proprietarioimovel2;
import Hibernate.Proprietarioimoveli;
import Hibernate.ProprietarioimoveliId;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ProImovel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author USuario
 */
public class ProImovelDAO {

    private Connection connection;

    public ProImovelDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(ProImovel pi) {

        String sql = "INSERT INTO ProprietarioImovelI(ID_Proprietario,Cod_Incra,Demais) VALUES(?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, pi.getID());
                stmt.setString(2, pi.getCI());
                stmt.setString(3, pi.getCom());

                stmt.execute();
            }

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
            
        }
    }

    public void adicionaOutros(ProImovel pi) {

        String sql = "INSERT INTO proprietarioimovel2(ID_Proprietario,Matricula,Demais) VALUES(?,?,?)";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, pi.getID());
                stmt.setString(2, pi.getCI());
                stmt.setString(3, pi.getCom());

                stmt.execute();
            }

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, u);
            throw new RuntimeException(u);
        }
    }

    public List<Proprietarioimoveli> buscaProprietarioIncra(String ID) {

        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;

        List<Proprietarioimoveli> p = new ArrayList();
        
        try {
             
            p = session.createQuery("from Proprietarioimoveli where ID_Proprietario = ?").setString(0, ID).list();
           /* for (int i = 0; i < p.size(); i++) {
                
            }
*/
            
        } catch (HibernateException e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return p;
    }

    public Imovelincra buscaPropriedadeIncra(String ID) {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {

            Query query = session.createQuery("FROM Imovelincra where Cod_Incra = ?").setString(0, ID);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                Imovelincra ranking = (Imovelincra) iterator.next();
                
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
    public List<Proprietarioimovel2> buscaProprietarioOutros(String ID) {

        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;

        List<Proprietarioimovel2> p = new ArrayList();
        
        try {

            p = session.createQuery("from Proprietarioimovel2 where ID_Proprietario = ?").setString(0, ID).list();
         /*   for (int i = 0; i < p.size(); i++) {
                
            }

           */
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return p;
    }

    public Imovel2 buscaPropriedade2(String ID) {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {

            Query query = session.createQuery("FROM Imovel2 where Matricula = ?").setString(0, ID);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                Imovel2 ranking = (Imovel2) iterator.next();
                
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
}
