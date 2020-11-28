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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import dataBase.GestorBD;
import model.Cliente;
import model.Trabajador;

public class RegistrarCliente extends JFrame {

	
	private static final long serialVersionUID = 1L;

	private JPanel bienvenidaPanel;
	private JLabel bienvenidaLabel;
	private JPanel formPanel;
	private Box formBox;
	private JPanel buttonsPanel;
	private JLabel usuarioLabel;
	private JTextField usuarioField;
	private Box usuarioBox;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private Box passwordBox;
	private JLabel passwordRLabel;
	private JPasswordField passwordRField;
	private Box passwordRBox;
	private JLabel emailLabel;
	private JTextField emailField;
	private Box emailBox;
	private JLabel dniLabel;
	private JTextField dniField;
	private Box dniBox;
	private JLabel nombreLabel;
	private JTextField nombreField;
	private Box nombreBox;
	private JLabel apellidosLabel;
	private JTextField apellidosField;
	private Box apellidosBox;
	private JLabel fechaNacimientoLabel;
	private JDateChooser fechaNacimientoCalendario;
	private Box fechaNacimientoBox;
	private JLabel numeroTarjetaLabel;
	private JTextField numeroTarjetaField;
	private Box numeroTarjetaBox;
	private JButton acceptButton;
	private JButton cancelButton;
	private Box buttonsBox;

	public RegistrarCliente(Trabajador t) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bienvenidaPanel = new JPanel();

		String bienvenida = "<html><body><center> Bienvenido a RestauranteUD </center></body></html>";

		bienvenidaLabel = new JLabel(bienvenida);
		bienvenidaPanel.add(bienvenidaLabel);

		getContentPane().add(bienvenidaPanel, BorderLayout.NORTH);

		formPanel = new JPanel();
		formPanel.setLayout(new GridBagLayout());

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());

		usuarioLabel = new JLabel("Nombre de usuario:");
		usuarioField = new JTextField(12);

		usuarioBox = new Box(BoxLayout.X_AXIS);
		usuarioBox.add(usuarioLabel);
		usuarioBox.add(Box.createRigidArea(new Dimension(29, 12)));
		usuarioBox.add(usuarioField);

		passwordLabel = new JLabel("Contrase�a:");
		passwordField = new JPasswordField(12);

		passwordBox = new Box(BoxLayout.X_AXIS);
		passwordBox.add(passwordLabel);
		passwordBox.add(Box.createRigidArea(new Dimension(71, 12)));
		passwordBox.add(passwordField);

		passwordRLabel = new JLabel("Repita la contrase�a:");
		passwordRField = new JPasswordField(12);

		passwordRBox = new Box(BoxLayout.X_AXIS);
		passwordRBox.add(passwordRLabel);
		passwordRBox.add(Box.createRigidArea(new Dimension(19,0)));
		passwordRBox.add(passwordRField);

		emailLabel = new JLabel("Email:");
		emailField = new JTextField();

		emailBox = new Box(BoxLayout.X_AXIS);
		emailBox.add(emailLabel);
		emailBox.add(Box.createRigidArea(new Dimension(100, 12)));
		emailBox.add(emailField);

		dniLabel = new JLabel("DNI:");
		dniField = new JTextField(9);

		dniBox = new Box(BoxLayout.X_AXIS);
		dniBox.add(dniLabel);
		dniBox.add(Box.createRigidArea(new Dimension(111, 12)));
		dniBox.add(dniField);

		nombreLabel = new JLabel("Nombre:");
		nombreField = new JTextField();

		nombreBox = new Box(BoxLayout.X_AXIS);
		nombreBox.add(nombreLabel);
		nombreBox.add(Box.createRigidArea(new Dimension(87, 12)));
		nombreBox.add(nombreField);

		apellidosLabel = new JLabel("Apellidos:");
		apellidosField = new JTextField();

		apellidosBox = new Box(BoxLayout.X_AXIS);
		apellidosBox.add(apellidosLabel);
		apellidosBox.add(Box.createRigidArea(new Dimension(95, 12)));
		apellidosBox.add(apellidosField);

		fechaNacimientoLabel= new JLabel("Fecha de nacimiento:");

		fechaNacimientoCalendario = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		fechaNacimientoCalendario.setDateFormatString("dd/MM/yyyy");

		fechaNacimientoBox = new Box(BoxLayout.X_AXIS);
		fechaNacimientoBox.add(fechaNacimientoLabel);
		fechaNacimientoBox.add(Box.createRigidArea(new Dimension(39,0)));
		fechaNacimientoBox.add(fechaNacimientoCalendario);

		numeroTarjetaLabel = new JLabel("N�mero de tarjeta:");
		numeroTarjetaField = new JTextField();

		numeroTarjetaBox = new Box(BoxLayout.X_AXIS);
		numeroTarjetaBox.add(numeroTarjetaLabel);
		numeroTarjetaBox.add(Box.createRigidArea(new Dimension(51, 12)));
		numeroTarjetaBox.add(numeroTarjetaField);

		formPanel = new JPanel();

		formBox = new Box(BoxLayout.Y_AXIS);
		formBox.add(usuarioBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(passwordBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(passwordRBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(emailBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(dniBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(nombreBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(apellidosBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(fechaNacimientoBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));
		formBox.add(numeroTarjetaBox);
		formBox.add(Box.createRigidArea(new Dimension(0,10)));

		formPanel.add(formBox);

		acceptButton = new JButton("Registrarme");
		acceptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				registrar(t);
			}
		});

		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				volver(t);
			}
		});

		buttonsBox = new Box(BoxLayout.X_AXIS);
		buttonsBox.add(acceptButton);
		buttonsBox.add(Box.createRigidArea(new Dimension(40, 0)));
		buttonsBox.add(cancelButton);

		buttonsPanel.add(buttonsBox);

		getContentPane().add(formPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	}

	private void volver(Trabajador t) {
		if(t== null) {
			Inicio.abrirInicio();
			dispose();
		}else{
			if(t.isGerente()) {
				VistaGerente.abrirVistaGerente(t);
				dispose();
			}else {
				VistaTrabajador.abrirVistaTrabajador(t);
				dispose();
			}
		}

	}

	private void limpiarCajas(Trabajador t) {
		usuarioField.setText(null);
		passwordField.setText(null);
		passwordRField.setText(null);
		emailField.setText(null);
		dniField.setText(null);
		nombreField.setText(null);
		apellidosField.setText(null);
		numeroTarjetaField.setText(null);
	}

	private void registrar(Trabajador t ) {
		try {

			if (comprobarVacios()) {
				return;
			}

			if (comprobarContrasenas()) {
				return;
			}

			Date fechaNacimiento = fechaNacimientoCalendario.getDate();
			String usuario = usuarioField.getText();
			String contra = new String(passwordField.getPassword());;
			String email = emailField.getText();
			String dNI = dniField.getText();
			String nombre = nombreField.getText();
			String apellidos = apellidosField.getText();
			long numTarjeta = Long.parseLong(numeroTarjetaField.getText());

			Cliente c = new Cliente(usuario, contra, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta);

			GestorBD bd = new GestorBD();
			bd.anadirNuevoCliente(c);
			bd.desconectar();

			String[] opciones = {"Si", "No"};
			int respuesta = JOptionPane.showOptionDialog( null, "¿Desea registrar un nuevo cliente?", "Registrar otro", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);	

			switch (respuesta) {
			case 0:
				limpiarCajas(t);
				break;
			case 1:
				volver(t);
				dispose();
				break;
			default:
				break;
			}
		} 
		catch (NumberFormatException en) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un n�mero de tarjeta");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean comprobarVacios() {
		if (usuarioField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un nombre de usuario");
			return true;
		}

		if (new String(passwordField.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca una contrasena");
			return true;
		}

		if (new String(passwordRField.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, repita su contrasena");
			return true;
		}

		if (new String(emailField.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca un email de contacto");
			return true;
		}

		if (new String(dniField.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su DNI");
			return true;
		}

		if (new String(nombreField.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca su nombre");
			return true;
		}

		if (new String(apellidosField.getText()).equals("")) {
			JOptionPane.showMessageDialog(this, "Por favor, introduzca al menos un apellido");
			return true;
		}

		return false;
	}
	

	private boolean comprobarContrasenas() {
		String contra1 = new String(passwordField.getPassword());
		String contra2 = new String(passwordRField.getPassword());
		if (contra1.equals(contra2)) {
			return false;
		} else {
			JOptionPane.showMessageDialog(this, "Las contrasenas tienen que coincidir");
			return true;
		}
	}

	public static void abrirRegistrarCliente(Trabajador t) {
		RegistrarCliente registrarCliente = new RegistrarCliente(t);
		registrarCliente.setTitle("Registrate");
		registrarCliente.setVisible(true);
		registrarCliente.setSize(480,420);
		registrarCliente.setLocationRelativeTo(null);
	}

	
}