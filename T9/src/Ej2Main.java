
public class Ej2Main {
	public static void main(String[] args) {

		 // Crear arrays de Series y Videojuegos
       Ej2Serie[] series = new Ej2Serie[5];
       Ej2Videojuego[] videojuegos = new Ej2Videojuego[5];

       // Crear objetos en cada posición del array
       series[0] = new Ej2Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
       series[1] = new Ej2Serie("Game of Thrones", 8, "Fantasía", "David Benioff y D.B. Weiss");
       series[2] = new Ej2Serie("Friends", 10, "Comedia", "David Crane y Marta Kauffman");
       series[3] = new Ej2Serie("Stranger Things", 4, "Ciencia ficción", "Duffer Brothers");
       series[4] = new Ej2Serie("The Office", 9, "Comedia", "Greg Daniels");

       videojuegos[0] = new Ej2Videojuego("The Legend of Zelda: Breath of the Wild", 50, "Aventura", "Nintendo");
       videojuegos[1] = new Ej2Videojuego("Grand Theft Auto V", 30, "Acción", "Rockstar Games");
       videojuegos[2] = new Ej2Videojuego("The Witcher 3: Wild Hunt", 70, "RPG", "CD Projekt");
       videojuegos[3] = new Ej2Videojuego("Red Dead Redemption 2", 60, "Aventura", "Rockstar Games");
       videojuegos[4] = new Ej2Videojuego("Minecraft", 20, "Sandbox", "Mojang Studios");

       // Entregar algunos Videojuegos y Series
       series[0].entregar(); //Seran true
       series[2].entregar();
       videojuegos[1].entregar();
       videojuegos[3].entregar();
       videojuegos[4].entregar();
       
    // Contar cuántos Series y Videojuegos están entregados y devolverlos
       int seriesEntregadas = contarEntregados(series);
//       T9Ej2Serie[] seriesDevueltas = devolverEntregados(series);
       
       System.out.println("Series entregadas: " + seriesEntregadas);

       int videojuegosEntregados = contarEntregados(videojuegos);
//       T9Ej2Videojuego[] videojuegosDevueltos = devolverEntregados(videojuegos);
       
       System.out.println("Videojuegos entregadas: " + videojuegosEntregados);


       // Indicar el Videojuego con más horas estimadas
       Ej2Videojuego videojuegoMasHoras = obtenerVideojuegoMasHoras(videojuegos);
       // Indicar la Serie con más temporadas
       Ej2Serie serieMasTemporadas = obtenerSerieMasTemporadas(series);
       
    // Mostrar resultados
      
       System.out.println("\nEl videojuego con más horas estimadas es: \n" + videojuegoMasHoras);
       System.out.println("\nLa serie con más temporadas es: \n" + serieMasTemporadas);

	}
	
	// Método para contar objetos entregados
   public static int contarEntregados(Ej2Entregable[] entregables) {
       int count = 0;
       for (Ej2Entregable entregable : entregables) {
           if (entregable.isEntregado()) {
               count++;
           }
       }
       return count;
   }

   

   // Método para obtener el videojuego con más horas estimadas
   public static Ej2Videojuego obtenerVideojuegoMasHoras(Ej2Videojuego[] videojuegos) {
   	Ej2Videojuego masHoras = videojuegos[0];
       for (int i = 1; i < videojuegos.length; i++) {
           if (videojuegos[i].getHorasEstimadas() > masHoras.getHorasEstimadas()) {
               masHoras = videojuegos[i];
           }
       }
       return masHoras;
   }

   // Método para obtener la serie con más temporadas
   public static Ej2Serie obtenerSerieMasTemporadas(Ej2Serie[] series) {
   	Ej2Serie masTemporadas = series[0];
       for (int i = 1; i < series.length; i++) {
           if (series[i].getNumeroTemporadas() > masTemporadas.getNumeroTemporadas()) {
               masTemporadas = series[i];
           }
       }
       return masTemporadas;
   }
}
