package petsClinic;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    private String name;
    private String sex;
    private String city;
    private String address;
    private String phone;
    private String mail;
    private ArrayList<Pet> pets = new ArrayList<Pet>();

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, Pet... pets) throws Exception {
        this(name);
        addPets(pets);
    }

    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public String getCity() {
        return city;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getMail() {
        return mail;
    }
    public ArrayList<Pet> getPets() {
        return pets;
    }
    public int getNumberOfPets(){
        return pets.size();
    }

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

    public void setName(String name) {
        this.name = name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void addPets(Pet... newPets) throws Exception {
        ArrayList<Pet> list = new ArrayList<Pet>(this.pets);
        for (Pet pet: newPets){
            if (list.contains(pet)) {
                throw new Exception("Adding failed! Pet \"" + pet.getName() +
                        "\" for client \"" + getName() + "\" already exist!");
            }
            list.add(pet);
        }
        this.pets.addAll(Arrays.asList(newPets));
    }

    public void removePet(String name) throws Exception {
        this.pets.remove(searchPets(name));
    }

    public void removePetAll(){
        this.pets.clear();
    }

    public void editPetName(String oldName, Pet newPet) throws Exception {
        if (isPetName(newPet.getName()) && !oldName.equalsIgnoreCase(newPet.getName())) {
            throw new Exception("Renaming failed! Pet \"" + newPet +
                    "\" for client \"" + getName() + "\" already exist !");
        }
        searchPets(oldName).editPet(newPet);
    }

    public boolean isPetName(String name){
        for (Pet pet: pets) {
            if(name.equalsIgnoreCase(pet.getName())){
                return true;
            }
        }
        return false;
    }

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
        if (getClass() != obj.getClass()) {
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
