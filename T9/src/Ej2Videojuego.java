
public class Ej2Videojuego implements Ej2Entregable {

	private String titulo;
	private int horasEstimadas;
	private boolean entregado;
	private String genero;
	private String compañia;

	public Ej2Videojuego() {
		this.horasEstimadas = 10;
		this.entregado = false;
		this.genero = "";
		this.compañia = "";
	}

	public Ej2Videojuego(String titulo, int horasEstimadas) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.genero = "";
		this.compañia = "";
	}

	public Ej2Videojuego(String titulo, int horasEstimadas, String genero, String compañia) {
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.compañia = compañia;
		this.entregado = false;
	}

	// Métodos Get
	public String getTitulo() {
		return titulo;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public String getGenero() {
		return genero;
	}

	public String getCompañia() {
		return compañia;
	}

	// Métodos Set
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	@Override
	public String toString() {
		return "Videojuego{" + "titulo='" + titulo + '\'' + ", horasEstimadas=" + horasEstimadas + ", entregado="
				+ entregado + ", genero='" + genero + '\'' + ", compañia='" + compañia + '\'' + '}';
	}

	public void entregar() {
		this.entregado = true;
	}

	public void devolver() {
		this.entregado = false;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public int compareTo(Object o) {
		Ej2Videojuego otherVideojuego = (Ej2Videojuego) o;
		return Integer.compare(this.horasEstimadas, otherVideojuego.getHorasEstimadas());
	}
}
