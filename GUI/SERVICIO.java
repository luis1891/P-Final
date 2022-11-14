package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Canvas;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class SERVICIO extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id_Service;
	private JTextField txt_name_Serv;
	private JTextField txt_Hora_Serv;
	private JTextField txt_desc_Serv;
	private JTextField txt_price_Serv;
	private JTextField txt_loc_Serv;
	private JTextField txt_ci_Serv;

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
		setBounds(100, 100, 435, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 400, 447);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Datos sobre su servicio", null, layeredPane, null);
		layeredPane.setLayout(null);
		
		JLabel idService = new JLabel("Servicio ID");
		idService.setBounds(20, 58, 72, 14);
		idService.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layeredPane.add(idService);
		
		txt_id_Service = new JTextField();
		txt_id_Service.setBounds(20, 75, 72, 20);
		txt_id_Service.setColumns(10);
		txt_id_Service.setBackground(new Color(255, 255, 255));
		layeredPane.add(txt_id_Service);
		
		JLabel CI_INI_1 = new JLabel("Descricion de servicio:");
		CI_INI_1.setBounds(20, 244, 145, 14);
		CI_INI_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layeredPane.add(CI_INI_1);
		
		JComboBox escojerServicio = new JComboBox();
		escojerServicio.setMaximumRowCount(4);
		escojerServicio.setModel(new DefaultComboBoxModel(new String[] {"Servicio 1", "Servicio 2", "Servicio 3", "Servicio 4"}));
		escojerServicio.setBounds(20, 20, 72, 22);
		layeredPane.add(escojerServicio);
		
		JLabel lblNombreDelServicio = new JLabel("Nombre del servicio");
		lblNombreDelServicio.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lblNombreDelServicio.setBounds(20, 106, 129, 14);
		layeredPane.add(lblNombreDelServicio);
		
		txt_name_Serv = new JTextField();
		txt_name_Serv.setBounds(20, 123, 185, 20);
		layeredPane.add(txt_name_Serv);
		txt_name_Serv.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorario.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lblHorario.setBounds(20, 149, 52, 14);
		layeredPane.add(lblHorario);
		
		txt_Hora_Serv = new JTextField();
		txt_Hora_Serv.setColumns(10);
		txt_Hora_Serv.setBounds(20, 168, 52, 20);
		layeredPane.add(txt_Hora_Serv);
		
		JButton btn_pub_Serv = new JButton("Publicar");
		btn_pub_Serv.setForeground(Color.BLACK);
		btn_pub_Serv.setBackground(Color.DARK_GRAY);
		btn_pub_Serv.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_pub_Serv.setBounds(20, 372, 113, 31);
		layeredPane.add(btn_pub_Serv);
		
		JButton btn_del_Serv = new JButton("Borrar");
		btn_del_Serv.setBackground(Color.DARK_GRAY);
		btn_del_Serv.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_del_Serv.setBounds(256, 372, 113, 31);
		layeredPane.add(btn_del_Serv);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_volver.setBackground(Color.DARK_GRAY);
		btn_volver.setBounds(138, 372, 113, 31);
		layeredPane.add(btn_volver);
		
		txt_desc_Serv = new JTextField();
		txt_desc_Serv.setBounds(20, 265, 305, 68);
		layeredPane.add(txt_desc_Serv);
		txt_desc_Serv.setColumns(10);
		
		JLabel preServ = new JLabel("Precio");
		preServ.setHorizontalAlignment(SwingConstants.CENTER);
		preServ.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		preServ.setBounds(114, 149, 43, 14);
		layeredPane.add(preServ);
		
		txt_price_Serv = new JTextField();
		txt_price_Serv.setToolTipText("");
		txt_price_Serv.setColumns(10);
		txt_price_Serv.setBounds(103, 168, 72, 20);
		layeredPane.add(txt_price_Serv);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		lblLocalidad.setBounds(20, 196, 61, 14);
		layeredPane.add(lblLocalidad);
		
		txt_loc_Serv = new JTextField();
		txt_loc_Serv.setColumns(10);
		txt_loc_Serv.setBounds(20, 213, 185, 20);
		layeredPane.add(txt_loc_Serv);
		
		JLabel ciService = new JLabel("Servicio C.I");
		ciService.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		ciService.setBounds(157, 58, 72, 14);
		layeredPane.add(ciService);
		
		txt_ci_Serv = new JTextField();
		txt_ci_Serv.setColumns(10);
		txt_ci_Serv.setBackground(Color.WHITE);
		txt_ci_Serv.setBounds(128, 75, 133, 20);
		layeredPane.add(txt_ci_Serv);
	}
}

