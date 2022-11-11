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
	private final String SQL = "INSERT INTO proveedor (ci2,id_p,nombre_c,contraseña_p,contacto,disponibilidad) values(?,?,?,?,?,?)";
	private String disponibilidad = null, nombre_C = null, contra = null; 
	private int C_I = 0, id_p = 0, contacto = 0;
	
	public Proveedor(int CI, int idp, String nombrec, String clave, int contact, String disp){
		  
		this.C_I = CI;
		this.id_p = idp;
		this.nombre_C = nombrec;
		this.contra = clave;
		this.contacto = contact;
		this.disponibilidad = disp;
	    CN = new Conexion();
	  }
	
	public int insertar() {
		  try {
				ps = CN.getConnection().prepareStatement(SQL);
				ps.setInt(1, C_I);
				ps.setInt(2, id_p);
				ps.setString(3, nombre_C);
				ps.setString(4, contra);
				ps.setInt(5, contacto);
				ps.setString(6, disponibilidad);
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
}
