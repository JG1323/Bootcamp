package T20;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ej2_Window {
	
	public static void main (String[] args) {
	JFrame frame = new JFrame("Ventana con Interacción");
	frame.setMinimumSize(new java.awt.Dimension(300, 200));
	// Crear un panel para añadir componentes
    JPanel panel = new JPanel();
    frame.add(panel);

    // Crear dos botones
    JButton button1 = new JButton("Botón 1");
    JButton button2 = new JButton("Botón 2");

    // Añadir los botones al panel
    panel.add(button1);
    panel.add(button2);

    // Crear una etiqueta para mostrar mensajes
    JLabel messageLabel = new JLabel();
    panel.add(messageLabel);

    // Añadir action listeners a los botones
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            messageLabel.setText("Has pulsado: el Botón 1");
        }
    });

    button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            messageLabel.setText("Has pulsado: el Botón 2");
        }
    });

    // Configurar la acción al cerrar la ventana
    frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            // Confirmar antes de cerrar la aplicación
            int confirmed = JOptionPane.showConfirmDialog(
                    frame,
                    "¿Deseas salir de la aplicación?",
                    "Salir",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        }
    });

    // Hacer visible la ventana
    frame.setSize(400, 300); // Tamaño inicial de la ventana
    frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    frame.setVisible(true);
}
}