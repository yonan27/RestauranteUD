package model;

public class Cliente extends Persona {
	
	private long numTarjeta;
	private Suscripcion suscripcion;
	
	public Cliente(long numTarjeta, Suscripcion suscripcion) {
		super();
		this.numTarjeta = numTarjeta;
		this.suscripcion = suscripcion;
	}
	
	public Cliente() {
		super();
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
	
	
	


}