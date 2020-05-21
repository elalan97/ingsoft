/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.Proveedor;
import Modelo.Vendedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class VendedorDAO extends Conexion {

    public VendedorDAO() {
    }

    public boolean guardarVendedor(Vendedor vendedor) {
        String consulta = "INSERT INTO vendedor (codigo,"
                + "cedula, nombre, apellido, direccion, telefono)"
                + "VALUES ('" + vendedor.getCodigo() + "', '" + vendedor.getCedula() + "', '"
                + vendedor.getNombre() + "', '" + vendedor.getApellido() + "', '"
                + vendedor.getDireccion() + "', '" + vendedor.getTelefono() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarVendedor(Vendedor vendedor) {
        String consulta = "UPDATE vendedor SET codigo='" + vendedor.getCodigo() + "', "
                + " cedula='" + vendedor.getCedula() + "', nombre='" + vendedor.getNombre() + "', "
                + " apellido='" + vendedor.getApellido() + "', direccion='" + vendedor.getDireccion() + "', "
                + " telefono='" + vendedor.getTelefono() + "'"
                + " WHERE codigo='" + vendedor.getCodigo() + "'";
        return super.ejecutar(consulta);

    }

    public Vendedor buscarVendedor(int codigo) {
        String consulta = "select codigo, "
                + " cedula, nombre, apellido, direccion, telefono from vendedor where codigo ='" + codigo + "'";
        Vendedor ve = new Vendedor();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                ve.setCodigo(resultadoDB.getInt("codigo"));
                ve.setCedula(resultadoDB.getString("cedula"));
                ve.setNombre(resultadoDB.getString("nombre"));
                ve.setApellido(resultadoDB.getString("apellido"));
                ve.setDireccion(resultadoDB.getString("direccion"));
                ve.setTelefono(resultadoDB.getString("telefono"));
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return ve;
    }

    public boolean eliminarVendedor(int codigo) {
        String consulta = "DELETE FROM vendedor where codigo = " + codigo + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Vendedor> listarVendedor() {
        ArrayList<Vendedor> lista = new ArrayList<>();
        String consulta = "select * from vendedor";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Vendedor ve = new Vendedor();
                ve.setCodigo(resultadoDB.getInt("codigo"));
                ve.setCedula(resultadoDB.getString("cedula"));
                ve.setNombre(resultadoDB.getString("nombre"));
                ve.setApellido(resultadoDB.getString("apellido"));
                ve.setDireccion(resultadoDB.getString("direccion"));
                ve.setTelefono(resultadoDB.getString("telefono"));
                lista.add(ve);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public Proveedor buscarProveedor(String nombre) {
        String consulta = "select cedula, "
                + " nombre, apellido, direccion, telefono from proveedor where nombre ='" + nombre + "'";
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

    public Vendedor buscarVendedor1(String cedula) {
        String consulta = "select codigo, "
                + " cedula, nombre, apellido, direccion, telefono from vendedor where cedula ='" + cedula + "'";
        Vendedor ve = new Vendedor();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                ve.setCodigo(resultadoDB.getInt("codigo"));
                ve.setCedula(resultadoDB.getString("cedula"));
                ve.setNombre(resultadoDB.getString("nombre"));
                ve.setApellido(resultadoDB.getString("apellido"));
                ve.setDireccion(resultadoDB.getString("direccion"));
                ve.setTelefono(resultadoDB.getString("telefono"));
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return ve;
    }
}
