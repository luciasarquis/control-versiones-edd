import java.util.Scanner;

public class Calculadora {

    // Suma dos numeros.
    public static long sumar(int a, int b) {
        return (long) a + b;
    }

    // Resta dos numeros.
    public static long restar(int a, int b) {
        return (long) a - b;
    }

    // Multiplica dos numeros.
    public static long multiplicar(int a, int b) {
        return (long) a * b;
    }

    // Calcula una potencia.
    public static double potencia(int a, int b) {
        return Math.pow(a, b);
    }

    // Comprueba el rango permitido.
    public static boolean validar(int n) {
        return n >= -99999 && n <= 99999;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("CALCULADORA");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Potencia");

        System.out.print("Elige una opcion: ");
        int opcion = sc.nextInt();

        System.out.print("Primer numero: ");
        int a = sc.nextInt();

        System.out.print("Segundo numero: ");
        int b = sc.nextInt();

        if (!validar(a) || !validar(b)) {
            System.out.println("Error: numeros fuera del rango permitido.");
            sc.close();
            return;
        }

        switch (opcion) {
            case 1:
                System.out.println("Resultado: " + sumar(a, b));
                break;
            case 2:
                System.out.println("Resultado: " + restar(a, b));
                break;
            case 3:
                System.out.println("Resultado: " + multiplicar(a, b));
                break;
            case 4:
                double resultado = potencia(a, b);
                if (Double.isInfinite(resultado) || Double.isNaN(resultado)) {
                    System.out.println("Resultado demasiado grande.");
                } else {
                    System.out.println("Resultado: " + resultado);
                }
                break;
            default:
                System.out.println("Opcion no valida.");
        }

        sc.close();
    }
}
