package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LosInvestigadores {

	private static final String URL = "jdbc:mysql://localhost:3306/investigadores_db?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
				System.out.println("Server Connected");

				insertarFacultades(conexion);
				insertarEquipos(conexion);
				insertarInvestigadores(conexion);
				insertarReservas(conexion);
			}
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			ex.printStackTrace();
		}
	}

	private static void insertarFacultades(Connection conexion) throws SQLException {
		String insertFacultadesQuery = "INSERT INTO facultad (cod_facultad, nombre) VALUES (?, ?)";
		try (PreparedStatement stmt = conexion.prepareStatement(insertFacultadesQuery)) {
			stmt.setInt(1, 11);
			stmt.setString(2, "Facultad de Ciencias");
			stmt.addBatch();

			stmt.setInt(1, 12);
			stmt.setString(2, "Facultad de Humanidades");
			stmt.addBatch();

			stmt.setInt(1, 13);
			stmt.setString(2, "Facultad de Ciencias Sociales");
			stmt.addBatch();

			stmt.setInt(1, 14);
			stmt.setString(2, "Facultad de Medicina");
			stmt.addBatch();

			stmt.setInt(1, 15);
			stmt.setString(2, "Facultad de Ingeniería");
			stmt.addBatch();

			stmt.executeBatch();
			System.out.println("Registros insertados en la tabla facultad");
		}
	}

	private static void insertarEquipos(Connection conexion) throws SQLException {
		String insertEquiposQuery = "INSERT INTO equipos (num_serie, nombre, cod_facultad) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conexion.prepareStatement(insertEquiposQuery)) {
			stmt.setString(1, "E001");
			stmt.setString(2, "Equipo de Investigación en Ciencias de la Salud");
			stmt.setInt(3, 11);
			stmt.addBatch();

			stmt.setString(1, "E002");
			stmt.setString(2, "Equipo de Investigación en Ciencias de la Tierra");
			stmt.setInt(3, 12);
			stmt.addBatch();

			stmt.setString(1, "E003");
			stmt.setString(2, "Equipo de Investigación en Ciencias de la Vida");
			stmt.setInt(3, 13);
			stmt.addBatch();

			stmt.setString(1, "E004");
			stmt.setString(2, "Equipo de Investigación en Ingeniería");
			stmt.setInt(3, 14);
			stmt.addBatch();

			stmt.setString(1, "E005");
			stmt.setString(2, "Equipo de Investigación en Economía");
			stmt.setInt(3, 15);
			stmt.addBatch();

			stmt.executeBatch();
			System.out.println("Registros insertados en la tabla equipos");
		}
	}

	private static void insertarInvestigadores(Connection conexion) throws SQLException {
		String insertInvestigadoresQuery = "INSERT INTO investigadores (dni_investigador, nom_apels, cod_facultad) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conexion.prepareStatement(insertInvestigadoresQuery)) {
			stmt.setString(1, "12345678");
			stmt.setString(2, "Juan Pérez");
			stmt.setInt(3, 1);
			stmt.addBatch();

			stmt.setString(1, "23456789");
			stmt.setString(2, "María González");
			stmt.setInt(3, 2);
			stmt.addBatch();

			stmt.setString(1, "34567890");
			stmt.setString(2, "Pedro Sanchez");
			stmt.setInt(3, 3);
			stmt.addBatch();

			stmt.setString(1, "45678901");
			stmt.setString(2, "Ana López");
			stmt.setInt(3, 4);
			stmt.addBatch();

			stmt.setString(1, "56789012");
			stmt.setString(2, "Jose Martínez");
			stmt.setInt(3, 5);
			stmt.addBatch();
			stmt.executeBatch();
			System.out.println("Registros insertados en la tabla investigadores");
		}
	}

	private static void insertarReservas(Connection conexion) throws SQLException {
		String insertReservasQuery = "INSERT INTO reserva (comienzo, fin, dni_investigador, num_serie) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conexion.prepareStatement(insertReservasQuery)) {
			stmt.setString(1, "2022-01-01");
			stmt.setString(2, "2022-01-31");
			stmt.setString(3, "12345678");
			stmt.setString(4, "E001");
			stmt.addBatch();

			stmt.setString(1, "2022-02-01");
			stmt.setString(2, "2024-02-28");
			stmt.setString(3, "23456789");
			stmt.setString(4, "E002");
			stmt.addBatch();

			stmt.setString(1, "2024-03-01");
			stmt.setString(2, "2024-03-31");
			stmt.setString(3, "34567890");
			stmt.setString(4, "E003");
			stmt.addBatch();

			stmt.setString(1, "2024-04-01");
			stmt.setString(2, "2024-04-30");
			stmt.setString(3, "45678901");
			stmt.setString(4, "E004");
			stmt.addBatch();

			stmt.setString(1, "2024-05-05");
			stmt.setString(2, "2024-05-19");
			stmt.setString(3, "56789012");
			stmt.setString(4, "E005");
			stmt.addBatch();

			stmt.executeBatch();
			System.out.println("Registros insertados en la tabla reserva");
		}
	}
}
