package Logica;


import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import Conexion.Contrata;
import Conexion.Hace;
import Conexion.Horario;
import Conexion.Persona;
import Conexion.Proveedor;
import Conexion.Servicio;


public class Negocio {

	
	//ingresar datos y mostrar tabla persona
	public static void insertarpersona(String nom, int ci, String clave, String ubi) {
	Persona persona = new Persona(nom,ci,clave,ubi);
	persona.insertar();
	}
	
	public static DefaultTableModel Mostrardatospersona(){
		
		String[] dato = new String[4];
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("CI");
		model.addColumn("NOMBRE COMPLETO");
		model.addColumn("CONTRASEÑA");
		model.addColumn("UBICACION");
		try {
			ResultSet rs=Persona.Mostrardatos();
			while(rs.next()) {
				dato[0]=rs.getString(1);
				dato[1]=rs.getString(2);
				dato[2]=rs.getString(3);
				dato[3]=rs.getString(4);
				model.addRow(dato);
			}
			
		}
		catch (Exception e){
			System.out.print(e);
		}
		
		return model;
		
	}
	//fin tabla persona
	
	
	//ingresar datos y mostrar tabla proveedor
		public static void insertarproveedor(int CI, int idp, String nombrec, String contra, int contact, String disp) {
		Proveedor proveedor = new Proveedor(CI,idp,nombrec,contra,contact,disp);
		proveedor.insertar();
		}
		
		public static DefaultTableModel Mostrardatosproveedor(){
			
			String[] dato = new String[6];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("CI");
			model.addColumn("ID_P");
			model.addColumn("NOMBRE COMPLETO");
			model.addColumn("CONTRASEÑA");
			model.addColumn("CONTACTO");
			model.addColumn("DISPONIBILIDAD");
			try {
				ResultSet rs=Proveedor.Mostrardatos();
				while(rs.next()) {
					dato[0]=rs.getString(1);
					dato[1]=rs.getString(2);
					dato[2]=rs.getString(3);
					dato[3]=rs.getString(4);
					dato[4]=rs.getString(5);
					dato[5]=rs.getString(6);
					model.addRow(dato);
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			return model;
			
		}
		//fin tabla proveedor
		
		
		//ingresar datos y mostrar tabla servicio
		public static void insertarservicio(String ids, String desc) {
		Servicio servicio = new Servicio(ids,desc);
		servicio.insertar();
		}
		
		public static DefaultTableModel Mostrardatosservicio(){
			
			String[] dato = new String[2];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_S");
			model.addColumn("DESCRIPCION");
			try {
				ResultSet rs=Servicio.Mostrardatos();
				while(rs.next()) {
					dato[0]=rs.getString(1);
					dato[1]=rs.getString(2);
					model.addRow(dato);
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			return model;
			
		}
		//fin tabla servicio
		

		//ingresar datos y mostrar tabla hace
		public static void insertarhace(String idse, int idpr, int ci, int pre, String hora, String zo) {
		Hace hace = new Hace(idse,idpr,ci,pre,hora,zo);
		hace.insertar();
		}
		
		public static DefaultTableModel Mostrardatoshace(){
			
			String[] dato = new String[6];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_SE");
			model.addColumn("ID_PR");
			model.addColumn("CI");
			model.addColumn("PRECIO");
			model.addColumn("HORARIO");
			model.addColumn("ZONA");
			try {
				ResultSet rs=Hace.Mostrardatos();
				while(rs.next()) {
					dato[0]=rs.getString(1);
					dato[1]=rs.getString(2);
					dato[2]=rs.getString(3);
					dato[3]=rs.getString(4);
					dato[4]=rs.getString(5);
					dato[5]=rs.getString(6);
					model.addRow(dato);
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			return model;
			
		}
		//fin tabla hace
		
		
		//ingresar datos y mostrar tabla contrata
		public static void insertarcontrata(int ci, int idpro, String idser, String fechac, String horatra) {
		Contrata contrata = new Contrata(ci,idpro,idser,fechac,horatra);
		contrata.insertar();
		}
		
		public static DefaultTableModel Mostrardatoscontrata(){
			
			String[] dato = new String[5];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("CI");
			model.addColumn("ID_PRO");
			model.addColumn("ID_SER");
			model.addColumn("FECHA_C");
			model.addColumn("HORA_TRA");
			try {
				ResultSet rs=Contrata.Mostrardatos();
				while(rs.next()) {
					dato[0]=rs.getString(1);
					dato[1]=rs.getString(2);
					dato[2]=rs.getString(3);
					dato[3]=rs.getString(4);
					dato[4]=rs.getString(5);
					model.addRow(dato);
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			return model;
			
		}
		//fin tabla contrata
		
		
		//ingresar datos y mostrar tabla horario
		public static void insertarhorario(String idh, String fechahor_in, String fechahor_fin, String est, int idprove) {
		Horario horario = new Horario(idh,fechahor_in,fechahor_fin,est,idprove);
		horario.insertar();
		}
		
		public static DefaultTableModel Mostrardatoshorario(){
			
			String[] dato = new String[5];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_H");
			model.addColumn("HORA INICIO");
			model.addColumn("HORA FIN");
			model.addColumn("ESTADO");
			model.addColumn("ID_PROVE");
			try {
				ResultSet rs=Horario.Mostrardatos();
				while(rs.next()) {
					dato[0]=rs.getString(1);
					dato[1]=rs.getString(2);
					dato[2]=rs.getString(3);
					dato[3]=rs.getString(4);
					dato[4]=rs.getString(5);
					model.addRow(dato);
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			return model;
			
		}
		//fin tabla horario
}
