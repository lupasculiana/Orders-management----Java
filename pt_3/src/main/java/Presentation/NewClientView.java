package Presentation;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 * Interfata pentru inserarea unui client - utilizatorul introduce datele noului client si la apasarea butonului
 * acesta este introdus in tabel
 */
public class NewClientView extends JFrame {

    private JTextField numeField;
    private JTextField prenumeField;
    private JTextField emailField;
    private JTextField adresaField;
    private JButton enterButton;

    public NewClientView() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 715, 519);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        numeField = new JTextField();
        numeField.setBounds(40, 61, 223, 48);
        this.getContentPane().add(numeField);
        numeField.setColumns(10);

        prenumeField = new JTextField();
        prenumeField.setColumns(10);
        prenumeField.setBounds(40, 134, 223, 48);
        this.getContentPane().add(prenumeField);

        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(40, 206, 223, 48);
        this.getContentPane().add(emailField);

        adresaField = new JTextField();
        adresaField.setColumns(10);
        adresaField.setBounds(40, 287, 223, 48);
        this.getContentPane().add(adresaField);

        JLabel numeLabel = new JLabel("Nume");
        numeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        numeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        numeLabel.setBounds(40, 25, 120, 26);
        this.getContentPane().add(numeLabel);

        JLabel prenumeLabel = new JLabel("Prenume");
        prenumeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        prenumeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        prenumeLabel.setBounds(40, 106, 120, 26);
        this.getContentPane().add(prenumeLabel);

        JLabel emailLabel = new JLabel("Email\r\n");
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        emailLabel.setBounds(40, 185, 120, 26);
        this.getContentPane().add(emailLabel);

        JLabel adresaLabel = new JLabel("Adresa\r\n");
        adresaLabel.setHorizontalAlignment(SwingConstants.LEFT);
        adresaLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        adresaLabel.setBounds(40, 262, 120, 26);
        this.getContentPane().add(adresaLabel);

        enterButton = new JButton("Enter client\r\n");
        enterButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        enterButton.setBounds(90, 355, 128, 36);
        this.getContentPane().add(enterButton);

        this.setVisible(true);
    }

    public String getNumeField() {
        return numeField.getText();
    }

    public String  getPrenumeField() {
        return prenumeField.getText();
    }

    public String getEmailField() {
        return emailField.getText();
    }

    public String getAdresaField() {
        return adresaField.getText();
    }

    public void addEnterListener(ActionListener action) {
        this.enterButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }


}
