import java.util.HashMap;
import java.util.Map;

public class TA7ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> estudiantesTechTalent = new HashMap<>();
        estudiantesTechTalent.put("Alejandro", 8);
        estudiantesTechTalent.put("Joel", 9);
        estudiantesTechTalent.put("Adrian", 6);
        estudiantesTechTalent.put("Carlos", 7);
        
        double sumaNotas = 0;
        for (int nota : estudiantesTechTalent.values()) {
            sumaNotas += nota;
        }

        double media = sumaNotas / estudiantesTechTalent.size();
        

        HashMap<String, Double> diccionarioNotaMedia = new HashMap<>();
        diccionarioNotaMedia.put("Media", media);

        System.out.println("Diccionario de nota media: " + diccionarioNotaMedia);
       
	}

}
