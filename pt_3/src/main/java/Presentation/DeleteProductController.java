package Presentation;
import BusinessLogic.ProductBLL;
import Model.product;
import Presentation.DeleteProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfata pentru stergerea unui produs - citeste ID ul dat de utilizator si la apasarea butonului apeleaza metodele
 * necesare pentru a-l sterge din baza de date
 */
public class DeleteProductController {
    private DeleteProductView view;
    private ProductBLL productBLL;

    public DeleteProductController(DeleteProductView view, ProductBLL productBLL) {
        this.view = view;
        this.productBLL = productBLL;
        this.view.addDeleteListener(new EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                product product = productBLL.findProductById(Integer.parseInt(view.getDeleteIdField()));
                productBLL.deleteProduct(product);
            } catch (Exception exception) {
                view.showMessage("Error :( ");
                System.out.println(exception);
            }
        }
    }
}