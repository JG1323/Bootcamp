package com.example.model;

import com.example.model.ClienteController;
import com.example.model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ClienteView extends JFrame {
    private ClienteController clienteController;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField direccionField;
    private JTextField dniField;
    private JTextField fechaField;
    private JButton addButton;

    public ClienteView() {
        clienteController = new ClienteController();

        setTitle("Gestión de Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        nombreField = new JTextField();
        apellidoField = new JTextField();
        direccionField = new JTextField();
        dniField = new JTextField();
        fechaField = new JTextField();
        addButton = new JButton("Agregar Cliente");

        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Apellido:"));
        add(apellidoField);
        add(new JLabel("Dirección:"));
        add(direccionField);
        add(new JLabel("DNI:"));
        add(dniField);
        add(new JLabel("Fecha:"));
        add(fechaField);
        add(new JLabel(""));
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new Cliente();
                    cliente.setNombre(nombreField.getText());
                    cliente.setApellido(apellidoField.getText());
                    cliente.setDireccion(direccionField.getText());
                    cliente.setDni(Integer.parseInt(dniField.getText()));
                    cliente.setFecha(java.sql.Date.valueOf(fechaField.getText()));
                    clienteController.addCliente(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al agregar cliente");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteView().setVisible(true);
            }
        });
    }
}
