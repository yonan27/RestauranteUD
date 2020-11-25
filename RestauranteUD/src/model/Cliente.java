package model;

import java.util.Date;

public class Cliente extends Persona {

	private long numTarjeta;

	public Cliente(String usuario, String contra, String email, String dNI, String nombre, String apellidos,
			Date fechaNacimiento, long numTarjeta) {
		super(usuario, contra, email, dNI, nombre, apellidos, fechaNacimiento);
		this.numTarjeta = numTarjeta;
		
	}

	public Cliente() {
		super("", "", "", "", "", "", new Date());
		this.numTarjeta = 0;
		
	}

	public Cliente(Cliente c) {
		super(c.usuario, c.contra, c.email, c.dNI, c.nombre, c.apellidos, c.fechaNacimiento);
		this.numTarjeta = c.numTarjeta;
		
	}

	public long getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}








}