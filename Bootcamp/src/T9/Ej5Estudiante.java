package T9;

import java.util.Random;

public class Ej5Estudiante extends Ej5Persona {
	private double calificacion;

    
    public Ej5Estudiante(String nombre, int edad, String sexo, int calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.calificacion = calificacion;
    }

   
    public boolean haceNovillos() {
        Random random = new Random();
        return random.nextDouble() < 0.5;
    }

    
    public double getCalificacion() {
        return calificacion;
    }

    public String getSexo() {
        return sexo;
    }
}
