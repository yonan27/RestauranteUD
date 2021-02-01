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

public class TablaVentaMenu extends JFrame {

	private JScrollPane tablaPanel;
	private JPanel botonesPanel;
	private JButton anadirButton;
	private JButton eliminarButton;
	private JButton atrasButton;
	private JTable tabla;
	private DefaultTableModel modelo;
	
	 public TablaVentaMenu(Trabajador t) {
		
	 	this.setTitle("tabla de ventas de menus");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setData();
		tablaPanel = new JScrollPane(tabla);

		botonesPanel = new JPanel();
		botonesPanel.setLayout(new GridBagLayout());

		anadirButton = new JButton("anadir venta");
		botonesPanel.add(anadirButton);

		eliminarButton = new JButton("eliminar venta");
		botonesPanel.add(eliminarButton);

		atrasButton = new JButton("atras");
		botonesPanel.add(atrasButton);

		anadirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EscogerMenu.abrirEscogerMenu(null,t);
				dispose();	
			}
		});


		eliminarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"si", "no"};
				if(tabla.getSelectedRow() >= 0) {
					String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("semanal"));

					int respuesta = JOptionPane.showOptionDialog( null, "¿estas seguro de cancelar el menu "+ nombre + " ?",
							"borrar", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

					switch (respuesta) {
					case 0:
						String nombreM = (String) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("menu"));
						boolean semanal = (boolean) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("menu semanal"));
						boolean finDeSemana = (boolean) modelo.getValueAt(tabla.getSelectedRow(), modelo.findColumn("menu finDeSemana"));
						

						GestorBD bd = new GestorBD();
						bd.eliminarVenta("ventamenu",nombreM ,semanal, finDeSemana);
						bd.desconectar();

						TablaVentaMenu.abrirTablaVentasMenu(t);
						dispose();
						break;
					default:
						break;
					}
				}else {
					JOptionPane.showMessageDialog(null, "selecciona una fila de la tabla", null, 0);
				}
			}
		});
 
		atrasButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
			}
		});

		add(tablaPanel, BorderLayout.CENTER);
		add(botonesPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		this.setVisible(true);

}
		 private void setData() {
				modelo = new DefaultTableModel();
				tabla = new JTable(modelo);

				modelo.addColumn("semanal");
				modelo.addColumn("finDeSemana");

				GestorBD bd = new GestorBD();
				ResultSet rs = bd.rellenarTablaVentaMenu();
				
				try {
					while (rs.next()){
						Object [] fila = new Object[2]; 
						for (int i = 0;i<fila.length;i++) {

							if (i == 3) {
								if (rs.getObject(i+1).equals(0)) {
									fila[i] = "no";
								} else {
									fila[i] = "si";
								}
							} else if (i == 4) {
								if (rs.getObject(i+1).equals(0)) {
									fila[i] = "no";
								} else {
									fila[i] = "si";
								}
							} else {
								fila[i] = rs.getObject(i+1); 
							}
						}
						modelo.addRow(fila);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				bd.desconectar();
			}
		 
	private void volver(Trabajador t) {
		if (t.isGerente()) {
			VistaGerente.abrirVistaGerente(t);
			dispose();
		} else {
			VistaTrabajador.abrirVistaTrabajador(t);
			dispose();
		}
	}
	public static void abrirTablaVentasMenu(Trabajador t) {
		TablaVentaMenu tablaVentas = new TablaVentaMenu(t);
		tablaVentas.setVisible(true);
		tablaVentas.setSize(480,360);
		tablaVentas.setLocationRelativeTo(null);
		
	}
	
}
