package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Empleados {

    private static final String URL = "jdbc:mysql://localhost:3306/empleados_db?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión establecida");

            insertarDepartamentos(conexion);
            insertarEmpleados(conexion);

        } catch (SQLException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
            ex.printStackTrace();
        }
    }

    private static void insertarDepartamentos(Connection con) {
        String insertDepartamentosQuery = "INSERT IGNORE INTO departamentos (nombre, presupuesto) VALUES " +
                "('Compras', 15000), " +
                "('Contabilidad', 13000), " +
                "('Legal', 14000), " +
                "('Produccion', 16000), " +
                "('I+D', 17000)";

        ejecutarConsulta(con, insertDepartamentosQuery, "Registros insertados en la tabla departamentos");
    }

    private static void insertarEmpleados(Connection con) {
        String insertEmpleadosQuery = "INSERT INTO empleados (dni, nombre, apellidos, cod_departamento) VALUES " +
                "('12121212', 'Luis', 'Martín', 1), " +
                "('23232323', 'Lucía', 'Hernández', 2), " +
                "('34343434', 'Miguel', 'Ramírez', 3), " +
                "('45454545', 'Sofía', 'Romero', 4), " +
                "('56565656', 'Juan', 'Navarro', 5)";

        ejecutarConsulta(con, insertEmpleadosQuery, "Registros insertados en la tabla empleados");
    }

    private static void ejecutarConsulta(Connection con, String query, String mensajeExito) {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println(mensajeExito);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
        }
    }
}

