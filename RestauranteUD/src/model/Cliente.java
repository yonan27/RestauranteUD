package model;

import java.util.Date;

public class Cliente extends Persona {
	
	private long numTarjeta;
	private Suscripcion suscripcion;
	
<<<<<<< Updated upstream
	public Cliente(long numTarjeta, Suscripcion suscripcion) {
		super();
=======
	public Cliente(String usuario, String contra, String email, String nombre, String apellidos, Date fechaNacimiento,
			String direccion, long numTarjeta, Suscripcion suscripcion) {
		super(usuario, contra, email, nombre, apellidos, fechaNacimiento, direccion);
>>>>>>> Stashed changes
		this.numTarjeta = numTarjeta;
		this.suscripcion = suscripcion;
	}
	
	public Cliente() {
		super();
<<<<<<< Updated upstream
		this.numTarjeta = 0;
		this.suscripcion = null;
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
		return "Cliente [numTarjeta=" + numTarjeta + ", suscripcion=" + suscripcion + "]";
	}
	
	
	
=======
		this.numTarjeta = 000000;
		this.suscripcion = suscripcion;
	
	}
>>>>>>> Stashed changes

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
		return "Cliente [numTarjeta=" + numTarjeta + ", suscripcion=" + suscripcion + "]";
	}
	
}