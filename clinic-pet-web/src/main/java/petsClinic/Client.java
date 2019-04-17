package petsClinic;

import java.util.Collection;

public class Client implements ClientStorage {

    private ClientStorage clientStorage = new ClientHibernate(this);

    public Client() {
    }
    public Client(String name) {
        clientStorage.setName(name);
    }

    @Override
    public int getId() {
        return clientStorage.getId();
    }
    @Override
    public String getName() {
        return clientStorage.getName();
    }
    @Override
    public String getSex() {
        return clientStorage.getSex();
    }
    @Override
    public String getCity() {
        return clientStorage.getCity();
    }
    @Override
    public String getAddress() {
        return clientStorage.getAddress();
    }
    @Override
    public String getPhone() {
        return clientStorage.getPhone();
    }
    @Override
    public String getMail() {
        return clientStorage.getMail();
    }
    @Override
    public Collection<Pet> getPets() {
        return clientStorage.getPets();
    }

    @Override
    public void setId(int id) {
        clientStorage.setId(id);
    }
    @Override
    public void setName(String name) {
        clientStorage.setName(name);
    }
    @Override
    public void setSex(String sex) {
        clientStorage.setSex(sex);
    }
    @Override
    public void setCity(String city) {
        clientStorage.setCity(city);
    }
    @Override
    public void setAddress(String address) {
        clientStorage.setAddress(address);
    }
    @Override
    public void setPhone(String phone) {
        clientStorage.setPhone(phone);
    }
    @Override
    public void setMail(String mail) {
        clientStorage.setMail(mail);
    }
    @Override
    public void setPets(Collection<Pet> pets) {
        clientStorage.setPets(pets);
    }

    @Override
    public void editClient(Client client) {
        clientStorage.editClient(client);
    }

    @Override
    public void addPets(Pet newPet) throws Exception {
        clientStorage.addPets(newPet);
    }

    @Override
    public void removePet(String name) throws Exception {
        clientStorage.removePet(name);
    }

    @Override
    public void editPetName(String oldName, Pet newPet) throws Exception {
        clientStorage.editPetName(oldName, newPet);
    }

    @Override
    public Pet searchPets(String name) throws Exception {
        return clientStorage.searchPets(name);
    }

    @Override
    public boolean equals(Object obj) {
        return clientStorage.equals(obj);
    }

    @Override
    public int hashCode() {
        return clientStorage.hashCode();
    }
}
