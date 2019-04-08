package petsClinic;

import java.util.List;

public class Client implements ClientStorage {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private ClientStorage clientStorage = new ClientJDBC();

    public Client() {
    }
    public Client(String name) {
        clientStorage.setName(name);
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
    public List<Pet> getPets() {
        return clientStorage.getPets();
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
