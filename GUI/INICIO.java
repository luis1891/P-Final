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

import Conexion.Conexion;
import Logica.Negocio;
import java.awt.SystemColor;

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
		private JTextField txt_ci_Prov;
		private JTextField txt_cont_Prov;
		private JTextField txt_name_Prov;
		private JTextField txt_pass_Prov;
		private JPasswordField txt_pass_INI_Prov;
		private JTextField txt_INI_Prov;
		
	public INICIO() {
		setBounds(100, 100, 506, 382);
		getContentPane().setLayout(null);
		JTabbedPane panel_Inicio = new JTabbedPane(JTabbedPane.TOP);
		panel_Inicio.setEnabled(false);
		panel_Inicio.setBounds(12, 12, 462, 315);
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
		btn_OP_INI.setBackground(Color.WHITE);
		btn_OP_INI.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_OP_INI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inicio.setSelectedIndex(1);
			}
		});
		btn_OP_INI.setBounds(152, 31, 169, 44);
		lay_Opciones.add(btn_OP_INI);
		
		JButton btn_OP_Cli = new JButton("REGISTRO CLIENTE");
		btn_OP_Cli.setBackground(Color.WHITE);
		btn_OP_Cli.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_OP_Cli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inicio.setSelectedIndex(3);
			}
		});
		btn_OP_Cli.setBounds(152, 90, 169, 44);
		lay_Opciones.add(btn_OP_Cli);
		
		JButton btn_OP_Prov = new JButton("REGISTRO PROVEEDOR");
		btn_OP_Prov.setBackground(Color.WHITE);
		btn_OP_Prov.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_OP_Prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inicio.setSelectedIndex(4);
			}
		});
		btn_OP_Prov.setBounds(152, 149, 169, 44);
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
		
		JButton btnINI_CLI = new JButton("INICIAR SESION");
		btnINI_CLI.setForeground(new Color(0, 0, 0));
		btnINI_CLI.setBounds(119, 74, 162, 23);
		btnINI_CLI.setBackground(Color.WHITE);
		btnINI_CLI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pasa ci a la clase con_serv
				String ci_L = ci_INI.getText();
				CON_SERV serpro = new CON_SERV();
				serpro.ci_login(ci_L);
				//////
				int C_I = Integer.parseInt(ci_INI.getText());
				String clave =String.valueOf(pass_INI.getPassword());
				String nombre_C=null;
				String ubicacion=null;
				Negocio.logincli(nombre_C, C_I, clave, ubicacion);
				boolean lc = Negocio.logincliente();
				if(lc == true) {
					serpro.setVisible(true);
					dispose();
				}
			}
		});
		lay_INI.setLayout(null);
		btnINI_CLI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lay_INI.add(btnINI_CLI);
		
		pass_INI = new JPasswordField();
		pass_INI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass_INI.setBounds(200, 36, 145, 20);
		pass_INI.setBackground(Color.WHITE);
		pass_INI.setToolTipText("");
		pass_INI.setEchoChar('#');
		lay_INI.add(pass_INI);
		
		ci_INI = new JTextField();
		ci_INI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ci_INI.setBounds(200, 11, 145, 20);
		ci_INI.setBackground(Color.WHITE);
		ci_INI.setColumns(10);
		lay_INI.add(ci_INI);
		
		JLabel CI_INI = new JLabel("C.I");
		CI_INI.setBounds(78, 15, 113, 14);
		CI_INI.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_INI.add(CI_INI);
		
		JLabel txt_pass = new JLabel("Contraseña");
		txt_pass.setBounds(78, 39, 113, 14);
		txt_pass.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_INI.add(txt_pass);
		
		JButton btnINI_PROV = new JButton("INICIAR SESION COMO PROVEEDOR");
		btnINI_PROV.setForeground(new Color(0, 0, 0));
		btnINI_PROV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inicio.setSelectedIndex(2);
			}
		});
		btnINI_PROV.setBounds(77, 108, 247, 23);
		btnINI_PROV.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnINI_PROV.setBackground(Color.WHITE);
		lay_INI.add(btnINI_PROV);
		
		JButton btnVolver_Cli = new JButton("Volver");
		btnVolver_Cli.setForeground(new Color(0, 0, 0));
		btnVolver_Cli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inicio.setSelectedIndex(0);
			}
		});
		btnVolver_Cli.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver_Cli.setBackground(Color.WHITE);
		btnVolver_Cli.setBounds(119, 142, 162, 23);
		lay_INI.add(btnVolver_Cli);
		
		JTabbedPane panIni_Prov = new JTabbedPane(JTabbedPane.TOP);
		panel_Inicio.addTab("Inicio Prov", null, panIni_Prov, null);
		
		JLayeredPane lay_INI_Prov = new JLayeredPane();
		lay_INI_Prov.setLayout(null);
		panIni_Prov.addTab("Iniciar como proveedor", null, lay_INI_Prov, null);
		
		JButton btnINI_Prov = new JButton("INICIAR SESION");
		btnINI_Prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pasa ci a la clase con_serv
				String ci_L = txt_INI_Prov.getText();
				SERVICIO servicio = new SERVICIO();
				servicio.ci_login(ci_L);
				//////
				int C_I = Integer.parseInt(txt_INI_Prov.getText());
				String clave =String.valueOf(txt_pass_INI_Prov.getPassword());
				String nombrec=null;
				int contact=0;
				Negocio.loginpro(C_I, nombrec, clave, contact);
				boolean lc = Negocio.loginproveedor();
				if(lc == true) {
					servicio.setVisible(true);
					dispose();
				}
			}
		});
		btnINI_Prov.setForeground(new Color(0, 0, 0));
		btnINI_Prov.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnINI_Prov.setBackground(Color.WHITE);
		btnINI_Prov.setBounds(120, 67, 162, 23);
		lay_INI_Prov.add(btnINI_Prov);
		
		txt_pass_INI_Prov = new JPasswordField();
		txt_pass_INI_Prov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_pass_INI_Prov.setToolTipText("");
		txt_pass_INI_Prov.setEchoChar('#');
		txt_pass_INI_Prov.setBackground(Color.WHITE);
		txt_pass_INI_Prov.setBounds(200, 36, 145, 20);
		lay_INI_Prov.add(txt_pass_INI_Prov);
		
		txt_INI_Prov = new JTextField();
		txt_INI_Prov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_INI_Prov.setColumns(10);
		txt_INI_Prov.setBackground(Color.WHITE);
		txt_INI_Prov.setBounds(200, 11, 145, 20);
		lay_INI_Prov.add(txt_INI_Prov);
		
		JLabel CI_INI_Prov = new JLabel("C.I");
		CI_INI_Prov.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		CI_INI_Prov.setBounds(78, 15, 113, 14);
		lay_INI_Prov.add(CI_INI_Prov);
		
		JLabel lbiContrasena = new JLabel("Contraseña");
		lbiContrasena.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lbiContrasena.setBounds(78, 39, 113, 14);
		lay_INI_Prov.add(lbiContrasena);
		
		JButton btnVolver_Prov = new JButton("Volver");
		btnVolver_Prov.setForeground(new Color(0, 0, 0));
		btnVolver_Prov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inicio.setSelectedIndex(0);
			}
		});
		btnVolver_Prov.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver_Prov.setBackground(Color.WHITE);
		btnVolver_Prov.setBounds(120, 101, 162, 23);
		lay_INI_Prov.add(btnVolver_Prov);
		JTabbedPane panRegCli = new JTabbedPane(JTabbedPane.TOP);
		panel_Inicio.addTab("Cliente", null, panRegCli, null);
		
		JLayeredPane layRegiCLI = new JLayeredPane();
		panRegCli.addTab("Registro para Cliente", null, layRegiCLI, null);
		
		JLabel nameRegis = new JLabel("Nombre completo");
		nameRegis.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		nameRegis.setBounds(74, 34, 113, 14);
		layRegiCLI.add(nameRegis);
		
		JLabel passRegis = new JLabel("Contraseña");
		passRegis.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		passRegis.setBounds(74, 58, 90, 14);
		layRegiCLI.add(passRegis);
		
		JLabel ubiRegis = new JLabel("Ubicacion");
		ubiRegis.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		ubiRegis.setBounds(74, 108, 75, 20);
		layRegiCLI.add(ubiRegis);
		
		txt_name_Regi_CLI = new JTextField();
		txt_name_Regi_CLI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_name_Regi_CLI.setColumns(10);
		txt_name_Regi_CLI.setBounds(196, 30, 176, 20);
		layRegiCLI.add(txt_name_Regi_CLI);
		
		txt_pass_Regi_CLI = new JTextField();
		txt_pass_Regi_CLI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_pass_Regi_CLI.setColumns(10);
		txt_pass_Regi_CLI.setBounds(196, 55, 176, 20);
		layRegiCLI.add(txt_pass_Regi_CLI);
		
		txt_ubi_Regi_CLI = new JTextField();
		txt_ubi_Regi_CLI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_ubi_Regi_CLI.setColumns(10);
		txt_ubi_Regi_CLI.setBounds(196, 105, 176, 20);
		layRegiCLI.add(txt_ubi_Regi_CLI);
		
		JLabel ciRegi = new JLabel("C.I");
		ciRegi.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		ciRegi.setBounds(74, 83, 52, 14);
		layRegiCLI.add(ciRegi);
		
		txt_ci_Regi_CLi = new JTextField();
		txt_ci_Regi_CLi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_ci_Regi_CLi.setColumns(10);
		txt_ci_Regi_CLi.setBounds(196, 80, 176, 20);
		layRegiCLI.add(txt_ci_Regi_CLi);
		
		JButton btnAddCLI = new JButton("AÑADIR CLIENTE");
		btnAddCLI.setBackground(Color.WHITE);
		btnAddCLI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txt_name_Regi_CLI.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_pass_Regi_CLI.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_ci_Regi_CLi.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_ubi_Regi_CLI.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else {
				String nombre_C = txt_name_Regi_CLI.getText();
				String clave = txt_pass_Regi_CLI.getText();
				int C_I = Integer.parseInt(txt_ci_Regi_CLi.getText());
				String ubicacion = txt_ubi_Regi_CLI.getText();
				
				Negocio.insertarpersona(nombre_C, C_I, clave, ubicacion);
				
				txt_name_Regi_CLI.setText(null);
				txt_pass_Regi_CLI.setText(null);
				txt_ci_Regi_CLi.setText(null);
				txt_ubi_Regi_CLI.setText(null);
			}
				}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Ingrese bien los datos" );
					}
			}
		});
		btnAddCLI.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddCLI.setBounds(140, 139, 139, 23);
		layRegiCLI.add(btnAddCLI);
		
		JButton btnVolverCli = new JButton("VOLVER");
		btnVolverCli.setBackground(Color.WHITE);
		btnVolverCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inicio.setSelectedIndex(0);
			}
		});
		btnVolverCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVolverCli.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolverCli.setBounds(140, 167, 139, 23);
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
		
		JLabel nameProv = new JLabel("Nombre completo");
		nameProv.setBounds(74, 30, 108, 14);
		nameProv.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(nameProv);
		
		txt_name_Prov = new JTextField();
		txt_name_Prov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_name_Prov.setBounds(187, 27, 176, 20);
		txt_name_Prov.setColumns(10);
		lay_Proveedor.add(txt_name_Prov);
		
		JLabel passProv = new JLabel("Contraseña");
		passProv.setBounds(74, 55, 108, 14);
		passProv.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(passProv);
		
		txt_pass_Prov = new JTextField();
		txt_pass_Prov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_pass_Prov.setBounds(187, 52, 176, 20);
		txt_pass_Prov.setColumns(10);
		lay_Proveedor.add(txt_pass_Prov);
		
		JLabel ciProv = new JLabel("C.I");
		ciProv.setBounds(74, 80, 108, 14);
		ciProv.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(ciProv);
		
		txt_ci_Prov = new JTextField();
		txt_ci_Prov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_ci_Prov.setBounds(187, 77, 176, 20);
		txt_ci_Prov.setColumns(10);
		lay_Proveedor.add(txt_ci_Prov);
		
		JLabel contact_Prov = new JLabel("Contacto");
		contact_Prov.setBounds(74, 105, 108, 14);
		contact_Prov.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lay_Proveedor.add(contact_Prov);
		
		txt_cont_Prov = new JTextField();
		txt_cont_Prov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_cont_Prov.setBounds(187, 102, 176, 20);
		txt_cont_Prov.setColumns(10);
		lay_Proveedor.add(txt_cont_Prov);
		
		JButton btnAddProv = new JButton("AÑADIR PROVEEDOR");
		btnAddProv.setBackground(Color.WHITE);
		btnAddProv.setBounds(146, 149, 156, 23);
		btnAddProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txt_name_Prov.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_pass_Prov.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_ci_Prov.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_cont_Prov.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else {
				String nombre_C = txt_name_Prov.getText();
				String clave = txt_pass_Prov.getText();
				int C_I = Integer.parseInt(txt_ci_Prov.getText());
				int contacto = Integer.parseInt(txt_cont_Prov.getText());
				
				Negocio.insertarproveedor(C_I, nombre_C, clave, contacto);
				
				txt_name_Prov.setText(null);
				txt_pass_Prov.setText(null);
				txt_ci_Prov.setText(null);
				txt_cont_Prov.setText(null);
			}
				}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Ingrese bien los datos" );
					}
			}
		});
		btnAddProv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lay_Proveedor.add(btnAddProv);
		
		JButton btnVolverProv = new JButton("VOLVER");
		btnVolverProv.setBackground(Color.WHITE);
		btnVolverProv.setBounds(146, 177, 156, 23);
		btnVolverProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Inicio.setSelectedIndex(0);
			}
		});
		btnVolverProv.setFont(new Font("Tahoma", Font.BOLD, 11));
		lay_Proveedor.add(btnVolverProv);
	}
}