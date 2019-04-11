package petsClinic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;

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

//        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metaData = new MetadataSources(standardRegistry)
//                .getMetadataBuilder().build();
//        factory = metaData.getSessionFactoryBuilder().build();
//

//        Configuration cfg = new Configuration().addResource("petsClinic/Client.hbm.xml")
//                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
//                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
//                .setProperty("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/petsClinic")
//                .setProperty("hibernate.connection.username", "postgres")
//                .setProperty("hibernate.connection.password", "7663733").configure();
//        SessionFactory factory = cfg.buildSessionFactory();

//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
//                applySettings(configuration.getProperties());
//        SessionFactory factory = configuration.buildSessionFactory(builder.build());

        try {
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }
//        Session session = factory.getCurrentSession();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            list = (List<Client>)session.createQuery("from petsClinic.Client ").list();
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
