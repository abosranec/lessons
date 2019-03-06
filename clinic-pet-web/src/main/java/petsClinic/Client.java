package petsClinic;

import petsClinic.pets.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Client {
    private String name;
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

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public int getNumberOfPets(){
        return pets.size();
    }

    public void editClient(Client client){
        setName(client.getName());
        this.pets = client.getPets();
    }

    public void setName(String name) {
        this.name = name;
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

    public void editPetName(String oldName, String newName) throws Exception {
        if (isPetName(newName)) {
            throw new Exception("Renaming failed! Pet \"" + newName +
                    "\" for client \"" + getName() + "\" already exist !");
        }
        searchPets(oldName).setName(newName);
    }

    public boolean isPetName(String name){
        for (Pet pet: pets) {
            if(name.equals(pet.getName())){
                return true;
            }
        }
        return false;
    }

    private Pet searchPets(String name) throws Exception {
        for (Pet pet: pets) {
            if(name.equals(pet.getName())){
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
        return (name.equals(((Client)obj).getName()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        return 31 * result + Arrays.hashCode(name.toCharArray());
    }
}
