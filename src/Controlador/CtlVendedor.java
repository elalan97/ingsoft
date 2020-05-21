/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoVendedor;
import Exepciones.NoExisteProducto;
import Exepciones.YaExisteProducto;
import Modelo.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlVendedor {

    BoVendedor bo;

    public CtlVendedor() {

        bo = new BoVendedor();
    }

    public void guardarCliente(Vendedor vendedor) throws YaExisteProducto {

        bo.guardar(vendedor);
    }

    public Vendedor buscarCliente(int codigo) throws NoExisteProducto {
        return bo.buscar(codigo);
    }

    public void editarCliente(Vendedor vendedor) throws NoExisteProducto {

        bo.editar(vendedor);
    }

    public void eliminarCliente(int codigo) throws NoExisteProducto {

        bo.eliminar(codigo);
    }

    public ArrayList<Vendedor> listarCliente() {

        return bo.listarVendedor();
    }

    public Vendedor buscarVendedor(String cedula) throws NoExisteProducto {
        return bo.buscarVendedor(cedula);
    }
}
