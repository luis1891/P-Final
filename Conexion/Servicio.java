package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Servicio {
	
	private PreparedStatement ps;
	private final Conexion CN;
	private final String SQL = "INSERT INTO servicio (id_s,descripcion) values(?,?)";
	private String id_s = null , descripcion = null;
	
	public Servicio(String ids, String desc){
		  
		this.id_s = ids;
		this.descripcion = desc;
	    CN = new Conexion();
	  }
	
	  public int insertar() {
		  try {
				ps = CN.getConnection().prepareStatement(SQL);
				ps.setString(1, id_s);
				ps.setString(2, descripcion);
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
	    		String mos = "SELECT * FROM servicio";
	    		rs=st.executeQuery(mos);
	    		
	    	}
	    	catch (Exception e){
	    		System.out.print(e);
	    	}
	    	return rs;
		}
	
}
