package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import Logica.Negocio;

public class CON_SERV extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JTextPane textcicn;

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
		Calendar calendar = Calendar.getInstance();
		int horap = calendar.get(Calendar.HOUR_OF_DAY);
		int minutop = calendar.get(Calendar.MINUTE);
		int segundop = calendar.get(Calendar.MINUTE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 768, 373);
		contentPane.add(tabbedPane);
		
		JLayeredPane layConService = new JLayeredPane();
		tabbedPane.addTab("Opcion de servicios", null, layConService, null);
		layConService.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String opcion = (String)comboBox.getSelectedItem();
				if(opcion.equals("Servicio 1")) {
					DefaultTableModel model = Negocio.Mostrardatoshace1();
					table.setModel(model);
					DefaultTableModel modeldesc = Negocio.Mostrardatosdesc1();
					table_1.setModel(modeldesc);
				}
				else if(opcion.equals("Servicio 2")) {
					DefaultTableModel model = Negocio.Mostrardatoshace2();
					table.setModel(model);
					DefaultTableModel modeldesc = Negocio.Mostrardatosdesc2();
					table_1.setModel(modeldesc);
				}
				else if(opcion.equals("Servicio 3")) {
					DefaultTableModel model = Negocio.Mostrardatoshace3();
					table.setModel(model);
					DefaultTableModel modeldesc = Negocio.Mostrardatosdesc3();
					table_1.setModel(modeldesc);
				}
				else if(opcion.equals("Servicio 4")) {
					DefaultTableModel model = Negocio.Mostrardatoshace4();
					table.setModel(model);
					DefaultTableModel modeldesc = Negocio.Mostrardatosdesc4();
					table_1.setModel(modeldesc);
				}
			}
		});
		comboBox.setBounds(10, 11, 105, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Servicio 1", "Servicio 2", "Servicio 3", "Servicio 4"}));
		layConService.add(comboBox);
		
		JButton btn_Aceptar = new JButton("Contratar");
		btn_Aceptar.setBounds(172, 276, 154, 44);
		btn_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				String disp = (String) table.getValueAt(fila, 5);;
				if(textcicn.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese su cedula");
				}
				else if(disp.equals("no")){
					JOptionPane.showMessageDialog(null, "Proveedor no disponible");
				}
				else if(table.getValueAt(fila, 1).equals(textcicn.getText())){
					JOptionPane.showMessageDialog(null, "No se puede contratar a si mismo");
				}
				else {
					int C_I = Integer.parseInt(textcicn.getText());
					String id_se = (String) table.getValueAt(fila, 0);
					String cip = (String) table.getValueAt(fila, 1);
					int C_Ip = Integer.parseInt(cip);
					String pre = (String) table.getValueAt(fila, 2);
					int precio = Integer.parseInt(pre);
					String hora = (String) table.getValueAt(fila, 3);
					int horaf = Integer.parseInt(hora);
					int preciot = precio * horaf;
					System.out.print(preciot);
					String zona = (String) table.getValueAt(fila, 4);
					String fecha = LocalDate.now().toString();
					String estado = "en curso";
					LocalTime hora_in = LocalTime.of(horap,minutop,segundop);
					LocalTime hora_fin = hora_in.plusHours(horaf);
					String hora_ini = hora_in.toString();
					String hora_f = hora_fin.toString();
					
					Negocio.insertarcontrata(C_I,id_se,fecha,hora,C_Ip,preciot);
					Negocio.modificarhace(id_se,C_Ip,precio,hora,zona,disp);
					Negocio.insertarhorario(hora_ini,hora_f,estado);
					
					comboBox.setSelectedIndex(0);
					DefaultTableModel model = Negocio.Mostrardatoshace1();
					table.setModel(model);
				}
			}
		});
		layConService.add(btn_Aceptar);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.setBounds(392, 276, 154, 44);
		btn_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				INICIO inicio = new INICIO();
				inicio.setVisible(true);
				dispose();
			}
		});
		layConService.add(btn_Volver);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 100, 741, 98);
		layConService.add(scrollPane);
		
		table = new JTable();
		table.setBounds(10, 44, 281, 218);
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = Negocio.Mostrardatoshace1();
		table.setModel(model);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 39, 317, 44);
		layConService.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setBounds(312, 83, 317, 116);
		
		DefaultTableModel modeldesc = Negocio.Mostrardatosdesc1();
		table_1.setModel(modeldesc);
		
		JLabel C_I_cn = new JLabel("Su C.I");
		C_I_cn.setBounds(10, 209, 63, 14);
		layConService.add(C_I_cn);
		
		textcicn = new JTextPane();
		textcicn.setEditable(false);
		textcicn.setBounds(10, 235, 154, 20);
		layConService.add(textcicn);
	}
	
	//guarda la ci y la utiliza automaticamente
	public void ci_login(String ci_l) {
		textcicn.setText(ci_l);
	}
}