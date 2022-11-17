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
	private final String SQL = "INSERT INTO hace (id_se,ci3,precio,horario,zona,disponibilidad) values(?,?,?,?,?,?)";
	private String id_se = null , horario = null, zona = null, disponibilidad = null;
	private int c_i = 0, precio = 0;

	public Hace(String idse, int ci, int pre, String hora, String zo, String dispo){	  
		this.id_se = idse;
		this.c_i = ci;
		this.precio = pre;
		this.horario = hora;
		this.zona = zo;
		this.disponibilidad = dispo;
	    CN = new Conexion();
	}

	public int insertar() {
		try {
			ps = CN.getConnection().prepareStatement(SQL);
			ps.setString(1, id_se);
			ps.setInt(2, c_i);
			ps.setInt(3, precio);
			ps.setString(4, horario);
			ps.setString(5, zona);
			ps.setString(6, disponibilidad);
			int r = ps.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Guardado correctamente");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ingrese bien sus datos");
		}
		return 0;
	}
	  
	public int modificar() {
		try {
			String modificar = "UPDATE hace set disponibilidad = 'no' where ci3 = '"+c_i+"'";
			ps = CN.getConnection().prepareStatement(modificar);
			ps.executeUpdate();
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
	    }catch (Exception e){
	    	System.out.print(e);
	    }
	    return rs;
	}
	  
	public static ResultSet Mostrardatos1() {
	    ResultSet rs =null;

	    try {
	    	Conexion CN = new Conexion();
	    	String SQL="";
	    	Statement st=CN.getConnection().prepareStatement(SQL);
	    	String mos = "SELECT * FROM hace WHERE id_se = '1'";
	    	rs=st.executeQuery(mos);
	    }catch (Exception e){
	    	System.out.print(e);
	    }
	    return rs;
	}

	public static ResultSet Mostrardatos2() {
	    ResultSet rs =null;

	    try {	
	    	Conexion CN = new Conexion();
	    	String SQL="";
	    	Statement st=CN.getConnection().prepareStatement(SQL);
	    	String mos = "SELECT * FROM hace WHERE id_se = '2'";
	    	rs=st.executeQuery(mos);
	    }catch (Exception e){
	    		System.out.print(e);
	    }
	    return rs;
	}
	  
	public static ResultSet Mostrardatos3() {
	    ResultSet rs =null;

	    try {	
	    	Conexion CN = new Conexion();
	    	String SQL="";
	    	Statement st=CN.getConnection().prepareStatement(SQL);
	    	String mos = "SELECT * FROM hace WHERE id_se = '3'";
	    	rs=st.executeQuery(mos);	
	    }catch (Exception e){
	    	System.out.print(e);
	    }
	    return rs;
	}
	  
	public static ResultSet Mostrardatos4() {
	    ResultSet rs =null;
		
	    try {	
	    	Conexion CN = new Conexion();
	    	String SQL="";
	    	Statement st=CN.getConnection().prepareStatement(SQL);
	    	String mos = "SELECT * FROM hace WHERE id_se = '4'";
	    	rs=st.executeQuery(mos);
	    }catch (Exception e){
	    	System.out.print(e);
	    }
	    return rs;
	}
}
