package BusinessLogic.Validators;
import Model.product;

/**
 * Verifica daca stocul unui produs introdus de utilizator este valid
 */
public class ProductStockValidator implements Validator<product> {
    private static final int MIN_AMMOUNT = 1;
    private static final int MAX_AMMOUNT = 100000;

    public void validate(product t) {
        if (Integer.parseInt(t.getStoc())< MIN_AMMOUNT || Integer.parseInt(t.getStoc()) > MAX_AMMOUNT) {
            throw new IllegalArgumentException("The stock amount is not correct ! ");
        }

    }

}
