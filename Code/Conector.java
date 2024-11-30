import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "");
        }
        return connection;
    }
}
