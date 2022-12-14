package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Contrata {
	private PreparedStatement ps;
	private final Conexion CN;
    private final String SQL = "INSERT INTO contrata (ci4,id_ser,fecha_c,hora_tra,ci_prov,precio) values(?,?,?,?,?,?)";
    private String id_ser = null , fecha_c = null, hora_tra = null;
	private int C_I = 0;
	private int ci_p;
	private int precio;
	
	public Contrata(int ci, String idser, String fechac, String horatra, int cip, int pre){  
		this.C_I = ci;
		this.id_ser = idser;
		this.fecha_c = fechac;
		this.hora_tra = horatra;
		this.ci_p = cip;
		this.precio = pre;
	    CN = new Conexion();
	}
	
	public int insertar() {
		try {
			ps = CN.getConnection().prepareStatement(SQL);
			ps.setInt(1, C_I);
			ps.setString(2, id_ser);
			ps.setString(3, fecha_c);
			ps.setString(4, hora_tra);
			ps.setInt(5, ci_p);
			ps.setInt(6, precio);
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
    		String mos = "SELECT * FROM contrata";
    		rs=st.executeQuery(mos);
    	}catch (Exception e){
    		System.out.print(e);
    	}
    	return rs;
	}
}
