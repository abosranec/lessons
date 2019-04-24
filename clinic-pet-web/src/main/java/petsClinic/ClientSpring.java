package petsClinic;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

//@Repository
//@Scope(value = "prototype")
public class ClientSpring implements ClientStorage{
    private int id;
    private String name;
    private String sex;
    private String city;
    private String address;
    private String phone;
    private String mail;
    private Collection<Pet> pets = new LinkedHashSet<>();
    private Client client;
    @Autowired
    private HibernateTemplate template;

    public ClientSpring() {}

    public ClientSpring(Client client) {
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
    public Collection<Pet> getPets() {
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
    public void setPets(Collection<Pet> pets) {
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

    @Transactional
    @Override
    public void addPets(Pet newPet) throws Exception {
//        if (pets.contains(newPet)) {
//            throw new Exception("Adding failed! Pet \"" + newPet.getName() +
//                    "\" for client \"" + getName() + "\" already exist!");
//        } else {
            newPet.setClient(this.client);
            this.template.save(newPet);
//        }
    }

    @Transactional
    @Override
    public void removePet(String name) throws Exception {
        this.template.delete(searchPets(name));
    }

    @Transactional
    @Override
    public void editPetName(String oldName, Pet newPet) throws Exception {
//        Pet searchPet = searchPets(newPet.getName());
//        if (searchPet != null && !oldName.equalsIgnoreCase(newPet.getName())){
//            throw new Exception("Renaming failed! Pet \"" + newPet.getName() +
//                    "\" for client \"" + getName() + "\" already exist !");
//        } else {
            Pet pet = this.template.get(Pet.class, searchPets(oldName).getId());
            pet.editPet(newPet);
//        }
    }

    @Override
    public Pet searchPets(String name) throws Exception {
        try (Session session = this.template.getSessionFactory().openSession()){
            final Query query = session.createQuery(
                    "from Pet as P where upper(P.name)=upper(:petName) and P.client.name=:clientName");
            query.setString("petName", name);
            query.setString("clientName", getName());
            return (Pet) query.iterate().next();
        } catch (Exception e){
            return null;
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
