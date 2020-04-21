/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.ProveedorProductoDAO;
import Exepciones.NoExisteProveedor;
import Exepciones.YaExisteProducto;
import Modelo.ProveedorProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoProveedorProducto {

    ProveedorProductoDAO dao;

    public BoProveedorProducto() {

        dao = new ProveedorProductoDAO();
    }

    public void guardar(ProveedorProducto provedorProducto) {

        ProveedorProducto pro = dao.buscarProveedor(provedorProducto.getId());

        if (pro != null) {

            if (pro.getId() == provedorProducto.getId()) {

                throw new YaExisteProducto();
            }
        }
            dao.guardarProveedor(provedorProducto);

    }

    public ProveedorProducto buscar(int id) {

        ProveedorProducto pro = dao.buscarProveedor(id);

        if (pro == null) {
            throw new NoExisteProveedor();
        } else if (pro != null) {
            return pro;
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void editar(ProveedorProducto proveedorProducto) {

        ProveedorProducto pro = dao.buscarProveedor(proveedorProducto.getId());

        if (pro != null) {
            dao.editarProveedor(proveedorProducto);
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void eliminar(int id) {

        ProveedorProducto pro = dao.buscarProveedor(id);

        if (pro != null) {
            boolean result = dao.eliminarProveedor(id);
        } else if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExisteProveedor();
        }
    }

    public ArrayList<ProveedorProducto> listarProvedor() {
        return dao.listarProveedor();
    }

}
