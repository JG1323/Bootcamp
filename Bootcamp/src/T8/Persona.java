package T8;

public class Persona {

	private String nombre;
	private int edad;
	private String dni;
	private char sexo;
	private double peso;
	private double altura;

	private static final char SEXO_POR_DEFECTO = 'H';

	public Persona() {

		this.nombre = "";
		this.edad = 0;
		this.dni = generarDNI();
		this.sexo = SEXO_POR_DEFECTO;
		this.peso = 0;
		this.altura = 0;
	}

	public Persona(String nombre, int edad, char sexo)

	{

		this.nombre = nombre;
		this.edad = edad;
		this.dni = generarDNI();
		this.sexo = sexo;
		this.peso = 0;
		this.altura = 0;
	}

	public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = DNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

// Método privado para generar un DNI aleatorio
	private String generarDNI() {

//    DNI aleatorio
		return "49679537C";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
	return altura;

	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Persona{" + "nombre='" + nombre + '\'' + ", edad=" + edad + ", sexo='" + sexo + '\'' + '}';
	}

}