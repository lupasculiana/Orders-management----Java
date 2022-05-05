package DataAccess;
import Model.client;
import Presentation.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import  Connection.ConnectionFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Apeluri directe catre baza de date - este o clasa specifica pentru functiile client si va fi folosita pentru a realiza
 * si executa query-uri
 */
public class ClientDAO extends AbstractDAO<client> {

    /**
     * va fi folosit ulterior pentru a afisa tabelul de clienti
     */
    private static EmptyView view;

    public ClientDAO() {};

    public ClientDAO(EmptyView view) {
        this.view = view;
    }

    /**
     *
     * @param client
     * @return String
     * Query specific pentru client, realizeaza statement-ul necesar la inserarea unui client nou in tabel
     */
    public String createInsertQuery(client client){
        String sb = "INSERT INTO client (idclient, nume, prenume, email, adresa)" +
                " VALUES ('" +
                client.getIdclient() + "', '" +
                client.getNume() + "', '" +
                client.getPrenume() + "', '" +
                client.getEmail() + "', '" +
                client.getAdresa() +
                "');";
        return sb;
    }

    public String createDeleteQuery(client client){
        String sb = "DELETE FROM client WHERE idclient = '" +
                client.getIdclient() + "'; " ;
        System.out.println(sb);
        return sb;
    }

    /**
     *
     * @param client
     * Realizeaza conexiunea cu baza de date, construieste query-ul prin apelarea functiei specifice, si insereaza
     * clientul primit ca parametru in baza de date
     */
    public void insertClient(client client) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createInsertQuery(client);
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

    /**
     *
     * @param client
     * Realizeaza conexiunea cu baza de date, construieste query-ul prin apelarea functiei specifice, si sterge
     * clientul primit ca parametru din baza de date
     */
    public void deleteClient(client client) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery(client);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * @throws SQLException
     * Face rost de datele tuturor clientilor din tabel, initializeaza tabelul din GUI, si il populeaza apeland functia din
     * AbstractDAO
     */
    public void viewAllClients() throws SQLException {

        ArrayList<client> clients = getClientsList();

        JScrollPane myScrollPane = new JScrollPane();
        myScrollPane.setBounds(250, 70, 600, 400);

        JTable clientTable = new JTable();
        clientTable=createTable(clients);
        clientTable.setEnabled(true);
        clientTable.setVisible(true);

        myScrollPane.setViewportView(clientTable);
        view.getContentPane().add(myScrollPane);
    }

    /**
     *
     * @throws SQLException
     * Realizeaza conexiunea cu baza de date, apeleaza query-ul in care preia toate informatiile clientiilor din tabelul client,
     * si realizeaza un ArrayList cu toti clientii, pe care ii initializeaza folosind rezultatele din baza de date
     */
    public ArrayList<client> getClientsList() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                client newClient = new client(resultSet.getString("idclient"), resultSet.getString("nume"), resultSet.getString("prenume"),resultSet.getString("email"),
                        resultSet.getString("adresa"));
                clients.add(newClient);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:table " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return clients;
    }

    /**
     * @throws SQLException
     * La fel ca metoda getClientsList(), dar selecteaza doar numele acestora. Va fi folosita la initializarea
     * combo box-ului in interfata GUI pentru realizarea unei comenzi
     */
    public ArrayList<String> getClientsNamesList() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT nume FROM client";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String newClient = resultSet.getString("nume");
                names.add(newClient);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:scroll panel " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return names;
    }
}
