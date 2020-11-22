package model;

import java.util.Date;

public class Trabajador extends Persona{

	private int sueldo;
	private boolean isGerente;
	
	public Trabajador(String usuario, String contra, String email, String dNI, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, int sueldo, boolean isGerente) {
		super(usuario, contra, email, dNI, nombre, apellidos, fechaNacimiento, direccion);
		this.sueldo = sueldo;
		this.isGerente = isGerente;
	}

	public Trabajador(Trabajador t) {
		super(t.usuario,t.contra,t.email,t.dNI, t.nombre,t.apellidos,t.fechaNacimiento,t.direccion);
		this.sueldo = t.sueldo;
		this.isGerente = t.isGerente;
	}
	
	public Trabajador() {
		super("", "", "", "", "", "", new Date(), "");
		this.sueldo = 0;
		this.isGerente = false;
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
		return "Trabajador [sueldo=" + sueldo + ", isGerente=" + isGerente + "]";
	}
	
	
	
}