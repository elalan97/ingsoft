/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.LoginDAO;
import Exepciones.NoExisteProveedor;
import Exepciones.NoExisteUsuario;
import Modelo.Login;
import Modelo.Pedido;
import Modelo.Proveedor;
import Vista.FrmDespachoPedido;
import Vista.FrmDetalleFacturaCliente;
import Vista.FrmVendedor;

import Vista.InicioAdmin;
import Vista.inicioVendedor;
import javax.swing.JOptionPane;

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

                FrmDespachoPedido event = new FrmDespachoPedido();
                event.setVisible(true);
            } else if (log.getTipoUsuario().equals("vendedor")) {

                inicioVendedor event = new inicioVendedor();
                event.setVisible(true);
            } else if (log.getTipoUsuario().equals("cliente")) {

                FrmDetalleFacturaCliente event = new FrmDetalleFacturaCliente();
                event.setVisible(true);
            }

        } else {
            throw new NoExisteUsuario();
        }

    }

    public void guardar(Login login) {
        loginDAO.guardarUsuario(login);
    }

    public void eliminar(String cedula) {

        boolean result = loginDAO.eliminarUsuario(cedula);
        if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExisteProveedor();
        }
    }

}
