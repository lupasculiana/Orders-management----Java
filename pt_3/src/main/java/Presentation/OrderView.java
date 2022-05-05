package Presentation;

import DataAccess.ClientDAO;
import DataAccess.ProductDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfata pentru realizarea unei comenzi noi - utilizatorul selecteaza din comboBox clientul si produsul pe care-l doreste,
 * specificand cantitatea produsului dorit. La apasarea butonului informatiile sunt trimise spre controller
 */
public class OrderView extends JFrame{

    private JComboBox comboBoxClients;
    private JComboBox comboBoxProducts;
    private JTextField quantityField;
    private JButton enterButton;

    public OrderView() throws SQLException {
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 344, 417);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        ClientDAO clientDAO = new ClientDAO();
        ArrayList<String> namesList = clientDAO.getClientsNamesList();
        comboBoxClients = new JComboBox();
        comboBoxClients.setFont(new Font("Tahoma",Font.BOLD | Font.ITALIC, 20));
        comboBoxClients.setForeground(Color.BLACK);
        comboBoxClients.setModel(new DefaultComboBoxModel(namesList.toArray()));
        comboBoxClients.setBounds(30, 59, 150, 45);
        this.getContentPane().add(comboBoxClients);

        ProductDAO productDAO = new ProductDAO();
        ArrayList<String> namesProductsList = productDAO.getProductsNamesList();
        comboBoxProducts = new JComboBox();
        comboBoxProducts.setFont(new Font("Tahoma",Font.BOLD | Font.ITALIC, 20));
        comboBoxProducts.setForeground(Color.BLACK);
        comboBoxProducts.setModel(new DefaultComboBoxModel(namesProductsList.toArray()));
        comboBoxProducts.setBounds(30, 159, 150, 45);
        this.getContentPane().add(comboBoxProducts);

        JLabel clientLabel = new JLabel("Select client id :");
        clientLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        clientLabel.setBounds(30, 30, 160, 19);
        this.getContentPane().add(clientLabel);

        JLabel productLabel = new JLabel("Select product id :");
        productLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        productLabel.setBounds(30, 127, 183, 19);
        this.getContentPane().add(productLabel);

        JLabel quantityLabel = new JLabel("Insert quantity of selected product :");
        quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        quantityLabel.setBounds(30, 214, 286, 19);
        this.getContentPane().add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(30, 243, 142, 31);
        this.getContentPane().add(quantityField);
        quantityField.setColumns(10);

        enterButton = new JButton("place order");
        enterButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        enterButton.setBounds(30, 294, 122, 42);
        this.getContentPane().add(enterButton);

        this.setVisible(true);
    }

    public int getQuantityField() { return Integer.parseInt(this.quantityField.getText());}

    public void addEnterListener(ActionListener action) {
        this.enterButton.addActionListener(action);
    }

    public String getClientField(){return this.comboBoxProducts.getSelectedItem().toString();}

    public String getProductField(){return this.comboBoxClients.getSelectedItem().toString();}

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
