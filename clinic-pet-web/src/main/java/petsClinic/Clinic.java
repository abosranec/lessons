package petsClinic;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Clinic implements ClinicStorage{

    private ClinicStorage clinicStorage;

    private static final Clinic INSTANCE = new Clinic();

    private Clinic() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        clinicStorage = (ClinicStorage)applicationContext.getBean("clinicHibernate");
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
