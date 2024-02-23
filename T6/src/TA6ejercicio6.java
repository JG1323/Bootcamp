
public class TA6ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		       
		        System.out.print("Ingrese la dimensión de los arrays: ");
		        int dimension = scanner.nextInt();

		        int[] array1 = new int[dimension];
		        int[] array2 = new int[dimension];

		        
		        rellenarConAleatorios(array1);

		       
		        rellenarConAleatorios(array2);

		        
		        int[] resultado = multiplicarArrays(array1, array2);

		      
		        System.out.println("Contenido del primer array:");
		        mostrarArray(array1);

		        System.out.println("Contenido del segundo array:");
		        mostrarArray(array2);

		        System.out.println("Resultado de la multiplicación:");
		        mostrarArray(resultado);
		    }

	
		    public static void rellenarConAleatorios(int[] array) {
		        Random random = new Random();
		        for (int i = 0; i < array.length; i++) {
		            array[i] = random.nextInt(10); 
		        }
		    }

		   
		    public static int[] multiplicarArrays(int[] array1, int[] array2) {
		        int[] resultado = new int[array1.length];
		        for (int i = 0; i < array1.length; i++) {
		            resultado[i] = array1[i] * array2[i];
		        }
		        return resultado;
		    }

		    
		    public static void mostrarArray(int[] array) {
		        for (int i = 0; i < array.length; i++) {
		            System.out.print(array[i] + " ");
		        }
		        System.out.println();

    }

	

}