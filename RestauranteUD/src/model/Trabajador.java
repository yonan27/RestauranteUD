package model;

import java.util.Date;

public class Trabajador extends Persona{

	private int sueldo;
	private boolean isGerente;
	
	
	public Trabajador(String usuario, String contra, String email, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, int sueldo, boolean isGerente) {
		super(usuario, contra, email, nombre, apellidos, fechaNacimiento, direccion);
		this.sueldo = sueldo;
		this.isGerente = isGerente;
	}
	public Trabajador() {
		super();
		this.sueldo = 0;
		this.isGerente = false;
	}
	public Trabajador(Trabajador t) {
		super("","","","","",null,"");
		this.sueldo = t.sueldo;
		this.isGerente = t.isGerente;
	}
	
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public boolean isGerente() {
		return isGerente;
	}
	public void setGerente(boolean isGerente) {
		this.isGerente = isGerente;
	}
	
	@Override
	public String toString() {
		String gerente;
		if (this.isGerente) {
			gerente = "es";
		} else {
			gerente = "no es ";
		}
		return nombre + " " + apellidos + " con email " + email + " gerente tiene un sueldo " + gerente + " " ;  
	}
	

	
}