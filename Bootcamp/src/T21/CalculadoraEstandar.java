package T21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraEstandar extends JFrame implements ActionListener {

    JTextField inputScreen;
    private JTextArea historyArea;
    private String num1 = "";
    private String op = "";
    private double memory = 0;
    private boolean startNumber = true;

    public CalculadoraEstandar() {
        createUI();
    }

    private void createUI() {
        this.setTitle("Calculadora Estandar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Pantalla de entrada
        inputScreen = new JTextField("0");
        inputScreen.setEditable(false);
        inputScreen.setHorizontalAlignment(JTextField.RIGHT);
        inputScreen.setFont(new Font("Arial", Font.BOLD, 36));
        inputScreen.setPreferredSize(new Dimension(400, 80));
        this.add(inputScreen, BorderLayout.NORTH);

        // Historial
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(historyArea);
        scrollPane.setPreferredSize(new Dimension(200, 400));
        this.add(scrollPane, BorderLayout.EAST);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons = {
            "MC", "MR", "M+", "√",
            "x²", "1/x", "CE", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", "C", "%", "="
        };

        for (String b : buttons) {
            JButton button = new JButton(b);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(buttonPanel, BorderLayout.CENTER);

        // Ajuste del tamaño de la ventana
        this.setSize(800, 600);
        this.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("0123456789".contains(command)) {
            if (startNumber) {
                inputScreen.setText(command);
            } else {
                inputScreen.setText(inputScreen.getText() + command);
            }
            startNumber = false;
        } else {
            switch (command) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    num1 = inputScreen.getText();
                    op = command;
                    startNumber = true;
                    break;
                case "=":
                    if (!op.isEmpty()) {
                        double num2 = Double.parseDouble(inputScreen.getText());
                        double result = calculate(Double.parseDouble(num1), num2, op);
                        historyArea.append(num1 + " " + op + " " + num2 + " = " + result + "\n");
                        inputScreen.setText(String.valueOf(result));
                        op = "";
                    }
                    startNumber = true;
                    break;
                case "C":
                    inputScreen.setText("0");
                    startNumber = true;
                    break;
                case "CE":
                    inputScreen.setText("0");
                    break;
                case "√":
                    double sqrtValue = Double.parseDouble(inputScreen.getText());
                    double sqrtResult = Math.sqrt(sqrtValue);
                    historyArea.append("√" + sqrtValue + " = " + sqrtResult + "\n");
                    inputScreen.setText(String.valueOf(sqrtResult));
                    startNumber = true;
                    break;
                case "x²":
                    double squaredValue = Double.parseDouble(inputScreen.getText());
                    double squaredResult = Math.pow(squaredValue, 2);
                    historyArea.append(squaredValue + "² = " + squaredResult + "\n");
                    inputScreen.setText(String.valueOf(squaredResult));
                    startNumber = true;
                    break;
                case "1/x":
                    double value = Double.parseDouble(inputScreen.getText());
                    if (value != 0) {
                        double inverseResult = 1 / value;
                        historyArea.append("1/" + value + " = " + inverseResult + "\n");
                        inputScreen.setText(String.valueOf(inverseResult));
                    } else {
                        inputScreen.setText("Error");
                    }
                    startNumber = true;
                    break;
                case "MC":
                    memory = 0;
                    break;
                case "MR":
                    inputScreen.setText(String.valueOf(memory));
                    startNumber = true;
                    break;
                case "M+":
                    memory += Double.parseDouble(inputScreen.getText());
                    break;
            }
        }
    }

   public double calculate(double num1, double num2, String op) {
        double result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    inputScreen.setText("Error");
                    return 0;
                }
                break;
            case "%":
                result = num1 * (num2 / 100);
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculadoraEstandar::new);
    }
}
