/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Hibernate.NewHibernateUtil;
import factory.ConnectionFactory;
import gui.JDialogCadstAltera;
import gui.JDialogCadstAltera2;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Proprietario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author USuario
 */
public class UsuarioDAO {

    private static Connection connection;

    static String ID_Proprietario;
    static String Nome;
    static String cpf;
    static String rg;
    static String telefone1;
    static String telefone2;
    static String log;
    static String uf;
    static String complemento;
    static String end;
    static String nro;
    static String bairro;
    static String cidade;
    static String cep;
    static String email;

    private static JTable tabela;

    private static void degug(Proprietario verifica) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(verifica.getIdProprietario());
        System.out.println(verifica.getNome());
        System.out.println(verifica.getEmail());
        System.out.println(verifica.getCpfcnpj());
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("-----------------------------");
    }

    public static boolean excluir(Proprietario usuarios) {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {
            Proprietario verifica = null;
            tx = session.beginTransaction();
            Integer busca = usuarios.getIdProprietario();

            Query query = session.createQuery("FROM Proprietario where 	ID_Proprietario =" + busca);
            List list = query.list();
            Iterator iterator = list.iterator();

            if (iterator.hasNext()) {
                verifica = (Proprietario) iterator.next();
            }

            session.delete(verifica);

            tx.commit();

            return true;
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());

        } finally {
            session.close();
        }
        return false;

    }

    public UsuarioDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public static boolean adiciona(Proprietario usuario) {

        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(usuario);
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

    public static List<Proprietario> procuraUser(String nome) {

        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;

        List<Proprietario> p = new ArrayList();
        try {
            if (nome.isEmpty()) {
                p = session.createQuery("FROM Proprietario").list();
            } else {
                p = session.createQuery("FROM Proprietario where nome like ?").setString(0, nome).list();
                System.out.println("Hash do p:" + p);
            }
            

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return p;
    }

    public static Proprietario procuraUserC(String cpfcnpj) {

        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        Proprietario verifica = null;
        Query query = null;
        try {
            query = session.createQuery("FROM Proprietario where CPFCNPJ =" + cpfcnpj);

            List list = query.list();
            Iterator iterator = list.iterator();

            if (iterator.hasNext()) {
                verifica = (Proprietario) iterator.next();
                System.out.println(verifica.getIdProprietario());
                return verifica;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return null;
    }

    public static Proprietario procuraIDUser(String ID_Proprietario) throws SQLException {
        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {

            Query query = session.createQuery("FROM Proprietario where ID_Proprietario = ?").setString(0, ID_Proprietario);
            List rank = query.list();
            Iterator iterator = rank.iterator();
            if (iterator.hasNext()) {
                Proprietario ranking = (Proprietario) iterator.next();
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

    public void procuraIDUser2(String ID_Proprietario) throws SQLException {

        String query;
        query = "SELECT* FROM proprietario  WHERE ID_Proprietario=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ID_Proprietario);

            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Nome = rs.getString("Nome");
                cpf = rs.getString("CPFCNPJ");
                rg = rs.getString("RG");
                log = rs.getString("Logradouro");
                end = rs.getString("End");
                nro = rs.getString("Nro");
                complemento = rs.getString("Complemento");
                bairro = rs.getString("Bairro");
                cidade = rs.getString("Cidade");
                uf = rs.getString("UF");
                cep = rs.getString("CEP");
                telefone1 = rs.getString("TelefoneF");
                telefone2 = rs.getString("TefeloneC");
                email = rs.getString("email");
                JOptionPane.showMessageDialog(null, Nome + "\nCPF/CNPJ: " + cpf + "\nRG: " + rg);
            }
            JDialogCadstAltera pi = new JDialogCadstAltera(null, true);

            // pi.receber(Nome, cpf, rg, log, end, nro, complemento, bairro, cidade, uf, cep, telefone1, telefone2, email);
            if (rs.next() == false && (Nome == null)) {
                JOptionPane.showMessageDialog(null, "NAO ENCONTRADO");
            }
            stmt.execute();
            stmt.close();

        } catch (java.sql.SQLException u) {
            JOptionPane.showMessageDialog(null, "Não encontrado\n" + u.getMessage());
            throw new RuntimeException(u);
        }
    }

    public void procuraIDUser3(String ID_Proprietario) throws SQLException {

        String query;
        query = "SELECT* FROM proprietario  WHERE ID_Proprietario=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ID_Proprietario);

            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Nome = rs.getString("Nome");
                cpf = rs.getString("CPFCNPJ");
                rg = rs.getString("RG");
                log = rs.getString("Logradouro");
                end = rs.getString("End");
                nro = rs.getString("Nro");
                complemento = rs.getString("Complemento");
                bairro = rs.getString("Bairro");
                cidade = rs.getString("Cidade");
                uf = rs.getString("UF");
                cep = rs.getString("CEP");
                telefone1 = rs.getString("TelefoneF");
                telefone2 = rs.getString("TefeloneC");
                email = rs.getString("email");
                JOptionPane.showMessageDialog(null, Nome + "\nCPF/CNPJ: " + cpf + "\nRG: " + rg);
            }
            JDialogCadstAltera2 pi = new JDialogCadstAltera2(null, true);

            //  pi.receber(Nome, cpf, rg, log, end, nro, complemento, bairro, cidade, uf, cep, telefone1, telefone2, email);
            if (rs.next() == false && (Nome == null)) {
                JOptionPane.showMessageDialog(null, "NAO ENCONTRADO");
            }
            stmt.execute();
            stmt.close();

        } catch (java.sql.SQLException u) {
            JOptionPane.showMessageDialog(null, "Não encontrado\n" + u.getMessage());
            throw new RuntimeException(u);
        }
    }

    public static boolean atualiza(Proprietario usuario) {

        SessionFactory sess = NewHibernateUtil.getSessionFactory();
        Session session = sess.openSession();
        org.hibernate.Transaction tx = null;
        try {
            Proprietario verifica = null;
            tx = session.beginTransaction();
            Integer busca = usuario.getIdProprietario();

            Query query = session.createQuery("FROM Proprietario where 	ID_Proprietario =" + busca);
            List list = query.list();
            Iterator iterator = list.iterator();

            if (iterator.hasNext()) {
                verifica = (Proprietario) iterator.next();
            }

            verifica.setBairro(usuario.getBairro());
            verifica.setCep(usuario.getCep());
            verifica.setCidade(usuario.getCidade());
            verifica.setComplemento(usuario.getComplemento());
            verifica.setCpfcnpj(usuario.getCpfcnpj());
            verifica.setEmail(usuario.getEmail());
            verifica.setEnd(usuario.getEnd());
            verifica.setLogradouro(usuario.getLogradouro());
            verifica.setNome(usuario.getNome());
            verifica.setNro(usuario.getNro());
            verifica.setRg(usuario.getRg());
            verifica.setTefeloneC(usuario.getTefeloneC());
            verifica.setTelefoneF(usuario.getTelefoneF());
            verifica.setUf(usuario.getUf());

            session.update(verifica);
            tx.commit();

            return true;
        } catch (Exception u) {
            JOptionPane.showMessageDialog(null, u.getMessage());

        } finally {
            session.close();
        }
        return false;
    }
}
