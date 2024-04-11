package T9;

public class Ej5Main {
	public static void main(String[] args) {
		
		Ej5Profesor profesor = new Ej5Profesor("Profesor1", 40, "masculino", "matemáticas");
		Ej5Estudiante estudiante1 = new Ej5Estudiante("Estudiante1", 20, "masculino", 7);
		Ej5Estudiante estudiante2 = new Ej5Estudiante("Estudiante2", 21, "femenino", 4);
		Ej5Estudiante estudiante3 = new Ej5Estudiante("Estudiante3", 22, "masculino", 6);

		
		Ej5Aula aula = new Ej5Aula(1, 20, "matemáticas", profesor);

		
		aula.agregarEstudiante(estudiante1);
		aula.agregarEstudiante(estudiante2);
		aula.agregarEstudiante(estudiante3);

		
		if (aula.puedeDarClase()) {
			System.out.println("Se puede dar clase en el aula.");
		
			aula.contarEstudiantesAprobados();
		} else {
			System.out.println("No se puede dar clase en el aula.");
		}
	}
}