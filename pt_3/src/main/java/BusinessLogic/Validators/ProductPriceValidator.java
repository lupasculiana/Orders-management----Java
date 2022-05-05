package BusinessLogic.Validators;
import Model.product;

/**
 * Verifica daca pretul unui produs introdus de utilizatorul aplicatiei este pozitiv
 */
public class ProductPriceValidator implements Validator<product> {

    public void validate(product t) {
        if (Integer.parseInt(t.getPret())< 0) {
            throw new IllegalArgumentException("The price amount is not correct ! ");
        }

    }

}