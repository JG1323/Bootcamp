import javax.swing.JOptionPane;
public class TA5ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Pon el primer operando:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Pon el segundo operando:"));
        String signo = JOptionPane.showInputDialog("Ingrese el signo aritmético (+, -, *, /, ^, %):");

        double resultado = 0;

        switch (signo) {
            case "+":
                resultado = num1 +num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1* num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = (double) num1/ num2;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: división por cero");
                    return;
                }
                break;
            case "^":
                resultado = Math.pow(num1, num2);
                break;
            case "%":
                resultado = num1 % num2;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error: operación no válida");
                return;
        }

        JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
    }

	{
		
	}

{
	
}}
