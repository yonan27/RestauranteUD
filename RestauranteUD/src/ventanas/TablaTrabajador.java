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

public class TablaTrabajador extends JFrame{

	private JScrollPane tablaPanel;
	private JPanel botonPanel;
	private JButton anadirBoton;
	private JButton echarBoton;
	private JButton atrasBoton;
	private JTable tabla;
	private DefaultTableModel modelo;
	
	public  TablaTrabajador(Trabajador t) {
		this.setTitle("Tabla trabajador");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setData();
		tablaPanel = new JScrollPane(tabla);
		botonPanel = new JPanel();
		botonPanel.setLayout(new GridBagLayout());
		anadirBoton = new JButton ("contratar trabajador");
		botonPanel.add(anadirBoton);
		echarBoton = new JButton("echar trabajador");
		botonPanel.add(echarBoton);
		atrasBoton = new JButton("atras");
		botonPanel.add(atrasBoton);
		
		anadirBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ContratarTrabajador.abrirContratarTrabajador(t);
				dispose();
			}
		});
		echarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opcion = {"si","no"};
				if(tabla.getSelectedRow()>= 0) {
					String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(),modelo.findColumn("nombre"));
				int respuesta = JOptionPane.showOptionDialog(null,"¿despedir a "+ nombre + "?", "despedir",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcion , opcion[0]);
				switch (respuesta) {
				case 0:
					String dni = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("dni"));
				GestorBD bd = new GestorBD();
				bd.eliminarPersona("trabajador",dni);
				bd.desconectar();
				TablaTrabajador.abrirTablaTrabjador(t);
				dispose();
				break;
				default:
					break;
				}
				}else {
					JOptionPane.showMessageDialog(null, "selecciona una fila",null,0);
				}
				
			}
		});
		atrasBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
				
			}
		});
		add(tablaPanel, BorderLayout.CENTER);
		add(tablaPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
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
		modelo.addColumn("sueldo");
		modelo.addColumn("gerente");
		
		GestorBD bd = new GestorBD();
		ResultSet rs = bd.rellenarTablaTrabajador();
		
		try {
			while (rs.next()) {
				Object[] fila = new Object[8];
				for (int i = 0; i < fila.length; i++) {
					if(i ==7) {
						if(rs.getObject(i+1).equals(0)) {
							fila[i] ="no";
						}else {
							fila[i]= "si";
						}
					}else {
						fila[i]= rs.getObject(i+1);
					}
				}
				modelo.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
	}
	private void volver(Trabajador t ) {
		if(t.isGerente()) {
			VistaGerente.abrirVistaGerente(t);
			dispose();
		}else {
			VistaTrabajador.abrirVistaTrabajador(t);
			dispose();
		}
	}
	public static void abrirTablaTrabjador(Trabajador t) {
		TablaTrabajador tablaTrabajador = new TablaTrabajador(t);
		tablaTrabajador.setVisible(true);
		tablaTrabajador.setSize(500,300);
		tablaTrabajador.setLocationRelativeTo(null);
		tablaTrabajador.setVisible(true);
	}
	
}
