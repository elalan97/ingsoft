/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoLogin;
import Exepciones.NoExisteUsuario;
import Modelo.Login;

/**
 *
 * @author halan
 */
public class ControladorLogin {
    BoLogin boLogin;

    public ControladorLogin() {
        
        boLogin = new BoLogin();
    }

    public void Logeo(String nombreUsuario, String contraseña) throws NoExisteUsuario{
        
        boLogin.Logeo(nombreUsuario, contraseña);
    }
    
    public void guardarUsuario(Login login){
        
        boLogin.guardar(login);
    }
}
