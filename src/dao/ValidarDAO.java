/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Hibernate.NewHibernateUtil;
import modelo.Validar;
import java.util.Iterator;
import java.util.List;
import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jader
 */
public class ValidarDAO {
    

    public static boolean adiciona(Validar uk) {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(uk);
            tx.commit();
            session.flush();
             return true;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return false;
        
    }
    public static boolean excluir(String nome) {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        Transaction tx = null;
        Validar ranking = null;
        try {
             session = sess.openSession();
             tx = session.beginTransaction();
            Query query = session.createQuery("FROM Validar where Usuario = ?").setString(0, nome);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                 ranking = (Validar) iterator.next();
                
            }
            session.delete(ranking);
            tx.commit();
            return true;
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return false;
        
    }
     public static Validar logar(String nomeUsuario) {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = null;
        try {
             session = sess.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery("FROM Validar where Usuario = ?").setString(0, nomeUsuario);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                Validar ranking = (Validar) iterator.next();
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
     public static boolean buscarUser(String nome){
          SessionFactory sess = NewHibernateUtil.getSessionFactory();
            Session session = null;
            try {
             session = sess.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createQuery("FROM Validar where Usuario = ?").setString(0, nome);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                Validar ranking = (Validar) iterator.next();
                return true;
            }
            tx.commit();
            session.flush();
            //System.out.println(list);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return false;
     }
    
}
