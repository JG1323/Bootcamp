package T9;

public class Ej3LibroMain {
	public static void main(String[] args) {
	}
	
    public static Ej3Libro libroConMasPaginas(Ej3Libro libro1, Ej3Libro libro2) {
        if (libro1.getNumeroPaginas() > libro2.getNumeroPaginas()) {
            return libro1;
        } else if (libro1.getNumeroPaginas() < libro2.getNumeroPaginas()) {
            return libro2;
        } else {
            return null; 
        }
    }
}
