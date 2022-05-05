package Presentation;
import javax.swing.JFrame;
import java.awt.Color;

/**
 * Un frame gol - va fi folosit pentru a introduce in el tabelul de vizualizare a clientilor/produselor
 */
public class EmptyView extends JFrame{

    public EmptyView() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(100, 100, 722, 416);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setVisible(true);
    }
}
