package T9;

import java.util.Random;

public class Ej5Profesor extends Ej5Persona {
		
	 private String materia;

	    
	    public Ej5Profesor(String nombre, int edad, String sexo, String materia) {
	        this.nombre = nombre;
	        this.edad = edad;
	        this.sexo = sexo;
	        this.materia = materia;
	    }

	    
	    public boolean estaDisponible() {
	        Random random = new Random();
	        return random.nextDouble() > 0.2;
	    }

	 
	    public String getMateria() {
	        return materia;
	    }
}
