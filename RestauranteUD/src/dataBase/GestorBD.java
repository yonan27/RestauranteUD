package dataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Menu;
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
		String sqlEliminar = "DROP TABLE " +  tabla;
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
		List<Trabajador> trabajadores = new ArrayList<>();
		File f = null;
		Scanner sc = null;
		try {
			f = new File("fichero/trabajadores.csv");
			sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				Trabajador t = new Trabajador();
				String[] campos = linea.split(";");
				t.setUsuario(campos[0]);
				t.setContra(campos[1]);
				t.setEmail(campos[2]);
				t.setdNI(campos[3]);
				t.setNombre(campos[4]);
				t.setApellidos(campos[5]);
				t.setFechaNacimientoString((campos[6]));
				t.setSueldo(Integer.parseInt(campos[7]));
				t.setGerente(Boolean.parseBoolean(campos[8]));
				trabajadores.add(t);
			}
			sc.close();
			log(Level.INFO, " cargando trabajadores", null);
		}catch (Exception e) {
			log(Level.SEVERE,"error al cargar ",null);
		}
		Iterator<Trabajador> iterator = trabajadores.iterator();
		while (iterator.hasNext()) {
			Trabajador t =  iterator.next();
			anadirNuevoTrabajador(t);
			
		}
		log(Level.INFO, "anadidos", null);
	}
	
	private void importarCliente() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		File f = null;
		Scanner sc = null;
		try {
			f = new File("fichero/clientes.csv");
			sc = new Scanner (f);
			while (sc.hasNext()) {
				String linea = (String) sc.next();
				Cliente c = new Cliente();
				String[] campos =  linea.split(";");
				c.setUsuario(campos[0]);
				c.setContra(campos[1]);
				c.setEmail(campos[2]);
				c.setdNI(campos[3]);
				c.setNombre(campos[4]);
				c.setApellidos(campos[5]);
				c.setFechaNacimientoString(campos[6]);
				c.setNumTarjeta(Long.parseLong(campos[7]));
				clientes.add(c);
				
			}
			sc.close();
			log(Level.INFO, "cargando clientes", null);
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "error al cargar", null);
		}
		Iterator<Cliente> iterator = clientes.iterator();
		while(iterator.hasNext()) {
			Cliente c = iterator.next();
			anadirNuevoCliente(c);
		}
		log(Level.INFO, "anadidos", null);
	}
	private void importarMenu() {
		List<Menu> menus = new ArrayList<Menu>();
		File f= null;
		Scanner sc = null;
		try {
			f = new File("ficheros/menu.csv");
			sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				
			Menu m = new Menu();
			String[] campos = linea.split(";") ;
			m.setSemanal(Boolean.parseBoolean(campos[0]));
			m.setFinDeSemana(Boolean.parseBoolean(campos[1]));
			m.setConsumidor(null);
			menus.add(m);
		}	
		log(Level.INFO, "menus cargados desde el fichero", null);		
			
		} catch (Exception e) {
			e.printStackTrace();
			log(Level.SEVERE, "error al cargar", null);
		}finally {
			sc.close();
		}
		Iterator<Menu> me = menus.iterator();
		while (me.hasNext()) {
			Menu m =  me.next();
			anadirNuevoMenu(m);
		}
		log(Level.INFO,"menus añadidos a la BD", null);
	}
	private void anadirNuevoMenu(Menu m) {
		String sql = "INSERT INTO MENU (SEMANAL, FINDESEMANA, CONSUMIDOR)"+ "VALUES(?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, m.isSemanal());
			stmt.setBoolean(2, m.isFinDeSemana());
			
			if (m.isFinDeSemana()) {
				stmt.setBoolean(1, m.isSemanal());
			}else {
				stmt.setBoolean(2, m.isFinDeSemana());
			}
			stmt.executeUpdate();
			log(Level.INFO, "el menu" + m.toString()+ "ha sido anadido", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "erro al insertar el menu", null);
			setLastError(e);
			e.printStackTrace();
		}
	}

	private void exportarCliente() {
		FileWriter f = null;
		List<Cliente> clientes = obtenerClientes();
		try {
			f = new FileWriter("fichero/clientesEx.csv");
			for (Cliente c : clientes) {
				String usuario = c.getUsuario();
				String contra = c.getContra();
				String email = c.getEmail();
				String dni = c.getdNI();
				String nombre = c.getNombre();
				String apellidos = c.getApellidos();
				String fechaNaciminetoS = c.getFechaNacimientoString();
				long numTar = c.getNumTarjeta();
				
				f.write(usuario + ";" + contra + ";" + email + ";" + 
						dni + ";" + nombre + ";" + apellidos + ";" + 
						fechaNaciminetoS + ";" + numTar + ";");
				log(Level.INFO, "cliente" + c.toString() +"ha sido exportado", null);
			}
			log(Level.INFO,"exportados", null);
		} catch (IOException e) {
			log(Level.SEVERE, " error al exportar ", e);
			e.printStackTrace();
		}
		
	}

	private void exportarTrabajador() {
		FileWriter f = null;
		List<Trabajador> trabajadores = obtenerTrabajadores();
		try {
			f = new FileWriter("fichero/trabajadoresEx.csv");
			for (Trabajador t : trabajadores) {
				String usuario = t.getUsuario();
				String contra = t.getContra();
				String email = t.getEmail();
				String dni = t.getdNI();
				String nombre = t.getNombre();
				String apellidos = t.getApellidos();
				String fechaNaciminetoS = t.getFechaNacimientoString();
				int sueldo = t.getSueldo();
				boolean gerente = t.isGerente();
				f.write(usuario + ";" + contra + ";" + email + ";" + 
						dni + ";" + nombre + ";" + apellidos + ";" + 
						fechaNaciminetoS + ";" + sueldo + ";"+ gerente+ ";");
				log(Level.INFO, "trabajador" + t.toString() +"ha sido exportado", null);
			}
			log(Level.INFO,"exportados", null);
		} catch (IOException e) {
			log(Level.SEVERE, " error al exportar ", e);
			e.printStackTrace();
		}finally {
			try {
				if (f !=null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "error al cerrar el documento de exportar ", e);
			}
		}
		
	}

	private void exportarMenu() {
		FileWriter f = null;
		List<Menu> menus = obtenerMenus();
		try {
			f = new FileWriter("ficheros/menusExp.csv");

			for (Menu m : menus) {
				boolean semanal = m.isSemanal();
				boolean findesemana = m.isFinDeSemana();

				f.write(semanal + ";" + findesemana + ";" + "\n");

				log(Level.INFO, "El menu " + m.toString() + " se ha exportado ", null);
			}

			log(Level.INFO, "menus exportados ", null);
		} catch (IOException e) {
			log(Level.SEVERE, "Error al abrir el fichero para exportar menus", e);
			e.printStackTrace();
		} finally {
			try {
				if(f != null) {
					f.close();
				}
			} catch (IOException e) {
				log(Level.SEVERE, "Error al cerrar el fichero de exportar menus", e);
				e.printStackTrace();
			}
		}
	}
		
	private List<Menu> obtenerMenus() {
		String sql = "SELECT SEMANAL, FINDESEMANA, CONSUMIDOR FROM MENU";
		PreparedStatement stmt;

		List<Menu> menus = new ArrayList<Menu>();

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()){

				Menu m = new Menu();
				m.setSemanal(rs.getBoolean("Semanal"));
				m.setFinDeSemana(rs.getBoolean("FinDeSemana"));
				m.setConsumidor(null);
				
				if (rs.getBoolean("Semanal") == false) {
					m.setSemanal(false);
				} else {
					m.setSemanal(true);
				}

				menus.add(m);
			}

			log(Level.INFO, "Obteniendo los menus", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener los menus", e);
			e.printStackTrace();
		}
		return menus;
	}

	public ResultSet rellenarTablaVentaMenu() {
		String sql = "SELECT SEMANAL, FINDESEMANA FROM VENTAMENU";
		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log(Level.INFO, "Obteniendo las ventas del menu", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "Error al obtener las ventas del menu", e);
			e.printStackTrace();
		}
		return null;
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
	//TODO
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
	//TODO
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
	//TODO
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
	
	//TODO
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

	public ResultSet TablaTrabajadores() {
		
		return null;
	}
	public void eliminarPersona(String tabla, String dni) {
		String sqlBorrar= "DELETE FROM" + tabla +"WHERE DNI";
		PreparedStatement stmtBorrar;
		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);
			stmtBorrar.setString(1,dni);
			stmtBorrar.executeUpdate();
			log(Level.INFO, "el" + tabla + "con dni" + dni + "ha sido borrado", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "no ha sido borrado" + tabla+ "con dni" + dni , e);
			e.printStackTrace();
		}
		
	}
	public ResultSet rellenarTablaClientes() {
		String sql = "SELECT NOMBRE, APELLIDO, EMAIL,DNI, USUARIO , CONTRASEÑA FROM CLIENTE";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			log(Level.INFO,"obteniendo clientes",null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE,"error",null);
			e.printStackTrace();
		}
		return null;
	}
	public void exportarBDFichero(String tabla) {
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
				JOptionPane.showMessageDialog(null, "contacte con el servicio para importar este fichero");
				break;
		}
		
	}
	public ResultSet rellenarTablaTrabajador() {
		String sql ="SELECT NOMBRE, APELLIDO, EMAIL,DNI, USUARIO , FENAC, SALARIO, ISGERENTE FROM TRABAJADOR";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			log(Level.INFO, "obteniendo trabajadores", null);
			return rs;
		} catch (SQLException e) {
			log(Level.SEVERE, "error", e);
			e.printStackTrace();
		}
		return null;
	}
	
	public void eliminarVenta(String nombreC, String nombreM,boolean semanal, boolean finDeSemana) {
		
		String sqlBorrar = "DELETE FROM " + nombreC + "WHERE DNI = xxxxxxx ";
		PreparedStatement stmtBorrar;
		try {
			stmtBorrar = conn.prepareStatement(sqlBorrar);
			stmtBorrar.setString(1, nombreC);
			stmtBorrar.setBoolean(2,semanal);
			stmtBorrar.setBoolean(3,finDeSemana);
			stmtBorrar.executeUpdate();
			log(Level.INFO, "la venta del menu"+semanal+"hecha por el cliente"+nombreC+"ha sido eliminada", null);
		} catch (Exception e) {
			log(Level.SEVERE, "no se ha podido eliminar la venta del menu"+semanal+"hecha por el cliente"+ nombreC, e);
			e.printStackTrace();
		}
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