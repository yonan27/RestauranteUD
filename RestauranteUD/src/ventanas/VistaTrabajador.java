package ventanas;

import javax.swing.JFrame;
import model.Trabajador;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import dataBase.GestorBD;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VistaTrabajador extends JFrame {

	
	private JMenuBar barraM;
	private JMenu clientesM;
	private JMenu venderM;
	private JMenu MenuM;
	private JMenu clientesEditarM;
	private JMenuItem clientesI;
	private JMenuItem clientesAddI;
	private JMenuItem clientesEliminarI;
	private JMenuItem clientesExportar;
	
	

	public VistaTrabajador (Trabajador t) {
		
		barraM = new JMenuBar();
		clientesM = new JMenu("clientes");
		venderM = new JMenu("vender");
		MenuM = new JMenu ("menu");
		
		clientesI = new JMenuItem("ver");
		clientesI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes.abrirTablaClientes(t);
				dispose();
			}
		});
		clientesM.add(clientesI);
		clientesEditarM = new JMenu("editar");
		clientesM.add(clientesEditarM);
		clientesAddI = new JMenuItem("Añadir cliente");
		clientesAddI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente.abrirRegistrarCliente(t);
				dispose();
			}
		});
		clientesEditarM.add(clientesAddI);
		clientesEliminarI = new JMenuItem("eliminar cliente");
		clientesEliminarI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes.abrirTablaClientes(t);
				dispose();
			}
			
		});
		clientesEditarM.add(clientesEliminarI);
		clientesExportar = new JMenuItem("exportar");
		clientesExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBDFichero("cliente");
				bd.desconectar();
			}
		});
		
		
	}

	public static void abrirVistaTrabajador(Trabajador t) {
		VistaTrabajador vistaTrabajador = new VistaTrabajador(t);
		vistaTrabajador.setTitle("Vista trabajador");
		vistaTrabajador.setSize(480,360);
		vistaTrabajador.setLocationRelativeTo(null);
		vistaTrabajador.setVisible(true);
	}
}