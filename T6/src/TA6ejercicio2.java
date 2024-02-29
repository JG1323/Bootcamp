import java.util.Scanner;

public class TA6ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese el número mínimo del rango: ");
		int min = scanner.nextInt();

		System.out.print("Ingrese el número máximo del rango: ");
		int max = scanner.nextInt();

		System.out.print("Ingrese la cantidad de números a generar: ");
		int cantidad = scanner.nextInt();

		System.out.println("Números aleatorios generados:");
		for (int i = 0; i < cantidad; i++) {
			int numeroAleatorio = generarNumeroAleatorio(min, max);
			System.out.println(numeroAleatorio);
		}

		scanner.close();

	}

	public static int generarNumeroAleatorio(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;

	}

}