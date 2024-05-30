package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PeliculasySalas {
	private static final String URL = "jdbc:mysql://localhost:3306/peliculas_y_salas?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {
		try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
			System.out.println("Server Connected");

			insertarPeliculas(conexion);
			insertarSalas(conexion);

		} catch (SQLException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			ex.printStackTrace();
		}
	}

	private static void insertarPeliculas(Connection conexion) {
		String insertPeliculasQuery = "INSERT INTO peliculas (cod_pelicula, nombre, calificacion_edad) VALUES (?, ?, ?)";
		Object[][] peliculas = { { 101, "Los Mercenarios", 16 }, { 102, "Fast & Furious", 16 },
				{ 103, "El Señor de los Anillos", 12 }, { 104, "Un espía y medio", 12 }, { 105, "Creed 3", 5 } };

		try (PreparedStatement statement = conexion.prepareStatement(insertPeliculasQuery)) {
			for (Object[] pelicula : peliculas) {
				statement.setInt(1, (int) pelicula[0]);
				statement.setString(2, (String) pelicula[1]);
				statement.setInt(3, (int) pelicula[2]);
				statement.executeUpdate();
			}
			System.out.println("Registros insertados en la tabla peliculas");
		} catch (SQLException e) {
			System.err.println("Error al insertar registros en la tabla peliculas: " + e.getMessage());
		}
	}

	private static void insertarSalas(Connection conexion) {
		String insertSalasQuery = "INSERT INTO salas (cod_sala, nombre, cod_pelicula) VALUES (?, ?, ?)";
		Object[][] salas = { { 1, "Sala 1", 101 }, { 2, "Sala 2", 102 }, { 3, "Sala 3", 103 }, { 4, "Sala 4", 104 },
				{ 5, "Sala 5", 105 } };

		try (PreparedStatement statement = conexion.prepareStatement(insertSalasQuery)) {
			for (Object[] sala : salas) {
				statement.setInt(1, (int) sala[0]);
				statement.setString(2, (String) sala[1]);
				statement.setInt(3, (int) sala[2]);
				statement.executeUpdate();
			}
			System.out.println("Registros insertados en la tabla salas");
		} catch (SQLException e) {
			System.err.println("Error al insertar registros en la tabla salas: " + e.getMessage());
		}
	}
}
