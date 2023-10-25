package correctorConsola;

public class Corrector extends Thread {
    private volatile boolean seEjecuta = true;
    private String entrada;
    
    public void pararHilo() {
        seEjecuta = false;
    }

    public void run() {
        while (seEjecuta) {
            if (entrada != null) {
                String corregida = palabraCorregida(entrada);
                if (!entrada.equals(corregida)) {
                    System.err.println("Palabra corregida: " + corregida);
                }
                entrada = null;
            }
        }
    }

    public synchronized void setEntrada(String palabra) {
        entrada = palabra;
    }

    private String palabraCorregida(String palabra) {
        if (palabra.length() == 0) {
            return palabra;
        }
        
        String palabraFinal = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
        return palabraFinal;
    }
}