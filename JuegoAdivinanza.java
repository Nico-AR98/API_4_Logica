import java.util.*;

class JuegoAdivinanza {
    private int numeroGenerado;
    private int intentosMaximos;
    public List<Integer> intentos = new ArrayList<>();
    private int minimo;
    private int maximo;

    public JuegoAdivinanza(int minimo, int maximo, int intentosMaximos) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.intentosMaximos = intentosMaximos;
        generarNumeroAleatorio();
    }

    private void generarNumeroAleatorio() {
        Random random = new Random();
        this.numeroGenerado = random.nextInt(maximo - minimo + 1) + minimo;
    }

    public boolean adivinarNumero(int numero) {
        if (numero < minimo || numero > maximo) {
            System.out.println("El número ingresado está fuera del rango.");
            return false;
        }

        if (intentos.contains(numero)) {
            System.out.println("Ya ingresaste ese número anteriormente.");
            return false;
        }

        intentos.add(numero);
        Collections.sort(intentos);
        int intentosRestantes = intentosMaximos - intentos.size();
        if (numero == numeroGenerado) {
            System.out.println("¡Felicidades! Has adivinado el número.");
            return true;
        } else {
            if (numero < numeroGenerado) {
                System.out.println("El número ingresado es menor. Intentos restantes: " + intentosRestantes);
            } else {
                System.out.println("El número ingresado es mayor. Intentos restantes: " + intentosRestantes);
            }
            System.out.println("Números ingresados: " + intentos);
            if (intentosRestantes <= 0) {
                System.out.println("¡Has agotado todos tus intentos! El número era: " + numeroGenerado);
            }
            return false;
        }
    }
}

