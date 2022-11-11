package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class INICIO extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass_INI;
	private JTextField ci_INI;

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
	public INICIO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pass_INI = new JPasswordField();
		pass_INI.setEchoChar('#');
		pass_INI.setToolTipText("");
		pass_INI.setBounds(106, 86, 145, 20);
		contentPane.add(pass_INI);
		
		ci_INI = new JTextField();
		ci_INI.setBounds(106, 48, 145, 20);
		contentPane.add(ci_INI);
		ci_INI.setColumns(10);
		
		JLabel CI_INI = new JLabel("C.I");
		CI_INI.setFont(new Font("Tahoma", Font.BOLD, 11));
		CI_INI.setBounds(10, 48, 34, 14);
		contentPane.add(CI_INI);
		
		JLabel txt_pass = new JLabel("CONTRASE\u00D1A ");
		txt_pass.setFont(new Font("Tahoma", Font.BOLD, 11));
		txt_pass.setBounds(10, 86, 86, 14);
		contentPane.add(txt_pass);
		
		JButton btnINI_CLI = new JButton("INICIAR CLIENTE");
		btnINI_CLI.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnINI_CLI.setBounds(67, 117, 162, 23);
		contentPane.add(btnINI_CLI);
		
		JButton btnIniciarProveedor = new JButton("INICIAR \r\nPROVEEDOR");
		btnIniciarProveedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIniciarProveedor.setBounds(67, 161, 162, 23);
		contentPane.add(btnIniciarProveedor);
	}
}
