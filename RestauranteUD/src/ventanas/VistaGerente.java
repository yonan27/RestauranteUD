package ventanas;

import javax.swing.JFrame;

import model.Trabajador;

public class VistaGerente extends JFrame {

	/**
	 * 
	 */

	public VistaGerente (Trabajador t) {
		//TODO ventana entera


	}

	public static void abrirVistaGerente(Trabajador t) {
		VistaGerente vistaGerente = new VistaGerente(t);
		vistaGerente.setTitle("Vista cliente");
		vistaGerente.setSize(480,360);
		vistaGerente.setLocationRelativeTo(null);
		vistaGerente.setVisible(true);
	}
}