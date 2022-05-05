package Presentation;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * Interfata pentru stergerea unui produs - citeste ID ul dat de utilizator si la apasarea butonului apeleaza metodele
 * necesare pentru a-l sterge din baza de date
 */
public class DeleteProductView extends JFrame {
    private JTextField deleteProductField;
    private JButton deleteProductButton;

    public DeleteProductView() {
        this.setBackground(new Color(240, 240, 240));
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 284, 288);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        deleteProductField = new JTextField();
        deleteProductField.setForeground(Color.BLACK);
        deleteProductField.setBounds(41, 110, 162, 39);
        this.getContentPane().add(deleteProductField);
        deleteProductField.setColumns(10);

        JLabel deleteProductLabel = new JLabel("Enter product id :");
        deleteProductLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        deleteProductLabel.setBounds(41, 78, 162, 22);
        this.getContentPane().add(deleteProductLabel);

        deleteProductButton = new JButton("delete product");
        deleteProductButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        deleteProductButton.setBounds(41, 172, 147, 21);
        this.getContentPane().add(deleteProductButton);

        this.setVisible(true);
    }
    public String getDeleteIdField() {
        return deleteProductField.getText();
    }

    public void addDeleteListener(ActionListener action) {
        this.deleteProductButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
