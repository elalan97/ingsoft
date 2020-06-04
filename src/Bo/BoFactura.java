/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.FacturaDAO;
import DAO.PedidoDAO;
import DAO.VendedorDAO;
import Exepciones.NoExisteProveedor;
import Exepciones.YaExisteCliente;
import Modelo.Factura;
import Modelo.Pedido;
import Modelo.Vendedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoFactura {

    FacturaDAO DAO;
    PedidoDAO DAO1;
    VendedorDAO DAO2;

    public BoFactura() {
        DAO = new FacturaDAO();
        DAO1 = new PedidoDAO();
        DAO2 = new VendedorDAO();
    }

    public void guardar(Factura factura) {

        int id;
        
        
        
        Factura fac = DAO.buscarFactura(factura.getCodigo());
        Pedido pe = DAO1.buscarPedido(factura.getCodigo());

        if (fac != null) {

            if (fac.getFechaEmision() == null) {
                id = pe.getId();
                DAO.guardarFactura(factura, id);
            } else {
                throw new YaExisteCliente();
            }

        }

    }

    public Factura buscar(int codigo) {

        Factura fac = DAO.buscarFactura(codigo);

        if (fac == null) {
            throw new NoExisteProveedor();
        } else if (fac != null) {
            return fac;
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void editar(Factura factura) {

        Pedido pe = DAO1.buscarPedido(factura.getCodigo());
        int id = pe.getId();
        DAO.editarFactura(factura, id);

    }

    public void eliminar(int codigo) {

        Pedido pe = DAO1.buscarPedido(codigo);
        int id = pe.getId();
        boolean result = DAO.eliminarFactura(id);
        if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExisteProveedor();
        }
    }

    public ArrayList<Factura> listar(String codigoVendedor) {

        Vendedor ve = DAO2.buscarVendedor1(codigoVendedor);
        return DAO.listarFactura(ve.getId());
    }

}
