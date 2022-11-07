package Conexion;

import javax.swing.*;
import java.sql.*;

public class Conexion{
    Connection con;
    
    public Conexion(){
    	con = null;
       }
    
    
    public Connection getConnection(){
    	try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registro?autoReconnect=true&useSSL=false","root","root");
            
            }
        catch (ClassNotFoundException | SQLException ex){
                JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
            }
      return con;
    }
}