package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LosDirectores {
	
	private static final String URL = "jdbc:mysql://localhost:3306/directores_db?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Server Connected");

            insertarDespachos(conexion);
            insertarDirectores(conexion);

        } catch (SQLException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
            ex.printStackTrace();
        }
    }

    private static void insertarDespachos(Connection conexion) {
        String insertDespachosQuery = "INSERT INTO despachos (capacidad) VALUES (?)";
        int[] capacidades = {3, 8, 7, 6, 4};

        try (PreparedStatement statement = conexion.prepareStatement(insertDespachosQuery)) {
            for (int capacidad : capacidades) {
                statement.setInt(1, capacidad);
                statement.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla despachos");
        } catch (SQLException e) {
            System.err.println("Error al insertar registros en la tabla despachos: " + e.getMessage());
        }
    }

    private static void insertarDirectores(Connection conexion) {
        String insertDirectoresQuery = "INSERT INTO directores (dni, nom_apels, dni_jefe, num_despacho) VALUES (?, ?, ?, ?)";
        Object[][] directores = {
            {"12345", "Central CEE", "22345", 1},
            {"22345", "Jahseh Dwayne", "32345", 2},
            {"32345", "Micheal Ward", "42345", 3},
            {"42345", "Joel García", "62345", 4},
            {"62345", "Bryant Myers", "52345", 5}
        };

        try (PreparedStatement statement = conexion.prepareStatement(insertDirectoresQuery)) {
            for (Object[] director : directores) {
                statement.setString(1, (String) director[0]);
                statement.setString(2, (String) director[1]);
                statement.setString(3, (String) director[2]);
                statement.setInt(4, (int) director[3]);
                statement.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla directores");
        } catch (SQLException e) {
            System.err.println("Error al insertar registros en la tabla directores: " + e.getMessage());
        }
    }
}

