/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author halan
 */
public class CategoriaDAO extends Conexion {

    public CategoriaDAO() {
    }

    public boolean guardarCategoria(Categoria categoria) {
        String consulta = "INSERT INTO categoria (codigo, nombre)"
                + "VALUES ('" + categoria.getCodigo() + "', '" + categoria.getNombre() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean eliminarCategoria(String codigo) {
        String consulta = "DELETE FROM categoria where codigo = " + codigo + ";";
        return super.ejecutar(consulta);
    }

    public ArrayList<Categoria> listarCategoria() {
        ArrayList<Categoria> lista = new ArrayList<>();
        String consulta = "select * from categoria";

        super.ejecutarRetorno(consulta);
        try {
            while (resultadoDB.next()) {
                Categoria ca = new Categoria();
                ca.setCodigo(resultadoDB.getString("codigo"));
                ca.setNombre(resultadoDB.getString("nombre"));
                lista.add(ca);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return lista;
    }

    public Categoria buscarCategoria(String nombre) {
        String consulta = "select codigo, nombre from categoria where nombre ='" + nombre + "'";
        Categoria ca = new Categoria();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                ca.setCodigo(resultadoDB.getString("codigo"));
                ca.setNombre(resultadoDB.getString("nombre"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return ca;
    }
}
