package Presentation;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * Interfata pentru inserarea unui produs - utilizatorul introduce datele noului produs si la apasarea butonului
 * acesta este introdus in tabel
 */
public class NewProductView extends JFrame {

    private JTextField numeField;
    private JTextField stocField;
    private JButton enterButton;

    public NewProductView() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 715, 519);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        numeField = new JTextField();
        numeField.setBounds(40, 61, 223, 48);
        this.getContentPane().add(numeField);
        numeField.setColumns(10);

        stocField = new JTextField();
        stocField.setColumns(10);
        stocField.setBounds(40, 134, 223, 48);
        this.getContentPane().add(stocField);

        JLabel numeLabel = new JLabel("Nume");
        numeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        numeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        numeLabel.setBounds(40, 25, 120, 26);
        this.getContentPane().add(numeLabel);

        JLabel stocLabel = new JLabel("Stoc");
        stocLabel.setHorizontalAlignment(SwingConstants.LEFT);
        stocLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        stocLabel.setBounds(40, 106, 120, 26);
        this.getContentPane().add(stocLabel);

        enterButton = new JButton("Enter product\r\n");
        enterButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        enterButton.setBounds(90, 355, 128, 36);
        this.getContentPane().add(enterButton);

        this.setVisible(true);
    }

    public String getNumeField() {
        return numeField.getText();
    }

    public String getStocField() {
        return stocField.getText();
    }

    public void addEnterListener(ActionListener action) {
        this.enterButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        this.refresh();
    }

    public void refresh() {
        this.numeField.setText((String)null);
        this.stocField.setText((String)null);
    }
}
