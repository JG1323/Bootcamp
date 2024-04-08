package T5;
import java.util.Scanner;
public class TA5ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        
        System.out.print("Pon las ventas que quieres: ");
        int numVentas = sc.nextInt();

        double ventas = 0;

        
        for (int i = 1; i <= numVentas; i++) {
            System.out.print("Pon la venta " + i + ": ");
            double venta = sc.nextDouble();
            ventas += venta;
        }

       
        System.out.println("El total de las ventas es: " + ventas);

        sc.close();
    }
	
}
