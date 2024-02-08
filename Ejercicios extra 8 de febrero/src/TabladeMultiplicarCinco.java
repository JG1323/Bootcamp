import java.util.Scanner;

public class TabladeMultiplicarCinco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner scanner = new Scanner(System.in);

		       
		        System.out.print("Ingresa el número para la tabla de multiplicar: ");
		        int numero = scanner.nextInt();

		       
		        int contador = 1;

		        
		        System.out.println("Tabla de multiplicar del " + numero + ":");

		 
		        while (contador <= 10) {
		            
		            int resultado = numero * contador;

         System.out.println(numero + " * " + contador + " = " + resultado);

		          
		            contador++;
		        }

		       
		        scanner.close();
		    
		
	}

}
