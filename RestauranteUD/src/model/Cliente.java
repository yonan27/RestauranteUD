package model;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona {
	
	private long numTarjeta;
	private Suscripcion suscripcion;
	
	public Cliente(String usuario, String contra, String email,  String nombre, String apellidos,
			ArrayList<Suscripcion> suscripcion ,Date fechaNacimiento, long numTarjeta) {
		super(usuario, contra, email, nombre, apellidos, fechaNacimiento, null);
		this.numTarjeta = numTarjeta;
	}

	public Cliente() {
		super("","","","","",null,null);
		this.numTarjeta = 0000000000000000;
	}

	public Cliente(Cliente c) {
		super(c.usuario, c.contra, c.email, c.nombre, c.apellidos, c.fechaNacimiento, null);
		this.numTarjeta = c.numTarjeta;
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

	@Override
	public String toString() {
		return nombre + " " +  apellidos + " ";
	}

	
}