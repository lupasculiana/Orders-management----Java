package Presentation;

import BusinessLogic.ClientBLL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfata pentru editarea unui client - utilizatorul introduce campul pe care doreste sa-l modifice si datele noi ale
 * clientului dorit, iar la apasarea butonului clientul este modificat
 */
public class EditClientController {
    private EditClientView view;
    private ClientBLL clientBLL;

    public EditClientController(EditClientView view, ClientBLL clientBLL) {
        this.view = view;
        this.clientBLL = clientBLL;
        this.view.addUpdateListener(new EditClientController.EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                clientBLL.updateClient(Integer.parseInt(view.getClientField()),view.getValueField(),view.getColumnField());
            } catch (Exception exception) {
                view.showMessage("Error :( ");
                System.out.println(exception);
            }
        }
    }
}
