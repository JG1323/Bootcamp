
public class Lavadora extends Electrodomestico1 {
	
	   
	    private static final double CARGA_DEFAULT = 5;

	    
	    private double carga;

	
	    public Lavadora() {
	    	this.precioBase= PRECIO_BASE_DEFECTO;
	    	this.peso=PESO_DEFECTO;
	    	this.color=COLOR_DEFECTO;
	    	this.consumoEnergetico=CONSUMO_ENERGETICO_DEFECTO;
	    	this.carga =CARGA_DEFAULT;
	    }

	    public Lavadora(double precioBase, double peso) {
	    	this.precioBase=precioBase;
	    	this.peso=peso;
	    	this.color=COLOR_DEFECTO;
	    	this.consumoEnergetico=CONSUMO_ENERGETICO_DEFECTO;
	    	this.carga =CARGA_DEFAULT;
	    }

	    public Lavadora(double carga, double precioBase, double peso, String color, char consumoEnergetico) {
	        super();
	        this.carga = carga;
	    }

	    
	    public double getCarga() {
	        return carga;
	    }

	    
	    @Override
	    public double precioFinal() {
	        double precioFinal = super.precioFinal();

	        if (carga > 30) {
	            precioFinal += 50;
	        }

	        return precioFinal;
	    }

	}