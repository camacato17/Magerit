package com.UCC.conexion;



import java.sql.*;
import com.UCC.conexion.conector;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Cuenta {
//    String registrar_usuario="{ call registrarUsuario(?,?)}";
    
    
    //Funcion para ingresa usuario a base de datos
    public static void registrar(String correo, String contraseña) throws SQLException,ClassNotFoundException{
        try {
            Connection conexion = conector.abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("{ call ingresarusuario(?,?)}");
            ps.setString(1,correo);
            ps.setString(2, contraseña);
            ps.execute();
            System.out.println("se ingresado el dato"+correo+" y "+contraseña);
        } catch (Exception ex) {
            throw ex;
        } 
       
        
        
    }
    
      // funcion de logear usuario
    public static boolean Login(String correo, String contraseña) throws SQLException,ClassNotFoundException{
        try {
            Connection conexion = conector.abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("{ call Loginusuario(?,?)}");
            ps.setString(1,correo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            boolean existe=false;
            
            while(rs.next()){
              existe=true;
            }
            return existe;
           
        } catch (Exception ex) {
            throw ex;
        } 
               
    }
    
    
    
     public static boolean Verificarcorreo(String correo) throws SQLException,ClassNotFoundException{
        try {
            Connection conexion = conector.abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("{ call VerificarCorreoRegistrado(?)}");
            ps.setString(1,correo);
            
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            boolean existe=false;
            
            while(rs.next()){
              existe=true;
            }
            return existe;
           
        } catch (Exception ex) {
            throw ex;
        } 
               
    }
    
    
}
