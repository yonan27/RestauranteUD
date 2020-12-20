package model;

public class Menu {

	
	protected boolean semanal ;
	protected boolean finDeSemana;
	protected Cliente consumidor;
	
	public Menu(boolean semanal, boolean finDeSemana, Cliente consumidor) {
		super();
		this.semanal = semanal;
		this.finDeSemana = finDeSemana;
		this.consumidor = consumidor;
	}
	public Menu() {
		super();
		this.semanal = false;
		this.finDeSemana = false;
		this.consumidor = null;
	}

	public boolean isSemanal() {
		return semanal;
	}
	public void setSemanal(boolean semanal) {
		this.semanal = semanal;
	}
	public boolean isFinDeSemana() {
		return finDeSemana;
	}
	public void setFinDeSemana(boolean finDeSemana) {
		this.finDeSemana = finDeSemana;
	}
	public Cliente getConsumidor() {
		return consumidor;
	}
	public void setConsumidor(Cliente consumidor) {
		this.consumidor = consumidor;
	}
	
	
}

