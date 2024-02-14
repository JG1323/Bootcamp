
public class TA6ConversiondeMoneda {
    public static void main(String[] args) {
        double euros = 10; 
        String monedaDestino = "dolares"; 
        
        convertirMoneda(euros, monedaDestino);
    }
    
    public static void convertirMoneda(double euros, String monedaDestino) {
        double tasaConversion = 0;
        String nombreMoneda = "";
        
        switch (monedaDestino.toLowerCase()) {
            case "dolares":
                tasaConversion = 1.13; 
                nombreMoneda = "dólares";
                break;
         
            default:
                System.out.println("Moneda no válida. Por favor ingrese dolares, yenes o libras.");
                return;
        }
        
        double cantidadConvertida = euros * tasaConversion;
        System.out.println(euros + " euros equivale a " + cantidadConvertida + " " + nombreMoneda + ".");
    }
}
