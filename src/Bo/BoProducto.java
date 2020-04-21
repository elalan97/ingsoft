/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.CategoriaDAO;
import DAO.ProductoDAO;
import Exepciones.NoExisteProducto;
import Exepciones.YaExisteProducto;
import Exepciones.YaExisteProveedor;
import Modelo.Categoria;
import Modelo.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author halan
 */
public class BoProducto {

    ProductoDAO productoDAO;
    CategoriaDAO categoriaDAO;

    public BoProducto() {
        productoDAO = new ProductoDAO();
        categoriaDAO = new CategoriaDAO();

    }

    public void guardar(Producto producto, String categoria) {

        Producto pro = productoDAO.buscarProducto(producto.getCodigo());
        Categoria ca = categoriaDAO.buscarCategoria(categoria);

        if (pro != null) {

            if (pro.getCodigo() == producto.getCodigo()) {

                throw new YaExisteProducto();
            }
        }
            producto.setCategoria(ca.getCodigo());

            productoDAO.guardarProducto(producto);

    }

    public Producto buscar(int codigo) {

        Producto pro = productoDAO.buscarProducto(codigo);

        if (pro != null) {
            return pro;
        } else {

            throw new NoExisteProducto();
        }

    }

    public void editar(Producto producto, String categoria) {

        Categoria ca = categoriaDAO.buscarCategoria(categoria);

        producto.setCategoria(ca.getCodigo());

        productoDAO.editarProducto(producto);

    }

    public void eliminar(int codigo) {

        boolean result = productoDAO.eliminarProducto(codigo);
        if (true) {

            JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");

        } else {

            throw new NoExisteProducto();
        }
    }

    public ArrayList<Producto> listarProvedor() {
        return productoDAO.listarProducto();
    }
}
