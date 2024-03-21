import java.util.Random;

public class T8ej2Password  {
	
	private String contraseña;
	private int longitud;
	private static final String LONGITUD_POR_DEFECTO = "8";
	
	public T8ej2Password() {

		this.contraseña= "";
		this.longitud = 0;
}
	public T8ej2Password(String contraseña,int longitud) {

		this.contraseña= contraseña;
		this.longitud = longitud;
	}
	private void generarContraseñaAleatoria() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indice));
        }

        this.contraseña = sb.toString();
    }

    // Método para obtener la contraseña generada
    public String getContraseña() {
        return contraseña;
    }

    // Método para obtener la longitud de la contraseña
    public int getLongitud() {
        return longitud;
    }

    public static void main(String[] args) {
    	
        // Ejemplo de uso de la clase Password
    	T8ej2Password contraseñaPorDefecto = new T8ej2Password();
        System.out.println("Contraseña por defecto (longitud 8): " + contraseñaPorDefecto.getContraseña());

        T8ej2Password contraseñaPersonalizada = new T8ej2Password();
        System.out.println("Contraseña personalizada (longitud 12): " + contraseñaPersonalizada.getContraseña());
    }
}