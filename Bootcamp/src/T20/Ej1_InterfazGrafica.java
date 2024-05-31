package T20;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ej1_InterfazGrafica {
	public static void main(String[] args) {
		// Crear la ventana principal
		JFrame frame = new JFrame("Aplicación con Interfaz Gráfica");

		// Configurar el tamaño mínimo de la ventana
		frame.setMinimumSize(new java.awt.Dimension(300, 200));

		// Crear una etiqueta y añadirla a la ventana
		JLabel label = new JLabel("Esta es una etiqueta", JLabel.CENTER);
		frame.add(label);
		
		// Configurar la acción al cerrar la ventana
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Confirmar antes de cerrar la aplicación
				int confirmed = javax.swing.JOptionPane.showConfirmDialog(frame, "¿Deseas salir de la aplicación?",
						"Salir", javax.swing.JOptionPane.YES_NO_OPTION);

				if (confirmed == javax.swing.JOptionPane.YES_OPTION) {
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
