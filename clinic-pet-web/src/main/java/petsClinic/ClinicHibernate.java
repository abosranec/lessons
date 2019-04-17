package petsClinic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ClinicHibernate implements ClinicStorage {
    private static final SessionFactory factory;
    static {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public ClinicHibernate() {
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    @Override
    public List<Client> getClients() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List<Client> list = null;
        try {
            list = (List<Client>)session.createQuery("from petsClinic.Client ").list();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            tx.commit();
            session.close();
        }
        return list;
    }

    @Override
    public void addClient(Client client) throws Exception {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(client);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void removeClient(String name) throws Exception {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(searchClient(name));
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void editClientName(String oldName, Client newClient) throws Exception {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Client client = session.get(Client.class, searchClient(oldName).getId());
            client.editClient(newClient);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Client searchClient(String name) throws Exception {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from Client C where upper(C.name)=upper(:name)");
            query.setString("name", name);
            return (Client) query.iterate().next();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void close() {
        this.factory.close();
    }
}
