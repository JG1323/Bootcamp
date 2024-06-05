package T20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Ej4_VentanaInteligente {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana con más Interacción");
        frame.setMinimumSize(new java.awt.Dimension(300, 200));

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear un panel para mostrar las frases guardadas
        JPanel listPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);
        list.setCellRenderer(new MultilineCellRenderer());
        JScrollPane scrollPane = new JScrollPane(list);
        listPanel.add(scrollPane);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(listPanel, gbc);

        // Crear un campo de texto interactivo
        JTextField textField = new JTextField("Escribe algo...", 20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(textField, gbc);

        // Crear un botón para guardar la frase
        JButton saveButton = new JButton("Guardar frase");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(saveButton, gbc);

        // Crear una lista para almacenar las frases
        List<String> frases = new ArrayList<>();

        // Añadir un ActionListener al botón para guardar la frase
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String frase = textField.getText();
                frases.add(frase);
                listModel.addElement(frase);
                textField.setText(""); // Limpiar el campo de texto después de guardar
            }
        });

        // Hacer visible la ventana después de haber añadido todos los componentes
        frame.setSize(400, 300); // Tamaño inicial de la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }

    // Clase para el renderizado de celdas multilínea
    static class MultilineCellRenderer extends JTextArea implements ListCellRenderer<Object> {
        private static final long serialVersionUID = 1L;

        MultilineCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            setText((value == null) ? "" : value.toString());
            setSize(list.getWidth(), getPreferredSize().height);
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }
    }
}
