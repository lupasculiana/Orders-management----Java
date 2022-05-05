package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import BusinessLogic.Validators.ProductPriceValidator;
import BusinessLogic.Validators.ProductStockValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.ProductDAO;
import Model.product;

/**
 * Apeleaza metodele din DataAccess pentru a opri accesul direct la baza de date
 */
public class ProductBLL {

    private List<Validator<product>> validators;
    private ProductDAO productDAO;

    public ProductBLL() {
        validators = new ArrayList<Validator<product>>();
        validators.add(new ProductStockValidator());
        validators.add(new ProductPriceValidator());
        productDAO = new ProductDAO();
    }

    /**
     *
     * @param id
     * @return product
     * apeleaza functia necesara pentru a gasi produsul in functie de id in baza de date
     */
    public product findProductById(int id) {
        product st = productDAO.findById(id,2);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return st;
    }

    public product findProductByName(String name) {
        product st = productDAO.findByName(name);
        if (st == null) {
            throw new NoSuchElementException("The client with name =" + name + " was not found!");
        }
        return st;
    }

    public void updateProduct(int id,String val, String field) {
        productDAO.update(id,field,val,2);
    }

    public void insertProduct(product product) {
        productDAO.insertProduct(product);
    }
    public void deleteProduct(product product) {
        productDAO.deleteProduct(product);
    }

}
