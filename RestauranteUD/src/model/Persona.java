package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Persona {

	protected String usuario;
	protected String contra;
	protected String email;
	protected String nombre;
	protected String apellidos;
	protected Date fechaNacimiento;
	private String direccion;
	public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
<<<<<<< Updated upstream
=======
	
>>>>>>> Stashed changes
	public Persona(String usuario, String contra, String email, String nombre, String apellidos, Date fechaNacimiento,
			String direccion) {
		super();
		this.usuario = usuario;
		this.contra = contra;
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
	}
<<<<<<< Updated upstream
	
=======
>>>>>>> Stashed changes
	public Persona() {
		super();
		this.usuario = "";
		this.contra = "";
		this.email = "";
		this.nombre = "";
		this.apellidos = "";
		this.fechaNacimiento = null;
		this.direccion = "";
	}
<<<<<<< Updated upstream

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

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static SimpleDateFormat getDf() {
		return df;
	}

	public static void setDf(SimpleDateFormat df) {
		Persona.df = df;
	}

	@Override
	public String toString() {
		return "Persona [usuario=" + usuario + ", contra=" + contra + ", email=" + email + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion
				+ "]";
	}
	
	
	
	
=======
	public Persona(Persona p) {
		super();
		this.usuario = p.usuario;
		this.contra = p.contra;
		this.email = p.email;
		this.nombre = p.nombre;
		this.apellidos = p.apellidos;
		this.fechaNacimiento = p.fechaNacimiento;
		this.direccion = p.direccion;
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
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setFechaNacimientoString(String fechaNacimiento) throws ParseException{
		this.fechaNacimiento = df.parse(fechaNacimiento);
	}
	public String getFechaNaciminetoString() {
		return df.format(fechaNacimiento);
	}
>>>>>>> Stashed changes

}