package T8;
import java.util.Random;

public class Password  {
	
	private String contraseña;
	private int longitud;
	private static final int LONGITUD_POR_DEFECTO = 8;
	
	public Password() {

		this.contraseña= "";
		this.longitud = LONGITUD_POR_DEFECTO;
}
	public Password(String contraseña,int longitud) {

		this.contraseña= contraseña;
		this.longitud = longitud;
	}

	    // Método para generar una contraseña aleatoria
	    public String generarContraAleatoria() {
	        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder sb = new StringBuilder();

	        Random random = new Random();
	        for (int i = 0; i < longitud; i++) {
	            int indice = random.nextInt(caracteres.length());
	            sb.append(caracteres.charAt(indice));
	        }

	        return sb.toString();
	    }

	    public static void main(String[] args) {
	    	
	        Password contraseña = new Password();
	        System.out.println("Contraseña generada: " + contraseña.generarContraAleatoria());
	    }
	}