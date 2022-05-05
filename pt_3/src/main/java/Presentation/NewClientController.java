package Presentation;
import BusinessLogic.ClientBLL;
import Model.client;
import Presentation.NewClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Interfata pentru inserarea unui client - utilizatorul introduce datele noului client si la apasarea butonului
 * acesta este introdus in tabel
 */
public class NewClientController {
    private NewClientView view;
    private ClientBLL clientBLL;

    public NewClientController(NewClientView view, ClientBLL clientBLL) {
        this.view = view;
        this.clientBLL = clientBLL;
        this.view.addEnterListener(new EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                Random rand = new Random();
                Integer clientNr = rand.nextInt(1000);
                client client = new client();
                client.setAdresa(view.getAdresaField());
                client.setEmail(view.getEmailField());
                client.setIdclient(clientNr.toString());
                client.setNume(view.getNumeField());
                client.setPrenume(view.getPrenumeField());
                clientBLL.insertClient(client);
            } catch (Exception exception) {
                view.showMessage("Error :( ");
                System.out.println(exception);
            }
        }
    }
}