package model;

public class Trabajador extends Persona{

	private int sueldo;
	private boolean isGerente;
	
	
	public Trabajador(int sueldo, boolean isGerente) {
		super();
		this.sueldo = sueldo;
		this.isGerente = isGerente;
	}

	public Trabajador() {
		super();
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