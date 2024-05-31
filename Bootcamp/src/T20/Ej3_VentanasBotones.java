package T20;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ej3_VentanasBotones {
	public static void main (String[] args) {
		JFrame frame = new JFrame("Ventana con más Interacción");
		frame.setMinimumSize(new java.awt.Dimension(300, 200));

	 // Crear un panel para añadir componentes
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        
        // Crear restricciones para el GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton button1 = new JButton("Botón 1");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(button1, gbc);
        
        JLabel messageLabel = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(messageLabel, gbc);

        JButton button2 = new JButton("Botón 2");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(button2, gbc);

        JLabel messageLabel1 = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(messageLabel1, gbc);
        
	    // Contadores de clics
        final int[] count1 = {0};
        final int[] count2 = {0};


	 // Añadir action listeners a los botones
	    button1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	count1[0]++;
	            messageLabel.setText("Boton 1: " + count1[0] + "veces.");
	        }
	    });

	   button2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	count2[0]++;
	            messageLabel1.setText("Boton 2: " + count2[0] + "veces.");
	        }
	    });

	    // Hacer visible la ventana
	    frame.setSize(400, 300); // Tamaño inicial de la ventana
	    frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
	    frame.setVisible(true);
	} 
	}