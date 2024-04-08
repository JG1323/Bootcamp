package T9;

import java.util.Random;

public class Ej5Profesor extends Ej5Persona {
		
	 private String materia;

	    // Constructor
	    public Ej5Profesor(String nombre, int edad, String sexo, String materia) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.sexo = sexo;
	        this.materia = materia;
	    }

	    // Método para verificar disponibilidad del profesor (20% de no estar disponible)
	    public boolean estaDisponible() {
	        Random random = new Random();
	        return random.nextDouble() > 0.2;
	    }

	    // Método getter
	    public String getMateria() {
	        return materia;
	    }
}
