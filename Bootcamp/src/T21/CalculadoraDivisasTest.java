package T21;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraDivisasTest {

    @Test
    public void testConvertCurrencyValidInput() {
        ConversorDivisas conversor = new ConversorDivisas();
        String result = conversor.convertCurrency("100");
        assertEquals("100.00 dólares = 85.00 euros     100.00 euros = 117.00 dólares", result);
    }

    @Test
    public void testConvertCurrencyInvalidInput() {
        ConversorDivisas conversor = new ConversorDivisas();
        String result = conversor.convertCurrency("abc");
        assertEquals("¡Ingrese un número válido!", result);
    }

    @Test
    public void testConvertCurrencyEmptyInput() {
        ConversorDivisas conversor = new ConversorDivisas();
        String result = conversor.convertCurrency("");
        assertEquals("¡Ingrese un número válido!", result);
    }

    @Test
    public void testConvertCurrencyNegativeInput() {
        ConversorDivisas conversor = new ConversorDivisas();
        String result = conversor.convertCurrency("-100");
        assertEquals("-100.00 dólares = -85.00 euros     -100.00 euros = -117.00 dólares", result);
    }
}