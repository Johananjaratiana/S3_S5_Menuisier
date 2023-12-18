package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/johan_s3";  // Correct the JDBC URL
    private static final String user = "postgres";
    private static final String mdp = "postgres";

    public static Connection GetConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");  // Correct the driver class name
            connection = DriverManager.getConnection(jdbcUrl, user, mdp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle ClassNotFoundException
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQLException
        }
        return connection;
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
