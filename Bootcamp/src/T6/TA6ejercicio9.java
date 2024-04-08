package T6;
import java.util.Scanner;
import java.util.Random;
public class TA6ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Pon el tamaño del array: ");
	        int tamaño = sc.nextInt();

	        
	        int[] numeros = new int[tamaño];

	        
	        Random random = new Random();

	        
	        for (int i = 0; i < numeros.length; i++) {
	            numeros[i] = random.nextInt(10);
	        }
	       int suma = 0;
	       
	        System.out.println("Valores del array:");
	        
	        for (int i = 0; i < numeros.length; i++) {
	        	
	            System.out.println("Número en la posición " + i + ": " + numeros[i]);
	            suma += numeros[i];
	        }
	        System.out.println("La suma de todos es: " + suma);
	        
	        sc.close(); 
	}

}
