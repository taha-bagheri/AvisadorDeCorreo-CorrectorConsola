package correctorConsola;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Instancia de la clase corrector
		Corrector corrector = new Corrector();
		// Establecemos la prioridad del hilo al minimo
		corrector.setPriority(Thread.MIN_PRIORITY);
		// Inicia el corrector
		corrector.start();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			// Solicita una palabra al usuario
			System.out.println("Escribe una palabra (o 'Fin' para terminar):");
			String palabra = scanner.nextLine();

			// Se comprueba si el usuario quiere cerrar el programa
			if (palabra.equalsIgnoreCase("Fin")) {
				// Se detiene el hilo y se sale del bucle
				corrector.pararHilo();
				break;
			}

			// Se establece la palabra a corregir
			corrector.setEntrada(palabra);
		}
	}
}