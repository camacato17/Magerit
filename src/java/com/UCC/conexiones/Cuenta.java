
package com.UCC.conexiones;
import java.sql.*;
import com.UCC.conexion.conector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Cuenta {
//    String registrar_usuario="{ call registrarUsuario(?,?)}";
    
    
    //Funcion para ingresa usuarion a base de datos
    public void registrar(String correo, String contraseña){
        try {
            Connection conexion = conector.abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("{ call registrarUsuario(?,?)}");
            ps.setString(1,correo);
            ps.setString(2, contraseña);
            System.out.println("se ingresado el dato"+correo+" y "+contraseña);
        } catch (SQLException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
}
