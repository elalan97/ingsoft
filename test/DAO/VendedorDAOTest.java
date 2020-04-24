/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Proveedor;
import Modelo.Vendedor;
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
public class VendedorDAOTest {

    public VendedorDAOTest() {
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
     * Test of guardarVendedor method, of class VendedorDAO.
     */
    @Test
    public void testGuardarVendedor() {
        System.out.println("guardarVendedor");
        Vendedor vendedor = new Vendedor(1, "123", "que mira", "sapo", "lol", "1234", "1");
        VendedorDAO instance = new VendedorDAO();
        boolean expResult = true;
        boolean result = instance.guardarVendedor(vendedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editarVendedor method, of class VendedorDAO.
     */
    @Test
    public void testEditarVendedor() {
        System.out.println("editarVendedor");
        Vendedor vendedor = new Vendedor(1, "123", "halan", "gonzalez", "lol", "1234", "1");
        VendedorDAO instance = new VendedorDAO();
        boolean expResult = true;
        boolean result = instance.editarVendedor(vendedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of buscarVendedor method, of class VendedorDAO.
     */
    @Test
    public void testBuscarVendedor() {
        System.out.println("buscarVendedor");
        int codigo = 1;
        VendedorDAO instance = new VendedorDAO();
        Vendedor expResult = null;
        Vendedor result = instance.buscarVendedor(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarVendedor method, of class VendedorDAO.
     */
    @Test
    public void testEliminarVendedor() {
        System.out.println("eliminarVendedor");
        int codigo = 1;
        VendedorDAO instance = new VendedorDAO();
        boolean expResult = true;
        boolean result = instance.eliminarVendedor(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of listarVendedor method, of class VendedorDAO.
     */
    @Test
    public void testListarVendedor() {
        System.out.println("listarVendedor");
        VendedorDAO instance = new VendedorDAO();
        ArrayList<Vendedor> expResult = null;
        ArrayList<Vendedor> result = instance.listarVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProveedor method, of class VendedorDAO.
     */

}
