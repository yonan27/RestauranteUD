package ventanas;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.Menu;
import model.Trabajador;

public class EscogerMenu extends JFrame{

	private JPanel surP;
	private JPanel bontonP;
	private JScrollPane tablaP;
	private JTable table;
	private DefaultTableModel model;
	private Box tablaB;
	private Box botonesB;
	private JButton volverBoton;
	private JButton comprarBoton;
	
	
	public static void EscogerMenu(Cliente c, Trabajador t) {
		//TODO
	}
	
	
	public void cerrarCompra(Cliente c, Trabajador t, Menu m) {
		if(t== null) {
			VistaCliente.abrirVistaCliente(c);
			dispose();
		}else {
			if(t.isGerente()) {
				VistaGerente.abrirVistaGerente(t);
				dispose();
				
			}else {
				VistaTrabajador.abrirVistaTrabajador(t);
				dispose();
			}
		}
	}
	private void volver(Cliente c, Trabajador t) {
		if(t == null) {
			VistaCliente.abrirVistaCliente(c);
			dispose();
		}else {
			if(t.isGerente()) {
				VistaGerente.abrirVistaGerente(t);
				dispose();
				
			}else {
				VistaTrabajador.abrirVistaTrabajador(t);
				dispose();
			}
		}
	}
	
	
	
	public static void abrirEscogerMenu(Cliente c, Trabajador t) {
	EscogerMenu escogerM = new EscogerMenu(c,t);
	escogerM.setVisible(true);
	escogerM.setSize(500, 500);
		
		
	}
}
