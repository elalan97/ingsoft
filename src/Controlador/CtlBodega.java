/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoBodega;
import Exepciones.NoExisteProducto;
import Exepciones.YaExisteBodega;
import Exepciones.YaExisteProducto;
import Modelo.Bodega;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlBodega {

    BoBodega BO;

    public CtlBodega() {
        BO = new BoBodega();
    }

    public void guardarProducto(Bodega bodega) throws YaExisteBodega {

        BO.guardar(bodega);
    }

    public Bodega buscarProducto(int codigo) throws NoExisteProducto {
        return BO.buscar(codigo);
    }

    public void editarProducto(Bodega bodega) throws NoExisteProducto {

        BO.editar(bodega);
    }

    public void eliminarProveedor(int codigo) throws NoExisteProducto {

        BO.eliminar(codigo);
    }

    public ArrayList<Bodega> listarProveedor() {

        return BO.listarBodega();
    }

}
