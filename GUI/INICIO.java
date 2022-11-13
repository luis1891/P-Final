package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.JTextPane;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JComboBox;

import Logica.Negocio;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/*
######################
# Importe de negocio #
######################
*/
import Logica.Negocio;

public class INICIO extends JFrame {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INICIO frame = new INICIO();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

		private JTextField textField;
		private JPasswordField pass_INI;
		private JTextField ci_INI;
		private JTextField txt_name_Regi_CLI;
		private JTextField txt_pass_Regi_CLI;
		private JTextField txt_ubi_Regi_CLI;
		private JTextField txt_ci_Regi_CLi;
		private JTextField txt_disp_Prov;
		private JTextField txt_ci_Prov;
		private JTextField txt_cont_Prov;
		private JTextField txt_id_Prov;
		private JTextField txt_name_Prov;
		private JTextField txt_pass_Prov;
		
	public INICIO() {
		

		/*
		 ###########################
		 # PANEL DE INICIO CENTRAL #
		 ###########################
		*/
		getContentPane().setLayout(null);
		JTabbedPane panel_Inicio = new JTabbedPane(JTabbedPane.TOP);
		panel_Inicio.setBounds(0, 0, 463, 314);
		getContentPane().add(panel_Inicio);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_Inicio.addTab("Opciones de servicio", null, tabbedPane, null);
		
		/*
		 ###############################
		 # PANEL DE OPCIONES DE INICIO #
		 ###############################
		*/
		JLayeredPane lay_Opciones = new JLayeredPane();
		tabbedPane.addTab("Opciones", null, lay_Opciones, null);
		
		JButton btn_OP_INI = new JButton("INICIAR SESION");
		btn_OP_INI.setBounds(152, 27, 154, 44);
		lay_Opciones.add(btn_OP_INI);
		
		JButton btn_OP_Cli = new JButton("REGISTRO CLIENTE");
		btn_OP_Cli.setBounds(152, 82, 154, 44);
		lay_Opciones.add(btn_OP_Cli);
		
		JButton btn_OP_Prov = new JButton("REGISTRO PROVEEDOR");
		btn_OP_Prov.setBounds(152, 137, 154, 44);
		lay_Opciones.add(btn_OP_Prov);
		
		/*
		 #############################
		 # PANEL DE INICIO DE SESION #
		 #############################
		*/
		JTabbedPane panIni = new JTabbedPane(JTabbedPane.TOP);
		panel_Inicio.addTab("Inicio", null, panIni, null);
		
		JLayeredPane lay_INI = new JLayeredPane();
		panIni.addTab("Inicio de sesion", null, lay_INI, null);
		lay_INI.setLayout(null);
		
		JButton btnINI_CLI = new JButton("INICIAR SESION");
		btnINI_CLI.setBackground(Color.DARK_GRAY);
		btnINI_CLI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnINI_CLI.setBounds(120, 67, 162, 23);
		btnINI_CLI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lay_INI.add(btnINI_CLI);
		
		pass_INI = new JPasswordField();
		pass_INI.setBackground(Color.WHITE);
		pass_INI.setBounds(200, 36, 145, 20);
		pass_INI.setToolTipText("");
		pass_INI.setEchoChar('#');
		lay_INI.add(pass_INI);
		
		ci_INI = new JTextField();
		ci_INI.setBackground(Color.WHITE);
		ci_INI.setBounds(200, 11, 145, 20);
		ci_INI.setColumns(10);
		lay_INI.add(ci_INI);
		
		JLabel CI_INI = new JLabel("C.I");
		CI_INI.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		CI_INI.setBounds(78, 15, 113, 14);
		lay_INI.add(CI_INI);
		
		JLabel txt_pass = new JLabel("Contraseña");
		txt_pass.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		txt_pass.setBounds(78, 39, 113, 14);
		lay_INI.add(txt_pass);
		
		/*
		 ################################
		 # PANEL DE REGISTRO DE CLIENTE #
		 ################################
		*/
		JTabbedPane panRegCli = new JTabbedPane(JTabbedPane.TOP);
		panel_Inicio.addTab("Cliente", null, panRegCli, null);
		
		JLayeredPane layRegiCLI = new JLayeredPane();
		panRegCli.addTab("Registro para Cliente", null, layRegiCLI, null);
		
		JLabel nameRegis = new JLabel("Nombre completo");
		nameRegis.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		nameRegis.setBounds(78, 9, 113, 14);
		layRegiCLI.add(nameRegis);
		
		JLabel passRegis = new JLabel("Contraseña");
		passRegis.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		passRegis.setBounds(78, 33, 90, 14);
		layRegiCLI.add(passRegis);
		
		JLabel ubiRegis = new JLabel("Ubicacion");
		ubiRegis.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		ubiRegis.setBounds(78, 83, 75, 20);
		layRegiCLI.add(ubiRegis);
		
		txt_name_Regi_CLI = new JTextField();
		txt_name_Regi_CLI.setColumns(10);
		txt_name_Regi_CLI.setBounds(200, 5, 176, 20);
		layRegiCLI.add(txt_name_Regi_CLI);
		
		txt_pass_Regi_CLI = new JTextField();
		txt_pass_Regi_CLI.setColumns(10);
		txt_pass_Regi_CLI.setBounds(200, 30, 176, 20);
		layRegiCLI.add(txt_pass_Regi_CLI);
		
		txt_ubi_Regi_CLI = new JTextField();
		txt_ubi_Regi_CLI.setColumns(10);
		txt_ubi_Regi_CLI.setBounds(200, 80, 176, 20);
		layRegiCLI.add(txt_ubi_Regi_CLI);
		
		JLabel ciRegi = new JLabel("C.I");
		ciRegi.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		ciRegi.setBounds(78, 58, 52, 14);
		layRegiCLI.add(ciRegi);
		
		txt_ci_Regi_CLi = new JTextField();
		txt_ci_Regi_CLi.setColumns(10);
		txt_ci_Regi_CLi.setBounds(200, 55, 176, 20);
		layRegiCLI.add(txt_ci_Regi_CLi);
		
		JButton btnAddCLI = new JButton("AÑADIR CLIENTE");
		btnAddCLI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddCLI.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddCLI.setBounds(144, 114, 139, 23);
		layRegiCLI.add(btnAddCLI);
		
		JButton btnVolverCli = new JButton("VOLVER");
		btnVolverCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolverCli.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolverCli.setBounds(144, 142, 139, 23);
		layRegiCLI.add(btnVolverCli);
		
		/*
		 ##################################
		 # PANEL DE REGISTRO DE PROVEEDOR #
		 ##################################
		*/
		JTabbedPane paniRegProv = new JTabbedPane(JTabbedPane.TOP);
		panel_Inicio.addTab("Proveedor", null, paniRegProv, null);
		
		JLayeredPane lay_Proveedor = new JLayeredPane();
		lay_Proveedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		paniRegProv.addTab("Registro para Proveedor", null, lay_Proveedor, null);
		lay_Proveedor.setLayout(null);
		
		JLabel id_Prov = new JLabel("ID");
		id_Prov.setBounds(78, 9, 108, 14);
		id_Prov.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(id_Prov);
		//La concha de tu herrmana codigo puto
		txt_id_Prov = new JTextField();
		txt_id_Prov.setBounds(191, 5, 86, 20);
		txt_id_Prov.setColumns(10);
		lay_Proveedor.add(txt_id_Prov);
		
		JLabel nameProv = new JLabel("Nombre completo");
		nameProv.setBounds(78, 33, 108, 14);
		nameProv.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(nameProv);
		
		txt_name_Prov = new JTextField();
		txt_name_Prov.setBounds(191, 30, 176, 20);
		txt_name_Prov.setColumns(10);
		lay_Proveedor.add(txt_name_Prov);
		
		JLabel passProv = new JLabel("Contraseña");
		passProv.setBounds(78, 58, 108, 14);
		passProv.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(passProv);
		
		txt_pass_Prov = new JTextField();
		txt_pass_Prov.setBounds(191, 55, 176, 20);
		txt_pass_Prov.setColumns(10);
		lay_Proveedor.add(txt_pass_Prov);
		
		JLabel ciProv = new JLabel("C.I");
		ciProv.setBounds(78, 83, 108, 14);
		ciProv.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(ciProv);
		
		txt_ci_Prov = new JTextField();
		txt_ci_Prov.setBounds(191, 80, 176, 20);
		txt_ci_Prov.setColumns(10);
		lay_Proveedor.add(txt_ci_Prov);
		
		JLabel contact_Prov = new JLabel("Contacto");
		contact_Prov.setBounds(78, 108, 108, 14);
		contact_Prov.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(contact_Prov);
		
		txt_cont_Prov = new JTextField();
		txt_cont_Prov.setBounds(191, 105, 176, 20);
		txt_cont_Prov.setColumns(10);
		lay_Proveedor.add(txt_cont_Prov);
		
		JLabel disp_Prov = new JLabel("Disponibilidad");
		disp_Prov.setBounds(78, 133, 108, 14);
		disp_Prov.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(disp_Prov);
		
		txt_disp_Prov = new JTextField();
		txt_disp_Prov.setBounds(191, 130, 176, 20);
		txt_disp_Prov.setColumns(10);
		lay_Proveedor.add(txt_disp_Prov);
		
		JButton btnAddProv = new JButton("AÑADIR PROVEEDOR");
		btnAddProv.setBounds(149, 168, 145, 23);
		btnAddProv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lay_Proveedor.add(btnAddProv);
		
		JButton btnVolverProv = new JButton("VOLVER");
		btnVolverProv.setBounds(149, 196, 145, 23);
		btnVolverProv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lay_Proveedor.add(btnVolverProv);
	}
}