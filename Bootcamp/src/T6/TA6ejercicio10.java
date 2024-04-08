package T6;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TA6ejercicio10 {

	// TODO Auto-generated method stub
	public static boolean esPrimo(int num) {
		if (num <= 1)
			return false;
		if (num <= 3)
			return true;
		if (num % 2 == 0 || num % 3 == 0)
			return false;
		for (int i = 5; i * i <= num; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0)
				return false;
		}
		return true;
	}

	public static ArrayList<Integer> generarPrimos(int tamaño) {
		ArrayList<Integer> primos = new ArrayList<>();
		Random rand = new Random();
		while (primos.size() < tamaño) {
			int num = rand.nextInt(999) + 2;
			if (esPrimo(num)) {
				primos.add(num);
			}
		}
		return primos;
	}

	public static int encontrarMayor(ArrayList<Integer> array) {
		int mayor = Integer.MIN_VALUE;
		for (int num : array) {
			if (num > mayor) {
				mayor = num;
			}
		}
		return mayor;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce el tamaño del array: ");
		int tamaño = scanner.nextInt();

		ArrayList<Integer> numerosPrimos = generarPrimos(tamaño);
		System.out.println("Array de números primos: " + numerosPrimos);

		int mayor = encontrarMayor(numerosPrimos);
		System.out.println("El mayor número primo es: " + mayor);

		scanner.close();
	}

}
