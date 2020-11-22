package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {

	protected String usuario;
	protected String contra;
	protected String email;
	protected String dNI;
	protected String nombre;
	protected String apellidos;
	protected Date fechaNacimiento;
	protected String direccion;
	public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Persona(String usuario, String contra, String email, String dNI, String nombre, String apellidos, 
			Date fechaNacimiento, String direccion) {

		super();
		this.usuario = usuario;
		this.contra = contra;
		this.email = email;
		this.dNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona() {
		super();
		this.usuario = "";
		this.usuario = "";
		this.email = "";
		this.dNI = "";
		this.nombre = "";
		this.apellidos = "";
		this.fechaNacimiento = null;
	}

	public Persona(Persona p) {
		super();
		this.usuario = p.usuario;
		this.contra = p.contra;
		this.email = p.email;
		this.dNI = p.dNI;
		this.nombre = p.nombre;
		this.apellidos = p.apellidos;
		this.fechaNacimiento = null;
		this.direccion =p.direccion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getdNI() {
		return dNI;
	}

	public void setdNI(String dNI) {
		this.dNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getFechaNacimientoString() {
		return df.format(fechaNacimiento);
	}

	public void setFechaNacimientoString (String fechaNacimiento) throws ParseException {
		this.fechaNacimiento = df.parse(fechaNacimiento);
	}
}