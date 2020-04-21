/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author halan
 */
public class ProveedorDAO extends Conexion {

    public ProveedorDAO() {
    }

    public boolean guardarProveedor(Proveedor proveedor) {
        String consulta = "INSERT INTO proveedor (cedula,"
                + "nombre, apellido, direccion, telefono)"
                + "VALUES ('" + proveedor.getCedula() + "', '" + proveedor.getNombre() + "', '"
                + proveedor.getApellido() + "', '" + proveedor.getDireccion() + "', '"
                + proveedor.getTelefono() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarProveedor(Proveedor proveedor) {
        String consulta = "UPDATE proveedor SET cedula='" + proveedor.getCedula() + "', "
                + " nombre='" + proveedor.getNombre() + "', apellido='" + proveedor.getApellido() + "', "
                + " direccion='" + proveedor.getDireccion() + "', telefono='" + proveedor.getTelefono() + "' "
                + " WHERE cedula='" + proveedor.getCedula() + "'";
        return super.ejecutar(consulta);
    }

    public Proveedor buscarProveedor(String cedula) {
        String consulta = "select cedula, "
                + " nombre, apellido, direccion, telefono from proveedor where cedula ='" + cedula + "'";
        Proveedor pro = new Proveedor();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                pro.setCedula(resultadoDB.getString("cedula"));
                pro.setNombre(resultadoDB.getString("nombre"));
                pro.setApellido(resultadoDB.getString("apellido"));
                pro.setDireccion(resultadoDB.getString("direccion"));
                pro.setTelefono(resultadoDB.getString("telefono"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return pro;
    }

    public boolean eliminarProveedor(String cedula) {
        String consulta = "DELETE FROM proveedor where cedula = " + cedula + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Proveedor> listarProveedor() {
        ArrayList<Proveedor> lista = new ArrayList<>();
        String consulta = "select * from proveedor";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Proveedor pro = new Proveedor();
                pro.setCedula(resultadoDB.getString("cedula"));
                pro.setNombre(resultadoDB.getString("nombre"));
                pro.setApellido(resultadoDB.getString("apellido"));
                pro.setDireccion(resultadoDB.getString("direccion"));
                pro.setTelefono(resultadoDB.getString("telefono"));
                lista.add(pro);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
}
