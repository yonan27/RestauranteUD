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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

public class RegistrarCliente extends JFrame {

	/**
	 * 
	 */
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

	public RegistrarCliente() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bienvenidaPanel = new JPanel();

		//TODO poner frase de bienvenida
		String bienvenida = "<html><body><center></center></body></html>";

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
				//TODO registrar usuario
			}
		});

		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO volver
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

	private void volver() {

	}

	private void limpiarCajas() {
		//TODO limpiar cajas
		usuarioField.setText(null);
		passwordField.setText(null);
		passwordRField.setText(null);
		emailField.setText(null);
		dniField.setText(null);
		nombreField.setText(null);
		apellidosField.setText(null);
		numeroTarjetaField.setText(null);
	}

	private void registrar() {
		//TODO registrar nuevo usuario
	}

	private boolean comprobarVacios() {
		return rootPaneCheckingEnabled;
		//TODO comprobar que no haya nada vac�o
	}

	private boolean comprobarContrase�as() {
		return rootPaneCheckingEnabled;
		//TODO comprobar que las contrase�as coincidan
	}

	public static void abrirRegistrarCliente() {
		RegistrarCliente registrarCliente = new RegistrarCliente();
		registrarCliente.setTitle("Reg�strate");
		registrarCliente.setVisible(true);
		registrarCliente.setSize(480,420);
		registrarCliente.setLocationRelativeTo(null);
	}
}