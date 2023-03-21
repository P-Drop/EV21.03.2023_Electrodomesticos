package com.cursoceat.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Aparatos {

	static ArrayList<Electrodomestico> misAparatos = new ArrayList<>();
	static Scanner keyboard = new Scanner(System.in);
	static final double PRECIO_KWH = 0.132;
	
	public static void crearLavadora() {
		boolean modoCaliente;
		System.out.println("\nVamos a crear una lavadora. ¿Sabes su precio y modo de funcionamiento? (y/n)");
		if(keyboard.next().equals("y")) {
			keyboard.nextLine();
			System.out.print("Ok, introduce sus datos\n\nMarca: ");
			String marca = keyboard.nextLine();
			System.out.print("Precio: ");
			double precio = keyboard.nextDouble();
			System.out.print("Potencia: ");
			double potencia = keyboard.nextDouble();
			while(true) {
			System.out.println("Modo de funcionamiento (agua fría(f) / agua caliente (c)): ");
			String modo = keyboard.next();
			if(modo.equals("c")) {
				modoCaliente = true;
				break;
			}
			else if(modo.equals("f")) {
				modoCaliente = false;
				break;
			}
			else {
				System.err.println("\n\tERROR: Introduce 'c' o 'f'");
			}
			}
			Lavadora lavC = new Lavadora(marca, precio, potencia, modoCaliente);
			misAparatos.add(lavC);
			System.out.println("\nOperación realizada");
		}
		else {
			keyboard.nextLine();
			System.out.print("Ok, introduce sus datos\n\nMarca: ");
			String marca = keyboard.nextLine();
			System.out.print("Potencia: ");
			double potencia = keyboard.nextDouble();
			Lavadora lavI = new Lavadora(marca, potencia);
			misAparatos.add(lavI);
			System.out.println("\nOperación realizada");		
		}
	}
	
	public static void crearElectro() {
		keyboard.nextLine();
		System.out.print("Se va a crear un electrodoméstico. Introduce sus datos\n\nTipo: ");
		String tipo = keyboard.nextLine();
		System.out.print("Marca: ");
		String marca = keyboard.nextLine();
		System.out.println("Potencia: ");
		double potencia = keyboard.nextDouble();
		Electrodomestico elect = new Electrodomestico(tipo, marca, potencia);
		misAparatos.add(elect);
		System.out.println("\nOperación realizada");		
	}
	
	public static void mostrarElectro() {
		for (Electrodomestico aparato : misAparatos) {
			System.out.println("\n"+aparato.toString());
		}
	}
	public static void editarLavadora() {
		System.err.println("ERROR: Funcion no disponible");
		/*
		 * boolean modoCaliente;
		 * System.out.print("Introduce ID de la lavadora que deseas editar -> "); int
		 * idEdit = keyboard.nextInt();
		 * System.out.println("Datos actuales de la Lavadora\n");
		 * misAparatos.get(idEdit-1).toString();
		 * System.out.print("Modificar datos\n\nMarca: "); String marca =
		 * keyboard.nextLine(); misAparatos.get(idEdit-1).setMarca(marca);
		 * System.out.print("Precio: "); double precio = keyboard.nextDouble();
		 * //misAparatos.get(idEdit-1).setPrecio(precio);
		 * System.out.print("Potencia: "); double potencia = keyboard.nextDouble();
		 * misAparatos.get(idEdit-1).setPotencia(potencia); while(true) { System.out.
		 * println("Modo de funcionamiento (agua fría(f) / agua caliente (c)): ");
		 * String modo = keyboard.next(); if(modo.equals("c")) { modoCaliente = true;
		 * break; } else if(modo.equals("f")) { modoCaliente = false; break; } else {
		 * System.err.println("\n\tERROR: Introduce 'c' o 'f'"); } }
		 * //misAparatos.get(idEdit-1).setAguaCaliente(modoCaliente);
		 * System.out.println("\nOperación realizada");
		 */
	}
	
	public static void editarElectro() {
		System.err.println("ERROR: Funcion no disponible");
		/*
		 * System.out.print("Introduce ID del electrodoméstico que deseas editar -> ");
		 * int idEdit = keyboard.nextInt(); System.out.println(idEdit-1);
		 * System.out.println("Datos actuales del Electrodomestico\n");
		 * misAparatos.get(idEdit-1).toString(); keyboard.nextLine();
		 * System.out.print("Modificar datos\n\nTipo: "); String tipo =
		 * keyboard.nextLine(); misAparatos.get(idEdit-1).setTipo(tipo);
		 * System.out.print("Marca: "); String marca = keyboard.nextLine();
		 * misAparatos.get(idEdit-1).setMarca(marca); System.out.println("Potencia: ");
		 * double potencia = keyboard.nextDouble();
		 * misAparatos.get(idEdit-1).setPotencia(potencia);
		 * System.out.println("\nOperación realizada");
		 */
	}
	
	public static void consumoElectro() {
		System.out.print("Introduce ID del electrodoméstico que deseas consultar -> ");
		int idConsulta = keyboard.nextInt();
		boolean idEncontrado = false;
		double costeConsumo = 0;
		for (Electrodomestico e : misAparatos) {
			if(e.getId()==idConsulta) {
				idEncontrado = true;
				System.out.println(e.getTipo()+" tiene una potencia de "+e.getPotencia()+" kW/h");
				System.out.print("Introduce las horas de funcionamiento (número entero): ");
				int horas = keyboard.nextInt();
				System.out.println("El consumo es de "+e.getConsumo(horas)+" kW");
				System.out.println("\nEl precio del kW/hora actual es de "+PRECIO_KWH+" € ¿Es correcto? (y/n)");
				if(keyboard.next().equals("y")) {
					costeConsumo = e.getCosteConsumo(horas, PRECIO_KWH);
				}
				else {
					System.out.print("Introduce el precio del kW/hora: ");
					double precioActual = keyboard.nextDouble();
					costeConsumo = e.getCosteConsumo(horas, precioActual);
				}
				System.out.print("El coste del consumo para "+horas+" horas es "+Math.round(costeConsumo*100)/100.0 +" €");
			}
		}
		
	}
}
