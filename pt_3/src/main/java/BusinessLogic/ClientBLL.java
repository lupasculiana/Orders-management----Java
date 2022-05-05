package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import BusinessLogic.Validators.EmailValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.ClientDAO;
import Model.client;

/**
 * Apeleaza metodele din DataAccess pentru a opri accesul direct la baza de date
 */
public class ClientBLL {

    private List<Validator<client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
       validators = new ArrayList<Validator<client>>();
       validators.add(new EmailValidator());
        clientDAO = new ClientDAO();
    }

    /**
     *
     * @param id
     * @return client
     * apeleaza functia necesara pentru a gasi clientul in functie de id in baza de date
     */
    public client findClientById(int id) {
        client st = clientDAO.findById(id,1);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }

    public client findClientByName(String name) {
        client st = clientDAO.findByName(name);
        if (st == null) {
            throw new NoSuchElementException("The client with name =" + name + " was not found!");
        }
        return st;
    }

    public void updateClient(int id,String val, String field) {
        clientDAO.update(id,field,val,1);
    }

    public void insertClient(client client) { clientDAO.insertClient(client);}

    public void deleteClient(client client) {
        clientDAO.deleteClient(client);
    }
}
