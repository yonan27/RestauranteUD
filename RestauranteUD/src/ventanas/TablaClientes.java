package ventanas;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		
	}

}
