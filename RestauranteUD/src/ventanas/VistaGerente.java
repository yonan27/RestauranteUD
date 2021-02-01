package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataBase.GestorBD;
import model.Trabajador;

public class VistaGerente extends JFrame {

	
	private JMenuBar barraM;
	private JMenu clientesM;
	private JMenu trabajadoresM;
	private JMenu ventasM;
	private JMenu MenuM;
	private JMenu ventasMenuM;
	private JMenu clientesEditarM;
	private JMenu ventasMEditarM;
	private JMenuItem clientesVerItem;
	private JMenuItem clientesAddItem;
	private JMenuItem clientesImpotar;
	private JMenuItem clientesEliminarItem;
	private JMenuItem clientesExportar;
	private JMenuItem trabajadorVerItem;
	private JMenu trabajadorEditarM;
	private JMenuItem trabajadorAddItem;
	private JMenuItem trabajadorEliminarItem;
	private JMenuItem trabajadorImportar ;
	private JMenuItem trabajadorExportar;
	private JMenuItem ventasMVerItem;
	private JMenuItem ventasMAddItem;
	private JMenuItem ventasMEliminarItem;
	private JMenuItem ventasMExportar;
	
	
	private JPanel panelSuperior;
	private JButton cerrarButton;
	private JPanel opcionesPanel;
	private Box opcionesBox;
	private Box clienteBox;
	private JLabel clienteLabel;
	private JButton clienteButton;
	private Box trabajadorBox;
	private JLabel trabajadorLabel;
	private JButton trabajadorButton;
	private Box ventasBox;
	private JLabel ventasLabel;
	private JButton ventasButton;
	private Box menuBox;
	private JLabel menuLabel;
	private JButton menuButton;
	

	public VistaGerente (Trabajador t) {
		this.setTitle("Bienvenido "+ t.getNombre()+ " " + t.getApellidos());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450,330);
		this.setResizable(true);
		barraM= new JMenuBar();
		clientesM = new JMenu("clientes");
		trabajadoresM = new JMenu("trabajadores");
		ventasM = new JMenu("ventas");
		MenuM = new JMenu("menus");
		
		clientesVerItem = new JMenuItem("ver");
		clientesVerItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes.abrirTablaClientes(t);
				dispose();				
			}
		});
		clientesM.add(clientesVerItem);
		
		clientesEditarM = new JMenu("Editar");
		clientesM.add(clientesEditarM);
		clientesAddItem = new JMenuItem("anadir cliente");
		clientesAddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente.abrirRegistrarCliente(t);
				dispose();
			}
		});
		clientesEditarM.add(clientesAddItem);
		
		clientesEliminarItem = new JMenuItem("eliminar cliente");
		clientesEliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes.abrirTablaClientes(t);
				dispose();
			}
		});
		clientesEditarM.add(clientesEliminarItem);

		clientesImpotar = new JMenuItem("importar");
		clientesImpotar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.importarFicheroBD("cliente");
				bd.desconectar();
			}
		});
		clientesM.add(clientesImpotar);
		
		clientesExportar = new JMenuItem("exportar");
		clientesExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.importarFicheroBD("cliente");
				bd.desconectar();
			}
		});
		clientesM.add(clientesExportar);
		
		trabajadorVerItem = new JMenuItem("ver");
		trabajadorVerItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaTrabajador.abrirTablaTrabjador(t);
				dispose();
			}
		});
		trabajadoresM.add(trabajadorVerItem);
		
		trabajadorEditarM = new JMenu("editar");
		trabajadoresM.add(trabajadorEditarM);
		trabajadorAddItem = new JMenuItem("anadir trabjador");
		trabajadorAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ContratarTrabajador.abrirContratarTrabajador(t);
				dispose();
			}
		});
		trabajadorEditarM.add(trabajadorAddItem);
		
		trabajadorEliminarItem = new JMenuItem("despedir");
		trabajadorEliminarItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TablaTrabajador.abrirTablaTrabjador(t);
				dispose();
			}
		});
		trabajadorEditarM.add(trabajadorEliminarItem);
		
		trabajadorImportar = new JMenuItem("importar");
		trabajadorImportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.importarFicheroBD("trabajador");
				bd.desconectar();
			}
		});
		trabajadoresM.add(trabajadorImportar);
		
		trabajadorExportar = new JMenuItem("exportar");
		trabajadorExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestorBD bd = new GestorBD();
				bd.exportarBDFichero("trabajador");
				bd.desconectar();				
			}
		});
		trabajadoresM.add(trabajadorExportar);
		
		ventasMenuM = new JMenu("venta de menus");
		ventasM.add(ventasMenuM);

		ventasMVerItem = new JMenuItem("ver");
		ventasMVerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"semanal", "finDeSemana"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿que ventas de menus quieres ver?", "Ver ventas", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					TablaVentaMenu.abrirTablaVentasMenu(t);
					dispose();
					break;
				
				}
			}
		});
		ventasMenuM.add(ventasMVerItem);
		
		ventasMEditarM = new JMenu("editar");
		ventasMenuM.add(ventasMEditarM);
		ventasMAddItem = new JMenuItem("anadir venta");
		ventasMAddItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"semanal", "finDeSemana"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿que menu quiere comprar?", "comprar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					EscogerMenu.abrirEscogerMenu(null, t);
					dispose();
					break;
				
				}
			}
		});
		ventasMEditarM.add(ventasMAddItem);
		
		ventasMEliminarItem = new JMenuItem("eliminar ");
		ventasMEliminarItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"semanal", "finDeSemana"};

				int respuesta = JOptionPane.showOptionDialog( null, "¿que menu quiere eliminar?", "cancelar", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					TablaVentaMenu.abrirTablaVentasMenu(t);
					dispose();
					break;
				
				}
			}
		});
		ventasMEditarM.add(ventasMEliminarItem);
		
		ventasMExportar = new JMenuItem("exportar");
		ventasMExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"semanal", "finDeSemana"};
				GestorBD bd = new GestorBD();

				int respuesta = JOptionPane.showOptionDialog( null, "¿que menu quieres exportar?", "exportar ", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				switch (respuesta) {
				case 0:
					bd.exportarBDFichero("venta menu");
					bd.desconectar();	
					break;
				
				}
			}
		});
		ventasMenuM.add(ventasMExportar);

		barraM.add(clientesM);
		barraM.add(trabajadoresM);
		barraM.add(ventasM);
		barraM.add(MenuM);
		setJMenuBar(barraM);		
		panelSuperior  =new JPanel();
		cerrarButton = new JButton("cerrar sesion");
		cerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				volver();
			}
		});

		panelSuperior.add(Box.createRigidArea(new Dimension(300,0)));
		panelSuperior.add(cerrarButton);
		add(panelSuperior, BorderLayout.NORTH);
		opcionesPanel = new JPanel();
		opcionesPanel.setLayout(new GridBagLayout());
		clienteLabel = new JLabel("clientes");
		clienteButton = new JButton("ver clientes");
		clienteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes.abrirTablaClientes(t);
				dispose();
				}
		});

		clienteBox = new Box(BoxLayout.Y_AXIS);
		clienteBox.add(clienteLabel);
		clienteBox.add(Box.createRigidArea(new Dimension(0, 10)));
		clienteBox.add(clienteButton);
		trabajadorLabel = new JLabel("trabajadores");
		trabajadorButton = new JButton("ver trabajadores");
		trabajadorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaClientes.abrirTablaClientes(t);
				dispose();
			}
		});
		
		trabajadorBox = new Box(BoxLayout.Y_AXIS);
		trabajadorBox.add(trabajadorLabel);
		trabajadorBox.add(Box.createRigidArea(new Dimension(0, 10)));
		trabajadorBox.add(trabajadorButton);
		menuLabel = new JLabel("menus");
		menuButton = new JButton("ver menus");
		menuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TablaTrabajador.abrirTablaTrabjador(t);
				dispose();	
			}
		});
		
		menuBox = new Box(BoxLayout.Y_AXIS);
		menuBox.add(menuLabel);
		menuBox.add(Box.createRigidArea(new Dimension(0, 10)));
		menuBox.add(menuButton);
		ventasLabel = new JLabel("ventas");
		ventasButton = new JButton("ver ventas");
		ventasButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"semanal, finDeSemana"};
				int respuesta = JOptionPane.showOptionDialog(null,
						"¿que ventas quiere ver?","ver ventas",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null,opciones,opciones[0]);
				switch (respuesta) {
				case 0:
					String[] opciones1 = {"menuS", "menuFDS"};

					int respuesta1 = JOptionPane.showOptionDialog( null, "¿que ventas del menu quiere ver?", "ver ventas", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opciones1, opciones1[0]);
					switch (respuesta1) {
					case 0:
						TablaClientes.abrirTablaClientes(t);
						dispose();
						break;
					case 1:
						TablaClientes.abrirTablaClientes(t);
						dispose();
						break;
					default:
						break;
					}
					break;
				
				}
			}
		});
		
		ventasBox = new Box(BoxLayout.Y_AXIS);
		ventasBox.add(ventasLabel);
		ventasBox.add(Box.createRigidArea(new Dimension(0, 10)));
		ventasBox.add(ventasButton);
		opcionesBox = new Box(BoxLayout.Y_AXIS);
		opcionesBox.add(clienteBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(trabajadorBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(ventasBox);
		opcionesBox.add(Box.createRigidArea(new Dimension(0, 10)));
		opcionesBox.add(menuBox);
		opcionesPanel.add(opcionesBox);
		getContentPane().add(opcionesPanel, BorderLayout.CENTER);
		this.setVisible(true);
}
	public static void abrirVistaGerente(Trabajador t) {
		VistaGerente vistaGerente = new VistaGerente(t);
		vistaGerente.setVisible(true);
		vistaGerente.setSize(480,360);
		vistaGerente.setLocationRelativeTo(null);
		vistaGerente.setVisible(true);
	}
	private void volver() {
		Login.abrirLogin();
		dispose();
	}
}