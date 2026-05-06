import java.util.Arrays;

public class Ordenamiento {

    // ══════════════════════════════════════════════════════
    //  INSERCIÓN
    //  Recorre el arreglo de i=1 hasta n-1.
    //  En cada iteración toma el elemento en posición b=i
    //  y lo compara con el elemento a=b-1 (izquierda).
    //  Si están en el orden incorrecto, intercambia y
    //  continúa retrocediendo hacia la izquierda.
    // ══════════════════════════════════════════════════════
    public int[] insercion(int[] original, boolean ascendente) {
        int[] arr = Arrays.copyOf(original, original.length);

        int comparaciones = 0;
        int cambios       = 0;
        int iteraciones   = 0;

        System.out.println("==== METODO INSERCION ====");
        System.out.print("Arreglo original: ");
        imprimirArreglo(arr);
        System.out.println();

        for (int i = 1; i < arr.length; i++) {
            iteraciones++;
            int b = i;
            int a = b - 1;

            // Cabecera de iteración
            System.out.printf("I%-4d", iteraciones);
            imprimirArregloInline(arr);

            boolean primero = true;

            while (a >= 0) {
                comparaciones++;
                boolean intercambiar = ascendente ? arr[a] > arr[b] : arr[a] < arr[b];

                if (primero) {
                    System.out.printf("a=%-3d b=%-3d [a]=%-6d [b]=%-6d cambio=%s%n",
                            a, b, arr[a], arr[b], intercambiar ? "si" : "no");
                    primero = false;
                } else {
                    System.out.printf("%35s a=%-3d b=%-3d [a]=%-6d [b]=%-6d cambio=%s%n",
                            "", a, b, arr[a], arr[b], intercambiar ? "si" : "no");
                }

                if (intercambiar) {
                    int tmp = arr[a]; arr[a] = arr[b]; arr[b] = tmp;
                    cambios++;
                    System.out.print("     ");
                    imprimirArreglo(arr);
                    b = a;
                    a--;
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

    // ══════════════════════════════════════════════════════
    //  SHELL SORT
    //  El gap comienza en n/2 y se divide entre 2 en cada
    //  pasada. Para cada gap, compara pares separados por
    //  'gap' posiciones, intercambiando si es necesario y
    //  retrocediendo de gap en gap.
    // ══════════════════════════════════════════════════════
    public int[] shell(int[] original, boolean ascendente) {
        int[] arr = Arrays.copyOf(original, original.length);
        int n = arr.length;

        int comparaciones = 0;
        int cambios       = 0;
        int iteraciones   = 0;

        System.out.println("==== METODO SHELL ====");
        System.out.print("Arreglo original: ");
        imprimirArreglo(arr);
        System.out.println();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                iteraciones++;
                int b = i;
                int a = b - gap;

                System.out.printf("I%-4d", iteraciones);
                imprimirArregloInline(arr);

                boolean primero = true;

                while (a >= 0) {
                    comparaciones++;
                    boolean intercambiar = ascendente ? arr[a] > arr[b] : arr[a] < arr[b];

                    if (primero) {
                        System.out.printf("gap=%-3d a=%-3d b=%-3d [a]=%-6d [b]=%-6d cambio=%s%n",
                                gap, a, b, arr[a], arr[b], intercambiar ? "si" : "no");
                        primero = false;
                    } else {
                        System.out.printf("%35s gap=%-3d a=%-3d b=%-3d [a]=%-6d [b]=%-6d cambio=%s%n",
                                "", gap, a, b, arr[a], arr[b], intercambiar ? "si" : "no");
                    }

                    if (intercambiar) {
                        int tmp = arr[a]; arr[a] = arr[b]; arr[b] = tmp;
                        cambios++;
                        System.out.print("     ");
                        imprimirArreglo(arr);
                        b = a;
                        a -= gap;
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
