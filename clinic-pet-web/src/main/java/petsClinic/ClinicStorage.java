package petsClinic;

import java.util.List;

public interface ClinicStorage {

    List<Client> getClients();

    void addClient(Client client) throws Exception;

    void removeClient(String name) throws Exception;

    void editClientName(String oldName, Client newClient) throws Exception;

    Client searchClient(String name) throws Exception;
}
