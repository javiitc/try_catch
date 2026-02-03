import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            try {

                System.out.print("Introduce el primer número: ");
                double num1 = sc.nextDouble();


                System.out.print("Introduce el segundo número: ");
                double num2 = sc.nextDouble();


                System.out.print("Introduce la operación: ");
                char operacion = sc.next().charAt(0);

                double resultado = 0;

                switch (operacion) {
                        case  '+':
                        resultado = num1 + num2;
                        break;
                        case  '-':
                        resultado = num1 - num2;
                        break;
                        case  '*':
                            resultado = num1 * num2;
                            break;
                        case   '/':
                            resultado = num1 / num2;
                            break;
                        }

                        System.out.println("Resultado: " + resultado);

                    } catch (InputMismatchException e) {
                        System.out.println("Introduce un número válido");
                        sc.nextLine();

                    } catch (ArithmeticException e) {
                        System.out.println("Error aritmético" );
                    }

                    System.out.print("Realizar otra operacion? ");
                    sc.nextLine();
                    String respuesta = sc.nextLine();

                    if (respuesta.equalsIgnoreCase("Si")) {
                        continue;
                    } else {
                        continuar = false;
                    }
                }
            }

}
