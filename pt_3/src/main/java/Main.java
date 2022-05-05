import Model.Order;
import Presentation.*;
import BusinessLogic.*;

import java.sql.SQLException;

/**
 * Clasa de baza care apeleaza interfata GUI pentru meniul principal
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ViewFinal viewFinal = new ViewFinal();
        ControllerFinal controllerFinal = new ControllerFinal(viewFinal);
    }
}