package model;

public class Suscripcion {
	
	private String nombre;
	private int precio;
	private int duracion; //En d�as
	
	
	public Suscripcion(String nombre, int precio, int duracion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.duracion = duracion;
	}
	

	public Suscripcion() {
		super();
		this.nombre = "";
		this.precio = 0;
		this.duracion = 0;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	@Override
	public String toString() {
		return "Suscripcion [nombre=" + nombre + ", precio=" + precio + ", duracion=" + duracion + "]";
	}
	
	

}
