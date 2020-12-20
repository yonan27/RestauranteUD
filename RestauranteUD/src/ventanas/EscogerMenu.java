package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Cliente;
import model.Menu;
import model.Trabajador;

public class EscogerMenu extends JFrame{

	private JPanel surP;
	private JPanel bontonP;
	private JScrollPane tablaP;
	private JTable table;
	private JLabel informacionL;
	private DefaultTableModel model;
	private Box tablaB;
	private Box botonesB;
	private JButton volverBoton;
	private JButton comprarBoton;
	
	
	public EscogerMenu(Cliente c, Trabajador t) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("bienvenido");
		surP = new JPanel();
		surP.setLayout(new BorderLayout());
		JPanel centroP = new JPanel();
		centroP.setLayout(new BorderLayout());
		String frase = " selecciona el menu";
		informacionL = new JLabel (frase);
		surP.add(informacionL, BorderLayout.WEST);
		volverBoton = new JButton("volver");
		volverBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				volver(c,t);	
			}
		});
		
		surP.add(volverBoton, BorderLayout.EAST);
		setData();
		tablaP = new JScrollPane(table);
		tablaB = new Box(BoxLayout.Y_AXIS);
		tablaB.add(Box.createRigidArea(new Dimension(0,10)));
		tablaB.add(tablaP);
		comprarBoton = new JButton("comprar menu");
		comprarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 
				
			}
		});
	}
	
	
	private void setData() {
		// TODO 
		
	}


	public void cerrarCompra(Cliente c, Trabajador t, Menu m) {
		Menu cmenu = new Menu(false, false, null );
		GestorBD bd = new GestorBD();
		if(c == null){
			cmenu.setConsumidor(null);
		}else {
			cmenu.setConsumidor(c);
		}
	
		bd.desconectar();
		volver(c,t);
		
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
