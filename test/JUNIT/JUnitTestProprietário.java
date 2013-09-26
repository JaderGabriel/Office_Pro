/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JUNIT;

import dao.UsuarioDAO;
import junit.framework.TestCase;
import modelo.Proprietario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jader
 */
public class JUnitTestProprietário extends TestCase{
     private static Proprietario p;
    public JUnitTestProprietário() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         p = new Proprietario();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    @Override
    public void setUp() {
    }
    
    @After
    @Override
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
    public void testPropret(){
        
        p.setCpfcnpj("122333333");
        p.setNome("TESTE");
        p.setRg("123");
        boolean valida = UsuarioDAO.adiciona(p);
        assertEquals(true,valida);
    }
     
}
