package Presentation;
import BusinessLogic.ProductBLL;
import Model.product;
import Presentation.NewProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Interfata pentru inserarea unui produs - utilizatorul introduce datele noului produs si la apasarea butonului
 * acesta este introdus in tabel
 */
public class NewProductController {
    private NewProductView view;
    private ProductBLL productBLL;

    public NewProductController(NewProductView view, ProductBLL productBLL) {
        this.view = view;
        this.productBLL = productBLL;
        this.view.addEnterListener(new EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                Random rand = new Random();
                Integer productNr = rand.nextInt(1000);
                product product = new product();
                product.setNume(view.getNumeField());
                product.setStoc(view.getStocField());
                product.setIdproduct(productNr.toString());
                productBLL.insertProduct(product);
            } catch (Exception exception) {
                view.showMessage("Error :( ");
                System.out.println(exception);
            }
        }
    }
}