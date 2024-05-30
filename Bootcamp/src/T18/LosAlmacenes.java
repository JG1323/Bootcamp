package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LosAlmacenes {

	private static final String URL = "jdbc:mysql://localhost:3306/almacenes_db?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {
		try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
			System.out.println("Server Connected");

			insertarAlmacenes(conexion);
			insertarCajas(conexion);

		} catch (SQLException ex) {
			System.out.println("No se ha podido conectar con la base de datos");
			ex.printStackTrace();
		}
	}

	private static void insertarAlmacenes(Connection conexion) {
		String insertAlmacenesQuery = "INSERT IGNORE INTO almacenes (lugar, capacidad) VALUES (?, ?)";
		String[][] almacenes = { { "Gijon", "1000" }, { "Tarragona", "1200" }, { "Sevilla", "1100" },
				{ "Cadiz", "1300" }, { "Zaragoza", "1050" } };

		try (PreparedStatement statement = conexion.prepareStatement(insertAlmacenesQuery)) {
			for (String[] almacen : almacenes) {
				statement.setString(1, almacen[0]);
				statement.setInt(2, Integer.parseInt(almacen[1]));
				statement.executeUpdate();
			}
			System.out.println("Registros insertados en la tabla almacenes");
		} catch (SQLException e) {
			System.err.println("Error al insertar registros en la tabla almacenes: " + e.getMessage());
		}
	}

	private static void insertarCajas(Connection conexion) {
		String insertCajasQuery = "INSERT IGNORE INTO cajas (num_referencia, contenido, valor, cod_almacen) VALUES (?, ?, ?, ?)";
		Object[][] cajas = { { "C001", "Altavoz", 50, 11 }, { "C002", "Ordenador", 70, 12 }, { "C003", "PS4", 60, 13 },
				{ "C004", "XBOX one", 80, 14 }, { "C005", "Cachimba", 65, 15 } };

		try (PreparedStatement statement = conexion.prepareStatement(insertCajasQuery)) {
			for (Object[] caja : cajas) {
				statement.setString(1, (String) caja[0]);
				statement.setString(2, (String) caja[1]);
				statement.setInt(3, (int) caja[2]);
				statement.setInt(4, (int) caja[3]);
				statement.executeUpdate();
			}
			System.out.println("Registros insertados en la tabla cajas");
		} catch (SQLException e) {
			System.err.println("Error al insertar registros en la tabla cajas: " + e.getMessage());
		}
	}
}
