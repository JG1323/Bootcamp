import java.util.Scanner;
public class TA5ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
			System.out.print("Pon un número: ");
        
		int numero = scanner.nextInt();

       
        if (numero % 2 == 0) {
            System.out.println(numero + " es divisible entre 2.");
        } else {
            System.out.println(numero + " no es divisible entre 2.");
        }

        scanner.close();

	}

}
