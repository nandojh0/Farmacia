/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author NANDO1
 */
public class Conexion {
   Connection  con;
    String user = "root";
    String Password = "";
    String url = "jdbc:mysql://localhost:3306/bd_ejemplo";
    public Connection Conectar(){
        try
       {

         Class.forName("com.mysql.jdbc.Driver");

         con=DriverManager.getConnection(url,user,Password);      
         
       }
       catch(Exception e)
       {
       }
        return con;
    }
}
