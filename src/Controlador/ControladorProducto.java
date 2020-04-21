/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoProducto;
import Exepciones.NoExisteProducto;
import Exepciones.YaExisteProducto;
import Modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author halan
 */
public class ControladorProducto {
    BoProducto boProducto;

    public ControladorProducto() {
        boProducto = new BoProducto();
    }
    
    
        public void guardarProducto(Producto producto, String categoria) throws YaExisteProducto{

        boProducto.guardar(producto, categoria);
    }

    public Producto buscarProducto(int codigo) throws NoExisteProducto {
        return boProducto.buscar(codigo);
    }

    public void editarProducto(Producto producto, String categoria) throws NoExisteProducto {

        boProducto.editar(producto, categoria);
    }

    public void eliminarProveedor(int codigo) throws NoExisteProducto {

        boProducto.eliminar(codigo);
    }
    
    public ArrayList<Producto> listarProveedor(){
        
        return boProducto.listarProvedor();
    }
    
}
