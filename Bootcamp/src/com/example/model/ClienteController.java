package com.example.model;

import com.example.model.Cliente;
import com.example.model.ClienteDAO;

import java.sql.SQLException;
import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }

    public void addCliente(Cliente cliente) throws SQLException {
        clienteDAO.addCliente(cliente);
    }

    public Cliente getCliente(int id) throws SQLException {
        return clienteDAO.getCliente(id);
    }

    public List<Cliente> getAllClientes() throws SQLException {
        return clienteDAO.getAllClientes();
    }

    public void updateCliente(Cliente cliente) throws SQLException {
        clienteDAO.updateCliente(cliente);
    }

    public void deleteCliente(int id) throws SQLException {
        clienteDAO.deleteCliente(id);
    }
}
