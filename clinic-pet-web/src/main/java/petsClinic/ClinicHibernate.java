package petsClinic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import petsClinic.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClinicHibernate implements ClinicStorage {
    private final SessionFactory factory;
    private final Settings settings = Settings.getInstance();

    public ClinicHibernate() {
        factory = new Configuration().configure().buildSessionFactory();
        try {
            Class.forName(settings.value("jdbc.driver_class"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getClients() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Client ").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void addClient(Client client) throws Exception {

    }

    @Override
    public void removeClient(String name) throws Exception {
    }

    @Override
    public void editClientName(String oldName, Client newClient) throws Exception {
    }

    @Override
    public Client searchClient(String name) throws Exception {
        return null;
    }

    @Override
    public void close() {
    }
}
