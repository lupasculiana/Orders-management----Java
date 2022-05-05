package Model;

/**
 * Model - Client : clasa de baza a unui client, contine datele acestuia
 */

public class Order {
    private client client;
    private product product;
    private int amount;
    private String idorder;

    public Order(client client,product product, int amount) {
        this.client=client;
        this.product=product;
        this.amount=amount;
    }

    public Model.client getClient() {
        return client;
    }

    public void setClient(Model.client client) {
        this.client = client;
    }

    public Model.product getProduct() {
        return product;
    }

    public void setProduct(Model.product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getIdorder() {
        return idorder;
    }

    public void setIdorder(String idorder) {
        this.idorder = idorder;
    }

    /**
     *
     * @throws Exception
     * In cazul in care cantitatea de produs dorita de client depaseste stocul acestuia, afiseaza un mesaj prin care anunta
     * clientul
     */
    public void checkAmount() throws Exception{
        if(Integer.parseInt(product.getStoc()) < amount)
        {
            throw new Exception();
        }
    }

    /**
     *
     * @return String
     * Folosit la realizarea bonului digital
     */
    @Override
    public String toString() {
        return "Order " + idorder +  " of client " + getClient().getNume() + " " + getClient().getPrenume() + " consists of " +
                 amount + " of product " + getProduct().getNume() + " and has a total cost of " + Integer.parseInt(product.getPret())
                *amount + " lei";
    }
}
