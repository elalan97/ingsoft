/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.PedidoDAO;
import DAO.PedidoProductoDAO;
import DAO.ProductoDAO;
import DTO.PedidoDTO;
import DTO.pedidoProductoDTO;
import Exepciones.NoExistePedido;
import Exepciones.YaExistePedido;
import Modelo.Pedido;
import Modelo.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoPedido {

    PedidoDAO DAO;
    PedidoProductoDAO DAO2;
    ProductoDAO DAO3;

    public BoPedido() {

        DAO = new PedidoDAO();
        DAO2 = new PedidoProductoDAO();
        DAO3 = new ProductoDAO();
    }

    public void guardar(Pedido pedido) {

        Pedido p = DAO.buscarPedido(pedido.getCodigo());
        if (p != null) {

            if (p.getEstado() == null) {
                DAO.guardarPedido(pedido);
            } else {
                throw new YaExistePedido();
            }

        }

    }

    public Pedido buscar(int codigo) {

        Pedido p = DAO.buscarPedido(codigo);

        if (p != null) {
            return p;
        } else {

            throw new NoExistePedido();
        }

    }

    public void editar(Pedido pedido) {

        Pedido p = DAO.buscarPedido(pedido.getCodigo());
        if (p == null) {

            throw new NoExistePedido();

        }

        pedido.setId(p.getId());
        DAO.editarPedido(pedido);

    }

    public void eliminar(int codigo) {

        boolean result = DAO.eliminarPedido(codigo);
        if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExistePedido();
        }
    }

    public ArrayList<Pedido> listarPedido() {
        return DAO.listarPedido();
    }

    public PedidoDTO buscarPedidoDTO(int codigo) {

        return DAO.buscarPedidoDTO(codigo);
    }

    public Pedido buscarPorCedula(String cedula) {

        Pedido p = DAO.buscarPedidoPorCedulaCliente(cedula);

        if (p != null) {
            return p;
        } else {

            throw new NoExistePedido();
        }

    }

    public void editar1(Pedido pedido) {

        int total = 0;
        Pedido p = DAO.buscarPedido(pedido.getCodigo());
        ArrayList<pedidoProductoDTO> list = DAO2.listarCarrito(p.getId());
        if (p == null) {

            throw new NoExistePedido();

        }
        
        for (int i = 0; i < list.size(); i++) {
            
            Producto pro = DAO3.buscarProducto(list.get(i).getCodigo());
            
            total = pro.getCantidad() - list.get(i).getCantidad();
            
            DAO3.editarProducto(new Producto(pro.getNombre(), pro.getFechaVencimiento(), pro.getCategoria(), pro.getPrecio(), 
                    pro.getCodigo(), total));
            
            
            
        }

        pedido.setId(p.getId());
        DAO.editarPedido(pedido);

    }

}
