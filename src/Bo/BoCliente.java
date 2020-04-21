/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.ClienteDAO;
import Exepciones.NoExisteProveedor;
import Exepciones.YaExisteCliente;
import Exepciones.YaExisteProducto;
import Modelo.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoCliente {

    ClienteDAO dao;

    public BoCliente() {
        dao = new ClienteDAO();
    }

    public void guardar(Cliente cliente) {

        Cliente cli = dao.buscarCliente(cliente.getCedula());

        if (cli == null) {
            dao.guardarCliente(cliente);
        } else if (cliente.getCedula().equals(cli.getCedula())) {
            throw new YaExisteCliente();
        } else {
            dao.guardarCliente(cliente);
        }

    }

    public Cliente buscar(String cedula) {

        Cliente cli = dao.buscarCliente(cedula);

        if (cli == null) {
            throw new NoExisteProveedor();
        } else if (cli != null) {
            return cli;
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void editar(Cliente cliente) {

        Cliente cli = dao.buscarCliente(cliente.getCedula());

        if (cli != null) {
            dao.editarCliente(cliente);
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void eliminar(String cedula) {

        Cliente cli = dao.buscarCliente(cedula);

        if (cli != null) {
            boolean result = dao.eliminarCliente(cedula);
        } else if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExisteProveedor();
        }
    }

    public ArrayList<Cliente> listarCliente() {
        return dao.listarCliente();
    }
}
