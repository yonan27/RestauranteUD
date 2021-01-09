package ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Trabajador;

public class TablaClientes extends JFrame {

	private JScrollPane tablaPanel;
	private JPanel botonPanel;
	private JButton anadirBoton;
	private JButton eliminarBoton;
	private JButton atrasBoton;
	private JTable tabla;
	private DefaultTableModel modelo;
	
	public TablaClientes(Trabajador t) {
		this.setTitle ("tabla de cliente");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setData();
		tablaPanel = new JScrollPane(tabla);
		botonPanel.setLayout(new GridBagLayout());
		anadirBoton = new JButton ("anadir cliente");
		botonPanel.add(anadirBoton);
		eliminarBoton = new JButton ("eleminar cliente");
		botonPanel.add(eliminarBoton);
		atrasBoton = new JButton ("atras");
		botonPanel.add(atrasBoton);
		
		anadirBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente.abrirRegistrarCliente(t);
				dispose();
				
			}
		});
		eliminarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"si","no"};
				if (tabla.getSelectedRow()>= 0) {
					String nombre = (String)modelo.getValueAt(tabla.getSelectedRow(),modelo.findColumn("nombre"));
				int respuesta = JOptionPane.showOptionDialog(null,"¿Quieres eliminar a" + nombre + 
						"?", "eliminar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null ,opciones, opciones[0]);
				switch(respuesta) {
				case 0:
					String dni = (String)modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("dni"));
					GestorBD bd = new GestorBD();
					bd.eleminarPersona("cliente",dni);
					bd.desconectar();
					TablaClientes.abrirTablaClientes(t);
					dispose();
					break;
					default:
						break;
				}
				}else {
					JOptionPane.showMessageDialog(null, "seleccionar una fila", null, 0);
				}
			}
		});
		atrasBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
				
			}
		});
		add(tablaPanel,BorderLayout.CENTER);
		add(botonPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	private void setData() {
		modelo = new DefaultTableModel();
		tabla = new JTable(modelo);
		modelo.addColumn("nombre");
		modelo.addColumn("apellido");
		modelo.addColumn("email");
		modelo.addColumn("dni");
		modelo.addColumn("usuario");
		modelo.addColumn("contraseña");
		
		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaClientes();
		try {
			while (rs.next()) {
				Object []fila = new Object[6];
				for (int i = 0; i < fila.length; i++) {
					fila[i] = rs.getObject(i+1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			bd.desconectar();
	}
	private void volver(Trabajador t) {
		if(t.isGerente()){
			VistaGerente.abrirVistaGerente(t);
			dispose();
		}else {
			VistaTrabajador.abrirVistaTrabajador(t);
			dispose();
		}
	}
	public static void abrirTablaClientes(Trabajador t) {
		TablaClientes tablaClientes = new TablaClientes(t);
		tablaClientes.setVisible(true);
		tablaClientes.setSize(500,300);
		tablaClientes.setLocationRelativeTo(null);
		tablaClientes.setVisible(true);
	}

}
