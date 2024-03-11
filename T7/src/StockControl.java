import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockControl {

	private Map<String, Double> baseDatos = new HashMap<>();

	public static void main(String[] args) {

		StockControl stockControl = new StockControl();

		stockControl.menu();
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("===== Control de Stock =====");
			System.out.println("1. Añade un Artículo");
			System.out.println("2. Consultar producto");
			System.out.println("3. Lista de Información");
			System.out.println("4. Salir");
			System.out.print("Pon tu eleccion: ");

			choice = scanner.nextInt();

			scanner.nextLine();

			switch (choice) {
			case 1:
				agregarArticulo(scanner);
				break;
			case 2:
				consultarArticulo(scanner);
				break;
			case 3:
				listarInformacion();
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida. Por favor, ingrese nuevamente.");
			}
		} while (choice != 4);
		scanner.close();
	}

	public void agregarArticulo(Scanner scanner) {
		System.out.print("Pon el nombre del artículo: ");
		String nombre = scanner.nextLine();
		System.out.print("Pon el precio del artículo: ");
		double precio = scanner.nextDouble();
		baseDatos.put(nombre, precio);
		System.out.println("Artículo agregado correctamente.");
	}

	public void consultarArticulo(Scanner scanner) {
		System.out.print("Pon el nombre del artículo a consultar: ");

		String nombre = scanner.nextLine();

		if (baseDatos.containsKey(nombre)) {
			System.out.println("Precio de " + nombre + ": " + baseDatos.get(nombre));
		} else {
			System.out.println("Artículo no encontrado.");
		}
	}

	public void listarInformacion() {
		System.out.println("===== Información de Stock =====");

		for (Map.Entry<String, Double> entry : baseDatos.entrySet()) {
			System.out.println("Nombre: " + entry.getKey() + ", Precio: " + entry.getValue());
		}
	}
}
