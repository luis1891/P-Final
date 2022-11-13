package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class REGISTRO_PROV extends JFrame {

	private JPanel contentPane;
	private JTextField txt_disp_Prov;
	private JTextField txt_CI_Prov;
	private JTextField txt_contact_Prov;
	private JTextField txt_ID_Prov;
	private JTextField txt_name_Prov;
	private JTextField txt_pass_Prov;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGISTRO_PROV frame = new REGISTRO_PROV();
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
	public REGISTRO_PROV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_disp_Prov = new JTextField();
		txt_disp_Prov.setColumns(10);
		txt_disp_Prov.setBounds(155, 167, 176, 20);
		contentPane.add(txt_disp_Prov);
		
		JButton btn_Prov = new JButton("A\u00D1ADIR PROVEEDOR");
		btn_Prov.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Prov.setBounds(94, 212, 160, 23);
		contentPane.add(btn_Prov);
		
		JLabel disp_Prov = new JLabel("Disponibilidad");
		disp_Prov.setFont(new Font("Tahoma", Font.BOLD, 11));
		disp_Prov.setBounds(37, 167, 90, 14);
		contentPane.add(disp_Prov);
		
		JLabel ci_Prov = new JLabel("C.I");
		ci_Prov.setFont(new Font("Tahoma", Font.BOLD, 11));
		ci_Prov.setBounds(37, 106, 52, 14);
		contentPane.add(ci_Prov);
		
		txt_CI_Prov = new JTextField();
		txt_CI_Prov.setColumns(10);
		txt_CI_Prov.setBounds(155, 106, 176, 20);
		contentPane.add(txt_CI_Prov);
		
		txt_contact_Prov = new JTextField();
		txt_contact_Prov.setColumns(10);
		txt_contact_Prov.setBounds(155, 136, 176, 20);
		contentPane.add(txt_contact_Prov);
		
		JLabel contact_Prov = new JLabel("Contacto");
		contact_Prov.setFont(new Font("Tahoma", Font.BOLD, 11));
		contact_Prov.setBounds(37, 136, 90, 14);
		contentPane.add(contact_Prov);
		
		JLabel id_Prov = new JLabel("ID");
		id_Prov.setFont(new Font("Tahoma", Font.BOLD, 11));
		id_Prov.setBounds(37, 26, 113, 14);
		contentPane.add(id_Prov);
		
		txt_ID_Prov = new JTextField();
		txt_ID_Prov.setColumns(10);
		txt_ID_Prov.setBounds(155, 26, 52, 20);
		contentPane.add(txt_ID_Prov);
		
		JLabel nameProv = new JLabel("Nombre completo");
		nameProv.setFont(new Font("Tahoma", Font.BOLD, 11));
		nameProv.setBounds(37, 51, 113, 14);
		contentPane.add(nameProv);
		
		JLabel passProv = new JLabel("Contrase\u00F1a");
		passProv.setFont(new Font("Tahoma", Font.BOLD, 11));
		passProv.setBounds(37, 81, 90, 14);
		contentPane.add(passProv);
		
		txt_name_Prov = new JTextField();
		txt_name_Prov.setColumns(10);
		txt_name_Prov.setBounds(155, 51, 176, 20);
		contentPane.add(txt_name_Prov);
		
		txt_pass_Prov = new JTextField();
		txt_pass_Prov.setColumns(10);
		txt_pass_Prov.setBounds(155, 81, 176, 20);
		contentPane.add(txt_pass_Prov);
	}

}
