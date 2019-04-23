package petsClinic;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClinicSpring implements ClinicStorage {

    @Autowired
    private HibernateTemplate template;

    @Override
    public List<Client> getClients() {
        return (List<Client>) this.template.find("from Client ");
    }

    @Transactional
    @Override
    public void addClient(Client client) throws Exception {
        this.template.save(client);
    }

    @Transactional
    @Override
    public void removeClient(String name) throws Exception {
        this.template.delete(searchClient(name));
    }

    @Transactional
    @Override
    public void editClientName(String oldName, Client newClient) throws Exception {
        Client searchClient = searchClient(newClient.getName());
        if (searchClient != null && !oldName.equalsIgnoreCase(newClient.getName())){
            throw new Exception("Renaming failed! Client \"" + newClient.getName() + "\" already exist !");
        } else {
                Client client = this.template.get(Client.class, searchClient(oldName).getId());
                client.editClient(newClient);
        }
    }

    @Override
    public Client searchClient(String name) throws Exception {
        try (Session session = this.template.getSessionFactory().openSession()) {
            final Query query = session.createQuery("from Client C where upper(C.name)=upper(:name)");
            query.setString("name", name);
            return (Client) query.iterate().next();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() {
        if (this.template.getSessionFactory().isOpen()){
            this.template.getSessionFactory().close();
        }
    }
}
