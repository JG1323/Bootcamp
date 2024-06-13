package T21;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;

public class CalculadoraCientificaTest {
	


	    private CalculadoraCientifica calculadora;

	    @BeforeEach
	    public void setUp() {
	        calculadora = new CalculadoraCientifica();
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
	    public void testPotencia() {
	        double result = calculadora.calculate(2, 3, "^");
	        assertEquals(8, result, 0.001);
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
	    public void testSin() {
	        double value = 30;
	        calculadora.inputScreen.setText(String.valueOf(value));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "sin"));
	        assertEquals(String.valueOf(Math.sin(Math.toRadians(value))), calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testCos() {
	        double value = 60;
	        calculadora.inputScreen.setText(String.valueOf(value));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "cos"));
	        assertEquals(String.valueOf(Math.cos(Math.toRadians(value))), calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testTan() {
	        double value = 45;
	        calculadora.inputScreen.setText(String.valueOf(value));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "tan"));
	        assertEquals(String.valueOf(Math.tan(Math.toRadians(value))), calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testLog() {
	        double value = 100;
	        calculadora.inputScreen.setText(String.valueOf(value));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "log"));
	        assertEquals(String.valueOf(Math.log10(value)), calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testLn() {
	        double value = 2.718281828459;
	        calculadora.inputScreen.setText(String.valueOf(value));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "ln"));
	        assertEquals(String.valueOf(Math.log(value)), calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testExp() {
	        double value = 1;
	        calculadora.inputScreen.setText(String.valueOf(value));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "exp"));
	        assertEquals(String.valueOf(Math.exp(value)), calculadora.inputScreen.getText());
	    }

	    @Test
	    public void testMemoria() {
	        calculadora.inputScreen.setText("10");
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "M+"));
	        calculadora.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "MR"));
	        assertEquals("10.0", calculadora.inputScreen.getText());
	    }
	}