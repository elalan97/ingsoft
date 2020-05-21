/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.PedidoDAO;
import DAO.PedidoProductoDAO;
import DAO.ProductoDAO;
import DTO.pedidoProductoDTO;
import Exepciones.CantidadExedida;
import Exepciones.NoExistePedido;
import Exepciones.YaExistePedido;
import Modelo.Pedido;
import Modelo.PedidoProducto;
import Modelo.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoPedidoProducto {

    PedidoProductoDAO DAO;
    PedidoDAO DAO1;
    ProductoDAO DAO2;

    public BoPedidoProducto() {
        DAO = new PedidoProductoDAO();
        DAO1 = new PedidoDAO();
        DAO2 = new ProductoDAO();
    }

    public void guardar(PedidoProducto pedidoProducto) {

        PedidoProducto p = DAO.buscarCarrito(pedidoProducto.getIdPedido());
        Producto pro = DAO2.buscarProducto(pedidoProducto.getCodigoProducto());
        if (p == null) {

            throw new YaExistePedido();

        }
        if (pedidoProducto.getCantidad() <= pro.getCantidad()) {

            Pedido pedido = DAO1.buscarPedido(pedidoProducto.getIdPedido());
            int id = pedido.getId();
            DAO.guardarCarrito(pedidoProducto, id);
        } else {

            throw new CantidadExedida();
        }

    }

    public PedidoProducto buscar(int codigo) {

        PedidoProducto p = DAO.buscarCarrito(codigo);

        if (p != null) {
            return p;
        } else {

            throw new NoExistePedido();
        }

    }

    public void editar(PedidoProducto pedidoProducto) {

        Pedido pedido = DAO1.buscarPedido(pedidoProducto.getIdPedido());
        PedidoProducto p = DAO.buscarCarrito(pedido.getId());
        if (p == null) {

            throw new NoExistePedido();

        }

        pedidoProducto.setId(p.getId());
        pedidoProducto.setIdPedido(pedido.getId());
        DAO.editarCarrito(pedidoProducto);

    }

    public void eliminar(int codigo) {

        boolean result = DAO.eliminarCarrito(codigo);
        if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExistePedido();
        }
    }

    public ArrayList<pedidoProductoDTO> listar(int codigo) {

        Pedido pedido = DAO1.buscarPedido(codigo);

        int id = pedido.getId();

        return DAO.listarCarrito(id);
    }
}
