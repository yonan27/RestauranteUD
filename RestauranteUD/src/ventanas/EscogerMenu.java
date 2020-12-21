package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.GestorBD;
import model.Cliente;
import model.Menu;
import model.Trabajador;

public class EscogerMenu extends JFrame{

	private JPanel norteP;
	private JPanel botonP;
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
		norteP = new JPanel();
		norteP.setLayout(new BorderLayout());
		JPanel centroP = new JPanel();
		centroP.setLayout(new BorderLayout());
		String frase = " selecciona el menu";
		informacionL = new JLabel (frase);
		norteP.add(informacionL, BorderLayout.WEST);
		volverBoton = new JButton("volver");
		volverBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				volver(c,t);	
			}
		});
		
		norteP.add(volverBoton, BorderLayout.EAST);
		setData();
		tablaP = new JScrollPane(table);
		tablaB = new Box(BoxLayout.Y_AXIS);
		tablaB.add(Box.createRigidArea(new Dimension(0,10)));
		tablaB.add(tablaP);
		comprarBoton = new JButton("comprar menu");
		comprarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] seleccion = {"si", "no"};
				if (table.getSelectedRow()>= 0) {
					boolean menuSemanal = false;
					boolean menufinDeSemana = false;
					Cliente consumidor = null;
					
					Menu m = new Menu( menuSemanal, menufinDeSemana, consumidor);
					
					int respuesta = JOptionPane.showOptionDialog(null, "que menu queire", "menu", JOptionPane.YES_NO_CANCEL_OPTION, 
							JOptionPane.QUESTION_MESSAGE, null, seleccion, seleccion[0]);
					
				}
			}
		});
		botonesB = new Box (BoxLayout.X_AXIS);
		botonesB.add(comprarBoton);
		botonesB.add(volverBoton);
		botonP = new JPanel();
		botonP.setLayout(new GridLayout());
		botonP.add(botonesB);
		centroP.add(tablaB,BorderLayout.CENTER);
		getContentPane().add(centroP, BorderLayout.CENTER);
		getContentPane().add(norteP, BorderLayout.NORTH);
		getContentPane().add(botonP, BorderLayout.SOUTH);
	}
	
	
	private void setData() {
		model = new DefaultTableModel();
		table = new JTable();
		model.addColumn("menu semanal");
		model.addColumn("menu fin de semana");
		model.addColumn("cliente");
		GestorBD bd = new GestorBD(); 
		ResultSet re = bd.TablaTrabajadores();
		try {
			while (re.next()) {
				Object [] fila = new Object[3];
				for (int i = 0; i < fila.length; i++) {
					if (i == 2) {
						if (re.getObject(i+1).equals(0)) {
							fila[i] = "no";
						} else {
							fila[i] = "si";
						}
						
					}else {
						fila[i] = re.getObject(i+1);
					}
					model.addRow(fila);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.desconectar();
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
