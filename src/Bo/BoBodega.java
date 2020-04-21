/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.BodegaDAO;
import Exepciones.NoExisteProveedor;
import Exepciones.YaExisteBodega;
import Exepciones.YaExisteProducto;
import Modelo.Bodega;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALAN
 */
public class BoBodega {
    
    BodegaDAO dao;

    public BoBodega() {
        
        dao = new BodegaDAO();
    }
    
        public void guardar(Bodega bodega) {

        Bodega bo = dao.buscarBodega(bodega.getCodigo());

        if (bo != null) {

            if (bo.getCodigo() == bodega.getCodigo()) {

                throw new YaExisteBodega();
            }
        }

            dao.guardarBodega(bodega);

    }

    public Bodega buscar(int codigo) {

        Bodega bo = dao.buscarBodega(codigo);

        if (bo == null) {
            throw new NoExisteProveedor();
        } else if (bo != null) {
            return bo;
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void editar(Bodega bodega) {

        Bodega bo = dao.buscarBodega(bodega.getCodigo());

        if (bo != null) {
            dao.editarBodega(bodega);
        } else {

            throw new NoExisteProveedor();
        }

    }

    public void eliminar(int codigo) {

        Bodega bo = dao.buscarBodega(codigo);

        if (bo != null) {
            boolean result = dao.eliminarBodega(codigo);
        } else if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExisteProveedor();
        }
    }

    public ArrayList<Bodega> listarBodega() {
        return dao.listarBodega();
    }
    
}
