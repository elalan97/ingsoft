/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.LoginDAO;
import Exepciones.NoExisteUsuario;
import Modelo.Login;
import Modelo.Proveedor;
import Vista.FrmVendedor;

import Vista.InicioAdmin;

/**
 *
 * @author halan
 */
public class BoLogin {

    LoginDAO loginDAO;

    public BoLogin() {
        loginDAO = new LoginDAO();
    }

    public void Logeo(String nombreUsuario, String contraseña) {

        Login log = loginDAO.buscarUsuario(nombreUsuario);

        if (nombreUsuario.equals(log.getNombreUsuario()) && contraseña.equals(log.getContraseña())) {

            if (log.getTipoUsuario().equals("administrador")) {

                InicioAdmin event = new InicioAdmin();
                event.setVisible(true);

            } else if (log.getTipoUsuario().equals("proveedor")) {

                FrmVendedor event = new FrmVendedor();
                event.setVisible(true);
            }

        } else {
            throw new NoExisteUsuario();
        }

    }

    public void guardar(Login login) {
        loginDAO.guardarBodega(login);
    }

}
