package BusinessLogic;
import DataAccess.OrderDAO;
import Model.Order;

/**
 * Apeleaza metodele din DataAccess pentru a opri accesul direct la baza de date
 */
public class OrderBLL {
    private OrderDAO orderDAO;

    public OrderBLL() {
        orderDAO = new OrderDAO();
    }

    public void insertOrder(Order order) { orderDAO.insertOrder(order);}

}
