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

    public void guardarCliente(Vendedor vendedor, String Nombre) throws YaExisteProducto {

        bo.guardar(vendedor, Nombre);
    }

    public Vendedor buscarCliente(int codigo) throws NoExisteProducto {
        return bo.buscar(codigo);
    }

    public void editarCliente(Vendedor vendedor, String Nombre) throws NoExisteProducto {

        bo.editar(vendedor, Nombre);
    }

    public void eliminarCliente(int codigo) throws NoExisteProducto {

        bo.eliminar(codigo);
    }

    public ArrayList<Vendedor> listarCliente() {

        return bo.listarVendedor();
    }
}
