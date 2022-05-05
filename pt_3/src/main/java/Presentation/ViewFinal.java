package Presentation;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * Fereastra de baza - utilizatorul alege daca doreste sa aplice actiuni pe clienti/produse sau sa realizeze
 * o comanda noua
 */
public class ViewFinal extends JFrame {

    JButton clientsButton;
    JButton orderButton;

    public ViewFinal(){
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 344, 269);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel selectLabel = new JLabel("Select the operation needed :");
        selectLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        selectLabel.setBounds(45, 52, 240, 19);
        this.getContentPane().add(selectLabel);

        clientsButton = new JButton("clients/products");
        clientsButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        clientsButton.setBounds(79, 92, 151, 42);
        this.getContentPane().add(clientsButton);

        orderButton = new JButton("place order");
        orderButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        orderButton.setBounds(79, 155, 151, 42);
        this.getContentPane().add(orderButton);

        this.setVisible(true);
    }

    public void addClientsListener(ActionListener action) {this.clientsButton.addActionListener(action);}

    public void addOrderListener(ActionListener action) {this.orderButton.addActionListener(action);}

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
