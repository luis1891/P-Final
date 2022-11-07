package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Hace {
	
	private PreparedStatement ps;
	private final Conexion CN;
	private final String SQL = "INSERT INTO hace (id_se,id_pr,ci3,precio,horario,zona) values(?,?,?,?,?,?)";
	private String id_se = null , horario = null, zona = null;
	private int id_pr = 0, c_i = 0, precio = 0;
	
	
	public Hace(String idse, int idpr, int ci, int pre, String hora, String zo){
		  
		this.id_se = idse;
		this.id_pr = idpr;
		this.c_i = ci;
		this.precio = pre;
		this.horario = hora;
		this.zona = zo;
	    CN = new Conexion();
	  }
	
	
	  public int insertar() {
		  try {
				ps = CN.getConnection().prepareStatement(SQL);
				ps.setString(1, id_se);
				ps.setInt(2, id_pr);
				ps.setInt(3, c_i);
				ps.setInt(4, precio);
				ps.setString(5, horario);
				ps.setString(6, zona);
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
	    		String mos = "SELECT * FROM hace";
	    		rs=st.executeQuery(mos);
	    		
	    	}
	    	catch (Exception e){
	    		System.out.print(e);
	    	}
	    	return rs;
		}

}
