/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.ProveedorProducto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class ProveedorProductoDAO extends Conexion {

    public ProveedorProductoDAO() {
    }

    public boolean guardarProveedor(ProveedorProducto proveedorProducto) {
        String consulta = "INSERT INTO proveedor_producto (id,"
                + "proveedor_cedula, producto_codigo)"
                + "VALUES ('" + proveedorProducto.getId() + "', '" + proveedorProducto.getProveedorCedula() + "', '"
                + proveedorProducto.getProductoCodigo() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarProveedor(ProveedorProducto proveedorProducto) {
        String consulta = "UPDATE proveedor_producto SET id='" + proveedorProducto.getId() + "', "
                + " proveedor_cedula='" + proveedorProducto.getProveedorCedula() + "', producto_codigo='" + proveedorProducto.getProductoCodigo() + "' "
                + " WHERE id='" + proveedorProducto.getId() + "'";
        return super.ejecutar(consulta);
    }

    public ProveedorProducto buscarProveedor(int id) {
        String consulta = "select id, "
                + " proveedor_cedula, producto_codigo from proveedor_producto where id ='" + id + "'";
        ProveedorProducto pro = new ProveedorProducto();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                pro.setId(resultadoDB.getInt("id"));
                pro.setProveedorCedula(resultadoDB.getString("proveedor_cedula"));
                pro.setProductoCodigo(resultadoDB.getInt("producto_codigo"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return pro;
    }

    public boolean eliminarProveedor(int id) {
        String consulta = "DELETE FROM proveedor_producto where id = " + id + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<ProveedorProducto> listarProveedor() {
        ArrayList<ProveedorProducto> lista = new ArrayList<>();
        String consulta = "select * from proveedor_producto";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                ProveedorProducto pro = new ProveedorProducto();
                pro.setId(resultadoDB.getInt("id"));
                pro.setProveedorCedula(resultadoDB.getString("proveedor_cedula"));
                pro.setProductoCodigo(resultadoDB.getInt("producto_codigo"));
                lista.add(pro);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

}
