/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.ProveedorDAO;
import DAO.VendedorDAO;
import Exepciones.NoExisteProveedor;
import Exepciones.YaExisteProducto;
import Exepciones.YaExisteVendedor;
import Modelo.Proveedor;
import Modelo.Vendedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoVendedor {

    VendedorDAO dao;

    public BoVendedor() {
        dao = new VendedorDAO();
    }

    public void guardar(Vendedor vendedor, String Nombre) {

        Vendedor ve = dao.buscarVendedor(vendedor.getCodigo());

        if (ve != null) {

            if (ve.getCodigo() == vendedor.getCodigo()) {

                throw new YaExisteVendedor();
            }
        }
        
        Proveedor pro = dao.buscarProveedor(Nombre);
        
        vendedor.setCedulaProveedor(pro.getCedula());

        dao.guardarVendedor(vendedor);

    }

    public Vendedor buscar(int codigo) {

        Vendedor ve = dao.buscarVendedor(codigo);

        if (ve == null) {
            throw new NoExisteProveedor();
        } else if (ve != null) {
            return ve;
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void editar(Vendedor vendedor, String Nombre) {
        
        Proveedor pro = dao.buscarProveedor(Nombre);
        
        vendedor.setCedulaProveedor(pro.getCedula());

        dao.editarVendedor(vendedor);

    }

    public void eliminar(int codigo) {

        Vendedor ve = dao.buscarVendedor(codigo);

        if (ve != null) {
            boolean result = dao.eliminarVendedor(codigo);
        } else if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExisteProveedor();
        }
    }

    public ArrayList<Vendedor> listarVendedor() {
        return dao.listarVendedor();
    }

}
