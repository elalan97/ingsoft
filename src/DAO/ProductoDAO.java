/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.Producto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author halan
 */
public class ProductoDAO extends Conexion {

    public ProductoDAO() {
    }

    public boolean guardarProducto(Producto producto) {
        String consulta = "INSERT INTO producto (codigo,"
                + "nombre, precio, fecha_vencimiento, categoria_codigo, cantidad)"
                + "VALUES ('" + producto.getCodigo() + "', '" + producto.getNombre() + "', '"
                + producto.getPrecio() + "', '" + producto.getFechaVencimiento() + "', '"
                + producto.getCategoria() + "', '" + producto.getCantidad() + "' " 
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarProducto(Producto producto) {
        String consulta = "UPDATE producto SET codigo='" + producto.getCodigo() + "', "
                + " nombre='" + producto.getNombre() + "', precio='" + producto.getPrecio() + "', "
                + " fecha_vencimiento='" + producto.getFechaVencimiento() + "', " 
                + " categoria_codigo='" + producto.getCategoria() + "', cantidad='" + producto.getCantidad() + "'"
                + " WHERE codigo='" + producto.getCodigo() + "'";
        return super.ejecutar(consulta);
        
    }

    public Producto buscarProducto(int codigo) {
        String consulta = "select codigo, "
                + " nombre, precio, fecha_vencimiento, categoria_codigo ,cantidad from producto where codigo ='" + codigo + "'";
        Producto pro = new Producto();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                pro.setCodigo(resultadoDB.getInt("codigo"));
                pro.setNombre(resultadoDB.getString("nombre"));
                pro.setPrecio(resultadoDB.getInt("precio"));
                pro.setFechaVencimiento(resultadoDB.getString("fecha_vencimiento"));
                pro.setCategoria(resultadoDB.getString("categoria_codigo"));
                pro.setCantidad(resultadoDB.getInt("cantidad"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return pro;
    }

    public boolean eliminarProducto(int codigo) {
        String consulta = "DELETE FROM producto where codigo = " + codigo + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Producto> listarProducto() {
        ArrayList<Producto> lista = new ArrayList<>();
        String consulta = "select * from producto";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Producto pro = new Producto();
                pro.setCodigo(resultadoDB.getInt("codigo"));
                pro.setNombre(resultadoDB.getString("nombre"));
                pro.setPrecio(resultadoDB.getInt("precio"));
                pro.setFechaVencimiento(resultadoDB.getString("fecha_vencimiento"));
                pro.setCategoria(resultadoDB.getString("categoria_codigo"));
                pro.setCantidad(resultadoDB.getInt("cantidad"));
                lista.add(pro);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
}
