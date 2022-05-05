package Presentation;
import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller pentru fereastra de baza - la apasarea butonului de clients/products deschide meniul cu actiuni pentru
 * editarea acestora, iar la apasarea butonului de place order deschide fereastra pentru inserarea unei comenzi noi
 */
public class ControllerFinal {
    private ViewFinal view;

    public ControllerFinal(ViewFinal view) {
        this.view = view;
        this.view.addClientsListener(new ClientsListener());
        this.view.addOrderListener(new OrderListener());
    }

    class ClientsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                View view = new View();
                Controller controller = new Controller(view);
            } catch (Exception exception) {
                view.showMessage("Error :( ");
                System.out.println(exception);
            }
        }
    }

    class OrderListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                OrderView view = new OrderView();
                ClientBLL clientBLL = new ClientBLL();
                ProductBLL productBLL = new ProductBLL();
                OrderBLL orderBLL = new OrderBLL();
                OrderController controller = new OrderController(view,clientBLL,productBLL,orderBLL);
            } catch (Exception exception) {
                view.showMessage("Error :( ");
                System.out.println(exception);
            }
        }
    }
}