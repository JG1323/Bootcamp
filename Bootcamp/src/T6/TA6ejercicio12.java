package T6;
import java.util.Random;
import java.util.Scanner;

public class TA6ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        try {
            System.out.print("Introduce el tamaño del array: ");
            int tamano = scanner.nextInt();
            if (tamano <= 0) {
                throw new IllegalArgumentException("El tamaño del array debe ser mayor que cero.");
            }

            int[] arrayNumeros = crearArray(tamano, random);
            System.out.print("Array generado: ");
            mostrarArray(arrayNumeros);

            System.out.print("Introduce el dígito para filtrar: ");
            int digito = scanner.nextInt();
            if (digito < 0 || digito > 9) {
                throw new IllegalArgumentException("Por favor, introduce un dígito válido (0-9).");
            }

            int[] numerosFiltrados = filtrarNumeros(arrayNumeros, digito);
            System.out.print("Números filtrados que terminan en " + digito + ": ");
            mostrarArray(numerosFiltrados);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int[] crearArray(int tamano, Random random) {
        int[] array = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            array[i] = random.nextInt(300) + 1;
        }
        return array;
    }

    public static void mostrarArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] filtrarNumeros(int[] array, int digito) {
        int count = 0;
        for (int num : array) {
            if (String.valueOf(num).endsWith(String.valueOf(digito))) {
                count++;
            }
        }

        int[] numerosFiltrados = new int[count];
        int index = 0;
        for (int num : array) {
            if (String.valueOf(num).endsWith(String.valueOf(digito))) {
                numerosFiltrados[index++] = num;
            }
        }
        return numerosFiltrados;
    }
    
}
