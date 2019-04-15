package petsClinic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientHibernate implements ClientStorage{
    private int id;
    private String name;
    private String sex;
    private String city;
    private String address;
    private String phone;
    private String mail;
    private List<Pet> pets = new ArrayList<>();
    private final SessionFactory factory = ClinicHibernate.getFactory();
    private Client client;

    public ClientHibernate(Client client) {
        this.client = client;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSex() {
        return sex;
    }
    @Override
    public String getCity() {
        return city;
    }
    @Override
    public String getAddress() {
        return address;
    }
    @Override
    public String getPhone() {
        return phone;
    }
    @Override
    public String getMail() {
        return mail;
    }
    @Override
    public List<Pet> getPets() {
        return this.pets;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }
    @Override
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public void editClient(Client client){
        setName(client.getName());
        setSex(client.getSex());
        setCity(client.getCity());
        setAddress(client.getAddress());
        setPhone(client.getPhone());
        setMail(client.getMail());
    }

    @Override
    public void addPets(Pet newPet) throws Exception {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            newPet.setClient(this.client);
            session.save(newPet);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void removePet(String name) throws Exception {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(searchPets(name));
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void editPetName(String oldName, Pet newPet) throws Exception {

    }

    @Override
    public Pet searchPets(String name) throws Exception {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from Pet P where P.name=:name");
            query.setString("name", name);
            return (Pet) query.iterate().next();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (Client.class != obj.getClass()) {
            return false;
        }
        return (name.equalsIgnoreCase(((Client)obj).getName()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        return 31 * result + Arrays.hashCode(name.toCharArray());
    }
}
