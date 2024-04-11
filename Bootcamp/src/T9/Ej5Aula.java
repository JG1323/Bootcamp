package T9;

public class Ej5Aula {
	private int id;
    private int capacidadMaxima;
    private String asignatura;
    private Ej5Profesor profesor;
    private Ej5Estudiante[] estudiantes;
    private int numEstudiantes;


    public Ej5Aula(int id, int capacidadMaxima, String asignatura, Ej5Profesor profesor) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.asignatura = asignatura;
        this.profesor = profesor;
        this.estudiantes = new Ej5Estudiante[capacidadMaxima];
        this.numEstudiantes = 0;
    }

   
    public void agregarEstudiante(Ej5Estudiante estudiante) {
        if (numEstudiantes < capacidadMaxima) {
            estudiantes[numEstudiantes++] = estudiante;
        } else {
            System.out.println("El aula está llena, no se puede agregar más estudiantes.");
        }
    }

   
    public boolean puedeDarClase() {
       
        if (!profesor.estaDisponible()) {
            return false;
        }

      
        if (!profesor.getMateria().equalsIgnoreCase(asignatura)) {
            return false;
        }

     
        int numAsistentes = 0;
        for (Ej5Estudiante estudiante : estudiantes) {
            if (estudiante != null && !estudiante.haceNovillos()) {
                numAsistentes++;
            }
        }
        return numAsistentes > (capacidadMaxima / 2);
    }

   
    public void contarEstudiantesAprobados() {
        int numAprobadosHombres = 0;
        int numAprobadasMujeres = 0;

        for (Ej5Estudiante estudiante : estudiantes) {
            if (estudiante != null && estudiante.getCalificacion() >= 5) {
                if (estudiante.getSexo().equalsIgnoreCase("masculino")) {
                    numAprobadosHombres++;
                } else if (estudiante.getSexo().equalsIgnoreCase("femenino")) {
                    numAprobadasMujeres++;
                }
            }
        }

        System.out.println("Estudiantes aprobados:");
        System.out.println("Hombres: " + numAprobadosHombres);
        System.out.println("Mujeres: " + numAprobadasMujeres);
    }
}
