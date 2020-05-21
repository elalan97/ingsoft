/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoPedidoProducto;
import DTO.pedidoProductoDTO;
import Exepciones.NoExistePedido;
import Exepciones.YaExistePedido;
import Modelo.PedidoProducto;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class CtlPedidoProducto {

    BoPedidoProducto BO;
    
    public CtlPedidoProducto() {
        BO = new BoPedidoProducto();
    }
    
    public void guardarPedido(PedidoProducto pedidoProducto) throws YaExistePedido {
        
        BO.guardar(pedidoProducto);
    }
    
    public PedidoProducto buscarPedido(int codigo) throws NoExistePedido {
        return BO.buscar(codigo);
    }
    
    public void editarPedido(PedidoProducto pedido) throws NoExistePedido {
        
        BO.editar(pedido);
    }
    
    public void eliminarPedido(int codigo) throws NoExistePedido {
        
        BO.eliminar(codigo);
    }
    
    public ArrayList<pedidoProductoDTO> listarCarrito(int codigo) {
        return BO.listar(codigo);
    }
    
}
