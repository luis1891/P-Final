package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Persona {
	  
	private PreparedStatement ps;
	private final Conexion CN;
	private final String SQL = "INSERT INTO Persona (ci,Nom_completo,contraseña,ubicacion) values(?,?,?,?)";
	private static String contra = null;
	private String ubicacion = null;
	private String nombre = null;
	private static int C_I = 0;

	public Persona(String nom, int ci, String clave, String ubi){	  
		this.nombre = nom;
		this.C_I = ci;
		this.contra = clave;
		this.ubicacion = ubi;
		CN = new Conexion();
	}
	  
	public int insertar() { 
		try {
			ps = CN.getConnection().prepareStatement(SQL);
			ps.setInt(1, this.C_I);
			ps.setString(2, this.nombre);
			ps.setString(3, this.contra);
			ps.setString(4, this.ubicacion);
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
    		String mos = "SELECT * FROM Persona";
    		rs=st.executeQuery(mos);	
    	}catch (Exception e){
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
    		String mos = "SELECT * FROM Persona WHERE ci='"+C_I+"' and contraseña='"+contra+"'";
    		System.out.print(mos);
    		rs=st.executeQuery(mos);
    	}catch (Exception e){
    		System.out.print(e);
    	}
    	return rs;
	}
}