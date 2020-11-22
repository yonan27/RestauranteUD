package ventanas;

import javax.swing.JFrame;

import model.Cliente;

public class VistaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VistaCliente (Cliente c) {
		//TODO ventana entera

		
	}

	public static void abrirVistaCliente(Cliente c) {
		VistaCliente vistaCliente = new VistaCliente(c);
		vistaCliente.setTitle("Vista cliente");
		vistaCliente.setSize(480,360);
		vistaCliente.setLocationRelativeTo(null);
		vistaCliente.setVisible(true);
	}
}