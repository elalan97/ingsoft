/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import DTO.PedidoDTO;
import Modelo.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class PedidoDAO extends Conexion {

    public PedidoDAO() {
    }

    public boolean guardarPedido(Pedido pedido) {
        String consulta = "INSERT INTO pedido (codigo,"
                + "estado, cedulaCliente, total)"
                + "VALUES ('" + pedido.getCodigo() + "', '" + pedido.getEstado() + "', '"
                + pedido.getCedulaCliente() + "', '"
                + pedido.getTotal() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarPedido(Pedido pedido) {
        String consulta = "UPDATE pedido SET codigo='" + pedido.getCodigo() + "', "
                + " estado='" + pedido.getEstado() + "', "
                + " cedulaCliente='" + pedido.getCedulaCliente() + "', "
                + " total='" + pedido.getTotal() + "' "
                + " WHERE id='" + pedido.getId() + "'";
        return super.ejecutar(consulta);

    }

    public Pedido buscarPedido(int codigo) {
        String consulta = "select id, codigo, "
                + " estado, cedulaCliente from pedido where codigo ='" + codigo + "'";
        Pedido p = new Pedido();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                p.setId(resultadoDB.getInt("id"));
                p.setCodigo(resultadoDB.getInt("codigo"));
                p.setEstado(resultadoDB.getString("estado"));
                p.setCedulaCliente(resultadoDB.getString("cedulaCliente"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return p;
    }

    public boolean eliminarPedido(int codigo) {
        String consulta = "DELETE FROM pedido where codigo = " + codigo + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Pedido> listarPedido() {
        ArrayList<Pedido> lista = new ArrayList<>();
        String consulta = "select * from pedido";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Pedido p = new Pedido();
                p.setId(resultadoDB.getInt("id"));
                p.setCodigo(resultadoDB.getInt("codigo"));
                p.setEstado(resultadoDB.getString("estado"));
                p.setCedulaCliente(resultadoDB.getString("cedulaCliente"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public PedidoDTO buscarPedidoDTO(int codigo) {
        String consulta = "select p.codigo, c.cedula, c.nombre, c.apellido, p.total from pedido p\n"
                + "join cliente c on c.cedula = p.cedulaCliente\n"
                + "where p.codigo = " + codigo + ";";
        PedidoDTO p = new PedidoDTO();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                p.setCodigo(resultadoDB.getInt("p.codigo"));
                p.setCedula(resultadoDB.getString("c.cedula"));
                p.setNombre(resultadoDB.getString("c.nombre"));
                p.setApellido(resultadoDB.getString("c.apellido"));
                p.setTotal(resultadoDB.getInt("p.total"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return p;
    }

    public Pedido buscarPedidoPorCedulaCliente(String cedula) {
        String consulta = "select id, codigo, "
                + " estado, cedulaCliente from pedido where cedulaCliente ='" + cedula + "'";
        Pedido p = new Pedido();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                p.setId(resultadoDB.getInt("id"));
                p.setCodigo(resultadoDB.getInt("codigo"));
                p.setEstado(resultadoDB.getString("estado"));
                p.setCedulaCliente(resultadoDB.getString("cedulaCliente"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return p;
    }
}
