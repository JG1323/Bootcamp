import java.util.Scanner;
public class TA6ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner sc = new Scanner(System.in);
		        System.out.print("Pon un número entero positivo: ");
		        int numero = sc.nextInt();

		        if (esPrimo(numero)) {
		            System.out.println(numero + " es un número primo.");
		        } else {
		            System.out.println(numero + " no es un número primo.");
		           
		        
		  } 
		        
		        sc.close();  }

		    
		    public static boolean esPrimo(int numero) {
		        if (numero <= 1) {
		            return false;
		        }
		        for (int i = 2; i <= Math.sqrt(numero); i++) {
		            if (numero % i == 0) {
		                return false;
		            }
		        }
		        return true; 
		    
		}

	}