package com.cursoceat.model;

public class Electrodomestico {

	private String tipo;
	private String marca;
	private double potencia;
	private static int idTotal;
	private int id;
	
	
	public Electrodomestico(String tipo, String marca, double potencia) {
		this.tipo = tipo;
		this.marca = marca;
		this.potencia = potencia;
		asignarId();
	}

	public void asignarId() {
		idTotal++;
		this.id = idTotal;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	
	@Override
	public String toString() {
		String datosElectrodomestico = "ID: "+ this.id+ "\nTipo: " + this.tipo + "\nMarca: " + this.marca + "\nPotencia: " + this.potencia +" kW/h";
		return datosElectrodomestico;
	}
	
	public double getConsumo(int horas) {
		double consumo = horas*this.potencia;
		return consumo;
	}
	
	public double getCosteConsumo(int horas, double costeHora) {
		double costeTotal = this.getConsumo(horas)*costeHora;
		return costeTotal;
		
	}
	
}
