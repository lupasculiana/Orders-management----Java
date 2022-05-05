package Presentation;
import BusinessLogic.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * Controller pentru interfata in care se realizeaza fiecare comanda. La apasarea butonului action listener-ul preia
 * datele specificate de utilizator si realizeaza comanda. La final se va genera un bon digital cu informatiile
 * comenzii, si se va updata stocul produsului cumparat
 */
public class OrderController {
    private OrderView view;
    private ClientBLL clientBLL;
    private ProductBLL productBLL;
    private OrderBLL orderBLL;

    public OrderController(OrderView view, ClientBLL clientBLL, ProductBLL productBLL, OrderBLL orderBLL) {
        this.view = view;
        this.clientBLL = clientBLL;
        this.productBLL = productBLL;
        this.orderBLL = orderBLL;
        this.view.addEnterListener(new EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                client client = clientBLL.findClientByName(view.getProductField());
                product product = productBLL.findProductByName(view.getClientField());
                Random rand = new Random();
                Integer orderNr = rand.nextInt(1000);
                Order order = new Order(client,product,view.getQuantityField());
                order.setIdorder(orderNr.toString());
                order.checkAmount();
                orderBLL.insertOrder(order);
                order.getProduct().setStoc(String.valueOf(Integer.parseInt(order.getProduct().getStoc())-order.getAmount()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("bon_digital_"+order.getIdorder()+".txt"))));
                writer.write(order.toString());
                writer.flush();

            } catch (Exception exception) {
                view.showMessage("Not enough stock of the product! ");
                System.out.println(exception);
                exception.printStackTrace();
            }
        }
    }
}