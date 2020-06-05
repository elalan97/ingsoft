/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoPedido;
import DTO.PedidoDTO;
import Exepciones.NoExistePedido;
import Exepciones.NoExisteProducto;
import Exepciones.YaExistePedido;
import Exepciones.YaExisteProducto;
import Modelo.Pedido;
import Modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlPedido {

    BoPedido BO;

    public CtlPedido() {
        BO = new BoPedido();
    }

    public void guardarPedido(Pedido pedido) throws YaExistePedido {

        BO.guardar(pedido);
    }

    public Pedido buscarPedido(int codigo) throws NoExistePedido {
        return BO.buscar(codigo);
    }

    public void editarPedido(Pedido pedido) throws NoExistePedido {

        BO.editar(pedido);
    }

    public void eliminarPedido(int codigo) throws NoExistePedido {

        BO.eliminar(codigo);
    }

    public ArrayList<Pedido> listarPedido() {

        return BO.listarPedido();
    }

    public PedidoDTO buscarPedidoDTO(int codigo) throws NoExistePedido {
        return BO.buscarPedidoDTO(codigo);
    }

    public Pedido buscarPedidoPorCedula(String cedula) throws NoExistePedido {
        return BO.buscarPorCedula(cedula);
    }

    public void editarPedido1(Pedido pedido) throws NoExistePedido {

        BO.editar1(pedido);
    }
}
