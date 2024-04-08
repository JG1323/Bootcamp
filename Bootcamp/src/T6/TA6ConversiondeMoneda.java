package T6;
import java.util.Scanner;

public class TA6ConversiondeMoneda {
	public static void main(String[] args) {
		 Scanner Scanner= new Scanner(System.in); 
		 
	        System.out.println("Introduce la cantidad que quieres convertir:");  
	        int dolares = Scanner.nextInt();
	        
	        double euros = 10;
		String monedaDestino = "dolares";

		convertirMoneda(euros, monedaDestino);
		
		Scanner.close();
	}

	public static void convertirMoneda(double euros, String monedaDestino) {
		double tasaConversion = 0;
		String nombreMoneda = "";

		switch (monedaDestino.toLowerCase()) {
		case "dolares":
			tasaConversion = 1.13;
			nombreMoneda = "dólares";
			break;

		default:
			System.out.println("Moneda incorrecta. Pon dolares, yenes o libras.");
			return;
		}

		double cantidadConvertida = euros * tasaConversion;
		System.out.println(euros + " euros equivale a " + cantidadConvertida + " " + nombreMoneda + ".");
	}

}