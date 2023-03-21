package com.cursoceat.ui;

import java.util.Scanner;

import com.cursoceat.model.Aparatos;

public class MenuUsuario {
	
	static Scanner keyboard = new Scanner(System.in);
	public static void mostrarMenu() {
		boolean salir = false;
		do {
		System.out.println("\n\n\tMENU PRINCIPAL");
		System.out.println("\n1. Crear una lavadora");
		System.out.println("2. Crear otro electrodoméstico");
		System.out.println("3. Consultar datos de los electrodomesticos");
		System.out.println("4. Editar datos de lavadora");
		System.out.println("5. Editar datos de electrodomestico");
		System.out.println("6. Calcular el coste del consumo");
		System.out.print("\n0. Salir\n\n\tSelecciona una opción -> ");
		int opcion = keyboard.nextInt();
		switch(opcion) {
		case 1 ->{
			Aparatos.crearLavadora();
		}
		case 2 ->{
			Aparatos.crearElectro();
		}
		case 3 ->{
			Aparatos.mostrarElectro();
		}
		case 4 ->{
			Aparatos.editarLavadora();
		}
		case 5 ->{
			Aparatos.editarElectro();
		}
		case 6 ->{
			Aparatos.consumoElectro();
		}
		case 0 ->{
			salir = true;
		}
		default ->{
			System.err.println("\tERROR: Opción no valida");
		}
		}
				
		} while (!salir);
		System.out.println("\n¡Hasta Luego!");
		keyboard.close();
		}
}
