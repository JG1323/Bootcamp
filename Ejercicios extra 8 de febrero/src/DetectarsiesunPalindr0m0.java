import java.util.Scanner;

public class DetectarsiesunPalindr0m0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String palin="zorra, arroz";
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Introduzca una cadena para saber si es palindromo:");
		
	String input= scanner.nextLine();

		if (esPalindromo(input)) {
			System.out.println("Es palíndromo" + palin);
		} else {
				System.out.println("No es un palíndromo");
			}
		scanner.close();
	}
	
	private static boolean esPalindromo(String cadena) {
		// TODO Auto-generated method stub
		cadena = cadena.replaceAll("s+","").toLowerCase();
		return cadena.equals(new StringBuilder(cadena).reverse().toString());
	}
		
	} 
