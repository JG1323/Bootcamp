package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LosGrandesAlmacenes {
	
	private static final String URL = "jdbc:mysql://localhost:3306/GrandesAlmacenes";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
            insertarCajeros(conexion);
            insertarMaquinasRegistradoras(conexion);
            insertarProductos(conexion);
            insertarVentas(conexion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertarCajeros(Connection conexion) throws SQLException {
        String insertCajerosQuery = "INSERT INTO cajeros (cod_cajero, nom_apels) VALUES (?, ?)";
        Object[][] cajeros = {
                {11, "Roberto Molina"},
                {12, "Carmen Herrero"},
                {13, "Javier Moreno"},
                {14, "Isabel Jiménez"},
                {15, "Oscar Vargas"}
        };

        try (PreparedStatement stmt = conexion.prepareStatement(insertCajerosQuery)) {
            for (Object[] cajero : cajeros) {
                stmt.setInt(1, (int) cajero[0]);
                stmt.setString(2, (String) cajero[1]);
                stmt.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla cajeros");
        }
    }

    private static void insertarMaquinasRegistradoras(Connection conexion) throws SQLException {
        String insertMaquinasQuery = "INSERT INTO maquinas_registradoras (cod_maquina, piso) VALUES (?, ?)";
        Object[][] maquinas = {
                {1, 1},
                {2, 2},
                {3, 1},
                {4, 3},
                {5, 2}
        };

        try (PreparedStatement stmt = conexion.prepareStatement(insertMaquinasQuery)) {
            for (Object[] maquina : maquinas) {
                stmt.setInt(1, (int) maquina[0]);
                stmt.setInt(2, (int) maquina[1]);
                stmt.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla maquinas_registradoras");
        }
    }

    private static void insertarProductos(Connection conexion) throws SQLException {
        String insertProductosQuery = "INSERT INTO productos (cod_producto, nombre, precio) VALUES (?, ?, ?)";
        Object[][] productos = {
                {501, "Producto A", 19},
                {502, "Producto B", 48},
                {503, "Producto C", 36},
                {504, "Producto D", 32},
                {505, "Producto E", 25}
        };

        try (PreparedStatement stmt = conexion.prepareStatement(insertProductosQuery)) {
            for (Object[] producto : productos) {
                stmt.setInt(1, (int) producto[0]);
                stmt.setString(2, (String) producto[1]);
                stmt.setInt(3, (int) producto[2]);
                stmt.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla productos");
        }
    }

    private static void insertarVentas(Connection conexion) throws SQLException {
        String insertVentasQuery = "INSERT INTO venta (cod_cajero, cod_maquina, cod_producto) VALUES (?, ?, ?)";
        Object[][] ventas = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4},
                {5, 5, 5}
        };

        try (PreparedStatement stmt = conexion.prepareStatement(insertVentasQuery)) {
            for (Object[] venta : ventas) {
                stmt.setInt(1, (int) venta[0]);
                stmt.setInt(2, (int) venta[1]);
                stmt.setInt(3, (int) venta[2]);
                stmt.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla venta");
        }
    }
}
