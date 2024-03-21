
public class Serie {

	private String titulo;
	private String temporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	private static final String Numero_de_temporadas_por_defecto="3";
	
	
	public Serie() {

		this.titulo = "";
		this.temporadas = Numero_de_temporadas_por_defecto;
		this.entregado = false;
		this.genero = "";
		this.creador = "";
	
	}
	public Serie(String titulo, String creador) {

		this.titulo = titulo;
		this.temporadas = Numero_de_temporadas_por_defecto;
		this.entregado = entregado;
		this.genero = "";
		this.creador = creador;
	 
	} 
	
	public Serie(String titulo, String creador,String temporadas, String genero ) {

		this.titulo = titulo;
		this.temporadas = temporadas;
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

    public String getNumTemporadas() {
        return temporadas;
    }

    public void setNumtemporadas(String temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isEntregado() {
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
    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nNúmero de temporadas: " + temporadas +
                "\nEntregado: " + (entregado ? "Sí" : "No") +
                "\nGénero: " + genero +
                "\nCreador: " + creador;
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        Serie serie1 = new Serie("Vikingos", "Michael Hirst");
        Serie serie2 = new Serie("Top Boy", "Ronan Bennett");
        Serie serie3 = new Serie("Game of Thrones", "Fantasía");

        System.out.println("Serie 1:");
        System.out.println(serie1);

        System.out.println("\nSerie 2:");
        System.out.println(serie2);

        System.out.println("\nSerie 3:");
        System.out.println(serie3);
    }
}
