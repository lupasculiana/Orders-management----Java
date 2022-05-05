package Presentation;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * Interfata in care utilizatorul va alege ce actiune doreste sa aplice clientilor/produselor - la apasarea
 * unui buton, o noua fereastra specifica actiunii alese se va deschide
 */
public class View extends JFrame {
    private JButton newClientButton;
    private JButton editClientButton;
    private JButton deleteClientButton;
    private JButton newProductButton;
    private JButton editProductButton;
    private JButton deleteProductButton;
    private JButton viewClientsButton;
    private JButton viewProductsButton;

    public View() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 715, 519);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Orders management");
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setBounds(110, 24, 247, 45);
        this.getContentPane().add(titleLabel);

        newClientButton = new JButton("add new client");
        newClientButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        newClientButton.setForeground(Color.DARK_GRAY);
        newClientButton.setBounds(36, 87, 182, 45);
        this.getContentPane().add(newClientButton);

        editClientButton = new JButton("edit client");
        editClientButton.setForeground(Color.DARK_GRAY);
        editClientButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editClientButton.setBounds(36, 155, 182, 45);
        this.getContentPane().add(editClientButton);

         deleteClientButton = new JButton("delete client");
        deleteClientButton.setForeground(Color.DARK_GRAY);
        deleteClientButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        deleteClientButton.setBounds(36, 232, 182, 45);
        this.getContentPane().add(deleteClientButton);

         newProductButton = new JButton("add new product");
        newProductButton.setForeground(Color.DARK_GRAY);
        newProductButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        newProductButton.setBounds(255, 87, 182, 45);
        this.getContentPane().add(newProductButton);

         editProductButton = new JButton("edit product");
        editProductButton.setForeground(Color.DARK_GRAY);
        editProductButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        editProductButton.setBounds(255, 155, 182, 45);
        this.getContentPane().add(editProductButton);

         deleteProductButton = new JButton("delete product");
        deleteProductButton.setForeground(Color.DARK_GRAY);
        deleteProductButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        deleteProductButton.setBounds(255, 232, 182, 45);
        this.getContentPane().add(deleteProductButton);

         viewClientsButton = new JButton("view all clients");
        viewClientsButton.setForeground(Color.DARK_GRAY);
        viewClientsButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        viewClientsButton.setBounds(36, 300, 182, 45);
        this.getContentPane().add(viewClientsButton);

         viewProductsButton = new JButton("view all products");
        viewProductsButton.setForeground(Color.DARK_GRAY);
        viewProductsButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        viewProductsButton.setBounds(255, 300, 182, 45);
        this.getContentPane().add(viewProductsButton);

        this.setVisible(true);
    }
    public void addNewClientListener(ActionListener action) {
        this.newClientButton.addActionListener(action);
    }
    public void addNewProductListener(ActionListener action) {
        this.newProductButton.addActionListener(action);
    }
    public void addEditClientListener(ActionListener action) {
        this.editClientButton.addActionListener(action);
    }
    public void addEditProductListener(ActionListener action) {
        this.editProductButton.addActionListener(action);
    }
    public void addDeleteClientListener(ActionListener action) {
        this.deleteClientButton.addActionListener(action);
    }
    public void addDeleteProductListener(ActionListener action) {
        this.deleteProductButton.addActionListener(action);
    }
    public void addViewProductsListener(ActionListener action) {
        this.viewProductsButton.addActionListener(action);
    }
    public void addViewClientsListener(ActionListener action) {this.viewClientsButton.addActionListener(action);}

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

