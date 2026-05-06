import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int[] arreglo = { 12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3 };
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==== PROGRAMA DE ORDENAMIENTO ====");
            System.out.println("1. Ejecutar ordenamientos");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("¿Inserción ascendente? (true/false): ");
                boolean ascIns = sc.nextBoolean();

                System.out.print("¿Shell ascendente? (true/false): ");
                boolean ascShell = sc.nextBoolean();

                Ordenamiento ord = new Ordenamiento();

                System.out.println();
                ord.insercion(arreglo, ascIns);

                System.out.println();
                ord.shell(arreglo, ascShell);

            } else if (opcion != 2) {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 2);

        sc.close();
    }
}