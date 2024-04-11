package T9;

public class Ej4Raices {
	private double a;
	private double b;
	private double c;

	
	public Ej4Raices(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}


	public double getDiscriminante() {
		return Math.pow(b, 2) - 4 * a * c;
	}

	
	public boolean tieneRaices() {
		return getDiscriminante() > 0;
	}

	
	public boolean tieneRaiz() {
		return getDiscriminante() == 0;
	}

	
	public void calcular() {
		if (tieneRaices()) {
			obtenerRaices();
		} else if (tieneRaiz()) {
			obtenerRaiz();
		} else {
			System.out.println("No tiene soluciones reales.");
		}
	}

	
	public void obtenerRaices() {
		double discriminante = getDiscriminante();
		double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
		double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
		System.out.println("Las raíces son: " + raiz1 + " y " + raiz2);
	}

	
	public void obtenerRaiz() {
			double raizUnica = -b / (2 * a);
			System.out.println("La única raíz es: " + raizUnica);
	}
}