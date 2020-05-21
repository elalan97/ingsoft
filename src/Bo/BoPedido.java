/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.PedidoDAO;
import DTO.PedidoDTO;
import Exepciones.NoExistePedido;
import Exepciones.YaExistePedido;
import Modelo.Pedido;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoPedido {

    PedidoDAO DAO;

    public BoPedido() {

        DAO = new PedidoDAO();
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

}
