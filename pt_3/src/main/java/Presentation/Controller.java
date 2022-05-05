package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DataAccess.ClientDAO;
import DataAccess.ProductDAO;
import BusinessLogic.ClientBLL;
import BusinessLogic.ProductBLL;

/**
 * Controller pentru interfata in care utilizatorul va alege ce actiune doreste sa aplice clientilor/produselor - la apasarea
 * unui buton, o noua fereastra specifica actiunii alese se va deschide prin implementarea Action listeners specifice
 */
public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
        this.view.addNewClientListener(new NewClientListener());
        this.view.addEditClientListener(new EditClientListener());
        this.view.addDeleteClientListener(new DeleteClientListener());
        this.view.addViewClientsListener(new ViewClientsListener());
        this.view.addNewProductListener(new NewProductListener());
        this.view.addEditProductListener(new EditProductListener());
        this.view.addDeleteProductListener(new DeleteProductListener());
        this.view.addViewProductsListener(new ViewProductsListener());
    }

    //Client buttons
    class NewClientListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                NewClientView view2 = new NewClientView();
                ClientBLL clientBLL = new ClientBLL();
                NewClientController clientController= new NewClientController(view2,clientBLL);

            } catch (Exception var6) {
                view.showMessage("Bad Input :(");
            }
        }
    }

    class EditClientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                EditClientView view = new EditClientView();
                ClientBLL clientBLL = new ClientBLL();
                EditClientController editClientController = new EditClientController(view,clientBLL);
            } catch (Exception var6) {
                view.showMessage("Bad Input :(");
            }
        }
    }

    class DeleteClientListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                DeleteClientView view = new DeleteClientView();
                ClientBLL clientBLL = new ClientBLL();
                DeleteClientController deleteClientController = new DeleteClientController(view,clientBLL);

            } catch (Exception var6) {
                view.showMessage("Bad Input :(");
            }
        }
    }

    class ViewClientsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                EmptyView view = new EmptyView();
                ClientDAO clientDAO = new ClientDAO(view);
                clientDAO.viewAllClients();

            } catch (Exception var6) {
                view.showMessage("Bad Input :(");
            }
        }
    }

    //Product buttons
    class NewProductListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                NewProductView view2 = new NewProductView();
                ProductBLL productBLL = new ProductBLL();
                NewProductController productController= new NewProductController(view2,productBLL);

            } catch (Exception var6) {
                view.showMessage("Bad Input :(");
            }
        }
    }

    class EditProductListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            EditProductView view = new EditProductView();
            ProductBLL productBLL = new ProductBLL();
            EditProductController editProductController = new EditProductController(view,productBLL);

        }
    }

    class DeleteProductListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                DeleteProductView view = new DeleteProductView();
                ProductBLL productBLL = new ProductBLL();
                DeleteProductController deleteProductController = new DeleteProductController(view,productBLL);

            } catch (Exception var6) {
                view.showMessage("Bad Input :(");
            }
        }
    }

    class ViewProductsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                EmptyView view2 = new EmptyView();
                ProductDAO productDAO = new ProductDAO(view2);
                productDAO.viewAllProducts();

            } catch (Exception var6) {
                view.showMessage("Bad Input :(");
            }
        }
    }

}
