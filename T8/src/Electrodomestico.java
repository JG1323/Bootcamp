import java.util.Arrays;
import java.util.List;
	
public class Electrodomestico {
	  
	    private static final List<String> COLORES_DISPONIBLES = Arrays.asList("blanco", "negro", "rojo", "azul", "gris");
	    private static final List<String> CONSUMO_ENERGETICO_VALIDO = Arrays.asList("A", "B", "C", "D", "E", "F");
	    private static final double PRECIO_BASE_DEFECTO = 100;
	    private static final String COLOR_DEFECTO = "blanco";
	    private static final String CONSUMO_ENERGETICO_DEFECTO = "F";
	    private static final double PESO_DEFECTO = 5;

	    
	    private double precioBase;
	    private String color;
	    private String consumoEnergetico;
	    private double peso;

	    // Constructores
	    public Electrodomestico() {
	        this(PRECIO_BASE_DEFECTO, PESO_DEFECTO, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFECTO);
	    }

	    public Electrodomestico(double precio, double peso) {
	        this(precio, peso, COLOR_DEFECTO, CONSUMO_ENERGETICO_DEFECTO);
	    }

	    public Electrodomestico(double precioBase, double peso, String color, String consumoEnergetico) {
	        this.precioBase = precioBase;
	        this.color = validarColor(color);
	        this.consumoEnergetico = validarConsumoEnergetico(consumoEnergetico);
	        this.peso = peso;
	    }

	    // Métodos para validación
	    private String validarColor(String color) {
	        String colorValidado = color.toLowerCase();
	        if (COLORES_DISPONIBLES.contains(colorValidado)) {
	            return colorValidado;
	        } else {
	            return COLOR_DEFECTO;
	        }
	    }

	    private String validarConsumoEnergetico(String consumo) {
	        String consumoValidado = consumo.toUpperCase();
	        if (CONSUMO_ENERGETICO_VALIDO.contains(consumoValidado)) {
	            return consumoValidado;
	        } else {
	            return CONSUMO_ENERGETICO_DEFECTO;
	        }
	    }

	   
	    public void mostrarDetalles() {
	        System.out.println("Precio: " + precioBase + " €");
	        System.out.println("Color: " + color);
	        System.out.println("Consumo energético: " + consumoEnergetico);
	        System.out.println("Peso: " + peso + " kg");
	    }

	    
	    public static void main(String[] args) {
	        Electrodomestico electrodomestico1 = new Electrodomestico();
	        electrodomestico1.mostrarDetalles();

	        Electrodomestico electrodomestico2 = new Electrodomestico(150, 8);
	        electrodomestico2.mostrarDetalles();

	        Electrodomestico electrodomestico3 = new Electrodomestico(200, 10, "rojo", "A");
	        electrodomestico3.mostrarDetalles();
	    }
	}