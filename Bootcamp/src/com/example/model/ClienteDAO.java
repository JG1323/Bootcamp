package com.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void addCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO Cliente (nombre, apellido, direccion, dni, fecha) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getDireccion());
            pst.setInt(4, cliente.getDni());
            pst.setDate(5, new java.sql.Date(cliente.getFecha().getTime()));
            pst.executeUpdate();
        }
    }

    public Cliente getCliente(int id) throws SQLException {
        String query = "SELECT * FROM Cliente WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setId(rs.getInt("dni"));
                    cliente.setFecha(rs.getDate("fecha"));
                    return cliente;
                }
            }
        }
        return null;
    }

    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente";
        try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setId(rs.getInt("dni"));
                cliente.setFecha(rs.getDate("fecha"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void updateCliente(Cliente cliente) throws SQLException {
        String query = "UPDATE Cliente SET nombre = ?, apellido = ?, direccion = ?, dni = ?, fecha = ? WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getDireccion());
            pst.setInt(4, cliente.getDni());
            pst.setDate(5, new java.sql.Date(cliente.getFecha().getTime()));
            pst.setInt(6, cliente.getId());
            pst.executeUpdate();
        }
    }

    public void deleteCliente(int id) throws SQLException {
        String query = "DELETE FROM Cliente WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}
