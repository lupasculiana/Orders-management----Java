package Presentation;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * Interfata pentru editarea unui produs - utilizatorul introduce campul pe care doreste sa-l modifice si datele noi ale
 * produsului dorit, iar la apasarea butonului produsul este modificat
 */
public class EditProductView extends JFrame {

    private JTextField productField;
    private JTextField columnField;
    private JTextField valueField;
    private JButton updateButton;

    public EditProductView() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 349, 417);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel columnLabel = new JLabel("Field that you want to be updated :");
        columnLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        columnLabel.setBounds(10, 108, 341, 25);
        this.getContentPane().add(columnLabel);

        JLabel clientLabel = new JLabel("Product that you want to update :");
        clientLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        clientLabel.setBounds(10, 29, 341, 25);
        this.getContentPane().add(clientLabel);

        JLabel valueLabel = new JLabel("Value that you want to update with :");
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        valueLabel.setBounds(10, 190, 341, 25);
        this.getContentPane().add(valueLabel);

        productField = new JTextField();
        productField.setBounds(10, 64, 156, 34);
        this.getContentPane().add(productField);
        productField.setColumns(10);

        columnField = new JTextField();
        columnField.setColumns(10);
        columnField.setBounds(10, 146, 156, 34);
        this.getContentPane().add(columnField);

        valueField = new JTextField();
        valueField.setColumns(10);
        valueField.setBounds(10, 230, 156, 34);
        this.getContentPane().add(valueField);

        updateButton = new JButton("update\r\n\r\n");
        updateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        updateButton.setBounds(10, 296, 127, 42);
        this.getContentPane().add(updateButton);

        this.setVisible(true);
    }

    public String getProductField() {
        return productField.getText();
    }

    public String  getColumnField() {
        return columnField.getText();
    }

    public String getValueField() {
        return valueField.getText();
    }

    public void addUpdateListener(ActionListener action) {
        this.updateButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
