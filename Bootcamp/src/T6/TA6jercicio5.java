package T6;
import java.util.Scanner;
public class TA6jercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc= new Scanner(System.in); 
	        System.out.println("Introduce un número:");  
	        String num = sc.nextLine();
	        
	        int numero =Integer.parseInt(num);
	        System.out.println(Binario(numero));
	        
	        sc.close();
	    }

	    public static String Binario(int n1) {
	        String result =""; 
	        int resto; 
	        do {
	            resto= n1%2; 
	            n1= n1/2; 
	            result = resto + result; 
	        }while (n1>0); 
	        
	        return result; 

	}

}
