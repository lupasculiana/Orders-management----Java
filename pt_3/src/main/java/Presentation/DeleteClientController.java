package Presentation;
import BusinessLogic.ClientBLL;
import Model.client;
import Presentation.DeleteClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfata pentru stergerea unui client - citeste ID ul dat de utilizator si la apasarea butonului apeleaza metodele
 * necesare pentru a-l sterge din baza de date
 */
public class DeleteClientController {
    private DeleteClientView view;
    private ClientBLL clientBLL;

    public DeleteClientController(DeleteClientView view, ClientBLL clientBLL) {
        this.view = view;
        this.clientBLL = clientBLL;
        this.view.addDeleteListener(new EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                client client = clientBLL.findClientById(Integer.parseInt(view.getDeleteIdField()));
                clientBLL.deleteClient(client);
            } catch (Exception exception) {
                view.showMessage("Error :( ");
                System.out.println(exception);
            }
        }
    }
}