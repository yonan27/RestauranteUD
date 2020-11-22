package ventanas;

import javax.swing.JFrame;

import model.Trabajador;

public class VistaTrabajador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VistaTrabajador (Trabajador t) {
		//TODO ventana entera

	}

	public static void abrirVistaTrabajador(Trabajador t) {
		VistaTrabajador vistaTrabajador = new VistaTrabajador(t);
		vistaTrabajador.setTitle("Vista trabajador");
		vistaTrabajador.setSize(480,360);
		vistaTrabajador.setLocationRelativeTo(null);
		vistaTrabajador.setVisible(true);
	}
}