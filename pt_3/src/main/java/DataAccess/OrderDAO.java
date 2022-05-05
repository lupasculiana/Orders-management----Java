package DataAccess;
import Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import Connection.ConnectionFactory;
/**
 * Apeluri directe catre baza de date - este o clasa specifica pentru functiile order si va fi folosita pentru a realiza
 * si executa query-uri
 */
public class OrderDAO extends AbstractDAO<product> {

    // uses basic CRUD methods from superclass
    /**
     *
     * @param order
     * @return String
     * Query specific pentru order, realizeaza statement-ul necesar la inserarea unui order nou in tabel
     */
    public String createInsertOrderQuery(Order order){
        String sb = "INSERT INTO schooldb.order (idclient,idproduct,idorder)" +
                " VALUES ('" +
                order.getClient().getIdclient() + "', '" +
                order.getProduct().getIdproduct() + "', '" +
                order.getIdorder() +
                "');";
        return sb;
    }

    /**
     *
     * @param order
     * Realizeaza conexiunea cu baza de date, construieste query-ul prin apelarea functiei specifice, si insereaza
     * comanda primit ca parametru in baza de date
     */
    public void insertOrder(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createInsertOrderQuery(order);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

}