/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.Bodega;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ALAN
 */
public class BodegaDAO extends Conexion {

    public BodegaDAO() {
    }

    public boolean guardarBodega(Bodega bodega) {
        String consulta = "INSERT INTO bodega (codigo,"
                + "nombre, direccion, telefono, producto_bodega)"
                + "VALUES ('" + bodega.getCodigo() + "', '" + bodega.getNombre() + "', '"
                + bodega.getDireccion() + "', '" + bodega.getTelefono() + "', '"
                + bodega.getProductoBodega() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean editarBodega(Bodega bodega) {
        String consulta = "UPDATE bodega SET codigo='" + bodega.getCodigo() + "', "
                + " nombre='" + bodega.getNombre() + "', direccion='" + bodega.getDireccion() + "', "
                + " telefono='" + bodega.getTelefono() + "', "
                + " producto_bodega='" + bodega.getProductoBodega() + "'"
                + " WHERE codigo='" + bodega.getCodigo() + "'";
        return super.ejecutar(consulta);

    }

    public Bodega buscarBodega(int codigo) {
        String consulta = "select codigo, "
                + " nombre, direccion, telefono, producto_bodega from bodega where codigo ='" + codigo + "'";
        Bodega bo = new Bodega();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                bo.setCodigo(resultadoDB.getInt("codigo"));
                bo.setNombre(resultadoDB.getString("nombre"));
                bo.setDireccion(resultadoDB.getString("direccion"));
                bo.setTelefono(resultadoDB.getString("telefono"));
                bo.setProductoBodega(resultadoDB.getInt("producto_bodega"));
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return bo;
    }

    public boolean eliminarBodega(int codigo) {
        String consulta = "DELETE FROM bodega where codigo = " + codigo + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Bodega> listarBodega() {
        ArrayList<Bodega> lista = new ArrayList<>();
        String consulta = "select * from bodega";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Bodega bo = new Bodega();
                bo.setCodigo(resultadoDB.getInt("codigo"));
                bo.setNombre(resultadoDB.getString("nombre"));
                bo.setDireccion(resultadoDB.getString("direccion"));
                bo.setTelefono(resultadoDB.getString("telefono"));
                bo.setProductoBodega(resultadoDB.getInt("producto_bodega"));
                lista.add(bo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }


}
