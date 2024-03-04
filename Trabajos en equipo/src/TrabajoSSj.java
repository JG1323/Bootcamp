import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
public class TrabajoSSj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Crear un HashMap con clave de tipo String y valor de tipo Integer
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

        System.out.println("Información de alumnos:");
        for (Map.Entry<String, Integer> entry : estudiantesTechTalent.entrySet()) {
            System.out.println("Nombre " + entry.getKey() + ", Edad: " + entry.getValue());
        }

        // Formar aleatoriamente 5 grupos de 3 personas
        List<Map<String, Integer>> grupos = formarGrupos(estudiantesTechTalent);

        // Mostrar los grupos formados
        mostrarGrupos(grupos);
    }

    private static List<Map<String, Integer>> formarGrupos(Map<String, Integer> estudiantes) {
        List<Map<String, Integer>> grupos = new ArrayList<>(5);

        List<Map.Entry<String, Integer>> listaEstudiantes = new ArrayList<>(estudiantes.entrySet());

        // Usar un objeto Random para seleccionar estudiantes aleatorios
        Random random = new Random();

        while (!listaEstudiantes.isEmpty()) {
            Map<String, Integer> grupoMap = new LinkedHashMap<>();

            // Seleccionar aleatoriamente 3 estudiantes para el grupo
            for (int i = 0; i < 3 && !listaEstudiantes.isEmpty(); i++) {
                int index = random.nextInt(listaEstudiantes.size());
                Map.Entry<String, Integer> entry = listaEstudiantes.remove(index);
                grupoMap.put(entry.getKey(), entry.getValue());
            }

            grupos.add(grupoMap);
        }

        return grupos;
    }

    private static void mostrarGrupos(List<Map<String, Integer>> grupos) {
        System.out.println("\nGrupos formados:");

        for (int i = 0; i < grupos.size(); i++) {
            System.out.println("Grupo " + (i + 1) + ":");
            for (Map.Entry<String, Integer> entry : grupos.get(i).entrySet()) {
                System.out.println("Nombre: " + entry.getKey() + ", Edad: " + entry.getValue());
            }
            System.out.println();
        }

	}

}
