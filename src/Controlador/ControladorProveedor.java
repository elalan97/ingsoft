/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoProvedor;
import Exepciones.NoExisteProveedor;
import Exepciones.YaExisteProveedor;
import Modelo.Proveedor;
import java.util.ArrayList;

/**
 *
 * @author halan
 */
public class ControladorProveedor {

    BoProvedor proveedorBo;

    public ControladorProveedor() {

        proveedorBo = new BoProvedor();
    }

    public void guardarProveedor(Proveedor proveedor) throws YaExisteProveedor {

        proveedorBo.guardarProvedor(proveedor);
    }

    public Proveedor buscarProveedor(String cedula) throws NoExisteProveedor {
        return proveedorBo.buscarProveedor(cedula);
    }

    public void editarProveedor(Proveedor proveedor) throws NoExisteProveedor {

        proveedorBo.editarProveedor(proveedor);
    }

    public void eliminarProveedor(String cedula) throws NoExisteProveedor {

        proveedorBo.eliminarProveedor(cedula);
    }
    
    public ArrayList<Proveedor> listarProveedor(){
        
        return proveedorBo.listarProvedor();
    }
}
