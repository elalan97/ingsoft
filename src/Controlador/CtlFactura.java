/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoFactura;
import Exepciones.NoExisteProducto;
import Exepciones.YaExisteCliente;
import Modelo.Factura;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlFactura {

    BoFactura BO;

    public CtlFactura() {

        BO = new BoFactura();
    }

    public void guardarFactura(Factura factura) throws YaExisteCliente {

        BO.guardar(factura);
    }

    public Factura buscarFactura(int codigo) throws NoExisteProducto {
        return BO.buscar(codigo);
    }

    public void editarFactura(Factura factura) throws NoExisteProducto {

        BO.editar(factura);
    }

    public void eliminarFactura(int codigo) throws NoExisteProducto {

        BO.eliminar(codigo);
    }

    public ArrayList<Factura> listarFactura(String codigoVendedor) {

        return BO.listar(codigoVendedor);
    }

}
