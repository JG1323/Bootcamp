package T9;

import java.util.ArrayList;
import java.util.Collections;

public class Ej6CineMain {

    private static final int PRECIO_ENTRADA = 7;

    public static void main(String[] args) {

        Asiento[][] asientos = new Asiento[8][9];
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = new Asiento(i, j);
            }
        }

        Pelicula pelicula = generarPeliculaAleatoria();
        System.out.println("Película en proyección:");
        System.out.println("Título: " + pelicula.getTitulo());
        System.out.println("Duración: " + pelicula.getDuracion() + " minutos");
        System.out.println("Edad mínima: " + pelicula.getEdadMinima() + " años");
        System.out.println("Director: " + pelicula.getDirector());
        System.out.println();

        System.out.println("Precio de la entrada: € " + PRECIO_ENTRADA);
        System.out.println();

        ArrayList<Espectador> espectadores = generarEspectadoresAleatorios(72);
        Collections.shuffle(espectadores);

        for (Espectador espectador : espectadores) {
            if (espectador.getEdad() < pelicula.getEdadMinima()) {
                System.out.println(espectador.getNombre() + " no puede entrar debido a que es menor de la edad mínima requerida.");
            } else if (espectador.getDinero() < PRECIO_ENTRADA) {
                System.out.println(espectador.getNombre() + " no puede entrar debido a que no tiene suficiente dinero.");
            } else {
                boolean sentado = false;
                while (!sentado) {
                    int filaAleatoria = (int) (Math.random() * asientos.length);
                    int columnaAleatoria = (int) (Math.random() * asientos[filaAleatoria].length); 

                    if (!asientos[filaAleatoria][columnaAleatoria].isOcupado()) {
                        asientos[filaAleatoria][columnaAleatoria].setOcupado(true);
                        System.out.println(espectador.getNombre() + " se ha sentado en el asiento [" + filaAleatoria + "][" + columnaAleatoria + "]");
                        sentado = true;
                    } else {
                        System.out.println("El asiento [" + filaAleatoria + "][" + columnaAleatoria + "] está ocupado.");
                    }
                }
            }
        }

        int asientosOcupados = contarAsientosOcupados(asientos);
        System.out.println("Número de asientos ocupados: " + asientosOcupados);

    }

    public static Pelicula generarPeliculaAleatoria() {
        Random random = new Random();
        String[] titulos = { "El señor de los anillos", "Titanic", "La La Land", "El Padrino", "Matrix" };
        String[] directores = { "Peter Jackson", "James Cameron", "Damien Chazelle", "Francis Ford Coppola",
                "Lana Wachowski" };
        int[] duraciones = { 180, 195, 128, 175, 136 };
        int[] edadesMinimas = { 12, 18, 14, 18, 16 };

        int indice = random.nextInt(titulos.length);

        return new Pelicula(titulos[indice], duraciones[indice], edadesMinimas[indice], directores[indice]);
    }

    public static ArrayList<Espectador> generarEspectadoresAleatorios(int cantidad) {
        ArrayList<Espectador> espectadores = new ArrayList<>();
        Random random = new Random();

        String[] nombres = { "Juan", "María", "Carlos", "Laura", "Pedro", "Ana", "Diego", "Sofía", "Luis", "Elena",
                "Miguel", "Lucía", "Javier", "Carmen", "Alejandro", "Paula", "David", "Isabel", "Jorge", "Raquel",
                "Francisco", "Eva", "Daniel", "Patricia", "Manuel", "Silvia", "Pablo", "Natalia", "Joaquín", "Beatriz",
                "Fernando", "Cristina", "Adrián", "Lorena", "Rubén", "Marta", "Ángel", "Sara", "Jesús", "Rosa",
                "Alberto", "Clara", "Sergio", "Virginia", "Ignacio", "Mónica", "Óscar", "Elena", "Roberto", "Miriam",
                "Ricardo", "Marina", "Víctor", "Laura", "Gonzalo", "Alicia", "Antonio", "Teresa", "Diego", "Beatriz",
                "Germán", "María José", "Guillermo", "Lorena", "Andrés", "Ana María", "Emilio", "Raquel", "José Luis",
                "Cristina", "Héctor", "Patricia" };

        for (int i = 0; i < cantidad; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];
            int edad = random.nextInt(60) + 5; // Edad entre 5 y 65
            int dinero = random.nextInt(15) + 5; // Dinero entre 5 y 20
            espectadores.add(new Espectador(nombre, edad, dinero));
        }

        return espectadores;
    }

    public static int contarAsientosOcupados(Asiento[][] asientos) {
        int asientosOcupados = 0;
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j].isOcupado()) {
                    asientosOcupados++;
                }
            }
        }
        return asientosOcupados;
    }

}