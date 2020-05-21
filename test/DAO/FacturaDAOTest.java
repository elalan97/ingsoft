/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Factura;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Felipe
 */
public class FacturaDAOTest {
    
    public FacturaDAOTest() {
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
     * Test of guardarFactura method, of class FacturaDAO.
     */
    @Test
    public void testGuardarFactura() {
        System.out.println("guardarFactura");
        Factura factura = new Factura(3, 1, "13", "20/06/2012");
        int id = 0;
        FacturaDAO instance = new FacturaDAO();
        boolean expResult = true;
        boolean result = instance.guardarFactura(factura, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      if (result == false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editarFactura method, of class FacturaDAO.
     */
    @Test
    public void testEditarFactura() {
        System.out.println("editarFactura");
        Factura factura = new Factura(3, 1, "13", "01/05/2012");;
        int id = 0;
        FacturaDAO instance = new FacturaDAO();
        boolean expResult = true;
        boolean result = instance.editarFactura(factura, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
         fail("The test case is a prototype.");
        }
    }

    /**
     * Test of buscarFactura method, of class FacturaDAO.
     */
    @Test
    public void testBuscarFactura() {
        System.out.println("buscarFactura");
        int codigo = 0;
        FacturaDAO instance = new FacturaDAO();
        Factura expResult = null;
        Factura result = instance.buscarFactura(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarFactura method, of class FacturaDAO.
     */
    @Test
    public void testEliminarFactura() {
        System.out.println("eliminarFactura");
        int codigo = 3;
        FacturaDAO instance = new FacturaDAO();
        boolean expResult = false;
        boolean result = instance.eliminarFactura(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of listarFactura method, of class FacturaDAO.
     */
    @Test
    public void testListarFactura() {
        System.out.println("listarFactura");
        int codigoVendedor = 0;
        FacturaDAO instance = new FacturaDAO();
        ArrayList<Factura> expResult = null;
        ArrayList<Factura> result = instance.listarFactura(codigoVendedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
