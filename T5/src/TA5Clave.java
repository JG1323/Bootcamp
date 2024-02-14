import java.util.Scanner;

public class TA5Clave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("¿Contraseña?");
		
		Scanner scanner = new Scanner(System.in);
				int intentos=3;
				
		while (intentos>0) {
			System.out.println("Introduzca su contraseña:");
			String contraseñaIngresada= scanner.nextLine();
		
//			contraseña="contraseñaCorrecta";
			
			String contraseñaCorrecta="1234";
			
			if (contraseñaIngresada.equals(contraseñaCorrecta)){ 
				System.out.println("Contraseña aceptada");
				break;
			} else {
				intentos--;
				System.out.println("Contraseña incorrecta. Itentos restantes:" + intentos);
			if (intentos ==0) {
				System.out.println("Has agotado todos los intentos. Acceso denegado");
				
			scanner.close();
			}
		}
			
	}
}
}