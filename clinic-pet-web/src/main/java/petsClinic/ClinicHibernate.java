package petsClinic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import petsClinic.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClinicHibernate implements ClinicStorage {
//    private ;

    public ClinicHibernate() {
        System.out.println("\nbefore constructor\n");
//        try {
//            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println("\nafter constructor\n");
    }

    @Override
    public List<Client> getClients() {
        List<Client> list = null;
        SessionFactory factory = null;

//        Configuration configuration = new Configuration().configure();
//        ServiceRegistry serviceRegistry
//                = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//
//        // builds a session factory from the service registry
//        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

        try {
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            list = session.createQuery("from Client ").list();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            tx.commit();
            session.close();
        }
        if (list == null){
            System.out.println("Don't have list of clients");
        }
        return list;
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
