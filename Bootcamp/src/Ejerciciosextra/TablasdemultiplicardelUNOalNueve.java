package Ejerciciosextra;
import java.util.Scanner;

public class TablasdemultiplicardelUNOalNueve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

	       
        System.out.print("Ingresa el número para la tabla de multiplicar: ");
        int inicio = scanner.nextInt();

        System.out.println("Ingresa el numero final: ");
        	int fin = scanner.nextInt();
        
        int contador = 1;

        
        System.out.println("Tabla de multiplicar del " + inicio + "al " + fin + ":");

 for (int i= inicio; i <=fin; i++) {
        System.out.println("Tabla de multiplicar del" + i + ":");
        System.out.println("----------------------------------");
        
        int contador2 =1;
        
        while (contador <= 10) {
            
            int resultado = i * contador2;

 System.out.println(inicio + " * " + contador2 + " = " + resultado);
 		
 		contador++;
       
        
        
        }

       
        scanner.close();
    

        
}


	}
	
}



