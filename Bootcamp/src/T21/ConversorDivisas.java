package T21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorDivisas extends JFrame implements ActionListener {

    private JTextField inputField;
    private JLabel resultLabel;

    public ConversorDivisas() {
        createUI();
    }

    private void createUI() {
        setTitle("Conversor de Divisas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Conversor de Divisas", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel);

        inputField = new JTextField(10);
        inputField.setEditable(false);  // No editable para obligar a usar los botones
        panel.add(inputField);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(this);
        buttonPanel.add(zeroButton);

        JButton dotButton = new JButton(".");
        dotButton.addActionListener(this);
        buttonPanel.add(dotButton);

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        panel.add(buttonPanel);

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(this);
        panel.add(convertButton);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(resultLabel);

        add(panel, BorderLayout.CENTER);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Convertir")) {
            String input = inputField.getText();
            try {
                double amount = Double.parseDouble(input);
                double euros, dollars;
                dollars = amount * 1.17; // Suponiendo una tasa de conversión de 1 dólar = 0.85 euros
                euros = amount * 0.85; // Suponiendo una tasa de conversión de 1 euro = 1.17 dólares
                resultLabel.setText(String.format("%.2f dólares = %.2f euros     %.2f euros = %.2f dólares", amount, euros, amount, dollars));
            } catch (NumberFormatException ex) {
                resultLabel.setText("¡Ingrese un número válido!");
            }
        } else if (command.equals("C")) {
            inputField.setText("");
        } else {
            inputField.setText(inputField.getText() + command);
        }
    }

    public static void main(String[] args) {
        new ConversorDivisas();
    }
}
