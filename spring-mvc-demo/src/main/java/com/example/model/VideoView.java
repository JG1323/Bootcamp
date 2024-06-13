package com.example.model;

import com.example.model.VideoController;
import com.example.model.Video;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class VideoView extends JFrame {
    private VideoController videoController;
    private JTextField idField;
    private JTextField titleField;
    private JTextField directorField;
    private JTextField cliIdField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton getAllButton;
    private JTextArea displayArea;

    public VideoView() {
        videoController = new VideoController();

        setTitle("Gestión de Videos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        idField = new JTextField();
        titleField = new JTextField();
        directorField = new JTextField();
        cliIdField = new JTextField();

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Título:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Director:"));
        inputPanel.add(directorField);
        inputPanel.add(new JLabel("ID Cliente:"));
        inputPanel.add(cliIdField);

        addButton = new JButton("Agregar");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");
        getAllButton = new JButton("Mostrar Todos");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Video video = new Video();
                    video.setTitle(titleField.getText());
                    video.setDirector(directorField.getText());
                    video.setCliId(Integer.parseInt(cliIdField.getText()));
                    videoController.addVideo(video);
                    displayArea.setText("Video agregado correctamente.");
                } catch (SQLException ex) {
                    displayArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Video video = new Video();
                    video.setId(Integer.parseInt(idField.getText()));
                    video.setTitle(titleField.getText());
                    video.setDirector(directorField.getText());
                    video.setCliId(Integer.parseInt(cliIdField.getText()));
                    videoController.updateVideo(video);
                    displayArea.setText("Video actualizado correctamente.");
                } catch (SQLException ex) {
                    displayArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    videoController.deleteVideo(id);
                    displayArea.setText("Video eliminado correctamente.");
                } catch (SQLException ex) {
                    displayArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        getAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Video> videos = videoController.getAllVideos();
                    StringBuilder sb = new StringBuilder();
                    for (Video video : videos) {
                        sb.append(video.toString()).append("\n");
                    }
                    displayArea.setText(sb.toString());
                } catch (SQLException ex) {
                    displayArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(getAllButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VideoView().setVisible(true);
            }
        });
    }
}