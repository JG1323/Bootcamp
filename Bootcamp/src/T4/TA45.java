package T4;

public class TA45 {

		// TODO Auto-generated method stub
		   public static void main(String[] args) {
		        // TODO Auto-generated method stub
		      
			   
			   int A = 98;
		        int B = 21;
		        int C = 65;
		        int D = 47;

		        System.out.println("El valor de A es " + A);
		        System.out.println("El valor de B es " + B);
		        System.out.println("El valor de C es " + C);
		        System.out.println("El valor de D es " + D);

		        B = B + C;
		        C = B - C;
		        B = B - C;

		        C = C + A;
		        A = C - A;
		        C = C - A;

		        A = A + D;
		        D = A - D;
		        A = A - D;

		        System.out.println("El valor A es ahora " + A);
		        System.out.println("El valor B es ahora  " + B);
		        System.out.println("El valor C es ahora " + C);
		        System.out.println("El valor D es ahora " + D);
		        
		        
		    }

		
	}

