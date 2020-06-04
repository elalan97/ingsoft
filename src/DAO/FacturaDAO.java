/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.Factura;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class FacturaDAO extends Conexion {

    public FacturaDAO() {
    }

    public boolean guardarFactura(Factura factura, int id) {
        String consulta = "INSERT INTO factura (idPedido,"
                + "codigoVendedor, cedulaCliente, fechaEmision)"
                + "VALUES ('" + id + "', '" + factura.getCodigoVendedor() + "', '"
                + factura.getCedulaCliente() + "', '"
                + factura.getFechaEmision() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarFactura(Factura factura, int id) {
        String consulta = "UPDATE factura SET idPedido='" + id + "', "
                + " codigoVendedor='" + factura.getCodigoVendedor() + "', cedulaCliente='" + factura.getCedulaCliente() + "', "
                + " fechaEmision='" + factura.getFechaEmision() + "'"
                + " WHERE idPedido='" + id + "'";
        return super.ejecutar(consulta);

    }

    public Factura buscarFactura(int codigo) {
        String consulta = "select idPedido, "
                + " codigoVendedor, cedulaCliente, fechaEmision from factura where idPedido ='" + codigo + "'";
        Factura fac = new Factura();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                fac.setCodigo(resultadoDB.getInt("idPedido"));
                fac.setCodigoVendedor(resultadoDB.getInt("codigoVendedor"));
                fac.setCedulaCliente(resultadoDB.getString("cedulaCliente"));
                fac.setFechaEmision(resultadoDB.getString("fechaEmision"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return fac;
    }

    public boolean eliminarFactura(int codigo) {
        String consulta = "DELETE FROM factura where idPedido = " + codigo + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Factura> listarFactura(int id) {
        ArrayList<Factura> lista = new ArrayList<>();
        String consulta = "select * from factura where codigoVendedor = " + id + ";";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Factura fac = new Factura();
                fac.setCodigo(resultadoDB.getInt("idPedido"));
                fac.setCodigoVendedor(resultadoDB.getInt("codigoVendedor"));
                fac.setCedulaCliente(resultadoDB.getString("cedulaCliente"));
                fac.setFechaEmision(resultadoDB.getString("fechaEmision"));
                lista.add(fac);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }
}
