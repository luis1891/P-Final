package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class CON_SERV extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Name_Serv;
	private JTextField txt_con_Serv;
	private JTextField txt_Ci_Serv;
	private JTextField txt_Disp_Serv;
	private JTextField txt_IdServicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CON_SERV frame = new CON_SERV();
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
	public CON_SERV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 644, 438);
		contentPane.add(tabbedPane);
		
		JLayeredPane layConService = new JLayeredPane();
		tabbedPane.addTab("Opcion de servicios", null, layConService, null);
		layConService.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(224, 0, 15, 312);
		layConService.setLayer(separator, 10);
		layConService.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.LIGHT_GRAY);
		
		/*
		 ###############################################################
		 #   														   #
		 # La idea de la parte de abajo, es que cuando el usuario      #
		 # elija otro servicio se carguen en el visual los datos       #
		 # de proveedor como el de sus ID servicio nuevo y su 		   #
		 # descripcion, en caso que no te guste la idea podes quitarlo #
		 # sin drama 												   #
		 #   														   #
		 ###############################################################
		*/
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Servicio 1", "Servicio 2", "Servicio 3", "Servicio 4"}));
		//comboBox.setSelectedIndex(-5); esta linea comente
		comboBox.setBounds(10, 11, 80, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Servicio 1", "Servicio 2", "Servicio 3", "Servicio 4"}));
		layConService.add(comboBox);
		
		//##################
		
		txt_Name_Serv = new JTextField();
		txt_Name_Serv.setBounds(10, 152, 155, 20);
		layConService.add(txt_Name_Serv);
		txt_Name_Serv.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Datos sobre el Proveedor:");
		lblNewLabel.setBounds(10, 44, 189, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		layConService.add(lblNewLabel);
		
		JLabel lblcontactProveedor = new JLabel("Numero de Contacto");
		lblcontactProveedor.setBounds(10, 77, 122, 14);
		lblcontactProveedor.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layConService.add(lblcontactProveedor);
		
		JLabel lblNombreDeProvedor = new JLabel("Nombre de Provedor");
		lblNombreDeProvedor.setBounds(10, 133, 143, 14);
		lblNombreDeProvedor.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layConService.add(lblNombreDeProvedor);
		
		JLabel lblCiProvedor = new JLabel("C.I Proveedor");
		lblCiProvedor.setBounds(10, 183, 113, 14);
		lblCiProvedor.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layConService.add(lblCiProvedor);
		
		JLabel lblDisponibilidadDeProvedor = new JLabel("Disponibilidad de Provedor");
		lblDisponibilidadDeProvedor.setBounds(10, 232, 173, 14);
		lblDisponibilidadDeProvedor.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layConService.add(lblDisponibilidadDeProvedor);
		
		txt_con_Serv = new JTextField();
		txt_con_Serv.setBounds(10, 95, 155, 20);
		txt_con_Serv.setColumns(10);
		layConService.add(txt_con_Serv);
		
		txt_Ci_Serv = new JTextField();
		txt_Ci_Serv.setBounds(10, 201, 122, 20);
		txt_Ci_Serv.setColumns(10);
		layConService.add(txt_Ci_Serv);
		
		txt_Disp_Serv = new JTextField();
		txt_Disp_Serv.setBounds(10, 251, 204, 33);
		txt_Disp_Serv.setColumns(10);
		layConService.add(txt_Disp_Serv);
		
		JLabel lblServicioId = new JLabel("Servicio ID");
		lblServicioId.setBounds(249, 34, 80, 14);
		lblServicioId.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layConService.add(lblServicioId);
		
		txt_IdServicio = new JTextField();
		txt_IdServicio.setBounds(336, 30, 45, 20);
		txt_IdServicio.setColumns(10);
		layConService.add(txt_IdServicio);
		
		JLabel lblDescripcionDelServicio = new JLabel("Descripcion del servicio");
		lblDescripcionDelServicio.setBounds(249, 76, 143, 14);
		lblDescripcionDelServicio.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		layConService.add(lblDescripcionDelServicio);
		
		JPanel panel_DescriptService = new JPanel();
		panel_DescriptService.setBounds(249, 101, 317, 116);
		layConService.add(panel_DescriptService);
		
		JButton btn_Aceptar = new JButton("Aceptar");
		btn_Aceptar.setBounds(255, 253, 154, 44);
		layConService.add(btn_Aceptar);
		
		JButton btn_Denegar = new JButton("Denegar");
		btn_Denegar.setBounds(431, 253, 154, 44);
		layConService.add(btn_Denegar);
		
	}
}

