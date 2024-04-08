package T6;
import java.util.Scanner;

public class TA6ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int matri[] = new int[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un valor:");

	
		 
		for (int i=0; i<10; i++) {
			int numero = sc.nextInt();
			matri[i]=numero;
		}
		System.out.println(matri[6]);
		
		sc.close();

	}

}
