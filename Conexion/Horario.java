package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Horario {
	
	private PreparedStatement ps;
	private final Conexion CN;
	private final String SQL = "INSERT INTO horario (id_h,fecha_hor_in,fecha_hor_fin,estado,id_prove) values(?,?,?,?,?)";
	private String id_h = null , fecha_hor_in = null, fecha_hor_fin = null, estado = null;
	private int id_prove = 0;
	
	
	public Horario(String idh, String fechahor_in, String fechahor_fin, String est, int idprove){
		  
		this.id_h = idh;
		this.fecha_hor_in = fechahor_in;
		this.fecha_hor_fin = fechahor_fin;
		this.estado = est;
		this.id_prove = idprove; 
		CN = new Conexion();
	  }
	
	
	
	public int insertar() {
		try {
				ps = CN.getConnection().prepareStatement(SQL);
				ps.setString(1, id_h);
				ps.setString(2, fecha_hor_in);
				ps.setString(3, fecha_hor_fin);
				ps.setString(4, estado);
				ps.setInt(5, id_prove);
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
    		String mos = "SELECT * FROM horario";
    		rs=st.executeQuery(mos);
    		
    	}
    	catch (Exception e){
    		System.out.print(e);
    	}
    	return rs;
	}

}
