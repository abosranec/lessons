package petsClinic;

import petsClinic.pets.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Clinic{
    private ArrayList<Client> clients = new ArrayList<Client>();

    public Clinic() {
    }

    public Clinic(Client... clients) {
        addClients(clients);
    }

    public int getNumberOfClients(){
        return clients.size();
    }

    public int getNumberOfPetsAll(){
        int size = 0;
        for (Client client: clients) {
            size+= client.getNumberOfPets();
        }
        return size;
    }

    public void addClients(Client... clients) {
        this.clients.addAll(Arrays.asList(clients));
    }

    public void removeClient(String name){
        this.clients.remove(searchClient(name));
    }

    public void removeClientAll(){
        this.clients.clear();
    }

    public void addPet(String clientName, Pet... pets){
        searchClient(clientName).addPets(pets);
    }

    public void removePet(String clientName, String pet){
        searchClient(clientName).removePet(pet);
    }

    public void editClientName(String oldName, String newName){
        searchClient(oldName).setName(newName);
    }

    public void editClientPetName(String client, String oldName, String newName){
        searchClient(client).editPetName(oldName, newName);
    }

    public List<String> seachClientsName(String pet){
        List<String> list = new LinkedList<String>();
        for (Client client: clients) {
            if(client.isPetName(pet)){
                list.add(client.getName());
            }
        }
        return list;
    }

    public List<String> seachClientPets(String client){
        return searchClient(client).getPets();
    }

    private Client searchClient(String name){
        for (Client client: clients) {
            if(name.equals(client.getName())){
                return client;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String string = "All clients - " + this.getNumberOfClients() + ", all pets - " + this.getNumberOfPetsAll() + ":\n";
        for (Client client: clients){
            string += "\t" + client.getName() + ": ";
            for (String list: client.getPets()){
                string += list + ", ";
            }
            string +="\n";
        }
        return string;
    }

    public static void main(String[] args) {
        Clinic clinic = new Clinic(
                new Client("Jon", new Cat("barsik")),
                new Client("Billy", new Dog("doggy"), new Hamster("ham")),
                new Client("Jack", new Dog("pyshok"))
        );
        System.out.println(clinic);
    }
}
