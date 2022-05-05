package DataAccess;
import Model.product;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import Connection.ConnectionFactory;
import Presentation.EmptyView;
import javax.swing.*;

/**
 * Apeluri directe catre baza de date - este o clasa specifica pentru functiile produs si va fi folosita pentru a realiza
 * si executa query-uri
 */
public class ProductDAO extends AbstractDAO<product> {

    /**
     * va fi folosit ulterior pentru a afisa tabelul de produse
     */
    private static EmptyView view;

    public ProductDAO() {};

    public ProductDAO(EmptyView view) {
        this.view = view;
    }
    // uses basic CRUD methods from superclass
    /**
     *
     * @param product
     * @return String
     * Query specific pentru produs, realizeaza statement-ul necesar la inserarea unui produs nou in tabel
     */
    public String createInsertProductQuery(product product){
        String sb = "INSERT INTO product (idproduct,nume,stoc,pret)" +
                " VALUES ('" +
                product.getIdproduct() + "', '" +
                product.getNume() + "', '" +
                product.getStoc() + "', '" +
                product.getPret() +
                "');";
        return sb;
    }

    public String createDeleteQuery(product product){
        String sb = "DELETE FROM product WHERE idproduct = '" +
                product.getIdproduct() + "'; " ;
        return sb;
    }

    /**
     *
     * @param product
     * Realizeaza conexiunea cu baza de date, construieste query-ul prin apelarea functiei specifice, si insereaza
     * produsul primit ca parametru in baza de date
     */
    public void insertProduct(product product) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createInsertProductQuery(product);
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
     * @param product
     * Realizeaza conexiunea cu baza de date, construieste query-ul prin apelarea functiei specifice, si sterge
     * produsul primit ca parametru din baza de date
     */
    public void deleteProduct(product product) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery(product);
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
     * Face rost de datele tuturor produselor din tabel, initializeaza tabelul din GUI, si il populeaza apeland functia din
     * AbstractDAO
     */
    public void viewAllProducts() throws SQLException {

        ArrayList<product> products = getProductsList();

        JScrollPane myScrollPane = new JScrollPane();
        myScrollPane.setBounds(250, 70, 600, 400);

        JTable productTable = new JTable();
        productTable=createTable(products);
        productTable.setEnabled(true);
        productTable.setVisible(true);

        myScrollPane.setViewportView(productTable);
        view.getContentPane().add(myScrollPane);
    }

    /**
     *
     * @throws SQLException
     * Realizeaza conexiunea cu baza de date, apeleaza query-ul in care preia toate informatiile produselor din tabelul product,
     * si realizeaza un ArrayList cu toate produsele, pe care ii initializeaza folosind rezultatele din baza de date
     */
    public ArrayList<product> getProductsList() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product product = new product(resultSet.getString("idproduct"), resultSet.getString("nume"), resultSet.getString("stoc"), resultSet.getString("pret"));
                products.add(product);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, getClass().getName() + "DAO:table " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return products;
    }

    /**
     *
     * @throws SQLException
     * La fel ca metoda getProductsList(), dar selecteaza doar numele acestora. Va fi folosita la initializarea
     * combo box-ului in interfata GUI pentru realizarea unei comenzi
     */
    public ArrayList<String> getProductsNamesList() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT nume FROM product";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String newProduct = resultSet.getString("nume");
                names.add(newProduct);
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
