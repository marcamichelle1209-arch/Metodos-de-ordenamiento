import java.util.Arrays;

public class Ordenamiento {

    
    public int[] insercion(int[] original, boolean ascendente) {
        int[] arr = Arrays.copyOf(original, original.length);

        int comparaciones = 0;
        int cambios       = 0;
        int iteraciones   = 0;

        System.out.println("==== METODO INSERCION ====");
        System.out.print("Arreglo original: ");
        imprimirArreglo(arr);

        for (int i = 1; i < arr.length; i++) {
            iteraciones++;
            System.out.printf("I%-4d", iteraciones);
            imprimirArregloInline(arr);

            for (int j = i; j > 0; j--) {
                comparaciones++;
                boolean intercambiar = ascendente ? arr[j-1] > arr[j] : arr[j-1] < arr[j];

                System.out.printf("a=%-3d b=%-3d [a]=%-6d [b]=%-6d cambio=%s%n",
                        j-1, j, arr[j-1], arr[j], intercambiar ? "si" : "no");

                if (intercambiar) {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                    cambios++;
                    System.out.print("     ");
                    imprimirArreglo(arr);
                } else {
                    break;
                }
            }
        }

        System.out.println();
        System.out.printf("COMPARACIONES = %d%n", comparaciones);
        System.out.printf("ITERACIONES   = %d%n", iteraciones);
        System.out.printf("CAMBIOS       = %d%n", cambios);

        return new int[]{ comparaciones, cambios, iteraciones };
    }

    
    public int[] shell(int[] original, boolean ascendente) {
        int[] arr = Arrays.copyOf(original, original.length);
        int n = arr.length;

        int comparaciones = 0;
        int cambios       = 0;
        int iteraciones   = 0;

        System.out.println("==== METODO SHELL ====");
        System.out.print("Arreglo original: ");
        imprimirArreglo(arr);

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                iteraciones++;
                System.out.printf("I%-4d", iteraciones);
                imprimirArregloInline(arr);

                for (int j = i; j >= gap; j -= gap) {
                    comparaciones++;
                    boolean intercambiar = ascendente ? arr[j-gap] > arr[j] : arr[j-gap] < arr[j];

                    System.out.printf("gap=%-3d a=%-3d b=%-3d [a]=%-6d [b]=%-6d cambio=%s%n",
                            gap, j-gap, j, arr[j-gap], arr[j], intercambiar ? "si" : "no");

                    if (intercambiar) {
                        int tmp = arr[j-gap];
                        arr[j-gap] = arr[j];
                        arr[j] = tmp;
                        cambios++;
                        System.out.print("     ");
                        imprimirArreglo(arr);
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println();
        System.out.printf("COMPARACIONES = %d%n", comparaciones);
        System.out.printf("ITERACIONES   = %d%n", iteraciones);
        System.out.printf("CAMBIOS       = %d%n", cambios);

        return new int[]{ comparaciones, cambios, iteraciones };
    }


    private void imprimirArreglo(int[] arr) {
        for (int v : arr) System.out.printf("%-5d", v);
        System.out.println();
    }

    private void imprimirArregloInline(int[] arr) {
        for (int v : arr) System.out.printf("%-5d", v);
        System.out.print("     ");
    }
}