/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class ClienteDAO extends Conexion {

    public ClienteDAO() {
    }

    public boolean guardarCliente(Cliente cliente) {
        String consulta = "INSERT INTO cliente (cedula,"
                + "nombre, apellido, direccion, telefono)"
                + "VALUES ('" + cliente.getCedula() + "', '" + cliente.getNombre() + "', '"
                + cliente.getApellido() + "', '" + cliente.getDireccion() + "', '"
                + cliente.getTelefono() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarCliente(Cliente cliente) {
        String consulta = "UPDATE cliente SET cedula='" + cliente.getCedula() + "', "
                + " nombre='" + cliente.getNombre() + "', apellido='" + cliente.getApellido() + "', "
                + " direccion='" + cliente.getDireccion() + "', "
                + " telefono='" + cliente.getTelefono() + "'"
                + " WHERE cedula='" + cliente.getCedula() + "'";
        return super.ejecutar(consulta);

    }

    public Cliente buscarCliente(String cedula) {
        String consulta = "select cedula, "
                + " nombre, apellido, direccion, telefono from cliente where cedula ='" + cedula + "'";
        Cliente cli = new Cliente();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                cli.setCedula(resultadoDB.getString("cedula"));
                cli.setNombre(resultadoDB.getString("nombre"));
                cli.setApellido(resultadoDB.getString("apellido"));
                cli.setDireccion(resultadoDB.getString("direccion"));
                cli.setTelefono(resultadoDB.getString("telefono"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return cli;
    }

    public boolean eliminarCliente(String cedula) {
        String consulta = "DELETE FROM cliente where cedula = " + cedula + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String consulta = "select * from cliente";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Cliente cli = new Cliente();
                cli.setCedula(resultadoDB.getString("cedula"));
                cli.setNombre(resultadoDB.getString("nombre"));
                cli.setApellido(resultadoDB.getString("apellido"));
                cli.setDireccion(resultadoDB.getString("direccion"));
                cli.setTelefono(resultadoDB.getString("telefono"));
                lista.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
}
