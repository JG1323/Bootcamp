package T10;

public class ExcepcionCustomizadaApp {

	public static void main(String[] args) {

		boolean excepcionCapturada = false;

		while (!excepcionCapturada) {
			try {
				System.out.println("Texto mostrado por pantalla.");
				throw new ExcepcionCustomizada("Esto es un objeto Excepcion.");
			} catch (ExcepcionCustomizada e) {
				System.out.println("Excepcion capturada por texto: " + e.getMensaje());
				excepcionCapturada = true;	
			} finally {
				System.out.println("Fin.");
			}
		}
	}
}