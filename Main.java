import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("<=== Bienvenido al juego de adivinanzas ===>");
        System.out.print("Ingresa el límite inferior del rango: ");
        int minimo = scanner.nextInt();
        System.out.print("Ingresa el límite superior del rango: ");
        int maximo = scanner.nextInt();
        System.out.print("Ingresa la cantidad de intentos permitidos: ");
        int intentosMaximos = scanner.nextInt();
        
        JuegoAdivinanza juego = new JuegoAdivinanza(minimo, maximo, intentosMaximos);
        
        while (true) {
            System.out.print("Ingresa un número: ");
            int numero = scanner.nextInt();
            boolean acertado = juego.adivinarNumero(numero);
            if (acertado || juego.intentos.size() >= intentosMaximos) {
                break;
            }
        }
        
        scanner.close();
    }
}