package T21;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class CalculadoraProgramador extends JFrame implements ActionListener {

	    private JTextField inputField;
	    private JLabel resultLabel;
	    private String currentOperation = "";
	    private int base = 10;

	    public CalculadoraProgramador() {
	        createUI();
	    }

	    private void createUI() {
	        setTitle("Calculadora Programador");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());
	        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        
	        // Panel de título
	        JLabel titleLabel = new JLabel("Calculadora Programador", SwingConstants.CENTER);
	        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	        mainPanel.add(titleLabel, BorderLayout.NORTH);

	        // Panel de entrada y resultado
	        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
	        inputField = new JTextField();
	        inputField.setEditable(false);  // No editable para obligar a usar los botones
	        inputField.setFont(new Font("Arial", Font.PLAIN, 18));
	        inputPanel.add(inputField, BorderLayout.NORTH);

	        resultLabel = new JLabel("", SwingConstants.CENTER);
	        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        inputPanel.add(resultLabel, BorderLayout.SOUTH);

	        mainPanel.add(inputPanel, BorderLayout.CENTER);

	        // Panel de botones
	        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5));
	        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

	        String[] buttons = {
	            "7", "8", "9", "C",
	            "4", "5", "6", "/",
	            "1", "2", "3", "*",
	            "0", "A", "B", "-",
	            "C", "D", "E", "F",
	            "BIN", "DEC", "HEX", "+"
	        };
	        
	        for (String text : buttons) {
	            JButton button = new JButton(text);
	            button.setFont(new Font("Arial", Font.BOLD, 16));
	            button.addActionListener(this);
	            buttonPanel.add(button);
	        }

	        JButton equalButton = new JButton("=");
	        equalButton.setFont(new Font("Arial", Font.BOLD, 16));
	        equalButton.addActionListener(this);
	        buttonPanel.add(equalButton);

	        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

	        add(mainPanel);

	        setSize(500, 500);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();

	        if (command.matches("[0-9A-F]")) {
	            inputField.setText(inputField.getText() + command);
	        } else if (command.equals("C")) {
	            inputField.setText("");
	            resultLabel.setText("");
	            currentOperation = "";
	        } else if (command.equals("BIN")) {
	            base = 2;
	            updateBase();
	        } else if (command.equals("DEC")) {
	            base = 10;
	            updateBase();
	        } else if (command.equals("HEX")) {
	            base = 16;
	            updateBase();
	        } else if (command.equals("=")) {
	            calculateResult();
	        } else {
	            if (!inputField.getText().isEmpty() && !inputField.getText().endsWith(" ")) {
	                currentOperation = command;
	                inputField.setText(inputField.getText() + " " + command + " ");
	            }
	        }
	    }

	    private void calculateResult() {
	        try {
	            String[] tokens = inputField.getText().split(" ");
	            if (tokens.length == 3) {
	                long num1 = Long.parseLong(tokens[0], base);
	                long num2 = Long.parseLong(tokens[2], base);
	                long result = 0;

	                switch (tokens[1]) {
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
	                            resultLabel.setText("Error: División por cero");
	                            return;
	                        }
	                        break;
	                }

	                resultLabel.setText("Resultado: " + Long.toString(result, base).toUpperCase());
	            }
	        } catch (Exception ex) {
	            resultLabel.setText("Error: Entrada inválida");
	        }
	    }

	    private void updateBase() {
	        try {
	            long value = Long.parseLong(inputField.getText(), base);
	            inputField.setText(Long.toString(value, base).toUpperCase());
	        } catch (Exception ex) {
	            inputField.setText("");
	        }
	    }

	    public static void main(String[] args) {
	        new CalculadoraProgramador();
	    }
	}
