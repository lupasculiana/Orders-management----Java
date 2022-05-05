package Presentation;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * Interfata pentru stergerea unui client - citeste ID ul dat de utilizator si la apasarea butonului apeleaza metodele
 * necesare pentru a-l sterge din baza de date
 */
public class DeleteClientView extends JFrame {
    private JTextField deleteClientField;
    private JButton deleteClientButton;

    public DeleteClientView() {
        this.setBackground(new Color(240, 240, 240));
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 284, 288);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        deleteClientField = new JTextField();
        deleteClientField.setForeground(Color.BLACK);
        deleteClientField.setBounds(41, 110, 162, 39);
        this.getContentPane().add(deleteClientField);
        deleteClientField.setColumns(10);

        JLabel deleteClientLabel = new JLabel("Enter client id :");
        deleteClientLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        deleteClientLabel.setBounds(41, 78, 162, 22);
        this.getContentPane().add(deleteClientLabel);

        deleteClientButton = new JButton("delete client");
        deleteClientButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        deleteClientButton.setBounds(41, 172, 147, 21);
        this.getContentPane().add(deleteClientButton);

        this.setVisible(true);
    }
    public String getDeleteIdField() {
        return deleteClientField.getText();
    }

    public void addDeleteListener(ActionListener action) {
        this.deleteClientButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
