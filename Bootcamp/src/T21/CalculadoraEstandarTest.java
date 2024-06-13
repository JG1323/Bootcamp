package T21;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculadoraEstandarTest {


	    private CalculadoraEstandar calculadora;

	    @BeforeEach
	    public void setUp() {
	        calculadora = new CalculadoraEstandar();
	    }

	    @Test
	    public void testSumar() {
	        double result = calculadora.calculate(5, 3, "+");
	        assertEquals(8, result, 0.001);
	    }

	    @Test
	    public void testRestar() {
	        double result = calculadora.calculate(5, 3, "-");
	        assertEquals(2, result, 0.001);
	    }

	    @Test
	    public void testMultiplicar() {
	        double result = calculadora.calculate(5, 3, "*");
	        assertEquals(15, result, 0.001);
	    }

	    @Test
	    public void testDividir() {
	        double result = calculadora.calculate(6, 3, "/");
	        assertEquals(2, result, 0.001);
	    }

	    @Test
	    public void testDividirPorCero() {
	        double result = calculadora.calculate(5, 0, "/");
	        assertEquals(0, result, 0.001); // Asumiendo que devuelve 0 en caso de división por cero
	    }

	    @Test
	    public void testPorcentaje() {
	        double result = calculadora.calculate(200, 10, "%");
	        assertEquals(20, result, 0.001);
	    }

	    @Test
	    public void testRaizCuadrada() {
	        double sqrtValue = 16;
	        calculadora.inputScreen.setText(String.valueOf(sqrtValue));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "√"));
	        assertEquals("4.0", calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testCuadrado() {
	        double squaredValue = 4;
	        calculadora.inputScreen.setText(String.valueOf(squaredValue));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "x²"));
	        assertEquals("16.0", calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testInverso() {
	        double value = 4;
	        calculadora.inputScreen.setText(String.valueOf(value));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "1/x"));
	        assertEquals("0.25", calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testMemoria() {
	        calculadora.inputScreen.setText("10");
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "M+"));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "MR"));
	        assertEquals("10.0", calculadora.inputScreen.getText());
	    }
	}

