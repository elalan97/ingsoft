/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
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
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
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
     * Test of guardarCliente method, of class ClienteDAO.
     */
    @Test
    public void testGuardarCliente() {
        System.out.println("guardarCliente");
        Cliente cliente = new Cliente("123", "mela suda", "100 veces", "askdj", "1234");
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = true;
        boolean result = instance.guardarCliente(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editarCliente method, of class ClienteDAO.
     */
    @Test
    public void testEditarCliente() {
        System.out.println("editarCliente");
        Cliente cliente = new Cliente("123", "mela suda", "cien veces", "askdj", "1234");
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = true;
        boolean result = instance.editarCliente(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of buscarCliente method, of class ClienteDAO.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        String cedula = "123";
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.buscarCliente(cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of eliminarCliente method, of class ClienteDAO.
     */
    @Test
    public void testEliminarCliente() {
        System.out.println("eliminarCliente");
        String cedula = "123";
        ClienteDAO instance = new ClienteDAO();
        boolean expResult = true;
        boolean result = instance.eliminarCliente(cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result == false) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of listarCliente method, of class ClienteDAO.
     */
    @Test
    public void testListarCliente() {
        System.out.println("listarCliente");
        ClienteDAO instance = new ClienteDAO();
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = instance.listarCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
