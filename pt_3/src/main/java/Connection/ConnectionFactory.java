package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Realizeaza conexiunea cu baza de date
 * Contine metode pentru a crea conexiunea, a realiza sau inchide o conexiune activa,
 * si pentru a inchide un statement sau un rezultat
 */
public class ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    /**
     * Numele driver-ului. Initializarea se realizeaza prin reflection
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * Locatia bazei de date
     */
    private static final String DBURL = "jdbc:mysql://localhost:3306/schooldb";
    /**
     * User si parola necesara pentru a accesa baza de date
     */
    private static final String USER = "root";
    private static final String PASS = "edward23L";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Conexiunea cu baza de date foloseste un obiect de tipul Singleton (este instantiat doar o data)
     */
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }

}