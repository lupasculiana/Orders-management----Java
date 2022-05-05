package Presentation;
import BusinessLogic.ProductBLL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfata pentru editarea unui produs - utilizatorul introduce campul pe care doreste sa-l modifice si datele noi ale
 * produsului dorit, iar la apasarea butonului produsul este modificat
 */
public class EditProductController {
    private EditProductView view;
    private ProductBLL productBLL;

    public EditProductController(EditProductView view, ProductBLL productBLL) {
        this.view = view;
        this.productBLL = productBLL;
        this.view.addUpdateListener(new EditProductController.EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                productBLL.updateProduct(Integer.parseInt(view.getProductField()),view.getValueField(),view.getColumnField());
            } catch (Exception exception) {
                view.showMessage("Error :( ");
                System.out.println(exception);
            }
        }
    }
}
