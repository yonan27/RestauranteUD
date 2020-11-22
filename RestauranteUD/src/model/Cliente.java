package model;

import java.util.Date;

public class Cliente extends Persona {

	private long numTarjeta;
	private Suscripcion suscripcion;

	public Cliente(String usuario, String contra, String email, String dNI, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, long numTarjeta, Suscripcion suscripcion) {
		super(usuario, contra, email, dNI, nombre, apellidos, fechaNacimiento, direccion);
		this.numTarjeta = numTarjeta;
		this.suscripcion = suscripcion;
	}

	public Cliente() {
		super("", "", "", "", "", "", new Date(),"");
		this.numTarjeta = 0;
		this.suscripcion = null;
	}

	public Cliente(Cliente c) {
		super(c.usuario, c.contra, c.email, c.dNI, c.nombre, c.apellidos, c.fechaNacimiento, c.direccion);
		this.numTarjeta = c.numTarjeta;
		this.suscripcion = c.suscripcion;
	}

	public long getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public Suscripcion getSuscripcion() {
		return suscripcion;
	}

	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}








}