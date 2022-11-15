package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Proveedor {
	
	private PreparedStatement ps;
	private final Conexion CN;
	private final String SQL = "INSERT INTO proveedor (ci2,nombre_c,contraseña_p,contacto) values(?,?,?,?)";
	private String nombre_C = null;
	private static String contra = null; 
	private static int C_I = 0;
	private int contacto = 0;
	
	public Proveedor(int CI, String nombrec, String clave, int contact){
		  
		this.C_I = CI;
		this.nombre_C = nombrec;
		this.contra = clave;
		this.contacto = contact;
	    CN = new Conexion();
	  }
	
	public int insertar() {
		  try {
				ps = CN.getConnection().prepareStatement(SQL);
				ps.setInt(1, C_I);
				ps.setString(2, nombre_C);
				ps.setString(3, contra);
				ps.setInt(4, contacto);
				int r = ps.executeUpdate();
				if (r > 0) {
					JOptionPane.showMessageDialog(null, "Guardado correctamente");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  return 0;
		  }
	
	public static ResultSet Mostrardatos() {
    	ResultSet rs =null;
    	
    	try {	
    		Conexion CN = new Conexion();
    		String SQL="";
    		Statement st=CN.getConnection().prepareStatement(SQL);
    		String mos = "SELECT * FROM proveedor";
    		rs=st.executeQuery(mos);
    		
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    	return rs;
	}
	
	public static ResultSet Login() {
    	ResultSet rs =null;
    	
    	try {	
    		Conexion CN = new Conexion();
    		String SQL="";
    		Statement st=CN.getConnection().prepareStatement(SQL);
    		String mos = "SELECT * FROM proveedor WHERE ci2='"+C_I+"' and contraseña_p='"+contra+"'";
    		System.out.print(mos);
    		rs=st.executeQuery(mos);
    		
    	}
    	catch (Exception e){
    		
    		System.out.print(e);
    	}
    	return rs;
	}
}
