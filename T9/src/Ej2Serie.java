
public class Ej2Serie {


	private String titulo;
	private int numerotemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
		
	
	public Ej2Serie() {

		this.titulo = "";
		this.numerotemporadas = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = "";
	
	}
	public Ej2Serie(String titulo, String creador) {

		this.titulo = titulo;
		this.numerotemporadas = 3;
		this.entregado = entregado;
		this.genero = "";
		this.creador = creador;
	 
	} 
	
	public Ej2Serie(String titulo, String creador,String temporadas, String genero ) {

		this.titulo = titulo;
		this.numerotemporadas = 3;
		this.entregado = false;
		this.genero = genero;
		this.creador = creador;
	 
	}
	
	// Métodos getter y setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumTemporadas() {
        return numerotemporadas;
    }

    public void setNumtemporadas(String temporadas) {
        this.numerotemporadas = numerotemporadas;
    }

    public boolean isEntregado1() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }
    
    public void setCreador(String creador) {
        this.creador = creador;
    }

    // Método toString para imprimir los detalles de la serie
    
  
    public String toString() {
        return "Título: " + titulo +
                "\nNúmero de temporadas: " + numerotemporadas +
                "\nEntregado: " + (entregado ? "Sí" : "No") +
                "\nGénero: " + genero +
                "\nCreador: " + creador;
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
		Ej2Serie otherSerie = (Ej2Serie) o;
        return Integer.compare(this.numerotemporadas, otherSerie.getNumTemporadas());
    }
}