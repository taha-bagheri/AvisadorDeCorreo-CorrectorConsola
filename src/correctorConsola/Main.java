package correctorConsola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Corrector corrector = new Corrector();
        corrector.setPriority(Thread.MIN_PRIORITY);
        corrector.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escribe una palabra (o 'Fin' para terminar):");
            String palabra = scanner.nextLine();

            if (palabra.equalsIgnoreCase("Fin")) {
                corrector.pararHilo();
                break;
            }

            corrector.setEntrada(palabra);
        }
    }
}