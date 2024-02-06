import java.util.Scanner;

public class TA52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		System.out.println("¿Nombre?");
		String name= sc.nextLine();
		sc.close();

		
		System.out.println("Bienvenido " + name.toUpperCase());
			
	}

}
