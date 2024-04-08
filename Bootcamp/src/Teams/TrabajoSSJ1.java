package Teams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TrabajoSSJ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> estudiantesTechTalent = new HashMap<>();
        estudiantesTechTalent.put("Laia", 23);
        estudiantesTechTalent.put("Aurora", 30);
        estudiantesTechTalent.put("Alexandre", 28);
        estudiantesTechTalent.put("Jose", 26);
        estudiantesTechTalent.put("Santos", 24);
        estudiantesTechTalent.put("Manel", 26);
        estudiantesTechTalent.put("Alejandro", 19);
        estudiantesTechTalent.put("Isabel", 18);
        estudiantesTechTalent.put("Toni", 23);
        estudiantesTechTalent.put("Diego", 22);
        estudiantesTechTalent.put("Sebas", 29);
        estudiantesTechTalent.put("Abdel", 20);
        estudiantesTechTalent.put("Joel", 22);
        estudiantesTechTalent.put("Jessica", 26);
        estudiantesTechTalent.put("Ana Maria", 29);

        // Imprimir la lista ordenada alfabéticamente y por edad
        System.out.println("Lista ordenada alfabéticamente y por edad:");
        List<Map.Entry<String, Integer>> listaOrdenada = ordenarEstudiantes(estudiantesTechTalent);
        for (Map.Entry<String, Integer> estudiante : listaOrdenada) {
            System.out.println("Nombre: " + estudiante.getKey() + ", Edad: " + estudiante.getValue());
        }

        // Crear 5 grupos de 3 personas de forma aleatoria
        List<List<Map.Entry<String, Integer>>> gruposAleatorios = distribuirAleatoriamente(listaOrdenada);
        System.out.println("\nGrupos aleatorios:");
        for (int i = 0; i < gruposAleatorios.size(); i++) {
            System.out.println("Grupo " + (i + 1) + ":");
            for (Map.Entry<String, Integer> estudiante : gruposAleatorios.get(i)) {
                System.out.println("Nombre: " + estudiante.getKey() + ", Edad: " + estudiante.getValue());
            }
            System.out.println();
        }
    }

    public static List<Map.Entry<String, Integer>> ordenarEstudiantes(Map<String, Integer> estudiantes) {
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(estudiantes.entrySet());

        // Ordenar la lista por nombre y luego por edad
        Collections.sort(listaOrdenada, (e1, e2) -> {
            int resultado = e1.getKey().compareTo(e2.getKey());
            if (resultado == 0) {
                return Integer.compare(e1.getValue(), e2.getValue());
            }
            return resultado;
        });

        return listaOrdenada;
    }

    public static List<List<Map.Entry<String, Integer>>> distribuirAleatoriamente(List<Map.Entry<String, Integer>> listaOrdenada) {
        List<List<Map.Entry<String, Integer>>> gruposAleatorios = new ArrayList<>();
        Random random = new Random();

        // Mezclar la lista de forma aleatoria
        Collections.shuffle(listaOrdenada);

        // Dividir la lista en 5 grupos de 3 personas
        for (int i = 0; i < listaOrdenada.size(); i += 3) {
            int fin = Math.min(i + 3, listaOrdenada.size());
            gruposAleatorios.add(new ArrayList<>(listaOrdenada.subList(i, fin)));
        }

        return gruposAleatorios;

	}

}
