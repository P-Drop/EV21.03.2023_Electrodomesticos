package com.cursoceat.model;

public class Lavadora extends Electrodomestico{

	private double precio;
	private boolean aguaCaliente; //Caliente: true, Fría: false
	
	public Lavadora(String marca, double potencia) {
		super("Lavadora", marca, potencia);
		this.aguaCaliente = false;
	}

	public Lavadora(String marca, double precio, double potencia, boolean modoDeFuncionamiento){
		super("Lavadora", marca, potencia);
		this.precio = precio;
		this.aguaCaliente = modoDeFuncionamiento;	
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isAguaCaliente() {
		return aguaCaliente;
	}

	public void setAguaCaliente(boolean aguaCaliente) {
		this.aguaCaliente = aguaCaliente;
	}
	
	@Override
	public String toString() {
		String modo = aguaCaliente ? "agua caliente" : "agua fría";
		String datosLavadora = super.toString() + "\nPrecio: " + this.precio + "\nModo de funcionamiento: " + modo;
		return datosLavadora;
	}
	
	
	
}
