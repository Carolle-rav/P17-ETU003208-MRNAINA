package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MaConnection {
    private static final String baseName = "db_s2_ETU003208";
    private static final String userName = "ETU003208";
    private static final String password = "UsjfRqNY";
    private static Connection sqlConnection = null;

    public static Connection getSqlConnection() throws SQLException, ClassNotFoundException  {
        if (sqlConnection == null) {
            String url = "jdbc:mysql://localhost:3306/" + baseName;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                sqlConnection = DriverManager.getConnection(url, userName, password);
                System.out.println("Connexion réussie à MySQL !");
            } catch (ClassNotFoundException e) {
                throw e;
            } catch (SQLException e) {
                throw e;
            }
        }
        return sqlConnection;
    }

    public static Statement getMysqlStatement() throws SQLException, ClassNotFoundException {
        sqlConnection = MaConnection.getSqlConnection();
        return sqlConnection.createStatement();
    }

    public static void closeConnection() throws SQLException {
        try {
            if (sqlConnection != null && !sqlConnection.isClosed()) {
                sqlConnection.close();
                System.out.println("Connexion fermée avec succès !");
            }
        } catch (SQLException e) {
           throw e;
        }
    }
}
