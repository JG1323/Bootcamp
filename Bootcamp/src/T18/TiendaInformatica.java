package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TiendaInformatica {
    
    private static final String URL = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión establecida con éxito");
            
            crearBaseDatos(conexion);
            usarBaseDatos(conexion);
            crearTablaFabricantes(conexion);
            insertarFabricantes(conexion);
            crearTablaArticulos(conexion);
            insertarArticulos(conexion);
            
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar con la base de datos");
            e.printStackTrace();
        }
    }

    private static void crearBaseDatos(Connection conexion) {
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS TiendaInformatica";
        ejecutarConsulta(conexion, createDatabaseQuery, "Base de datos creada o ya existente: TiendaInformatica");
    }

    private static void usarBaseDatos(Connection conexion) {
        String useDatabaseQuery = "USE TiendaInformatica";
        ejecutarConsulta(conexion, useDatabaseQuery, "Usando la base de datos: TiendaInformatica");
    }

    private static void crearTablaFabricantes(Connection conexion) {
        String createFabricantesTableQuery = "CREATE TABLE IF NOT EXISTS fabricantes (" +
                "cod_fabricantes INT, " +
                "nombre VARCHAR(100), " +
                "PRIMARY KEY (cod_fabricantes)" +
                ")";
        ejecutarConsulta(conexion, createFabricantesTableQuery, "Tabla creada o ya existente: fabricantes");
    }

    private static void insertarFabricantes(Connection conexion) {
        String insertFabricantesQuery = "INSERT IGNORE INTO fabricantes (cod_fabricantes, nombre) VALUES " +
                "(01, 'Sony'), " +
                "(02, 'Samsung'), " +
                "(03, 'Apple'), " +
                "(04, 'Microsoft'), " +
                "(05, 'HP')";
        ejecutarConsulta(conexion, insertFabricantesQuery, "Registros insertados en la tabla fabricantes");
    }

    private static void crearTablaArticulos(Connection conexion) {
        String createArticulosTableQuery = "CREATE TABLE IF NOT EXISTS articulos (" +
                "cod_articulos INT, " +
                "nombre VARCHAR(100), " +
                "precio DECIMAL(10, 2), " + 
                "cod_fabricantes INT, " +
                "PRIMARY KEY (cod_articulos), " +
                "FOREIGN KEY (cod_fabricantes) " +
                "REFERENCES fabricantes(cod_fabricantes) " +
                "ON DELETE SET NULL " +
                "ON UPDATE CASCADE" +
                ")";
        ejecutarConsulta(conexion, createArticulosTableQuery, "Tabla creada o ya existente: articulos");
    }

    private static void insertarArticulos(Connection conexion) {
        String insertArticulosQuery = "INSERT IGNORE INTO articulos (cod_articulos, nombre, precio, cod_fabricantes) VALUES " +
                "(1, 'PlayStation 5', 389.99, 01), " +
                "(2, 'Samsung Galaxy S21', 969.99, 02), " + 
                "(3, 'iPhone13 Pro', 865.99, 03), " +
                "(4, 'Microsoft Surface Laptop 4', 1143.99, 04), " +
                "(5, 'HP Spectre x360', 1143.99, 05)";
        ejecutarConsulta(conexion, insertArticulosQuery, "Registros insertados en la tabla articulos");
    }

    private static void ejecutarConsulta(Connection conexion, String query, String mensajeExito) {
        try (Statement stmt = conexion.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println(mensajeExito);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
        }
    }
}