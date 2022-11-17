package Logica;


import java.sql.ResultSet;

import javax.swing.JOptionPane;
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
		model.addColumn("CONTRASE�A");
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
	
	public static void logincli(String nom, int ci, String clave, String ubi){
		
		Persona persona = new Persona(nom,ci,clave,ubi);
	}
	
	public static boolean logincliente(){
		boolean lc = false;
		try {
			ResultSet rs=Persona.Login();
			if(rs.next()) {
				lc = true;
			}else {
				JOptionPane.showMessageDialog(null,"USUARIO O CONTRASEÑA INCORRECTA");
			}
			
		}
		catch (Exception e){
			System.out.print(e);
		}
		return lc;
		
	}
	
	
	//fin tabla persona
	
	
	//ingresar datos y mostrar tabla proveedor
		public static void insertarproveedor(int CI, String nombrec, String contra, int contact) {
			Proveedor proveedor = new Proveedor(CI,nombrec,contra,contact);
			proveedor.insertar();
		}
		
		public static DefaultTableModel Mostrardatosproveedor(){
			
			String[] dato = new String[4];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("CI");
			model.addColumn("NOMBRE COMPLETO");
			model.addColumn("CONTRASEÑA");
			model.addColumn("CONTACTO");
			try {
				ResultSet rs=Proveedor.Mostrardatos();
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
		
		public static void loginpro(int CI, String nombrec, String contra, int contact){
			
			Proveedor proveedor = new Proveedor(CI,nombrec,contra,contact);
		}
		
		public static boolean loginproveedor(){
			boolean lc = false;
			try {
				ResultSet rs=Proveedor.Login();
				if(rs.next()) {
					lc = true;
				}else {
					JOptionPane.showMessageDialog(null,"USUARIO O CONTRASEÑA INCORRECTA");
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			return lc;
			
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
		
		public static DefaultTableModel Mostrardatosdesc1(){
			
			String[] dato = new String[1];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("DESCRIPCION");
			try {
				ResultSet rs=Servicio.Mostrardescripcion1();
				while(rs.next()) {
					dato[0]=rs.getString(2);
					model.addRow(dato);
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			return model;
			
		}
		
		public static DefaultTableModel Mostrardatosdesc2(){
			
			String[] dato = new String[1];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("DESCRIPCION");
			try {
				ResultSet rs=Servicio.Mostrardescripcion2();
				while(rs.next()) {
					dato[0]=rs.getString(2);
					model.addRow(dato);
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			return model;
			
		}
		
		public static DefaultTableModel Mostrardatosdesc3(){
			
			String[] dato = new String[1];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("DESCRIPCION");
			try {
				ResultSet rs=Servicio.Mostrardescripcion3();
				while(rs.next()) {
					dato[0]=rs.getString(2);
					model.addRow(dato);
				}
				
			}
			catch (Exception e){
				System.out.print(e);
			}
			
			return model;
			
		}
		
		public static DefaultTableModel Mostrardatosdesc4(){
			
			String[] dato = new String[1];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("DESCRIPCION");
			try {
				ResultSet rs=Servicio.Mostrardescripcion4();
				while(rs.next()) {
					dato[0]=rs.getString(2);
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
		public static void insertarhace(String idse, int ci, int pre, String hora, String zo, String dispo) {
		Hace hace = new Hace(idse,ci,pre,hora,zo,dispo);
		hace.insertar();
		}
		
		public static void modificarhace(String idse, int ci, int pre, String hora, String zo, String dispo) {
			Hace hace = new Hace(idse,ci,pre,hora,zo,dispo);
			hace.modificar();
			}
		
		public static DefaultTableModel Mostrardatoshace(){
			
			String[] dato = new String[6];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_SE");
			model.addColumn("CI");
			model.addColumn("PRECIO/HORA");
			model.addColumn("HORAS");
			model.addColumn("ZONA");
			model.addColumn("DISPONIBILIDAD");
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
		
		public static DefaultTableModel Mostrardatoshace1(){
			
			String[] dato = new String[6];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_SE");
			model.addColumn("CI");
			model.addColumn("PRECIO/HORA");
			model.addColumn("HORAS");
			model.addColumn("ZONA");
			model.addColumn("DISPONIBILIDAD");
			try {
				ResultSet rs=Hace.Mostrardatos1();
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
		
		public static DefaultTableModel Mostrardatoshace2(){
			
			String[] dato = new String[6];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_SE");
			model.addColumn("CI");
			model.addColumn("PRECIO/HORA");
			model.addColumn("HORAS");
			model.addColumn("ZONA");
			model.addColumn("DISPONIBILIDAD");
			try {
				ResultSet rs=Hace.Mostrardatos2();
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
		
		public static DefaultTableModel Mostrardatoshace3(){
			
			String[] dato = new String[6];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_SE");
			model.addColumn("CI");
			model.addColumn("PRECIO/HORA");
			model.addColumn("HORAS");
			model.addColumn("ZONA");
			model.addColumn("DISPONIBILIDAD");
			try {
				ResultSet rs=Hace.Mostrardatos3();
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
		
		public static DefaultTableModel Mostrardatoshace4(){
			
			String[] dato = new String[6];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID_SE");
			model.addColumn("CI");
			model.addColumn("PRECIO/HORA");
			model.addColumn("HORAS");
			model.addColumn("ZONA");
			model.addColumn("DISPONIBILIDAD");
			try {
				ResultSet rs=Hace.Mostrardatos4();
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
		public static void insertarcontrata(int ci, String idser, String fechac, String horatra, int cip, int pre) {
		Contrata contrata = new Contrata(ci,idser,fechac,horatra,cip,pre);
		contrata.insertar();
		}
		
		public static DefaultTableModel Mostrardatoscontrata(){
			
			String[] dato = new String[6];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("CI");
			model.addColumn("ID SERVICIO");
			model.addColumn("FECHA CONTRATACIO");
			model.addColumn("HORAS");
			model.addColumn("CI PROVEEDOR");
			model.addColumn("PRECIO");
			try {
				ResultSet rs=Contrata.Mostrardatos();
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
		//fin tabla contrata
		
		
		//ingresar datos y mostrar tabla horario
		public static void insertarhorario(String fechahor_in, String fechahor_fin, String est) {
		Horario horario = new Horario(fechahor_in,fechahor_fin,est);
		horario.insertar();
		}
		
		public static DefaultTableModel Mostrardatoshorario(){
			
			String[] dato = new String[3];
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("HORA INICIO");
			model.addColumn("HORA FIN");
			model.addColumn("ESTADO");
			try {
				ResultSet rs=Horario.Mostrardatos();
				while(rs.next()) {
					dato[0]=rs.getString(1);
					dato[1]=rs.getString(2);
					dato[2]=rs.getString(3);
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
