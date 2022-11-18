package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Canvas;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Logica.Negocio;

public class SERVICIO extends JFrame{
	private JPanel contentPane;
	private JTextField txt_id_Service;
	private JTextField txt_price_Serv;
	private JTextField txt_loc_Serv;
	private JTextField txt_ci_Serv;
	private JComboBox escojerServicio;
	private JTextField txt_name_Serv;
	private JSpinner hora_i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SERVICIO frame = new SERVICIO();
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
	public SERVICIO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 400, 350);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Datos sobre su servicio", null, layeredPane, null);
		layeredPane.setLayout(null);
		
		JLabel idService = new JLabel("Servicio ID");
		idService.setBounds(20, 58, 72, 14);
		idService.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layeredPane.add(idService);
		
		txt_id_Service = new JTextField();
		txt_id_Service.setHorizontalAlignment(SwingConstants.CENTER);
		txt_id_Service.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		txt_id_Service.setText("1");
		txt_id_Service.setEditable(false);
		txt_id_Service.setBounds(20, 75, 72, 20);
		txt_id_Service.setColumns(10);
		txt_id_Service.setBackground(new Color(255, 255, 255));
		layeredPane.add(txt_id_Service);
		
		escojerServicio = new JComboBox();
		escojerServicio.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		escojerServicio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String opcion = (String)escojerServicio.getSelectedItem();
				if(opcion.equals("Servicio 1")) {
					txt_id_Service.setText("1");
					txt_name_Serv.setText("Herreria");
				}
				else if(opcion.equals("Servicio 2")) {
					txt_id_Service.setText("2");
					txt_name_Serv.setText("Carpinteria");
				}
				else if(opcion.equals("Servicio 3")) {
					txt_id_Service.setText("3");
					txt_name_Serv.setText("Albañileria");
				}
				else if(opcion.equals("Servicio 4")) {
					txt_id_Service.setText("4");
					txt_name_Serv.setText("Limpieza");
				}
			}
		});
		escojerServicio.setMaximumRowCount(4);
		escojerServicio.setModel(new DefaultComboBoxModel(new String[] {"Servicio 1", "Servicio 2", "Servicio 3", "Servicio 4"}));
		escojerServicio.setBounds(20, 20, 101, 22);
		layeredPane.add(escojerServicio);
			
		
		JLabel lblNombreDelServicio = new JLabel("Nombre del servicio");
		lblNombreDelServicio.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lblNombreDelServicio.setBounds(20, 106, 129, 14);
		layeredPane.add(lblNombreDelServicio);
		
		JButton btn_pub_Serv = new JButton("Publicar");
		btn_pub_Serv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txt_id_Service.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_ci_Serv.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_name_Serv.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_price_Serv.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else if(txt_loc_Serv.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor, llene los campos obligatorios");
					}
					else {
				String idse = txt_id_Service.getText();
				int C_I = Integer.parseInt(txt_ci_Serv.getText());
				int pre = Integer.parseInt(txt_price_Serv.getText());
				String hora = hora_i.getValue().toString();
				String zo = txt_loc_Serv.getText();
				String dispo = "si";
				
				Negocio.insertarhace(idse, C_I, pre, hora, zo,dispo);
				
				txt_ci_Serv.setText(null);
				txt_price_Serv.setText(null);
				txt_loc_Serv.setText(null);
			}
				}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Ingrese bien los datos" );
					}
			}
		});
		btn_pub_Serv.setForeground(Color.BLACK);
		btn_pub_Serv.setBackground(new Color(255, 255, 255));
		btn_pub_Serv.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_pub_Serv.setBounds(20, 262, 113, 31);
		layeredPane.add(btn_pub_Serv);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				INICIO inicio = new INICIO();
				inicio.setVisible(true);
				dispose();
			}
		});
		btn_volver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_volver.setBackground(new Color(255, 255, 255));
		btn_volver.setBounds(203, 262, 113, 31);
		layeredPane.add(btn_volver);
		
		JLabel preServ = new JLabel("Precio por hora");
		preServ.setHorizontalAlignment(SwingConstants.CENTER);
		preServ.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		preServ.setBounds(153, 149, 121, 14);
		layeredPane.add(preServ);
		
		txt_price_Serv = new JTextField();
		txt_price_Serv.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_price_Serv.setToolTipText("");
		txt_price_Serv.setColumns(10);
		txt_price_Serv.setBounds(176, 168, 72, 20);
		layeredPane.add(txt_price_Serv);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lblLocalidad.setBounds(20, 196, 113, 14);
		layeredPane.add(lblLocalidad);
		
		txt_loc_Serv = new JTextField();
		txt_loc_Serv.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_loc_Serv.setColumns(10);
		txt_loc_Serv.setBounds(20, 213, 185, 20);
		layeredPane.add(txt_loc_Serv);
		
		JLabel ciService = new JLabel("C.I Proveedor");
		ciService.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		ciService.setBounds(128, 58, 101, 14);
		layeredPane.add(ciService);
		
		txt_ci_Serv = new JTextField();
		txt_ci_Serv.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_ci_Serv.setColumns(10);
		txt_ci_Serv.setBackground(Color.WHITE);
		txt_ci_Serv.setBounds(128, 75, 133, 20);
		layeredPane.add(txt_ci_Serv);
		
		txt_name_Serv = new JTextField();
		txt_name_Serv.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		txt_name_Serv.setText("Herreria");
		txt_name_Serv.setEditable(false);
		txt_name_Serv.setColumns(10);
		txt_name_Serv.setBackground(Color.WHITE);
		txt_name_Serv.setBounds(20, 123, 113, 20);
		layeredPane.add(txt_name_Serv);
		
		hora_i = new JSpinner();
		hora_i.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		hora_i.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		hora_i.setBounds(42, 168, 50, 20);
		layeredPane.add(hora_i);
		
		JLabel lblNewLabel = new JLabel("Cantidad de horas");
		lblNewLabel.setBounds(20, 146, 121, 20);
		layeredPane.add(lblNewLabel);
	}
}