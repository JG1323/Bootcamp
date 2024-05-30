package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PiezasyProveedores {

	private static final String URL = "jdbc:mysql://localhost:3306/piezas_proveedores?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Server Connected");

            insertarPiezas(conexion);
            insertarProveedores(conexion);
            insertarSuministra(conexion);

        } catch (SQLException ex) {
            System.out.println("No se ha podido conectar con mi base de datos");
            ex.printStackTrace();
        }
    }

    private static void insertarPiezas(Connection conexion) {
        String insertPiezasQuery = "INSERT INTO piezas (cod_pieza, nombre) VALUES (?, ?)";
        Object[][] piezas = {
            {1, "Pieza-Motor"},
            {2, "Pieza-Frenos"},
            {3, "Pieza-Volante"},
            {4, "Pieza-Luces"},
            {5, "Pieza-Bujias"},
            {6, "Pieza-Retrovisor"},
            {7, "Pieza-Transmisión"},
            {8, "Pieza-Luces de freno"},
            {9, "Pieza-Asiento"},
            {10, "Pieza-Cambio de marchas"}
        };

        try (PreparedStatement statement = conexion.prepareStatement(insertPiezasQuery)) {
            for (Object[] pieza : piezas) {
                statement.setInt(1, (int) pieza[0]);
                statement.setString(2, (String) pieza[1]);
                statement.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla piezas");
        } catch (SQLException e) {
            System.err.println("Error al insertar registros en la tabla piezas: " + e.getMessage());
        }
    }

    private static void insertarProveedores(Connection conexion) {
        String insertProveedoresQuery = "INSERT INTO proveedores (id_proveedor, nombre) VALUES (?, ?)";
        Object[][] proveedores = {
            {"1", "Bosch"},
            {"2", "A.B.S"},
            {"3", "Ridex"},
            {"4", "Stark"},
            {"5", "TRW"},
            {"6", "ATE"},
            {"7", "Brembo"},
            {"8", "Vaico"},
            {"9", "Mapco"},
            {"10", "Valeo"}
        };

        try (PreparedStatement statement = conexion.prepareStatement(insertProveedoresQuery)) {
            for (Object[] proveedor : proveedores) {
                statement.setString(1, (String) proveedor[0]);
                statement.setString(2, (String) proveedor[1]);
                statement.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla proveedores");
        } catch (SQLException e) {
            System.err.println("Error al insertar registros en la tabla proveedores: " + e.getMessage());
        }
    }

    private static void insertarSuministra(Connection conexion) {
        String insertSuministraQuery = "INSERT INTO suministra (precio, cod_pieza, id_proveedor) VALUES (?, ?, ?)";
        Object[][] suministros = {
            {200.25,"1", "1"},
            {69.99, "2", "2"},
            {82.05, "3", "3"},
            {300.00,"4", "4"},
            {225.55, "5", "5"},
            {120.34, "6", "6"},
            {230.34, "7", "7"},
            {527.76, "8", "8"},
            {199.56, "9", "9"},
            {246.88, "10", "10"}
        };

        try (PreparedStatement statement = conexion.prepareStatement(insertSuministraQuery)) {
            for (Object[] suministro : suministros) {
                statement.setInt(1, (int) suministro[0]);
                statement.setString(2, (String) suministro[1]);
                statement.setString(3, (String) suministro[2]);
                statement.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla suministra");
        } catch (SQLException e) {
            System.err.println("Error al insertar registros en la tabla suministra: " + e.getMessage());
        }
    }
}
