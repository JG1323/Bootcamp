
public class Television extends Electrodomestico1{
	
	private static final double RESOLUCION_DEFAULT = 20;
    private static final boolean SINTONIZADOR_TDT_DEFAULT = false;
    private static final double PORCENTAJE_INCREMENTO_RESOLUCION = 0.3;
    private static final double PRECIO_INCREMENTO_SINTONIZADOR_TDT = 50;

    // Atributos
    private double resolucion;
    private boolean sintonizadorTDT;

    // Constructores
    public Television() {
    	this.precioBase=PRECIO_BASE_DEFECTO;
    	this.peso=PESO_DEFECTO;
    	this.color=COLOR_DEFECTO;
    	this.consumoEnergetico=CONSUMO_ENERGETICO_DEFECTO;
    	this.resolucion=RESOLUCION_DEFAULT;
    	this.sintonizadorTDT = SINTONIZADOR_TDT_DEFAULT;
    }

}
