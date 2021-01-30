package model;

public class Menu {

	
	protected String primerPlato ;
	protected String segundoPlato;
	protected String bebida;
	protected int precio;
	
	public Menu(String primerPlato, String segundoPlato, String bebida, int precio) {
		super();
		this.primerPlato = primerPlato;
		this.segundoPlato = segundoPlato;
		this.bebida = bebida;
		this.precio = precio;
	}
	
	public Menu() {
		super();
		this.primerPlato = "";
		this.segundoPlato = "";
		this.bebida = "";
		this.precio = 0;
	}

	public String getPrimerPlato() {
		return primerPlato;
	}

	public void setPrimerPlato(String primerPlato) {
		this.primerPlato = primerPlato;
	}

	public String getSegundoPlato() {
		return segundoPlato;
	}

	public void setSegundoPlato(String segundoPlato) {
		this.segundoPlato = segundoPlato;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
	
	
	
	
}

