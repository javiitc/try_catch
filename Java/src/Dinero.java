import java.util.Scanner;
import java.util.InputMismatchException;

public class Dinero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dinero = 0;
        boolean continuar = true;

        System.out.println("=== BIENVENIDO AL BANCO ===\n");

        while (continuar) {
            try {
                // Mostrar menú
                System.out.println("========== MENÚ ==========");
                System.out.println("Dinero disponible: " + dinero + "€");
                System.out.println("1. Ingresar dinero");
                System.out.println("2. Sacar dinero");
                System.out.println("3. Consultar saldo disponible");
                System.out.println("4. Salir");
                System.out.print("Elige una opción: ");

                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        // Ingresar dinero
                        System.out.print("Seleccione la cantidad a ingresar: ");
                        int ingreso = sc.nextInt();

                        if (ingreso < 0) {
                            throw new IllegalArgumentException("No puedes ingresar cantidades negativas");
                        }

                        dinero += ingreso;
                        System.out.println("Ingreso realizado correctamente");
                        System.out.println("Dinero en cuenta: " + dinero + "€");
                        break;

                    case 2:
                        // Sacar dinero
                        System.out.print("¿Cuánto dinero deseas sacar?: ");
                        int retiro = sc.nextInt();

                        if (retiro < 0) {
                            throw new IllegalArgumentException("No puedes retirar cantidades negativas");
                        }

                        if (retiro > dinero) {
                            throw new ArithmeticException("Dinero insuficiente. Solo tienes " + dinero + "€");
                        }

                        dinero -= retiro;
                        System.out.println("Retiro realizado correctamente");
                        System.out.println("Dinero dispoible en efectivo: " + dinero + "€");
                        break;

                    case 3:
                        System.out.println("Tu saldo actual es: " + dinero + "€");
                        break;

                    case 4:
                        continuar = false;
                        System.out.println("Gracias por usar nuestros servicios. Hasta la próxima!");
                        break;

                    default:
                        System.out.println("Opción no válida. Vuelva a intentarlo");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Solo puede introducir números enteros");
                sc.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
