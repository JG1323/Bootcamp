package T21;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraProgramadoraTest {
    private CalculadoraProgramador calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new CalculadoraProgramador();
    }

    @Test
    public void testCalculateResultAddition() {
        calculadora.inputField.setText("10 + 20");
        calculadora.calculateResult();
        assertEquals("Resultado: 30", calculadora.resultLabel.getText());
    }

    @Test
    public void testCalculateResultSubtraction() {
        calculadora.inputField.setText("30 - 10");
        calculadora.calculateResult();
        assertEquals("Resultado: 20", calculadora.resultLabel.getText());
    }

    @Test
    public void testCalculateResultMultiplication() {
        calculadora.inputField.setText("10 * 5");
        calculadora.calculateResult();
        assertEquals("Resultado: 50", calculadora.resultLabel.getText());
    }

    @Test
    public void testCalculateResultDivision() {
        calculadora.inputField.setText("20 / 4");
        calculadora.calculateResult();
        assertEquals("Resultado: 5", calculadora.resultLabel.getText());
    }

    @Test
    public void testCalculateResultDivisionByZero() {
        calculadora.inputField.setText("20 / 0");
        calculadora.calculateResult();
        assertEquals("Error: División por cero", calculadora.resultLabel.getText());
    }

    @Test
    public void testCalculateResultInvalidInput() {
        calculadora.inputField.setText("10 +");
        calculadora.calculateResult();
        assertEquals("Error: Entrada inválida", calculadora.resultLabel.getText());
    }

    @Test
    public void testUpdateBaseToBinary() {
        calculadora.inputField.setText("10");
        calculadora.base = 10;
        calculadora.updateBase();
        assertEquals("10", calculadora.inputField.getText());

        calculadora.base = 2;
        calculadora.updateBase();
        assertEquals("10", calculadora.inputField.getText());
    }

    @Test
    public void testUpdateBaseToHexadecimal() {
        calculadora.inputField.setText("255");
        calculadora.base = 10;
        calculadora.updateBase();
        assertEquals("255", calculadora.inputField.getText());

        calculadora.base = 16;
        calculadora.updateBase();
        assertEquals("255", calculadora.inputField.getText());
    }
}