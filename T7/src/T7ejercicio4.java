
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class T7ejercicio4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("¿Qué desea utilizar?");
		System.out.println("1. Caja del Supermercado");
		System.out.println("2. Menú de Gestión de Productos");
		System.out.print("Ingrese el número correspondiente a la opción que desea utilizar: ");

		int opcion = scanner.nextInt();
		scanner.nextLine();

		if (opcion == 1) {
			cajaSupermercado(scanner);
		} else if (opcion == 2) {
			usarMenuGestionProductos(scanner);
		} else {
			System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
		}

		scanner.close();
	}

	public static void cajaSupermercado(Scanner scanner) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ha seleccionado utilizar la Caja del Supermercado.");
		
	}

	public static void usarMenuGestionProductos(Scanner scanner) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ha seleccionado utilizar el Menú de Gestión de Productos.");

	}

	public static void cajaSupermercado(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Producto> carrito = new ArrayList<>();

		String nombreProducto;
		double cantidad, precio;

		do {
			System.out.print("Ingrese el nombre del producto (o 'fin' para finalizar): ");
			nombreProducto = scanner.nextLine();

			if (!nombreProducto.equalsIgnoreCase("fin")) {
				System.out.print("Ingrese la cantidad del producto '" + nombreProducto + "': ");
				cantidad = scanner.nextDouble();

				System.out.print("Ingrese el precio unitario del producto '" + nombreProducto + "': ");
				precio = scanner.nextDouble();
				scanner.nextLine();

				carrito.add(new Producto(nombreProducto, cantidad, precio));
			}
		} while (!nombreProducto.equalsIgnoreCase("fin"));

		System.out.print("Ingrese el porcentaje de IVA a aplicar (4 o 21): ");
		int porcentajeIVA = scanner.nextInt();

		if (porcentajeIVA != 4 && porcentajeIVA != 21) {
			System.out.println("Error: Porcentaje de IVA no válido. Se aplicará el 21% por defecto.");
			porcentajeIVA = 21;
		}

		double iva = porcentajeIVA / 100.0;
		double precioTotalBruto = calcularPrecioTotal(carrito);
		double precioTotalConIVA = precioTotalBruto * (1 + iva);

		System.out.println("\nInformación de la Venta:");
		System.out.println("IVA Aplicado: " + porcentajeIVA + "%");
		System.out.println("Precio Total Bruto: " + precioTotalBruto + " €");
		System.out.println("Precio Total con IVA: " + precioTotalConIVA + " €");
		System.out.println("Número de Artículos Comprados: " + carrito.size());

		System.out.print("Ingrese la cantidad pagada por el cliente: ");
		double cantidadPagada = scanner.nextDouble();

		double cambio = cantidadPagada - precioTotalConIVA;
		System.out.println("Cambio a Devolver: " + cambio + " €");

		scanner.close();
	}

		// Parte del código del segundo archivo
		
		public static void usarMenuGestionProductos(String[] args) {
		Map<String, Map<String, Object>> productosMap = new HashMap<>();
		baseDeDatos(productosMap);
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n---- Menú Principal ----");
			System.out.println("\n--- Que Quieres Hacer? ---");
			System.out.println("1. Añadir artículo");
			System.out.println("2. Consultar artículo");
			System.out.println("3. Listar todos los artículos");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");

			String opcion = scanner.nextLine();

			switch (opcion) {
			case "1":
				anadirArticulo(productosMap, scanner);
				break;
			case "2":
				consultarArticulo(productosMap, scanner);
				break;
			case "3":
				mostrarListaProductos(productosMap);
				break;
			case "4":
				System.out.println("¡Hasta luego!");
				System.exit(0);
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		}
	}

	private static double calcularPrecioTotal(List<Producto> carrito) {
		double precioTotal = 0;
		for (Producto producto : carrito) {
			precioTotal += producto.getCantidad() * producto.getPrecio();
		}
		return precioTotal;
	}

	private static class Producto {
		private String nombre;
		private double cantidad;
		private double precio;

		public Producto(String nombre, double cantidad, double precio) {
			this.nombre = nombre;
			this.cantidad = cantidad;
			this.precio = precio;
		}

		public double getCantidad() {
			return cantidad;
		}

		public double getPrecio() {
			return precio;
		}
	}

	public static void baseDeDatos(Map<String, Map<String, Object>> productosMap) {
		Map<String, Object> datosProductos = new HashMap<>();

		datosProductos.put("cantidad", 10);
		datosProductos.put("precio", 10.5);
		productosMap.put("producto1", datosProductos);

		datosProductos = new HashMap<>();
		datosProductos.put("cantidad", 5);
		datosProductos.put("precio", 20.75);
		productosMap.put("producto2", datosProductos);

	}

	private static void consultarArticulo(Map<String, Map<String, Object>> productosMap, Scanner scanner) {
		System.out.print("Introduzca el producto que este buscando: ");
		String nombreProducto = scanner.nextLine();

		if (!productosMap.containsKey(nombreProducto)) {
			System.out.println("El producto no existe en la base de datos.");
			return;
		}

	}

	public static void mostrarListaProductos(Map<String, Map<String, Object>> productosMap) {
		System.out.println("Lista de todos los productos:");
		for (Map.Entry<String, Map<String, Object>> entry : productosMap.entrySet()) {
			String producto = entry.getKey();
			if (!producto.startsWith("producto")) {
				Map<String, Object> datos = entry.getValue();
				int cantidad = (int) datos.get("cantidad");
				double precio = (double) datos.get("precio");

				System.out.println("Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: €" + precio);
			}
		}
	}

	private static void anadirArticulo(Map<String, Map<String, Object>> productosMap, Scanner scanner) {
		System.out.print("Introduzca el nombre del nuevo producto: ");
		String nombreProducto = scanner.nextLine();

		if (productosMap.containsKey(nombreProducto)) {
			System.out.println("El producto ya existe en la base de datos.");
			return;
		}

		Map<String, Object> datosProducto = new HashMap<>();

		System.out.print("Introduzca la cantidad del producto: ");
		int cantidad = scanner.nextInt();
		scanner.nextLine();
		datosProducto.put("cantidad", cantidad);

		System.out.print("Introduzca el precio del producto: ");
		double precio = scanner.nextDouble();
		scanner.nextLine();
		datosProducto.put("precio", precio);

		productosMap.put(nombreProducto, datosProducto);

		System.out.println("Producto añadido correctamente.");

	}
}
