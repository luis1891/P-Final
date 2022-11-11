package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class REGISTRO_CLI extends JFrame {
 
	private JPanel contentPane;
	private JTextField txt_nameCompleto_Regi;
	private JTextField txt_pass_Regi;
	private JTextField txt_ubi_Regi;
	private JTextField textField;
	private JButton btnAadirCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					REGISTRO_CLI frame = new REGISTRO_CLI();
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
	public REGISTRO_CLI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameRegis = new JLabel("Nombre completo");
		nameRegis.setFont(new Font("Tahoma", Font.BOLD, 11));
		nameRegis.setBounds(36, 30, 113, 14);
		contentPane.add(nameRegis);
		
		JLabel passRegis = new JLabel("Contrase\u00F1a");
		passRegis.setFont(new Font("Tahoma", Font.BOLD, 11));
		passRegis.setBounds(36, 72, 90, 14);
		contentPane.add(passRegis);
		
		JLabel ubiRegis = new JLabel("Ubicacion");
		ubiRegis.setFont(new Font("Tahoma", Font.BOLD, 11));
		ubiRegis.setBounds(36, 155, 64, 14);
		contentPane.add(ubiRegis);
		
		txt_nameCompleto_Regi = new JTextField();
		txt_nameCompleto_Regi.setBounds(154, 30, 176, 20);
		contentPane.add(txt_nameCompleto_Regi);
		txt_nameCompleto_Regi.setColumns(10);
		
		txt_pass_Regi = new JTextField();
		txt_pass_Regi.setBounds(154, 72, 176, 20);
		contentPane.add(txt_pass_Regi);
		txt_pass_Regi.setColumns(10);
		
		txt_ubi_Regi = new JTextField();
		txt_ubi_Regi.setColumns(10);
		txt_ubi_Regi.setBounds(154, 155, 176, 20);
		contentPane.add(txt_ubi_Regi);
		
		JLabel ciRegi = new JLabel("C.I");
		ciRegi.setFont(new Font("Tahoma", Font.BOLD, 11));
		ciRegi.setBounds(36, 113, 52, 14);
		contentPane.add(ciRegi);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(154, 113, 176, 20);
		contentPane.add(textField);
		
		btnAadirCliente = new JButton("A\u00D1ADIR CLIENTE");
		btnAadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAadirCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAadirCliente.setBounds(170, 204, 139, 23);
		contentPane.add(btnAadirCliente);
	}
}
