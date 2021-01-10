package ventanas;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import model.Trabajador;

public class ContratarTrabajador extends JFrame {

	private JPanel panel;
	private Box box;
	private JPanel botonPanel;
	
	private JLabel usuarioLabel;
	private JTextField usuarioText;
	private Box usuarioBox;
	
	private JLabel contrasenaLabel;
	private JPasswordField contrasenaField;
	private Box contrasenaBox;
	
	private JLabel dniLabel;
	private JTextField dniField;
	private Box dniBox;
	
	private JLabel emailLabel;
	private JTextField emailField;
	private Box emailBox;
	
	private JLabel nombreLabel;
	private JTextField nombreField;
	private Box nombreBox;
	
	private JLabel apellidoLabel;
	private JTextField apellidoField;
	private Box apellidoBox;
	
	private JLabel FeNacLabel;
	private JDateChooser FeNacChooser;
	private Box FenacBox;

	private JLabel sueldoLabel;
	private JTextField sueldoField;
	private Box sueldoBox;
	
	private JLabel gerenteLabel;
	private JCheckBox gerenteCheck ;
	private Box gerenteBox ;
	
	private JButton aceptarBoton;
	private JButton cancelarBoton;
	private Box botonBox;
	
	public ContratarTrabajador(Trabajador t){
		//TODO
	
	}
	
	private void limpiarCajas() {
		//TODO
	}
	
	
	private void contratar() {
		try {
			
		} catch (Exception e) {
			// TODO
		}
	}
	private void comprobarVacios() {
		//TODO
	}
	public static void abrirContratarTrabajador(Trabajador t) {
		ContratarTrabajador contratarTrabajador = new ContratarTrabajador(t);
		contratarTrabajador.setVisible(true);
		contratarTrabajador.setSize(500,300);
		contratarTrabajador.setLocationRelativeTo(null);
		
		
	}
	public void volver(Trabajador t ) {
		if(t.isGerente()) {
			VistaGerente.abrirVistaGerente(t);
		}else {
			VistaTrabajador.abrirVistaTrabajador(t);
			dispose();
		}
	}
}
