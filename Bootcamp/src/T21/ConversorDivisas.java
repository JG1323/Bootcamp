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

        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Conversor de Divisas", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel);

        inputField = new JTextField(10);
        panel.add(inputField);

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(this);
        panel.add(convertButton);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(resultLabel);

        add(panel, BorderLayout.CENTER);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        try {
            double amount = Double.parseDouble(input);
            double euros, dollars;
            if (e.getActionCommand().equals("Convertir")) {
                dollars = amount * 1.17; // Suponiendo una tasa de conversión de 1 dólar = 0.85 euros
                euros = amount * 0.85; // Suponiendo una tasa de conversión de 1 euro = 1.17 dólares
                resultLabel.setText(String.format("%.2f dólares = %.2f euros\n%.2f euros = %.2f dólares", amount, euros, amount, dollars));
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("¡Ingrese un número válido!");
        }
    }

    public static void main(String[] args) {
        new ConversorDivisas();
    }
}