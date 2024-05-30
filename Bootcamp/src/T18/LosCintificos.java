package T18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LosCintificos {

	public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cientificos_db", "root", "");
            System.out.println("Conexión establecida con la base de datos");

            insertarCientificos(conexion);
            insertarProyecto(conexion);
            insertarAsignadoA(conexion);

            conexion.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
            ex.printStackTrace();
        }
    }

    private static void insertarCientificos(Connection conexion) {
        String insertCientificosQuery = "INSERT INTO cientificos (dni_cientifico, nom_apels) VALUES (?, ?)";
        Object[][] cientificos = {
        		{"8765432B", "Alejandro Martinez Calvo"},
                {"9012345J", "Adrian Vega Belsue"},
                {"8901234I", "Jose Vazquez Rodriguez"},
                {"4567890E", "Alba García Lopez"},
                {"7890123H", "Vanessa Pérez Martinez"},
                {"3769824A", "Ian Vega Cano"},
                {"3456789D", "Nuria Gópmez Fernández"},
                {"6789012G", "Nerea Martinez Sole"},
                {"2345678C", "Kyle García Rodriguez"},
                {"56789012", "Luca Ortega Marin"}
        };

        try (PreparedStatement statement = conexion.prepareStatement(insertCientificosQuery)) {
            for (Object[] cientifico : cientificos) {
                statement.setString(1, (String) cientifico[0]);
                statement.setString(2, (String) cientifico[1]);
                statement.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla cientificos");
        } catch (SQLException e) {
            System.err.println("Error al insertar registros en la tabla cientificos: " + e.getMessage());
        }
    }

    private static void insertarProyecto(Connection conexion) {
        String insertProyectoQuery = "INSERT INTO proyecto (id_proyecto, nombre, horas) VALUES (?, ?, ?)";
        Object[][] proyectos = {
        		{"P001", "Desarrollo de Software", 100},
                {"P002", "Investigación Médica", 220},
                {"P003", "Ingeniería Ambiental", 150},
                {"P004", "Robótica Avanzada", 190},
                {"P005", "Inteligencia Artificial", 130},
                {"P006", "Nanotecnología", 120},
                {"P007", "Bioinformática", 90},
                {"P008", "Realidad Virtual", 200},
                {"P009", "Exploración Espacial", 240},
                {"P010", "Biotecnología", 170}
        };

        try (PreparedStatement statement = conexion.prepareStatement(insertProyectoQuery)) {
            for (Object[] proyecto : proyectos) {
                statement.setString(1, (String) proyecto[0]);
                statement.setString(2, (String) proyecto[1]);
                statement.setInt(3, (int) proyecto[2]);
                statement.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla proyecto");
        } catch (SQLException e) {
            System.err.println("Error al insertar registros en la tabla proyecto: " + e.getMessage());
        }
    }

    private static void insertarAsignadoA(Connection conexion) {
        String insertAsignadoAQuery = "INSERT INTO asignado_a (dni_cientifico, id_proyecto) VALUES (?, ?)";
        Object[][] asignados = {
        		   {"8765432B", "P001"},
                   {"9012345J", "P002"},
                   {"8901234I", "P003"},
                   {"4567890E", "P004"},
                   {"7890123H", "P005"},
                   {"3769824A", "P006"},
                   {"3456789D", "P007"},
                   {"6789012G", "P008"},
                   {"2345678C", "P009"},
                   {"56789012", "P010"}
        };

        try (PreparedStatement statement = conexion.prepareStatement(insertAsignadoAQuery)) {
            for (Object[] asignado : asignados) {
                statement.setString(1, (String) asignado[0]);
                statement.setString(2, (String) asignado[1]);
                statement.executeUpdate();
            }
            System.out.println("Registros insertados en la tabla asignado_a");
        } catch (SQLException e) {
            System.err.println("Error al insertar registros en la tabla asignado_a: " + e.getMessage());
        }
    }
}
