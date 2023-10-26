package correctorConsola;

public class Corrector extends Thread {
	// Variable que controla la ejecución del hilo
	private volatile boolean seEjecuta = true;
	private String entrada;

	// Metodo para parar la ejecucion del hilo
	public void pararHilo() {
		seEjecuta = false;
	}

	// Metodo run() sobreescrito
	public void run() {
		while (seEjecuta) {
			// Comprueba si hay una palabra a corregir
			if (entrada != null) {
				String corregida = palabraCorregida(entrada);
				if (!entrada.equals(corregida)) {
					// Si corrige la palabra, la imprime por salida de error
					System.err.println("Palabra corregida: " + corregida);
				}
				// Limpia la entrada
				entrada = null;
			}
		}
	}

	// Metodo que establece la palabra a corregir. Se utiliza la keyword
	// "synchronized" para permitir la ejecución de un solo hilo simultaneamente
	public synchronized void setEntrada(String palabra) {
		entrada = palabra;
	}

	// Metodo que corrige la palabra mediante el metodo substring()
	private String palabraCorregida(String palabra) {
		if (palabra.length() == 0) {
			return palabra;
		}

		String palabraFinal = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
		return palabraFinal;
	}
}