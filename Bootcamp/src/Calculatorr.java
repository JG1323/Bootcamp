import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculatorr extends JFrame {
    private JTextField inputScreen;
    private JTextArea historyArea;
    private JLabel resultLabel;
    private String num1 = "";
    private String op = "";
    private boolean startNumber = true;
    private List<String> historyList = new ArrayList<>();

    public Calculatorr() {
        createUI();
    }

    private void createUI() {
        this.setTitle("Calculadora Espacial");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        // Primer Panel: Paz Espacial
        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel textLabel = new JLabel("Paz Espacial", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Carga de la imagen
        JLabel imageLabel = new JLabel();
        try {
            BufferedImage img = ImageIO.read(new File("/Users/Joel/Desktop/Bootcamp/Bootcamp/src"));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            imageLabel.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel1.add(imageLabel, BorderLayout.WEST);
        panel1.add(textLabel, BorderLayout.CENTER);
        this.add(panel1);

        // Segundo Panel: Historial
        JPanel panel2 = new JPanel(new BorderLayout());
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        scrollPane.setPreferredSize(new Dimension(400, 100));
        panel2.add(scrollPane, BorderLayout.CENTER);
        this.add(panel2);

        // Tercer Panel: Calculadora y Resultado Actual
        JPanel panel3 = new JPanel(new BorderLayout());
        inputScreen = new JTextField();
        inputScreen.setEditable(false);
        inputScreen.setHorizontalAlignment(JTextField.RIGHT);
        inputScreen.setFont(new Font("Arial", Font.PLAIN, 50));

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "←", "+",
            "", "", "=", ""
        };

        for (String b : buttons) {
            JButton button = new JButton(b);
            button.addActionListener(this::handleButtonPress);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            buttonPanel.add(button);
        }

        panel3.add(inputScreen, BorderLayout.NORTH);
        panel3.add(buttonPanel, BorderLayout.CENTER);
        panel3.add(resultLabel, BorderLayout.SOUTH);
        this.add(panel3);

        this.setSize(400, 800);
        this.setVisible(true);
    }

    private void handleButtonPress(ActionEvent e) {
        String command = e.getActionCommand();
        if ("0123456789".contains(command)) {
            handleNumberButton(command);
        } else if ("+-*/".contains(command)) {
            handleOperatorButton(command);
        } else if ("=".equals(command)) {
            handleEqualsButton();
        } else if ("C".equals(command)) {
            handleClearButton();
        } else if ("←".equals(command)) {
            handleBackspaceButton();
        }
    }

    private void handleNumberButton(String number) {
        if (startNumber) {
            inputScreen.setText(number);
            startNumber = false;
        } else {
            inputScreen.setText(inputScreen.getText() + number);
        }
    }

    private void handleOperatorButton(String operator) {
        num1 = inputScreen.getText();
        op = operator;
        startNumber = true;
    }

    private void handleEqualsButton() {
        if (!op.isEmpty() && !num1.isEmpty()) {
            double num2 = Double.parseDouble(inputScreen.getText());
            double result = calculate(Double.parseDouble(num1), num2, op);
            historyList.add(num1 + " " + op + " " + num2 + " = " + result);
            inputScreen.setText(String.valueOf(result));
            num1 = "";  // Clear num1 after calculation
            op = "";    // Clear operator after calculation
            updateHistory();
            updateResult(result);
            startNumber = true;
        }
    }

    private void handleClearButton() {
        inputScreen.setText("0");
        num1 = "";
        op = "";
        startNumber = true;
    }

    private void handleBackspaceButton() {
        String currentText = inputScreen.getText();
        if (!currentText.isEmpty() && !currentText.equals("0")) {
            inputScreen.setText(currentText.substring(0, currentText.length() - 1));
            if (inputScreen.getText().isEmpty()) {
                inputScreen.setText("0");
                startNumber = true;
            }
        }
    }

    private double calculate(double num1, double num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    inputScreen.setText("Error");
                    return 0;
                }
        }
        return 0;
    }

    private void updateHistory() {
        StringBuilder historyText = new StringBuilder();
        for (String entry : historyList) {
            historyText.append(entry).append("\n");
        }
        historyArea.setText(historyText.toString());
    }

    private void updateResult(double result) {
        resultLabel.setText("Resultado: " + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculatorr::new);
    }
}


//CODIGO ANTIGUO
//	import javax.imageio.ImageIO;
//	import javax.swing.*;
//	import java.awt.*;
//	import java.awt.image.BufferedImage;
//	import java.io.File;
//	import java.io.IOException;
//	import java.util.ArrayList;
//	import java.util.List;
//	
//	public class Calculatorr extends JFrame{
//	    private JTextField inputScreen;
//	    private JTextArea historyArea;
//	    private JLabel resultLabel;
//	    private String num1 = "";
//	    private String op = "";
//	    private boolean startNumber = true;
//	    private List<String> historyList = new ArrayList<>();
//
//	    public Calculatorr() {
//	        createUI();
//	    }
//
//	    private void createUI() {
//	        this.setTitle("Calculadora Espacial");
//	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        this.setLayout(new GridLayout(3, 1));
//
//	        // Primer Panel: Paz Espacial
//	        JPanel panel1 = new JPanel();
//	        panel1.setLayout(new BorderLayout());
//
//	        JLabel textLabel = new JLabel("Paz Espacial", SwingConstants.CENTER);
//	        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
//
//	        // Carga de la imagen
//	        JLabel imageLabel = new JLabel();
//	        try {
//	            BufferedImage img = ImageIO.read(new File("C:\\Users\\Santos\\Desktop\\RepositoriTechTalent\\Eclipse\\Calculadora\\src\\calculadora\\rocket.png")); // Ruta de la imagen del cohete
//	            ImageIcon icon = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
//	            imageLabel.setIcon(icon);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//
//	        // Agregar los componentes al panel
//	        panel1.add(imageLabel, BorderLayout.WEST);
//	        panel1.add(textLabel, BorderLayout.CENTER);
//	        this.add(panel1);
//
//	        // Segundo Panel: Historial
//	        JPanel panel2 = new JPanel();
//	        panel2.setLayout(new BorderLayout());
//	        historyArea = new JTextArea();
//	        historyArea.setEditable(false);
//	        JScrollPane scrollPane = new JScrollPane(historyArea);
//	        scrollPane.setPreferredSize(new Dimension(400, 100));
//	        panel2.add(scrollPane, BorderLayout.CENTER);
//	        this.add(panel2);
//
//	        // Tercer Panel: Calculadora y Resultado Actual
//	        JPanel panel3 = new JPanel();
//	        panel3.setLayout(new BorderLayout());
//
//	        inputScreen = new JTextField();
//	        inputScreen.setEditable(false);
//	        inputScreen.setHorizontalAlignment(JTextField.RIGHT);
//	        inputScreen.setFont(new Font("Arial", Font.PLAIN, 50));
//
//	        resultLabel = new JLabel("", SwingConstants.CENTER);
//	        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//
//	        JPanel calculatorPanel = new JPanel();
//	        calculatorPanel.setLayout(new GridLayout(4, 4, 1, 1));
//	        String[] buttons = {
//	            "7", "8", "9", "/",
//	            "4", "5", "6", "*",
//	            "1", "2", "3", "-",
//	            "0", "C", "=", "+"
//	        };
//
//	        for (String b : buttons) {
//	            JButton button;
//	            if ("=".equals(b)) {
//	                try {
//	                    BufferedImage img = ImageIO.read(new File("C:\\Users\\Santos\\Desktop\\RepositoriTechTalent\\Eclipse\\Calculadora\\src\\calculadora\\Igual_cohete.png")); // Ruta de la imagen del cohete
//	                    ImageIcon icon = new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
//	                    button = new JButton(icon);
//	                } catch (IOException e) {
//	                    e.printStackTrace();
//	                    button = new JButton(b);
//	                }
//	            } else {
//	                button = new JButton(b);
//	            }
//	            button.addActionListener(e -> {
//	                if ("0123456789".contains(b)) {
//	                    handleNumberButton(b);
//	                } else if ("+-*/".contains(b)) {
//	                    handleOperatorButton(b);
//	                } else if ("=".equals(b)) {
//	                    handleEqualsButton();
//	                } else if ("C".equals(b)) {
//	                    handleClearButton();
//	                }
//	            });
//	            button.setFont(new Font("Arial", Font.PLAIN, 20));
//	            calculatorPanel.add(button);
//	        }
//
//	        panel3.add(inputScreen, BorderLayout.NORTH);
//	        panel3.add(calculatorPanel, BorderLayout.CENTER);
//	        panel3.add(resultLabel, BorderLayout.SOUTH);
//	        this.add(panel3);
//
//	        // Configuración de la ventana
//	        this.setSize(400, 800); // Ajusta el tamaño de la ventana según tus necesidades
//	        this.setVisible(true);
//	    }
//
//	    private void handleNumberButton(String number) {
//	        if (startNumber) {
//	            inputScreen.setText(number);
//	        } else {
//	            inputScreen.setText(inputScreen.getText() + number);
//	        }
//	        startNumber = false;
//	    }
//
//	    private void handleOperatorButton(String operator) {
//	        num1 = inputScreen.getText();
//	        op = operator;
//	        startNumber = true;
//	    }
//
//	    private void handleEqualsButton() {
//	        if (!op.isEmpty()) {
//	            double num2 = Double.parseDouble(inputScreen.getText());
//	            double result = calculate(Double.parseDouble(num1), num2, op);
//	            historyList.add(num1 + " " + op + " " + num2 + " = " + result);
//	            num1 = String.valueOf(result);
//	            updateHistory();
//	            updateResult(result);
//	        }
//	    }
//
//	    private void handleClearButton() {
//	        inputScreen.setText("");
//	        startNumber = true;
//	    }
//
//	    private double calculate(double num1, double num2, String op) {
//	        double result = 0;
//	        switch (op) {
//	            case "+":
//	                result = num1 + num2;
//	                break;
//	            case "-":
//	                result = num1 - num2;
//	                break;
//	            case "*":
//	                result = num1 * num2;
//	                break;
//	            case "/":
//	                if (num2 != 0) {
//	                    result = num1 / num2;
//	                } else {
//	                    inputScreen.setText("Error");
//	                }
//	                break;
//	        }
//	        return result;
//	    }
//
//	    private void updateHistory() {
//	        StringBuilder historyText = new StringBuilder();
//	        for (String entry : historyList) {
//	            historyText.append(entry).append("\n");
//	        }
//	        historyArea.setText(historyText.toString());
//	    }
//
//	    private void updateResult(double result) {
//	        resultLabel.setText("Resultado: " + result);
//	    }
//
//	    public static void main(String[] args) {
//	        SwingUtilities.invokeLater(Calculatorr::new);
//	    }
//	}