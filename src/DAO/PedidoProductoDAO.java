/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import DTO.pedidoProductoDTO;
import Modelo.PedidoProducto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class PedidoProductoDAO extends Conexion {

    public PedidoProductoDAO() {
    }

    public boolean guardarCarrito(PedidoProducto pedidoProducto, int id) {
        String consulta = "INSERT INTO pedido_producto (idPedido,"
                + "codigoProducto, precio, cantidad)"
                + "VALUES ('" + id + "', '" + pedidoProducto.getCodigoProducto() + "', '"
                + pedidoProducto.getPrecio() + "', '"
                + pedidoProducto.getCantidad() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarCarrito(PedidoProducto pedidoProducto) {
        String consulta = "UPDATE pedido_producto SET idPedido='" + pedidoProducto.getIdPedido() + "', "
                + " codigoProducto='" + pedidoProducto.getCodigoProducto() + "', precio='" + pedidoProducto.getPrecio() + "', "
                + " cantidad='" + pedidoProducto.getCantidad() + "'"
                + " WHERE id='" + pedidoProducto.getId() + "'";
        return super.ejecutar(consulta);

    }

    public PedidoProducto buscarCarrito(int codigo) {
        String consulta = "select id, idPedido, codigoProducto, precio, cantidad from pedido_producto \n"
                + "where idPedido ='" + codigo + "';";
        PedidoProducto p = new PedidoProducto();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                p.setId(resultadoDB.getInt("id"));
                p.setIdPedido(resultadoDB.getInt("idPedido"));
                p.setCodigoProducto(resultadoDB.getInt("codigoProducto"));
                p.setPrecio(resultadoDB.getInt("precio"));
                p.setCantidad(resultadoDB.getInt("cantidad"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return p;
    }

    public boolean eliminarCarrito(int codigo) {
        String consulta = "DELETE FROM pedido_producto where codigoProducto = " + codigo + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<pedidoProductoDTO> listarCarrito(int codigo) {
        ArrayList<pedidoProductoDTO> lista = new ArrayList<>();
        String consulta = "select pro.codigo, pro.nombre, pp.cantidad, pro.precio, pp.precio from pedido_producto pp\n"
                + "join producto pro on pro.codigo = pp.codigoProducto\n"
                + "where pp.idPedido = '" + codigo + "';";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                pedidoProductoDTO p = new pedidoProductoDTO();

                p.setCantidad(resultadoDB.getInt("pp.cantidad"));
                p.setCodigo(resultadoDB.getInt("pro.codigo"));
                p.setNombre(resultadoDB.getString("pro.nombre"));
                p.setPrecio(resultadoDB.getInt("pp.precio"));
                p.setPrecioProducto(resultadoDB.getInt("pro.precio"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
}
