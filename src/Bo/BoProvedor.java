/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.ProveedorDAO;
import Exepciones.NoExisteProveedor;
import Exepciones.YaExisteProveedor;
import Modelo.Proveedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author halan
 */
public class BoProvedor {

    ProveedorDAO proveedorDAO;

    public BoProvedor() {
        proveedorDAO = new ProveedorDAO();
    }

    public void guardarProvedor(Proveedor provedor) {

        Proveedor pro = proveedorDAO.buscarProveedor(provedor.getCedula());

        if (pro == null) {
            proveedorDAO.guardarProveedor(provedor);

        } else if (!provedor.getCedula().equals(pro.getCedula())) {
            proveedorDAO.guardarProveedor(provedor);
        } else {
            throw new YaExisteProveedor();
        }

    }

    public Proveedor buscarProveedor(String cedula) {

        Proveedor pro = proveedorDAO.buscarProveedor(cedula);

        if (pro == null) {
            throw new NoExisteProveedor();
        } else if (pro != null) {
            return pro;
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void editarProveedor(Proveedor proveedor) {

        Proveedor pro = buscarProveedor(proveedor.getCedula());

        if (pro != null) {
            proveedorDAO.editarProveedor(proveedor);
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void eliminarProveedor(String cedula) {

        Proveedor pro = buscarProveedor(cedula);

        if (pro != null) {
            boolean result = proveedorDAO.eliminarProveedor(cedula);
        } else if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExisteProveedor();
        }
    }

    public ArrayList<Proveedor> listarProvedor() {
        return proveedorDAO.listarProveedor();
    }
}
