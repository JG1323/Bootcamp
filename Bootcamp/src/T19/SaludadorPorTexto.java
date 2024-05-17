package T19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaludadorPorTexto extends JFrame {
    private JTextField campoTexto;
    private JButton botonSaludar;

    public SaludadorPorTexto() {
        configurarVentana();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Saludador Personalizable");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }

    private void agregarComponentes() {
        JLabel etiqueta = new JLabel("Escribe tu nombre:");
        add(etiqueta);

        campoTexto = new JTextField(10);
        add(campoTexto);

        botonSaludar = new JButton("Saludar");
        botonSaludar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saludar();
            }
        });
        add(botonSaludar);
    }

    private void saludar() {
        String nombre = campoTexto.getText();
        JOptionPane.showMessageDialog(this, "¡Hola " + nombre + "!", "Saludo", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SaludadorPorTexto().setVisible(true);
            }
        });
    }
}
