package Avisador_de_Correo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AvisadorDeCorreo {
	private volatile boolean nuevoCorreo = false; // Declaración de una variable booleana para controlar el estado del
													// correo.

	public static void main(String[] args) {
		AvisadorDeCorreo avisador = new AvisadorDeCorreo(); // Creación de una instancia de la clase AvisadorDeCorreo.

		Thread hiloAvisador = new Thread(() -> {
			// Creación de un hilo Avisador que se ejecuta en segundo plano.
			while (true) {
				if (avisador.nuevoCorreo) {
					System.err.println("Nuevo Correo"); // Si hay nuevo correo, muestra un mensaje en la consola de
														// errores.
					try {
						Thread.sleep(5000); // Pausa de 5 segundos antes de volver a verificar.
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		hiloAvisador.setDaemon(true); // Establece que el hilo Avisador sea un hilo demonio (menos prioritario).

		hiloAvisador.start(); // Inicia el hilo Avisador.

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Configura la entrada desde la
																						// consola.

			while (true) {
				String comando = br.readLine(); // Lee el comando ingresado por el usuario.
				if ("leer".equals(comando)) {
					avisador.nuevoCorreo = false; // Marca el correo como leído al cambiar la variable a falso.
					System.out.println("El correo ha sido leído. No recibirás más avisos.");
				} else if ("nuevo".equals(comando)) {
					avisador.nuevoCorreo = true; // Activa la recepción de avisos de nuevo correo al cambiar la variable
													// a verdadero.
					System.out.println("Recibiendo avisos de nuevo correo.");
				} else if ("fin".equals(comando)) {
					System.out.println("Finalizando el programa.");
					hiloAvisador.interrupt(); // Detiene el hilo Avisador.
					System.exit(0); // Finaliza el programa.
				} else {
					System.out.println("Comando no reconocido. Usa 'leer', 'nuevo' o 'fin'."); // Mensaje de error para
																								// comandos no válidos.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
