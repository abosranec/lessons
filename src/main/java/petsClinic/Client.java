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

    public Client(String name, Pet... pets) {
        this.name = name;
        addPets(pets);
    }

    public String getName() {
        return name;
    }

    public List<String> getPets() {
        List<String> list = new LinkedList<String>();
        for (Pet pet: pets) {
            list.add(pet.toString());
        }
        return list;
    }

    public int getNumberOfPets(){
        return pets.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPets(Pet... pets){
        this.pets.addAll(Arrays.asList(pets));
    }

    public void removePet(String name) throws Exception {
        this.pets.remove(searchPets(name));
    }

    public void removePetAll(){
        this.pets.clear();
    }

    public void editPetName(String oldName, String newName) throws Exception {
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
        return (name.equals(((Client)obj).getName()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        return 31 * result + Arrays.hashCode(name.toCharArray());
    }
}
