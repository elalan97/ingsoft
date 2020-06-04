/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.Login;
import java.sql.SQLException;

/**
 *
 * @author halan
 */
public class LoginDAO extends Conexion {

    public LoginDAO() {
    }

    public Login buscarUsuario(String nombreUsuario) {
        String consulta = "select nombreUsuario, contraseña, tipoUsuario "
                + "from login where nombreUsuario ='" + nombreUsuario + "'";
        Login login = new Login();
        super.ejecutarRetorno(consulta);
        try {
            if (resultadoDB.next()) {

                login.setNombreUsuario(resultadoDB.getString("nombreUsuario"));
                login.setContraseña(resultadoDB.getString("contraseña"));
                login.setTipoUsuario(resultadoDB.getString("tipoUsuario"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al consultar");
            return null;
        }
        return login;
    }

    public boolean guardarUsuario(Login login) {
        String consulta = "INSERT INTO login (nombreUsuario,"
                + "contraseña, tipoUsuario)"
                + "VALUES ('" + login.getNombreUsuario() + "', '" + login.getContraseña() + "', '"
                + login.getTipoUsuario() + "' "
                + ");";
        return super.ejecutar(consulta);
    }

    public boolean eliminarUsuario(String cedula) {
        String consulta = "DELETE FROM login where contraseña = " + cedula + ";";
        return super.ejecutar(consulta);
    }

}
