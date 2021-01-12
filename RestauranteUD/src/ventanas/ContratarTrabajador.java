package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import dataBase.GestorBD;
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
	private Box FeNacBox;

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
		this.setTitle("contratar trabajador");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,300);
		this.setResizable(true);
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		botonPanel = new JPanel ();
		botonPanel.setLayout(new GridBagLayout());
		
		usuarioLabel = new JLabel("usuario:");
		usuarioText = new JTextField(10);
		
		usuarioBox = new Box(BoxLayout.X_AXIS);
		usuarioBox.add(usuarioLabel);
		usuarioBox.add(usuarioText);
		usuarioBox.add(Box.createRigidArea(new Dimension(40,10)));
		
		contrasenaLabel = new JLabel("contraseña:");
		contrasenaField = new JPasswordField(10);
		
		contrasenaBox = new Box(BoxLayout.X_AXIS);
		contrasenaBox.add(contrasenaLabel);
		contrasenaBox.add(contrasenaField);
		contrasenaBox.add(Box.createRigidArea(new Dimension(80,10)));
		
		dniLabel = new JLabel("dni:");
		dniField = new JTextField();
		
		dniBox = new Box(BoxLayout.X_AXIS);
		dniBox.add(dniLabel);
		dniBox.add(dniField);
		dniBox.add(Box.createRigidArea(new Dimension(130,10)));
		
		emailLabel = new JLabel("email:");
		emailField = new JTextField();
		
		emailBox = new Box(BoxLayout.X_AXIS);
		emailBox.add(emailLabel);
		emailBox.add(emailField);
		emailBox.add(Box.createRigidArea(new Dimension(120,10)));
		
		nombreLabel = new JLabel("nombre:");
		nombreField = new JTextField();
		
		nombreBox = new Box(BoxLayout.X_AXIS);
		nombreBox.add(nombreLabel);
		nombreBox.add(nombreField);
		nombreBox.add(Box.createRigidArea(new Dimension(110,10)));
		
		apellidoLabel = new JLabel("apellido:");
		apellidoField = new JTextField();
		
		apellidoBox = new Box(BoxLayout.X_AXIS);
		apellidoBox.add(apellidoLabel);
		apellidoBox.add(apellidoField);
		apellidoBox.add(Box.createRigidArea(new Dimension(100,10)));
		
		FeNacLabel = new JLabel("fecha de nacimiento:");
		FeNacChooser = new JDateChooser(null,null,null, new JSpinnerDateEditor());
		FeNacChooser.setDateFormatString("yyyy-mm-dd");
		
		FeNacBox = new Box(BoxLayout.X_AXIS);
		FeNacBox.add(FeNacLabel);
		FeNacBox.add(FeNacChooser);
		FeNacBox.add(Box.createRigidArea(new Dimension(40,0)));
		
		sueldoLabel = new JLabel("sueldo:");
		sueldoField = new JTextField();
		
		sueldoBox = new Box(BoxLayout.X_AXIS);
		sueldoBox.add(sueldoLabel);
		sueldoBox.add(Box.createRigidArea(new Dimension(115,10)));
		sueldoBox.add(sueldoField);
		
		gerenteLabel = new JLabel("¿es gerente del restaurante?");
		gerenteCheck = new JCheckBox();
		
		gerenteBox= new Box(BoxLayout.X_AXIS);
		gerenteBox.add(gerenteLabel);
		gerenteBox.add(gerenteCheck);
		gerenteBox.add(Box.createRigidArea(new Dimension(115,10)));
		
		panel = new JPanel();
		box= new Box(BoxLayout.Y_AXIS);
		box.add(usuarioBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		box.add(contrasenaBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		box.add(dniBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		box.add(emailBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		box.add(nombreBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		box.add(apellidoBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		box.add(FeNacBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		box.add(sueldoBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		box.add(gerenteBox);
		box.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(box);
		
		aceptarBoton = new JButton("contratar");
		aceptarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contratar();
				
			}
		});
		cancelarBoton = new JButton("cancelar");
		cancelarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				volver(t);
				
			}
		});
		
		botonBox = new Box(BoxLayout.X_AXIS);
		
		botonBox.add(aceptarBoton);
		botonBox.add(cancelarBoton);
		botonBox.add(Box.createRigidArea(new Dimension(50,0)));
		botonPanel.add(botonBox);
		
		getContentPane().add(panel,BorderLayout.CENTER);
		getContentPane().add(botonPanel,BorderLayout.SOUTH);
	}
	
	private void limpiarCajas() {
		usuarioText.setText(null);
		contrasenaField.setText(null);
		dniField.setText(null);
		emailField.setText(null);
		nombreField.setText(null);
		apellidoField.setText(null);
		sueldoField.setText(null);
		gerenteCheck.setEnabled(false);
	}
	
	
	private void contratar() {
		try {
		if(comprobarVacios()) {
			return;
		}
		Date FeNac = FeNacChooser.getDate();
		String usuario = usuarioText.getText();
		String contrasena = new String(contrasenaField.getPassword());
		String dni = dniField.getText();
		String email = emailField.getText();
		String nombre = nombreField.getText();
		String apellido = apellidoField.getText();
		int sueldo = Integer.parseInt(sueldoField.getText());
		boolean isGerente = gerenteBox.isEnabled();
		Trabajador t = new Trabajador(usuario,contrasena,dni, email,nombre, apellido,FeNac,sueldo,isGerente);
		GestorBD bd = new GestorBD();
		bd.anadirNuevoTrabajador(t);
		bd.desconectar();
		String[] opciones = {"si","no"};
		int respuesta = JOptionPane.showOptionDialog( null, "¿quieres contratar otro trabajador?", "contratar", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		switch(respuesta) {
		case 0:
			limpiarCajas();
		break;
		case 1:
			VistaGerente.abrirVistaGerente(t);
			dispose();
			default:
			break;
		}	
		
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,"introduzca el sueldo del trabajador");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private boolean comprobarVacios() {
		if(usuarioText.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"introduzca el usuario");
			return true;
		}
		if (new String(contrasenaField.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, " introduzca la contraseña");
			return true;
		}
		if(emailField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"introduzca el e-mail");
			return true;
		}
		if(dniField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"introduzca el dni");
			return true;
		}
		if(nombreField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"introduzca el nombre");
			return true;
		}
		if(apellidoField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"introduzca el apellido");
			return true;
		}
		if(sueldoField.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"introduzca el salario");
			return true;
		}
		
		return false;
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
