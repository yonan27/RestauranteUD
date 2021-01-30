package model;

public class VentaMenu {
	
	protected Persona comprador;
	protected Menu menu;
	protected int precio;
	
	public VentaMenu(Persona comprador, Menu menu, int precio) {
		super();
		this.comprador = comprador;
		this.menu = menu;
		this.precio = precio;
	}
	
	public VentaMenu() {
		super();
		this.comprador = null;
		this.menu = null;
		this.precio = 0;
	}

	public Persona getComprador() {
		return comprador;
	}

	public void setComprador(Persona comprador) {
		this.comprador = comprador;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
	
	

}
