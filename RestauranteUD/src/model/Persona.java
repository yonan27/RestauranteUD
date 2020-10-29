package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {

	protected String usuario;
	protected String contra;
	protected String email;
	protected String nombre;
	protected String apellidos;
	protected Date fechaNacimiento;
	private String direccion;
	public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

}