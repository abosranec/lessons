package petsClinic;

import java.util.*;

public class Clinic implements ClinicStorage{

    private ClinicStorage clinicStorage = new ClinicHibernate();

    private static final Clinic INSTANCE = new Clinic();

    private Clinic() {
    }

    public static Clinic getINSTANCE() {
        return INSTANCE;
    }


    @Override
    public List<Client> getClients() {
        return clinicStorage.getClients();
    }

    @Override
    public void addClient(Client client) throws Exception {
        clinicStorage.addClient(client);
    }

    @Override
    public void removeClient(String name) throws Exception {
        clinicStorage.removeClient(name);
    }

    @Override
    public void editClientName(String oldName, Client newClient) throws Exception {
        clinicStorage.editClientName(oldName, newClient);
    }

    @Override
    public Client searchClient(String name) throws Exception {
        return clinicStorage.searchClient(name);
    }

    @Override
    public void close() {
        clinicStorage.close();
    }

    @Override
    public String toString() {
        return clinicStorage.toString();
    }
}
