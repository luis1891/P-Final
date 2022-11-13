package Por_las_dudas_xd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Negocio;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pvisual extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pvisual frame = new Pvisual();
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
	
	Negocio persona = new Negocio();
	private JTextField textCI;
	private JTextField textnombre;
	private JTextField txtClave;
	private JTextField txtUbicacion;
	private JButton btnNewButton;
	
	public Pvisual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 355, 1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 382, 111);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		textCI = new JTextField();
		textCI.setText("ci");
		textCI.setBounds(10, 122, 144, 20);
		contentPane.add(textCI);
		textCI.setColumns(10);
		
		textnombre = new JTextField();
		textnombre.setText("nombre");
		textnombre.setColumns(10);
		textnombre.setBounds(10, 153, 144, 20);
		contentPane.add(textnombre);
		
		txtClave = new JTextField();
		txtClave.setText("clave");
		txtClave.setColumns(10);
		txtClave.setBounds(10, 184, 144, 20);
		contentPane.add(txtClave);
		
		txtUbicacion = new JTextField();
		txtUbicacion.setText("ubicacion");
		txtUbicacion.setColumns(10);
		txtUbicacion.setBounds(10, 215, 144, 20);
		contentPane.add(txtUbicacion);
		
		JButton btnGuardar = new JButton("guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						
						String nombre = textnombre.getText();
						int C_I = Integer.parseInt(textCI.getText());
						String clave = txtClave.getText();
						String ubi = txtUbicacion.getText();
						Negocio.insertarpersona(nombre, C_I, clave, ubi);
						
					}
						
				
				 catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Ingrese bien los datos" );
				}
			
			}});
		
		btnGuardar.setBounds(204, 170, 89, 23);
		contentPane.add(btnGuardar);
		
		btnNewButton = new JButton("actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrardatos();
			}
		});
		btnNewButton.setBounds(204, 214, 89, 23);
		contentPane.add(btnNewButton);
		mostrardatos();
		
	}
	public void mostrardatos(){
		
		//String[] dato = new String[3];
		DefaultTableModel model = Negocio.Mostrardatospersona();
		//model.addColumn("CI");
		//model.addColumn("NOMBRE COMPLETO");
		//model.addColumn("FECHA DE NACIMIENTO");
		
		table.setModel(model);
		/*
		try {
			
			
			Statement st=CN.getConnection().prepareStatement(SQL);
			String mos = "SELECT * FROM DATOS";
			ResultSet rs=st.executeQuery(mos);
			while(rs.next()) {
				dato[0]=rs.getString(1);
				dato[1]=rs.getString(2);
				dato[2]=rs.getString(3);
				model.addRow(dato);
			}
			
		}
		catch (Exception e){
			System.out.print(e);
		}
		*/
	
}
}

