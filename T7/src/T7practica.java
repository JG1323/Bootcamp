import java.util.HashMap;
import java.util.Scanner;

public class T7practica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> edadesAlumnos = new HashMap<>();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese la clave para el primer alumno: ");

		String alumno1 = scanner.nextLine();

		System.out.print("Ingrese la edad para el primer alumno: ");

		int valor1 = scanner.nextInt();

		scanner.nextLine();

		edadesAlumnos.put(alumno1, valor1);

		System.out.print("Ingrese la clave para el segundo alumno: ");

		String alumno2 = scanner.nextLine();

		System.out.print("Ingrese la edad para el segundo alumno: ");

		int valor2 = scanner.nextInt();

		scanner.nextLine();

		edadesAlumnos.put(alumno2, valor2);

		System.out.println("Las edades de los alumnos estan actualizadas correctamente: " + edadesAlumnos);

		scanner.close();

	}

}