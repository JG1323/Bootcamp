import java.util.Scanner;

public class arr4ys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

 Scanner scanner = new Scanner(System.in);
 
  String[] participantes = new String[3];
  
   for (int i = 0; i < participantes.length; i++) {
	   
	  System.out.println("Pon el nombre del participante " + (i + 1) + ":");
	  
	participantes[i] = scanner.nextLine();
	
	        }
	        scanner.close();
	        
  System.out.println("\nLos participantes son:");
  
	 for (String participante : participantes) {
		 
	     System.out.println(participante);
	     
	     
	        }
	
	 System.out.println("\nEligiendo ganador...");
	 
	 	int indiceGanador = (int) (Math.random() * participantes.length);
	 	
	        String ganador = participantes[indiceGanador];
	        
	        System.out.println("El ganador es: " + ganador );
	        
	    }
	
	
	{	
		}

}
