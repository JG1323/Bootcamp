package T10;

import java.util.Scanner;

public class Password {

	private int longitud;
	private String contraseña;

	public Password() {
		this.longitud = 8;
		generarPassword();
	}

	public Password(int longitud) {
		this.longitud = longitud;
		generarPassword();
	}

	public boolean esFuerte() {
		int mayusculas = 0, minusculas = 0, numeros = 0;
		for (char c : contraseña.toCharArray()) {
			if (Character.isUpperCase(c)) {
				mayusculas++;
			} else if (Character.isLowerCase(c)) {
				minusculas++;
			} else if (Character.isDigit(c)) {
				numeros++;
			}
		}
		return (mayusculas > 2 && minusculas > 1 && numeros > 5);
	}

	public void generarPassword() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < longitud; i++) {
			int tipo = (int) (Math.random() * 3);

			switch (tipo) {
			case 0:
				sb.append((char) ('A' + Math.random() * 26));
				break;
			case 1:
				sb.append((char) ('a' + Math.random() * 26));
				break;
			case 2:
				sb.append((char) ('0' + Math.random() * 10));
				break;
			}
		}
		contraseña = sb.toString();
	}

	public String getContraseña() {
		return contraseña;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
		generarPassword();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int longitud;
			while (true) {

				System.out.print("Pon la longitud de la contraseña: ");
				String input = scanner.next();
				try {
					longitud = Integer.parseInt(input);
					if (longitud <= 0) {
						throw new IllegalArgumentException("La longitud debe ser mayor que 0.");
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Error: Introduce un número válido.");
				} catch (IllegalArgumentException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}

			// Crear array de Passwords
			System.out.print("¿Cuantas contraseñas quieres CREAR?\n");
			int tamañoArray = scanner.nextInt();
			if (tamañoArray <= 0) {
				throw new IllegalArgumentException("La longitud de la contraseña tiene que ser mayor de 0.");
			}
			Password[] passwords = new Password[tamañoArray];
			for (int i = 0; i < tamañoArray; i++) {
				passwords[i] = new Password(longitud);
			}

			boolean[] esFuerteArray = new boolean[tamañoArray];

			for (int i = 0; i < tamañoArray; i++) {
				esFuerteArray[i] = passwords[i].esFuerte();
			}

			for (int i = 0; i < tamañoArray; i++) {
				System.out.println("La contraseña es: " + passwords[i].getContraseña() + " " + esFuerteArray[i]);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
