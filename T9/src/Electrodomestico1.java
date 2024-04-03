public class Electrodomestico1 {
    protected double precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    protected static final String[] COLORES_DISPONIBLES = {"blanco", "negro", "rojo", "azul", "gris"};
    protected static final char[] CONSUMOS_ENERGETICOS = {'A', 'B', 'C', 'D', 'E', 'F'};
    protected static final double PRECIO_BASE_DEFECTO = 100.0;
    protected static final String COLOR_DEFECTO = "blanco";
    protected static final char CONSUMO_ENERGETICO_DEFECTO = 'F';
    protected static final double PESO_DEFECTO = 5.0;

    public Electrodomestico1() {
        this.precioBase = PRECIO_BASE_DEFECTO;
        this.color = COLOR_DEFECTO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
        this.peso = PESO_DEFECTO;
    }

    public Electrodomestico1(double precioBase, double peso) {
        this();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Electrodomestico1(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        comprobarColor(color);
        comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    private void comprobarConsumoEnergetico(char letra) {
        for (char c : CONSUMOS_ENERGETICOS) {
            if (Character.toUpperCase(letra) == c) {
                this.consumoEnergetico = Character.toUpperCase(letra);
                return;
            }
        }
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEFECTO;
    }

    private void comprobarColor(String color) {
        for (String c : COLORES_DISPONIBLES) {
            if (color.equalsIgnoreCase(c)) {
                this.color = color.toLowerCase();
                return;
            }
        }
        this.color = COLOR_DEFECTO;
    }

    public double precioFinal() {
        double precioFinal = precioBase;
        switch (consumoEnergetico) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 50;
                break;
            case 'E':
                precioFinal += 30;
                break;
            case 'F':
                precioFinal += 10;
                break;
        }
        if (peso >= 0 && peso < 20) {
            precioFinal += 10;
        } else if (peso >= 20 && peso < 50) {
            precioFinal += 50;
        } else if (peso >= 50 && peso < 80) {
            precioFinal += 80;
        } else if (peso >= 80) {
            precioFinal += 100;
        }
        return precioFinal;
    }
    
    @Override
    public String toString() {
        return "Precio base: " + precioBase + " €\nColor: " + color + "\nConsumo energético: " + consumoEnergetico + "\nPeso: " + peso + " kg";
    }


}