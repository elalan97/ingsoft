/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoCliente;
import Exepciones.NoExisteProducto;
import Exepciones.YaExisteCliente;
import Exepciones.YaExisteProducto;
import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlCliente {

    BoCliente bo;

    public CtlCliente() {
        bo = new BoCliente();
    }

    public void guardarCliente(Cliente cliente) throws YaExisteCliente{

        bo.guardar(cliente);
    }

    public Cliente buscarCliente(String cedula) throws NoExisteProducto {
        return bo.buscar(cedula);
    }

    public void editarCliente(Cliente cliente) throws NoExisteProducto {

        bo.editar(cliente);
    }

    public void eliminarCliente(String cedula) throws NoExisteProducto {

        bo.eliminar(cedula);
    }

    public ArrayList<Cliente> listarCliente() {

        return bo.listarCliente();
    }

}
