package T5;
import java.util.Scanner;
public class TA5ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

	        System.out.print("Pon el radio del círculo: ");
	        double radio = Double.parseDouble(scanner.nextLine());

	        double area = Math.PI * Math.pow(radio, 2);

	        
	        System.out.println("El área del círculo es: " + area);

	        scanner.close();
	        
	}

}
