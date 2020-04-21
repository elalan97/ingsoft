/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoProveedorProducto;
import Exepciones.NoExisteProducto;
import Exepciones.YaExisteProducto;
import Modelo.ProveedorProducto;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlProvedorProducto {

    BoProveedorProducto bo;

    public CtlProvedorProducto() {

        bo = new BoProveedorProducto();
    }

    public void guardarProducto(ProveedorProducto proveedorProducto) throws YaExisteProducto {

        bo.guardar(proveedorProducto);
    }

    public ProveedorProducto buscarProducto(int id) throws NoExisteProducto {
        return bo.buscar(id);
    }

    public void editarProducto(ProveedorProducto proveedorProducto) throws NoExisteProducto {

        bo.editar(proveedorProducto);
    }

    public void eliminarProveedor(int codigo) throws NoExisteProducto {

        bo.eliminar(codigo);
    }

    public ArrayList<ProveedorProducto> listarProveedor() {

        return bo.listarProvedor();
    }

}
