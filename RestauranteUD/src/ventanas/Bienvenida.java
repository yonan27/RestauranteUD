package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Bienvenida extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private Fondo fondo;
	private JLabel bienvenida;
	private JButton accederButton;

	public Bienvenida() {
		this.setTitle("Bienvenida");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

		try { 
			//TODO poner foto de fondo
			fondo = new Fondo(ImageIO.read(new File("img/fondo.jpg")));
			panel = (JPanel) this.getContentPane();

			bienvenida = new JLabel("Bienvenido al restaurante");
			bienvenida.setBounds(0, 88, 464, 37);
			bienvenida.setFont(new Font("Tahoma", Font.BOLD, 30));
			bienvenida.setVerticalAlignment(SwingConstants.TOP);
			bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
			bienvenida.setForeground(new Color(128, 0, 0));

			accederButton = new JButton("Acceder");
			accederButton.setBounds(0, 298, 464, 23);
			accederButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Inicio.abrirInicio();
					dispose();
				}
			});
			getContentPane().setLayout(null);

			getContentPane().add(bienvenida);
			getContentPane().add(accederButton);

			panel.setBorder(fondo);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}		
		this.setVisible(true);
	}

	public static void abrirBienvenida() {
		Bienvenida bienvenida = new Bienvenida();
		bienvenida.setSize(480,360);
		bienvenida.setLocationRelativeTo(null);
		bienvenida.setVisible(true);
	}
}
