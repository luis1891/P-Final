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

public class SERVICIO extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id_Service;

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
		setBounds(100, 100, 469, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 435, 382);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Datos sobre su servicio", null, layeredPane, null);
		
		JLabel idService = new JLabel("Servicio ID");
		idService.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		idService.setBounds(21, 15, 113, 14);
		layeredPane.add(idService);
		
		txt_id_Service = new JTextField();
		txt_id_Service.setColumns(10);
		txt_id_Service.setBackground(Color.WHITE);
		txt_id_Service.setBounds(156, 11, 72, 20);
		layeredPane.add(txt_id_Service);
		
		JLabel CI_INI_1 = new JLabel("Descricion de servicio:");
		CI_INI_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 13));
		CI_INI_1.setBounds(21, 44, 145, 14);
		layeredPane.add(CI_INI_1);
		
		JTextPane descriptService = new JTextPane();
		layeredPane.setLayer(descriptService, 0);
		descriptService.setForeground(new Color(0, 0, 255));
		descriptService.setBackground(new Color(255, 255, 255));
		descriptService.setBounds(21, 69, 367, 235);
		layeredPane.add(descriptService);
	}
}
