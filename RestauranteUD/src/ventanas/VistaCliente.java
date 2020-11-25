package ventanas;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Cliente;

public class VistaCliente extends JFrame{
	private static final long seriaVersionUD = 1L;
	private JPanel panelSuperior;
	private JPanel opcionesPanel;
	private JLabel restauranteLabel;
	private JButton cerrarButton;
	private JButton restauranteButton;
	private Box opcionesBox;
	private Box restauranteBox;
	
	
	public VistaCliente(Cliente c) {
		this.setTitle("Bienvenido " + c.getNombre()+ " " + c.getApellidos());
		this.setResizable(true);
		panelSuperior = new JPanel();
		cerrarButton = new JButton("Cerrar sesion");
		cerrarButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				volver();
				dispose();
			}
		});

	panelSuperior.add(Box.createRigidArea(new Dimension(300,0)));
	panelSuperior.add(cerrarButton);
	opcionesPanel = new JPanel();
	opcionesPanel.setLayout(new GridBagLayout());
	restauranteLabel = new JLabel ("restaurante");
	restauranteButton = new JButton("comprar menu");
	restauranteButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String[] escoge = {"menu", "postre"};
			int respuesta = JOptionPane.showOptionDialog(null, "¿que comida quiere?","comida", 
			        									JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
			        									null, escoge,escoge[0]);
			switch(respuesta) {
			case 0:
			
			EscogerMenu.abrirEscogerMenu( c , null);
			dispose();
			break;
			case 1:
				
			
			}
		}
		
		
	});
	
	
	}
	public static void abrirVistaCliente(Cliente c) {
	VistaCliente vistaCliente = new VistaCliente(c);
	vistaCliente.setSize(480,360);
	vistaCliente.setLocationRelativeTo(null);
	vistaCliente.setVisible(true);
}	
	private void volver() {
		Login.abrirLogin();
		dispose();
	}
	
}
