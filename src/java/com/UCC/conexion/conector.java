
package com.UCC.conexion;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;
public class conector {
    private static Connection conexion=null;
    
    public static Connection abrirConexion() throws SQLException, ClassNotFoundException {
       if(conexion==null) {
        String server = "localhost";
        String database = "Ucc";
        String user = "sa";
        String password = "12345678";

        String connectionUrl = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;"
                + "encrypt=false;trustServerCertificate=true", 
            server, database, user, password);

           try {                          
      
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conexion = DriverManager.getConnection(connectionUrl);
               System.out.println("conectado a la base de datos Ucc");
             } catch (ClassNotFoundException e) {
               System.out.println("no se a podido conectar a la base de datos");
           }
       }
        return conexion;
        
    }
   
 }
     
     

