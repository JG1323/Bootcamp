import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField inputScreen;
    private String num1 = "";
    private String op = "";
    private boolean startNumber = true;

    public Calculator() {
        createUI();
    }

    private void createUI() {
        this.setTitle("Calculadora Simple");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        inputScreen = new JTextField();
        inputScreen.setEditable(false);
        inputScreen.setHorizontalAlignment(JTextField.RIGHT);
        this.add(inputScreen, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String b : buttons) {
            JButton button = new JButton(b);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        this.add(buttonPanel, BorderLayout.CENTER);
        this.setSize(400, 400);
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
                    num1 = inputScreen.getText();
                    op = command;
                    startNumber = true;
                    break;
                case "=":
                    if (!op.isEmpty()) {
                        calculate(Double.parseDouble(num1), Double.parseDouble(inputScreen.getText()), op);
                        op = "";
                    }
                    startNumber = true;
                    break;
                case "C":
                    inputScreen.setText("");
                    startNumber = true;
                    break;
            }
        }
    }

    private void calculate(double num1, double num2, String op) {
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
                    return;
                }
                break;
        }
        inputScreen.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
