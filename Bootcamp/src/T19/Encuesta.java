package T19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Encuesta extends JFrame {
    private JRadioButton windowsButton, linuxButton, macButton;
    private JCheckBox programacionCheck, disenoCheck, administracionCheck;
    private JSlider horasSlider;
    private JButton botonEnviar;

    public Encuesta() {
        configurarVentana();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("Encuesta");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));
    }

    private void agregarComponentes() {
    	
        // Grupo de botones de radio para el sistema operativo
        JLabel osLabel = new JLabel("Elije un sistema operativo:");
        add(osLabel);
        
        ButtonGroup osGroup = new ButtonGroup();
        windowsButton = new JRadioButton("Windows");
        linuxButton = new JRadioButton("Linux");
        macButton = new JRadioButton("Mac");

        osGroup.add(windowsButton);
        osGroup.add(linuxButton);
        osGroup.add(macButton);

        add(windowsButton);
        add(linuxButton);
        add(macButton);

        // Checkboxes para la especialidad
        JLabel specialtyLabel = new JLabel("Elije tu especialidad:");
        add(specialtyLabel);

        programacionCheck = new JCheckBox("Programación");
        disenoCheck = new JCheckBox("Diseño gráfico");
        administracionCheck = new JCheckBox("Administración");

        add(programacionCheck);
        add(disenoCheck);
        add(administracionCheck);

        // Slider para las horas dedicadas en el ordenador
        JLabel horasLabel = new JLabel("Horas dedicadas en el ordenador:");
        add(horasLabel);

        horasSlider = new JSlider(0, 10, 5);
        horasSlider.setMajorTickSpacing(1);
        horasSlider.setPaintTicks(true);
        horasSlider.setPaintLabels(true);

        add(horasSlider);

        // Botón para enviar los datos
        botonEnviar = new JButton("Enviar");
        botonEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResultados();
            }
        });
        add(botonEnviar);
    }

    private void mostrarResultados() {
        String sistemaOperativo = "";
        if (windowsButton.isSelected()) {
            sistemaOperativo = "Windows";
        } else if (linuxButton.isSelected()) {
            sistemaOperativo = "Linux";
        } else if (macButton.isSelected()) {
            sistemaOperativo = "Mac";
        }

        StringBuilder especialidades = new StringBuilder();
        if (programacionCheck.isSelected()) {
            especialidades.append("Programación ");
        }
        if (disenoCheck.isSelected()) {
            especialidades.append("Diseño gráfico ");
        }
        if (administracionCheck.isSelected()) {
            especialidades.append("Administración ");
        }

        int horas = horasSlider.getValue();

        String mensaje = String.format(
            "Sistema Operativo: %s\nEspecialidad(es): %s\nHoras dedicadas en el ordenador: %d",
            sistemaOperativo,
            especialidades.toString().trim(),
            horas
        );

        JOptionPane.showMessageDialog(this, mensaje, "Resultados de la Encuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Encuesta().setVisible(true);
            }
        });
    }
}
