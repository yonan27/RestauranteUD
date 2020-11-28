package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Trabajador;

public class GestorBD {

	private static Exception lastError = null; // Ultimo error que ha sucedido

	private Connection conn;
	private static Logger logger = null;

	public GestorBD() {
		conectar();
	}

	private void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:ficheros/baseDeDatos.db");
			log(Level.INFO, "Conectado a la base de datos", null);
		} catch (ClassNotFoundException | SQLException e) {
			setLastError(e);
			log(Level.SEVERE, "Error en conexion de base de datos ", e);
			e.printStackTrace();
		}
	}

	public void desconectar() {
		try {
			conn.close();
			log(Level.INFO, "Desconectado de la base de datos", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al desconectar la base de datos", e);
			e.printStackTrace();
		
		}
	}

	private void eliminar(String tabla) {
		String sqlEliminar = "DELETE FROM " +  tabla;
		Statement stmtEliminar;
		try {
			stmtEliminar = conn.createStatement();
			stmtEliminar.executeUpdate(sqlEliminar);
			log(Level.INFO, "eliminar tabla" + tabla+ "de la bd", null);
			
		} catch (SQLException e) {
			log(Level.SEVERE, "error al eliminar la tabla"+ tabla+ "de la bd", e);
	}
	
	}
	public void importarFicheroBD(String tabla) {
		eliminar(tabla);
		switch(tabla) {
		case "trabajador":
			importarTrabajador();
			break;
		case "cliente":
			importarCliente();
		case "menu":
			importarMenu();
			break;
		default:
			JOptionPane.showMessageDialog(null, "importar este fichero");
			break;
		}
	}

	public void exportarFicheroBD(String tabla) {
		
		switch(tabla) {
		case "trabajador":
			exportarTrabajador();
			break;
		case "cliente":
			exportarCliente();
			break;
		case "menu":
			exportarMenu();
			break;
		default:
			JOptionPane.showMessageDialog(null, "exportar este fichero");
			break;
		}
	}
	
	

	private void importarTrabajador() {
		// TODO 
		
	}
	
	private void importarCliente() {
		// TODO 
		
	}
	private void importarMenu() {
		// TODO 
		
	}
	private void exportarCliente() {
		// TODO 
		
	}

	private void exportarTrabajador() {
		// TODO 
		
	}

	private void exportarMenu() {
		// TODO 
		
	}
	public Cliente iniciarSesionCliente(String usuario, String contra) {
		List<Cliente> clientes = obtenerClientes();

		Iterator<Cliente> itClientes = clientes.iterator();

		while (itClientes.hasNext()) {
			Cliente c = itClientes.next();

			String login = c.getUsuario();
			String password = c.getContra();

			if (login.equals(usuario)) {
				if (password.equals(contra)) {
					return c;
				}
			}
		}
		return null;
	}

	public List<Cliente> obtenerClientes() {

		String sql = "SELECT usuario, contra, email, nombre , apellidos , fechaNacimiento,numTarjeta,suscrpcion ,FROM cliente";
		PreparedStatement stmt;
		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setUsuario(rs.getString("usuario"));
				c.setContra(rs.getString("contrasena"));
				c.setEmail(rs.getString("email"));
				c.setNombre(rs.getString("nombre"));
				c.setApellidos(rs.getString("apellidos"));
				try {
					c.setFechaNacimientoString("fechaNacimiento");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.setNumTarjeta(rs.getLong("numTarjeta"));

				clientes.add(c);
			}
			log(Level.INFO, "obtener trbajadores", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "error al obtener trabajadores", e);
			e.printStackTrace();
		}

		return clientes;

	}

	public void anadirNuevoCliente(Cliente c) {
		String sql = "INSERT INTO cliente (login, password, email, dNI, nombre, apellidos, fechaNacimiento, numTarjeta)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, c.getUsuario());
			stmt.setString(2, c.getContra());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getdNI());
			stmt.setString(5, c.getNombre());
			stmt.setString(6, c.getApellidos());
			stmt.setString(7, c.getFechaNacimientoString());
			stmt.setLong(8, c.getNumTarjeta());

			stmt.executeUpdate();

			log(Level.INFO, "El cliente " + c.getNombre() + " ha sido anadido", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al insertar el cliente" + sql, e);
			setLastError(e);
			e.printStackTrace();
		}
	}

	public void anadirNuevoTrabajador(Trabajador t) {
		String sql = "INSERT INTO trabajador (usuario, contrasena, email, nombre, apellidos, fechaNacimiento, sueldo, gerente)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, t.getUsuario());
			stmt.setString(2, t.getContra());
			stmt.setString(3, t.getEmail());
			stmt.setString(4, t.getNombre());
			stmt.setString(5, t.getApellidos());
			stmt.setInt(8, t.getSueldo());
			if (t.isGerente()) {
				stmt.setInt(9, 1);
			} else {
				stmt.setInt(9, 0);
			}
			stmt.executeUpdate();
			log(Level.INFO, "el trabajador" + t.getNombre() + "ha sido anadido", null);

		} catch (SQLException e) {
			log(Level.SEVERE, "error al insertar el trabajador" + sql, e);
			setLastError(e);
			e.printStackTrace();
		}
	}

	public Trabajador iniciarSesionTrabajador(String usuario, String contra) {
		List<Trabajador> trabajadores = obtenerTrabajadores();

		Iterator<Trabajador> itTrabajadores = trabajadores.iterator();

		while (itTrabajadores.hasNext()) {
			Trabajador t = itTrabajadores.next();

			String login = t.getUsuario();
			String password = t.getContra();

			if (login.equals(usuario)) {
				if (password.equals(contra)) {
					return t;
				}
			}
		}
		return null;
	}

	public List<Trabajador> obtenerTrabajadores() {

		String sql = "SELECT usuario, contra, email, nombre , apellidos , fechaNacimiento,sueldo, isGerente FROM trabajador";
		PreparedStatement stmt;
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();

		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Trabajador t = new Trabajador();
				t.setUsuario(rs.getString("usuario"));
				t.setContra(rs.getString("contrasena"));
				t.setEmail(rs.getString("email"));
				t.setNombre(rs.getString("nombre"));
				t.setApellidos(rs.getString("apellidos"));
				try {
					t.setFechaNacimientoString("fechaNacimiento");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				t.setSueldo(rs.getInt("sueldp"));
				if (rs.getInt("isGerente") == 0) {
					t.setGerente(false);
				} else {
					t.setGerente(true);
				}
				trabajadores.add(t);
			}
			log(Level.INFO, "obtener trbajadores", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "error al obtener trabajadores", e);
			e.printStackTrace();
		}

		return trabajadores;

	}

	// Metodo publico para asignar un logger externo
	public static void setLogger(Logger logger) {
		GestorBD.logger = logger;
	}

	// Metodo local para loggear (si no se asigna un logger externo, se asigna uno
	// local)
	private static void log(Level level, String msg, Throwable excepcion) {
		if (logger == null) { // Logger por defecto local:
			logger = Logger.getLogger(GestorBD.class.getName()); // Nombre del logger - el de la clase
			logger.setLevel(Level.ALL); // Loguea todos los niveles
			try {
				// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() +
				// ".log.xml" ) ); // Y saca el log a fichero xml
				logger.addHandler(new FileHandler("logger.xml", true)); // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log(Level.SEVERE, "No se pudo crear fichero de log", e);
			}
		}
		if (excepcion == null) {
			logger.log(level, msg);
		} else {
			logger.log(level, msg, excepcion);
		}
	}

	public static Exception getLastError() {
		return lastError;
	}

	public static void setLastError(Exception lastError) {
		GestorBD.lastError = lastError;
	}
}