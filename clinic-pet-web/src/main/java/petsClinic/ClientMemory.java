package petsClinic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ClientMemory implements ClientStorage{
    private int id;
    private String name;
    private String sex;
    private String city;
    private String address;
    private String phone;
    private String mail;
    private Collection<Pet> pets = new ArrayList<>();

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
        return pets;
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
        this.pets.clear();
        this.pets.addAll(client.getPets());
    }

    @Override
    public void addPets(Pet newPet) throws Exception {
        if (pets.contains(newPet)) {
            throw new Exception("Adding failed! Pet \"" + newPet.getName() +
                    "\" for client \"" + getName() + "\" already exist!");
        }
        pets.add(newPet);
    }

    @Override
    public void removePet(String name) throws Exception {
        this.pets.remove(searchPets(name));
    }

    @Override
    public void editPetName(String oldName, Pet newPet) throws Exception {
        if (pets.contains(newPet) && !oldName.equalsIgnoreCase(newPet.getName())) {
            throw new Exception("Renaming failed! Pet \"" + newPet.getName() +
                    "\" for client \"" + getName() + "\" already exist !");
        }
        searchPets(oldName).editPet(newPet);
    }

    @Override
    public Pet searchPets(String name) throws Exception {
        for (Pet pet: pets) {
            if(name.equalsIgnoreCase(pet.getName())){
                return pet;
            }
        }
        throw new Exception("Operation failed, pet name \"" + name + "\" doesn't exist!");
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

//    public int getNumberOfPets(){
//        return pets.size();
//    }
//
//    public boolean isPetName(String name){
//        for (Pet pet: pets) {
//            if(name.equalsIgnoreCase(pet.getName())){
//                return true;
//            }
//        }
//        return false;
//    }
}
