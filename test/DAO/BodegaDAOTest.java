/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Bodega;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ALAN
 */
public class BodegaDAOTest {

    public BodegaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of guardarBodega method, of class BodegaDAO.
     */
    @Test
    public void testGuardarBodega() {
        System.out.println("guardarBodega");
        Bodega bodega = new Bodega(1, 1, "sao", "Avenida tres puñaladas", "2345");
        BodegaDAO instance = new BodegaDAO();
        boolean expResult = true;
        boolean result = instance.guardarBodega(bodega);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of editarBodega method, of class BodegaDAO.
     */
    @Test
    public void testEditarBodega() {
        System.out.println("editarBodega");
        Bodega bodega = new Bodega(1, 1, "lol", "Avenida tres puñaladas", "12345");
        BodegaDAO instance = new BodegaDAO();
        boolean expResult = true;
        boolean result = instance.editarBodega(bodega);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of buscarBodega method, of class BodegaDAO.
     */
    @Test
    public void testBuscarBodega() {
        System.out.println("buscarBodega");
        int codigo = 1;
        BodegaDAO instance = new BodegaDAO();
        Bodega expResult = null;
        Bodega result = instance.buscarBodega(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of listarBodega method, of class BodegaDAO.
     */
    @Test
    public void testListarBodega() {
        System.out.println("listarBodega");
        BodegaDAO instance = new BodegaDAO();
        ArrayList<Bodega> expResult = null;
        ArrayList<Bodega> result = instance.listarBodega();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
    
        /**
     * Test of eliminarBodega method, of class BodegaDAO.
     */
    @Test
    public void testEliminarBodega() {
        System.out.println("eliminarBodega");
        int codigo = 1;
        BodegaDAO instance = new BodegaDAO();
        boolean expResult = true;
        boolean result = instance.eliminarBodega(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }
    }


}
