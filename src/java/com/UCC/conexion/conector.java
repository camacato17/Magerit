
package com.UCC.conexion;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;
public class conector {
    private static Connection conexion=null;
    
    public static Connection abrirConexion() throws SQLException, ClassNotFoundException {
       if(conexion==null) {
           try {                          
         String server,database,user,password;
         server="localhost";
         database="Ucc";
         user="sa";
         password="12345678";
      
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conexion = DriverManager.getConnection("jdbc:sqlserver//"+server+
                   ":1433; databaseName="+ database,user,password);
               System.out.println("conectado a la base de datos Ucc");
             } catch (ClassNotFoundException e) {
               System.out.println("no se a podido conectar a la base de datos");
           }
       }
        return conexion;
        
    }
   
 }
     
     

